package com.facundogaitansegura.Portfolio.Controller;

import com.facundogaitansegura.Portfolio.Dto.dtoBanner;
import com.facundogaitansegura.Portfolio.Entity.Banner;
import com.facundogaitansegura.Portfolio.Security.Controller.Mensaje;
import com.facundogaitansegura.Portfolio.Service.SBanner;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/banner")
@CrossOrigin(origins = {"https://portfoliofacundo.web.app","http://localhost:4200"})
public class CBanner {
    @Autowired
    SBanner sBanner;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Banner>> list(){
        List<Banner> list = sBanner.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Banner> getById(@PathVariable("id")int id){
        if(!sBanner.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Banner banner = sBanner.getOne(id).get();
        return new ResponseEntity(banner, HttpStatus.OK);
    }
    
    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sBanner.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sBanner.delete(id);
        return new ResponseEntity(new Mensaje("Banner eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByNombre(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(
                dtoeducacion.getNombre(), 
                dtoeducacion.getDescripcion(),
                dtoeducacion.getImg(),
                dtoeducacion.getLink()
            );
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
                
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBanner dtobanner){
        if(!sBanner.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sBanner.existsByNombre(dtobanner.getNombre()) && sBanner.getByNombre(dtobanner.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtobanner.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Banner banner = sBanner.getOne(id).get();
        
        banner.setNombre(dtobanner.getNombre());
        banner.setDescripcion(dtobanner.getDescripcion());
        banner.setImg(dtobanner.getImg());       
        
        sBanner.save(banner);
        
        return new ResponseEntity(new Mensaje("Banner actualizado"), HttpStatus.OK);
    }
}