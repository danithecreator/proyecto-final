package co.edu.uniquindio.proyecto.Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Ciudad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "nombre", length = 200, nullable =false)
    private String nombre;

    @OneToMany(mappedBy = "ciudadUsuario")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "ciudadLugar")
    private List<Lugar> lugares;
    //constructor getter y setter y hashcode y equals
    public Ciudad(){
        super();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ciudad ciudad = (Ciudad) o;

        return codigo == ciudad.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }
}
