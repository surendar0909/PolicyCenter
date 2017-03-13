package com.eplan.register;

import java.util.List;

public interface UserService {
	public UserModel findUserById(Long id);
	public List <UserModel> listAllUsers();
	public void saveOrUpdate(UserModel user);
	public void deleteUser(Long id);
}
