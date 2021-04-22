package info.martialagbangla.realestate.login.ws.ui.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.martialagbangla.realestate.login.ws.service.UserService;

import info.martialagbangla.realestate.login.ws.shared.dto.UserDto;
import info.martialagbangla.realestate.login.ws.ui.model.request.UserDetailsRequestModel;
import info.martialagbangla.realestate.login.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/api/v1/users") //http://localhost:8081/api/v1/users
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping
	public String getUser()
	{ 
		return "get user was called";
		
	}
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails)
	{
		//System.out.print(userDetails.getLastName());
		UserRest returnvalue= new UserRest();
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		//System.out.print(userDto.getLastName());
		UserDto createUser=userService.createUser(userDto);
		//System.out.print(createUser.getLastName());
		BeanUtils.copyProperties(createUser, returnvalue);
		//System.out.print(returnvalue.getLastName());
		return returnvalue;
	}
	@PutMapping
	public String updateUser()
	{
		return "update user was called";
	}
	@DeleteMapping
	public String deleteUser()
	{
		return "delete user was called";
	}
}
