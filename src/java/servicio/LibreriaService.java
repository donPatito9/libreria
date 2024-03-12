/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dominio.Libro;
import dto.LibroDTO;
//import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 696
 */
@Stateless
public class LibreriaService {
@PersistenceContext
    private EntityManager em;

    public void agregarLibro(LibroDTO dto) throws ServicioException {
        Libro bd = buscarLibroPorId(dto.getId());
        if (bd != null) {
            throw new ServicioException("Ya existe Libro con el ID: " + dto.getId());
        }

        // convertir el DTO en Entity
        Libro l = new Libro();
   
        l.setId(dto.getId());
        l.setTitulo(dto.getTitulo());
        l.setAutor(dto.getAutor());
        l.setEditorial(dto.getEditorial());
        l.setPrecio(dto.getPrecio());
        l.setFechaRegistro(new Date());

        em.persist(l);
    }

    private Libro buscarLibroPorId(int id) {
        Libro l = null;
        try {
            l = em.createNamedQuery("Libro.findById", Libro.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException ex) {
            l = null;
        } catch (NonUniqueResultException ex) {
            // existe más de uno
            throw ex;
        }
        return l;
    }

    public void eliminarLibro(int id) {
        Libro l= em.find(Libro.class, id);
        em.remove(l);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Libro> buscarLibroTodos() {
        return em.createNamedQuery("Libro.findAll", Libro.class)
                .getResultList();

    }

    /*@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Libro> buscarLibroTitulo(String titulo) {
        return em.createNamedQuery("Libro.findByTitulo", Libro.class)
                .setParameter("titulo", titulo)
                .getResultList();
    }*/

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Libro> buscarLibroEditorial(String editorial) {
        return em.createNamedQuery("Libro.findByEditorial", Libro.class)
                .setParameter("editorial", editorial)
                .getResultList();
    }

   
    
}
    

