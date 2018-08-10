package com.example.springboottest.controller;

import com.example.springboottest.model.Taste;
import com.example.springboottest.service.TasteService;
import com.example.springboottest.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class TasteApiController {

	public static final Logger logger = LoggerFactory.getLogger(TasteApiController.class);

	@Autowired
	TasteService tasteService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve Single User------------------------------------------

	@RequestMapping(value = "/users/{uid}/taste", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("uid") int id) {
		logger.info("Fetching User with uid {}", id);
		Taste taste = tasteService.findById(id);
		if(taste == null){
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Taste with id " + id
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Taste>(taste, HttpStatus.OK);
	}

}