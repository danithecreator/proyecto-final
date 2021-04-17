package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface define el deposito de datos de imagen
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface ImagenRepo extends JpaRepository<Imagen,Integer> {
}
