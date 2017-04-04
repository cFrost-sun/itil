package net.eulerframework.web.module.demo.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import net.eulerframework.web.core.base.dao.impl.hibernate5.BaseDao;
import net.eulerframework.web.module.demo.entity.WorkOrderCharge;

public class WorkOrderChargeDao extends BaseDao<WorkOrderCharge> {
    
    public Set<Long> findChargeIdsByRemovedArtifactName(String removedArtifactName){
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);
        detachedCriteria.add(Restrictions.like("removedArtifactName", removedArtifactName, MatchMode.ANYWHERE).ignoreCase());
        List<WorkOrderCharge> charges = this.query(detachedCriteria);       
        Set<Long> ret = new HashSet<>();
        if(charges != null) {
            for(WorkOrderCharge c : charges) {
                ret.add(c.getWorkerOrderId());
            }
        }
        return ret;
    }
    

    
    public Set<Long> findChargeIdsByDesc(String desc){
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);
        detachedCriteria.add(Restrictions.like("description", desc, MatchMode.ANYWHERE));
        List<WorkOrderCharge> charges = this.query(detachedCriteria);       
        Set<Long> ret = new HashSet<>();
        if(charges != null) {
            for(WorkOrderCharge c : charges) {
                ret.add(c.getWorkerOrderId());
            }
        }
        return ret;
    }

    public List<WorkOrderCharge> loadChargesByWorkOrderId(long workOrderId) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);
        detachedCriteria.add(Restrictions.eq("workerOrderId", workOrderId));
        detachedCriteria.addOrder(Order.desc("createdTime"));
        return this.query(detachedCriteria);
    }

    public Set<Long> findChargeIdsByOwnerId(long technicianId) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);
        detachedCriteria.add(Restrictions.eq("technicianId", technicianId));
        List<WorkOrderCharge> charges = this.query(detachedCriteria);       
        Set<Long> ret = new HashSet<>();
        if(charges != null) {
            for(WorkOrderCharge c : charges) {
                ret.add(c.getWorkerOrderId());
            }
        }
        return ret;
    }  

    public Set<Long> findChargeIdsByCreateTime(Date begin, Date end) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);
        if(begin != null)
            detachedCriteria.add(Restrictions.ge("createdTime", begin.getTime()));
        if(end != null)
            detachedCriteria.add(Restrictions.le("createdTime", end.getTime()));
        List<WorkOrderCharge> charges = this.query(detachedCriteria);       
        Set<Long> ret = new HashSet<>();
        if(charges != null) {
            for(WorkOrderCharge c : charges) {
                ret.add(c.getWorkerOrderId());
            }
        }
        return ret;
    }

}
