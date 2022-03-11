package com.eduardo.HpaeApi.services;

import com.eduardo.HpaeApi.DTO.UsuarioDTO;
import com.eduardo.HpaeApi.entities.Usuario;
import com.eduardo.HpaeApi.repositories.UsuarioRepository;
import com.eduardo.HpaeApi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findByid(Long id){
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado - " + id));
    }

    public Usuario create(Usuario obj){
        obj.setId(null);
        return usuarioRepository.save(obj);
    }

    public void delete(Long id){
        findByid(id);
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Long id, Usuario newObj){
        try {
            Usuario oldObj = findByid(id);
            updateData(newObj, oldObj);
            return usuarioRepository.save(oldObj);
        }  catch(EntityNotFoundException e) {
            throw new ObjectNotFoundException("Usuario não encontrado "+id);
        }
    }

    private void updateData(Usuario newObj, Usuario oldObj) {
        oldObj.setNome(newObj.getNome());
        oldObj.setEmail(newObj.getEmail());
        oldObj.setCpf(newObj.getCpf());
        oldObj.setAtivo(newObj.getAtivo());
    }
}
