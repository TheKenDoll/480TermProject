// CrewInfoDisplay.js

import React from 'react';
import { useNavigate } from 'react-router-dom';

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
        <button onClick={() => navigate('/aircraftedit')}>Add Aircraft</button>
        <div style={{ maxHeight: '400px', overflowY: 'scroll' }}>
        {aircraftInfo.map((aircraft, index) => (
            <div key={index} style={{ border: '1px solid #ccc', padding: '10px', marginBottom: '20px' }}>
            <h3>Aircraft Information</h3>
            <div>
                <strong>Aircraft Type:</strong> {aircraft.aircraftType}
            </div>
            <div>
                <strong>Aircraft Capacity:</strong> {aircraft.aircraftCapacity}
            </div>
            <div>
                <strong>Aircraft Availability:</strong> {aircraft.available ? 'Available' : 'Not Available'}
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
