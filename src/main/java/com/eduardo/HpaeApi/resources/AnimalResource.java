package com.eduardo.HpaeApi.resources;

import com.eduardo.HpaeApi.DTO.AnimalDTO;
import com.eduardo.HpaeApi.entities.Animal;
import com.eduardo.HpaeApi.entities.Usuario;
import com.eduardo.HpaeApi.services.AnimalService;
import com.eduardo.HpaeApi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/animais")
public class AnimalResource {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> findAll(){
        List<Animal> listUsuarios = animalService.findAll();
        return listUsuarios;
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable Long id){
        return animalService.findByid(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Animal create(@RequestBody AnimalDTO obj){
        return animalService.create(obj);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Animal update(@PathVariable Long id, @RequestBody Animal obj){
        return animalService.update(id, obj);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        animalService.delete(id);
    }
}
