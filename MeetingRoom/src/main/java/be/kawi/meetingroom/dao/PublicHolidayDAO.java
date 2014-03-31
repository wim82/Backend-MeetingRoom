package be.kawi.meetingroom.dao;


import be.kawi.meetingroom.model.PublicHoliday;


import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PublicHolidayDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<PublicHoliday> getPublicHolidays() {
        return sessionFactory.getCurrentSession().createCriteria(PublicHoliday.class).list();
    }

    public void updatePublicHoliday(PublicHoliday holiday) {
        sessionFactory.getCurrentSession().update(holiday);
    }

    public void savePublicHoliday(PublicHoliday holiday) {
        sessionFactory.getCurrentSession().persist(holiday);
    }

}
