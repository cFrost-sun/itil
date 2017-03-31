package net.eulerframework.web.module.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.eulerframework.web.core.base.service.impl.BaseService;
import net.eulerframework.web.module.demo.dao.WorkOrderDao;
import net.eulerframework.web.module.demo.entity.WorkOrder;

@Service
public class WorkOrderService extends BaseService {

    @Resource WorkOrderDao workOrderDao;
    
    public WorkOrder findWorkOrder(long id) {
        return this.workOrderDao.load(id);
    }
}
