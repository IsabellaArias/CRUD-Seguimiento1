package Ejercicio5.Service;

import Ejercicio5.Dto.CarritoDto;
import Ejercicio5.Interface.Carrito;
import Ejercicio5.Service.ObjectSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AgregarAlCarrito implements Carrito {
    private List<CarritoDto> carritos;

    public AgregarAlCarrito() throws IOException, ClassNotFoundException {
        carritos = new ArrayList<>();
    }

    @Override
    public CarritoDto findById(int id) {
        return carritos.stream()
                .filter(carrito -> carrito.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CarritoDto> findAll() throws IOException, ClassNotFoundException {
        carritos = (List<CarritoDto>) Ejercicio2.Servicie.ObjectSerializer.readObjectFromFile("carritos.ax");
        return carritos;
    }

    @Override
    public void save(CarritoDto carrito) throws IOException {
        carritos.add(carrito);
        Ejercicio2.Servicie.ObjectSerializer.writeObjectToFile(carritos, "carritos.ax");
    }

    @Override
    public void update(CarritoDto carrito) throws IOException {
        CarritoDto oldcarrito = findById(carrito.getId());
        if (oldcarrito != null) {
            carritos.remove(oldcarrito);
            carritos.add(carrito);
            Ejercicio2.Servicie.ObjectSerializer.writeObjectToFile(carritos, "carritos.ax");
        }
    }

    @Override
    public void delete(CarritoDto carrito) throws IOException {
        carritos.remove(carrito);
        ObjectSerializer.writeObjectToFile(carritos, "carritos.ax");
    }
}
