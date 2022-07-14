package com.spring.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000", "http://54.161.140.125"})
@RestController
@RequestMapping("/api")
public class DeployRestController {

	@GetMapping("/deploy")
	public String deployTest() {
		return "배포 테스트 RestController";
	}
}
