package co.edu.uniquindio.proyecto.config;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.ElementCollection;
import java.util.ArrayList;


@Component
public class InformacionPorDefecto implements CommandLineRunner {

    @Autowired
    private AdministradorServicio adminService;

    @Autowired
    private CiudadServicio ciudadServicio;

    @Autowired
    private TipoServicio tipoServicio;

    @Autowired
    private LugarServicio lugarServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ComentarioServicio comentarioServicio;

    @Override
    public void run(String... args) throws Exception {

    /*    if(adminService.existenAdmins())
        {
            Administrador ad1= Administrador.builder().n;
        }

     */

        if(ciudadServicio.listarCiudades().isEmpty())
        {
            Ciudad c1= new Ciudad("Armenia");
            Ciudad c2= new Ciudad("Cali");
            Ciudad c3= new Ciudad("Pereira");
            Ciudad c4= new Ciudad("Medellin");

            ciudadServicio.registrarCiudad(c1);
            ciudadServicio.registrarCiudad(c2);
            ciudadServicio.registrarCiudad(c3);
            ciudadServicio.registrarCiudad(c4);
        }

        if(tipoServicio.listarTiposLugares().isEmpty()) {
            Tipo t1 = new Tipo("Restaurante");
            Tipo t2 = new Tipo("Hotel");
            Tipo t3 = new Tipo("Cafe");
            Tipo t4 = new Tipo("Bar");

            tipoServicio.registrarTipoLugar(t1);
            tipoServicio.registrarTipoLugar(t2);
            tipoServicio.registrarTipoLugar(t3);
            tipoServicio.registrarTipoLugar(t4);

        }

        if(lugarServicio.listarLugares().isEmpty()) {
            Lugar l1 = Lugar.builder().nombre("Cafe de la 25")
                    .ciudadLugar(ciudadServicio.obtenerCiudad(1))
                    .descripcion("Es un café muy rico")
                    .latitud(1.22F)
                    .longitud(1.33F)
                    .usuario(usuarioServicio.obtenerUsuario(2))
                    .imagenes(new ArrayList<>())
                    .tipo(tipoServicio.obtenerTipoLugar(3))
                    .horarios(new ArrayList<>()).build();

            Lugar l2 = Lugar.builder().nombre("Hotel de la 25")
                    .ciudadLugar(ciudadServicio.obtenerCiudad(1))
                    .descripcion("Es un hotel muy economico")
                    .latitud(1.22F)
                    .longitud(1.33F)
                    .usuario(usuarioServicio.obtenerUsuario(2))
                    .imagenes(new ArrayList<>())
                    .tipo(tipoServicio.obtenerTipoLugar(2))
                    .horarios(new ArrayList<>()).build();

            lugarServicio.crearLugar(l1);
            lugarServicio.crearLugar(l2);
        }

        Comentario co1= Comentario.builder()
                .comentario("Este lugar es bueno")
                .calificacion(5)
                .lugarComentario(lugarServicio.obtenerLugar(2))
                .usuarioComentario(usuarioServicio.obtenerUsuario(2)).build();

        Comentario co2= Comentario.builder()
                .comentario("Este lugar es genial")
                .calificacion(4)
                .lugarComentario(lugarServicio.obtenerLugar(1))
                .usuarioComentario(usuarioServicio.obtenerUsuario(3)).build();


        comentarioServicio.crearComentario(co1);
        comentarioServicio.crearComentario(co2);
    }
}
