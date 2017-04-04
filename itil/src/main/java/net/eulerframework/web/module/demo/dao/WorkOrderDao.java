package net.eulerframework.web.module.demo.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import net.eulerframework.common.util.DateUtils;
import net.eulerframework.common.util.StringUtils;
import net.eulerframework.web.core.base.dao.impl.hibernate5.BaseDao;
import net.eulerframework.web.core.base.request.QueryRequest;
import net.eulerframework.web.core.base.request.QueryRequest.QueryMode;
import net.eulerframework.web.core.base.request.easyuisupport.EasyUiQueryReqeuset;
import net.eulerframework.web.core.base.response.easyuisupport.EasyUIPageResponse;
import net.eulerframework.web.module.demo.entity.WorkOrder;

public class WorkOrderDao extends BaseDao<WorkOrder> {

    public EasyUIPageResponse<WorkOrder> pageQuery(EasyUiQueryReqeuset queryRequest) {
        DetachedCriteria totalCriteria = this.analyzeQueryRequestWithoutOrder(queryRequest);
        DetachedCriteria detachedCriteria = this.analyzeQueryRequest(queryRequest);
        
        String filterValue = null;
        filterValue = queryRequest.getFilterValue("begin");
        if(StringUtils.hasText(filterValue)) {
            try {
                totalCriteria.add(Restrictions.ge("createdTime", DateUtils.parseDate(filterValue, "yyyy-MM-dd HH:mm:ss").getTime()));
                detachedCriteria.add(Restrictions.ge("createdTime", DateUtils.parseDate(filterValue, "yyyy-MM-dd HH:mm:ss").getTime()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        filterValue = queryRequest.getFilterValue("end");
        if(StringUtils.hasText(filterValue)) {
            try {
                totalCriteria.add(Restrictions.le("createdTime", DateUtils.parseDate(filterValue, "yyyy-MM-dd HH:mm:ss").getTime()));
                detachedCriteria.add(Restrictions.le("createdTime", DateUtils.parseDate(filterValue, "yyyy-MM-dd HH:mm:ss").getTime()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        
        totalCriteria.setProjection(Projections.rowCount());
        long total = ((Long)totalCriteria.getExecutableCriteria(this.getSessionFactory().getCurrentSession()).list().get(0)).longValue();
        
        
        int pageIndex = queryRequest.getPageIndex();
        int pageSize = queryRequest.getPageSize();
        return this.pageQuery(detachedCriteria, pageIndex, pageSize, total);
    }
    
    
    
    
    
    
    
    
    protected EasyUIPageResponse<WorkOrder> pageQuery(DetachedCriteria detachedCriteria, int pageIndex, int pageSize, long total) {
        
        Criteria criteria = detachedCriteria.getExecutableCriteria(this.getSessionFactory().getCurrentSession());
        criteria.setFirstResult((pageIndex - 1) * pageSize);
        criteria.setMaxResults(pageSize);
        @SuppressWarnings("unchecked")
        List<WorkOrder> result = criteria.list();
        evict(result);
        return new EasyUIPageResponse<>(result, total, pageIndex, pageSize);
    }
    
    private DetachedCriteria analyzeQueryRequestWithoutOrder(QueryRequest queryRequest) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);
        
        Map<String, String> queryMap = queryRequest.getQueryMap();
        
        if(queryRequest.useOr()) {
            List<Criterion> criterions = new ArrayList<>();
            
            for (Map.Entry<String, String> entry : queryMap.entrySet()) {
                String property = entry.getKey();
                String value = entry.getValue();
                
                if(StringUtils.isNull(value))
                    continue;
                
                QueryMode queryMode = queryRequest.getQueryMode(property);
                try {
                    criterions.add(this.generateRestriction(property, value, queryMode));
                } catch (NumberFormatException e) {
                    this.logger.warn(e.getMessage() + " property:" + property);
                }
            }
            
            detachedCriteria.add(Restrictions.or(criterions.toArray(new Criterion [0])));
        } else {
            for (Map.Entry<String, String> entry : queryMap.entrySet()) {
                String property = entry.getKey();
                String value = entry.getValue();
                
                if(StringUtils.isNull(value))
                    continue;
                
                QueryMode queryMode = queryRequest.getQueryMode(property);
                detachedCriteria.add(this.generateRestriction(property, value, queryMode));
            }            
        }
        return detachedCriteria;
    }

}
