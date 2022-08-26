package com.portfolio.gnr.Controller;

import com.portfolio.gnr.Dto.DtoExperiencia;
import com.portfolio.gnr.Entity.Experiencia;
import com.portfolio.gnr.Security.Controller.Mensaje;
import com.portfolio.gnr.Service.ExperienciaService;
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
@RequestMapping("explab")
@CrossOrigin(origins = "https://portfoliognr-argentinaprograma.web.app")
//@CrossOrigin (origins = "http://localhost:8080")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExperiencia) {
        if (StringUtils.isBlank(dtoExperiencia.getNombreE())) {
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (experienciaService.existsByNombreE(dtoExperiencia.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoExperiencia.getNombreE(), dtoExperiencia.getDescripcionE(), dtoExperiencia.getUrlImgE());
        experienciaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada con éxito"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExperiencia) {
        //Validamos la existencia por Id
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Validamos la existencia por nombre
        if (experienciaService.existsByNombreE(dtoExperiencia.getNombreE()) 
                && experienciaService.getByNombreE(dtoExperiencia.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacío el campo
        if (StringUtils.isBlank(dtoExperiencia.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setNombreE(dtoExperiencia.getNombreE());
        experiencia.setDescripcionE(dtoExperiencia.getDescripcionE());
        experiencia.setUrlImgE(dtoExperiencia.getUrlImgE());

        experienciaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos la existencia por Id
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }

        experienciaService.delete(id);

        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
