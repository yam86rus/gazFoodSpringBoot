package com.gazFood.dao;

import com.gazFood.entity.Vacancy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VacancyDAOImpl implements VacancyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Vacancy> getAllVacancies() {
        Session session = sessionFactory.getCurrentSession();
        Query <Vacancy> query = session.createQuery("from Vacancy",Vacancy.class);
        List<Vacancy> allVacancies = query.getResultList();

        return allVacancies;
    }

    @Override
    public void saveVacancy(Vacancy vacancy) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(vacancy);
    }

    @Override
    public Vacancy getVacancy(int id) {
        Session session = sessionFactory.getCurrentSession();
        Vacancy vacancy = session.get(Vacancy.class, id);
        return vacancy;
    }

    @Override
    public void deleteVacancy(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Vacancy> query = session.createQuery("delete from Vacancy where id=:vacancyId");
        query.setParameter("vacancyId", id);
        query.executeUpdate();

    }

}
