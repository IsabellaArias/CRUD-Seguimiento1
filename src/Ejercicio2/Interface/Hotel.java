package Ejercicio2.Interface;
import Ejercicio2.Dto.HotelDto;
import java.io.IOException;
import java.util.List;

public interface Hotel {
    HotelDto findById(int id);
    List<HotelDto> findAll() throws IOException, ClassNotFoundException;
    void save(HotelDto dato) throws IOException;
    void update(HotelDto dato) throws IOException;
    void delete(HotelDto dato) throws IOException;
}
