package com.jchmielewski.pks.DAO;

import com.jchmielewski.pks.entity.Central;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CentralDAO extends CRUDHibernateDAO<Central,Integer>{

    @Autowired
    public CentralDAO(EntityManager entityManager) {
        super(entityManager);
        setEntityClass(Central.class);
    }
}
