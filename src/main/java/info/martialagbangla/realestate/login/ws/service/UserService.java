package info.martialagbangla.realestate.login.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import info.martialagbangla.realestate.login.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService {
	UserDto createUser(UserDto user);
	
}
