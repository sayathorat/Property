package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class LeaseDAO {

	@Autowired
	LeaseRepository leaseRepository;
	
	public Lease save(Lease lease)
	{
		return leaseRepository.save(lease);

	}
	public List<Lease> findAll() {
		// TODO Auto-generated method stub
		return leaseRepository.findAll();
		}
	

}
