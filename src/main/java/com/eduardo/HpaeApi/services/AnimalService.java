package com.eduardo.HpaeApi.services;

import com.eduardo.HpaeApi.DTO.AnimalDTO;
import com.eduardo.HpaeApi.entities.Animal;
import com.eduardo.HpaeApi.entities.Usuario;
import com.eduardo.HpaeApi.repositories.AnimalRepository;
import com.eduardo.HpaeApi.repositories.UsuarioRepository;
import com.eduardo.HpaeApi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    public Animal findByid(Long id){
        Optional<Animal> obj = animalRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado - " + id) );
    }

    public Animal create(AnimalDTO obj){
        obj.setId(null);
        Usuario dono = usuarioService.findByid(obj.getDono());
        Animal animal = createAnimal(obj, dono);
        return animalRepository.save(animal);
    }

    public void delete(Long id){
        findByid(id);
        animalRepository.deleteById(id);
    }

    public Animal update(Long id, Animal newObj){
        try {
            Animal oldObj = findByid(id);
            updateData(newObj, oldObj);
            return animalRepository.save(oldObj);
        }  catch(EntityNotFoundException e) {
            throw new ObjectNotFoundException("Animal não encontrado "+id);
        }
    }

    private void updateData(Animal newObj, Animal oldObj) {
        oldObj.setDataInicio(newObj.getDataInicio());
        oldObj.setDataFim(newObj.getDataFim());
        oldObj.setNomeAnimal(newObj.getNomeAnimal());
        oldObj.setRaca(newObj.getRaca());
        oldObj.setDono(newObj.getDono());
        oldObj.setValor(newObj.getValor());
    }

    public Animal createAnimal(AnimalDTO newObj, Usuario usuario){
        return new Animal(null, newObj.getDataInicio(), newObj.getDataFim(), newObj.getNomeAnimal(), newObj.getRaca(), usuario, newObj.getValor());
    }
}
