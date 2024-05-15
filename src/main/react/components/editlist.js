'use strict';

import React from 'react';
import ReactDOM from 'react-dom';
import { useEffect, useState } from 'react';
import { NavLink, Outlet } from "react-router-dom";

export function EditList(props) {

    const [loaded, setLoaded] = useState(false);
    const [loading, setLoading] = useState(false);
    const [meals, setMeals] = useState({"content": []});
    const [error, setError] = useState("none");

    useEffect(() => {
        const fetchData = async() => {
            try {
                setLoaded(false);
                setLoading(true);

                const response = await fetch('/api/meal')

                if(!response.ok) {
                    throw new Error("Http Error, status ${response.status}.")
                }

                let mealsData = await response.json();

                setMeals(mealsData);
                setLoaded(true);

            } catch(err) {
                setError(err.message)
                setLoaded(false)
            } finally {
                setLoading(false)
            }
        };

        fetchData();
    }, []);

    return (
        <>
            { loading
                ? (<div>LOADING...</div>)
                : (<MenuList meals={meals} />) }
        </>
    );
}

function MenuList(props) {

    return (
        <table className="table table-striped-rows">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Title</th>
                </tr>
            </thead>

            <tbody>
            {
                props.meals.content.map((menu, i) =>
                    <MenuElement key={menu.id} menu={menu} />
                )
            }
            </tbody>
        </table>
    )
}

function MenuElement(props) {

    return (
        <>
            <tr>
                <td>{props.menu.id}</td>
                <td>{props.menu.title}</td>
            </tr>
        </>
    )
}