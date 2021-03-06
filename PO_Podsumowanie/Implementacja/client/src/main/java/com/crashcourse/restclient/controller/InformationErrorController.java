package com.crashcourse.restclient.controller;

import com.crashcourse.restclient.view.FXMLDialog;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InformationErrorController extends ArtifactsBaseController {

	@FXML
	Label informationText;
	private String errorType;
	private String text;

	
	/*
	public InformationErrorController(Stage primaryStage) {
		super(primaryStage);
	}

*/
	
	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public InformationErrorController(Stage primaryStage, String error) {
		super(primaryStage);
		String errorType=error;
		String s = errorType;
		//System.out.println(errorType);
		setText(s);
		//show();
		//informationText.setText("This user name already exists");

		
	
	}

	
//	void show () {
//		informationText.setText("This user name already exists");
//	}

	 @FXML
	   void initialize() {
		System.out.println(text);
		if (text.equals("Register")) 
				informationText.setText("User name already exists or empty fields");
		else if(text.equals("Empty"))
			informationText.setText("Empty username or password");
		else if(text.equals("Login"))
			informationText.setText("Incorrect username or password");
		else 
			 informationText.setText("Another exception");
	 }
	
	
	@FXML
    public void close() {
    	FXMLDialog defaultDialog=getScreens().loginDialog();
        getDialog().close();
        getScreens().showDialog(defaultDialog);
    }

	@Override
	public String getResourcePath() {
		return "/com/crashcourse/restclient/controller/InformationError.fxml";
	}
	
	
}
