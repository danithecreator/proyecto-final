package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    @Sql({"classpath:ciudad.sql","classpath:usuario.sql"})
    public void registrarUsuarioTest(){
        Usuario usuarioNuevo=usuarioRepo.getOne(1);
        Usuario usuarioGuardado=usuarioRepo.save(usuarioNuevo);
        Assertions.assertNotNull(usuarioGuardado);
    }
    @Test
    @Sql({"classpath:ciudad.sql","classpath:usuario.sql"})
    public void eliminarUsuarioTest(){
        usuarioRepo.delete(usuarioRepo.getOne(2));
        Usuario buscado=usuarioRepo.findById(2).orElse(null);
        Assertions.assertNull(buscado);
    }
    @Test
    @Sql({"classpath:ciudad.sql","classpath:usuario.sql"})
    public void actualizarUsuarioTest(){
        Usuario registrado=usuarioRepo.getOne(2);
        registrado.setNombre("Paola");
        usuarioRepo.save(registrado);
        Usuario buscado=usuarioRepo.findById(2).orElse(null);
        Assertions.assertEquals("Paola",buscado.getNombre());
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:usuario.sql"})
    public void listarUsuarioTest(){
        List<Usuario> lista = usuarioRepo.findAll();

        System.out.println("Listado de usuarios"+"\n"+ lista);
    }


}
