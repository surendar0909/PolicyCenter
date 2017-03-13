package com.eplan.register;

import java.util.List;

import com.eplan.register.UserModel;

public interface UserDao {

	public void saveUser(UserModel newUser);
	public List<UserModel> showUsers();
	public UserModel findUser(Long id);
	public void updateUser(UserModel newUser);
	public void deleteUser(Long id);
}
