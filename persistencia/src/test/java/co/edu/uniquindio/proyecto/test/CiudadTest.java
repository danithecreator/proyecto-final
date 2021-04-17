package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

/**
 * Esta clase permite testear la entidad ciudad
 * @author: Daniel Ceballos, Angy Tabares
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {
    @Autowired
    private CiudadRepo ciudadRepo;

    /**
     * metodo para verificar si se ha registrado una ciudad correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql("classpath:ciudad.sql")
    public void registrarCiudadTest(){
        Ciudad ciudadNueva=ciudadRepo.getOne(1);
        Ciudad ciudadGuardada=ciudadRepo.save(ciudadNueva);
        Assertions.assertNotNull(ciudadGuardada);
    }

    /**
     * metodo para verificar si se ha eliminado una ciudad correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql("classpath:ciudad.sql")
    public void eliminarCiudadTest(){
        ciudadRepo.delete(ciudadRepo.getOne(2));
        Ciudad buscada=ciudadRepo.findById(2).orElse(null);
        Assertions.assertNull(buscada);
    }

    /**
     * metodo para verificar si se ha actualizado una ciudad correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql("classpath:ciudad.sql")
    public void actualizarCiudadTest(){
        Ciudad registrada=ciudadRepo.getOne(2);

        registrada.setNombre("medellin");

        ciudadRepo.save(registrada);
        Ciudad buscada=ciudadRepo.findById(2).orElse(null);
        Assertions.assertEquals("medellin",buscada.getNombre());
    }

    /**
     * metodo para listar las ciudades
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:ciudad.sql"})
    public void listarCiudadesTest(){
        List<Ciudad> lista = ciudadRepo.findAll();
        System.out.println("Listado de ciudades"+"\n"+lista);
    }


}
