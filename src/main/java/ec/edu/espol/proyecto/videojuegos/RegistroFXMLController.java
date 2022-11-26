package ec.edu.espol.proyecto.videojuegos;

import Model.Cuenta;
import estructuras.ArrayListTDA;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RegistroFXMLController {

    @FXML
    private CheckBox checkadmin;

    @FXML
    private CheckBox checkusuario;

    @FXML
    private TextField txtapellido;

    @FXML
    private PasswordField txtcontraseña;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtnombre;

    @FXML
    private TextField txtorganizacion;

    @FXML
    private TextField txtusuario;

    @FXML
    void RegistrarVolverAV(MouseEvent event) {
        if( (!(txtnombre.getText().equals("")||txtapellido.getText().equals("")||txtemail.getText().equals("")
                ||txtorganizacion.getText().equals("")||txtusuario.getText().equals("")||txtcontraseña.getText().equals("")))
                && !(checkadmin.selectedProperty().getValue()==false && checkusuario.selectedProperty().getValue()==false) ){
            try{    
                if(Cuenta.verificarUsuariodisponible(txtusuario.getText(), txtemail.getText(),"cuentas")){
                    try{
                        String num = "0";
                        if (checkadmin.selectedProperty().getValue() && checkusuario.selectedProperty().getValue())
                            num = "3";
                        else if (checkadmin.selectedProperty().getValue())
                            num = "1";
                        else if (checkusuario.selectedProperty().getValue())
                            num = "2";
                        Cuenta p1 = new Cuenta(txtnombre.getText(),txtapellido.getText(),txtemail.getText(),
                                txtorganizacion.getText(),txtusuario.getText(),txtcontraseña.getText(),num);
                        ArrayListTDA<Cuenta> arr = Cuenta.leer("cuentas");
                        arr.add(p1);
                        Cuenta.serializar(arr,"cuentas");
                    } catch (Exception e1) {
                        Alert a = new Alert(Alert.AlertType.WARNING,"No se han completado correctamente los campos.");
                        a.show();
                    }
                    try {
                        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Se ha registrado exitosamente");
                        a.show();
                        App.setRoot("primary",446,398);
                            } 
                    catch (IOException ex) {
                        Alert a = new Alert(Alert.AlertType.ERROR,"No se pudo cambiar las ventanas");
                        a.show();
                        }
                }else{
                    throw new ObjetoYaRegistradoException("Este usuario o correo ya esta registrado.");
                }
            } catch (ObjetoYaRegistradoException ex) {
                Alert a = new Alert(Alert.AlertType.WARNING,ex.getMessage());
                a.show();
            }
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING,"No se han completado correctamente los campos.");
            a.show();
        }

    }

    @FXML
    void VolverAV(MouseEvent event) {
         try {
            App.setRoot("primary",446,398);
        }catch (IOException ex){
            Alert a = new Alert(Alert.AlertType.ERROR,"No se pudo cambiar las ventana");
            a.show();
        }

    }

}
