// JSONDisplay.js

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

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
    <div style={{ overflowY: 'scroll', maxHeight: '400px', border: '1px solid #ccc', padding: '10px' }}>
      {data.map((flight, index) => (
        <div key={index} style={{ border: '1px solid #ddd', marginBottom: '20px', padding: '20px' }}>
          <h2>{`Flight ${flight.flightNumber}`}</h2>
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
              <ul>
                {flight.crew.map((member, index) => (
                  <li key={index}>{`${member.name} - ${member.role}`}</li>
                ))}
              </ul>
            </div>
          )}
          <button onClick={() => handleEdit(flight)}>Edit</button>
          <button onClick={() => handleViewCrew(flight)}>{showCrew ? 'Hide Crew' : 'Show Crew'}</button>
        </div>
      ))}
    </div>
  );
};

export default FlightDisplay;
