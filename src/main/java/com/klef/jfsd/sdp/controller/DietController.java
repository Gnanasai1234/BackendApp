package com.klef.jfsd.sdp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.klef.jfsd.sdp.model.All;
import com.klef.jfsd.sdp.model.UserDietRetrival;
import com.klef.jfsd.sdp.repository.DietRepository;
import com.klef.jfsd.sdp.service.DietService;
import com.klef.jfsd.sdp.service.DietServiceImpl;

@Controller
@RequestMapping("/diet")
public class DietController {
	
	
	@Autowired
	DietService dietServiceImpl;
	
	@PostMapping("/updatediet")
	public ResponseEntity<?> updatediet(@RequestBody All all)
	{
		
		try {
			

			dietServiceImpl.UpdateDiet(all);
			return new ResponseEntity<>(HttpStatus.OK);

		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getuserdiet/{uid}/{date}")
	public ResponseEntity<List<UserDietRetrival>> getuserdiet(@PathVariable("uid") int  id,@PathVariable("date") LocalDate date)
	{
//		System.out.println(date);
		
		try {
			
			List<UserDietRetrival> d=dietServiceImpl.getuserdiet(id,date);
//			System.out.println(d.getFirst());
			return new ResponseEntity<>(d,HttpStatus.ACCEPTED); 
					
		}
		catch(Exception e){
				
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	

}