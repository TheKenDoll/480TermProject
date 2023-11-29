// InsuranceSelection.js
import React, { useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const SelectInsurance = () => {
  const navigate = useNavigate();
  const [selectedInsurance, setSelectedInsurance] = useState('');


  const handleInsuranceSelection = (insurance) => {
    // Handle insurance selection logic
    setSelectedInsurance(insurance);
  };

  const handleProceedToPayment = () => {
    // Add logic to proceed to payment screen
    navigate('/payment');
  };

  return (
    <div>
      <h2>Insurance Selection</h2>
      <p>Selected Insurance: {selectedInsurance}</p>

      {/* Fake insurance options */}
      <div>
        <label>
          <input
            type="radio"
            value="basic"
            checked={selectedInsurance === 'basic'}
            onChange={() => handleInsuranceSelection('basic')}
          />
          Basic Insurance
        </label>
      </div>

      <div>
        <label>
          <input
            type="radio"
            value="premium"
            checked={selectedInsurance === 'premium'}
            onChange={() => handleInsuranceSelection('premium')}
          />
          Premium Insurance
        </label>
      </div>

      {/* Button to proceed to payment screen */}
      {selectedInsurance && (
        <button onClick={handleProceedToPayment}>Proceed to Payment</button>
      )}
    </div>
  );
};

export default SelectInsurance;
