package com.springboot.eVallet.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.eVallet.entity.EVallet;
import com.springboot.eVallet.service.EValletService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/eVallet")
public class EValletController {
	 @Autowired
	    private EValletService eValletService;
	 
	//Test for application working 
	@RequestMapping(value = "info", method = RequestMethod.GET)
	public String info() {
		return "The application is working ...";
	}
	
	//create eVallet
	@RequestMapping(value = "", method = RequestMethod.POST)
    public EVallet createEVallet(@RequestBody EVallet eVallet){
        return eValletService.createEVallet(eVallet);
    }

	//get eVallet list
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<EVallet> readEVallet(){
        return eValletService.readEVallet();
    }
    
  //get eVallet by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EVallet readEValletById(@PathVariable(value="id") int eValletId){
        return eValletService.readEValletById(eValletId);
    }

    //update eVallet
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public EVallet updateEVallet(@RequestBody EVallet eVallet){
        return eValletService.updateEVallet(eVallet);
    }

    //delete eVallet
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public EVallet deleteEVallet(@PathVariable(value="id") int eValletId){
        return eValletService.deleteEVallet(eValletId);
    }
}

