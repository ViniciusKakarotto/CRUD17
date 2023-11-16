package trabalhodia16;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private AnchorPane main_from;

    @FXML
    private Button loginBtn;

    // ferramentas do data base
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public void login() {
      String sql = "SELECT * FROM admin WHERE username = ? and password = ?";
        connect = database.connectdb();
    
    
     try{
    prepare = connect.prepareStatement(sql);
    prepare.setString(1, username.getText());
    prepare.setString(2, password.getText());
    
    result = prepare.executeQuery();
    
    Alert alert;
    
    if(username.getText().isEmpty() || password.getText().isEmpty()){
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText("Por favor preencha os campos em branco");
        alert.showAndWait();
    }else{
        if(result.next()){
            // se a senha e o nome tiver certo entao vai seguir pra dashbord 
            
            
            // pra esconder o login
            loginBtn.getScene().getWindow().hide();
            
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information mensage");
            alert.setHeaderText(null);
            alert.setContentText("Login feito com sucesso!");
            alert.showAndWait();
            
            // n esquecer de linkar a dashbord aqui
            Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml") );
            Stage stage = new Stage ();
            Scene scene = new Scene (root);
            
            stage.setScene(scene);
            stage.show();
        }else{
            // se n a mensagem de texto vai parecer 
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Nome errado/senha");
            alert.showAndWait();
        }
    }
    
    
    }catch(Exception e){e.printStackTrace();}
    
    
    
    
    
    
    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           }    
    
}