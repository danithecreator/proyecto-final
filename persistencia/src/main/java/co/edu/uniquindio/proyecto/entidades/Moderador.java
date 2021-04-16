package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Moderador extends Persona implements Serializable {
    //constructor getter y setter y hashcode y equals
    @ManyToOne
    private Administrador administrador;
    @OneToMany(mappedBy = "moderador")
    private List<Lugar> lugaresAutorizados;
    public Moderador(){
        super();
    }

    public List<Lugar> getLugaresAutorizados() {
        return lugaresAutorizados;
    }

    public void setLugaresAutorizados(List<Lugar> lugaresAutorizados) {
        this.lugaresAutorizados = lugaresAutorizados;
    }
}
