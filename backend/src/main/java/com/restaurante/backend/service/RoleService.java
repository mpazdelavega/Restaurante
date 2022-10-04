package com.restaurante.backend.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.backend.entity.Role;
import com.restaurante.backend.enums.RoleList;
import com.restaurante.backend.repository.RoleRepository;


@Service
@Transactional
public class RoleService {
	
	private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Optional<Role> getByRoleName(RoleList roleName){
        return roleRepository.findByRoleName(roleName);
    }

}
