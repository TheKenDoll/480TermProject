// JSONDisplay.js

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './FlightDisplay.css';

const FlightDisplay = ({ data }) => {
  const [editMode, setEditMode] = useState(null);
  const navigate = useNavigate();
  const [showCrew, setShowCrew] = useState(false);

  const handleEdit = (flight) => {
    //setEditMode(index);
    navigate('/edit', { state: { someData: flight } });
  };

  const handleViewCrew = (flight) => {
    setShowCrew(!showCrew);
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
                {flight.crew.map((member, index) => (
                  <div key={index} className='crew-member'>{`${member.name} - ${member.role}`}</div>
                ))}
              </div>
            </div>
          )}
          <button className='button' onClick={() => handleEdit(flight)}>Edit</button>
          <button className='button' onClick={() => handleViewCrew(flight)}>{showCrew ? 'Hide Crew' : 'Show Crew'}</button>
        </div>
      ))}
    </div>
  );
};

export default FlightDisplay;
