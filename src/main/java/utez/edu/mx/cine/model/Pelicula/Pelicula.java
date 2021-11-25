package utez.edu.mx.cine.model.Pelicula;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="Pelicula")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pelicula {
    @XmlElement
    private int id;
    @XmlElement
    private String titulo;
    @XmlElement
    private String Descripcion;
    @XmlElement
    private String Sinopsis;
    @XmlElement
    private int Rating;
    @XmlElement
    private String dateCreacion;
    @XmlElement
    private String dateUpdate;
    @XmlElement
    private int status;
    @XmlElement
    private int Categoria;

    public Pelicula() {
    }

    public Pelicula(int id, String titulo, String descripcion, String sinopsis, int rating, String dateCreacion, String dateUpdate, int status, int categoria) {
        this.id = id;
        this.titulo = titulo;
        Descripcion = descripcion;
        Sinopsis = sinopsis;
        Rating = rating;
        this.dateCreacion = dateCreacion;
        this.dateUpdate = dateUpdate;
        this.status = status;
        Categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        Sinopsis = sinopsis;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getDateCreacion() {
        return dateCreacion;
    }

    public void setDateCreacion(String dateCreacion) {
        this.dateCreacion = dateCreacion;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int categoria) {
        Categoria = categoria;
    }
}

