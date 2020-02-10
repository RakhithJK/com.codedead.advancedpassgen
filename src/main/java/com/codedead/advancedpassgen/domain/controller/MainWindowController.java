package com.codedead.advancedpassgen.domain.controller;

import com.codedead.advancedpassgen.domain.controls.NumberTextField;
import com.codedead.advancedpassgen.domain.utils.FxUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public final class MainWindowController {

    private PropertiesController propertiesController;

    @FXML
    private NumberTextField numAmount;
    @FXML
    private NumberTextField numLength;
    @FXML
    private Tab tabList;
    @FXML
    private Tab tabAdvisor;
    @FXML
    private Tab tabAdvanced;
    @FXML
    private Tab tabOptions;
    @FXML
    private MenuItem MniHelp;
    @FXML
    private MenuItem MniUpdate;
    @FXML
    private MenuItem MniHomepage;
    @FXML
    private MenuItem MniLicense;
    @FXML
    private MenuItem MniDonate;
    @FXML
    private MenuItem MniAbout;
    @FXML
    private MenuItem MniSettings;
    @FXML
    private MenuItem MniExit;
    @FXML
    private MenuItem MniExport;

    /**
     * Get the PropertiesController object
     *
     * @return The PropertiesController object
     */
    public final PropertiesController getPropertiesController() {
        return propertiesController;
    }

    /**
     * Set the PropertiesController object
     *
     * @param propertiesController The PropertiesController object
     */
    public final void setPropertiesController(final PropertiesController propertiesController) {
        if (propertiesController == null) throw new NullPointerException("PropertiesController cannot be null!");

        this.propertiesController = propertiesController;
    }

    /**
     * Method that is invoked to initialize the controller
     */
    @FXML
    public void initialize() {
        // Menu items
        MniExport.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/export.png"))));
        MniExit.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/remove.png"))));
        MniSettings.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/settings.png"))));
        MniAbout.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/about.png"))));
        MniDonate.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/donate.png"))));
        MniLicense.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/license.png"))));
        MniHomepage.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/home.png"))));
        MniUpdate.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/update.png"))));
        MniHelp.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/help.png"))));
        // Tab items
        tabOptions.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/home.png"))));
        tabAdvanced.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/settings.png"))));
        tabList.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/list.png"))));
        tabAdvisor.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/images/advisor.png"))));
    }

    /**
     * Method that is called when the Exit menu item is selected
     */
    @FXML
    public final void exitAction() {
        System.exit(0);
    }

    @FXML
    public final void aboutAction() {
        try {
            final Properties properties = propertiesController.getProperties();
            final ResourceBundle bundle = ResourceBundle.getBundle("languages.AboutWindow", Locale.forLanguageTag(properties.getProperty("locale")));
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/AboutWindow.fxml"), bundle);
            final Parent root = loader.load();

            final double width = 450;
            final double height = 200;

            final Stage primaryStage = new Stage();
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/key.png")));
            FxUtils.initializeStage(primaryStage, root, "Advanced PassGen - " + bundle.getString("title"), width, height);

            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
            FxUtils.showErrorAlert("Error opening about window!", ex.getMessage(), getClass().getResourceAsStream("/images/key.png"));
        }
    }
}
