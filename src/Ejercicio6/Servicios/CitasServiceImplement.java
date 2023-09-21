package Ejercicio6.Servicios;

import Ejercicio6.Dto.citasDTO;
import Ejercicio6.Interfaces.ICitas;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitasServiceImplement implements ICitas {
    private List<citasDTO> citas;
    public CitasServiceImplement() throws IOException,ClassNotFoundException{
        citas = new ArrayList<>();
    }

    @Override
    public citasDTO findById(int id) {
        return citas.stream()
                .filter(cita -> cita.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<citasDTO> findAll() throws IOException, ClassNotFoundException {
        citas = (List<citasDTO>) ObjectSerializer.readObjectFromFile("citas.ax");
        return citas;
    }

    @Override
    public void save(citasDTO cita) throws IOException {
        citas.add(cita);
        ObjectSerializer.writeObjectToFile(citas,"citas.ax");
    }

    @Override
    public void update(citasDTO cita) throws IOException {
        citasDTO oldcita = findById(cita.getId());
        if(oldcita!=null){
            citas.remove(oldcita);
            citas.add(cita);
            ObjectSerializer.writeObjectToFile(citas,"citas.ax");
        }
    }

    @Override
    public void delete(citasDTO cita) throws IOException {
        citas.remove(cita);
        ObjectSerializer.writeObjectToFile(citas,"citas.ax");
    }
}
