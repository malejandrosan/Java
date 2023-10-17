package view;
import controller.Menu;
import model.Cliente;
import model.Factura;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  UNED - Programación Intermedia
 *  Proyecto 1
 * 
 *  Programa que lleva el registro de la renta de bicicletas para la empresa Ecocleta.
 *  Permite agregar usuario, rentar bicicleta, devolver bicicleta, generar factura, y
 *  puede mostrar todos los registros de clientes y facturas.
 *
 *  Main.java
 *  @author Mario Sánchez Gamboa
 */
public class Main {
    
    public static void main(String[] args){
        
        // Variables
        String nombre = "";
        String id = "";
        String direccion = "";
        int edad = 0;
        int opcion = 0;
        int distancia = 0;
        int contador = 0;
        int index = 0;
        boolean continuarPrograma = true;
        String codigo = "";
        String codigoCorrecto = "";
        
        // Crea una instancia tipo Scanner
        Scanner scanner = new Scanner(System.in);
        
        // Crea una instancia de Menu
        Menu menu = new Menu();

        // Crea una instancia de Factura
        Factura factura = new Factura();
        
        // Crea un ArrayList de tipo Cliente
        ArrayList <Cliente> clientes = new ArrayList<Cliente>();
        
        // Crea un ArrayList de tipo Factura
        ArrayList <Factura> facturas = new ArrayList<Factura>();
      
        // Itera hasta que el usuario decida salir del programa
        do{
            
            try{
                menu.mostrarMenu();
                opcion = scanner.nextInt();
                
                // Dependiendo de la opción, ejecutará cierto código
                switch(opcion){
                    case 1:
                            // Case para rentar bicicleta
                            id = menu.ingresarId();
                            if (!menu.esIdValido(id) || menu.estaIdRegistrado(clientes, id)){
                                System.out.println("Id inválido o ya está rentando.");
                                break;
                            }
                            else if (!menu.estaIdRegistrado(clientes, id)){
                                nombre = menu.ingresarNombre();
                                if (!menu.esNombreValido(nombre)){
                                    System.out.println("Nombre inválido.");
                                    break;
                                }

                                direccion = menu.ingresarDireccion();
                                if (!menu.esDireccionValida(direccion)){
                                    System.out.println("Dirección inválida.");
                                    break;
                                }
                                
                                edad = menu.ingresarEdad();
                                if (!menu.esEdadValida(edad)){
                                    System.out.println("Edad inválida.");
                                    break;
                                }
                                
                                menu.mostrarMenuDePrecio();
                                
                                codigo = menu.ingresarCodigo();
                                if (!menu.esCodigoValido(codigo)){
                                    System.out.println("Código inválido.");
                                    break;
                                }
                                
                                // Cuenta el número de entradas exitosas
                                contador++;
                                
                                // Se crea un objeto Cliente y se agrega al ArrayList de tipo Cliente
                                clientes.add(new Cliente(id, nombre, direccion, edad));
                                
                                // Se crea un objeto Factura y se agrega al ArrayList de tipo Factura
                                facturas.add(new Factura(String.valueOf(contador), id, nombre, codigo));
                                
                                // Informa al usuario que se procesó la renta
                                menu.mostrarMensajeRentaExitosa();
                            }
                            break;
                    case 2:       
                            // Case para devolver bicicleta y que genera factura
                            id = menu.ingresarId();
                            if (!menu.esIdValido(id) || !menu.estaIdRegistrado(clientes, id)){
                                System.out.println("Id inválido o no está registrado.");
                                break;
                            }
                            
                            // Reseteo valores
                            codigoCorrecto = "";
                            
                            // Busco el indice del objeto usando el id para localizarlo
                            index = menu.obtenerIdIndex(clientes, id);
                            
                            // El codigo tengo que verificar que matchee
                            codigo = menu.ingresarCodigo();
                            
                            // Obtengo el código de la bicileta rentada al cliente
                            codigoCorrecto = facturas.get(index).getCodigoBicicleta();
                                
                            if (!menu.esCodigoValido(codigo) || !codigoCorrecto.equals(codigo)){
                                System.out.println("Código inválido.");
                                break;
                            }

                            distancia = menu.ingresarDistancia();
                            if (!menu.esDistanciaValida(distancia)){
                                System.out.println("Distancia inválida.");
                                break;
                            }

                            // Se asigna distancia al objeto correcto tras haber obtenido el index anteriormente.
                            facturas.get(index).setDistancia(distancia);
                            
                            // Se asigna el monto calculado al objeto correspondiente
                            facturas.get(index).setMonto(factura.calcularMontoPorPagar(distancia));
                            
                            // Mostrar monto a pagar
                            menu.MostrarMontoAPagar(distancia);
                            
                            // Generar factura
                            facturas.get(index).mostrarFactura();
                            break;    
                    case 3:
                            // Case que imprime todos los clientes en consola
                            menu.muestraTodosLosClientes(clientes);
                            break;
                    case 4:
                           // Case que imprime todas las facturas en consola
                           menu.muestraTodasLasFacturas(facturas);
                           break; 
                    case 0:
                            // Case para salir del programa e imprime todas las facturas
                            menu.mostrarDespedida();
                            menu.muestraTodasLasFacturas(facturas);
                            continuarPrograma = false;
                            break;
                   default: 
                           menu.mostrarMensajeDeError();
                }
            }
            catch(Exception exception){
                menu.mostrarMensajeDeError();
                scanner.nextLine(); // Consume excepcion
            }
        }
        while(continuarPrograma);

    }// Fin del método main

}// Fin de la clase Main
