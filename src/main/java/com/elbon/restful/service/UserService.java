package com.elbon.restful.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.elbon.restful.model.User;

@Component
public class UserService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 3;
	
	static {
		users.add(new User(1, "chandu", new Date()));
		users.add(new User(2, "ravi", new Date()));
		users.add(new User(3, "tarun", new Date()));
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public User saveUser(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public void updateUser(User uiUser) {
		for(User user: users) {
			if(user.getId() == uiUser.getId()) {
				user.setName(uiUser.getName());
				user.setDob(uiUser.getDob());
			}
		}
	}
	
	public User getUser(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteUser(int id) {
		Iterator<User> i = users.iterator();
		while(i.hasNext()) {
			User user = i.next();
			if(user.getId() == id) {
				i.remove();
				return user;
			}
		}
		return null;
	}
}
