import { create } from "zustand";
import axios from "axios";

export const useStore = create((set, get) => ({
    currentComic: {},
    currentComicStatus: "",
    pastComic: {},
    pastComicStatus: "",
    fetchCurrentComic: async() =>{
        set({currentComicStatus: 'PENDING'})
        try{
            const res = await axios.get('/current')
            set({currentComic: res.data, currentComicStatus: 'SUCCESS'})
        }catch(err){
            set({currentComicStatus: 'FAILURE'})
            console.log(err)
        }
    },
    fetchPastComic: async(comicNum) =>{
        set({pastComicStatus: 'PENDING'})
        axios.get(`/past/${!comicNum ? Math.floor(Math.random() * 2900) : comicNum}`)
        .then((res) => {
            set({pastComic: res.data, pastComicStatus: 'SUCCESS'})
        })
        .catch(() =>{
            set({pastComicStatus: 'FAILURE'})
        })
    },
}))
