package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface define el deposito de datos de comentario
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface ComentarioRepo extends JpaRepository<Comentario,Integer> {
}
