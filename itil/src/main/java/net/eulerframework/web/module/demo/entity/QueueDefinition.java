package net.eulerframework.web.module.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import net.eulerframework.web.core.base.entity.NonIDEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "QueueDefinition")
public class QueueDefinition extends NonIDEntity<QueueDefinition> {

    // 状态ID
    @Id
    @Column(name = "QUEUEID")
    private Long id;
    // 状态名称
    @Column(name = "QUEUENAME")
    private String name;

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

    @Override
    public void setSerializableId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public int compareTo(QueueDefinition o) {
        return this.getId().compareTo(o.getId());
    }

}
