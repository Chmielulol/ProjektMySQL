package com.jchmielewski.pks.DAO;

import com.jchmielewski.pks.entity.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PackageDAO extends CRUDHibernateDAO<Package,Integer>{

    @Autowired
    public PackageDAO(EntityManager entityManager) {
        super(entityManager);
        setEntityClass(Package.class);
    }
}
