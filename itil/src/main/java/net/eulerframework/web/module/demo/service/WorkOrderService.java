package net.eulerframework.web.module.demo.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.eulerframework.web.core.base.request.easyuisupport.EasyUiQueryReqeuset;
import net.eulerframework.web.core.base.response.easyuisupport.EasyUIPageResponse;
import net.eulerframework.web.core.base.service.impl.BaseService;
import net.eulerframework.web.module.demo.dao.TechnicianDao;
import net.eulerframework.web.module.demo.dao.QueueDefinitionDao;
import net.eulerframework.web.module.demo.dao.StatusDefinitionDao;
import net.eulerframework.web.module.demo.dao.WorkOrderChargeDao;
import net.eulerframework.web.module.demo.dao.WorkOrderDao;
import net.eulerframework.web.module.demo.entity.Technician;
import net.eulerframework.web.module.demo.entity.QueueDefinition;
import net.eulerframework.web.module.demo.entity.StatusDefinition;
import net.eulerframework.web.module.demo.entity.WorkOrder;
import net.eulerframework.web.module.demo.entity.WorkOrderCharge;

@Service
public class WorkOrderService extends BaseService {
    @Resource TechnicianDao technicianDao;
    @Resource WorkOrderDao workOrderDao;
    @Resource WorkOrderChargeDao workOrderChargeDao;
    @Resource StatusDefinitionDao statusDefinitionDao;
    @Resource QueueDefinitionDao queueDefinitionDao;
    
    public Map<String, String> findResources() {
        return this.workOrderDao.findAllResources();
    }
    

    public List<Technician> findTechnicians() {
        return this.technicianDao.findTechnicians();
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

    public List<WorkOrderCharge> loadChargesByWorkOrderId(long workOrderId, String desc, String removedArtifactName, String owner, String begin, String end) {
        return this.workOrderChargeDao.loadChargesByWorkOrderId(
                workOrderId,
                desc,
                removedArtifactName,
                owner,
                begin,
                end);
    }
}
