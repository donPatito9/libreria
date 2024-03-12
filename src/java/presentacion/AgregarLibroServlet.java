/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;


import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import dominio.Libro;
import dto.LibroDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servicio.LibreriaService;
import servicio.ServicioException;

/**
 *
 * @author 696
 */
@WebServlet(name = "AgregarLibroServlet", urlPatterns = {"/AgregarLibroServlet"})
public class AgregarLibroServlet extends HttpServlet {
private static final Logger LOG = Logger.getLogger(AgregarLibroServlet.class.getName());    
    
    
    

    @EJB
    private LibreriaService service;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarLibroServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarLibroServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
         LibroDTO libro = new LibroDTO();

        request.setAttribute("libro", libro);
        request.getRequestDispatcher("/libro_agregar.jsp").forward(request, response);
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
         request.setCharacterEncoding("UTF-8");

        LibroDTO libro = new LibroDTO();
        Map<String, String> mapMensajes = new HashMap<>();
        String respuesta;

        response.setContentType("text/html;charset=UTF-8");
/*
        //recibir parámetros
        String idN = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String editorial = request.getParameter("editorial");
        String precioN = request.getParameter("precio");
       */
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if (id <= 0) {
                mapMensajes.put("id", "Favor, Ingrese un ID Positivo");
            }else{
                 libro.setId(id);
               
            }
            
        } catch (NumberFormatException ex) {
            mapMensajes.put("id", "ID no es válido: " + request.getParameter("id"));
        }
        
        
        String titulo = request.getParameter("titulo");
        if (titulo.isEmpty()) {
            mapMensajes.put("titulo", "Favor, Ingrese Titulo");
        } else {
            libro.setTitulo(titulo);
        }
        
         String autor = request.getParameter("autor");
       
        if (autor.isEmpty()) {
            mapMensajes.put("autor", "Favor, Seleccione Autor");
        } else {
            libro.setAutor(autor);
        }
        String editorial = request.getParameter("editorial");
       
        if (editorial.isEmpty()) {
            mapMensajes.put("editorial", "Favor, Seleccione Editorial");
        } else {
            libro.setEditorial(editorial);
        }
        
          try {
            int precio = Integer.parseInt(request.getParameter("precio"));
            if (precio <= 0) {
                mapMensajes.put("precio", "Favor, Ingrese Precio Positivo");
            } else {
                libro.setPrecio(precio);
            }
        } catch (NumberFormatException ex) {
            mapMensajes.put("precio", "Precio no es válido: " + request.getParameter("precio"));
        }

        
        if (mapMensajes.isEmpty()) {
            try {
                
                service.agregarLibro(libro);
                respuesta = "Libro agregado exitosamente";
            } catch (ServicioException ex) {
                respuesta = ex.getMessage();
            }
        } else {
            respuesta = "Favor, revise el formulario";
        }

        request.setAttribute("mapMensajes", mapMensajes);
        request.setAttribute("mensaje", respuesta);
        request.setAttribute("libro", libro);
        request.getRequestDispatcher("/libro_agregar.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

  }

