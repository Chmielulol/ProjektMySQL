package com.jchmielewski.pks.DAO;

import com.jchmielewski.pks.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDAO extends CRUDHibernateDAO<User, Integer>{

    @Autowired
    public UserDAO(EntityManager entityManager) {
        super(entityManager);
        setEntityClass(User.class);
    }
}
