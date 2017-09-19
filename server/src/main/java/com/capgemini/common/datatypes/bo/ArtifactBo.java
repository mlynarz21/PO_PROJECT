package com.capgemini.common.datatypes.bo;

import java.util.Date;

import com.capgemini.common.datatypes.enumerations.Category;

/**
 * Artifact Business Object
 * @author CWOJTOWI
 */
public class ArtifactBo {

    private Long id;

    private Date creationDate;

    private String name;

    private Category type;

    private String description;

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
