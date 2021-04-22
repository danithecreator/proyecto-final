package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Esta interface define el deposito de datos de ciudad
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {

    @Query("select u from Ciudad c join c.usuarios u where c.nombre = :nombreCiudad")
    List<Usuario> obtenerListaUsuarios(String nombreCiudad);

    @Query("select c.nombre, u from Ciudad c left join c.usuarios u")
    List<Object[]> obtenerListaUsuariosJoinLeft();
}
