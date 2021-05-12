package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.LugarRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LugarServicioImpl implements LugarServicio{

    private final LugarRepo lugarRepo;

    public LugarServicioImpl(LugarRepo lugarRepo) {
        this.lugarRepo = lugarRepo;
    }

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

        return lugarRepo.save(l);
    }

    @Override
    public void eliminarLugar(Lugar l) throws Exception {
        if(estaLugar(l.getCodigo())){
            throw new Exception("El lugar no existe") ;
        }
        lugarRepo.delete(l);
    }

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

    public boolean estaLugar(int id){
        Optional<Lugar> usuario=lugarRepo.findByCodigo(id);
        return usuario.isEmpty();
    }

    public boolean existeNombreLugar(String nombre){
        Optional<Lugar> usuario=lugarRepo.findByNombre(nombre);
        return usuario.isEmpty();
    }

    @Override
    public Lugar obtenerLugar(int codigo) throws Exception {
        Optional<Lugar> lugar =obtenerLugarPorId(codigo);
        if(lugar.isEmpty()){
            throw new Exception("No existe un lugar con el id dado");
        }

        return lugar.get();
    }

    public Optional<Lugar> obtenerLugarPorId(int codigo){
        return lugarRepo.findByCodigo(codigo);
    }

    @Override
    public List<Lugar> listarLugares() throws Exception {
        return lugarRepo.findAll();
    }
}
