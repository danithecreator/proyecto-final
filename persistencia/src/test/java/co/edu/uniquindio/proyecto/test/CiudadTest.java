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

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {
    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:ciudad.sql")
    public void registrarCiudadTest(){
        Ciudad ciudadNueva=ciudadRepo.getOne(1);
        Ciudad ciudadGuardada=ciudadRepo.save(ciudadNueva);
        Assertions.assertNotNull(ciudadGuardada);
    }

    @Test
    @Sql("classpath:ciudad.sql")
    public void eliminarCiudadTest(){
        ciudadRepo.delete(ciudadRepo.getOne(2));
        Ciudad buscada=ciudadRepo.findById(2).orElse(null);
        Assertions.assertNull(buscada);
    }

    @Test
    @Sql("classpath:ciudad.sql")
    public void actualizarCiudadTest(){
        Ciudad registrada=ciudadRepo.getOne(2);

        registrada.setNombre("medellin");

        ciudadRepo.save(registrada);
        Ciudad buscada=ciudadRepo.findById(2).orElse(null);
        Assertions.assertEquals("medellin",buscada.getNombre());
    }

    @Test
    @Sql({"classpath:ciudad.sql"})
    public void listarCiudadesTest(){
        List<Ciudad> lista = ciudadRepo.findAll();
        System.out.println("Listado de ciudades"+"\n"+lista);
    }


}
