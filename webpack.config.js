var path = require('path');

module.exports = {
    entry: './src/main/react/app.js',
    devtool: 'source-map',
    cache: true,
    mode: 'development',
    devServer: {
        port: 8081,
        proxy: [
            {
                context: ['/api'],
                target: 'http://localhost:8080'
            },
        ],
        historyApiFallback: true
    },
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },
    module: {
        rules: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ["@babel/preset-env", "@babel/preset-react"]
                    }
                }]
            },
            {
                test: /\.(css)$/,
                use: ['style-loader', 'css-loader'],
            },
        ]
    }
};