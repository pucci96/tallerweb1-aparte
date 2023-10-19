package com.tallerwebi.dominio;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;


public class UsuarioTest {

    @Test
    public void queCreeUsuarioDeFormaCorrecta(){
        Usuario prueba1 = new Usuario();

        Long valorID = 1L;
        String valorEmail = "Prueba123@gmail.com";
        String valorPass = "1234";
        String valorRol = "ADMIN";

        prueba1.setId(1L);
        prueba1.setEmail("Prueba123@gmail.com");
        prueba1.setPassword("1234");
        prueba1.setRol("ADMIN");

        assertThat(prueba1.getId(),is(equalTo(valorID)));
        assertThat(prueba1.getEmail(),is(equalTo(valorEmail)));
        assertThat(prueba1.getPassword(),is(equalTo(valorPass)));
        assertThat(prueba1.getRol(),is(equalTo(valorRol)));
    }

    @Test
    public void queDevuelvaEstadoActivo(){
        Usuario prueba2 = new Usuario();
        prueba2.setId(1L);
        prueba2.setEmail("Prueba123@gmail.com");
        prueba2.setPassword("1234");
        prueba2.setRol("ADMIN");

        assertThat(prueba2.activo(),is(equalTo(false)));
    }

    @Test
    public void queActiveUsuarioCorrectamente(){
        Usuario prueba3 = new Usuario();
        prueba3.setId(1L);
        prueba3.setEmail("Prueba123@gmail.com");
        prueba3.setPassword("1234");
        prueba3.setRol("ADMIN");

        prueba3.activar();

        assertThat(prueba3.activo(),is(equalTo(true)));
    }
}
