// SelectSeats.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const SelectSeats = () => {
  const navigate = useNavigate();
  const [selectedSeat, setSelectedSeat] = useState('');

  const handleSeatSelection = (seat) => {
    // Handle seat selection logic
    setSelectedSeat(seat);
  };

  const handleProceedToInsurance = () => {
    // Add logic to proceed to insurance selection page
    navigate('/select-insurance');
  };

  return (
    <div>
      <h2>Select Seats</h2>
      <p>Selected Seat: {selectedSeat}</p>

      {/* Fake seat selection buttons */}
      <button onClick={() => handleSeatSelection('A1')}>Select Seat A1</button>
      <button onClick={() => handleSeatSelection('B2')}>Select Seat B2</button>

      {/* Button to proceed to insurance selection */}
      {selectedSeat && (
        <button onClick={handleProceedToInsurance}>Proceed to Insurance</button>
      )}
    </div>
  );
};

export default SelectSeats;
