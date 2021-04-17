package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface define el deposito de datos de ciudad
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {

}
