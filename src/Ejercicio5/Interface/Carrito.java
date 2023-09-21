package Ejercicio5.Interface;

import Ejercicio5.Dto.CarritoDto;

import java.io.IOException;
import java.util.List;

public interface Carrito {
    CarritoDto findById(int id);
    List<CarritoDto> findAll() throws IOException, ClassNotFoundException;
    void save(CarritoDto carrito) throws IOException;
    void update(CarritoDto carrito) throws IOException;
    void delete(CarritoDto carrito) throws IOException;
}





