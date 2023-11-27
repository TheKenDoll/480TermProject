import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

const EditCrew = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const defaultCrew = {
    crewId: '',
    available: '',
    flightNumber: '',
    crew: [
        {
            "name": "",
            "role": ""
        },
        {
            "name": "",
            "role": ""
        }
    ]
    };
  const receivedData = location.state?.someData || defaultCrew;

  // State to manage form inputs
  const [editedCrew, setEditedCrew] = useState({ ...receivedData });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setEditedCrew((prevCrew) => ({
      ...prevCrew,
      [name]: value,
    }));
  };

  const handleSave = () => {
    // Implement logic to save the edited crew data
    console.log('Crew saved:', editedCrew);
    navigate('/admin');
  };

  const handleCrewInputChange = (e, index) => {
    const { name, value } = e.target;
    const updatedCrew = [...editedCrew.crew];
    updatedCrew[index] = { ...updatedCrew[index], [name]: value };
    setEditedCrew((prevCrew) => ({
      ...prevCrew,
      crew: updatedCrew,
    }));
  };

  return (
    <div>
      <h2>Edit Crew {editedCrew.crewId}</h2>
      <form>
        <label>
          Crew Number:
          <input type="text" name="crewId" value={editedCrew.crewId} onChange={handleInputChange}/>
        </label>
        <label>
          Availability:
          <input type="text" name="available" value={editedCrew.available} onChange={handleInputChange}/>
        </label>
        <label>
          Flight Number:
          <input type="text" name="flightNumber" value={editedCrew.flightNumber} onChange={handleInputChange}/>
        </label>
        <label>
          Crew Members:
          {editedCrew.crew.map((member, index) => (
            <div key={index}>
                Crew Member {index + 1}
                <input type="text" name="name" value={member.name} onChange={(e) => handleCrewInputChange(e, index)}/>
                <input type="text" name="role" value={member.role} onChange={(e) => handleCrewInputChange(e, index)}/>
            </div>
          ))}
        </label>
        <button type="button" onClick={handleSave}>Save</button>
      </form>
    </div>
  );
};

export default EditCrew;