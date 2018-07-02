/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hossam.persistence.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.hossam.exception.types.PersistenceException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.apache.bcel.generic.Tag;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Hossam ElDeen
 */
public abstract class AbstractDao extends HibernateDaoSupport{
    @Transactional
    public Object load(Class entity, Serializable id){
        if(entity == null){
            throw new IllegalArgumentException("data have to be initialized before being passed to load method can not be null");
        }
        try{
            Object object = getHibernateTemplate().get(entity, id);
            return object;
        }catch(RuntimeException ex){
            throw new PersistenceException("unable to load an object of class "+entity.getName()+" because \n"+ex.toString());
        }
    }
    
    @Transactional
    public Object load(Class entity,int id){
        if(entity == null){
            throw new IllegalArgumentException("data have to be initialized before being passed to load method can not be null");
        }
        try{
            Object object = getHibernateTemplate().get(entity, id);
            return object;
        }catch(RuntimeException ex){
            throw new PersistenceException("unable to load an object of class "+entity.getName()+" because \n"+ex.toString());
        }
    }
    
    @Transactional
    public Object load(Class entity,String id){
        if(entity == null){
            throw new IllegalArgumentException("data have to be initialized before being passed to load method can not be null");
        }
        try{
            Object object = getHibernateTemplate().get(entity, id);
            return object;
        }catch(RuntimeException ex){
            throw new PersistenceException("unable to load an object of class "+entity.getName()+" because \n"+ex.toString());
        }
    }
    
    @Transactional
    public Object loadWithProperty(Class entity, String property, Object value){
        if(entity == null){
            throw new IllegalArgumentException("data have to be initialized before being passed to load method can not be null");
        }
        try{
            Criteria cr = getSessionFactory().getCurrentSession().createCriteria(entity);
            cr.add(Restrictions.eq(property, value));
            List result = cr.list();
            if(result==null || result.isEmpty()){
                return null;
            }else{
                return result;
            }
        }catch(RuntimeException ex){
            throw new PersistenceException("unable to load an object of class "+entity.getName()+" because \n"+ex.toString());
        }
    }
    
    @Transactional
    public Object loadWithLikeProperty(Class entity, String property, Object value){
        if(entity == null){
            throw new IllegalArgumentException("data have to be initialized before being passed to load method can not be null");
        }
        try{
            Criteria cr = getSessionFactory().getCurrentSession().createCriteria(entity);
            cr.add(Restrictions.like(property, value));
            List result = cr.list();
            if(result==null || result.isEmpty()){
                return null;
            }else{
                return result;
            }
        }catch(RuntimeException ex){
            throw new PersistenceException("unable to load an object of class "+entity.getName()+" because \n"+ex.toString());
        }
    }
    
    @Transactional
    public void save(Object obj){  
        if(obj == null){
            throw new IllegalArgumentException("Object of "+obj.getClass().getName()+" passed to save method can not be null");
        }
        try{
            getHibernateTemplate().save(obj);
        }catch(RuntimeException ex){
            throw new PersistenceException("unable to save an object of class "+obj.getClass().getName()+" because \n"+ex.toString());
        }
    }  
    
    @Transactional
    public void update(Object obj){
        if(obj == null){
            throw new IllegalArgumentException("Object of "+obj.getClass().getName()+" passed to update method can not be null");
        }
        try{
            getHibernateTemplate().update(obj);
        }catch(RuntimeException ex){
            throw new PersistenceException("unable to update an object of class "+obj.getClass().getName()+" because \n"+ex.toString());
        }
    }  
     
    @Transactional
    public void delete(Object obj){  
        if(obj == null){
            throw new IllegalArgumentException("Object of "+obj.getClass().getName()+" passed to delete method can not be null");
        }
        try{
            getHibernateTemplate().delete(obj); 
        }catch(RuntimeException ex){
            throw new PersistenceException("unable to delete an object of class "+obj.getClass().getName()+" because \n"+ex.toString());
        }
    }
    
    @Transactional
    public void refresh(Object obj){
        if(obj == null){
            throw new IllegalArgumentException("Object of "+obj.getClass().getName()+" passed to refresh method can not be null");
        }
        try{
            getHibernateTemplate().refresh(obj);
        }catch(RuntimeException ex){
            throw new PersistenceException("unable to refresh an object of class "+obj.getClass().getName()+" because \n"+ex.toString());
        }
    }
  
}
