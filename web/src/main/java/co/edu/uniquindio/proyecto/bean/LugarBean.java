package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.servicios.CiudadServicio;
import co.edu.uniquindio.proyecto.servicios.LugarServicio;
import co.edu.uniquindio.proyecto.servicios.TipoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@RequestScope
public class LugarBean implements Serializable {

    private Lugar lugar;
    private final LugarServicio lugarServicio;
    private final CiudadServicio ciudadServicio;
    private final UsuarioServicio usuarioServicio;
    private final TipoServicio tipoServicio;

    public LugarBean(LugarServicio lugarServicio, CiudadServicio ciudadServicio,UsuarioServicio usuarioServicio,TipoServicio tipoServicio) {
        this.lugarServicio = lugarServicio;
        this.ciudadServicio= ciudadServicio;
        this.usuarioServicio= usuarioServicio;
        this.tipoServicio= tipoServicio;
    }

    @PostConstruct
    public void inicializar()
    {
        lugar= new Lugar();

    }
    public String crearLugar()
    {
        try{
            lugar.setCiudadLugar(ciudadServicio.obtenerCiudad(1));
            lugar.setUsuario(usuarioServicio.obtenerUsuario(1));
            lugar.setTipo(tipoServicio.obtenerTipoLugar(1));

            lugarServicio.crearLugar(lugar);

            return "lugarCreado?faces-redirect=true";
        }catch(Exception e)
        {
            FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,msg);

        }

        return null;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
}
