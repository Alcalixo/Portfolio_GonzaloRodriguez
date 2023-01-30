package com.portfolio.gnr.Service;

import com.portfolio.gnr.Entity.HardSoftSkill;
import com.portfolio.gnr.Repository.HardSoftSkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class HardSoftSkillService {
    @Autowired
    HardSoftSkillRepository hardSoftSkillRepository;
    
    public List<HardSoftSkill> list(){
        return hardSoftSkillRepository.findAll();
    }
    
    public Optional<HardSoftSkill> getOne(int id){
        return hardSoftSkillRepository.findById(id);
    }
    
    public Optional<HardSoftSkill> getByNombreS(String nombreS){
        return hardSoftSkillRepository.findByNombreS(nombreS);
    }
    
    public void save(HardSoftSkill Skill){
        hardSoftSkillRepository.save(Skill);
    }
    
    public void delete (int id){
        hardSoftSkillRepository.deleteById(id);
    }
    
    public boolean existsById (int id){
        return hardSoftSkillRepository.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreS){
        return hardSoftSkillRepository.existsByNombreS(nombreS);
    }
}
