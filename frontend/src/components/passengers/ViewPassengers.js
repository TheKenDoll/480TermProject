import React from "react";
import { useNavigate } from "react-router-dom";



const ViewPassengers = () => {
    const navigate = useNavigate();
    //const location = useLocation();

    // const receivedData = location.state?.someData || [];

    let passengers = [
        {
            "firstName": "John",
            "lastName": "Doe",
            "passportNumber": "123456789",
            "seatNumber": "1A"
        },
        {
            "firstName": "Jane",
            "lastName": "Doe",
            "passportNumber": "987654321",
            "seatNumber": "1B"
        }
    ];

    const handleGoBack = () => {
        navigate(-1);
    };

    return (
        <div>
            <h1>View Passengers</h1>
            {passengers.map((passenger, index) => (
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
