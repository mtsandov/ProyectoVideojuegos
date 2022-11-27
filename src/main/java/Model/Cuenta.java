/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import estructuras.ArrayListTDA;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author Melanie
 */
public class Cuenta implements Serializable{
    protected String nombres;
    protected String apellidos;
    protected String email;
    protected String organizacion;
    protected String usuario;
    protected String contraseña;
    protected String nivelAcceso;
    // CONSTRUCTOR
    public Cuenta(String nombre, String apellido, String email, String organizacion, String usuario, String contraseña,String nivelAcceso){
        this.nombres = nombre;
        this.apellidos = apellido;
        this.email = email;
        this.organizacion = organizacion;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nivelAcceso = nivelAcceso;
    }
    // GETTERS Y SETTERS
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }
    
    // MÉTODOS
       public static void serializar(ArrayListTDA<Cuenta> array,String archivo){
        try(FileOutputStream fout = new FileOutputStream(archivo)){
            try(ObjectOutputStream out = new ObjectOutputStream(fout)){
            out.writeObject(array);
            }   
        }catch(IOException e){
                System.out.println(e);
        }
    }
    public static ArrayListTDA<Cuenta> leer(String archivo){
        ArrayListTDA<Cuenta> lista = new ArrayListTDA<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))){
            lista = (ArrayListTDA<Cuenta>)in.readObject();
        }catch(Exception e){
            System.out.println(e);
        }
        return lista;
    }
    
 
    
    public static boolean verificarUsuariodisponible(String usuario,String email,String archivo){
        ArrayListTDA<Cuenta> cuen = Cuenta.leer(archivo);
        for(Cuenta c:cuen){
            if((c.usuario.equals(usuario)) || (c.email.equals(email)))
                return false;
        }
        return true;
    }
    
    public static boolean verificarCuenta(String usuario,String contraseña,String archivo){
        ArrayListTDA<Cuenta> cuen = Cuenta.leer(archivo);
        for(Cuenta c:cuen){
            if(c.usuario.equals(usuario) && c.contraseña.equals(contraseña))
                return true;
        }
        return false;
    }
    
    public static ArrayListTDA<String> datos(String usuario){
        ArrayListTDA<String> dat = new ArrayListTDA<String>();
        ArrayListTDA<Cuenta> cuen = Cuenta.leer("cuentas");
        for(Cuenta c:cuen){
            if(c.usuario.equals(usuario)){
                dat.add(c.nombres);
                dat.add(c.apellidos);
                dat.add(c.email);
                dat.add(c.organizacion);
                dat.add(c.usuario);
                dat.add(c.contraseña);
                dat.add(c.nivelAcceso);
            }
        }
        return dat;
    }
    
    // SOBREESCRITURAS
    @Override
    public String toString(){
        String cad = "Nombres: " + nombres + "\nApellidos: " + apellidos + "\nCorreo electrónico: " + email +
                "\nOrganización: " + organizacion + "\nUsuario: " + usuario + "\nContraseña: " + contraseña + "\nNivel de acceso: " + nivelAcceso;
        return cad;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == null)
            return false;
        if (this == o)
            return true;
        if (this.getClass() != o.getClass())
            return false;
        Cuenta other = (Cuenta)o;
        if (this.usuario.equals(other.usuario))
            return true;
        return false;
    }
}