
import React, { useEffect, useState } from "react";
import ComicView from "../components/ComicView";
import { useStore } from "../createStore";

//functional component
const XkcdCurrentComicContainer = () => {
    const xkcdComic = useStore()

    useEffect(() => {
       xkcdComic.fetchCurrentComic()
    }, [])

    return xkcdComic.currentComicStatus === "SUCCESS" ? 
        <ComicView 
            xkcdComicInfo={xkcdComic.currentComic}
        /> 
        : xkcdComic.currentComicStatus === "FAILURE" ? 
            onFailure()
            : <div className="spinner-border" role="status">
                <span className="visually-hidden">Loading...</span>
            </div>

    function onFailure() {
        return(
            <div>
                Oops something went wrong, please try again later...
            </div>
        )
    }

}

export default XkcdCurrentComicContainer;

// array as second variable in useEffect controls whether it is a componentDidMount or componentDidUpdate lifecycle method
// [] => componentDidMount
// [state || props] => componentDidUpdate