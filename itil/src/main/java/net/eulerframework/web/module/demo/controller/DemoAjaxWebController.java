package net.eulerframework.web.module.demo.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.eulerframework.web.core.annotation.WebController;
import net.eulerframework.web.core.base.controller.AjaxSupportWebController;
import net.eulerframework.web.core.base.request.easyuisupport.EasyUiQueryReqeuset;
import net.eulerframework.web.core.base.response.easyuisupport.EasyUIPageResponse;
import net.eulerframework.web.module.demo.entity.Technician;
import net.eulerframework.web.module.demo.entity.QueueDefinition;
import net.eulerframework.web.module.demo.entity.StatusDefinition;
import net.eulerframework.web.module.demo.entity.WorkOrder;
import net.eulerframework.web.module.demo.entity.WorkOrderCharge;
import net.eulerframework.web.module.demo.service.WorkOrderService;

@WebController
@RequestMapping("/")
public class DemoAjaxWebController extends AjaxSupportWebController {
    
    @Resource WorkOrderService workOrderService;
    
    
    @RequestMapping(value ="findResources_ajax", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> findResources(){
        return this.workOrderService.findResources();
    }

    @RequestMapping(value ="findTechnicians_ajax", method = RequestMethod.GET)
    @ResponseBody
    public List<Technician> findTechnicians(){
        return this.workOrderService.findTechnicians();
    }
    
    @RequestMapping(value ="findQueueDefinitions_ajax", method = RequestMethod.GET)
    @ResponseBody
    public List<QueueDefinition> findQueueDefinitions(){
        return this.workOrderService.findQueueDefinitions();
    }
    
    @RequestMapping(value ="findStatusDefinitions_ajax", method = RequestMethod.GET)
    @ResponseBody
    public List<StatusDefinition> findStatusDefinitions(){
        return this.workOrderService.findStatusDefinitions();
    }
    
    @RequestMapping(value ="loadChargesByWorkOrderId_ajax", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIPageResponse<WorkOrderCharge> loadChargesByWorkOrderId(long workOrderId){        
        List<WorkOrderCharge> ret = this.workOrderService.loadChargesByWorkOrderId(workOrderId);
        return new EasyUIPageResponse<>(ret, ret == null ? 0 : ret.size(), 1, ret == null ? 0 : ret.size());
    }
    
    @RequestMapping(value ="queryWorkerOrderByPage_ajax")
    @ResponseBody
    public EasyUIPageResponse<WorkOrder> queryWorkerOrderByPage(){
        return this.workOrderService.queryWorkerOrderByPage(new EasyUiQueryReqeuset(this.getRequest()));
    }
}
