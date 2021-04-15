package co.edu.uniquindio.proyecto.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Usuario extends Persona implements Serializable {

    @Column(name = "latitud")
    private float latitud;
    @Column(name = "longitud")
    private float longitud;
    public Usuario(){
        super();
    }

    @OneToMany(mappedBy = "usuario")
    private List<Lugar> lugares;

    @ManyToOne
    private Ciudad ciudadUsuario;

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

    //constructor getter y setter y hashcode y equals
}
