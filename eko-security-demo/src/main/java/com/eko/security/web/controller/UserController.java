package com.eko.security.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eko.security.domain.user.User;
import com.eko.security.domain.user.UserQueryCondition;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiOperation;

@RestController


@RequestMapping(value="/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping()
	@ResponseBody
	@JsonView(User.userSimpleView.class)
	@ApiOperation(value="user query api")
	public List<User> query(UserQueryCondition userQueryCondition){
		logger.info("user query request start");
		List<User> users = new ArrayList<User>();
		users.add(new User("1","tom","123"));
		users.add(new User("2","tom1","123"));
		users.add(new User("3","tom2","123"));
		System.out.println(ReflectionToStringBuilder.toString(userQueryCondition));
		logger.info("user query request end");
		return users;
		
	}
	@RequestMapping(value = "/user/{username:\\w+$}",method = RequestMethod.GET)
	@ResponseBody
	@JsonView(User.userDetailView.class)
	public User getUserInfo(@PathVariable String username){
		return new User("1","tom","123");
	}
	@PostMapping()
	@ResponseBody
	@JsonView(User.userDetailView.class)
	public User createUserInfo(@Valid @RequestBody User user, BindingResult errors){
		if(errors.hasErrors()){
			errors.getAllErrors().stream().forEach(error ->System.out.println(error.getDefaultMessage()));
		}
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return new User("3","tom","123");
	}
	
	@PostMapping("/createuser")
	@ResponseBody
	@JsonView(User.userDetailView.class)
	public User createUser(@RequestBody User user){
		return new User("3","tom","123");
		// throw new RuntimeException("errrrrrrrrrrrr"); 
		// throw new UserException("errrrrrrrrrrrr"); 
//		System.out.println(user.getId());
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
//		return null;
	}
	@PutMapping("/user/{id}")
	@ResponseBody
	@JsonView(User.userDetailView.class)
	public User updateUserInfo(@PathVariable String id){
	//	Filter > interceptor> ControllerAdvice> aspect>controller
//		if(errors.hasErrors()){
//		
//			errors.getAllErrors().stream().forEach(error ->
//			{
//				FieldError filedError = (FieldError)error;
//				System.out.println(filedError+":"+error.getDefaultMessage());
//			});
//			
//		}

		return new User("1","tom","123");
	}
	@DeleteMapping("/{id}")
	@ResponseBody
	@JsonView(User.userDetailView.class)
	public User deleteUserInfo(@Valid @RequestBody User user, BindingResult errors){
		if(errors.hasErrors()){
			errors.getAllErrors().stream().forEach(error ->
			{
				FieldError filedError = (FieldError)error;
				System.out.println(filedError+":"+error.getDefaultMessage());
			});
			
		}
	 
		return new User("1","tom","123");
	}
	
}
