package model;
/**
 * Cliente.java
 * @author Mario Sánchez Gamboa
 */
public class Cliente {
    
    // Variables de instancia o campos
    private String identificacion;
    private String nombre; 
    private String direccion; 
    private int edad; 
    private boolean esMayorDeEdad; 

    // Constructor
    public Cliente(){
        identificacion = "";
        nombre = "";
        direccion = "";
        edad = 0;
        esMayorDeEdad = false;
    }

    // Constructor
    public Cliente(String id, String nombre, String direccion, int edad){
        this.identificacion = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        if (this.edad >= 18)
            this.esMayorDeEdad = true;
        else
            this.esMayorDeEdad = false;
    }

    // Muestra la información del cliente
    public void mostrarInformacion(){
        System.out.println("==========================");
        System.out.println("Identificacion: " + identificacion);
        System.out.println("Nombre: " + nombre);
        System.out.println("Direccion: " + direccion);
        System.out.println("Edad: " + edad);
        System.out.println(interpretarEdad());
    }
    
    // Retorna String diciendo si usuario es mayor o menor de edad
    public String interpretarEdad(){
        return (esMayorDeEdad) ? "Mayor de edad" : "Menor de edad";   
    }

    // Getters y setters
    public String getIdentificacion(){
        return identificacion;
    }
    
    public void setIdentificacion(String id){
        this.identificacion = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public boolean getEsMayorDeEdad(){
        return esMayorDeEdad;
    }
    
    public void setEsMayorDeEdad(boolean valor){
        this.esMayorDeEdad = valor;
    }
    
} // Fin de la clase Cliente
