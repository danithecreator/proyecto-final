package co.edu.uniquindio.proyecto.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Imagen implements Serializable {
    @Id
    private int id;
    private String url;

    @ManyToOne
    private Lugar imagenLugar;

    public Imagen( ) {
        super();
    }

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
}
