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
    
    @Id
    @Column(name = "WORKORDERID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

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

    @Override
    public int compareTo(WorkOrder o) {
        return this.getId().compareTo(o.getId());
    }
}
