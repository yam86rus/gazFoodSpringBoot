package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.Vacancy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VacancyDAOImpl implements com.gazfood.gazfoodspringboot.dao.VacancyDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Vacancy> getAllVacancies() {
        Session session = entityManager.unwrap(Session.class);
        Query <Vacancy> query = session.createQuery("from Vacancy",Vacancy.class);
        List<Vacancy> allVacancies = query.getResultList();

        return allVacancies;
    }

    @Override
    public void saveVacancy(Vacancy vacancy) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(vacancy);
    }

    @Override
    public Vacancy getVacancy(int id) {
        Session session = entityManager.unwrap(Session.class);
        Vacancy vacancy = session.get(Vacancy.class, id);
        return vacancy;
    }

    @Override
    public void deleteVacancy(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Vacancy> query = session.createQuery("delete from Vacancy where id=:vacancyId");
        query.setParameter("vacancyId", id);
        query.executeUpdate();

    }

}
