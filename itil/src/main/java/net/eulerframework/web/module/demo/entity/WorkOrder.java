package net.eulerframework.web.module.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import net.eulerframework.web.core.base.entity.NonIDEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "V_WORK_ORDER")
public class WorkOrder extends NonIDEntity<WorkOrder> {

    // 请求ID
    @Id
    @Column(name = "WORKORDER_ID")
    private Long id;

    // 创建时间
    @Column(name = "CREATED_TIME")
    private Long createdTime;

    // 逾期时间
    @Column(name = "DUEBY_TIME")
    private Long duebyTime;

    // 最后更新时间
    @Column(name = "UPDATE_TIME")
    private Long updateTime;

    // 主题
    @Column(name = "TITLE")
    private String title;

    // 地点 ID
    @Column(name = "SITE_ID")
    private Long siteId;

    // 地点
    @Column(name = "SITE_NAME")
    private String siteName;

    // 机型Resource
    @Column(name = "RESOURCE")
    private String resource;

    // 需求类型
    @Column(name = "TYPE")
    private String type;

    // 停机时间
    @Column(name = "DOWN_TIME")
    private Double downTime;

    // 关联请求ID
    @Column(name = "LINKED_REQ_ID")
    private String linkedRequestId;

    // 航材处理状态
    @Column(name = "MR_STATUS")
    private String mrStatus;

    // 中断次数
    @Column(name = "HOLD_TIME")
    private Long holdTime;

    // 动作类型
    @Column(name = "ACT_TYPE")
    private String actionType;

    // 退料处理状态
    @Column(name = "RETURN_MATERIAL_STATUS")
    private String returnMaterialStatus;

    // Me订件数量
    @Column(name = "ME_ORDER_COUNT")
    private Long meOrderCount;

    // 优先级 ID
    @Column(name = "PRIORITY_ID")
    private Long priorityId;

    // 优先级
    @Column(name = "PRIORITY_NAME")
    private String priorityName;

    // 指派给 ID
    @Column(name = "OWNER_ID")
    private Long ownerId;

    // 指派给
    @Column(name = "OWNER_NAME")
    private String ownerName;

    // 状态 ID
    @Column(name = "STATUS_ID")
    private Long statusId;

    // 状态
    @Column(name = "STATUS_NAME")
    private String statusName;

    // 工作组 ID
    @Column(name = "QUEUE_ID")
    private Long queueId;

    // 工作组
    @Column(name = "QUEUE_NAME")
    private String queueName;

    @Override
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Long getDuebyTime() {
        return duebyTime;
    }

    public void setDuebyTime(Long duebyTime) {
        this.duebyTime = duebyTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getDownTime() {
        return downTime;
    }

    public void setDownTime(Double downTime) {
        this.downTime = downTime;
    }

    public String getLinkedRequestId() {
        return linkedRequestId;
    }

    public void setLinkedRequestId(String linkedRequestId) {
        this.linkedRequestId = linkedRequestId;
    }

    public String getMrStatus() {
        return mrStatus;
    }

    public void setMrStatus(String mrStatus) {
        this.mrStatus = mrStatus;
    }

    public Long getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(Long holdTime) {
        this.holdTime = holdTime;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getReturnMaterialStatus() {
        return returnMaterialStatus;
    }

    public void setReturnMaterialStatus(String returnMaterialStatus) {
        this.returnMaterialStatus = returnMaterialStatus;
    }

    public Long getMeOrderCount() {
        return meOrderCount;
    }

    public void setMeOrderCount(Long meOrderCount) {
        this.meOrderCount = meOrderCount;
    }

    public Long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Long priorityId) {
        this.priorityId = priorityId;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    @Override
    public int compareTo(WorkOrder o) {
        return this.getId().compareTo(o.getId());
    }
}
