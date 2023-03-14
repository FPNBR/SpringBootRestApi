package br.com.fpnbr.springbootrestapi.controllers;

import br.com.fpnbr.springbootrestapi.models.Usuario;
import br.com.fpnbr.springbootrestapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringBootRestApiController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/mostrarnome/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return  "Hello " + name + "!";
    }

    @RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String retornaOlaMundo(@PathVariable String nome) {

        Usuario usuario = new Usuario();
        usuario.setNome(nome);

        usuarioRepository.save(usuario);

        return "Olá mundo " + nome;
    }
}
