package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModeradorServicioImpl implements ModeradorServicio{

    private final ModeradorRepo moderadorRepo;

    public ModeradorServicioImpl(ModeradorRepo moderadorRepo) {
        this.moderadorRepo = moderadorRepo;
    }

    @Override
    public Moderador registrarModerador(Moderador m) throws Exception {

        if(!nicknameEstaDisponible(m.getNickname())){
            throw new Exception("El nickname no esta disponible");
        }
        if(!emailEstaDisponible(m.getEmail())){
            throw new Exception("El email no esta disponible" );
        }
        if(m.getNickname().length()>255)
        {
            throw new Exception("El nickname debe ser menor a 255 caracteres" );
        }
        if(m.getEmail().length()>255)
        {
            throw new Exception("El email debe ser menor a 255 caracteres" );
        }

        return  moderadorRepo.save(m);
    }

    public boolean nicknameEstaDisponible(String nickname){
        Optional<Moderador> moderadorNick= moderadorRepo.findByNickname(nickname);
        return moderadorNick.isEmpty();
    }

    public boolean emailEstaDisponible(String email){
        Optional<Moderador> moderadorEmail= moderadorRepo.findByEmail(email);
        return moderadorEmail.isEmpty();
    }

    public boolean estaUsuario(int id){
        Optional<Moderador> moderador= moderadorRepo.findById(id);
        return moderador.isEmpty();
    }
}
