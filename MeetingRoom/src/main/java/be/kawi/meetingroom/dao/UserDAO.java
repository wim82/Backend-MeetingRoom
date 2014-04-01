package be.kawi.meetingroom.dao;

import be.kawi.meetingroom.model.User;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }
    
    public List<User> getActiveUsers(User user) {
        //TODO: implement more criteria if needed
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
