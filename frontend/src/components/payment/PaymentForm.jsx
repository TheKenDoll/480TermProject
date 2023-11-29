import {
  PaymentElement,
  useElements,
  useStripe,
} from "@stripe/react-stripe-js";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Loader from "../loader/Loader";

function PaymentForm() {
  const navigator = useNavigate();
  const stripe = useStripe();
  const elements = useElements();

  const [loading, setLoading] = useState(false);

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
      navigator("/book");
    } else if (error.message) {
      console.error(error.message);
      setLoading(false);
    } else {
      console.log(error);
      setLoading(false);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <PaymentElement />
      {loading ? (
        <Loader></Loader>
      ) : (
        <div>
          <button type="submit">Pay</button>
        </div>
      )}
    </form>
  );
}

export default PaymentForm;
