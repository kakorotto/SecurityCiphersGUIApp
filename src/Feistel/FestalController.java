package Feistel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FestalController implements Initializable {
    @FXML
    private TextArea outputID;
    @FXML
    private TextArea inputID;
    @FXML
    private RadioButton andID;
    @FXML
    private RadioButton orID;
    @FXML
    private TextField keyID;


    FestalCipher festalCipher  = new FestalCipher();;



    public void encryptAction(ActionEvent actionEvent) {
        String chosen=null;
        if (andID.isSelected())chosen="AND";

        if (inputID.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter a message to continue");
            a.show();
        }
        else if (keyID.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter a key to continue");
            a.show();
        } else {
            outputID.setText(festalCipher.encrypt(inputID.getText(),keyID.getText(),chosen));
        }
    }

    public void decryptAction(ActionEvent actionEvent) {
        String chosen=null;
        if (andID.isSelected())chosen="AND";
        if (inputID.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter a message to continue");
            a.show();
        }
        else if (keyID.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter a key to continue");
            a.show();
        } else {
            outputID.setText(festalCipher.decrypt(inputID.getText(),keyID.getText(),chosen));
        }
    }


    public void backAction(ActionEvent actionEvent)  throws IOException {
        Parent patientview = FXMLLoader.load(getClass().getResource("../mainPage.fxml"));
        Scene patientviewscene = new Scene(patientview);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(patientviewscene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
