package Ejercicio5;
import Ejercicio5.Dto.CarritoDto;
import Ejercicio5.Interface.Carrito;
import Ejercicio5.Service.AgregarAlCarrito;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args)throws IOException, ClassNotFoundException{
        String opc = "1";
        Carrito car=new AgregarAlCarrito();

        do {
            Scanner s = new Scanner(System.in);
            System.out.print("""
                    ~~~~~ Menú ~~~~~\n
                     1.Agregar al Carrito\n
                     2.Ver el Carrito\n
                     3.Total\n
                     4.Eliminar\n
                     5.Salir\n""");
            opc = s.next();
            switch (opc) {
                case "1": {
                    System.out.println("~~~~~ Agregando al Carrito ~~~~~");
                    System.out.println("Id del producto: ");
                    Integer id = s.nextInt();
                    System.out.println("Nombre del producto: ");
                    String nombreP = s.next();
                    System.out.println("Precio: ");
                    Integer pre= s.nextInt();
                    System.out.println("Cantidad: ");
                    double can = s.nextDouble();
                    car.save(new CarritoDto(id,nombreP,pre,can));
                    break;
                }
                case "2": {
                    System.out.println("~~~~~ Carrito ~~~~~");
                    //Muestra los productos que estan en el carrito
                    List<CarritoDto> carrito = car.findAll();
                    if (!carrito.isEmpty()) {
                        carrito.forEach(System.out::println);
                    } else {
                        System.out.println("El carrito está vacío.");
                    }
                    break;
                }
                case "3": {
                    System.out.println("~~~~~ Total ~~~~~");
                    double Compratotal = car.findAll().stream().mapToDouble(CarritoDto::getPrecio).sum();
                    System.out.println("El total de la compra es:" + Compratotal);
                    break;
                }
                case "4": {
                    System.out.println("~~~~~ Eliminar del Carrito ~~~~~");
                    System.out.println("Ingrese el id del producto que desea eliminar:");
                    Integer id = s.nextInt();
                    car.delete(car.findById(id));
                    car.findAll().forEach(System.out::println);
                    break;
                }
                case "5": {
                    opc = "5";
                    break;
                }
            }
        } while (!opc.equals("5"));
    }
}

