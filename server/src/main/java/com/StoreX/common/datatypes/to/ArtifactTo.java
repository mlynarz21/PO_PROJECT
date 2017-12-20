package com.StoreX.common.datatypes.to;

import java.util.Date;

import com.StoreX.common.datatypes.enumerations.Category;
import com.StoreX.common.datatypes.enumerations.Status;
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
    
    private Status status;
    
    private String username;

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
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
