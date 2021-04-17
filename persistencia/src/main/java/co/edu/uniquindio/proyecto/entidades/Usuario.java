package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * Esta clase define la entidad Usuario de la base de datos
 * @author: Daniel Ceballos, Angy Tabares
 */
@Entity
public class Usuario extends Persona implements Serializable {
    //Campos o atributos de la clase
    @Column(name = "latitud")
    private float latitud;
    @Column(name = "longitud")
    private float longitud;

    @OneToMany(mappedBy = "usuario")
    private List<Lugar> lugares;
    @ManyToOne
    private Ciudad ciudadUsuario;
    @OneToMany(mappedBy = "usuarioFavorito")
    private List<Favorito> favoritos;
    @OneToMany(mappedBy = "usuarioComentario")
    private List<Comentario> comentarios;

    /**
     * Constructor de la clase vacio
     */
    public Usuario(){
        super();
    }

    /**
     * getters y setters
     */
    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    public Ciudad getCiudadUsuario() {
        return ciudadUsuario;
    }

    public void setCiudadUsuario(Ciudad ciudadUsuario) {
        this.ciudadUsuario = ciudadUsuario;
    }

    public List<Favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<Favorito> favoritos) {
        this.favoritos = favoritos;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Hashcode and equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Usuario usuario = (Usuario) o;

        return Float.compare(usuario.latitud, latitud) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (latitud != +0.0f ? Float.floatToIntBits(latitud) : 0);
        return result;
    }
}
