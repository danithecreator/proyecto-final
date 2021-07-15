package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.servicios.LugarServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    @Autowired
    private LugarServicio lugarServicio;

    @Getter @Setter
    private List<Lugar> lugares;

    @PostConstruct
    public void inicializar()
    {
        try {
            this.lugares = lugarServicio.listarLugares();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public String irADetalle(int id)
    {
        return "/detalleLugar?faces-redirect=true&amp;lugar="+id;

    }



 }
