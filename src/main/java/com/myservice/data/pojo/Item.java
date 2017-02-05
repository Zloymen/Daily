package com.myservice.data.pojo;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Zloy on 04.02.2017.
 */
@Entity
@Table(name = "item", schema = "calendar", catalog = "")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    @Basic
    @Column(name = "name_group", nullable = false, insertable = true, updatable = true, length = 50)
    private String nameItem;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "text")
    @Lob
    private String text;

    @Basic
    @Column(name = "file_name")
    private String nameFile;

    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "file_content")
    private byte[] contentFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @PrePersist
    public void setPersistCreateDate() {
        this.createDate = LocalDateTime.now();
    }

    @PreUpdate
    @PrePersist
    public void setPersistUpdateDate() {
        this.createDate = LocalDateTime.now();
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public byte[] getContentFile() {
        return contentFile;
    }

    public void setContentFile(byte[] contentFile) {
        this.contentFile = contentFile;
    }
}
