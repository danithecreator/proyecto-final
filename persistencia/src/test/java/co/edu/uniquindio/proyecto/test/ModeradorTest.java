package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ModeradorTest {
    @Autowired
    private ModeradorRepo moderadorRepo;

    @Test
    @Sql({"classpath:ciudad.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql"})
    public void registrarModeradorTest(){
        Moderador moderadorNuevo=moderadorRepo.getOne(1);
        Moderador moderadorGuardado=moderadorRepo.save(moderadorNuevo);
        Assertions.assertNotNull(moderadorGuardado);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql"})
    public void eliminarModeradorTest(){
        moderadorRepo.delete(moderadorRepo.getOne(2));
        Moderador buscado=moderadorRepo.findById(2).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql"})
    public void actulizarModeradorTest(){
        Moderador registrado=moderadorRepo.getOne(2);
        registrado.setNombre("Angy");
        moderadorRepo.save(registrado);
        Moderador buscado=moderadorRepo.findById(2).orElse(null);
        Assertions.assertEquals("Angy",buscado.getNombre());
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql"})
    public void listarModeradorTest(){
        List<Moderador> lista = moderadorRepo.findAll();

        System.out.println("Listado de Moderadores"+"\n"+ lista);
    }
}
