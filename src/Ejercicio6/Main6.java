package Ejercicio6;

import Ejercicio6.Dto.citasDTO;
import Ejercicio6.Interfaces.ICitas;
import Ejercicio6.Servicios.CitasServiceImplement;

import java.io.IOException;
import java.util.*;

public class Main6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        ICitas repo = new CitasServiceImplement();
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("~~~~~ Atencion al cliente ~~~~~");
            System.out.println("Ingrese su cedula:");
            Integer id = Integer.valueOf(s.next());
            System.out.println("""
                    Que accion deseas realizar :\s 1.Programar cita \s 2. Citas Programadas \s 3.Cancelar cita \s 4.Salir""");
            String elect = s.next();
            switch (elect) {

                    case "1" -> {
                        System.out.println("~~~~~ Programando Cita ~~~~~");
                        System.out.println("Ingrese el nombre del paciente: ");
                        String paciente = s.next();
                        System.out.println("Ingrese el doctor que desea:\s 1-Trujillo \s 2-Arle \s 3-Cristian");
                        int doctor = Integer.parseInt(s.next());
                        repo.save(new citasDTO(id, paciente, doctor));
                        System.out.println("Gracias por su tiempo");
                        break;
                    }

                    case "2" -> {
                        System.out.println("~~~~~ Citas Programadas ~~~~~");
                        List<citasDTO> cita = repo.findAll();
                        if (!cita.isEmpty()) {
                            cita.forEach(System.out::println);
                        } else {
                            System.out.println("No hay registros");
                            break;
                        }
                    }

                    case "3" -> {
                        System.out.println("~~~~~ Cancelacion de Citas ~~~~~");
                        System.out.println("Ingresar la cedula para cancelar la cita:");
                        int ced = s.nextInt();
                        repo.delete(repo.findById(ced));
                        repo.findAll().forEach(System.out::println);
                        break;
                    }
                    case "4" -> {
                        opc = "4";
                        break;
                    }
                }
            }
            while (!opc.equals("4")) ;
        }
    }
