package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class UsuarioBean implements Serializable {

    @Autowired
    private UsuarioServicio usuarioServicio;
    private Usuario usuario;

    @PostConstruct
    public void inicializar()
    {
        this.usuario= new Usuario();
    }

    public void registrarUsuario()
    {
        try {
            usuarioServicio.registrarUsuario(usuario);
            FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","El registro fue exitoso");
            FacesContext.getCurrentInstance().addMessage("mensaje-p",msg);

        } catch (Exception e) {
            FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje-p",msg);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
