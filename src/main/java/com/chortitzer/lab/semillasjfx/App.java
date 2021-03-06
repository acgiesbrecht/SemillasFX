package com.chortitzer.lab.semillasjfx;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App extends Application {

    private static final Logger LOGGER = LogManager.getLogger(App.class);
    public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("semillasPU");
    private static final BorderPane root = new BorderPane();
    public static Stage mainStage;

    /**
     * Just a root getter for the controller to use
     */
    public static BorderPane getRoot() {
        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {

        MenuBar menu = FXMLLoader.load(this.getClass().getResource("/fxml/MenuPrincipal.fxml"));
        AnchorPane welcomePane = FXMLLoader.load(this.getClass().getResource("/fxml/Welcome.fxml"));

        root.setTop(menu);
        root.setCenter(welcomePane);

        Scene scene = new Scene(root);
        scene.getStylesheets().add((this.getClass().getResource("/com/panemu/tiwulfx/res/tiwulfx.css").toExternalForm()));//load tiwulfx.css
        stage.setScene(scene);

        InputStream resourceAsStream = this.getClass().getResourceAsStream("/version.properties");
        Properties prop = new Properties();
        prop.load(resourceAsStream);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        stage.setMaximized(true);
        stage.setTitle("Semillas " + prop.getProperty("project.version") + "." + prop.getProperty("project.build"));
        mainStage = stage;
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
