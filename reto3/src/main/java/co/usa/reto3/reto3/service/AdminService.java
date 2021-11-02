package co.usa.reto3.reto3.service;
import co.usa.reto3.reto3.repository.AdminRepository;
import co.usa.reto3.reto3.model.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();

    }
    public Optional <Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    public Admin save (Admin c) {
        if(c.getID()==null) {
            return adminRepository.save(c);
        }
        else {
            Optional<Admin> aux=adminRepository.getAdmin(c.getID());
            if(aux.isEmpty()) {
                return adminRepository.save(c);
            }else {
                return c;
            }
        }

    }
}
