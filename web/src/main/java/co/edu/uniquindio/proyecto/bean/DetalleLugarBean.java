package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.dto.LugarDTO;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.servicios.LugarServicio;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class DetalleLugarBean implements Serializable {

    @Value("#{param['lugar']}")
    private String idLugar;

    @Autowired
    private LugarServicio lugarServicio;

    @Getter
    @Setter
    private Lugar lugar;

    @Getter
    @Setter
    private List<Comentario> comentarios;

    @Getter
    @Setter
    private List<Horario> horarios;

    private List<String> images;

    @PostConstruct
    public void inicializar() {

        try {
<<<<<<< HEAD


            int id = Integer.parseInt(idLugar);
            this.images = lugarServicio.obtenerLugar(id).getImagenes();
            this.lugar = lugarServicio.obtenerLugar(id);
            this.comentarios = lugarServicio.listarComentariosDeUnLugar(id);

//            LugarDTO markerLugar = new LugarDTO(this.lugar.getCodigo(), this.lugar.getNombre(), this.lugar.getDescripcion(), this.lugar.getLatitud(), this.lugar.getLongitud(), this.lugar.getTipo().getNombre());
=======
            int id = Integer.parseInt(idLugar);
            this.lugar = lugarServicio.obtenerLugar(id);

            LugarDTO markerLugar = new LugarDTO(this.lugar.getCodigo(), this.lugar.getNombre(), this.lugar.getDescripcion(), this.lugar.getLatitud(), this.lugar.getLongitud(), this.lugar.getTipo().getNombre());

            PrimeFaces.current().executeScript("testMap(" + new Gson().toJson(markerLugar) + ")");
>>>>>>> cd30829744840c7ce455d9647b888043b5914fcf

        } catch (Exception e) {
            e.printStackTrace();
        }

<<<<<<< HEAD
    }

    public List<String> getImages() {
        return images;
=======
>>>>>>> cd30829744840c7ce455d9647b888043b5914fcf
    }


}
