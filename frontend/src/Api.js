// api.js

const API_BASE_URL = 'http://localhost:8080/api/v1';

const handleResponse = async (response) => {
  if (!response.ok) {
    const error = await response.json();
    throw new Error(error.message);
  }
  return response.json();
};

export const getAllAirlines = async () => {
  const response = await fetch(`${API_BASE_URL}/airline`);
  return handleResponse(response);
};

export const createAirline = async (airlineData) => {
  const response = await fetch(`${API_BASE_URL}/airline`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(airlineData),
  });
  return handleResponse(response);
};

// Similar functions for other airline endpoints (update, delete)

export const getAllFlights = async () => {
  const response = await fetch(`${API_BASE_URL}/flight`);
  return handleResponse(response);
};

export const createFlight = async (flightData) => {
  const response = await fetch(`${API_BASE_URL}/flight`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(flightData),
  });
  return handleResponse(response);
};

// Similar functions for other flight endpoints (update, delete)
// api.js

export const getFlightsByOrigin = async (origin) => {
    const response = await fetch(`/api/v1/flight/origin/${origin}`);
    if (!response.ok) {
      throw new Error('Failed to fetch flights by origin');
    }
    return response.json();
  };
  
  export const getFlightsByDestination = async (destination) => {
    const response = await fetch(`/api/v1/flight/destination/${destination}`);
    if (!response.ok) {
      throw new Error('Failed to fetch flights by destination');
    }
    return response.json();
  };
  