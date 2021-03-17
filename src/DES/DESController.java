package DES;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static DES.DesCipher.parseBytes;

public class DESController {

    public TextField keyID;
    public TextArea inputID;
    public TextArea outputID;

    DesCipher desCipher=new DesCipher();



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
            String oriText = inputID.getText(); //example "f3ed a6dc f8b7 9dd6 5be0 db8b 1e7b a551"
            String key = desCipher.convertStringToHex(keyID.getText()); //example "MyPass"
            byte[] keys = parseBytes(key);
            byte[] test = parseBytes(oriText);

            System.out.println("Key:  " + desCipher.hex(keys));

            String output = desCipher.hex(desCipher.encryptCBC(test, keys));
            inputID.setText(desCipher.hex(test));
            outputID.setText(output);

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
                String key = desCipher.convertStringToHex(keyID.getText());
                byte[] keys = parseBytes(key);
                System.out.println("Key:  " + desCipher.hex(keys));
                byte[] encResult = parseBytes(inputID.getText());
                String decResult = desCipher.hex(desCipher.decryptCBC(encResult,keys));
                outputID.setText(decResult);

            }
        }


    public void backAction(ActionEvent actionEvent) throws IOException {
                Parent patientview = FXMLLoader.load(getClass().getResource("../mainPage.fxml"));
                Scene patientviewscene = new Scene(patientview);
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(patientviewscene);
                stage.show();
            }
}

