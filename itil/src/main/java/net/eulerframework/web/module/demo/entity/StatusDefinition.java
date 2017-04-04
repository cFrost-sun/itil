package net.eulerframework.web.module.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import net.eulerframework.web.core.base.entity.NonIDEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "StatusDefinition")
public class StatusDefinition extends NonIDEntity<StatusDefinition> {

    // 状态ID
    @Id
    @Column(name = "STATUSID")
    private Long id;
    // 状态名称
    @Column(name = "STATUSNAME")
    private String name;
    // 状态颜色
    @Column(name = "STATUSCOLOR")
    private String color;
    // 状态颜色
    @Column(name = "ISDELETED")
    private Boolean deleted;

    @Override
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public void setSerializableId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public int compareTo(StatusDefinition o) {
        return this.getId().compareTo(o.getId());
    }

}
