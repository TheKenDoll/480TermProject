import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const CancellationInsurance = () => {
  const [selectedOption, setSelectedOption] = useState(null);
  const [promoCode, setPromoCode] = useState('');
  const [isPromoApplied, setIsPromoApplied] = useState(false);
  const [isPromoBoxVisible, setIsPromoBoxVisible] = useState(false);
  const [promoCodeError, setPromoCodeError] = useState('');
  const navigate = useNavigate();

  const handleOptionChange = (option) => {
    // Allow changing the option only if the promo is not applied
    // if (!isPromoApplied) {
      setSelectedOption(option);
    // }
  };

  const handleProceedToPayment = () => {
    // Navigate to "/checkout"
    navigate('/checkout');
  };

  const handlePromoCodeChange = (event) => {
    setPromoCode(event.target.value);
    // Clear promo code error when user starts typing
    setPromoCodeError('');
  };

  const handleApplyPromoCode = () => {
    // Check if the entered promo code is valid (e.g., "12345")
    if (promoCode === '12345') {
      // Apply the promo code, making premium insurance free
      setIsPromoApplied(true);
    } else {
      // Invalid promo code
      setPromoCodeError('Invalid promo code. Please try again.');
    }
  };

  const handleRemovePromoCode = () => {
    // Remove the applied promo code
    setIsPromoApplied(false);
    // Clear promo code error when promo is removed
    setPromoCodeError('');
  };

  return (
    <div style={{ marginTop: '100px', padding: '20px' }}>
      <h1>Cancellation Insurance</h1>
      <p>Please choose a cancellation insurance option:</p>

      <div>
        <label>
          <input
            type="radio"
            value="noInsurance"
            checked={selectedOption === 'noInsurance'}
            onChange={() => handleOptionChange('noInsurance')}
            disabled={isPromoApplied}
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
            disabled={isPromoApplied}
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
            disabled={isPromoApplied}
          />
          Premium Insurance {isPromoApplied ? '(Free with Promo)' : '($50)'}
        </label>
        <p>Provides a full refund on cancellations.</p>
      </div>

      {selectedOption && (
        <button onClick={handleProceedToPayment}>Proceed to Payment</button>
      )}

      <div style={{ marginTop: '20px' }}>
        {!isPromoApplied && (
          <button onClick={() => setIsPromoBoxVisible(true)}>Use Promo Code</button>
        )}
        {isPromoBoxVisible && (
          <>
            <input
              type="text"
              placeholder="Enter promo code"
              value={promoCode}
              onChange={handlePromoCodeChange}
              style={{ marginLeft: '10px' }}
            />
            <button onClick={handleApplyPromoCode}>Apply</button>
            {promoCodeError && <p style={{ color: 'red' }}>{promoCodeError}</p>}
          </>
        )}
        {isPromoApplied && (
          <button onClick={handleRemovePromoCode}>Remove Promo Code</button>
        )}
      </div>
    </div>
  );
};

export default CancellationInsurance;

