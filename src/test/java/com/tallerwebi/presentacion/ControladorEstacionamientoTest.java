package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Establecimiento;
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

        Establecimiento establecimiento = mock(Establecimiento.class);
        Usuario usuario = mock(Usuario.class);

        when(est.getEstablecimiento()).thenReturn(establecimiento);
        when(est.getUsuario()).thenReturn(usuario);
    }

    @Test
    public void queCreeRegistroEstacionamiento() throws Exception{
        ModelAndView modelAndView = cEst.registrarEstacionamiento(est);

        verify(sEst, times(1)).agregarEstacionamiento(est);
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("home"));
    }

    @Test
    public void queTireExceptionAlFallar() throws Exception{


        doThrow(Exception.class).when(sEst).agregarEstacionamiento(est);

        ModelAndView modelAndView = cEst.registrarEstacionamiento(est);

        assertThat(modelAndView.getViewName(), equalToIgnoringCase("nuevo-estacionamiento"));
        //assertThat(modelAndView.getModel().get("error").toString(), equalToIgnoringCase("Por favor, elegir un establecimiento valido"));
    }


}
