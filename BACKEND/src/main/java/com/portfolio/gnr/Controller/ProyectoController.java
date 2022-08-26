package com.portfolio.gnr.Controller;

import com.portfolio.gnr.Dto.DtoProyectos;
import com.portfolio.gnr.Entity.Proyectos;
import com.portfolio.gnr.Security.Controller.Mensaje;
import com.portfolio.gnr.Service.ProyectosService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://portfoliognr-argentinaprograma.web.app")
//@CrossOrigin (origins = "http://localhost:8080")
public class ProyectoController {

    @Autowired
    ProyectosService proyectosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProyectos) {
        if (StringUtils.isBlank(dtoProyectos.getNombreP())) {
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (proyectosService.existsByNombreP(dtoProyectos.getNombreP())) {
            return new ResponseEntity(new Mensaje("Ese Nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = new Proyectos(dtoProyectos.getNombreP(),
                dtoProyectos.getDescripcionP(),
                dtoProyectos.getUrlImgP());
        proyectosService.save(proyectos);

        return new ResponseEntity(new Mensaje("Proyecto agregado con éxito"), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoProyectos) {
        //Validamos la existencia por Id
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
        }
        //Validamos la existencia por nombre
        if (proyectosService.existsByNombreP(dtoProyectos.getNombreP())
                && proyectosService.getByNombreP(dtoProyectos.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacío el campo
        if (StringUtils.isBlank(dtoProyectos.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = proyectosService.getOne(id).get();
        proyectos.setNombreP(dtoProyectos.getNombreP());
        proyectos.setDescripcionP(dtoProyectos.getDescripcionP());
        proyectos.setUrlImg(dtoProyectos.getUrlImgP());

        proyectosService.save(proyectos);

        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id
    ) {
        //Validamos la existencia por Id
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
        }

        proyectosService.delete(id);

        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id
    ) {
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe esa Id"), HttpStatus.NOT_FOUND);
        }
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
}
