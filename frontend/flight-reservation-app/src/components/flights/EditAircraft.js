import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

const EditAircraft = () => {
  //const flightNumberParam = match.params.flightNumber;

    const location = useLocation();
    const navigate = useNavigate();
    const defaultAircraft = {
        aircraftType: '',
        aircraftCapacity: '',
        available: ''
    };


    const recievedData = location.state?.someData || defaultAircraft;

  // Find the flight in your data based on the flightNumberParam
  // For simplicity, assuming you have a flightsData array in the same file
  //const flightToEdit = recievedData.find((flight) => flight.flightNumber === flightNumberParam);

  // State to manage form inputs
  const [editedAircraft, setEditedAircraft] = useState({ ...recievedData });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setEditedAircraft((prevAircraft) => ({
      ...prevAircraft,
      [name]: value,
    }));
  };

  const handleSave = () => {
    // Implement logic to save the edited flight data
    console.log('Aircraft saved:', editedAircraft);
    navigate('/admin');
  };

  return (
    <div>
      <form>
        <label>
          Aircraft Type:
          <input type="text" name="aircraftType" value={editedAircraft.aircraftType} onChange={handleInputChange} />
        </label>
        <br />
        <label>
          Aircraft Capacity:
          <input type="text" name="aircraftCapacity" value={editedAircraft.aircraftCapacity} onChange={handleInputChange} />
        </label>
        <br />
        <label>
          Aircraft Availability:
          <input type="text" name="available" value={editedAircraft.available} onChange={handleInputChange} />
        </label>
        <br />
        <button type="button" onClick={handleSave}>Save</button>
      </form>
    </div>
  );
};

export default EditAircraft;
