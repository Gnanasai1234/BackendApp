
package com.klef.jfsd.sdp.controller;

import java.util.List;


import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/")
public class UserController {
	
	
	
	@GetMapping("/")
	public String home()
	{
		return "Your Backend is Running...";
	}
	
	
	

}
