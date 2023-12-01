// CrewInfoDisplay.js

import React from 'react';
import { useNavigate } from 'react-router-dom';
import './CrewInfoDisplay.css';

const CrewInfoDisplay = ({ crewInfo }) => {
    const navigate = useNavigate();

    const handleEdit = (crew) => {
        navigate('/crewedit', { state: { someData: crew } });
    };

    const deleteCrew = (crew) => {
        // Implement logic to delete the crew
        console.log('Crew deleted: ', crew);
        fetch(`http://localhost:8080/api/v1/crew/${crew.crewId}`, {})
    };

    console.log(crewInfo)

  return (
    <>
        <button className="button" onClick={() => navigate('/crewedit')}>Add Crew</button>
        <div style={{ maxHeight: '400px', overflowY: 'scroll' }}>
        {crewInfo && crewInfo.map((crew, index) => (
            <div key={index} style={{ border: '1px solid #ccc', padding: '10px', marginBottom: '20px' }}>
            <h3>Crew Information</h3>
            <div>
                <strong>Crew ID:</strong> {crew.id}
            </div>
            <div>
                <strong>Pilot Name:</strong> {crew.pilot.firstName} {crew.pilot.lastName}
            </div>
            <div>
                <strong>Copilot Name:</strong> {crew.copilot.firstName} {crew.copilot.lastName}
            </div>
            
            <button onClick={() => handleEdit(crew)}>Edit</button>
            <button onClick={() => deleteCrew(crew)}>Delete</button>
            </div>
        ))}
        </div>
    </>
  );
};

export default CrewInfoDisplay;
