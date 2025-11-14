package com.smr.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish-api")
public class WishMessageOperationsController {
	
	@GetMapping("/display")
	public ResponseEntity<String> showWishMessage(){
		return new ResponseEntity<String>("Hello Good Morning MR. SAMIR ",HttpStatus.OK);
	}

}
