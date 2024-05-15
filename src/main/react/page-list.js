'use strict';

import React from 'react';
import ReactDOM from 'react-dom';
import { useEffect, useState } from 'react';
import { NavLink, Outlet } from "react-router-dom";
import { EditList } from "./components/editlist";


export function PageList(props) {

    return (
        <div className="container">
            <div className="row">
                <h2>Edit meals</h2>
            </div>

            <div className="row m-1">
                <EditList />
            </div>
        </div>

    );
}