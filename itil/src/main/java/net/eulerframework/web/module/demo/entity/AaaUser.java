package net.eulerframework.web.module.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import net.eulerframework.web.core.base.entity.NonIDEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "AaaUser")
public class AaaUser extends NonIDEntity<AaaUser> {

    // 状态ID
    @Id
    @Column(name = "USER_ID")
    private Long id;
    // 状态名称
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Override
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setSerializableId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public int compareTo(AaaUser o) {
        return this.getId().compareTo(o.getId());
    }

}
