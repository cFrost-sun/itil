package net.eulerframework.web.module.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import net.eulerframework.web.core.base.entity.NonIDEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "V_WORK_ORDER_CHARGE")
public class WorkOrderCharge extends NonIDEntity<WorkOrderCharge> {

    // 任务日志ID
    @Id
    @Column(name = "CHARGE_ID")
    private Long id;
    
    // 请求ID
    @Column(name = "WORKORDER_ID")
    private Long workerOrderId;
    
    // 所有者ID
    @Column(name = "TECHNICIAN_ID")
    private Long technicianId;
    
    // 创建者ID
    @Column(name = "CREATEDBY_ID")
    private Long createdById;

    // 描述
    @Column(name = "DESCRIPTION")
    private String description;

    // 解决问题所用的时间(毫秒)
    @Column(name = "TIMESPENT")
    private Long timeSpent;
    
    // 创建时间
    @Column(name = "CREATED_TIME")
    private Long createdTime;
    
    // 开始时间
    @Column(name = "TS_STARTTIME")
    private Long tsStartTime;

    // 结束时间
    @Column(name = "TS_ENDTIME")
    private Long tsEndTime;

    // 拆下部件名称
    @Column(name = "REMOVED_ARTIFACT_NAME")
    private String removedArtifactName;

    // 拆下部件件号 P/N
    @Column(name = "REMOVED_ARTIFACT_PN")
    private String removedArtifactPn;

    // 拆下部件序号 S/N
    @Column(name = "REMOVED_ARTIFACT_SN")
    private String removedArtifactSn
    ;

    // 机停机时间-日志(Minutes)
    @Column(name = "DOWN_TIME")
    private Long downTime;

    // 安装/维修部件名称
    @Column(name = "INSTALLED_ARTIFACT_NAME")
    private String installedArtifactName;

    // 安装/维修部件件号 P/N
    @Column(name = "INSTALLED_ARTIFACT_PN")
    private String installedArtifactPn;

    // 安装/维修部件序号 S/N
    @Column(name = "INSTALLED_ARTIFACT_SN")
    private String installedArtifactSn;

    // 丢失时间-日志(Minutes)
    @Column(name = "LOST_TIME")
    private Long lostTime;

    // 所有者
    @Column(name = "OWNER_FIRST_NAME")
    private String ownerName;

    // 创建人
    @Column(name = "CREATEBY_FIRST_NAME")
    private String createbyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkerOrderId() {
        return workerOrderId;
    }

    public void setWorkerOrderId(Long workerOrderId) {
        this.workerOrderId = workerOrderId;
    }

    public Long getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Long technicianId) {
        this.technicianId = technicianId;
    }

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Long timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Long getTsEndTime() {
        return tsEndTime;
    }

    public void setTsEndTime(Long tsEndTime) {
        this.tsEndTime = tsEndTime;
    }

    public String getRemovedArtifactName() {
        return removedArtifactName;
    }

    public void setRemovedArtifactName(String removedArtifactName) {
        this.removedArtifactName = removedArtifactName;
    }

    public String getRemovedArtifactPn() {
        return removedArtifactPn;
    }

    public void setRemovedArtifactPn(String removedArtifactPn) {
        this.removedArtifactPn = removedArtifactPn;
    }

    public String getRemovedArtifactSn() {
        return removedArtifactSn;
    }

    public void setRemovedArtifactSn(String removedArtifactSn) {
        this.removedArtifactSn = removedArtifactSn;
    }

    public Long getDownTime() {
        return downTime;
    }

    public void setDownTime(Long downTime) {
        this.downTime = downTime;
    }

    public String getInstalledArtifactName() {
        return installedArtifactName;
    }

    public void setInstalledArtifactName(String installedArtifactName) {
        this.installedArtifactName = installedArtifactName;
    }

    public String getInstalledArtifactPn() {
        return installedArtifactPn;
    }

    public void setInstalledArtifactPn(String installedArtifactPn) {
        this.installedArtifactPn = installedArtifactPn;
    }

    public String getInstalledArtifactSn() {
        return installedArtifactSn;
    }

    public void setInstalledArtifactSn(String installedArtifactSn) {
        this.installedArtifactSn = installedArtifactSn;
    }

    public Long getLostTime() {
        return lostTime;
    }

    public void setLostTime(Long lostTime) {
        this.lostTime = lostTime;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCreatebyName() {
        return createbyName;
    }

    public void setCreatebyName(String createbyName) {
        this.createbyName = createbyName;
    }

    @Override
    public int compareTo(WorkOrderCharge o) {
        return this.getId().compareTo(o.getId());
    }
}
