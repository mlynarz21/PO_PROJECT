package com.capgemini.common.datatypes.to;

import java.util.Date;

import com.capgemini.common.datatypes.enumerations.Category;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Artifact Transport Object
 * @author CWOJTOWI
 */
public class ArtifactTo {

    private Long id;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date creationDate;

    private String name;

    private Category type;

    private String description;

    public Date getCreationDate() {
        return creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
