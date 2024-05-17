'use strict';

import React, { useState, useEffect } from 'react';
import { EditMeal } from './components/editmeal';

export function PageEdit(props) {

    return (
        <div className="container">
            <div className="row">
                <h2>Edit meal</h2>
            </div>

            <div className="row m-1">
                <EditMeal />
            </div>
        </div>
    )
}