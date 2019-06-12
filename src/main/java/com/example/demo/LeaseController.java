package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rblm/api/v1/")
public class LeaseController
{
	
	  @Autowired 
	  LeaseDAO leaseDAO;
	  
	  @GetMapping("/lease")
	  @CrossOrigin(origins = "*", allowedHeaders = "*") 
	  public List<Lease> getAllLease()
	  { 
	  //return leaserepository.findAll(); 
	  List<Lease> lstLease = leaseDAO.findAll();
	  
	  return lstLease; 
	  }
	 
	  // Create a new lease
	  
	  @PostMapping(value="/property/{id}/lease",consumes = "application/json",produces = "application/json")
	  @CrossOrigin(origins = "*", allowedHeaders = "*") 
	  public Lease createLease(@RequestBody Lease lease,@PathVariable(value="id") Long propertyId)
	   {
		  lease.setProperty_id(propertyId);
		  return leaseDAO.save(lease);
	    }
	 

}


