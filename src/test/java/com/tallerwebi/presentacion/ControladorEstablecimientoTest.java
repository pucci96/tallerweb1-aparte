package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Establecimiento;
import com.tallerwebi.dominio.ServicioEstablecimiento;
import com.tallerwebi.dominio.excepcion.EstablecimientoExistenteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.mockito.Mockito.*;

public class ControladorEstablecimientoTest {
    
    private ControladorEstablecimiento controladorEstablecimiento;
    private ServicioEstablecimiento servicioEstablecimientoMock;
    private Establecimiento establecimientoMock;
    
    @BeforeEach
    public void setup() {
        establecimientoMock = mock(Establecimiento.class);
        when(establecimientoMock.getDireccion()).thenReturn("Calle Falsa 123");
        servicioEstablecimientoMock = mock(ServicioEstablecimiento.class);
        controladorEstablecimiento = new ControladorEstablecimiento(servicioEstablecimientoMock);
    }
    
    @Test
    public void queSeRegistreUnEstablecimiento() throws EstablecimientoExistenteException {
        ModelAndView modelAndView = controladorEstablecimiento.registrarEstablecimiento(establecimientoMock);
        
        verify(servicioEstablecimientoMock, times(1)).agregarEstablecimiento(establecimientoMock);
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("home"));
    }
    
    @Test
    public void queNoSeRegistreUnEstablecimientoSiYaExisteUnoEnEsaDireccion() throws EstablecimientoExistenteException {
        Establecimiento establecimientoRepetidoMock = mock(Establecimiento.class);
        when(establecimientoRepetidoMock.getDireccion()).thenReturn("Calle Falsa 123");
        
        when(servicioEstablecimientoMock.buscarEstablecimiento("Calle Falsa 123")).thenReturn(establecimientoMock);
        doThrow(EstablecimientoExistenteException.class).when(servicioEstablecimientoMock).agregarEstablecimiento(establecimientoRepetidoMock);
        
        ModelAndView modelAndView = controladorEstablecimiento.registrarEstablecimiento(establecimientoRepetidoMock);
        
        verify(servicioEstablecimientoMock, times(1)).agregarEstablecimiento(establecimientoRepetidoMock);
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("nuevo-establecimiento"));
        assertThat(modelAndView.getModelMap().get("error").toString(), equalToIgnoringCase("Error: Ya existe un establecimiento en Calle Falsa 123"));
    }
    
}
