package Ejercicio3.Servicios;

import Ejercicio3.Dto.EstadisticasDTO;
import Ejercicio3.Interfaces.IEstadisticas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EstadisticasServiceImplement implements IEstadisticas {
    private List<EstadisticasDTO> estadisticas;
    public EstadisticasServiceImplement() throws IOException,ClassNotFoundException{
        estadisticas = new ArrayList<>();
    }

    @Override
    //Consultar por id
    public EstadisticasDTO findById(int id) {
        return estadisticas.stream()
                .filter(estadistica -> estadistica.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    //lee y devolve una lista de objetos del tipo EstadisticasDTO
    public List<EstadisticasDTO> findAll() throws IOException, ClassNotFoundException {
        estadisticas = (List<EstadisticasDTO>) ObjectSerializer.readObjectFromFile("estadisticas.ax");
        return estadisticas;
    }

    @Override
    //Se agregan y se guardan los datos
    public void save(EstadisticasDTO estadistica) throws IOException {
        estadisticas.add(estadistica);
        ObjectSerializer.writeObjectToFile(estadisticas,"estadisticas.ax");
    }

    @Override
    //Se actualizan los datos
    public void update(EstadisticasDTO estadistica) throws IOException {
        EstadisticasDTO oldEstadistica = findById(estadistica.getId());
        if(oldEstadistica!=null){
            estadisticas.remove(oldEstadistica);
            estadisticas.add(estadistica);
            ObjectSerializer.writeObjectToFile(estadisticas,"estadisticas.ax");
        }
    }

    @Override
    //Se eliminan los datos
    public void delete(EstadisticasDTO estadistica) throws IOException {
        estadisticas.remove(estadistica);
        ObjectSerializer.writeObjectToFile(estadisticas,"estadisticas.ax");
    }
}