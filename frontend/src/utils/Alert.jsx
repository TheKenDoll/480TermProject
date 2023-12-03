import Swal from "sweetalert2";

export class CustomAlert {
  static async showAlert(message) {
    return Swal.fire({
      icon: "success",
      title: `${message}`,
      text: "We have sent you an email with your booking details",
      confirmButtonColor: "#02040a",
    });
  }
  static async showError(message) {
    return Swal.fire({
      title: "Oops...",
      text: `${message}`,
      icon: "error",
      confirmButtonColor: "#02040a",
    });
  }
}
