package com.augusto.beltexam.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.augusto.beltexam.models.Waitstaff;
import com.augusto.beltexam.repositories.WaitstaffRepository;

@Service
public class WaitstaffService extends BaseService<Waitstaff>{

    private final WaitstaffRepository waitstaffRepository;

    public WaitstaffService(WaitstaffRepository waitstaffRepository) {
        super(waitstaffRepository);
        this.waitstaffRepository = waitstaffRepository;
    }
    
    //Registrar el waitstaff y hacer Hash a su password
    public Waitstaff registerWaitstaff(Waitstaff waitstaff) {
        String hashed = BCrypt.hashpw(waitstaff.getPassword(), BCrypt.gensalt());
        waitstaff.setPassword(hashed);
        return waitstaffRepository.save(waitstaff);
    }

    //Encontrar un waitstaff por su email
    public Waitstaff findByEmail(String email) {
        return waitstaffRepository.findByEmail(email);
    }

    //Log In Waitstaff
    public boolean authenticateWaitstaff(String email, String password) {
        
        Waitstaff waitstaff = waitstaffRepository.findByEmail(email);

        if (waitstaff == null) {
            return false;
        } else {
            if (BCrypt.checkpw(password, waitstaff.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
