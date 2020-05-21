package com.cg.iter.fms.service;


import java.util.List;

import com.cg.iter.fms.dto.User;

public interface UserService {

	public User addUser(User user);

	public User viewUser(Long userId);

	public List<User> viewUser();

	public User updateUser(User user) ;

	public void deleteUser(Long userId);
	
}
