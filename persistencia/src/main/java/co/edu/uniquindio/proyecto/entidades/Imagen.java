package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Esta clase define la entidad Imagen de la base de datos
 * @author: Daniel Ceballos, Angy Tabares
 */
@Entity
public class Imagen implements Serializable {
    //Campos o atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "url", nullable =false)
    private String url;

    @ManyToOne
    private Lugar imagenLugar;

    /**
     * constructor
     */
    public Imagen( ) {
        super();
    }

    /**
     * getters y setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Lugar getImagenLugar() {
        return imagenLugar;
    }

    public void setImagenLugar(Lugar imagenLugar) {
        this.imagenLugar = imagenLugar;
    }

    //metodo tostring de la clase
    @Override
    public String toString() {
        return "Imagen{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", imagenLugar=" + imagenLugar +
                '}';
    }

    /**
     * Hascode and equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Imagen imagen = (Imagen) o;

        return id == imagen.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
