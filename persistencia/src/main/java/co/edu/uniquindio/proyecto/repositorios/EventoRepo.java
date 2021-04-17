package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface define el deposito de datos de evento
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface EventoRepo extends JpaRepository<Evento,Integer> {
}
