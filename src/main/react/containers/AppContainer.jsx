import React from "react";
import Nav from "../components/nav";
import { Outlet } from "react-router-dom";
import { useLocation } from 'react-router-dom';

//functional component
const AppContainer = () => {
    const location = useLocation();

    return (
        <>
            <Nav locationUrl={location.pathname} />
            <Outlet />
        </>
    )
}

export default AppContainer