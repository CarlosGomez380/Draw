package edu.eci.arsw.drawit.persistence;

import edu.eci.arsw.drawit.model.Jugador;
import edu.eci.arsw.drawit.model.Sala;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface DrawitPersistence {

    public void addSala(Sala sl) throws DrawItException;

    public ArrayList<Sala> getSalas() throws DrawItException;

    public void addJugadorToSala(Jugador jg, String codigo) throws DrawItException;

    public ArrayList<String> getJugadoresBySala(String codigo) throws DrawItException;






}
