package RC4;

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

public class RC4Controller implements Initializable {
    @FXML
    private TextArea inputID;
    @FXML
    private TextArea outputID;
    @FXML
    private TextField keyID;

    RC4Cipher  rc4Cipher = new RC4Cipher();

//    private void handleEncryptButton() {
//        String message = inputID.getText();
//        String key = keyID.getText();
//
//        rc4Cipher.setKey(key);
//        String encryptedMessage = rc4Cipher.encrypt(message);
//
//        showEncryptedMessage(encryptedMessage);
//    }
//
//    private void handleDecryptedButton() {
//        String encryptedMessage = encryptedLabel.getText();
//        String decryptedMessage = rc4Cipher.decrypt(encryptedMessage);
//        showDecryptedMessage(decryptedMessage);
//    }
//
//    private void showEncryptedMessage(String encryptedMessage) {
//        headerLabel.setVisible(true);
//        encryptedLabel.setText(encryptedMessage);
//        messageTextField.clear();
//    }
//
//    private void showDecryptedMessage(String decryptedMessage) {
//        headerLabel.setVisible(false);
//        messageTextField.setText(decryptedMessage);
//        encryptedLabel.setText("");
//    }

    public void encryptAction(ActionEvent actionEvent) throws IOException {
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
            String message = inputID.getText();
            String key = keyID.getText();
            String encryptedMessage = rc4Cipher.encrypt(message,key);
            outputID.setText(encryptedMessage);
            //inputID.clear();

        }

    }

    public void decryptAction(ActionEvent actionEvent) throws IOException {
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
            }
            else {

                String encryptedMessage = inputID.getText();
                String key = keyID.getText();
                String decryptedMessage = rc4Cipher.decrypt(encryptedMessage,key);
                outputID.setText(decryptedMessage);
                //inputID.setText("");
        }
    }

    public void backAction(ActionEvent actionEvent) throws IOException {
        Parent mainpage = FXMLLoader.load(getClass().getResource("../mainPage.fxml"));
        Scene mainpagescene = new Scene(mainpage);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(mainpagescene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}