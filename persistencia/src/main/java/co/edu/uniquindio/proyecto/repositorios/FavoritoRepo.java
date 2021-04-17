package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface define el deposito de datos de favorito
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface FavoritoRepo extends JpaRepository<Favorito,Integer> {

}
