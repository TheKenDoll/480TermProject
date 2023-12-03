import React, { useState, useEffect } from "react";
import { Elements } from "@stripe/react-stripe-js";
import { loadStripe } from "@stripe/stripe-js";
import Loader from "../../components/loader/Loader";
import PaymentForm from "../../components/payment/PaymentForm";
import "./Stripe.css";

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
          headers: {
            Authorization: `Bearer ${localStorage.getItem("jwt")}`,
          },
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
    <>
      <main className="stripe-main-container">
        <div className="stripe-image-container">
          <img src="./dubai.jpg" alt="city" className="image"></img>
        </div>
        {loading ? (
          <div className="loader">
            <Loader key="loader" />
          </div>
        ) : (
          <section className="stripe-container">
            <Elements
              stripe={stripePromise}
              options={{ clientSecret: clientSecret }}
            >
              <PaymentForm></PaymentForm>
            </Elements>
          </section>
        )}
        <div className="stripe-blank-container"></div>
      </main>
    </>
  );
}

export default Stripe;
