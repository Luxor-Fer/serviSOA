/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Entidades.Planta;
import Entidades.Sucursales;
import Entidades.Usuarios;
import Entidades.tipoUsuario;
import Model.Conexion;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.HttpMethod;

/**
 *
 * @author windows
 */
public class controlador extends HttpServlet {

    Conexion con = new Conexion();
    Usuarios usuario = new Usuarios();
    Sucursales sucursal = new Sucursales();
    Planta planta = new Planta();
    String usu;
    String cont;

    String index = "index.jsp";
    String registro = "registro.jsp";
    String datosUsuario = "views/modules/datosUsuario.jsp";
    String datosUsuarioHome = "views/modules/homeUsuarios.jsp";
    String temSucursal = "views/templateSucursal.jsp";
    String template = "views/template.jsp";
    String temPlanta = "views/templatePlanta.jsp";
    String acceso = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        if (accion.equals("index")) {
            acceso = index;
        } else if (accion.equals("registro")) {
            acceso = registro;
        } else if (accion.equals("login")) {
            tipoUsuario mostrar = null;
            usu = request.getParameter("usuario");
            cont = request.getParameter("contrasenia");
            //System.out.println(usu);

            String dat = con.logeo(usu, cont);
            //System.out.println(dat);
            if (!dat.equals("\"No hay usuario\"")) {
                HashMap<String, String> info = new HashMap<>();
                info = obtenerDatos(dat);
                mostrar = asignarDatos(info, Integer.parseInt(info.get("NIV_ACC")));

                request.setAttribute("usu", mostrar);

                HttpSession misession = request.getSession(true);
                misession.setAttribute("usuario", mostrar);
                System.out.println(mostrar.getClass().getSimpleName());
                if (mostrar.getClass().getSimpleName().equals("Usuarios")) {
                    acceso = template;
                } else if (mostrar.getClass().getSimpleName().equals("Sucursales")) {
                    acceso = temSucursal;
                } else if (mostrar.getClass().getSimpleName().equals("Planta")) {
                    acceso = temPlanta;
                } else {
                    acceso = index;
                }
            } else {
                acceso = index;
            }
        } else if (accion.equals("datosUsuario")) {
            acceso = datosUsuario;
        } else if (accion.equals("guardarCambios")) {
            String ced = request.getParameter("inputCedula");
            String nom = request.getParameter("inputNombre");
            String ape = request.getParameter("inputApellido");
            String dir = request.getParameter("inputDireccion");
            String tel = request.getParameter("inputTelefono");
            con.actualizarUsuario(ced, nom, ape, dir, tel);
            
            tipoUsuario mostrar = null;
            String dat = con.logeo(usu, cont);
            HashMap<String, String> info = new HashMap<>();
            info = obtenerDatos(dat);
            mostrar = asignarDatos(info, Integer.parseInt(info.get("NIV_ACC")));

            request.setAttribute("usu", mostrar);

            HttpSession misession = request.getSession(true);
            misession.setAttribute("usuario", mostrar);
            acceso = datosUsuario;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(acceso);
        dispatcher.forward(request, response);
    }

    public HashMap<String, String> obtenerDatos(String dat) {
        dat = dat.replace("[{", "");
        dat = dat.replace("}]", "");
        dat = dat.replace("\"", "");
        String[] vector = dat.split(",");
        HashMap<String, String> datos = new HashMap<>();
        for (int i = 0; i < vector.length; i++) {
            //System.out.println(vector[i]);
            String[] sop = vector[i].split(":");
            datos.put(sop[0], sop[1]);
        }
        return datos;
    }

    public tipoUsuario asignarDatos(HashMap<String, String> usuario, int nivAcc) {
        if (nivAcc == 1) {
            this.usuario = new Usuarios();
            this.usuario.setCED_USU(usuario.get("CED_USU"));
            this.usuario.setNOM_USU(usuario.get("NOM_USU"));
            this.usuario.setAPE_USU(usuario.get("APE_USU"));
            this.usuario.setDIR_USU(usuario.get("DIR_USU"));
            this.usuario.setTEL_USU(usuario.get("TEL_USU"));
            this.usuario.setSAL_USU(Float.valueOf(usuario.get("SAL_USU")));
            this.usuario.setDES_USU(Integer.parseInt(usuario.get("DES_USU")));
            this.usuario.setCRE_USU(Float.valueOf(usuario.get("CRE_USU")));
            return this.usuario;
        } else if (nivAcc == 2) {
            this.sucursal.setCOD_SUC(Integer.parseInt(usuario.get("COD_SUC")));
            this.sucursal.setNOM_SUC(usuario.get("NOM_SUC"));
            this.sucursal.setDIR_SUC(usuario.get("DIR_SUC"));
            this.sucursal.setTEL_SUC(usuario.get("TEL_SUC"));
            return this.sucursal;

        } else if (nivAcc == 3) {
            this.planta.setCOD_PLA(Integer.parseInt(usuario.get("COD_PLA")));
            this.planta.setNOM_PLA(usuario.get("NOM_PLA"));
            this.planta.setDIR_PLA(usuario.get("DIR_PLA"));
            this.planta.setTEL_PLA(usuario.get("TEL_PLA"));
            return this.planta;
        } else {
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
