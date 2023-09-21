package Ejercicio1;

import Ejercicio1.Interfaces.ICuentaDTO;
import Ejercicio1.dto.CuentasDto;
import Ejercicio1.service.CuentaServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opt = "1";
        ICuentaDTO inter = new CuentaServiceImpl();
        do{
            Scanner s = new Scanner(System.in);
            System.out.print("Menu \n 1. Registrarse  \n 2. Consultar cuentas \n 3. Consignar  \n  4. Transferencia " +
                    " \n 5. Salir ");
            opt = s.next();
            switch (opt){
                case "1" -> {
                    System.out.println("REGISTRARSE");
                    System.out.println("Ingrese su numero de cuenta");
                    Integer numCuenta = Integer.valueOf(s.next());
                    System.out.println("Ingrese su nombre");
                    String nam = s.next();
                    Integer id = Integer.valueOf(s.next());
                    inter.save(new CuentasDto(numCuenta,nam,0));
                    break;
                }
                case "2" -> {
                    System.out.println("CONSULTAR CUENTAS");
                    List<CuentasDto> cuenta = inter.findAll();
                    if (!cuenta.isEmpty()){
                        cuenta.forEach(System.out::println);
                    }else {
                        System.out.println("No hay registros");
                    }
                }
                case "3" -> {
                    System.out.println("CONSIGNAR");
                    System.out.println("Ingrese el numero de cuenta");
                    int id = parseInt(s.next());
                    boolean busqueda = inter.findById(id) == null;
                    if (!busqueda){
                        System.out.println("Ingrese la cantidad de dinero que desea  transferir");
                        int consignacion =  parseInt(s.next());
                        int saldoActual = inter.findById(id).getSaldoCuenta();
                        int nuevoSaldo = saldoActual + consignacion;
                        String name = inter.findById(id).getname();
                        inter.update(new CuentasDto(id,name,nuevoSaldo));
                        System.out.println("Ha transferido exitosamente:" + consignacion);
                    }
                    else {
                        System.out.println("No se ha encuentrado la cuenta");
                    }
                }
                case "4" -> {
                    System.out.println("TRANSFERENCIA A OTRA CUENTA");
                    System.out.println("Ingrese el id de la cuenta a transferir");
                    int id1 = parseInt(s.next());
                    String name1 = inter.findById(id1).getname();
                    System.out.println("Ingrese el numero de la segunda cuenta");
                    int id2 = parseInt(s.next());
                    String name2 = inter.findById(id2).getname();
                    if (inter.findById(id1).getSaldoCuenta() >= id1){
                        Integer resta = inter.findById(id1).getSaldoCuenta() - id1;
                        Integer suma = inter.findById(id2).getSaldoCuenta() + id1;
                        inter.update(new CuentasDto(id1,name1,resta));
                        inter.update(new CuentasDto(id2,name2,suma));
                        System.out.println("Se ha transferido exitosamente " + id1 + " pesos a la cuenta asiganada");
                    }
                    else {
                        System.out.println("Esta cantidad supera el monto actual");
                    }

                }

            }
        }while (!opt.equals("5"));
    }
}
