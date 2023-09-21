package Ejercicio4.Interfaces;

import Ejercicio4.dto.TurnoDTO;

import java.io.IOException;
import java.util.List;

public interface ITurnoService {





        TurnoDTO findById(int id);
        List<TurnoDTO> findAll() throws IOException, ClassNotFoundException;
        void save(TurnoDTO turno) throws IOException;
        void update(TurnoDTO turno) throws IOException;
        void delete(TurnoDTO turno) throws IOException;
    }

