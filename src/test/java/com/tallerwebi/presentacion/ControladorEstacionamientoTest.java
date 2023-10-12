package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Usuario;
import com.tallerwebi.dominio.Estacionamiento;
import com.tallerwebi.dominio.ServicioEstacionamiento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ControladorEstacionamientoTest {

    private ControladorEstacionamiento cEst;
    private ServicioEstacionamiento sEst;
    private Estacionamiento est;

    @BeforeEach
    public void setup() {
        est = mock(Estacionamiento.class);
        sEst = mock(ServicioEstacionamiento.class);
        cEst = new ControladorEstacionamiento(sEst);
    }

    @Test
    public void checkRegistroEstacionamiento() throws Exception{
        Usuario establecimiento = mock(Usuario.class);
        Usuario usuario = mock(Usuario.class);

        when(est.getEstablecimiento_id()).thenReturn(establecimiento);
        when(est.getUsuario_id()).thenReturn(usuario);

        ModelAndView modelAndView = cEst.registrarEstacionamiento(est);

        verify(sEst, times(1)).agregarEstacionamiento(est);
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("home"));
    }
}
