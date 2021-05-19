package com.jchmielewski.pks.DAO;

import com.jchmielewski.pks.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class AddressDAO extends CRUDHibernateDAO<Address,Integer>{

    public AddressDAO(EntityManager entityManager) {

        super(entityManager);
        setEntityClass(Address.class);
    }
}
