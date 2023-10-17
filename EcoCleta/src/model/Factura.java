package model;
/**
 * Factura.java
 * @author Mario Sánchez Gamboa
 */
public class Factura {
    
    // Variables de instancia
    private String facturaId;
    private String clienteId;
    private String clienteNombre;
    private String codigoBicicleta;
    private int distancia;
    private double monto;
    
    // Constante
    private final int TARIFA_BASE = 3000;
    
    // Constructor
    public Factura(){
        facturaId = "";
        clienteId = "";
        clienteNombre = "";
        codigoBicicleta = "";
        distancia = 0;
        monto = 0;
    }
    
    // Constructor
    public Factura(String facturaId, String id, String nombre, String codigo){
        this.facturaId = facturaId;
        this.clienteId = id;
        this.clienteNombre = nombre;
        this.codigoBicicleta = codigo;
    }
    
    // Constructor
    public Factura(String facturaId, String id, String nombre, String codigo, int distancia, double monto){
        this.facturaId = facturaId;
        this.clienteId = id;
        this.clienteNombre = nombre;
        this.codigoBicicleta = codigo;
        this.distancia = distancia;
        this.monto = monto;
    }
    
    public void mostrarFactura(){
            System.out.println("=========================");
            System.out.println("Factura #" + facturaId);
            System.out.println("ID cliente: "+ clienteId);
            System.out.println("Nombre cliente: "+ clienteNombre);
            System.out.println("Código de la Bicicleta: " + codigoBicicleta);
            System.out.println("Distancia recorrida: " + convertirAKilometros(distancia) + " km.");
            System.out.println("Monto a Pagar: "+ monto);
    }
    
    // Calcula el monto a pagar de acuerdo a la distancia recorrida
    public double calcularMontoPorPagar(int distancia){
        int porcentaje = 0;
        if (distancia >= 0 && distancia <= 1000)
            porcentaje = 50;
        else if (distancia > 1000 && distancia <= 2000)
            porcentaje = 30;
        else if (distancia > 2000 && distancia <= 3000)
            porcentaje = 20;
        else if (distancia > 3000)
           porcentaje = 10;
    
        monto = TARIFA_BASE + (TARIFA_BASE * porcentaje) / 100;

        return monto;
    }
    
    // Convierte los metros a kilometros.
    public double convertirAKilometros(int metros){
        return metros/1000.0;
    }
    
    // Getters y setters
    public String getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(String facturaId) {
        this.facturaId = facturaId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getCodigoBicicleta() {
        return codigoBicicleta;
    }

    public void setCodigoBicicleta(String codigoBicicleta) {
        this.codigoBicicleta = codigoBicicleta;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    // Fin de getters y setters
    
}// Fin de la clase Factura
