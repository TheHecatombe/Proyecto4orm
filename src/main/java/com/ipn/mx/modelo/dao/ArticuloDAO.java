package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.entidades.Articulo;
import com.ipn.mx.utilerias.HibernateUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Data

public class ArticuloDAO {

//    private static final String SQL_CREATE = "insert into Articulo(nombreArticulo, descripcionArticulo, precioUnitarioArticulo, existenciaArticulo, stockMinimoArticulo, stockMaximoArticulo, idCategoria) values (?, ?, ?, ?, ?, ?, ?)";
//    private static final String SQL_UPDATE = "update Articulo set nombreArticulo = ?, descripcionArticulo = ?, precioUnitarioArticulo = ?, existenciaArticulo = ?, stockMinimoArticulo = ?, stockMaximoArticulo = ?, idCategoria = ? where idArticulo = ?";
//    private static final String SQL_DELETE = "delete from Articulo where idArticulo = ?";
//    private static final String SQL_READ = "select * from Articulo where idArticulo = ?";
//    private static final String SQL_READ_ALL = "select * from Articulo";
//    private Connection conn;

    private String navbar = "<nav class=\"navbar navbar-expand-lg bg-dark navbar-dark d-flex justify-content-space-between\">\n"
            + "            <div class=\"container-fluid\">\n"
            + "                <a class=\"navbar-brand\" href=\"#\">Tienda</a>\n"
            + "                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
            + "                    <span class=\"navbar-toggler-icon\"></span>\n"
            + "                </button>\n"
            + "                <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n"
            + "                    <ul class=\"navbar-nav\">\n"
            + "                        <li class=\"nav-item\">\n"
            + "                            <a class=\"nav-link active\" aria-current=\"page\" href=\"../index.jsp\">Inicio</a>\n"
            + "                        </li>\n"
            + "                        <li class=\"nav-item dropdown\">\n"
            + "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
            + "                                Artículos\n"
            + "                            </a>\n"
            + "                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n"
            + "                                <li><a class=\"dropdown-item\" href=\"listaArticulo.jsp\">Ver artículos</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"agregarArticulo.jsp\">Añadir artículo</a></li>\n"
            + "                            </ul>\n"
            + "                        </li>\n"
            + "                        <li class=\"nav-item dropdown\">\n"
            + "                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
            + "                                Categoria\n"
            + "                            </a>\n"
            + "                            <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\n"
            + "                                <li><a class=\"dropdown-item\" href=\"../categoria/listaCategoria.jsp\">Ver categorias</a></li>\n"
            + "                                <li><a class=\"dropdown-item\" href=\"../categoria/agregarCategoria.jsp\">Añadir categoria</a></li>\n"
            + "                            </ul>\n"
            + "                        </li>\n"
            + "                    </ul>\n"
            + "                </div>\n"
            + "            </div>\n"
            + "        </nav>";

    public ArticuloDAO() {
    }

//    public Connection getConnection() {
////        MYSQL
//        
////        String url = "jdbc:mysql://localhost:3306/ProyectoBase4";
////        String usuario = "admin";
////        String password = "12345";
////        String driverDB = "com.mysql.cj.jdbc.Driver";
//
////        POSTGRESQL
//
//        String url = "jdbc:postgresql://ec2-23-23-182-238.compute-1.amazonaws.com:5432/dccmdnsatad59j";
//        String usuario = "oscsvffynoijni";
//        String password = "f9f86ae035bfb6ba1f3e9ce57227329918898a45d7522b357e4ce119c685ba0c";
//        String driverDB = "org.postgresql.Driver";
//        try {
//            Class.forName(driverDB);
//            conn = DriverManager.getConnection(url, usuario, password);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return conn;
//    }

    public void create(Articulo a) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
//            System.out.println("Se guardara: " + v);

            transaction.begin(); // Iniciamos la transacion

            session.persist(a); // Persistimos ek objeto en la sesion.

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException e) {
            System.err.println("ERROR Hibernate: " + e);
        } catch (Exception e) {
            System.err.println("ERROR Normal: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }
    }

    public void update(Articulo a) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
//            System.out.println("Se guardara: " + v);

            transaction.begin(); // Iniciamos la transacion

            session.merge(a); // Persistimos ek objeto en la sesion.

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException e) {
            System.err.println("ERROR Hibernate: " + e);
        } catch (Exception e) {
            System.err.println("ERROR Normal: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }
    }

    public void delete(Articulo a) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
//            System.out.println("Se guardara: " + v);

            transaction.begin(); // Iniciamos la transacion

            session.remove(a); // Persistimos ek objeto en la sesion.

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException e) {
            System.err.println("ERROR Hibernate: " + e);
        } catch (Exception e) {
            System.err.println("ERROR Normal: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }
    }

    public Articulo read(Articulo a) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {

            transaction.begin(); // Iniciamos la transacion

            a = session.get(a.getClass(), a.getIdArticulo());

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException e) {
            System.err.println("ERROR: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }

        return a;
    }

    public List<Articulo> readAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();

        List articulos = new ArrayList<>();

        try {

            transaction.begin(); // Iniciamos la transacion

            Query q = session.createQuery("from Articulo", Articulo.class);

            articulos = (ArrayList<Articulo>) q.list();

            transaction.commit(); // Hacemos el commit de la transacion.

        } catch (HibernateException e) {
            System.err.println("ERROR: " + e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        }

        return articulos;
    }
    
//    private List obtenerResultados(ResultSet rs) throws SQLException {
//        List resultados = new ArrayList();
//
//        while (rs.next()) {
//            ArticuloDTO dto = new ArticuloDTO();
//
//            //Llenamos la instancia.
//            dto.getEntidad().setIdArticulo(rs.getInt("idArticulo"));
//            dto.getEntidad().setNombreArticulo(rs.getString("nombreArticulo"));
//            dto.getEntidad().setDescripcionArticulo(rs.getString("descripcionArticulo"));
//            dto.getEntidad().setPrecioUnitarioArticulo(rs.getDouble("precioUnitarioArticulo"));
//            dto.getEntidad().setExitenciasArticulo(rs.getInt("existenciaArticulo"));
//            dto.getEntidad().setStockMinimoArticulo(rs.getInt("stockMinimoArticulo"));
//            dto.getEntidad().setStockMaximoArticulo(rs.getInt("stockMaximoArticulo"));
//            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
//            
//
//            //Añadimos la instancia a la lista.
//            resultados.add(dto);
//        }
//
//        return resultados;
//    }
}
