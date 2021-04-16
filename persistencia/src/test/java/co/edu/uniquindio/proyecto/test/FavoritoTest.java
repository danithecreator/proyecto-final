package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Favorito;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.repositorios.FavoritoRepo;
import co.edu.uniquindio.proyecto.repositorios.LugarRepo;
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
public class FavoritoTest {
    @Autowired
    private FavoritoRepo favoritoRepo;
    @Autowired
    private LugarRepo lugarRepo;

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:favorito.sql"})
    public void agregarFavoritoTest(){
        Favorito favoritoNuevo= favoritoRepo.getOne(1);
        Favorito favoritoGuardado=favoritoRepo.save(favoritoNuevo);
        Assertions.assertNotNull(favoritoGuardado);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:favorito.sql"})
    public void eliminarFavoritoTest(){
        favoritoRepo.delete(favoritoRepo.getOne(2));
        Favorito buscado=favoritoRepo.findById(2).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:favorito.sql"})
    public void actualizarFavoritoTest(){
        Favorito registrado=favoritoRepo.getOne(2);
        Lugar lugar=lugarRepo.getOne(3);
        registrado.setLugarFavorito(lugar);

        favoritoRepo.save(registrado);
        Favorito buscado=favoritoRepo.findById(2).orElse(null);
        Assertions.assertEquals(lugar,buscado.getLugarFavorito());
    }
    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:favorito.sql"})
    public void listaFavoritoTest(){
        List<Favorito> lista = favoritoRepo.findAll();

        System.out.println("Listado de favoritos"+"\n"+lista);
    }


}
