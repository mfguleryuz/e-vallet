import axios from 'axios'

const CUSTOMER_BASE_REST_API_URL = 'http://localhost:8080/api/eVallet';
let token = localStorage.getItem("token")

class CustomerService{

    getAllCustomers(){
        return axios.get(CUSTOMER_BASE_REST_API_URL,{
            headers: {
              Authorization: `Bearer ${token}`, //here remove + in template litereal
            }}
            )
    }

    createCustomer(customer){
        return axios.post(CUSTOMER_BASE_REST_API_URL, customer)
    }

    getCustomerById(customerId){
        return axios.get(CUSTOMER_BASE_REST_API_URL + '/' + customerId);
    }

    updateCustomer(customerId, customer){
        return axios.put(CUSTOMER_BASE_REST_API_URL, customer);
    }

    deleteCustomer(customerId){
        return axios.delete(CUSTOMER_BASE_REST_API_URL + '/' + customerId);
    }
}

export default new CustomerService();