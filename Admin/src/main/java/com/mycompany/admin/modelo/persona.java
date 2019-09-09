/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.admin.modelo;

/**
 *
 * @author Wilmer
 */
public class persona {
    
    private String nombre;
    private String apellido;
    private Integer edad;
    private boolean selec;

    
    /**
     * Este metodo retona el atributo seleccionado
     * @return boolean devuelve un texto con el atributo concatenado
     */
    public boolean isSelec() {
        return selec;
    }

    /**
     * Este metodo envia el atributo seleccionado en formato boolean
     * @param selec atributo requerido para enviar boolean
     */
    public void setSelec(boolean selec) {
        this.selec = selec;
    }

    /**
     * Este metodo retorna el nombre
     * @return String obtiene un texto con el nombre concatenado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este metodo envia el nombre en formto String
     * @param nombre Nombre requerido para enviar String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /**
     * Este metodo retorna el apellido
     * @return String obtiene un texto con el apellido concatenado
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Este metodo envia el apellido en formto String
     * @param apellido Apellido requerido para enviar String
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Este metodo retorna la edad
     * @return Integer obtiene un texto con la edad concatenado
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Este metodo envia la edad en formto Integer
     * @param edad Edad requerida para enviar Integer
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    
    
    
    
    
}
