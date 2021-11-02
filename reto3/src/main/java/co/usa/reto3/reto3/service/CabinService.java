package co.usa.reto3.reto3.service;
import co.usa.reto3.reto3.repository.CabinRepository;
import co.usa.reto3.reto3.model.Cabin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CabinService {

    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getAll(){
        return cabinRepository.getAll();

    }
    public Optional <Cabin> getCabin(int id){
        return cabinRepository.getCabin(id);
    }
    public Cabin save (Cabin c) {
        if(c.getId()==null) {
            return cabinRepository.save(c);
        }
        else {
            Optional<Cabin> aux=cabinRepository.getCabin(c.getId());
            if(aux.isEmpty()) {
                return cabinRepository.save(c);
            }else {
                return c;
            }
        }

    }
}
