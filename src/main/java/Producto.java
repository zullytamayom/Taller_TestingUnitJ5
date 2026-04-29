public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public boolean estaDisponible() {
        return stock > 0;
    }

    public void reducirStock(int cantidad) {
        if (cantidad > stock) {
            throw new IllegalArgumentException("Stock insuficiente");
        }
        stock -= cantidad;
    }
}
