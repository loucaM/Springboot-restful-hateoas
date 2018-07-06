package com.louca.springboot.rest.restfulrestwebservice.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService userDao;

	@GetMapping(path="/getAllUsers")
	public List<User> getAllUsers() {
		return  userDao.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> getOneUser(@PathVariable Integer id) {	
		User user = userDao.findOne(id);
		if (user == null) 
			throw new UserNotFoundException("id- "+id);
		
			Resource<User> resource = new Resource<User>(user);
			ControllerLinkBuilder linkTo =
					linkTo(methodOn(this.getClass()).getAllUsers());
			resource.add(linkTo.withRel("all-users"));
		
		
		return resource;
		
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDao.save(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/delete/{id}")
	public User deleteUser (@PathVariable Integer id) {
		User deletedUser = userDao.deleteOne(id);
		return deletedUser;
	}
	
}
