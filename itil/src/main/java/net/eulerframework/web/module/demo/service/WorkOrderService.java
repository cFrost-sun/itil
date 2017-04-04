package net.eulerframework.web.module.demo.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.eulerframework.web.core.base.request.easyuisupport.EasyUiQueryReqeuset;
import net.eulerframework.web.core.base.response.easyuisupport.EasyUIPageResponse;
import net.eulerframework.web.core.base.service.impl.BaseService;
import net.eulerframework.web.module.demo.dao.AaaUserDao;
import net.eulerframework.web.module.demo.dao.QueueDefinitionDao;
import net.eulerframework.web.module.demo.dao.StatusDefinitionDao;
import net.eulerframework.web.module.demo.dao.WorkOrderChargeDao;
import net.eulerframework.web.module.demo.dao.WorkOrderDao;
import net.eulerframework.web.module.demo.entity.AaaUser;
import net.eulerframework.web.module.demo.entity.QueueDefinition;
import net.eulerframework.web.module.demo.entity.StatusDefinition;
import net.eulerframework.web.module.demo.entity.WorkOrder;
import net.eulerframework.web.module.demo.entity.WorkOrderCharge;

@Service
public class WorkOrderService extends BaseService {
    @Resource AaaUserDao aaaUserDao;
    @Resource WorkOrderDao workOrderDao;
    @Resource WorkOrderChargeDao workOrderChargeDao;
    @Resource StatusDefinitionDao statusDefinitionDao;
    @Resource QueueDefinitionDao queueDefinitionDao;
    
    public Map<String, String> findResources() {
        return this.workOrderDao.findAllResources();
    }
    

    public List<AaaUser> findAaaUsers() {
        return this.aaaUserDao.findAaaUsers();
    }
    
    public List<QueueDefinition> findQueueDefinitions() {
        return this.queueDefinitionDao.findQueueDefinitions();
    }
    
    public List<StatusDefinition> findStatusDefinitions() {
        return this.statusDefinitionDao.loadStatusDefinitions();
    }

    public EasyUIPageResponse<WorkOrder> queryWorkerOrderByPage(EasyUiQueryReqeuset easyUiQueryReqeuset) {
        return this.workOrderDao.pageQuery(easyUiQueryReqeuset);
    }

    public List<WorkOrderCharge> loadChargesByWorkOrderId(long workOrderId) {
        return this.workOrderChargeDao.loadChargesByWorkOrderId(workOrderId);
    }
}
