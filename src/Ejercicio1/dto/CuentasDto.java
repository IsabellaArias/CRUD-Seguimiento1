package Ejercicio1.dto;

import java.io.Serializable;

public class CuentasDto implements Serializable {
    public int id;
    private String name;
    private int saldoCuenta;

    public CuentasDto(int id, String name, int saldoCuenta) {
        this.id = id;
        this.name = name;
        this.saldoCuenta = saldoCuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setPin(String name) {
        this.name= name;
    }

    public int getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta() {
        this.saldoCuenta = saldoCuenta;
    }

    @Override
    public String toString() {
        return "CuentasDto{" +
                "id=" + id +
                ", name=" + name +
                ", saldoCuenta=" + saldoCuenta +
                '}';
    }
}
