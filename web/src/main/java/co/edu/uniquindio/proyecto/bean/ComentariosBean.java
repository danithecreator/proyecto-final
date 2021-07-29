package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.servicios.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.LugarServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class ComentariosBean implements Serializable {

    @Value("#{param['lugar']}")
    private String idLugar;

    @Value(value="#{seguridadBean.persona}")
    private Persona personaLogin;

    @Autowired
    private LugarServicio lugarServicio;

    @Autowired
    private ComentarioServicio comentarioServicio;

    @Getter @Setter
    private Lugar lugar;

    @Getter @Setter
    private List<Horario> horarios;

    private List<String> images;

    @Getter @Setter
    private List<Comentario> comentarios;

    @Getter @Setter
    private Comentario comentario;

    @Getter @Setter
    private String respuesta;


    @PostConstruct
    public void inicializar() {
        // this.icono = "pi pi-star-o";
        try {
            images = new ArrayList<String>();

            images.add("https://www.eltiempo.com/files/image_640_428/uploads/2019/03/30/5ca02668e04df.jpeg");
            images.add("https://www.revistalabarra.com/wp-content/uploads/2019/02/Potada-nota-enano-1500x800.jpg");
            images.add("https://www.entornoturistico.com/wp-content/uploads/2016/06/clientes-en-un-bar-660x330.jpg");

            int id = Integer.parseInt(idLugar);
            this.lugar = lugarServicio.obtenerLugar(id);
            this.comentarios = lugarServicio.listarComentariosDeUnLugar(id);

//            LugarDTO markerLugar = new LugarDTO(this.lugar.getCodigo(), this.lugar.getNombre(), this.lugar.getDescripcion(), this.lugar.getLatitud(), this.lugar.getLongitud(), this.lugar.getTipo().getNombre());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void responderComentario(Comentario comentario)
    {
        try {
            comentario.setRespuesta(this.respuesta);
            comentarioServicio.actualizarComentario(comentario);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hayRespuesta(Comentario comentario)
    {
        if(comentario.getRespuesta()==null)
        {
            return false;
        }
        return true;
    }
}
