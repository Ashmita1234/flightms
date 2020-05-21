package com.cg.iter.fms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.iter.fms.dto.User;
import com.cg.iter.fms.exception.UserNotFoundException;
import com.cg.iter.fms.service.UserService;

import java.util.List;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user")
    private User addUser(@Valid @RequestBody User user) 
    {
    	return userService.addUser(user);
    }

    
    @GetMapping(value = "/user/{id}")
    private User viewUser(@PathVariable(value = "id")Long userId)throws UserNotFoundException
    {
    	User user=userService.viewUser(userId);
    	if(null==user || "".equals(user))
    	{
    		 throw new UserNotFoundException("user not found with id "+userId);
    	}
    	else
    	{
    		return userService.viewUser(userId);
		}
    }

    
    @GetMapping(value = "/user")
    private List<User> viewUser(){
        return userService.viewUser();
    }

   
    @PutMapping(value = "/user/{id}")
    private User updateUser(@Valid @PathVariable(value = "id")Long userId, @RequestBody User userDetailsToUpdate) throws UserNotFoundException
    {
    	User user = userService.viewUser(userId);
    	if(null==user || "".equals(user))
    	{
    		 throw new UserNotFoundException("user not found with id "+userId);
    	}
    	else
    	{
    	return userService.updateUser(userDetailsToUpdate);
    	}
    }
    

    @DeleteMapping(value = "/user/{id}")
    private void deleteUser(@PathVariable(value = "id")Long userId) throws UserNotFoundException
    {
    	User user=userService.viewUser(userId);
    	if(null==user || "".equals(user))
    	{
    		 throw new UserNotFoundException("user not found with id "+userId);
    	}
    	userService.deleteUser(userId);
    }

}
