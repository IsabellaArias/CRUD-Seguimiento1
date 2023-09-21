package Ejercicio6.Dto;

import java.io.Serializable;

public class citasDTO implements Serializable {
    public Integer id;
    public String paciente;
    public Integer doctor;

    public citasDTO(Integer id, String paciente, Integer doctor) {
        this.id = id;
        this.paciente = paciente;
        this.doctor = doctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Citas: " +
                "\n Id= " + id +
                "\n Paciente= " + paciente +
                "\n Doctor= " + doctor;
    }
}