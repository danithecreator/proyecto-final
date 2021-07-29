package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.LugarRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class LugarServicioImpl implements LugarServicio{

    private final LugarRepo lugarRepo;
    private final UsuarioRepo usuarioRepo;

    public LugarServicioImpl(LugarRepo lugarRepo,UsuarioRepo usuarioRepo) {

        this.lugarRepo = lugarRepo;
        this.usuarioRepo=usuarioRepo;
    }

    /**
     * Metodo que permite crear un lugar en la bd
     * @param l
     * @return lugar guardado
     * @throws Exception
     */

    @Override
    public Lugar crearLugar(Lugar l) throws Exception{

        if(!estaLugar(l.getCodigo()))
        {
            throw new Exception("El lugar ya existe");
        }
        if(!existeNombreLugar(l.getNombre()))
        {
            throw new Exception("El nombre del lugar ya está en uso");
        }
        if(l.getDescripcion().length()>1000)
        {
            throw new Exception("La descripcion debe ser menor de 1000 caracteres");
        }
        if(l.getNombre().length()>200)
        {
            throw new Exception("El nombre debe ser menor de 200 caracteres");
        }

        l.setEstado(false);
        l.setFecha_creacion(new Date());
        //if(l.getImagenes().isEmpty())
        return lugarRepo.save(l);
    }

    /**
     * Metodo que permite eliminar un lugar de la bd
     * @param l
     * @throws Exception
     */

    @Override
    public void eliminarLugar(Lugar l) throws Exception {
        if(estaLugar(l.getCodigo())){
            throw new Exception("El lugar no existe") ;
        }
        lugarRepo.delete(l);
    }

    /**
     * Metodo que permite actualizar la info de un lugar de la bd
     * @param l
     * @return
     * @throws Exception
     */

    @Override
    public Lugar actualizarLugar(Lugar l) throws Exception {

        if(estaLugar(l.getCodigo()))
        {
            throw new Exception("El lugar no existe");
        }

        if(l.getDescripcion().length()>1000)
        {
            throw new Exception("La descripcion debe ser menor de 1000 caracteres");
        }
        if(l.getNombre().length()>200)
        {
            throw new Exception("El nombre debe ser menor de 200 caracteres");
        }

        return lugarRepo.save(l);

    }

    /**
     * Metodo que permite obtener un lugar
     * @param codigo
     * @return lugar
     */
    @Override
    public Lugar obtenerLugar(int codigo) throws Exception {
        Optional<Lugar> lugar =obtenerLugarPorId(codigo);
        if(lugar.isEmpty()){
            throw new Exception("No existe un lugar con el id dado");
        }

        return lugar.get();
    }

    /**
     * Metodo que permite listar los lugares de la bd
     * @return lugares
     * @throws Exception
     */

    @Override
    public List<Lugar> listarLugares() throws Exception {
        return lugarRepo.findAll();
    }

    @Override
    public List<Lugar> buscarLugares(String nombre) {
        return lugarRepo.buscarLugares(nombre);
    }

    @Override
    public List<Comentario> listarComentariosDeUnLugar(int codigoLugar) {
        return lugarRepo.obtenerComentariosPorLugar(codigoLugar);
    }

    @Override
    public List<Horario> listarHorariosDeUnLugar(int codigoLugar) {
        return lugarRepo.obtenerHorariosPorLugar(codigoLugar);
    }

    @Override
    public Integer obtenerCalificacionPromedio(int lugarId) throws Exception {
       if(estaLugar(lugarId))
       {
           throw new Exception("El id no existe");
       }
       return  lugarRepo.obtenerCalificacionPromedio(lugarId);
    }

    @Override
    public void marcarFavorito(Lugar l, Usuario u) {

        if(u.getLugaresFavoritos().contains(l))
        {
            u.getLugaresFavoritos().remove(l);
        }else{
            u.getLugaresFavoritos().add(l);
       }

        usuarioRepo.save(u);

    }

    @Override
    public boolean esFavorito(Lugar l, Usuario u) {

        if(u.getLugaresFavoritos().contains(l))
        {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Lugar> obtenerLugaresUsuario(String email) throws Exception {
        return lugarRepo.obtenerLugaresCreadosPorUsuario(email);
    }

    /**
     * Metodo que permite validar si un lugar se encuentra en la bd
     * @param id
     * @return true si el lugar no esta
     */
    public boolean estaLugar(int id){
        Optional<Lugar> lugar=lugarRepo.findByCodigo(id);
        return lugar.isEmpty();
    }

    /**
     * Metodo que permite validar si ya existe un nombre de un lugar en la bd
     * @param nombre
     * @return true si el lugar no esta
     */

    public boolean existeNombreLugar(String nombre){
        Optional<Lugar> lugar=lugarRepo.findByNombre(nombre);
        return lugar.isEmpty();
    }

    /**
     * Metodo que permite obtener un lugar dado su id
     * @param codigo
     * @return lugar
     */

    public Optional<Lugar> obtenerLugarPorId(int codigo){
        return lugarRepo.findByCodigo(codigo);
    }



}
