package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Imagen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "url", nullable =false)
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

    @Override
    public String toString() {
        return "Imagen{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", imagenLugar=" + imagenLugar +
                '}';
    }
}
