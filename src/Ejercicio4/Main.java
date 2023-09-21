package Ejercicio4;

import Ejercicio4.Interfaces.ITurnoService;
import Ejercicio4.Service.TurnoServicelmpl;
import Ejercicio4.dto.TurnoDTO;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        ITurnoService repo = new TurnoServicelmpl();
        int id = 1; // Variable para llevar el seguimiento del número único del turno

        do {
            Scanner s = new Scanner(System.in);
            System.out.print("Menu \n 1. Tomar turno  \n 2. Lista de turnos tomados" +
                    "\n 3. Atender  \n 4. Salir \n =>");
            opc = s.next();
            switch (opc) {
                case "1": {
                    // Crear un nuevo turno con el número único
                    TurnoDTO nuevoTurno = new TurnoDTO(id);
                    repo.save(nuevoTurno);
                    System.out.println("Se ha tomado el turno número: " + id);
                    id++; // Incrementar el número único del turno
                    break;
                }
                case "2": {
                    List<TurnoDTO> turnos = repo.findAll();
                    if (!turnos.isEmpty()) {
                        turnos.forEach(System.out::println);
                    } else {
                        System.out.println("No hay registros");
                    }
                    break;
                }

                case "3": {
                    System.out.println("===== Atender ======");
                    System.out.print("Ingrese el número de turno a atender: ");
                    int turnoAAtender = s.nextInt();
                    TurnoDTO turno = repo.findById(turnoAAtender);

                    if (turno != null) {
                        if (!turno.isAtendido()) {
                            System.out.println("Atendiendo al cliente con turno número: " + turno.getTurno());
                            turno.setAtendido(true); // Marcar el turno como atendido
                            repo.delete(turno); // Eliminar el turno de la lista de turnos tomados
                            repo.findAll().forEach(System.out::println);
                        } else {
                            System.out.println("El turno ya ha sido atendido anteriormente.");
                        }
                    } else {
                        System.out.println("No se encontró el turno especificado.");
                    }
                    break;
                }
                case "4": {
                    opc = "4";
                    break;
                }
            }
        } while (!opc.equals("4"));
    }
}
