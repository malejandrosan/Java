package controller;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Cliente;
import model.Factura;

/**
 * Menu.java
 * @author Mario Sánchez Gamboa
 */
public class Menu {
    
    // Variables de instancia
    Scanner scanner;
    Factura factura;
    
    // Constantes
    public final int MAX_CARACTER = 15;
    public final int TARIFA_BASE = 3000;
    public final int MAX_DISTANCIA = 100000; 
    
    // Constructor
    public Menu(){
        scanner = new Scanner(System.in);
        factura = new Factura();
    }
    
    // Muestra el menú inicial al usuario
    public void mostrarMenu(){
        System.out.println("==========================");
        System.out.println("  Bienvenido a EcoCleta  ");
        System.out.println("========== Menú ==========");
        System.out.println("1. Rentar Bicicleta");
        System.out.println("2. Devolver bicicleta");
        System.out.println("3. Mostrar usuarios");
        System.out.println("4. Mostrar facturas");
        System.out.println("0. Salir");
        System.out.println("==========================");
        System.out.print("Elija una opción: ");
    }
    
    // Muestra información sobre la renta al usuario
    public void mostrarMenuDePrecio(){
        System.out.println("==========================");
        System.out.println("Información para rentas en EcoCleta");
        System.out.println("La tarifa base es de " + TARIFA_BASE + " colones.");
        System.out.println("La distancia máxima por recorrido es: "+ MAX_DISTANCIA + " metros");
        System.out.println("Contamos con 2 tipos de bicicletas:");
        System.out.println("La T300 para distancias cortas.");
        System.out.println("La T900 para distancias largas");
        System.out.println("==========================");
    }
    
    public void mostrarDespedida(){
        System.out.println("==========================");
        System.out.println("Gracias por su preferencia.");
    }

    public void mostrarMensajeRentaExitosa(){
        System.out.println("¡Ha rentado exitosamente!");
    }
    
    public void mostrarMensajeRentaConcluida(){
        System.out.println("¡Ha devuelto exitosamente!");
    }
    
    public void mostrarMensajeDeError(){
        System.out.println("Datos inválidos. Intente de nuevo.");
    }

    // Muestra el monto a pagar
    public void MostrarMontoAPagar(int distancia){
        double total = factura.calcularMontoPorPagar(distancia);
        System.out.println("El total a pagar es de: " + total);
    }
    
    // Muestra todas las facturas 
    public void muestraTodasLasFacturas(ArrayList <Factura> facturas){
        for (int i = 0; i < facturas.size(); i++){
            facturas.get(i).mostrarFactura();
        }
    }

    // Muestra todos los clientes
    public void muestraTodosLosClientes(ArrayList <Cliente> clientes){
        for (int i = 0; i < clientes.size(); i++){
            clientes.get(i).mostrarInformacion();
        }
    }
    
    // Verificar si id ya está registrado o no
    public boolean estaIdRegistrado(ArrayList <Cliente> clientes, String id){
        for(int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getIdentificacion().equals(id))
                return true;
        }
        return false;
    }
    
    // Itera sobre arraylist comparando los id para obtener el índice del objeto
    public int obtenerIdIndex(ArrayList <Cliente> clientes, String id){
        for(int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getIdentificacion().equals(id))
                return i;
        }
        return -1;
    }

    // Lectura de datos
    // Lee el id
    public String ingresarId(){
        scanner.nextLine(); // Consume nueva línea
        System.out.print("Escriba su identificación: ");
        return scanner.nextLine();
    }
    
    // Lee el nombre
    public String ingresarNombre(){
        System.out.print("Escriba su nombre: ");
        return scanner.nextLine();
    }

    // Lee la dirección
    public String ingresarDireccion(){
        System.out.print("Escriba su dirección: ");
        return scanner.nextLine();
    }
    
    // Lee la distancia
    public int ingresarDistancia()throws InputMismatchException{
        System.out.print("Escriba la distancia recorrida en metros: ");
        return scanner.nextInt();
    }
    
    // Lee la edad
    public int ingresarEdad() throws InputMismatchException{
        System.out.print("Escriba su edad: ");
        return scanner.nextInt();
    }
    
    // Lee el código (bicicleta) elegida por el usuario y lo retorna en mayúscula
    public String ingresarCodigo(){
        scanner.nextLine(); // Consume nueva línea
        System.out.println("Escriba el modelo de bicicleta:");
        System.out.print("T300 o T900: ");
        return (scanner.nextLine()).toUpperCase();
    }

    // Validaciones
    // Verifica que identidad tenga 9 dígitos
    public boolean esIdValido(String id){
        if (id.isEmpty())
            return false;
        
        // Regex verifica que id contenga exactamente 9 dígitos
        // Fuentes: https://stackoverflow.com/questions/19715303/regex-that-accepts-only-numbers-0-9-and-no-characters
        // https://docs.oracle.com/javase/tutorial/essential/regex/index.html
        return id.matches("^[0-9]{9}$");
    }
    
    // Verifica que nombre tenga solo letras y se establece límite de caracteres (15)
    public boolean esNombreValido(String nombre){
        if (nombre.isEmpty() || nombre.length() > MAX_CARACTER)
            return false;
        
        // El regex verifica que "nombre" solo contenga letras del alfabeto y que cada letra puede aparecer 1 o más veces. 
        // Regex lo aprendí de la siguiente fuente: https://stackoverflow.com/questions/5238491/check-if-string-contains-only-letters
        return nombre.matches("[a-zA-Z]+");
    }
    
    // Verifica que dirección tenga como máximo 15 caracteres
    public boolean esDireccionValida(String direccion){
        if(direccion.isEmpty() || direccion.length() > MAX_CARACTER)
            return false;
        return true;
    }
    
    // Verifica que edad sea positiva y se establece límite de edad (120)
    public boolean esEdadValida(int edad){
        return (edad > 0 && edad < 120);
    } 
    
    // Verifica que distancia sea positiva y se establece limite de distancia (100000)
    public boolean esDistanciaValida(int distancia){
        return (distancia >= 0 && distancia <= MAX_DISTANCIA);
    }
    
    // Valida que el código de bicicleta sea "T300" o "T900"
    public boolean esCodigoValido(String codigo){
        if (codigo.equals("T300") || codigo.equals("T900"))
            return true;
        else
            return false;
    }

} // Fin de la clase Menu
