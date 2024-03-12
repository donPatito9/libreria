/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author 696
 */
public class LibroDTO implements Serializable{
 
  private int id,precio;
  private String titulo,autor,editorial;
  private Date fecha_registro; 

    public LibroDTO() {
    }

    public LibroDTO(int id,  String titulo, String autor, String editorial,int precio, Date fecha_registro) {
        this.id = id;
        
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.precio = precio;
        this.fecha_registro = fecha_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "LibroDTO{" + "id=" + id + ", precio=" + precio + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", fecha_registro=" + fecha_registro + '}';
    }

 
   }

   

