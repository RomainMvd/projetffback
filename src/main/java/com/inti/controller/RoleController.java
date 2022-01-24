package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Role;
import com.inti.service.interfaces.IRoleService;

@RestController
@CrossOrigin
public class RoleController {

	@Autowired
	IRoleService roleService;
	
	@GetMapping("/roles")
	public List<Role> findAll() {
		return roleService.findAll();
	}
	
	@GetMapping("/roles/{id}")
	public Role findOne(@PathVariable Long id) {
		return roleService.findOne(id);
	}
	
	@DeleteMapping("/roles/{id}")
	public void deleteRole(@PathVariable Long id) {
		roleService.delete(id);
	}
	
	@PostMapping("/roles")
	public String saveRole(
			@RequestParam(required = false) String nr
			) {
		Role currentRole = new Role();
		currentRole.setNomRole(nr);
		roleService.save(currentRole);
		return "Uploaded";
	}
	
	@PutMapping("/roles/{id}")
	public String updateRole(@PathVariable Long id, @RequestParam(required = false) String nr) {
		Role currentRole = roleService.findOne(id);
		currentRole.setNomRole(nr);
		roleService.save(currentRole);
		return "k";
	}
}
