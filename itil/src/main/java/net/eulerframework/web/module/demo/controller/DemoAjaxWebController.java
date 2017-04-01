package net.eulerframework.web.module.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.eulerframework.web.core.annotation.WebController;
import net.eulerframework.web.core.base.controller.JspSupportWebController;
import net.eulerframework.web.core.base.request.easyuisupport.EasyUiQueryReqeuset;
import net.eulerframework.web.core.base.response.easyuisupport.EasyUIPageResponse;
import net.eulerframework.web.module.demo.entity.WorkOrder;
import net.eulerframework.web.module.demo.service.WorkOrderService;

@WebController
@RequestMapping("/")
public class DemoAjaxWebController extends JspSupportWebController {
    
    @Resource WorkOrderService workOrderService;
    

    @RequestMapping(value ="workOrder/{id}", method = RequestMethod.GET)
    @ResponseBody
    public WorkOrder saveWorkType(@PathVariable("id") long id){
        return this.workOrderService.findWorkOrder(id);
    }
    
    @RequestMapping(value ="queryWorkerOrderByPage_ajax")
    @ResponseBody
    public EasyUIPageResponse<WorkOrder> queryWorkerOrderByPage(){
        return this.workOrderService.queryWorkerOrderByPage(new EasyUiQueryReqeuset(this.getRequest()));
    }
}
