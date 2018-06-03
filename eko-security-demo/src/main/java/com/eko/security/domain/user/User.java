package com.eko.security.domain.user;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2990616354756923794L;
	
	public interface userSimpleView{};
	public interface userDetailView extends userSimpleView{}
	public String id;
	public Date birthday;
	@NotEmpty
	public String username;
	@NotBlank
	@Pattern(regexp="[a-zA-Z]",message="only a-z")
	public String password;
	public User(){}
	public User(String id,String username,String password){
		this.username=username;
		this.password=password;
		this.id=id;
	}
	@JsonView(userSimpleView.class)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonView(userDetailView.class)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@JsonView(userSimpleView.class)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JsonView(userSimpleView.class)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
