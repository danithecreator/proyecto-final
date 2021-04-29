package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Esta interface define el deposito de datos de telefono
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface TelefonoRepo extends JpaRepository<Telefono,Integer> {

    @Query("select t.telefonoLugar from Telefono t where t.numeroTelefono = :telefono")
    Lugar obtenerLugarPorNumeroTelefono(String telefono);

}
