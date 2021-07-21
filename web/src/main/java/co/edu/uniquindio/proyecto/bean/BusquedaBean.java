package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.dto.LugarDTO;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.servicios.LugarServicio;
import com.google.gson.Gson;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ViewScoped
public class BusquedaBean implements Serializable {

    private String busqueda;

    @Value("#{param['busqueda']}")
    private String busquedaParam;

    private List<Lugar> lugares;

    @Autowired
    private LugarServicio lugarServicio;

    @PostConstruct
    public void inicializar() {

        if (busquedaParam != null && !busquedaParam.isEmpty()) {
            lugares = lugarServicio.buscarLugares(busquedaParam);
            List<LugarDTO> markerLugares = this.lugares.stream().map(l -> new LugarDTO(l.getCodigo(), l.getNombre(), l.getDescripcion(), l.getLatitud(), l.getLongitud(), l.getTipo().getNombre())).collect(Collectors.toList());

            PrimeFaces.current().executeScript("crearMapa(" + new Gson().toJson(markerLugares) + ")");
        }

    }

    public String buscar() {
        if (!busqueda.isEmpty()) {
            return "resultadoBusqueda?faces-redirect=true&amp;busqueda=" + busqueda;
        }
        return "";
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public String getBusquedaParam() {
        return busquedaParam;
    }

    public void setBusquedaParam(String busquedaParam) {
        this.busquedaParam = busquedaParam;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }
}
