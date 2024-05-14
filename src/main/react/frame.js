'use strict';

import React from 'react';
import ReactDOM from 'react-dom';
import { createRoot } from 'react-dom/client';
import { useEffect, useState } from 'react';

export function Header(props) {

    return (
        <nav className="navbar fixed-top bg-light">
            <div className="container-fluid">
                <a className="navbar-brand" href="/admin">Cookbook Admin</a>
            </div>
        </nav>
    )
}

export function Footer(props) {

    return (
        <>
            <div className="container">
                <div className="row mb-5">&nbsp;</div>
            </div>

            <footer>
                <div className="navbar fixed-bottom bg-light">
                    <div className="container-fluid">
                        <p className="navbar-brand">Cookbook</p>
                        <p>Keep cooking</p>
                    </div>
                </div>
            </footer>
        </>
    )
}