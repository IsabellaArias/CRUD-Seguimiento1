package Ejercicio6.Interfaces;

import Ejercicio6.Dto.citasDTO;

import java.io.IOException;
import java.util.List;

public interface ICitas {
    citasDTO findById(int id);
    List<citasDTO> findAll() throws IOException, ClassNotFoundException;
    void save(citasDTO cita) throws IOException;
    void update(citasDTO cita) throws IOException;
    void delete(citasDTO cita) throws IOException;
}