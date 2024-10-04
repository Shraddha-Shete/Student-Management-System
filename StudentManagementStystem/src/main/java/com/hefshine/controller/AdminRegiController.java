package com.hefshine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hefshine.dto.AdminRegiDto;
import com.hefshine.dto.LoginDto;
import com.hefshine.entity.AdminRegi;
import com.hefshine.loginMessage.loginMessage;
import com.hefshine.service.AdminRegiService;

@RestController
@CrossOrigin("*")
public class AdminRegiController {
	@Autowired
	AdminRegiService adminRegiService;
	
	@PostMapping("saveAdmin")
	public  AdminRegi save(@RequestBody AdminRegiDto adminRegiDto){
		return adminRegiService.save(adminRegiDto);
	}
	
	@PostMapping("login")
	public  ResponseEntity<?> login (@RequestBody LoginDto loginDto) {
		loginMessage login =adminRegiService.login(loginDto);
		return ResponseEntity.ok(login);
	}
}
