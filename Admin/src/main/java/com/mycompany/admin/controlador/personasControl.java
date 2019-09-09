/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.admin.controlador;

import com.mycompany.admin.modelo.persona;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.atmosphere.util.StringEscapeUtils;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 *
 * @author Wilmer
 */

@ManagedBean
@RequestScoped
public class personasControl {
    
    private persona usuarios = new persona();
    
    private static List<persona> listaUsuarios = new ArrayList();
    private static List<persona> listaUsuariosEliminada = new ArrayList();

    
    public personasControl() {
    }

    /**
     * Este metodo retona los aatributos seleccionados
     * @return persona obtiene un texto loa atributos seleccionados
     */
    public persona getUsuarios() {
        return usuarios;
    }

    /**
     * Este metodo envia los atributo seleccionado 
     * @param usuarios requerido para enviar los atributos 
     */
    public void setUsuarios(persona usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Este metodo retorna la lista
     * @return listUsuario obtiene un texto con la lusta concatenada
     */
    public List<persona> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * Este metodo envia la lista
     * @param listaUsuarios requerido para enviar la lista
     */
    public  void setListaUsuarios(List<persona> listaUsuarios) {
        personasControl.listaUsuarios = listaUsuarios;
    }
    
    
   
    public void agregarLista(){
        this.listaUsuarios.add(usuarios);
        notificarPUSH();
    }
    
    /**
     * Este metodo retona la lista en formato String
     * @return EliminarLista Lista requerida para eliminar String
     */
     public String Eliminarlista(){
         
         for(persona p: listaUsuarios){
             if(p.isSelec()){
                 listaUsuariosEliminada .add(p);
             }
             
             if(listaUsuariosEliminada.isEmpty()){
                 listaUsuarios.removeAll(listaUsuariosEliminada);
                 
             }
             
         }
         
         notificarPUSHElim();
         return "welcomePrimefaces";
         
         
         
    }
    
   
    public void notificarPUSH(){
        String nuevoElemento = "Nuevo elemento en la lista";
        String agregar = "Se agrego a la lista";
        String CHANEL = "/notify";
        
        EventBus eventBus =  EventBusFactory.getDefault().eventBus();
        try {
            eventBus.publish(CHANEL,new FacesMessage(StringEscapeUtils.escapeJava(nuevoElemento),StringEscapeUtils.escapeJava(agregar)) );
        } catch (Exception ex) {
            Logger.getLogger(personasControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void notificarPUSHElim(){
        String nuevoElemento = "Elemento Eliminado";
        String agregar = "Se ha eliminado el elemento";
        String CHANEL = "/notify";
        
        EventBus eventBus =  EventBusFactory.getDefault().eventBus();
        try {
            eventBus.publish(CHANEL,new FacesMessage(StringEscapeUtils.escapeJava(nuevoElemento),StringEscapeUtils.escapeJava(agregar)) );
        } catch (Exception ex) {
            Logger.getLogger(personasControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
