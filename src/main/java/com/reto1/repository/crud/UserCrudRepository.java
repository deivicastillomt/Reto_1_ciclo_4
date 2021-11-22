package com.reto1.repository.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.reto1.entity.User;

/**
 * 
 * @author deivi
 *
 */
public interface UserCrudRepository extends CrudRepository<User, Integer>{
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Optional<User> findByName(String name);
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	public Optional<User> findByEmail(String email);
	
	/**
	 * 
	 * @param name
	 * @param email
	 * @return
	 */
	public List<User> findByNameOrEmail(String name, String email);
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public Optional<User> findByEmailAndPassword(String email, String password);
}
