package kz.pavel.crm.service;

import kz.pavel.crm.entity.Check;
import kz.pavel.crm.repository.CheckRepository;
import kz.pavel.crm.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CheckService {

    private final CheckRepository checkRepository;

    @Autowired
    public CheckService(CheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    public Check getCheck(Long id) {
        Optional<Check> check = checkRepository.findById(id);
        return check.orElseThrow(EntityNotFoundException::new);
    }

    public Check saveCheck(Check check) {
        return checkRepository.save(check);
    }

    public void deleteCheck(Long id) {
        checkRepository.deleteById(id);
    }


}
