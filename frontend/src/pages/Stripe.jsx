import React, { useState, useEffect } from "react";
import { Elements } from "@stripe/react-stripe-js";
import { loadStripe } from "@stripe/stripe-js";
import Loader from "../components/loader/Loader";
import PaymentForm from "../components/payment/PaymentForm";

function Stripe() {
  const total = "100";
  const [clientSecret, setClientSecret] = useState("");
  const [loading, setLoading] = useState(true);

  const stripePromise = loadStripe(process.env.REACT_APP_STRIPE_PUBLIC_KEY);

  const paymentIntent = async () => {
    try {
      const res = await fetch(
        `${process.env.REACT_APP_URL}/api/v1/payment?total=${total}`,
        {
          method: "POST",
        }
      );
      const data = await res.json();
      setLoading(false);
      setClientSecret(data.client_secret);
    } catch (err) {
      console.error(err);
    }
  };

  useEffect(() => {
    paymentIntent();
  }, []);

  return (
    <main>
      <div>
        <h1>Payment</h1>
      </div>
      {loading ? (
        <div>
          <Loader key="loader" />
        </div>
      ) : (
        <Elements
          stripe={stripePromise}
          options={{ clientSecret: clientSecret }}
        >
          <PaymentForm></PaymentForm>
        </Elements>
      )}
    </main>
  );
}

export default Stripe;
