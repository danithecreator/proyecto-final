package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface define el deposito de datos de usuario
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface UsuarioRepo  extends JpaRepository<Usuario,Integer> {
}
