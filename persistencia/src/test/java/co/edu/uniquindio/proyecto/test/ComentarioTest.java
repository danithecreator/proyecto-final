package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComentarioTest {
    @Autowired
    private ComentarioRepo comentarioRepo;

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:comentario.sql"})
    public void agregarComentarioTest(){
        Comentario comentarioNuevo=comentarioRepo.getOne(1);
        Comentario comentarioGuardado=comentarioRepo.save(comentarioNuevo);
        Assertions.assertNotNull(comentarioGuardado);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:comentario.sql"})
    public  void eliminarComentarioTest(){
        comentarioRepo.delete(comentarioRepo.getOne(2));
        Comentario buscado=comentarioRepo.findById(2).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:comentario.sql"})
    public void actualizarComentarioTest(){
        Comentario registrado=comentarioRepo.getOne(1);
        registrado.setRespuesta("Gracias por comentar");
        comentarioRepo.save(registrado);
        System.out.println(registrado.getRespuesta());
        Comentario buscado=comentarioRepo.findById(1).orElse(null);
        Assertions.assertEquals("Gracias por comentar",buscado.getRespuesta());
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:comentario.sql"})
    public void listarComentarioTest(){
        List<Comentario> lista = comentarioRepo.findAll();
        System.out.println("Listado de comentarios"+"\n"+ lista);
    }

}
