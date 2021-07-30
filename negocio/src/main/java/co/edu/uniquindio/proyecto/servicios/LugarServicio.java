package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.LugarCalificacionDTO;
import co.edu.uniquindio.proyecto.dto.NumeroLugaresPorCategoriaDTO;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;

public interface LugarServicio {

    Lugar obtenerLugar(int codigo) throws Exception;

    Lugar crearLugar(Lugar l) throws Exception;

    void eliminarLugar(Lugar l) throws Exception;

    Lugar actualizarLugar(Lugar l) throws Exception;

    List<Lugar> listarLugares() throws Exception;

    List<Lugar> buscarLugares(String nombre);

    List<Comentario> listarComentariosDeUnLugar(int codigoLugar);

    List<Horario> listarHorariosDeUnLugar(int codigoLugar);

    Integer obtenerCalificacionPromedio(int lugarId) throws Exception;

    void marcarFavorito(Lugar l, Usuario u);

    boolean esFavorito(Lugar l, Usuario u);

    List<NumeroLugaresPorCategoriaDTO> cantLugaresPorCategorias();

    List<LugarCalificacionDTO> calificacionesLugarCiudad(int codigoCiudad);

}
