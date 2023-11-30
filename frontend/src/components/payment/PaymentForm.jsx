import {
  PaymentElement,
  useElements,
  useStripe,
} from "@stripe/react-stripe-js";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Loader from "../loader/Loader";
import { CustomAlert } from "../../utils/Alert";
import "./PaymentForm.css";

function PaymentForm() {
  const navigator = useNavigate();
  const stripe = useStripe();
  const elements = useElements();

  const [loading, setLoading] = useState(false);

  const sendEmail = async () => {
    const res = await fetch(`${process.env.REACT_APP_URL}/api/v1/email`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ email: "anahita.akbari312@gmail.com" }),
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);

    if (!stripe || !elements) {
      return;
    }

    const { error } = await stripe.confirmPayment({
      elements,
      redirect: "if_required",
    });
    if (!error) {
      await sendEmail();
      CustomAlert.showAlert("Purchase Completed");
      navigator("/book");
    } else if (error.message) {
      CustomAlert.showPaymentError(error.message);
      setLoading(false);
    } else {
      console.log(error);
      setLoading(false);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="payment-container">
      <h1 className="title">Payment</h1>
      <PaymentElement />
      {loading ? (
        <div className="pay-btn-container">
          <Loader></Loader>
        </div>
      ) : (
        <div className="pay-btn-container">
          <button type="submit" className="pay-btn">
            Pay
          </button>
        </div>
      )}
    </form>
  );
}

export default PaymentForm;
