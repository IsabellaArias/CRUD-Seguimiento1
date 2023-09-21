package Ejercicio1.service;


import Ejercicio1.Interfaces.ICuentaDTO;
import Ejercicio1.dto.CuentasDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CuentaServiceImpl implements ICuentaDTO {
    private List<CuentasDto> cuentas;

    public CuentaServiceImpl() throws IOException, ClassNotFoundException {
        cuentas = new ArrayList<>();
    }

    @Override
    public CuentasDto findById(int id) {
        return cuentas.stream()
                .filter(cuenta -> cuenta.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CuentasDto> findAll() throws IOException, ClassNotFoundException {
        cuentas = (List<CuentasDto>) ObjectSerializer.readObjectFromFile("cuentas.ax");
        return cuentas;
    }

    @Override
    public void save(CuentasDto cuenta) throws IOException {
        cuentas.add(cuenta);
        ObjectSerializer.writeObjectToFile(cuentas, "cuentas.ax");
    }

    @Override
    public void update(CuentasDto cuenta) throws IOException {
        CuentasDto oldProducto = findById(cuenta.getId());
        if (cuenta != null) {
            cuentas.remove(cuenta);
            cuentas.add(cuenta);
            ObjectSerializer.writeObjectToFile(cuentas, "productos.ax");
        }
    }

    @Override
    public void delete(CuentasDto cuenta) throws IOException {
        cuentas.remove(cuenta);
        ObjectSerializer.writeObjectToFile(cuentas, "productos.ax");
    }
}


