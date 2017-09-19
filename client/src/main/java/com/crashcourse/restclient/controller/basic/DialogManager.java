package com.crashcourse.restclient.controller.basic;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.crashcourse.restclient.view.FXMLDialog;

import javafx.stage.StageStyle;

public class DialogManager {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DialogManager.class);

    @Autowired
    private ScreensConfiguration screens;

    public FXMLDialog initializeDialog(DialogController controller) {
        FXMLDialog fxmlDialog = null;
        try {
            fxmlDialog = new FXMLDialog(controller, controller.getClass().getResource(controller.getResourcePath()),
                    controller.getPrimaryStage(),
                    StageStyle.UNDECORATED, screens.getLocale());
            controller.setDialog(fxmlDialog);
        } catch (IOException e) {
            LOGGER.error(new StringBuilder("Error when initializing the controller: ").append(controller.getClass().getCanonicalName()).append(" !").toString(),
                    e);
            e.printStackTrace();
        }

        return fxmlDialog;
    }

}
