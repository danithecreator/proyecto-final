package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorServicioImpl implements AdministradorServicio{

    private final AdministradorRepo administradorRepo;

    public AdministradorServicioImpl(AdministradorRepo administradorRepo) {
        this.administradorRepo = administradorRepo;
    }

    @Override
    public Administrador registrarAdmin(Administrador admin) throws Exception {
        if(!nicknameEstaDisponible(admin.getNickname())){
            throw new Exception("El nickname no esta disponible");
        }
        if(!emailEstaDisponible(admin.getEmail())){
            throw new Exception("El email no esta disponible" );
        }
        if(admin.getNickname().length()>255)
        {
            throw new Exception("El nickname debe ser menor a 255 caracteres" );
        }
        if(admin.getEmail().length()>255)
        {
            throw new Exception("El email debe ser menor a 255 caracteres" );
        }

        return  administradorRepo.save(admin);
    }

    public boolean nicknameEstaDisponible(String nickname){
        Optional<Administrador> administradorNick= administradorRepo.findByNickname(nickname);
        return administradorNick.isEmpty();
    }

    public boolean emailEstaDisponible(String email){
        Optional<Administrador> administradorEmail= administradorRepo.findByEmail(email);
        return administradorEmail.isEmpty();
    }

    public boolean estaUsuario(int id){
        Optional<Administrador> administrador= administradorRepo.findById(id);
        return administrador.isEmpty();
    }
}
