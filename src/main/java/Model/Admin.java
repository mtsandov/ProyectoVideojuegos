/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Cuenta;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Melanie
 */
public class Admin extends Cuenta{
   
    
    public Admin(String nombre, String apellido, String email, String organizacion, String usuario, String contraseña,String nivelAcceso){
        super(nombre,apellido,email,organizacion,usuario,contraseña,nivelAcceso);
    }
    
    
 
  
}
