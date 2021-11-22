package com.reto1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author deivi
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="User")
@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    
    @Column(name="user_email", unique=true, length=50, nullable=false)
	private String email;
    
    @Column(name="user_password", length=50, nullable=false)
	private String password;
    
    @Column(name="user_name", length=80, nullable=false)
	private String name;
}
