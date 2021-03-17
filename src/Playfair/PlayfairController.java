package Playfair;

import Caesar.CaesarCipher;
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

public class PlayfairController implements Initializable{

        @FXML
        private TextArea inputID;
        @FXML
        private TextArea outputID;
        @FXML
        private TextField keyID;

        PlayfairCipher playfairCipher = new PlayfairCipher();

        public void encryptAction(ActionEvent actionEvent) {
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
                playfairCipher.setKey(keyID.getText().toLowerCase());
                playfairCipher.Generator();
                String s = playfairCipher.encryptMessage(inputID.getText().toLowerCase());

                outputID.setText(s.toUpperCase());
            }
        }

        public void decryptAction(ActionEvent actionEvent) {
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
                playfairCipher.setKey(keyID.getText().toLowerCase());

                playfairCipher.Generator();
                String s = playfairCipher.decryptMessage(inputID.getText().toLowerCase());

                outputID.setText(s.toUpperCase());
            }
        }

    public void backAction(ActionEvent actionEvent) throws IOException {
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