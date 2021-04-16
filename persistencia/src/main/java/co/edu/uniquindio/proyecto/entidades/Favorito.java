package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Favorito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    private Usuario usuarioFavorito;

    @ManyToOne
    private  Lugar lugarFavorito;

    public Favorito() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuarioFavorito() {
        return usuarioFavorito;
    }

    public void setUsuarioFavorito(Usuario usuarioFavorito) {
        this.usuarioFavorito = usuarioFavorito;
    }

    public Lugar getLugarFavorito() {
        return lugarFavorito;
    }

    public void setLugarFavorito(Lugar lugarFavorito) {
        this.lugarFavorito = lugarFavorito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Favorito favorito = (Favorito) o;

        return id == favorito.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
