package com.pedro.usuariosservice.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoCriadoEvent extends ApplicationEvent {

    private final Integer id;
    private transient HttpServletResponse response;
    private String numero;

    public RecursoCriadoEvent(Object source, HttpServletResponse response, Integer id) {
        super(source);
        this.response = response;
        this.id = id;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Integer getId() { return id; }
}