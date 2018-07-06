package com.louca.springboot.rest.restfulrestwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
	private static int countId = 3;
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Repié", new Date()));
		users.add(new User(2, "Nojeat", new Date()));
		users.add(new User(3, "Chimjoa", new Date()));
		
	}

	public List<User> findAll() {
		return users;
	}
	
	public User save (User user) {
		if (user.getId() == null) {
			user.setId(++countId);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user: users) {
			if (user.getId() == id ) {
				return user ;
			}
		}
		return null;
	}
	
	public User deleteOne(int id) {
		Iterator<User> itUser = users.iterator();
		while (itUser.hasNext()) {
			User user = itUser.next();
			if (user.getId() == id) {
				users.remove(user);
				return user ;
			}
		}
		return null;
	}
}
