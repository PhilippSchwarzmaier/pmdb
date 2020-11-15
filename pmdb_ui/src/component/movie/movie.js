import React from 'react';
import axios from 'axios';

export default function Movie() {

    const [movie, setMovie] = React.useState({});
    const [movieId] = React.useState(0);

    React.useEffect(() => {
        axios.get('http://localhost:9080/movies/one')
        .then(res=>{
            console.log(res.data);
            setMovie(res.data);
        })
    }, [movieId]);


    return (
        <div>
            {movie.year}
        </div>
    )
}
