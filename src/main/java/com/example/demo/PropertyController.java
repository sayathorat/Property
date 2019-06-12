package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/rblm/api/v1/")
public class PropertyController
{
	@Autowired
	PropertyDAO propertyDAO;
	
	@GetMapping("/properties")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<Property> getAllProperty() {
		//return propertyrepository.findAll();
		List<Property> lstProp = propertyDAO.findAll();
		
		 return lstProp;
	}
	
	// Create a new property
	@PostMapping("/properties")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public Property createProperty(@RequestBody Property prop,Model model,HttpServletRequest request) 
	{
	    return propertyDAO.save(prop,model,request);
	}
}
