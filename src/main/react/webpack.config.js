const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const FileManagerPlugin = require('filemanager-webpack-plugin');

module.exports = {
    entry: './App.js',
    devtool: 'eval-source-map',
    cache: true,
    mode: 'development',
    output: {
        path: __dirname,
        filename: '../resources/static/built/bundle.js'
    },
    target: 'web',
    devServer: {
        port: '9000',
        static: {
            directory: path.join(__dirname, '')
        },
        proxy: [
            {
              context: ['/current'],
              target: 'http://localhost:8080',
            },
          ],
        open: true,
        hot: true,
        liveReload: true,
    },
    resolve: {
        extensions: ['.js', '.jsx', '.json'],
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: 'babel-loader',
            },
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
                test: /\.css$/,
                use: [
                    'style-loader',
                    'css-loader'
                ]
            },
            {
                test: /\.(png|svg|jpg|gif|eot|otf|ttf|woff|woff2)$/,
                use: [
                    {
                        loader: 'url-loader',
                        options: {}
                    }
                ]
            }
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: path.join(__dirname, '../resources/templates/', 'index.html'),
        }),
        new FileManagerPlugin({
            events: {
                onEnd: {
                    copy: [{
                        destination: path.join(__dirname, '/built', 'bundle.js'),
                        source: path.join(__dirname, '../resources/static/built/bundle.js'),
                    },
                    ],
                },
            }

        }),
    ],
};