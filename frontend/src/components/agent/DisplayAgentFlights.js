// JSONDisplay.js

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const DisplayAgentFlights = ({ data }) => {
    const [editMode, setEditMode] = useState(null);
    const navigate = useNavigate();

    const handleViewPassengers = (flight) => {
        // Logic to handle viewing passengers for the selected flight
        navigate(`/passengers`, { state: { someData: flight } });
        //console.log(`View passengers for Flight ${flightNumber}`);
    };

    const handleBookFlight = (flight) => {
        // Logic to handle booking the selected flight
        navigate(`/flight-details/${flight.id}`);
        // console.log(`Book Flight ${flightNumber}`);
    };

    return (
        <div className='flight-container'>
            {data.map((flight, index) => (
                <div key={index} className='flight-info'>
                    <h2>{`Flight ${flight.number}`}</h2>
                    <div>
                        <strong>Origin:</strong> {flight.origin}
                    </div>
                    <div>
                        <strong>Destination:</strong> {flight.destination}
                    </div>
                    <button onClick={() => handleViewPassengers(flight.number)}>View Passengers</button>
                    <button onClick={() => handleBookFlight(flight)}>Book Flight</button>
                </div>
            ))}
        </div>
    );
};

export default DisplayAgentFlights;
