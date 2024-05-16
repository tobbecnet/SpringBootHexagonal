'use strict';

import React from 'react';
import ReactDOM from 'react-dom';
import { StrictMode } from 'react';
import { Routes, Route, BrowserRouter } from 'react-router-dom';
import { createRoot } from 'react-dom/client';
import { useEffect, useState } from 'react';
import { Header, Footer } from './components/frame';
import { PageList } from './page-list';
import { PageEdit } from './page-edit';

import '../resources/static/css/bootstrap.css';

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
                    <Route path="/admin" element={ <PageList /> } />
                    <Route path="/admin/edit" element={ <PageEdit /> } />
                </Routes>
            </BrowserRouter>

            <Footer />
        </>
    );
}

const root = createRoot(document.getElementById('react'))
root.render(
    <StrictMode>
        <App />
    </StrictMode>
);

// Usable only with react <= 17
//ReactDOM.render(
//	<App />,
//	document.getElementById('react')
//)