/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ipn.mx.controlador;

import com.ipn.mx.modelo.dao.ArticuloDAO;
import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.entidades.Articulo;
import com.ipn.mx.modelo.entidades.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonathan
 */
@WebServlet(name = "CategoriaServlet", value = {"/CategoriaServlet"})
public class CategoriaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "addCategoria":
                addCategoria(request, response);
                break;
            case "updateCategoria":
                updateCategoria(request, response);
                break;
            case "deleteCategoria":
                deleteCategoria(request, response);
                break;
            default:
                break;
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void deleteCategoria(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        Categoria c = new Categoria();
        Articulo a = new Articulo();
        
        CategoriaDAO cdao = new CategoriaDAO();
        ArticuloDAO adao = new ArticuloDAO();
        
        c.setIdCategoria(Integer.parseInt(request.getParameter("id")));
        
        cdao.delete(c);
        
        response.sendRedirect("categoria/listaCategoria.jsp");
    }

    private void updateCategoria(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Categoria c = new Categoria();
        CategoriaDAO cdao = new CategoriaDAO();
        
        Articulo a = new Articulo();
        ArticuloDAO adao = new ArticuloDAO();
        
        // Damos forma a la categoria
        c.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
        c.setNombreCategoria(request.getParameter("txtNombreCategoria"));
        c.setDescripcionCategoria(request.getParameter("txtDescripcionCategoria"));
        
        cdao.update(c);
        
        response.sendRedirect("categoria/listaCategoria.jsp");
    }

    private void addCategoria(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Categoria c = new Categoria();
        CategoriaDAO cdao = new CategoriaDAO();
        
        // Damos forma a la categoria
        c.setNombreCategoria(request.getParameter("txtNombreCategoria"));
        c.setDescripcionCategoria(request.getParameter("txtDescripcionCategoria"));
        
//        System.out.println("ADDCATEGORIA: " + c.getEntidad().getNombreCategoria() + " " + c.getEntidad().getDescripcionCategoria());
        
        cdao.create(c);
        
        response.sendRedirect("categoria/listaCategoria.jsp");
    }
    
}
