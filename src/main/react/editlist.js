'use strict';

import React from 'react';
import ReactDOM from 'react-dom';
import { createRoot } from 'react-dom/client';
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
        <div>
            <div>
                <p>React 18 working ...</p>
            </div>
            <div>
                <p>Loading: { loading.toString() }</p>
            </div>
            <div>
                <p>Loaded: { loaded.toString() }</p>
            </div>
            <div>
                <p>Error: { error }</p>
            </div>
            <div>
                <NavLink to="/admin/edit">Edit</NavLink>
            </div>
            <div>
                <p>Meals: { JSON.stringify(meals) }</p>
            </div>
        </div>
    )
}