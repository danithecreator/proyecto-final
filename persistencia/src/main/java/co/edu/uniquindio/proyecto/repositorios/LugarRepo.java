package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.ComentariosLugarDTO;
import co.edu.uniquindio.proyecto.dto.NumeroLugaresPorCategoriaDTO;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Query("select new co.edu.uniquindio.proyecto.dto.ComentariosLugarDTO(l, c)  from Lugar  l  left join l.comentarios c ")
    List<ComentariosLugarDTO> obtenerComentariosLugares();

    @Query("select l.nombre, l.descripcion, l.ciudadLugar.nombre, l.tipo.nombre from Lugar l where l.moderador.email= :emailModerador")
    List<Object[]> obtenerLugaresModerador(String emailModerador);

    @Query("select count(c) from Lugar l join l.comentarios c where l.codigo= :codigo")
    int obtenerCantidadComentarios(Integer codigo);

    @Query("select new co.edu.uniquindio.proyecto.dto.NumeroLugaresPorCategoriaDTO(l.tipo.nombre,count(l))  from Lugar l group by l.tipo")
    List<NumeroLugaresPorCategoriaDTO> obtenerCantidadLugaresPorCategoria();

    @Query("select l from Lugar l where l.horarios is empty ")
    List<Lugar> obtenerLugaresSinHorarios();

    @Query("select l.ciudadLugar.nombre, count(l) from Lugar l group by l.ciudadLugar")
    List<Object[]> obtenerCantidadLugaresPorCiudad();

  //  @Query("select l from Lugar l join l.horarios h where h.diaSemana and  :horaActual between h.horaApertura and h.horaCierre ")
  //  List<Lugar> obtenerLugaresAbiertos(String diaSemana, Date horaActual);

    @Query("select l.tipo.nombre,count(l) as total from Lugar l where l.estado=true group by l.tipo order by total desc ")
    List<Object[]> obtenerTipoLugarPopular();

    @Query("select avg (c.calificacion) from Lugar l join l.comentarios c where l.codigo = :codigo")
    Float obtenerCalificacionPromedio(Integer codigo);

    @Query("select l.moderador,count(l) as total from Lugar l where l.estado=true group by l.moderador order by total desc ")
    List<Object[]> obtenerModeradorConMasAprobados();

    @Query("select l,avg (c.calificacion) as total  from Lugar l join l.comentarios c where l.ciudadLugar.codigo= :codigo group by l order by total desc")
    List<Object[]> obtenerLugarCalificacionMasAltaPorCiudad(Integer codigo);

    @Query("select l.ciudadLugar.nombre ,count(l)  from Lugar l  where l.estado=false group by l.ciudadLugar")
    List<Object[]> obtenerCantidadLugaresNoAprobadosPorCiudad();

    @Query("select l.tipo.nombre,count(l)  from Lugar l join l.horarios h where h.dia= :diaSemana and  :horaActual between h.horaApertura and h.horaCierre group by l.tipo")
    List<Object[]> obtenerCantidadLugaresAbiertosPorCategoria(String diaSemana, Date horaActual);
}
