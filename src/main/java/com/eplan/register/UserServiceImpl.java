package com.eplan.register;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	UserDao uDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.uDao=userDao;
	}

	@Override
	public UserModel findUserById(Long id) {
		// TODO Auto-generated method stub
		return uDao.findUser(id);
	}

	@Override
	public List<UserModel> listAllUsers() {
		// TODO Auto-generated method stub
		return uDao.showUsers();
	}

	@Override
	public void saveOrUpdate(UserModel user) {
		if(findUserById(user.getUser_id())==null)
			uDao.saveUser(user);
		else
			uDao.updateUser(user);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		uDao.deleteUser(id);
		
	}

}
