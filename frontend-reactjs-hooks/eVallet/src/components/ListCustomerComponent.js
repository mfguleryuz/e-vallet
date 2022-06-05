import React, {useState, useEffect} from 'react'
import { Link } from 'react-router-dom'
import CustomerService from '../services/CustomerService'
import MessageComponent from './MessageComponent';


const ListCustomerComponent = () => {

    const [customers, setCustomers] = useState([])

    useEffect(() => {

        getAllCustomers();
    }, [])

    const getAllCustomers = () => {
        CustomerService.getAllCustomers().then((response) => {
            setCustomers(response.data)
        }).catch(error =>{
            MessageComponent(true,error);
        })
    }

    const deleteCustomer = (customerId) => {
       CustomerService.deleteCustomer(customerId).then((response) =>{
        MessageComponent(false,'Record has been deleted');
        getAllCustomers();

       }).catch(error =>{
        MessageComponent(true,error);
    })
        
    }

    return (
        <div className = "container">
            <h2 className = "text-center"> Customer List </h2>
            <Link to = "/add-customer" className = "btn btn-primary mb-2" > Add Customer </Link>
            <table className="table table-bordered table-striped">
                <thead>
                    <th> Id </th>
                    <th> Citizen Id </th>
                    <th> First Name </th>
                    <th> Last Name </th>
                    <th> Found </th>
                    <th> Actions </th>
                </thead>
                <tbody>
                    {
                        customers.map(
                            customer =>
                            <tr key = {customer.id}> 
                                <td> {customer.id} </td>
                                <td> {customer.citizenId} </td>
                                <td> {customer.customerName} </td>
                                <td>{customer.customerSurname}</td>
                                <td>{customer.found}</td>
                                <td>
                                    <Link className="btn btn-info" to={`/edit-customer/${customer.id}`} >Update</Link>
                                    <button className = "btn btn-danger" onClick = {() => deleteCustomer(customer.id)}
                                    style = {{marginLeft:"10px"}}> Delete</button>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListCustomerComponent
