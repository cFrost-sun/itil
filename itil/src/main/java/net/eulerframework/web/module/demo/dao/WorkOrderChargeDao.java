package net.eulerframework.web.module.demo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import net.eulerframework.web.core.base.dao.impl.hibernate5.BaseDao;
import net.eulerframework.web.module.demo.entity.WorkOrderCharge;

public class WorkOrderChargeDao extends BaseDao<WorkOrderCharge> {

    public List<WorkOrderCharge> loadChargesByWorkOrderId(long workOrderId) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);
        detachedCriteria.add(Restrictions.eq("workerOrderId", workOrderId));
        detachedCriteria.addOrder(Order.desc("createdTime"));
        return this.query(detachedCriteria);
    }  

}
