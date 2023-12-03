// JSONDisplay.js

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './FlightDisplay.css';
import SeatSelection from '../seats/SeatSelection';

const FlightDisplayUser = ({ data }) => {
  const [editMode, setEditMode] = useState(null);
  const navigate = useNavigate();
  const [showCrew, setShowCrew] = useState(false);
  const [showSeat, setShowSeat] = useState(false)

  const handleEdit = (flight) => {
    //setEditMode(index);
    navigate('/select-seats/:flightId', { state: { someData: flight.id } });
  };

  const handleViewCrew = (flight) => {
    setShowCrew(!showCrew);
  };

  const handleDelete = (flight) => {
    // Implement logic to delete the flight
    console.log('Flight deleted: ', flight);
    fetch(`http://localhost:8080/api/v1/flight/${flight.id}`, {
      method: 'DELETE',
    });
  }

  return (
    <div className='flight-container'>
      <button className='button' onClick={() => navigate('/add')}>Add Flight</button>
      {data.map((flight, index) => (
        <div key={index} className='flight-info'>
          <h2>{`Flight ${flight.number}`}</h2>
          <div>
            <strong>Origin:</strong> {flight.origin}
          </div>
          <div>
            <strong>Destination:</strong> {flight.destination}
          </div>
          <div>
            <strong>Aircraft Type:</strong> {flight.aircraftType}
          </div>
          <div>
            <strong>Departure Time:</strong> {new Date(flight.departureTime).toLocaleString()}
          </div>
          <div>
            <strong>Arrival Time:</strong> {new Date(flight.arrivalTime).toLocaleString()}
          </div>
          {showCrew && (
            <div>
              <h3>Crew Members</h3>
              <div className='crew-members'>
                <div className='crew-member'>{`Pilot: ${flight.crew.pilot.firstName} ${flight.crew.pilot.lastName}`}</div>
                <div className='crew-member'>{`Copilot: ${flight.crew.copilot.firstName} ${flight.crew.copilot.lastName}`}</div>
                {flight.crew.flightAttendants.map((attendant, index) => (
                  <div key={index} className='crew-member'>{`Flight Attendent ${index}: ${attendant.firstName} ${attendant.lastName}`}</div>
                ))}
              </div>
            </div>
          )}
          <button className='button' onClick={() => handleEdit(flight)}>View Seats</button>
          {showSeat && <SeatSelection />}
        </div>
      ))}
    </div>
  );
};

export default FlightDisplayUser;
