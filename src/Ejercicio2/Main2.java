package Ejercicio2;

import Ejercicio2.Dto.HotelDto;
import Ejercicio2.Interface.Hotel;
import Ejercicio2.Servicie.ReservaDeHotel;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        String opc = "1";
        Hotel hotel=new ReservaDeHotel();

        do {
            Scanner d=new Scanner(System.in);
            System.out.println("""
                    ~~~~~ Menú ~~~~~\n
                     1.Reservar\n
                     2.Consultar Reserva\n
                     3.Editar Reserva\n
                     4.Eliminar Reserva\n
                     5.Mirar la candidad de huespedes en el hotel\n
                     6.Salir\n""");
            opc= d.next();
            switch (opc){
                case "1":{
                    System.out.println("~~~~~ Haciendo Reservación ~~~~~");
                    System.out.println("Ingrese su identificación:");
                    int id= Integer.parseInt(d.next());
                    System.out.println("Ingrese su nombre:");
                    String nombre=d.next();
                    System.out.println("Ingrese su pais de origen:");
                    String pais=d.next();
                    System.out.println("Ingrese el número de personas:");
                    int numPersonas= Integer.parseInt(d.next());
                    System.out.println("Ingrese la cantidad de dias que se hospedaran:");
                    Integer estadia=Integer.valueOf(d.next());
                    System.out.println("Indique si trae mascotas(Si su respuesta es sí solo podra acceder a la habitaión familiar):");
                    String mascota=d.next();
                    System.out.println("Indique si fuma:");
                    String fuma=d.next();
                    System.out.println("Ingrese el Tipo de habitacion que desea:\n 1-Individual(máx 2 personas) \n 2-Doble(máx 4 personas) \n 3-Familiar(máx 6 personas)");
                    int habitacion= Integer.parseInt(d.next());

                    if (habitacion ==1 && numPersonas <=2 && Objects.equals(mascota,"no")){
                        String tipoHabitacion="Individual";
                        hotel.save(new HotelDto(id,tipoHabitacion,nombre,pais,numPersonas,estadia,mascota,fuma));
                        System.out.println(" La reservacion esta hecha: "+ hotel.findById(id));
                    } else if (habitacion ==2 && numPersonas <=4 && Objects.equals(mascota,"no")) {
                        String tipoHabitacion="Doble";
                        hotel.save(new HotelDto(id,tipoHabitacion,nombre,pais,numPersonas,estadia,mascota,fuma));
                        System.out.println(" La reservacion esta hecha: "+ hotel.findById(id));
                    }else if (habitacion ==3 && numPersonas <=6 ) {
                        String tipoHabitacion="Familiar";
                        hotel.save(new HotelDto(id,tipoHabitacion,nombre,pais,numPersonas,estadia,mascota,fuma));
                        System.out.println(" La reservacion esta hecha: "+ hotel.findById(id));
                    }else {
                        System.out.println("El dato que ingreso es invalidó");
                    }
                }break;
                case "2":{
                    System.out.println("~~~~~ Consultando Reservas ~~~~~");
                    List<HotelDto> datos = hotel.findAll();
                    if (!datos.isEmpty()){
                        datos.forEach(System.out::println);
                    }else{
                        System.out.println("No se encontraron reservaciones");
                    }
                }break;
                case "3":{
                    System.out.println("~~~~~ Editando Reserva ~~~~~");
                    System.out.println("Ingrese el número de Identificación de la reserva a editar:");
                    int idEditar = Integer.parseInt(d.next());

                    HotelDto reservaExistente = hotel.findById(idEditar);

                    if (reservaExistente != null) {
                        System.out.println("Ingrese su nombre:");
                        String nuevoNombre = d.next();
                        System.out.println("Ingrese su país de origen:");
                        String nuevoPais = d.next();
                        reservaExistente.setNombre(nuevoNombre);
                        reservaExistente.setPaisDeOrigen(nuevoPais);
                        hotel.update(reservaExistente);
                        System.out.println("La reserva ha sido actualizada.");
                    } else {
                        System.out.println("No se encontró ninguna reserva con el número de identificación proporcionado.");
                    }
                    }break;
                    case "4":{
                    System.out.println("~~~~~ Eliminando Reserva ~~~~~");
                    System.out.println("Ingrese el número de Identificación:");
                    int id= Integer.parseInt(d.next());
                    boolean buscar= hotel.findById(id)==null;
                    if (!buscar){
                        System.out.println("Se solicito la eliminacion de la reserva: "+hotel.findById(id));
                        hotel.delete(hotel.findById(id));
                        System.out.println("La reserva se elimino");
                    }else {
                        System.out.println("No se encontro ninguna reserva");
                    }
                }break;
                case "5":{
                    System.out.println("~~~~~ Cantidad de Huespedes ~~~~~");
                    int totalHuespedes= hotel.findAll().stream().mapToInt(HotelDto::getNumeroDePersonas).sum();
                    System.out.println("En el hotel hay "+totalHuespedes+ " Huespedes en total.");
                }break;
                case "6":{
                    opc="6";
                }break;
            }

        }while (!opc.equals("6"));
    }
}