package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Favorito;
import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.repositorios.HorarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HorarioTest {
    @Autowired
    private HorarioRepo horarioRepo;

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:horario.sql"})
    public void agregarHorarioTest(){
        Horario horarioNuevo= horarioRepo.getOne(1);
        Horario horarioGuardado=horarioRepo.save(horarioNuevo);
        Assertions.assertNotNull(horarioGuardado);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:horario.sql"})
    public void eliminarHorarioTest(){
        horarioRepo.delete(horarioRepo.getOne(2));
        Horario buscado=horarioRepo.findById(2).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:horario.sql"})
    public void actualizarHorarioTest(){
        Horario registrado=horarioRepo.getOne(2);

        String horaNueva = "19:00:00";


        try {
            Date hora= new SimpleDateFormat("HH:mm:ss").parse(horaNueva);
            registrado.setHoraCierre(hora);
            horarioRepo.save(registrado);

            Horario buscado=horarioRepo.findById(2).orElse(null);
            Assertions.assertEquals(hora,buscado.getHoraCierre());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    @Sql({"classpath:ciudad.sql","classpath:tipo.sql","classpath:usuario.sql","classpath:administrador.sql","classpath:moderador.sql","classpath:lugar.sql","classpath:horario.sql"})
    public void listaHorariosTest(){
        List<Horario> lista = horarioRepo.findAll();
        System.out.println("Listado de Horarios"+"\n"+lista);
    }







}
