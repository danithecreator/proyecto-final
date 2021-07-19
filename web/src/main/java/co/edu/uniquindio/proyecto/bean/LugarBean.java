package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Tipo;
import co.edu.uniquindio.proyecto.servicios.CiudadServicio;
import co.edu.uniquindio.proyecto.servicios.LugarServicio;
import co.edu.uniquindio.proyecto.servicios.TipoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class LugarBean implements Serializable {

    @Getter
    @Setter
    private Lugar lugar;
    @Getter
    @Setter
    private boolean skip;


    private final LugarServicio lugarServicio;
    private final CiudadServicio ciudadServicio;
    private final UsuarioServicio usuarioServicio;
    private final TipoServicio tipoServicio;

    @Getter
    @Setter
    private List<Ciudad> ciudades;

    @Getter
    @Setter
    private List<Tipo> tipoLugares;


    public LugarBean(LugarServicio lugarServicio, CiudadServicio ciudadServicio, UsuarioServicio usuarioServicio, TipoServicio tipoServicio) {
        this.lugarServicio = lugarServicio;
        this.ciudadServicio = ciudadServicio;
        this.usuarioServicio = usuarioServicio;
        this.tipoServicio = tipoServicio;
    }

    @PostConstruct
    public void inicializar() {
        this.lugar = new Lugar();
        this.ciudades = ciudadServicio.listarCiudades();
        this.tipoLugares = tipoServicio.listarTiposLugares();
    }

    public String crearLugar() {

        try {
            System.out.println(lugar.getLatitud() + "," + lugar.getLongitud());
            if (lugar.getLatitud() != null && lugar.getLongitud() != null) {

                lugar.setUsuario(usuarioServicio.obtenerUsuario(2));


                lugarServicio.crearLugar(lugar);

                return "lugarCreado?faces-redirect=true";
            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "Es necesario ubicar el lugar dentro del mapa");
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", msg);

        }

        return null;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;    //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

}
