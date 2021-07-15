package co.edu.uniquindio.proyecto.entidades;


import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

/**
 * Esta clase define la entidad administrador
 * @author: Daniel Ceballos, Angy Tabares
 */
@Entity
@AllArgsConstructor
@Builder
public class Administrador extends Persona implements Serializable {
    //Campos o atributos de la clase
    @OneToMany(mappedBy ="administrador")
    private List<Moderador>moderadoresCreados;

    /**
     * constructor
     */
    public Administrador(){
        super();
    }

    public Administrador(@Email String email, String nickname, String password, String nombre) {
        super(email, nickname, password, nombre);
    }


}
