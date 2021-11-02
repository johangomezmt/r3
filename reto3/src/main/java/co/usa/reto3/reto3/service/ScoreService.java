package co.usa.reto3.reto3.service;
import co.usa.reto3.reto3.repository.ScoreRepository;
import co.usa.reto3.reto3.model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();

    }
    public Optional <Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    public Score save (Score c) {
        if(c.getID()==null) {
            return scoreRepository.save(c);
        }
        else {
            Optional<Score> aux=scoreRepository.getScore(c.getID());
            if(aux.isEmpty()) {
                return scoreRepository.save(c);
            }else {
                return c;
            }
        }

    }
}
