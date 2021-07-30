package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.dto.LugarDTO;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.servicios.LugarServicio;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ViewScoped
public class BusquedaBean implements Serializable {

    @Getter
    @Setter
    private String busqueda;

    @Value("#{param['search']}")
    private String busquedaParam;

    @Getter
    @Setter
    private List<Lugar> lugares;

    @Getter
    @Setter
    private Lugar lugar;


    @Autowired
    private LugarServicio lugarServicio;

    @PostConstruct
    public void inicializar() {
        System.out.println("parametro:" + busquedaParam);
        if (busquedaParam != null && !busquedaParam.isEmpty()) {
            System.out.println(busquedaParam);
            lugares = lugarServicio.buscarLugares(busquedaParam);
            System.out.println(lugares.get(0).getNombre());
            List<LugarDTO> markerLugares = this.lugares.stream().map(l -> new LugarDTO(l.getCodigo(), l.getNombre(), l.getDescripcion(), l.getLatitud(), l.getLongitud(), l.getTipo().getNombre())).collect(Collectors.toList());

            PrimeFaces.current().executeScript("crearMapa(" + new Gson().toJson(markerLugares) + ")");
        }

    }

    public String buscar() {
        System.out.println(busqueda);
        

        if (!busqueda.isEmpty()) {
            return "resultadoBusqueda?faces-redirect=true&amp;search=" + busqueda;
        }
        return "";
    }


}
