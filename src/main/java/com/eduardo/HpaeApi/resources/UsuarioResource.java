package com.eduardo.HpaeApi.resources;

import com.eduardo.HpaeApi.DTO.UsuarioDTO;
import com.eduardo.HpaeApi.entities.Usuario;
import com.eduardo.HpaeApi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> findAll(){
        List<Usuario> listUsuarios = usuarioService.findAll();
        List<UsuarioDTO> listUsuarioDTO = listUsuarios.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
        return listUsuarioDTO;
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id){
        return usuarioService.findByid(id);
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario obj){
        return usuarioService.create(obj);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario obj){
        return usuarioService.update(id, obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        usuarioService.delete(id);
    }
}
