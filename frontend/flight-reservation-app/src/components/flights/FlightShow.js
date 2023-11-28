import React from 'react'

const FlightShow = ({flight}) => {
  return (
    <div>

        <p>{flight.number}</p>
        <p>{flight.destination}</p>
        <p>{flight.origin}</p>
        <p>{flight.departureTime}</p>



    </div>
  )
}

export default FlightShow