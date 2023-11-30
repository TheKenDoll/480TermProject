import Swal from "sweetalert2";

export class CustomAlert {
  static async showAlert(message) {
    return Swal.fire({
      icon: "success",
      title: `${message}`,
      text: "We have sent you an email with your booking details",
      confirmButtonColor: "#4caf50",
    });
  }
  static async showPaymentError(message) {
    return Swal.fire({
      title: message,
      text: "Please try again",
      icon: "error",
      confirmButtonColor: "#4caf50",
    });
  }
}
