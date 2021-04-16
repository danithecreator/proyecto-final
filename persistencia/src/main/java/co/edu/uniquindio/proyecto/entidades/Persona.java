package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Email
    @Column(name = "email", nullable =false)
    private String email;
    @Column(name = "password", nullable =false)
    private String password;
    @Column(name = "nombre", nullable =false)
    private String nombre;

    public Persona(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //getters y setters
    //hashcode equals
}
