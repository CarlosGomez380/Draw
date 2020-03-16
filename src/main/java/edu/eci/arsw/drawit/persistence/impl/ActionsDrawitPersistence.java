package edu.eci.arsw.drawit.persistence.impl;


import edu.eci.arsw.drawit.model.Jugador;
import edu.eci.arsw.drawit.model.Sala;
import edu.eci.arsw.drawit.persistence.DrawItException;
import edu.eci.arsw.drawit.persistence.DrawitPersistence;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service("Action")
public class ActionsDrawitPersistence implements DrawitPersistence {

    private Map<Map<Tuple<Jugador, String>, ArrayList<Jugador>>, Sala> sala = new ConcurrentHashMap<>();
    private Map<Tuple<Jugador, String>, ArrayList<Jugador>> salaIni = new ConcurrentHashMap<>();

    public ActionsDrawitPersistence() {
        Jugador carlos = new Jugador("Carlos", 4);

    }

    @Override
    public void addSala(Sala sl) throws DrawItException {
        if (salaIni.containsKey(new Tuple<>(sl.getAutor(), sl.getCodigo()))) {
            throw new DrawItException("La sala " + sl + "ya existe");
        } else {
            salaIni.put(new Tuple<>(sl.getAutor(), sl.getCodigo()), sl.getJugadores());
            sala.put(salaIni, sl);
        }
    }

    @Override
    public void addJugadorToSala(Jugador jg, Sala sl) throws DrawItException {
        if (salaIni.containsKey(new Tuple<>(sl.getAutor(), sl.getCodigo()))) {
            ArrayList<Jugador> jugadoresAgregados = sl.getJugadores();
            jugadoresAgregados.add(jg);
            sl.setJugadores(jugadoresAgregados);
        } else {
            throw new DrawItException("La sala " + sl + " no existe");
        }
    }

    @Override
    public String getCodigoUnicoDeLaSala(Jugador jugador) throws DrawItException {
        Sala sala = new Sala(jugador);
        return sala.getCodigo();
    }

    @Override
    public String getCodigoUnicoDeLaSala() throws DrawItException {
        Sala sala = new Sala();
        return sala.getCodigo();
    }


}
