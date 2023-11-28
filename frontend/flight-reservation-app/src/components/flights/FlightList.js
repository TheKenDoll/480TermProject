// FlightList.js
import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import { getAllFlights, getFlightsByCriteria } from '../../Api.js';

const FlightList = () => {
  const location = useLocation();
  const [flights, setFlights] = useState([]);
  const criteria = location.state && location.state.criteria;

  useEffect(() => {
    const fetchFlights = async () => {
      try {
        // Assuming there's an API function in api.js to fetch flights based on criteria
        const response = await getAllFlights();

        // Assuming the response contains a data property with the actual flights
        const fetchedFlights = response.data;

        // Handle the fetched flights data as needed
        setFlights(fetchedFlights);
      } catch (error) {
        // Handle errors, such as displaying an error message to the user
        console.error('Error fetching flights:', error);
      }
    };

    if (criteria) {
      fetchFlights();
    }
  }, [criteria]);

  return (
    <div>
      <h2>Flight List!</h2>
      {flights.map((flight) => (
        <div key={flight.id}>
          <p>Flight Number: {flight.number}</p>
          <p>Origin: {flight.origin}</p>
          <p>Destination: {flight.destination}</p>
          {/* Display other flight information as needed */}
        </div>
      ))}
    </div>
  );
};

export default FlightList;

