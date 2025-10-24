package opgave01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Opgave 1");

        GridPane gridpane = new GridPane();
        initContent(gridpane);

        Scene scene = new Scene(gridpane, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private final Label lblName = new Label("Name:");
    private final TextField txfName = new TextField();
    private final Label lblTitle = new Label("Title:");
    private final TextField txfTitle = new TextField();
    private final Label lblSenior = new Label("Senior:");
    private final CheckBox cbxSenior = new CheckBox();
    private final Label lblPersons = new Label("Persons:");
    private final ListView<Person> lvPersons = new ListView<>();
    private final Button btnAddPerson = new Button("Add Person");

    private void initContent(GridPane gridpane) {
        gridpane.setGridLinesVisible(false);
        gridpane.setPadding(new Insets(20));
        gridpane.setHgap(10);
        gridpane.setVgap(10);

        gridpane.add(lblName, 0, 0);
        gridpane.add(txfName, 1, 0, 2, 1);

        gridpane.add(lblTitle, 0, 1);
        gridpane.add(txfTitle, 1, 1, 2, 1);

        gridpane.add(lblSenior, 0, 2);
        gridpane.add(cbxSenior, 1, 2);

        gridpane.add(btnAddPerson, 3, 2);
        btnAddPerson.setDefaultButton(true);
        btnAddPerson.setOnAction(event -> addPerson());

        gridpane.add(lblPersons, 0, 3);
        gridpane.add(lvPersons, 1, 3, 2, 3);


    }

    private void addPerson() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        boolean senior = cbxSenior.isSelected();

        if (!name.isEmpty() && !title.isEmpty()) {
            Person person = new Person(name, title, senior);
            lvPersons.getItems().add(person);

            txfName.clear();
            txfTitle.clear();
            cbxSenior.setSelected(false);
        } else { //Exercise 2: Show alert if fields are empty
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter both name and title.");
            alert.showAndWait();
        }
    }
}
