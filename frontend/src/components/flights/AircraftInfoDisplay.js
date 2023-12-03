// CrewInfoDisplay.js

import React from 'react';
import { useNavigate } from 'react-router-dom';
import './AircraftInfoDisplay.css';

const AircraftInfoDisplay = ({ aircraftInfo }) => {
    const navigate = useNavigate();

    const handleEdit = (aircraft) => {
        navigate('/aircraftedit', { state: { someData: aircraft } });
    };

    const deleteAircraft = (aircraft) => {
        // Implement logic to delete the aircraft
        console.log('Aircraft deleted: ', aircraft);
    };

  return (
    <>
        <div style={{ maxHeight: '400px', overflowY: 'scroll' }}>
        {aircraftInfo.map((aircraft, index) => (
            <div key={index} style={{ border: '1px solid #ccc', padding: '10px', marginBottom: '20px' }}>
            <h3>Aircraft Information</h3>
            <div>
                <strong>Aircraft Type:</strong> {aircraft.model}
            </div>
            <div>
                <strong>Aircraft Capacity:</strong> {aircraft.capacity}
            </div>
            <div>
                <strong>Aircraft Manufacture Year:</strong> {aircraft.manufactureYear}
            </div>
            <button onClick={() => handleEdit(aircraft)}>Edit</button>
            <button onClick={() => deleteAircraft(aircraft)}>Delete</button>
            </div>
        ))}
        </div>
    </>
  );
};

export default AircraftInfoDisplay;
