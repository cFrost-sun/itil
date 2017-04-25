package net.eulerframework.web.module.demo.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import net.eulerframework.common.util.DateUtils;
import net.eulerframework.common.util.StringUtils;
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

    public List<WorkOrderCharge> loadChargesByWorkOrderId(long workOrderId, String desc, String removedArtifactName, String owner, String begin, String end) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);
        detachedCriteria.add(Restrictions.eq("workerOrderId", workOrderId));
        
        if(StringUtils.hasText(desc))
            detachedCriteria.add(Restrictions.like("description", desc, MatchMode.ANYWHERE));
        if(StringUtils.hasText(removedArtifactName))
            detachedCriteria.add(Restrictions.like("removedArtifactName", removedArtifactName, MatchMode.ANYWHERE));
        if(StringUtils.hasText(owner))
            detachedCriteria.add(Restrictions.eq("technicianId", Long.parseLong(owner)));
        
        try {
            if(StringUtils.hasText(begin))
                detachedCriteria.add(Restrictions.ge("createdTime", DateUtils.parseDate(begin, "yyyy-MM-dd HH:mm:ss").getTime()));
            if(StringUtils.hasText(end))
                    detachedCriteria.add(Restrictions.le("createdTime", DateUtils.parseDate(end, "yyyy-MM-dd HH:mm:ss").getTime()));
        } catch (ParseException e) {
            // DONOTHING
        }
        
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
