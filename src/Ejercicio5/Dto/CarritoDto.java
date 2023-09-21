package Ejercicio5.Dto;
import java.io.Serializable;

public class CarritoDto implements Serializable {
    private Integer id;
    private String producto;
    private Integer precio;
    private Double cantidadDisponible;

    public CarritoDto(Integer id,String producto, Integer precio, Double cantidadDisponible) {
        this.id= id;
        this.producto = producto;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override
    public String toString() {
        return "Descripcion del producto: " +
                "\n Producto= " + producto +
                "\n Precio= " + precio +
                "\n Cantidad Disponible= " + cantidadDisponible;
    }
}
