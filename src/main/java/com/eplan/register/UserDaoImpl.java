package com.eplan.register;


import java.util.List;

import org.hibernate.Session;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {
	
	SessionFactory sessionFactory;
	
	@Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void saveUser(UserModel newUser) {
		Session session=sessionFactory.getCurrentSession();
		session.save(newUser);		
	}

	@Override
	public List<UserModel> showUsers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		List<UserModel> users=session.createCriteria(UserModel.class).list();
		return users;
	}

	@Override
	public UserModel findUser(Long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(UserModel.class);
		cr.add(Restrictions.eq("user_id",id));
		return (UserModel) cr.uniqueResult();
	}

	@Override
	public void updateUser(UserModel newUser) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(newUser);
		
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		UserModel user=findUser(id);
		session.delete(user);
		
	}
	
	

}
