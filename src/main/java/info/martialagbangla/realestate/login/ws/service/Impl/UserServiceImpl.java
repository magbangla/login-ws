package info.martialagbangla.realestate.login.ws.service.Impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import info.martialagbangla.realestate.login.ws.UserRepository;
import info.martialagbangla.realestate.login.ws.io.entity.UserEntity;
import info.martialagbangla.realestate.login.ws.service.UserService;
import info.martialagbangla.realestate.login.ws.shared.Utils;
import info.martialagbangla.realestate.login.ws.shared.dto.UserDto;
import info.martialagbangla.realestate.login.ws.shared.WsLogger;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utility;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public UserDto createUser(UserDto user) {
		
		if (userRepository.findByEmail(user.getEmail())!=null) throw new RuntimeException("Record already exist");
		UserEntity userEntity= new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setUserId(utility.generateUserId(30));
		
			UserEntity storedUserDetails = userRepository.save(userEntity);
			WsLogger.logger.debug("Hello this is a debug message");  
			WsLogger.logger.info("Hello this is an info message"); 
			UserDto returnValue= new UserDto();
			BeanUtils.copyProperties(storedUserDetails, returnValue);
			return returnValue;
	}
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
	
		return null;
	}
	

}
