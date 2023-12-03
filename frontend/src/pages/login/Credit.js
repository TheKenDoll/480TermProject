import React from 'react'

import Credit1 from "../../images/creditCard.jpeg"
import "./Credit.css"
import { useNavigate } from 'react-router-dom'

const Credit = () => {

    const userEmail = localStorage.getItem("uid")



    const userEmail1 = userEmail.split('@')[0].toUpperCase()

    const navigate = useNavigate()

    const handleImageClick = () => {
        navigate("/success")
    }



  return (
    <div className='credit1'>
        <p>{`Hi ${userEmail1}!  Do you know you can apply for the following benefits?`}`</p>

        <div className='credit1_div'>
            <p>Sign Up for credit Card</p>

            <img  onClick = {handleImageClick} className='credit1_image' src={Credit1}  alt=''/>


            <p>
                Click here for membership email <a>Here </a>
            </p>



        </div>



    </div>
  )
}

export default Credit