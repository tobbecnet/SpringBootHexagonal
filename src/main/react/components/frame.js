'use strict';

import React, { useState, useEffect } from 'react';

export function Header(props) {

    return (
        <>
            <nav className="navbar fixed-top bg-light">
                <div className="container-fluid">
                    <a className="navbar-brand" href="/admin">Cookbook Admin</a>
                </div>
            </nav>

            {/* prevent overlap with position: fixed navbar */}
            <div className="container">
                <div className="row mt-5">&nbsp;</div>
            </div>
        </>
    );
}

export function Footer(props) {

    return (
        <>
            {/* prevent overlap with position: fixed footer */}
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
    );
}