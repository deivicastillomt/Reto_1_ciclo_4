package com.reto1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto1.entity.User;
import com.reto1.repository.crud.UserCrudRepository;

/**
 * 
 * @author deivi
 *
 */
@Repository
public class UserRepository {
	@Autowired
	private UserCrudRepository userCrudRepository;
	
	/**
	 * 
	 * @return
	 */
    public List<User> findAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    
    /**
     * 
     * @param id
     * @return
     */
    public Optional<User> findById(Integer id){
        return userCrudRepository.findById(id);
    }
    
    /**
     * 
     * @param name
     * @return
     */
    public Optional<User> findByName(String name){
    	return userCrudRepository.findByName(name);
    }
    
    /**
     * 
     * @param email
     * @return
     */
    public Optional<User> findByEmail(String email){
    	return userCrudRepository.findByEmail(email);
    }
    
    /**
     * 
     * @param name
     * @param email
     * @return
     */
    public List<User> findByNameOrEmail(String name, String email){
    	return userCrudRepository.findByNameOrEmail(name, email);
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return
     */
    public Optional<User> findByEmailAndPassword(String email, String password){
    	return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    /**
     * 
     * @param user
     * @return
     */
    public User save(User user){
        return userCrudRepository.save(user);
    }
}
