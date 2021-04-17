package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Moderador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface define el deposito de datos de moderador
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface ModeradorRepo extends JpaRepository<Moderador,Integer> {
}
