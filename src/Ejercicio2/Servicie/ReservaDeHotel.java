package Ejercicio2.Servicie;
import Ejercicio2.Dto.HotelDto;
import Ejercicio2.Interface.Hotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDeHotel implements Hotel {
    private List<HotelDto> datos;

    public ReservaDeHotel() throws IOException, ClassNotFoundException {
        datos = new ArrayList<>();
    }

    @Override
    public HotelDto findById(int id) {
        return datos.stream()
                .filter(dato -> dato.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<HotelDto> findAll() throws IOException, ClassNotFoundException {
        datos = (List<HotelDto>) ObjectSerializer.readObjectFromFile("datos.ax");
        return datos;
    }

    @Override
    public void save(HotelDto dato) throws IOException {
        datos.add(dato);
        ObjectSerializer.writeObjectToFile(datos, "datos.ax");
    }

    @Override
    public void update(HotelDto dato) throws IOException {
        HotelDto oldProducto = findById(dato.getId());
        if (oldProducto != null) {
            datos.remove(oldProducto);
            datos.add(dato);
            ObjectSerializer.writeObjectToFile(datos, "datos.ax");
        }
    }

    @Override
    public void delete(HotelDto dato) throws IOException {
        datos.remove(dato);
        ObjectSerializer.writeObjectToFile(datos, "datos.ax");
    }
}

