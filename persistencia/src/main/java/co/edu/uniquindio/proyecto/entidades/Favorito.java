package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Favorito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="favorito")
    private int id;

    @ManyToOne
    private Usuario usuarioFavorito;

    @ManyToOne
    private  Lugar lugarFavorito;
}
