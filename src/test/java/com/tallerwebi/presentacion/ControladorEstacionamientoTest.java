package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Establecimiento;
import com.tallerwebi.dominio.Usuario;
import com.tallerwebi.dominio.Estacionamiento;
import com.tallerwebi.dominio.ServicioEstacionamiento;
import com.tallerwebi.integracion.config.HibernateTestConfig;
import com.tallerwebi.integracion.config.SpringWebTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebTestConfig.class, HibernateTestConfig.class})
public class ControladorEstacionamientoTest {

    private ControladorEstacionamiento cEst;
    private ServicioEstacionamiento sEst;
    private Estacionamiento est;
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;


    @BeforeEach
    public void setup() {
        est = mock(Estacionamiento.class);
        sEst = mock(ServicioEstacionamiento.class);
        cEst = new ControladorEstacionamiento(sEst);

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

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
        assertThat(modelAndView.getModel().get("error").toString(), equalToIgnoringCase("Por favor, elegir un establecimiento valido"));
    }

    @Test
    public void queCarguePaginaTestingEstacionamiento() throws Exception{
        ModelAndView modelAndView = cEst.listaEstacionamientos();
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("listaEstacionamientos"));
    }

    @Test
    public void queVayaALoginCuandoAprieteElBotonEnNav() throws Exception{

        MvcResult result = this.mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andReturn();

        ModelAndView modelAndView = result.getModelAndView();
        assert modelAndView != null;
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("login"));
        assertThat(modelAndView.getModel().get("datosLogin").toString(),  containsString("com.tallerwebi.presentacion.DatosLogin"));
    }
    @Test
    public void queVayaALoginCuandoVayaALaRaiz() throws Exception{

        MvcResult result = this.mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        ModelAndView modelAndView = result.getModelAndView();
        assert modelAndView != null;
        assertThat("redirect:/login", equalToIgnoringCase(Objects.requireNonNull(modelAndView.getViewName())));
        assertThat(true, is(modelAndView.getModel().isEmpty()));
    }

    @Test
    public void queVayaACreacionDeUsuarios() throws Exception{
        MvcResult result = this.mockMvc.perform(get("/nuevo-usuario.html"))
                .andExpect(status().isOk())
                .andReturn();

        ModelAndView modelAndView = result.getModelAndView();
        assert modelAndView != null;
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("nuevo-usuario"));
    }

    public void queVayaACreacionDeEstablecimientos() throws Exception{
        MvcResult result = this.mockMvc.perform(get("/nuevo-establecimiento.html"))
                .andExpect(status().isOk())
                .andReturn();

        ModelAndView modelAndView = result.getModelAndView();
        assert modelAndView != null;
        assertThat(modelAndView.getViewName(), equalToIgnoringCase("nuevo-establecimiento"));
    }
}
