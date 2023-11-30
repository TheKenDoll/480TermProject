// CancellationInsurance.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const CancellationInsurance = () => {
  const [selectedOption, setSelectedOption] = useState(null);
  const navigate = useNavigate();

  const handleOptionChange = (option) => {
    setSelectedOption(option);
  };

  const handleProceedToPayment = () => {
    // Navigate to "/checkout"
    navigate('/checkout');
  };

  return (
    <div>
      <h1>Cancellation Insurance</h1>
      <p>Please choose a cancellation insurance option:</p>

      <div>
        <label>
          <input
            type="radio"
            value="noInsurance"
            checked={selectedOption === 'noInsurance'}
            onChange={() => handleOptionChange('noInsurance')}
          />
          No Insurance (Free)
        </label>
        <p>Provides no cancellations or refunds.</p>
      </div>

      <div>
        <label>
          <input
            type="radio"
            value="basicInsurance"
            checked={selectedOption === 'basicInsurance'}
            onChange={() => handleOptionChange('basicInsurance')}
          />
          Basic Insurance ($20)
        </label>
        <p>Provides an 80% refund on cancellations.</p>
      </div>

      <div>
        <label>
          <input
            type="radio"
            value="premiumInsurance"
            checked={selectedOption === 'premiumInsurance'}
            onChange={() => handleOptionChange('premiumInsurance')}
          />
          Premium Insurance ($50)
        </label>
        <p>Provides a full refund on cancellations.</p>
      </div>

      {selectedOption && (
        <button onClick={handleProceedToPayment}>Proceed to Payment</button>
      )}
    </div>
  );
};

export default CancellationInsurance;
