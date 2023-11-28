// FlightList.js
import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import FlightShow from './FlightShow';

const FlightList = () => {
  const location = useLocation();
  const [flights, setFlights] = useState([]);
  const criteria = location.state && location.state.criteria;

  // useEffect(()=>{
  //   const fetchFlights = async () => {
  //     const res = await fetch(`http://localhost:8080/api/v1/flight`);


  //     setFlights(await res.json());
  //   };
  //   fetchFlights();
  // },[]);

const fetchFlights = async ()=> {
  await fetch("http://localhost:8080/api/v1/flight", {

  })
  .then((response ) => response.json())
  .then((data) => setFlights(data))
  .catch((error) => console.log(error))
};

useEffect(()=> {
  fetchFlights();
}, []);


  return (
    <div>

      <h2>Flight List</h2>

      {flights.length > 0 ? (
        <div>

          {flights.map((flight) => (
            <FlightShow key={flight.id}  flight = {flight}/>
          ))}


        </div>

      ):(<p>No flights availalble</p>)
      
      
      }


     
    </div>
  );
};

export default FlightList;