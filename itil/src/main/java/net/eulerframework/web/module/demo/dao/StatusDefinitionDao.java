package net.eulerframework.web.module.demo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import net.eulerframework.web.core.base.dao.impl.hibernate5.BaseDao;
import net.eulerframework.web.module.demo.entity.StatusDefinition;

public class StatusDefinitionDao extends BaseDao<StatusDefinition> {

    public List<StatusDefinition> loadStatusDefinitions() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);
        detachedCriteria.add(Restrictions.eq("deleted", false));
        detachedCriteria.addOrder(Order.asc("name"));
        return this.query(detachedCriteria);
    }  

}
