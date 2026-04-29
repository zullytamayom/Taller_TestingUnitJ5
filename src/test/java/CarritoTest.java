import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarritoTest {
    @Test
    @DisplayName("Un carrito nuevo debe estar vacío")
    void testCarritoNuevoVacio() {
        Carrito carrito = new Carrito();
        assertTrue(carrito.estaVacio());
    }

    @Test
    @DisplayName("Agregar un producto incrementa la cantidad a 1")
    void testAgregarUnProducto() {
        Carrito carrito = new Carrito();
        Producto p = new Producto("Chocolate", 5000.0, 10);

        carrito.agregar(p);

        assertEquals(1, carrito.cantidadDeProductos());
    }
}
