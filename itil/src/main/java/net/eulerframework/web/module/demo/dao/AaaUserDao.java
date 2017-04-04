package net.eulerframework.web.module.demo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import net.eulerframework.web.core.base.dao.impl.hibernate5.BaseDao;
import net.eulerframework.web.module.demo.entity.AaaUser;

public class AaaUserDao extends BaseDao<AaaUser> {

    public List<AaaUser> findAaaUsers() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);
        detachedCriteria.addOrder(Order.asc("firstName"));
        return this.query(detachedCriteria);
    }  

}
