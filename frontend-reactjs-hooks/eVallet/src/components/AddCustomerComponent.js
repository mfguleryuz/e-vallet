import React, {useState, useEffect} from 'react'
import {Link, useHistory, useParams } from 'react-router-dom';
import CustomerService from '../services/CustomerService'
import MessageComponent from './MessageComponent';

const AddCustomerComponent = () => {

    const [citizenId, setCitizenId] = useState('')
    const [customerName, setCustomerName] = useState('')
    const [customerSurname, setCustomerSurname] = useState('')
    const [found, setFound] = useState('')
    const history = useHistory();
    const {id} = useParams();

    const saveOrUpdateCustomer = (e) => {
        e.preventDefault();

        const customer = {citizenId, customerName, customerSurname, found}

        if(id){
            customer.id = id;
            CustomerService.updateCustomer(id, customer).then((response) => {
                MessageComponent(false,'Record has been Updated');
                history.push('/customers')
            }).catch(error => {
               MessageComponent(true,error);
            })

        }else{
            CustomerService.createCustomer(customer).then((response) =>{
                MessageComponent(false,'Record has been saved');
                history.push('/customers');
    
            }).catch(error => {
                MessageComponent(true,error);
            })
        }
        
    }

    useEffect(() => {

        CustomerService.getCustomerById(id).then((response) =>{
            setCitizenId(response.data.citizenId)
            setCustomerName(response.data.customerName)
            setCustomerSurname(response.data.customerSurname)
            setFound(response.data.found)
        }).catch(error => {
            console.log(error)
        })
    }, [])

    const title = () => {

        if(id){
            return <h2 className = "text-center">Update Customer</h2>
        }else{
            return <h2 className = "text-center">Add Customer</h2>
        }
    }

    return (
        <div>
           <br /><br />
           <div className = "container">
                <div className = "row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                       {
                           title()
                       }
                        <div className = "card-body">
                            <form>
                            <div className = "form-group mb-2">
                                    <label className = "form-label"> Citizen Id :</label>
                                    <input
                                        type = "text"
                                        placeholder = "Enter citizen id"
                                        disabled = {id ? true : false}
                                        name = "citizenId"
                                        className = "form-control"
                                        value = {citizenId}
                                        onChange = {(e) => setCitizenId(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <div className = "form-group mb-2">
                                    <label className = "form-label"> First Name :</label>
                                    <input
                                        type = "text"
                                        placeholder = "Enter first name"
                                        name = "customerName"
                                        className = "form-control"
                                        value = {customerName}
                                        onChange = {(e) => setCustomerName(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <div className = "form-group mb-2">
                                    <label className = "form-label"> Last Name :</label>
                                    <input
                                        type = "text"
                                        placeholder = "Enter last name"
                                        name = "customerSurname"
                                        className = "form-control"
                                        value = {customerSurname}
                                        onChange = {(e) => setCustomerSurname(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <div className = "form-group mb-2">
                                    <label className = "form-label"> Found :</label>
                                    <input
                                        type = "number"
                                        min = "0"
                                        placeholder = "Enter found"
                                        name = "found"
                                        className = "form-control"
                                        value = {found}
                                        onChange = {(e) => setFound(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <button className = "btn btn-success" onClick = {(e) => {
                                    found >= 0 && saveOrUpdateCustomer(e)}} >Submit </button>
                                <Link to="/customers" className="btn btn-danger"> Cancel </Link>
                            </form>

                        </div>
                    </div>
                </div>

           </div>

        </div>
    )
}

export default AddCustomerComponent
