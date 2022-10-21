package com.restaurante.backend.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

public class NewUser {

    @NotBlank
    private String userName;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();
    public NewUser() {
    }
    public NewUser(@NotBlank String userName,  @NotBlank String nombre, @NotBlank String apellido, @NotBlank String password,
            Set<String> roles) {

        this.userName = userName;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.roles = roles;
    }
  
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<String> getRoles() {
        return roles;
    }
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    
}
