// Book.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Book = () => {
  const navigate = useNavigate();
  const [origin, setOrigin] = useState('');
  const [destination, setDestination] = useState('');
  const [date, setDate] = useState('');

  const handleBookFlight = () => {
    navigate('/flights', { state: { origin, destination, date } });
  };

  return (
    <div>
      <h2>Book a Flight</h2>
      <form>
        <label>
          Origin:
          <input type="text" value={origin} onChange={(e) => setOrigin(e.target.value)} />
        </label>
        <br />

        <label>
          Destination:
          <input type="text" value={destination} onChange={(e) => setDestination(e.target.value)} />
        </label>
        <br />

        <label>
          Date:
          <input type="date" value={date} onChange={(e) => setDate(e.target.value)} />
        </label>
        <br />

        <button type="button" onClick={handleBookFlight}>
          Book Flight
        </button>
      </form>
    </div>
  );
};

export default Book;
