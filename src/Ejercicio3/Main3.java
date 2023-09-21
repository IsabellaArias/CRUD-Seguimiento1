package Ejercicio3;


import Ejercicio3.Dto.EstadisticasDTO;
import Ejercicio3.Interfaces.IEstadisticas;
import Ejercicio3.Servicios.EstadisticasServiceImplement;

import java.io.IOException;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        IEstadisticas repo = new EstadisticasServiceImplement();
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("~~~~~Atencion al cliente~~~~~");
            System.out.println("Ingrese su cedula:");
            // se utiliza para convertir un valor leído desde un objeto Scanner en un objeto de tipo Integer
            Integer id = Integer.valueOf(s.next());
            System.out.println("""
                    Selecciona el tipo de atencion :\s 1-Telefonica\s 2-Asesoria Estudiante\s 3-Asesoria Directivo\s 4-Consultar estadisticas\s 5-Salir""");
            String elect = s.next();
            switch (elect) {
                case "1" -> {
                    String tip = "telefonica";
                    System.out.println("~~~TELEFONICA~~~");
                    //Se crea un nuevo objeto
                    repo.save(new EstadisticasDTO(id,tip));
                    System.out.println("Gracias por su tiempo");
                }
                case "2" -> {
                    String tip = "estudiantes";
                    System.out.println("~~~Asesoria Estudiantes~~~");
                    repo.save(new EstadisticasDTO(id,tip));
                    System.out.println("Desea cambiarse a servicio telefonico?");
                    //Convierte todos los caracteres de la cadena en letras minúsculas
                    String descicion = s.next().toLowerCase();
                    //se usa para verificar si la entrada del usuario en la variable decision es diferente de "no".
                    if(!descicion.equals("no")){
                        String tipo = "Atencion diferente";
                        repo.update(new EstadisticasDTO(id,tipo));
                        System.out.println("Cambio satisfactorio!");
                    }else{
                        System.out.println("Muchas gracias por preferirnos");
                    }
                }
                case "3" ->{
                    String tip = "directivos";
                    System.out.println("~~~Asesoria Directivos~~~");
                    repo.save(new EstadisticasDTO(id,tip));
                    System.out.println("Desea cambiarse a servicio telefonico?");
                    String descicion = s.next().toLowerCase();

                    if(!descicion.equals("no")){
                        String tipo = "Atencion diferente";
                        repo.update(new EstadisticasDTO(id,tipo));
                        System.out.println("Cambio exitoso!");
                    }else{
                        System.out.println("Muchas gracias por preferirnos");
                    }
                }
                case "4"->{
                    List<EstadisticasDTO> a = repo.findAll();
                    List<EstadisticasDTO> e= new ArrayList<>();
                    List<EstadisticasDTO> d= new ArrayList<>();
                    List<EstadisticasDTO> c= new ArrayList<>();
                    List<EstadisticasDTO> f= new ArrayList<>();

                    
                    e = a.stream().filter(i -> i.getTipAtencion().equalsIgnoreCase("estudiantes")).toList();
                    d = a.stream().filter(i -> i.getTipAtencion().equalsIgnoreCase("directivos")).toList();
                    c = a.stream().filter(i -> i.getTipAtencion().equalsIgnoreCase("Atencion diferente")).toList();
                    f = a.stream().filter(i -> i.getTipAtencion().equalsIgnoreCase("telefonica")).toList();
                    int estudiante = e.size();
                    int directivo = d.size();
                    int atencionDiferente = c.size();
                    int telefono = f.size();
                    int total = estudiante+directivo+atencionDiferente+telefono;
                    System.out.println("~~~~~Estadisticas~~~~~" +
                            "\nAsesoria Telefonica:"+telefono+"\nAsesoria a Estudiantes:"+estudiante+"\nAsesoria a Directivos:"+directivo+"\nAtencion diferente:"+atencionDiferente+"\nTotal:"+
                            total);
                }
                case "5" -> {
                    opc = "5";
                }
            }
        }while (!opc.equals("5")) ;
    }
}