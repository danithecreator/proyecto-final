package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interface define el deposito de datos de administrador
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface AdministradorRepo extends JpaRepository<Administrador,Integer> {

}
