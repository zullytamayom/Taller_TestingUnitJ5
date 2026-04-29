import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {
    @Test
    @DisplayName("El precio debe coincidir con el valor del constructor")
    void testPrecioConstructor() {

        Producto producto = new Producto("Café", 15000.0, 5);

        double precioActual = producto.getPrecio();

        assertEquals(15000.0, precioActual, "El precio debería ser 15000.0");
    }

    @Test
    @DisplayName("Producto con stock > 0 debe estar disponible")
    void testEstaDisponibleTrue() {
        Producto producto = new Producto("Azúcar", 3000.0, 10);
        assertTrue(producto.estaDisponible(), "Debería devolver true cuando hay stock");
    }

    @Test
    @DisplayName("Producto con stock 0 no debe estar disponible")
    void testEstaDisponibleFalse() {
        Producto producto = new Producto("Leche", 4000.0, 0);
        assertFalse(producto.estaDisponible(), "Debería devolver false cuando el stock es 0");
    }

    @Test
    @DisplayName("Reducir stock disminuye la cantidad correctamente")
    void testReducirStockValido() {
        Producto producto = new Producto("Pan", 2000.0, 10);
        producto.reducirStock(7);
        assertEquals(3, producto.getStock(), "El stock debería haber disminuido a 7");
    }

    @Test
    @DisplayName("Reducir más stock del disponible lanza excepción")
    void testReducirStockInsuficiente() {
        Producto producto = new Producto("Miel", 12000.0, 5);
        assertThrows(IllegalArgumentException.class, () -> {
            producto.reducirStock(6);
        }, "Debería lanzar IllegalArgumentException por stock insuficiente");
    }

    @Test
    @DisplayName("Crear producto con precio negativo lanza excepción")
    void testPrecioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Producto("Error", -100.0, 10);
        }, "No se debería permitir crear productos con precios negativos");
    }
}
