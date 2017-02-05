package com.myservice.data.pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Zloy on 04.02.2017.
 */

@Entity
@Table(name = "group", schema = "calendar", catalog = "")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;

    @Basic
    @Column(name = "name_group", nullable = false, insertable = true, updatable = true, length = 50)
    private String nameGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn(name = "parent_id")
    private Group parentGroup;

    @OneToMany( fetch = FetchType.EAGER )
    @JoinColumn(name = "parent_id")
    private java.util.Set<Group> childrenGroup = new java.util.HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Group getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(Group parentGroup) {
        this.parentGroup = parentGroup;
    }

    public Set<Group> getChildrenGroup() {
        return childrenGroup;
    }

    public void setChildrenGroup(Set<Group> childrenGroup) {
        this.childrenGroup = childrenGroup;
    }
}
