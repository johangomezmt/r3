package co.usa.reto3.reto3.service;
import co.usa.reto3.reto3.model.Message;
import co.usa.reto3.reto3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();

    }
    public Optional <Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save (Message c) {
        if(c.getIdMessage()==null) {
            return messageRepository.save(c);
        }
        else {
            Optional<Message> aux=messageRepository.getMessage(c.getIdMessage());
            if(aux.isEmpty()) {
                return messageRepository.save(c);
            }else {
                return c;
            }
        }

    }
}
