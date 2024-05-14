'use strict';

import React from 'react';
import ReactDOM from 'react-dom';
import { createRoot } from 'react-dom/client';
import { useEffect, useState } from 'react';

// https://blog.logrocket.com/modern-api-data-fetching-methods-react/
// mvn frontend:webpack resources:resources

export function App(props) {

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
                <p>Meals: { JSON.stringify(meals) }</p>
            </div>
        </div>
    );
}

const root = createRoot(document.getElementById('react'))
root.render(<App />)

// Usable only with react <= 17
//ReactDOM.render(
//	<App />,
//	document.getElementById('react')
//)