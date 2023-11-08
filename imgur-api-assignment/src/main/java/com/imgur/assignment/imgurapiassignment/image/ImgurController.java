package com.imgur.assignment.imgurapiassignment.image;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImgurController {
    
	@RequestMapping("/hellobro")
	public String sayHi(){
		return "Hi";
	}
}
