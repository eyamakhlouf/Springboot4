package com.eya.livres.service;

import com.eya.livres.entities.Role;
import com.eya.livres.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}
