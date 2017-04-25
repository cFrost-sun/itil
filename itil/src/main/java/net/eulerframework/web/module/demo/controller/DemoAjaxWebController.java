package net.eulerframework.web.module.demo.controller;

import java.util.ArrayList;
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
    public List<SelectDataVO> findTechnicians(){
        List<Technician> list = this.workOrderService.findTechnicians();
        
        List<SelectDataVO> ret = new ArrayList<>();        
        ret.add(SelectDataVO.ALL);        
        if(list != null) {
            for(Technician each : list) {
                SelectDataVO data = new SelectDataVO(each);
                ret.add(data);
            }
        }
        
        return ret;
    }
    
    public static class SelectDataVO {
        public final static SelectDataVO ALL = new SelectDataVO();
        private String id;
        private String value;
        public String getId() {
            return id;
        }
        public String getValue() {
            return value;
        }
        
        private SelectDataVO() {
            this.id = "";
            this.value = "不限";
        }
        public SelectDataVO(Technician technician) {
            this.value = technician.getFirstName();
            this.id = technician.getId() == null ? "" : technician.getId().toString();
        }
        public SelectDataVO(QueueDefinition data) {
            this.value = data.getName();
            this.id = data.getId() == null ? "" : data.getId().toString();
        }
        public SelectDataVO(StatusDefinition data) {
            this.value = data.getName();
            this.id = data.getId() == null ? "" : data.getId().toString();
        }
    }
    
    @RequestMapping(value ="findQueueDefinitions_ajax", method = RequestMethod.GET)
    @ResponseBody
    public List<SelectDataVO> findQueueDefinitions(){
        List<QueueDefinition> list = this.workOrderService.findQueueDefinitions();
        
        List<SelectDataVO> ret = new ArrayList<>();        
        ret.add(SelectDataVO.ALL);        
        if(list != null) {
            for(QueueDefinition each : list) {
                SelectDataVO data = new SelectDataVO(each);
                ret.add(data);
            }
        }
        
        return ret;
    }
    
    @RequestMapping(value ="findStatusDefinitions_ajax", method = RequestMethod.GET)
    @ResponseBody
    public List<SelectDataVO> findStatusDefinitions(){
        List<StatusDefinition> list = this.workOrderService.findStatusDefinitions();
        
        List<SelectDataVO> ret = new ArrayList<>();        
        ret.add(SelectDataVO.ALL);        
        if(list != null) {
            for(StatusDefinition each : list) {
                SelectDataVO data = new SelectDataVO(each);
                ret.add(data);
            }
        }
        
        return ret;
    }
    
    @RequestMapping(value ="loadChargesByWorkOrderId_ajax", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIPageResponse<WorkOrderCharge> loadChargesByWorkOrderId(
            long workOrderId,
            String desc,
            String removedArtifactName,
            String owner,
            String begin,
            String end){        
        List<WorkOrderCharge> ret = this.workOrderService.loadChargesByWorkOrderId(
                workOrderId,
                desc,
                removedArtifactName,
                owner,
                begin,
                end);
        return new EasyUIPageResponse<>(ret, ret == null ? 0 : ret.size(), 1, ret == null ? 0 : ret.size());
    }
    
    @RequestMapping(value ="queryWorkerOrderByPage_ajax")
    @ResponseBody
    public EasyUIPageResponse<WorkOrder> queryWorkerOrderByPage(){
        return this.workOrderService.queryWorkerOrderByPage(new EasyUiQueryReqeuset(this.getRequest()));
    }
}
