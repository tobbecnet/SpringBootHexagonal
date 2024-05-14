'use strict';

import React from 'react';
import ReactDOM from 'react-dom';
import { Routes, Route, BrowserRouter } from 'react-router-dom';
import { createRoot } from 'react-dom/client';
import { useEffect, useState } from 'react';
import { Header, Footer } from './frame';
import { EditList } from './editlist';
import { EditMeal } from './editmeal';


// https://blog.logrocket.com/modern-api-data-fetching-methods-react/
// mvn frontend:webpack resources:resources

export function App(props) {

    const [loaded, setLoaded] = useState(false);
    const [loading, setLoading] = useState(false);
    const [meals, setMeals] = useState({"content": []});
    const [error, setError] = useState("none");


    return (
        <>
            <Header />

            <BrowserRouter>
                <Routes>
                    <Route path="/admin" element={ <EditList /> } />
                    <Route path="/admin/edit" element={ <EditMeal /> } />
                </Routes>
            </BrowserRouter>

            <Footer />
        </>
    );
}

const root = createRoot(document.getElementById('react'))
root.render(<App />)

// Usable only with react <= 17
//ReactDOM.render(
//	<App />,
//	document.getElementById('react')
//)