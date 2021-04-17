package co.edu.uniquindio.proyecto.entidades;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 * Esta clase define la entidad administrador
 * @author: Daniel Ceballos, Angy Tabares
 */
@Entity
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



}
