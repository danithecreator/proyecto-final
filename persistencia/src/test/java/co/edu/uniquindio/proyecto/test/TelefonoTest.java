package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Favorito;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Telefono;
import co.edu.uniquindio.proyecto.repositorios.TelefonoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase
public class TelefonoTest {
    @Autowired
    private TelefonoRepo telefonoRepo;

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:telefono.sql"})
    public void agregarTelefonoTest(){
        Telefono telefonoNuevo= telefonoRepo.getOne(1);
        Telefono telefonoGuardado=telefonoRepo.save(telefonoNuevo);
        Assertions.assertNotNull(telefonoGuardado);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:telefono.sql"})
    public void eliminarTelefonoTest(){
        telefonoRepo.delete(telefonoRepo.getOne(2));
        Telefono buscado=telefonoRepo.findById(2).orElse(null);
        Assertions.assertNull(buscado);
    }
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:telefono.sql"})
    public void actulizarTelefonoTest(){
        Telefono registrado=telefonoRepo.getOne(2);
        registrado.setNumeroTelefono("7350001");

        telefonoRepo.save(registrado);
        Telefono buscado=telefonoRepo.findById(2).orElse(null);
        Assertions.assertEquals("7350001",buscado.getNumeroTelefono());
    }
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:telefono.sql"})
    public void listaTelefonoTest(){
        List<Telefono> lista = telefonoRepo.findAll();
        System.out.println("Listado de telefonos"+"\n"+lista);
    }


}
