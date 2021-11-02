package co.usa.reto3.reto3.service;
import co.usa.reto3.reto3.repository.ReservationRepository;
import co.usa.reto3.reto3.model.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();

    }
    public Optional <Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save (Reservation c) {
        if(c.getID()==null) {
            return reservationRepository.save(c);
        }
        else {
            Optional<Reservation> aux=reservationRepository.getReservation(c.getID());
            if(aux.isEmpty()) {
                return reservationRepository.save(c);
            }else {
                return c;
            }
        }

    }
}
