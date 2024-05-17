'use strict';

import React, { useState, useEffect } from 'react';
import { EditList } from './components/editlist';


export function PageList(props) {

    return (
        <div className="container">
            <div className="row">
                <h2>Meals list</h2>
            </div>

            <div className="row m-1">
                <EditList />
            </div>
        </div>
    );
}