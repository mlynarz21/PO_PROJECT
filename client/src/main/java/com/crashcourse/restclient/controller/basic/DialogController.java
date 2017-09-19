
package com.crashcourse.restclient.controller.basic;

import com.crashcourse.restclient.view.FXMLDialog;

import javafx.stage.Stage;

public interface DialogController {
    String getResourcePath();

    Stage getPrimaryStage();

    void setDialog(FXMLDialog fxmlDialog);
}
