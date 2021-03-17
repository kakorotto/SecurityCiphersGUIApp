import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {

    public void caesarAction(ActionEvent actionEvent) throws IOException {
        Parent patientview = FXMLLoader.load(getClass().getResource("Caesar/caesarFXML.fxml"));
        Scene patientviewscene = new Scene(patientview);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(patientviewscene);
        stage.show();
    }

    public void playfairAction(ActionEvent actionEvent) throws IOException {

    Parent patientview = FXMLLoader.load(getClass().getResource("Playfair/playfairFXML.fxml"));
    Scene patientviewscene = new Scene(patientview);
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(patientviewscene);
        stage.show();
    }

    public void feistelAction(ActionEvent actionEvent) throws IOException {
        Parent patientview = FXMLLoader.load(getClass().getResource("Feistel/festalFXML.fxml"));
        Scene patientviewscene = new Scene(patientview);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(patientviewscene);
        stage.show();
    }

    public void desAction(ActionEvent actionEvent) throws IOException {
    Parent patientview = FXMLLoader.load(getClass().getResource("DES/desFXML.fxml"));
    Scene patientviewscene = new Scene(patientview);
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(patientviewscene);
        stage.show();
}

    public void rc4Action(ActionEvent actionEvent) throws IOException {
        Parent patientview = FXMLLoader.load(getClass().getResource("RC4/rc4FXML.fxml"));
        Scene patientviewscene = new Scene(patientview);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(patientviewscene);
        stage.show();
    }

    public void rsaAction(ActionEvent actionEvent) throws IOException {
        Parent patientview = FXMLLoader.load(getClass().getResource("RSA/rsaFXML.fxml"));
        Scene patientviewscene = new Scene(patientview);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(patientviewscene);
        stage.show();
    }
}
