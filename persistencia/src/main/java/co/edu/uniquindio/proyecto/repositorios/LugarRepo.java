package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.ComentariosLugarDTO;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Esta interface define el deposito de datos de lugar
 * @author: Daniel Ceballos, Angy Tabares
 */
@Repository
public interface LugarRepo extends JpaRepository<Lugar,Integer> {

    @Query("select l.tipo.nombre from Lugar l where l.codigo = :codigo")
    String obtenerTiposLugares(Integer codigo);

    @Query("select l.nombre,l.latitud, l.longitud from Lugar l where l.codigo = :codigo")
    List<Object[]> obtenerInfo(Integer codigo);

    @Query("select new co.edu.uniquindio.proyecto.dto.ComentariosLugarDTO(l, c)  from Lugar l left join l.comentarios c")
    List<ComentariosLugarDTO> obtenerComentariosLugares();

    @Query("select l.nombre, l.descripcion, l.ciudadLugar.nombre, l.tipo.nombre from Lugar l where l.moderador.email= :emailModerador")
    List<Object[]> obtenerLugaresModerador(String emailModerador);


}
