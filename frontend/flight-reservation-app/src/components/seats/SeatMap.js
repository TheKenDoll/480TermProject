// SeatMap.js
import React, { useState } from 'react';

const SeatMap = ({ seats, onSeatSelected }) => {
  const [selectedSeat, setSelectedSeat] = useState(null);

  const handleSeatClick = (seat) => {
    console.log('Seat clicked:', seat);
    if (seat.available) {
      setSelectedSeat(seat);
      // Wait for confirmation before calling onSeatSelected
    }
  };

  const handleConfirmSeat = () => {
    console.log('Confirm Seat:', selectedSeat);
    if (selectedSeat) {
      onSeatSelected(selectedSeat);
      // You can add logic here to proceed to the insurance page or update the database.
    }
  };

  const handleCancelSeat = () => {
    console.log('Cancel Seat');
    setSelectedSeat(null);
  };

  const renderSeats = () => {
    const seatsArray = seats && seats.aircraft ? seats.aircraft.seats : [];

    return seatsArray.map((seat) => (
      <button
        key={seat.seatNumber}
        className={`seat-button ${seat.available ? 'available' : 'unavailable'} ${
          selectedSeat && selectedSeat.seatNumber === seat.seatNumber ? 'selected' : ''
        }`}
        onClick={() => handleSeatClick(seat)}
        disabled={!seat.available}
        title={!seat.available ? 'Seat taken' : ''}
      >
        {seat.seatNumber}
      </button>
    ));
  };

  return (
    <div className="seat-map">
      <h3>Seat Map</h3>
      <div className="seat-grid">{renderSeats()}</div>
      {selectedSeat && selectedSeat.available && (
        <div>
          <p>Selected Seat: {selectedSeat.seatNumber}</p>
          <button onClick={handleConfirmSeat}>Confirm Seat</button>
          <button onClick={handleCancelSeat}>Cancel</button>
        </div>
      )}
      {selectedSeat && !selectedSeat.available && <p>Seat Taken</p>}
    </div>
  );
};

export default SeatMap;

