import React from 'react'
import Swal from "sweetalert2";

const MessageComponent = (isThereError,message) => {
    if(isThereError){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong!',
            footer: message?.response?.data?.message
          })                
          console.log(message)
    }else{
        Swal.fire({
            icon: 'success',
            title: message,
            showConfirmButton: false,
            timer: 2000
          })                
          console.log(message)
    }
}

export default MessageComponent
