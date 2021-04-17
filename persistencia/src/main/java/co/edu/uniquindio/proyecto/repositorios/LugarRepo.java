package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface define el deposito de datos de lugar
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface LugarRepo extends JpaRepository<Lugar,Integer> {
}
