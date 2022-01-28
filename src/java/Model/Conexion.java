/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.function.Consumer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;



/**
 *
 * @author windows
 */
public class Conexion {
    
    public String consume (){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost/ventaPeli/mostrarUsuarios.php");
        //System.out.println(target.request(MediaType.APPLICATION_JSON).get(String.class));
        return target.request(MediaType.APPLICATION_JSON).get(String.class);
    }
}
