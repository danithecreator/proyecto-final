package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

/**
 * Esta clase define la entidad moderador de la base de datos
 * @author: Daniel Ceballos, Angy Tabares
 */
@Entity
public class Moderador extends Persona implements Serializable {
    //Campos o atributos de la clase

    @ManyToOne
    @JoinColumn(nullable = false)
    private Administrador administrador;
    @OneToMany(mappedBy = "moderador")
    private List<Lugar> lugaresAutorizados;

    /**
     * Constructor de la clase
     */
    public Moderador(){
        super();
    }

    public Moderador(@Email String email, String nickname, String password, String nombre, Administrador administrador) {
        super(email, nickname, password, nombre);
        this.administrador = administrador;
    }

    /**
     * getters y setters
     */
    public List<Lugar> getLugaresAutorizados() {
        return lugaresAutorizados;
    }

    public void setLugaresAutorizados(List<Lugar> lugaresAutorizados) {
        this.lugaresAutorizados = lugaresAutorizados;
    }

    /**
     * Hashcode and equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moderador moderador = (Moderador) o;

        return administrador != null ? administrador.equals(moderador.administrador) : moderador.administrador == null;
    }

    @Override
    public int hashCode() {
        return administrador != null ? administrador.hashCode() : 0;
    }
}
