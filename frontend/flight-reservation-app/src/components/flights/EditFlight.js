import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

const EditFlight = () => {
  //const flightNumberParam = match.params.flightNumber;

    const location = useLocation();
    const navigate = useNavigate();

    const recievedData = location.state?.someData || "No data";

  // Find the flight in your data based on the flightNumberParam
  // For simplicity, assuming you have a flightsData array in the same file
  //const flightToEdit = recievedData.find((flight) => flight.flightNumber === flightNumberParam);

  // State to manage form inputs
  const [editedFlight, setEditedFlight] = useState({ ...recievedData });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setEditedFlight((prevFlight) => ({
      ...prevFlight,
      [name]: value,
    }));
  };

  const handleSave = () => {
    // Implement logic to save the edited flight data
    console.log('Flight saved:', editedFlight);
    navigate('/admin');
  };

  return (
    <div>
      <h2>Edit Flight {editedFlight.flightNumber}</h2>
      <form>
        <label>
          Flight Number:
          <input type="text" name="flightNumber" value={editedFlight.flightNumber} onChange={handleInputChange} />
        </label>
        <br />
        <label>
          Destination:
          <input type="text" name="destination" value={editedFlight.destination} onChange={handleInputChange} />
        </label>
        <br />
        <label>
          Origin:
          <input type="text" name="origin" value={editedFlight.origin} onChange={handleInputChange} />
        </label>
        <br />
        <label>
          Aircraft Type:
          <input type="text" name="aircraft" value={editedFlight.aircraftType} onChange={handleInputChange} />
        </label>
        <br />
        <label>
          Departure Time:
          <input type="text" name="departureTime" value={editedFlight.departureTime} onChange={handleInputChange} />
        </label>
        <br />
        <label>
          Arrival Time:
          <input type="text" name="arrivalTime" value={editedFlight.arrivalTime} onChange={handleInputChange} />
        </label>
        {/* Add more input fields for other flight properties */}
        <br />
        <button type="button" onClick={handleSave}>
          Save
        </button>
      </form>
    </div>
  );
};

export default EditFlight;
