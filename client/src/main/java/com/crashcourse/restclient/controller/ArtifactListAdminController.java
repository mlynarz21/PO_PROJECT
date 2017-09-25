package com.crashcourse.restclient.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.crashcourse.restclient.api.ArtifactRestServiceClient;
import com.crashcourse.restclient.datatype.ArtifactTo;
import com.crashcourse.restclient.datatype.enumeration.Category;
import com.crashcourse.restclient.datatype.enumeration.Status;
import com.crashcourse.restclient.main.config.LibrarySecurityContext;
import com.crashcourse.restclient.model.ArtifactModel;
import com.crashcourse.restclient.view.FXMLDialog;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ArtifactListAdminController extends ArtifactsBaseController {


	@FXML
    private TableView<ArtifactModel> artifacts;
    @FXML
    TableColumn<ArtifactModel, Date> createdDateColumn;
    @FXML
    TableColumn<ArtifactModel, String> nameColumn;
    @FXML
    TableColumn<ArtifactModel, String> typeColumn;
    @FXML
    TableColumn<ArtifactModel, String> statusColumn;
    @FXML
    TableColumn<ArtifactModel, String> descriptionColumn;
    @FXML
    TextField nameInput;
    @FXML
    ComboBox<Category> typeInput;
    @FXML
    TextField nameInput2;
    @FXML
    ComboBox<Category> typeInput2;
    @FXML
    ComboBox<Status> statusInput;
    @FXML
    ComboBox<Status> statusInput2;
    
    @Autowired
    private ArtifactRestServiceClient restServiceClient;
    @Autowired
    private LibrarySecurityContext context;
    @FXML
    TextField descriptionInput;

    public ArtifactListAdminController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    void initialize() {

        loadAllData();

        createdDateColumn.setCellValueFactory(celldata -> celldata.getValue().getCreatedDate());
        nameColumn.setCellValueFactory(celldata -> celldata.getValue().getName());
        typeColumn.setCellValueFactory(celldata -> celldata.getValue().getType());
        statusColumn.setCellValueFactory(celldata -> celldata.getValue().getType());
        descriptionColumn.setCellValueFactory(celldata -> celldata.getValue().getDescription());
        statusColumn.setCellValueFactory(celldata -> celldata.getValue().getStatus());
        
        typeInput.setItems(FXCollections.observableArrayList(Category.values()));


        typeInput2.setItems(FXCollections.observableArrayList(Category.values()));

        statusInput.setItems(FXCollections.observableArrayList(Status.values()));
        statusInput2.setItems(FXCollections.observableArrayList(Status.values()));

    }

    private void loadAllData() {
        List<ArtifactTo> allArtifacts = restServiceClient.getAllArtifacts();
        List<ArtifactModel> rows = allArtifacts.stream().map(ArtifactModel::fromArtifactTo).collect(Collectors.toList());
        artifacts.setItems(FXCollections.observableArrayList(rows));
    }
    
    private void loadSpecifiedData(ArtifactTo to) {
    	List<ArtifactTo> specifiedArtifacts = restServiceClient.getSpecifiedArtifacts(to);
        List<ArtifactModel> rows = specifiedArtifacts.stream().map(ArtifactModel::fromArtifactTo).collect(Collectors.toList());
        artifacts.setItems(FXCollections.observableArrayList(rows));
		
	}
    @FXML
    public void close() {
        getDialog().close();
    }

    @Override
    public String getResourcePath() {

        return "/com/crashcourse/restclient/controller/ArtifactListAdmin.fxml";
    }

    @FXML
    public void add() {
        ArtifactTo to = new ArtifactTo();
        to.setName(nameInput.getText());
        to.setDescription(descriptionInput.getText());
        to.setType(typeInput.getSelectionModel().getSelectedItem());
        to.setStatus(Status.AVALIBLE);
        to.setCreationDate(new Date());
        restServiceClient.addArtifact(to);
        loadAllData();
    }
    
    @FXML
    public void search() {
        ArtifactTo to = new ArtifactTo();
        to.setName(nameInput2.getText());
        to.setType(typeInput2.getSelectionModel().getSelectedItem());
        to.setStatus(statusInput2.getSelectionModel().getSelectedItem());
        loadSpecifiedData(to);
    }

	@FXML
	public void cancel() {
        nameInput.clear();
        descriptionInput.clear();
        typeInput.getSelectionModel().clearSelection();
        statusInput.getSelectionModel().clearSelection();
    }
	
	@FXML
	public void clear() {
        nameInput2.clear();
        typeInput2.getSelectionModel().clearSelection();
        statusInput2.getSelectionModel().clearSelection();
    }
	
	@FXML 
	public void free() {
        ArtifactTo to = new ArtifactTo();
        ArtifactModel artifactModel=artifacts.getSelectionModel().getSelectedItem();
        to.setId(artifactModel.getId());
        restServiceClient.freeArtifact(to);
        loadAllData();
	}
	
	@FXML 
	public void book() {
        ArtifactTo to = new ArtifactTo();
        ArtifactModel artifactModel=artifacts.getSelectionModel().getSelectedItem();
        to.setId(artifactModel.getId());
        restServiceClient.bookArtifact(to);
        loadAllData();
	}
	
	@FXML 
	public void borrow() {
        ArtifactTo to = new ArtifactTo();
        ArtifactModel artifactModel=artifacts.getSelectionModel().getSelectedItem();
        to.setId(artifactModel.getId());
        restServiceClient.borrowArtifact(to);
        loadAllData();
	}
	
	@FXML
	public void logOut() {
		context.deleteSession();
		FXMLDialog defaultDialog = getScreens().loginDialog();
		getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

}
