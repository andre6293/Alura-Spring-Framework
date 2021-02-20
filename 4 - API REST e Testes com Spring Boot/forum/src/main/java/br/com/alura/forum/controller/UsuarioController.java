package br.com.alura.forum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    private void criarUsuario() {}

    @RequestMapping(value = "/usuario", method = RequestMethod.DELETE)
    private void removerUsuario() {}



}
