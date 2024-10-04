package com.hefshine.service;

import com.hefshine.dto.AdminRegiDto;
import com.hefshine.dto.LoginDto;
import com.hefshine.entity.AdminRegi;
import com.hefshine.loginMessage.loginMessage;

public interface AdminRegiService {
	public AdminRegi save (AdminRegiDto adminRegiDto);
	public loginMessage login(LoginDto loginDto);

}
