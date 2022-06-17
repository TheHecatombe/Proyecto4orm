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
@WebServlet(name = "ArticuloServlet", value = {"/ArticuloServlet"})
public class ArticuloServlet extends HttpServlet {

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
            case "addArticulo":
                addArticulo(request, response);
                break;
            case "updateArticulo":
                updateArticulo(request, response);
                break;
            case "deleteArticulo":
                deleteArticulo(request, response);
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
            Logger.getLogger(ArticuloServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ArticuloServlet.class.getName()).log(Level.SEVERE, null, ex);
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

    private void addArticulo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Categoria c = new Categoria();
        CategoriaDAO cdao = new CategoriaDAO();
        
        Articulo a = new Articulo();
        ArticuloDAO adao = new ArticuloDAO();
        
        // Recuperamos la categoria.
        c.setIdCategoria(Integer.parseInt(request.getParameter("txtCategoria")));
        c = cdao.read(c);
        
        // Damos forma al articulo.
        
        a.setNombreArticulo(request.getParameter("txtNombreArticulo"));
        a.setDescripcionArticulo(request.getParameter("txtDescripcionArticulo"));
        a.setPrecioUnitarioArticulo(Double.parseDouble(request.getParameter("txtPrecioArticulo")));
        a.setExitenciasArticulo(Integer.parseInt(request.getParameter("txtExistenciasArticulo")));
        a.setStockMinimoArticulo(Integer.parseInt(request.getParameter("txtStockMinimo")));
        a.setStockMaximoArticulo(Integer.parseInt(request.getParameter("txtStockMaximo")));
        a.setCategoria(c);
        
        adao.create(a);
        
        response.sendRedirect("articulo/listaArticulo.jsp");
    }
    
    private void updateArticulo(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        Categoria c = new Categoria();
        Articulo a = new Articulo();
        
        CategoriaDAO cdao = new CategoriaDAO();
        ArticuloDAO adao = new ArticuloDAO();
        
        // Recuperamos la categoria.
        c.setIdCategoria(Integer.parseInt(request.getParameter("txtCategoria")));
        c = cdao.read(c);
        
        // Damos forma al articulo.
        
        a.setIdArticulo(Integer.parseInt(request.getParameter("idCategoria")));
        a.setNombreArticulo(request.getParameter("txtNombreArticulo"));
        a.setDescripcionArticulo(request.getParameter("txtDescripcionArticulo"));
        a.setPrecioUnitarioArticulo(Double.parseDouble(request.getParameter("txtPrecioArticulo")));
        a.setExitenciasArticulo(Integer.parseInt(request.getParameter("txtExistenciasArticulo")));
        a.setStockMinimoArticulo(Integer.parseInt(request.getParameter("txtStockMinimo")));
        a.setStockMaximoArticulo(Integer.parseInt(request.getParameter("txtStockMaximo")));
        a.setCategoria(c);
        
        adao.update(a);
        
        response.sendRedirect("articulo/listaArticulo.jsp");
    }

    private void deleteArticulo(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        Categoria c = new Categoria();
        Articulo a = new Articulo();
        
        CategoriaDAO cdao = new CategoriaDAO();
        ArticuloDAO adao = new ArticuloDAO();
        
        a.setIdArticulo(Integer.parseInt(request.getParameter("id")));
        
        adao.delete(a);
        
        response.sendRedirect("articulo/listaArticulo.jsp");
    }
    
}
