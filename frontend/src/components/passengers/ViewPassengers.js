import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';


const ViewPassengers = () => {
    const navigate = useNavigate();
    const location = useLocation();

    const receivedData = location.state?.someData || [];

    const handleGoBack = () => {
        navigate(-1);
    };

    return (
        <div>
            <h1>View Passengers</h1>
            {receivedData.passengers.map((passenger, index) => (
                <div key={index}>
                    <h2>{`Passenger ${index + 1}`}</h2>
                    <div>
                        <strong>First Name:</strong> {passenger.firstName}
                    </div>
                    <div>
                        <strong>Last Name:</strong> {passenger.lastName}
                    </div>
                    <div>
                        <strong>Passport Number:</strong> {passenger.passportNumber}
                    </div>
                    <div>
                        <strong>Seat Number:</strong> {passenger.seatNumber}
                    </div>
                </div>
            ))}
            <button onClick={handleGoBack}>Go Back</button>
        </div>
    );
};

export default ViewPassengers;
