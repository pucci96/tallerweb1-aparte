package com.tallerwebi.dominio;
import com.tallerwebi.dominio.reserva.Reserva;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.mockito.Mockito.*;
public class ReservaTest {

    @Test
    public void queSePuedaRegistrarUnaReserva(){
        //<>
        List<Reserva> reservas = new ArrayList<>();
        Long id = 1l;
        List<Establecimiento> establecimientos = new ArrayList<>();
        LocalDateTime ahora = LocalDateTime.now();
        String cliente = "Pablo Perez";
        String vehiculo = "Fiat uno";

        Reserva nuevaReserva = new Reserva(id, ahora, cliente, vehiculo, establecimientos);
        reservas.add(nuevaReserva);
        int cantidadEsperada = 1;
        assertThat(reservas.size(), is(equalTo(cantidadEsperada)));
    }
}
