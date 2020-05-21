package com.cg.iter.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.fms.dto.User;
import com.cg.iter.fms.repository.UserRepository;
import com.cg.iter.fms.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
    private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User viewUser(Long userId) {
		 if(userRepository.findById(userId).isPresent())
	            return userRepository.findById(userId).get();
	        return null;
	}

	@Override
	public List<User> viewUser() {
		 return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		   if(userRepository.findById(user.getUserId()).isPresent()){
	            User tempUser = userRepository.findById(user.getUserId()).get();
	            tempUser.setEmail(user.getEmail());
	            tempUser.setUserPhone(user.getUserPhone());
	            userRepository.save(tempUser);
	            return tempUser;
	        }
	        return null;
	}

	@Override
	public void deleteUser(Long userId) {
		  if(userRepository.findById(userId).isPresent()){
	            userRepository.deleteById(userId);
	        }
		
	}


}