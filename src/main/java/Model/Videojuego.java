/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import estructuras.ArrayListTDA;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class Videojuego implements Serializable {
    //Título, descripción, capturas de pantalla, géneros, desarrolladores (compañías)
   
    private String descripcion;
    private String titulo;
    private ArrayListTDA<File> capturas;
    private ArrayListTDA<Comentarios> resenas;
    private ArrayListTDA<String> generos;
    private ArrayListTDA<String> companias;

    public Videojuego(String descripcion, String titulo, ArrayListTDA<File> capturas, ArrayListTDA<Comentarios> resenas, ArrayListTDA<String> generos, ArrayListTDA<String> companias) {
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.capturas = capturas;
        this.resenas = resenas;
        this.generos = generos;
        this.companias = companias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayListTDA<File> getCapturas() {
        return capturas;
    }

    public void setCapturas(ArrayListTDA<File> capturas) {
        this.capturas = capturas;
    }
    
    public void setCapturas(File captura){
        capturas.add(captura);
    }

    public ArrayListTDA<Comentarios> getResenas() {
        return resenas;
    }

    public void setResenas(ArrayListTDA<Comentarios> resenas) {
        this.resenas = resenas;
    }

    public ArrayListTDA<String> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayListTDA<String> generos) {
        this.generos = generos;
    }

    public ArrayListTDA<String> getCompanias() {
        return companias;
    }

    public void setCompanias(ArrayListTDA<String> companias) {
        this.companias = companias;
    }

  

    
    
}
