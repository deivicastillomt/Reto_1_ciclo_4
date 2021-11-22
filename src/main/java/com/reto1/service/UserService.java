package com.reto1.service;

import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto1.entity.User;
import com.reto1.repository.UserRepository;

/**
 * 
 * @author deivi
 *
 */
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 
	 * @return
	 */
    public List<User> findAll(){
        return userRepository.findAll();
    }
    
    /**
     * 
     * @param user
     * @return
     */
    public User Save(User user){
        if(user.getId()==null){
        	List<User> existUsers = userRepository.findByNameOrEmail(user.getName(), user.getEmail());
        	
        	if(existUsers.isEmpty()) {
        		return userRepository.save(user);
        	}
        	else {
        		return user;
        	}
        }
        else{
            Optional<User> existUsers = userRepository.findById(user.getId());
            if(existUsers.isEmpty()){
                return userRepository.save(user);
            }
            else{
                return user;
            }
        }
    }
    
    /**
     * 
     * @param email
     * @return
     */
    public boolean findByEmail(String email) {
    	return userRepository.findByEmail(email).isPresent();
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return
     */
    public User findByEmailAndPassword(String email, String password) {
    	Optional<User> user = userRepository.findByEmailAndPassword(email, password);
    	
    	if(user.isPresent()) {
    		return user.get();
    	}
    	else {
    		return new User(null, email, password, "NO DEFINIDO");
    	}
    }
}
