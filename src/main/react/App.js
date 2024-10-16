import React from 'react';
import ReactDom from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import AppContainer from './containers/AppContainer';
import XkcdPastComicContainer from './containers/XkcdPastComicContainer';
import XkcdCurrentComicContainer from './containers/XkcdCurrentComicContainer';

const router = createBrowserRouter([
    {
        path: "/",
        element: <AppContainer />,
        children: [
            {
                index: true,
                element: <div>Home page with gradle compile</div>
            },
            {
                path: "currentComic",
                element: <XkcdCurrentComicContainer />
            },
            {
                path:"pastComic",
                element: <XkcdPastComicContainer />
            }
        ]
    }
])
// /pastComic
ReactDom.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <RouterProvider router={router} />
    </React.StrictMode>
)
