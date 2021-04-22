package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.ComentariosLugarDTO;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.repositorios.LugarRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.List;

/**
 * Esta clase permite testear la entidad lugar
 * @author: Daniel Ceballos, Angy Tabares
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LugarTest {
    @Autowired
    private LugarRepo lugarRepo;

    /**
     * metodo para verificar si se ha agregado un lugar correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql"})
    public void registrarLugarTest(){
        Lugar lugarNuevo=lugarRepo.getOne(1);
        Lugar lugarGuardado=lugarRepo.save(lugarNuevo);
        Assertions.assertNotNull(lugarGuardado);
    }

    /**
     * metodo para verificar si se ha eliminado un lugar correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql"})
    public void eliminarLugarTest(){
        lugarRepo.delete(lugarRepo.getOne(2));
        Lugar buscado=lugarRepo.findById(2).orElse(null);
        Assertions.assertNull(buscado);
    }

    /**
     * metodo para verificar si se ha actualizado un lugar correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql"})
    public void actualizarLugarTest(){
        Lugar registrado=lugarRepo.getOne(2);

        registrado.setNombre("Bar React");

        lugarRepo.save(registrado);
        Lugar buscado=lugarRepo.findById(2).orElse(null);
        Assertions.assertEquals("Bar React",buscado.getNombre());
    }

    /**
     * metodo para listar los lugares
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql"})
    public void listarLugarTest(){
        List<Lugar> lista = lugarRepo.findAll();

        System.out.println("Listado de lugares"+"\n"+lista);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql"})
    public void obtenerTipoLugarTest(){

        String nombreTipoLugar= lugarRepo.obtenerTiposLugares(1);
        System.out.println(nombreTipoLugar);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql"})
    public void obtenerInfoTest(){

        List<Object[]> infoLugar= lugarRepo.obtenerInfo(1);

        for (int i=0; i<infoLugar.get(0).length;i++) {

            System.out.println(infoLugar.get(0)[i]);
        }

    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:comentario.sql"})
    public void obtenerComentariosLugaresTest(){

        List<ComentariosLugarDTO> lugaresComentarios= lugarRepo.obtenerComentariosLugares();
        for (ComentariosLugarDTO l: lugaresComentarios) {
            System.out.println(l.getLugar().getNombre()+" "+l.getComentario().getComentario());
        }

    }
}
