package RSA;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.ResourceBundle;

public class RSAController implements Initializable {

    @FXML
    private TextField keyID1;
    @FXML
    private TextField keyID2;
    @FXML
    private TextArea inputID;
    @FXML
    private TextArea outputID;

    RSACipher rsaCipher = new RSACipher();
    public void encryptAction(ActionEvent actionEvent) throws IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, BadPaddingException{
try{
        if (inputID.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter a message to continue");
            a.show();
        }
        else if (keyID1.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter a key to continue");
            a.show();
        }
        else if (keyID2.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter a key to continue");
            a.show();
        }
        else {outputID.setText( Base64.getEncoder().encodeToString(rsaCipher.encrypt(inputID.getText(), rsaCipher.publicKey)));
        }
    } catch (NoSuchAlgorithmException e) {
        System.err.println(e.getMessage());
    }
    }

    public void decryptAction(ActionEvent actionEvent) throws IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, BadPaddingException {
        try {
            if (inputID.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter a message to continue");
            a.show();
        }
        else if (keyID1.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter a key to continue");
            a.show();
        }
            else if (keyID2.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText(null);
            a.setContentText("Please enter a key to continue");
            a.show();
        }

            else {
                outputID.setText(RSACipher.decrypt(inputID.getText(), rsaCipher.privateKey));
            }
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
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
