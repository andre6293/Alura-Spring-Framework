package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TopicoDto {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public TopicoDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public static List<TopicoDto> converter(List<Topico> listaTopicos) {
        List<TopicoDto> topicosDto = new ArrayList<>();
        listaTopicos.forEach(topico -> topicosDto.add(new TopicoDto(topico)));

//        return listaTopicos
//                .stream()
//                .map(TopicoDto::new)
//                .collect(Collectors.toList()); // modo da aula utilizando as vantagens do Java 8

//        return listaTopicos.stream()
//                .map(topico -> new TopicoDto(topico))
//                .collect(Collectors.toList()); // modo da aula sem method reference

        return topicosDto;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
