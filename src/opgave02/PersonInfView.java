package opgave02;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInfView extends Stage {

    private final Label lblName = new Label("Name:");
    private final TextField txfName = new TextField();
    private final Label lblTitle = new Label("Title:");
    private final TextField txfTitle = new TextField();
    private final Label lblSenior = new Label("Senior:");
    private final CheckBox cbxSenior = new CheckBox();

    private final Button btnOk = new Button("OK");
    private final Button btnCancel = new Button("Cancel");

    private Person person = null;

    public PersonInfView(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(150);
        this.setMinWidth(300);
        this.setResizable(false);
        this.setTitle(title);

        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane gridpane) {
        gridpane.setPadding(new Insets(20));
        gridpane.setHgap(10);
        gridpane.setVgap(10);

        gridpane.add(lblName, 0, 0);
        gridpane.add(txfName, 1, 0, 2, 1);

        gridpane.add(lblTitle, 0, 1);
        gridpane.add(txfTitle, 1, 1, 2, 1);

        gridpane.add(lblSenior, 0, 2);
        gridpane.add(cbxSenior, 1, 2);

        gridpane.add(btnOk, 1, 3);
        gridpane.add(btnCancel, 2, 3);

        // OK-knap
        btnOk.setOnAction(event -> {
            String name = txfName.getText().trim();
            String title = txfTitle.getText().trim();
            boolean senior = cbxSenior.isSelected();

            if (name.isEmpty() || title.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter both name and title.");
                alert.showAndWait();
            } else {
                person = new Person(name, title, senior);
                txfName.clear();
                txfTitle.clear();
                this.hide();
            }
        });

        // Cancel-knap
        btnCancel.setOnAction(event -> {
            person = null;
            this.hide();
        });
    }

    public Person getPerson() {
        return person;
    }
}
