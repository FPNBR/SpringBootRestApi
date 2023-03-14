package br.com.fpnbr.springbootrestapi.controllers;

import br.com.fpnbr.springbootrestapi.models.Usuario;
import br.com.fpnbr.springbootrestapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "listarUsuarios")
    @ResponseBody // Retorna os dados para ao corpo da requisição
    public ResponseEntity<List<Usuario>> usuarioList() {
        List<Usuario> usuarioList = usuarioRepository.findAll(); // Executa a consulta no banco de dados

        return new ResponseEntity<>(usuarioList, HttpStatus.OK); // Retorna a lista em JSON
    }

    @PostMapping(value = "salvarUsuario")
    @ResponseBody // Descrição da resposta
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) { // Recebe os dados para salvar
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
    }
}
