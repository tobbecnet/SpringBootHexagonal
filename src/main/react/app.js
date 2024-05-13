'use strict';

const React = require('react');
const ReactDOM = require('react-dom');


class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = { meals: [] };
    }

    componentDidMount() {

    }

    render() {
        return (
            <div>
                <p>React working...</p>
            </div>
        );
    }
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)