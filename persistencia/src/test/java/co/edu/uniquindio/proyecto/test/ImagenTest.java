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

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ImagenTest {

    @Autowired
    private ImagenRepo imagenRepo;

    @Test
    @Sql( {"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:imagen.sql"})
    public void registrarImagenTest(){
        Imagen imagenNueva=imagenRepo.getOne(1);
        Imagen imagenGuardada=imagenRepo.save(imagenNueva);
        Assertions.assertNotNull(imagenGuardada);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:imagen.sql"})
    public void eliminarImagenTest(){
        imagenRepo.delete(imagenRepo.getOne(2));
        Imagen buscada=imagenRepo.findById(2).orElse(null);
        Assertions.assertNull(buscada);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:imagen.sql"})
    public void actualizarImagenTest(){
        Imagen registrada=imagenRepo.getOne(2);

        registrada.setUrl("url2");

        imagenRepo.save(registrada);
        Imagen buscada=imagenRepo.findById(2).orElse(null);
        Assertions.assertEquals("url2",buscada.getUrl());
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:imagen.sql"})
    public void listarImagenTest(){
        List<Imagen> lista = imagenRepo.findAll();
        System.out.println("Listado de imagenes"+"\n"+lista);
    }
}
