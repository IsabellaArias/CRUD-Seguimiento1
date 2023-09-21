package Ejercicio4.Service;

import Ejercicio1.Interfaces.ICuentaDTO;
import Ejercicio4.Interfaces.ITurnoService;
import Ejercicio4.dto.TurnoDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TurnoServicelmpl implements ITurnoService {
    private List<TurnoDTO> turnos;

    public TurnoServicelmpl() throws IOException, ClassNotFoundException {
        turnos = new ArrayList<>();
    }

    @Override
    public TurnoDTO findById(int id) {
        return turnos.stream()
                .filter(turno -> turno.getTurno() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<TurnoDTO> findAll() throws IOException, ClassNotFoundException {
        turnos = (List<TurnoDTO>) ObjectSerializer.readObjectFromFile("productos.ax");
        return turnos;
    }

    @Override
    public void save(TurnoDTO producto) throws IOException {
        turnos.add(producto);
        ObjectSerializer.writeObjectToFile(turnos, "productos.ax");
    }

    @Override
    public void update(TurnoDTO turno) throws IOException {
        TurnoDTO oldTurno = findById(turno.getTurno());
        if (oldTurno != null) {
            turnos.remove(oldTurno);
            turnos.add(turno);
            ObjectSerializer.writeObjectToFile(turnos, "turnos.ax");
        }
    }

    @Override
    public void delete(TurnoDTO producto) throws IOException {
        turnos.remove(producto);
        ObjectSerializer.writeObjectToFile(turnos, "turnos.ax");
    }
}


