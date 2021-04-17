package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Imagen;
import co.edu.uniquindio.proyecto.entidades.Tipo;
import co.edu.uniquindio.proyecto.repositorios.ImagenRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

/**
 * Esta clase permite testear la entidad imagen
 * @author: Daniel Ceballos, Angy Tabares
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ImagenTest {

    @Autowired
    private ImagenRepo imagenRepo;

    /**
     * metodo para verificar si se ha agregado una imagen correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql( {"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:imagen.sql"})
    public void registrarImagenTest(){
        Imagen imagenNueva=imagenRepo.getOne(1);
        Imagen imagenGuardada=imagenRepo.save(imagenNueva);
        Assertions.assertNotNull(imagenGuardada);
    }

    /**
     * metodo para verificar si se ha eliminado una imagen correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:imagen.sql"})
    public void eliminarImagenTest(){
        imagenRepo.delete(imagenRepo.getOne(2));
        Imagen buscada=imagenRepo.findById(2).orElse(null);
        Assertions.assertNull(buscada);
    }

    /**
     * metodo para verificar si se ha actualizado una imagen correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:imagen.sql"})
    public void actualizarImagenTest(){
        Imagen registrada=imagenRepo.getOne(2);

        registrada.setUrl("url2");

        imagenRepo.save(registrada);
        Imagen buscada=imagenRepo.findById(2).orElse(null);
        Assertions.assertEquals("url2",buscada.getUrl());
    }

    /**
     * metodo para listar las imagenes
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:imagen.sql"})
    public void listarImagenTest(){
        List<Imagen> lista = imagenRepo.findAll();
        System.out.println("Listado de imagenes"+"\n"+lista);
    }
}
