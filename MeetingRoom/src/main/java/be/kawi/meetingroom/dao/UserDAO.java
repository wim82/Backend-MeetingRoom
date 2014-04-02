package be.kawi.meetingroom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.kawi.meetingroom.model.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getUsers() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	public List<User> getUser(User user) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("fullName", user.getFullName()));
		return criteria.list();
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void saveUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

}
