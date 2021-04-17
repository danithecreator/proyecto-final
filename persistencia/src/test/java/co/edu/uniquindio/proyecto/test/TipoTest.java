package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Tipo;
import co.edu.uniquindio.proyecto.repositorios.TipoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

/**
 * Esta clase permite testear la entidad tipo de lugar
 * @author: Daniel Ceballos, Angy Tabares
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TipoTest {

    @Autowired
    private TipoRepo tipoRepo;

    /**
     * metodo para verificar si se ha agregado un tipo de lugar correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql("classpath:tipo.sql")
    public void registrarTipoTest(){
        Tipo nuevoTipo=tipoRepo.getOne(4);
        Tipo tipoGuardado=tipoRepo.save(nuevoTipo);
        Assertions.assertNotNull(tipoGuardado);
    }

    /**
     * metodo para verificar si se ha eliminado un tipo correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql("classpath:tipo.sql")
    public void eliminarTipoTest(){
        tipoRepo.delete(tipoRepo.getOne(2));
        Tipo buscado=tipoRepo.findById(2).orElse(null);
        Assertions.assertNull(buscado);
    }

    /**
     * metodo para verificar si se ha actualizado un tipo de lugar correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql("classpath:tipo.sql")
    public void actualizarTipoTest(){
        Tipo registrado=tipoRepo.getOne(2);

        registrado.setNombre("Hotel");

        tipoRepo.save(registrado);
        Tipo buscado=tipoRepo.findById(2).orElse(null);
        Assertions.assertEquals("Hotel",buscado.getNombre());
    }

    /**
     * metodo para listar los tipos
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:tipo.sql"})
    public void listarTiposTest(){
        List<Tipo> lista = tipoRepo.findAll();
        System.out.println("Listado de Tipos de lugar"+"\n"+lista);
    }

}
