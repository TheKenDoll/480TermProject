
// FlightShow.js
import React from 'react';

const FlightShow = ({flight, onSelect}) => {
  return (
    <div>

        <p>{flight.number}</p>
        <p>{flight.destination}</p>
        <p>{flight.origin}</p>
        <p>{flight.departureTime}</p>
        <button onClick={onSelect}>Select Flight</button>



    </div>
  )
}

export default FlightShow