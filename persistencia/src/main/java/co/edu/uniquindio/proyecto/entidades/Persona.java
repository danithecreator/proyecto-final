package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Esta clase define la entidad Persona que es una superclase
 * @author: Daniel Ceballos, Angy Tabares
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class Persona implements Serializable {
    //Campos o atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "email", nullable =false, unique = true)
    @NotBlank
    @Email
    @Size(max=255)
    private String email;

    @Column(name = "nickname", nullable =false, unique = true)
    @NotBlank
    @Size(max=255)
    private String nickname;

    @Column(name = "password", nullable =false)
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(max=255)
    private String password;

    @Column(name = "nombre", nullable =false)
    @NotBlank
    @Size(max=255)
    private String nombre;

    /**
     * Constructor de la clase
     */
    public Persona(){
        super();
    }

    public Persona(@Email String email, String nickname, String password, String nombre) {

        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.nombre = nombre;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Hashcode and equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        return id == persona.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
