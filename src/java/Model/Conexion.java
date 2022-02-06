/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;


/**
 *
 * @author windows
 */
public class Conexion {
    String direccion = "http://localhost/serviciosSOA/";
    public String consume (){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(direccion+"mostrarUsuarios.php");
        //System.out.println(target.request(MediaType.APPLICATION_JSON).get(String.class));
        return target.request(MediaType.APPLICATION_JSON).get(String.class);
    }
    
    public String logeo (String usu, String contra){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(direccion+"serviLogin.php?usuario="+usu+"&contrasenia="+contra);
                
        return target.request(MediaType.APPLICATION_JSON).get(String.class);
    }
    
    public void actualizarUsuario (String cedula, String nombre, String apellido, String direccion, String telefono){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(this.direccion+"actualizarUsuario.php?cedula="+cedula+"&nombre="+nombre+"&apellido="+apellido+"&direccion="+direccion+"&telefono="+telefono);
        target.request(MediaType.APPLICATION_JSON).get(String.class);
    }
}
