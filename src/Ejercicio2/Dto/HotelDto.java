package Ejercicio2.Dto;
import java.io.Serializable;

public class HotelDto implements Serializable{
    private Integer id;
    private String tipoHabitacion;
    private String nombre;
    private String paisDeOrigen;
    private Integer numeroDePersonas;
    private Integer periodoDeEstadia;
    private String mascotas;
    private String fumador;

    public HotelDto(Integer id, String tipoHabitacion, String nombre, String paisDeOrigen, Integer numeroDePersonas, Integer periodoDeEstadia, String mascotas, String fumador) {
        this.id = id;
        this.tipoHabitacion = tipoHabitacion;
        this.nombre = nombre;
        this.paisDeOrigen = paisDeOrigen;
        this.numeroDePersonas = numeroDePersonas;
        this.periodoDeEstadia = periodoDeEstadia;
        this.mascotas = mascotas;
        this.fumador = fumador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisDeOrigen() {
        return paisDeOrigen;
    }

    public void setPaisDeOrigen(String paisDeOrigen) {
        this.paisDeOrigen = paisDeOrigen;
    }

    public Integer getNumeroDePersonas() {
        return numeroDePersonas;
    }

    public void setNumeroDePersonas(Integer numeroDePersonas) {
        this.numeroDePersonas = numeroDePersonas;
    }

    public Integer getPeriodoDeEstadia() {
        return periodoDeEstadia;
    }

    public void setPeriodoDeEstadia(Integer periodoDeEstadia) {
        this.periodoDeEstadia = periodoDeEstadia;
    }

    public String getMascotas() {
        return mascotas;
    }

    public void setMascotas(String mascotas) {
        this.mascotas = mascotas;
    }

    public String getFumador() {
        return fumador;
    }

    public void setFumador(String fumador) {
        this.fumador = fumador;
    }

    @Override
    public String toString() {
        return "Datos del nuevo Huesped:" +
                "id=" + id +
                "\n Tipo De Habitacion=" + tipoHabitacion +
                "\n Nombre=" + nombre +
                "\n Pais De Origen=" + paisDeOrigen +
                "\n Numero De Personas=" + numeroDePersonas +
                "\n Periodo De Estadia=" + periodoDeEstadia +
                "\n Mascotas=" + mascotas +
                "\n Fumador=" + fumador;
    }
}
