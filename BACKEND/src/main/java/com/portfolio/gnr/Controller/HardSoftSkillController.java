package com.portfolio.gnr.Controller;

import com.portfolio.gnr.Dto.DtoHardSoftSkill;
import com.portfolio.gnr.Entity.HardSoftSkill;
import com.portfolio.gnr.Security.Controller.Mensaje;
import com.portfolio.gnr.Service.HardSoftSkillService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hysSkill")
@CrossOrigin(origins = {"https://portfoliognr-argentinaprograma.web.app", "http://localhost:4200"})
public class HardSoftSkillController {

    @Autowired
    HardSoftSkillService hardSoftSkillService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HardSoftSkill>> list() {
        List<HardSoftSkill> list = hardSoftSkillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHardSoftSkill dtoHardSoftSkill) {
        //No puede estar vacío el campo
        if (StringUtils.isBlank(dtoHardSoftSkill.getNombreS())) {
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        //Validamos la existencia por nombre
        if (hardSoftSkillService.existsByNombreS(dtoHardSoftSkill.getNombreS())) {
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        HardSoftSkill hardSoftSkill = new HardSoftSkill(dtoHardSoftSkill.getNombreS(), dtoHardSoftSkill.getPorcentajeS(),
                dtoHardSoftSkill.getImgS());
        hardSoftSkillService.save(hardSoftSkill);

        return new ResponseEntity(new Mensaje("HardSoftSkill agregada con éxito"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHardSoftSkill dtoHardSoftSkill) {
        //Validamos la existencia por Id
        if (!hardSoftSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
        }
        //Validamos la existencia por nombre
        if (hardSoftSkillService.existsByNombreS(dtoHardSoftSkill.getNombreS())
                && hardSoftSkillService.getByNombreS(dtoHardSoftSkill.getNombreS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacío el campo
        if (StringUtils.isBlank(dtoHardSoftSkill.getNombreS())) {
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        HardSoftSkill hardSoftSkill = hardSoftSkillService.getOne(id).get();
        hardSoftSkill.setNombreS(dtoHardSoftSkill.getNombreS());
        hardSoftSkill.setPorcentajeS(dtoHardSoftSkill.getPorcentajeS());
        hardSoftSkill.setImgS(dtoHardSoftSkill.getImgS());

        hardSoftSkillService.save(hardSoftSkill);

        return new ResponseEntity(new Mensaje("HardSoftSkill Actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos la existencia por Id
        if (!hardSoftSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
        }

        hardSoftSkillService.delete(id);

        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<HardSoftSkill> getById(@PathVariable("id") int id) {
        if (!hardSoftSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe esa Id"), HttpStatus.NOT_FOUND);
        }
        HardSoftSkill hardSoftSkill = hardSoftSkillService.getOne(id).get();
        return new ResponseEntity(hardSoftSkill, HttpStatus.OK);
    }
}
