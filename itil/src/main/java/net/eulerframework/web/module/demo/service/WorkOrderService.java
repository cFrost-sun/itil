package net.eulerframework.web.module.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.eulerframework.web.core.base.request.easyuisupport.EasyUiQueryReqeuset;
import net.eulerframework.web.core.base.response.easyuisupport.EasyUIPageResponse;
import net.eulerframework.web.core.base.service.impl.BaseService;
import net.eulerframework.web.module.demo.dao.WorkOrderChargeDao;
import net.eulerframework.web.module.demo.dao.WorkOrderDao;
import net.eulerframework.web.module.demo.entity.WorkOrder;
import net.eulerframework.web.module.demo.entity.WorkOrderCharge;

@Service
public class WorkOrderService extends BaseService {

    @Resource WorkOrderDao workOrderDao;
    @Resource WorkOrderChargeDao workOrderChargeDao;
    
    public WorkOrder findWorkOrder(long id) {
        return this.workOrderDao.load(id);
    }

    public EasyUIPageResponse<WorkOrder> queryWorkerOrderByPage(EasyUiQueryReqeuset easyUiQueryReqeuset) {
        return this.workOrderDao.pageQuery(easyUiQueryReqeuset);
    }

    public List<WorkOrderCharge> loadChargesByWorkOrderId(long workOrderId) {
        return this.workOrderChargeDao.loadChargesByWorkOrderId(workOrderId);
    }
}
