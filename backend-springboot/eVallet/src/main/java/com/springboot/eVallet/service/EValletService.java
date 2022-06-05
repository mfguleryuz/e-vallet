package com.springboot.eVallet.service;
import java.io.Console;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.eVallet.entity.EVallet;
import com.springboot.eVallet.exception.FoundShouldNotGoBelowZero;
import com.springboot.eVallet.exception.ResourceAlreadyExistException;
import com.springboot.eVallet.exception.ResourceNotFoundException;
import com.springboot.eVallet.repository.EValletRepository;

@Service
public class EValletService {
	@Autowired
    private EValletRepository eValletRepository;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	//create eVallet
	 @Transactional
	    public EVallet createEVallet(EVallet eVallet){
		 
			 if(eVallet.getFound() < 0) {
	 			log.error("#Found Should Not Go Below Zero.");
	         	throw new FoundShouldNotGoBelowZero("Found Should Not Go Below Zero.");
	 		}
			 
	        try {
	        	//check for eVallet with same citizenId
	            if (!eValletRepository.existsByCitizenId(eVallet.getCitizenId())){
	            	//check for create id from max id exist in db
	                eVallet.setId(null == eValletRepository.findMaxId()? 1 : eValletRepository.findMaxId() + 1);
	                eValletRepository.save(eVallet);
	                log.info("#EVallet Created Successfully");
	                return eVallet;
	            }else{
	            	log.error("#e-vallet with CitizenId must be unique! e-vallet with CitizenId : "+ eVallet.getCitizenId() + " already exists in the database.");
	            	throw new ResourceAlreadyExistException(" e-vallet with CitizenId must be unique!  e-vallet with CitizenId : "+ eVallet.getCitizenId() + " already exists in the database.");
	            }
	        }catch (Exception e){
	            throw e;
	        }
	    }

	 	//get eVallet list 
	    public List<EVallet> readEVallet(){
            log.info("#Read EVallet list");
	        return eValletRepository.findAll();
	    }

	  //get eVallet by id 
	    public EVallet readEValletById(long id){
	    	try{
	            log.info("#Read EVallet By Id");
	    		return eValletRepository.findById(id).get();
	    	}catch (Exception e){
	    		log.error("#EVallet not fount with id : "+ id);
	    		throw new ResourceNotFoundException("EVallet not fount with id : "+ id);
	        }
	    	
	    }
	    
	    //update eVallet
	    @Transactional
	    public EVallet updateEVallet(EVallet eVallet){
	    	
	    	if(eVallet.getFound() < 0) {
    			log.error("#Found Should Not Go Below Zero.");
            	throw new FoundShouldNotGoBelowZero("Found Should Not Go Below Zero.");
    		}
	    	
	    	try {    	
    			EVallet eValletToBeUpdate = eValletRepository.findById(eVallet.getId()).get();
	            eValletToBeUpdate.setId(eVallet.getId());
	            eValletToBeUpdate.setCustomerName(eVallet.getCustomerName());
	            eValletToBeUpdate.setCustomerSurname(eVallet.getCustomerSurname());
	            eValletToBeUpdate.setCitizenId(eVallet.getCitizenId());
	            eValletToBeUpdate.setFound(eVallet.getFound());
	            eValletRepository.save(eValletToBeUpdate);
	            log.info("#EVallet Updated.");         
	            return eVallet;
	    	}catch (Exception e){
	    		log.error("#EVallet not fount with id : "+ eVallet.getId());
	    		throw new ResourceNotFoundException("EVallet not fount with id : "+ eVallet.getId());
	        }
	    }

	    //delete eVallet
	    @Transactional
	    public EVallet deleteEVallet(long id){
		    try {
		    	EVallet existingEVallet = eValletRepository.findById(id).get();
	            eValletRepository.deleteById(id);
	            log.info("EVallet Deleted.");
		        return existingEVallet;
	    	}catch (Exception e){
	    		log.error("#EVallet not fount with id : "+ id);
	    		throw new ResourceNotFoundException("#EVallet not fount with id : "+ id);
	        }
	    }
	}
