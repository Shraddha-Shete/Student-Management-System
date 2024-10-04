package com.hefshine.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hefshine.dto.AdminRegiDto;
import com.hefshine.dto.LoginDto;
import com.hefshine.entity.AdminRegi;
import com.hefshine.loginMessage.loginMessage;
import com.hefshine.repository.AdminRegiRepository;
import com.hefshine.service.AdminRegiService;

@Service
public class AdminRegiServiceImpl implements AdminRegiService {
	@Autowired
	AdminRegiRepository adminRegiRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public AdminRegi save(AdminRegiDto adminRegiDto) {
		AdminRegi adminRegi =new AdminRegi(
				adminRegiDto.getId(),
				adminRegiDto.getFirstName(),
				adminRegiDto.getLastName(),
				adminRegiDto.getMobNo(),
				adminRegiDto.getEmail(),
				this.passwordEncoder.encode(adminRegiDto.getPassword()));
		
		return adminRegiRepository.save(adminRegi);
	}

	
	@Override
	public loginMessage login(LoginDto loginDto) {
		AdminRegi admin=adminRegiRepository.findByEmail(loginDto.getEmail());
		if(admin!=null) {
			String passsword=loginDto.getPassword();
			String encodedPassword=admin.getPassword();
			boolean isPwdMatch=passwordEncoder.matches(passsword, encodedPassword);
			if(isPwdMatch) {
				Optional<AdminRegi> admin1=adminRegiRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
				if(admin1.isPresent()) {
					return new loginMessage("Login Success", true);
				}
				else
					return new loginMessage("Login Failed", false);
			}
			else {
				return new loginMessage("Password Not Match", false);
			}
		}
		else {
			return new loginMessage("Email not exist", false);
		}
	}
	
	
	
	

}
