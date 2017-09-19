package com.capgemini.persistence.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.capgemini.common.datatypes.enumerations.Category;

/**
 * Artifact Entity
 * @author CWOJTOWI
 */
@Entity
public class Artifact {

    @Id
    @GeneratedValue
    private Long id;

    private Date creationDate;

    @Size(max = 32)
    private String name;

    @Enumerated(EnumType.STRING)
    private Category type;

    @Size(max = 128)
    private String description;

    public Artifact() {

    }

    public Artifact(Long id, Date creationDate, String name, Category type, String description) {
        this.id = id;
        this.creationDate = creationDate;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getType() {
        return type;
    }

    public void setType(Category type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
