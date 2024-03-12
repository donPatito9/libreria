package dominio;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-08-24T00:43:43")
@StaticMetamodel(Libro.class)
public class Libro_ { 

    public static volatile SingularAttribute<Libro, String> editorial;
    public static volatile SingularAttribute<Libro, Integer> precio;
    public static volatile SingularAttribute<Libro, Date> fechaRegistro;
    public static volatile SingularAttribute<Libro, String> titulo;
    public static volatile SingularAttribute<Libro, Integer> id;
    public static volatile SingularAttribute<Libro, String> autor;

}