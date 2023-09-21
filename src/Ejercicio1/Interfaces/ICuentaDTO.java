package Ejercicio1.Interfaces;

import Ejercicio1.dto.CuentasDto;

import java.io.IOException;
import java.util.List;

public interface ICuentaDTO {
    CuentasDto findById(int id);

    List<CuentasDto> findAll() throws IOException, ClassNotFoundException;
    void save(CuentasDto cuenta) throws IOException;
    void update(CuentasDto cuenta) throws IOException;
    void delete(CuentasDto cuenta) throws IOException;
}
