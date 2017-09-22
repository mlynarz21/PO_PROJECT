package com.crashcourse.restclient.model;

import java.util.Date;

import com.crashcourse.restclient.datatype.ArtifactTo;
import com.crashcourse.restclient.datatype.enumeration.Category;
import com.crashcourse.restclient.datatype.enumeration.Status;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ArtifactModel {

	private StringProperty id;
	private StringProperty description;
    private StringProperty name;
    private SimpleObjectProperty<Category> type;
    private SimpleObjectProperty<Status> status;
    private ObjectProperty<Date> createdDate;
    
    public StringProperty getId() {
		return id;
	}

	public void setId(StringProperty id) {
		this.id = id;
	}
    public SimpleObjectProperty getStatus() {
		return status;
	}

	public void setStatus(SimpleObjectProperty status) {
		this.status = status;
	}

	public StringProperty getDescription() {
        return description;
    }

    public void setDescription(StringProperty description) {
        this.description = description;
    }

    public StringProperty getName() {
        return name;
    }

    public void setName(StringProperty name) {
        this.name = name;
    }

    public SimpleObjectProperty getType() {
        return type;
    }

    public void setType(SimpleObjectProperty type) {
        this.type = type;
    }

    public ObjectProperty<Date> getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ObjectProperty<Date> createdDate) {
        this.createdDate = createdDate;
    }

    public static ArtifactModel fromArtifactTo(ArtifactTo artifactTo) {
        ArtifactModel artifactModel = new ArtifactModel();
        artifactModel.id=new SimpleStringProperty(artifactTo.getId().toString());
        artifactModel.createdDate = new SimpleObjectProperty<>(artifactTo.getCreationDate());
        artifactModel.name = new SimpleStringProperty(artifactTo.getName());
        artifactModel.description = new SimpleStringProperty(artifactTo.getDescription());
        artifactModel.type = new SimpleObjectProperty<>(artifactTo.getType());
        artifactModel.status = new SimpleObjectProperty<>(artifactTo.getStatus());
        return artifactModel;
    }
}
