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
<<<<<<< HEAD
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.file.UploadedFile;

=======
import org.primefaces.event.FlowEvent;
>>>>>>> cd30829744840c7ce455d9647b888043b5914fcf
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class LugarBean implements Serializable {

    @Getter
    @Setter
    private Lugar lugar;
<<<<<<< HEAD


    @Value("${upload.url}")
    private String urlImagenes;
    private ArrayList<String> imagenes;

=======
>>>>>>> cd30829744840c7ce455d9647b888043b5914fcf
    @Getter
    @Setter
    private boolean skip;

<<<<<<< HEAD
=======

>>>>>>> cd30829744840c7ce455d9647b888043b5914fcf
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
<<<<<<< HEAD
        this.imagenes = new ArrayList<>();
=======
>>>>>>> cd30829744840c7ce455d9647b888043b5914fcf
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

<<<<<<< HEAD
    public void crearLugar() {

        try {
            System.out.println(imagenes.size());
            System.out.println(lugar.getLatitud() + "," + lugar.getLongitud());
            if (lugar.getLatitud() != null && lugar.getLongitud() != null && !imagenes.isEmpty()) {
                lugar.setImagenes(imagenes);
                lugar.setUsuario(usuarioServicio.obtenerUsuario(2));


                lugarServicio.crearLugar(lugar);
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "El lugar fue creado exitosamente");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", msg);


            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "Es necesario ubicar el lugar dentro del mapa y subir al menos una imagen");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", msg);

            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
=======
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
>>>>>>> cd30829744840c7ce455d9647b888043b5914fcf
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", msg);

        }

    }

    public void subirImagenes(FileUploadEvent event) {
        UploadedFile imagen = event.getFile();
        String nombreImagen = subirImagen(imagen);
        if (nombreImagen != null) {
            imagenes.add(nombreImagen);
        }

    }

    public String subirImagen(UploadedFile file) {
        try {
            InputStream input = file.getInputStream();
            String filename = FilenameUtils.getName(file.getFileName());
            String basename = FilenameUtils.getBaseName(filename) + "_";
            String extension = "." + FilenameUtils.getExtension(filename);
            File fileDest = File.createTempFile(basename, extension, new File(urlImagenes));
            FileOutputStream output = new FileOutputStream(fileDest);
            IOUtils.copy(input, output);
            return fileDest.getName();
        } catch (Exception e) {
            e.printStackTrace();
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
<<<<<<< HEAD

=======
>>>>>>> cd30829744840c7ce455d9647b888043b5914fcf

}
