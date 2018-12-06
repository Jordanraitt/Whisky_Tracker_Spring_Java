package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findWhiskeyByYear(int year) {
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Whisky> findWhiskyByRegion(String region) {
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distilleryAlias");
            cr.add(Restrictions.eq("distilleryAlias.region", region));
            results = cr.list();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Whisky> findWhiskyViaDistilleryViaAge(String name, int age){
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distilleryAlias");
            cr.add(Restrictions.eq("distilleryAlias.name", name));
            cr.add(Restrictions.eq("age", age));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    // same as above but using the id
//    @Transactional
//    public List<Whisky> findWhiskyViaDistilleryViaAge(Long distilleryId, int age){
//        List<Whisky> results = null;
//        Session session = entityManager.unwrap(Session.class);
//        try{
//            Criteria cr = session.createCriteria(Whisky.class);
//            cr.add(Restrictions.eq("age", age));
//            cr.add(Restrictions.eq("distillery.id", distilleryId));
//            results = cr.list();
//        } catch (HibernateException ex) {
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return results;
//    }
}
