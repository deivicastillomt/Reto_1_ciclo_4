package com.reto1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto1.entity.User;
import com.reto1.service.UserService;

/**
 * 
 * @author deivi
 *
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @return
	 */
    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.findAll();
    }
    
    /**
     * 
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
    	return userService.Save(user);
    }
    
    /**
     * 
     * @param email
     * @return
     */
    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email) {
    	return userService.findByEmail(email);
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User autheUser(@PathVariable("email") String email, @PathVariable("password") String password) {
    	return userService.findByEmailAndPassword(email, password);
    }
}
