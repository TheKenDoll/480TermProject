// CrewInfoDisplay.js

import React from 'react';
import { useNavigate } from 'react-router-dom';

const CrewInfoDisplay = ({ crewInfo }) => {
    const navigate = useNavigate();

    const handleEdit = (crew) => {
        navigate('/crewedit', { state: { someData: crew } });
    };

    const deleteCrew = (crew) => {
        // Implement logic to delete the crew
        console.log('Crew deleted: ', crew);
    };

  return (
    <>
        <button onClick={() => navigate('/crewedit')}>Add Crew</button>
        <div style={{ maxHeight: '400px', overflowY: 'scroll' }}>
        {crewInfo.map((crew, index) => (
            <div key={index} style={{ border: '1px solid #ccc', padding: '10px', marginBottom: '20px' }}>
            <h3>Crew Information</h3>
            <div>
                <strong>Crew ID:</strong> {crew.crewId}
            </div>
            <div>
                <strong>Availability:</strong> {crew.available ? 'Available' : 'Not Available'}
            </div>
            <div>
                <strong>Flight Number:</strong> {crew.flightNumber}
            </div>
            <div>
                <strong>Crew Members:</strong>
                <ul>
                {crew.crew.map((member, memberIndex) => (
                    <li key={memberIndex}>{`${member.name} - ${member.role}`}</li>
                ))}
                </ul>
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
