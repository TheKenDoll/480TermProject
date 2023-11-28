// FlightList.js
import React from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

const FlightList = () => {
  const location = useLocation();
  const navigate = useNavigate();

  // Accessing the criteria from the state
  const criteria = location.state && location.state.criteria;

  const handleSelectFlight = () => {
    // Assume you have a fake flight ID here
    const fakeFlightId = '123';

    // Navigate to the FlightDetails page with the selected flight ID
    navigate(`/flight-details/${fakeFlightId}`);
  };

  return (
    <div>
      {/* Display the flights based on the criteria */}
      <h2>Flight List</h2>
      <p>Displaying flights based on criteria: {JSON.stringify(criteria)}</p>

      {/* Fake button to simulate selecting a flight */}
      <button onClick={handleSelectFlight}>Select a Fake Flight</button>
    </div>
  );
};

export default FlightList;

