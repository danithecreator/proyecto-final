package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Tipo;
import co.edu.uniquindio.proyecto.repositorios.TipoRepo;
import org.springframework.stereotype.Service;

@Service
public class TipoServicioImpl implements TipoServicio{

    private final TipoRepo tipoRepo;

    public TipoServicioImpl(TipoRepo tipoRepo) {
        this.tipoRepo = tipoRepo;
    }

    @Override
    public Tipo registrarTipo(Tipo t) throws Exception {
        return tipoRepo.save(t);
    }
}
