package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface define el deposito de datos de tipo de lugar
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface TipoRepo extends JpaRepository<Tipo,Integer> {

}
