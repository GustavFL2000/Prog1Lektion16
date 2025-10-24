package opgave02;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    private final Label lblPersons = new Label("Persons:");
    private final Button btnAddPerson = new Button("Add Person");
    private final ListView<Person> lvPersons = new ListView<>();
    private PersonInfView personInfView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Opgave 3");

        GridPane gridpane = new GridPane();
        initContent(primaryStage, gridpane);

        Scene scene = new Scene(gridpane, 350, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initContent(Stage owner, GridPane gridpane) {
        gridpane.setPadding(new Insets(20));
        gridpane.setHgap(10);
        gridpane.setVgap(10);

        gridpane.add(btnAddPerson, 0, 0);
        btnAddPerson.setDefaultButton(true);
        btnAddPerson.setOnAction(event -> addPerson());

        gridpane.add(lblPersons, 0, 1);
        gridpane.add(lvPersons, 0, 2, 3, 3);
        lvPersons.setPrefHeight(250);

        // Opret dialogvinduet
        personInfView = new PersonInfView("Person Information", owner);
    }

    private void addPerson() {
        personInfView.showAndWait(); // åbner som modal dialog

        Person newPerson = personInfView.getPerson();
        if (newPerson != null) {
            lvPersons.getItems().add(newPerson);
        }
    }
}
