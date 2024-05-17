'use strict';

import React, { useState, useEffect } from 'react';
import { useNavigate } from "react-router-dom";


export function EditList(props) {

    const navigate = useNavigate();

    const [loaded, setLoaded] = useState(false);
    const [loading, setLoading] = useState(false);
    const [meals, setMeals] = useState({"content": []});
    const [error, setError] = useState("none");

    const handleCreateNew = async () => {
        navigate("/admin/edit");
    }

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

            <button type="button" className="btn btn-primary m-3" onClick={handleCreateNew}>Create new</button>
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