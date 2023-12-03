import React from "react";
import  Airport2 from "../../images/airport2.jpeg"
import "./Landing.css"
import Book from "../../components/bookings/Book";
import Credit from "./Credit";

function Landing() {


    const userEmail = sessionStorage.getItem('userEmail');

    const userEmail1 = userEmail.split('@')[0].toUpperCase()





    return (
        <div>
            <h1>This is the Landing</h1>


            <div>
            <h1>This is the Landing</h1>
            </div>

            <div className="image_container">


                <img  className = "full-width-image"  src={Airport2}  alt=""/>

                <h1 className="header2">{`Welcome to the ${userEmail1}'s  portal`}</h1>

                <div className="book-page">
                    <Book />
                </div>

                <div className="credit_page">
                    <Credit />

                </div>


                <div className="image_button">
{/*
                        <button >Hi</button>
                        <button >Checking for flights</button>

                        <button >Browse Flights</button> */}

                </div>







            </div>




        </div>


    )
}

export default Landing