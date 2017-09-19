package com.crashcourse.restclient.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.crashcourse.restclient.api.ArtifactRestServiceClient;
import com.crashcourse.restclient.datatype.ArtifactTo;
import com.crashcourse.restclient.datatype.enumeration.Category;
import com.crashcourse.restclient.model.ArtifactModel;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ArtifactListController extends ArtifactsBaseController {

    @FXML
    private TableView<ArtifactModel> artifacts;
    @FXML
    TableColumn<ArtifactModel, Date> createdDateColumn;
    @FXML
    TableColumn<ArtifactModel, String> nameColumn;
    @FXML
    TableColumn<ArtifactModel, String> typeColumn;
    @FXML
    TableColumn<ArtifactModel, String> descriptionColumn;
    @FXML
    TextField nameInput;
    @FXML
    ComboBox<Category> typeInput;
    @Autowired
    private ArtifactRestServiceClient restServiceClient;
    @FXML
    TextField descriptionInput;

    public ArtifactListController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    void initialize() {

        loadAllData();

        createdDateColumn.setCellValueFactory(celldata -> celldata.getValue().getCreatedDate());
        nameColumn.setCellValueFactory(celldata -> celldata.getValue().getName());
        typeColumn.setCellValueFactory(celldata -> celldata.getValue().getType());
        descriptionColumn.setCellValueFactory(celldata -> celldata.getValue().getDescription());
        typeInput.setItems(FXCollections.observableArrayList(Category.values()));
    }

    private void loadAllData() {
        List<ArtifactTo> allArtifacts = restServiceClient.getAllArtifacts();
        List<ArtifactModel> rows = allArtifacts.stream().map(ArtifactModel::fromArtifactTo).collect(Collectors.toList());
        artifacts.setItems(FXCollections.observableArrayList(rows));
    }

    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {

        return "/com/crashcourse/restclient/controller/ArtifactList.fxml";
    }

    @FXML
    public void add() {
        ArtifactTo to = new ArtifactTo();
        to.setName(nameInput.getText());
        to.setDescription(descriptionInput.getText());
        to.setType(typeInput.getSelectionModel().getSelectedItem());
        to.setCreationDate(new Date());
        restServiceClient.addArtifact(to);
        loadAllData();
    }

    @FXML
    public void cancel() {
        nameInput.clear();
        descriptionInput.clear();
        typeInput.getSelectionModel().clearSelection();

    }

}
