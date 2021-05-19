package com.jchmielewski.pks.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

abstract class CRUDHibernateDAO <Entity, Iterator extends Serializable>{

    private Class<Entity> entityClass;

    private EntityManager entityManager;

    public void setEntityClass(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    public CRUDHibernateDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Entity getById(Iterator id){
        Session session = entityManager.unwrap(Session.class);

        return session.get(entityClass,id);
    }

    @Transactional
    public List<Entity> getAll(){
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from "+ entityClass.getName()).getResultList();
    }

    @Transactional
    public void saveOrUpdate(Entity type){
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(type);
    }

    @Transactional
    public void delete(Iterator id) {
        Session session = entityManager.unwrap(Session.class);

        session.delete(getById(id));
    }
}
