package co.edu.uniquindio.proyecto.test;

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

/**
 * Esta clase permite testear la entidad telefono
 * @author: Daniel Ceballos, Angy Tabares
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TelefonoTest {
    @Autowired
    private TelefonoRepo telefonoRepo;

    /**
     * metodo para verificar si se ha agregado un telefono correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:telefono.sql"})
    public void agregarTelefonoTest(){
        Telefono telefonoNuevo= telefonoRepo.getOne(1);
        Telefono telefonoGuardado=telefonoRepo.save(telefonoNuevo);
        Assertions.assertNotNull(telefonoGuardado);
    }

    /**
     * metodo para verificar si se ha eliminado un telefono correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:telefono.sql"})
    public void eliminarTelefonoTest(){
        telefonoRepo.delete(telefonoRepo.getOne(2));
        Telefono buscado=telefonoRepo.findById(2).orElse(null);
        Assertions.assertNull(buscado);
    }

    /**
     * metodo para verificar si se ha actualizado un telefono correctamente
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:telefono.sql"})
    public void actulizarTelefonoTest(){
        Telefono registrado=telefonoRepo.getOne(2);
        registrado.setNumeroTelefono("7350001");

        telefonoRepo.save(registrado);
        Telefono buscado=telefonoRepo.findById(2).orElse(null);
        Assertions.assertEquals("7350001",buscado.getNumeroTelefono());
    }

    /**
     * metodo para listar los telefonos
     * se añaden a la anotacion  sql los archivos necesarios para este test
     */
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:telefono.sql"})
    public void listaTelefonoTest(){
        List<Telefono> lista = telefonoRepo.findAll();
        System.out.println("Listado de telefonos"+"\n"+lista);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:telefono.sql"})
    public void obtenerLugarPorNumeroTelefonoTest(){
        Lugar lugar = telefonoRepo.obtenerLugarPorNumeroTelefono("3160025489");
        System.out.println(lugar);
    }

}
