package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BytteAvScener {
    public static void lastInnStage(javafx.event.ActionEvent actionEvent,String fxmlFil){
        try{
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(BytteAvScener.class.getResource(fxmlFil));
            Parent tableViewParent= loader.load();
            Scene tableViewScene=new Scene(tableViewParent);
            Stage window= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
