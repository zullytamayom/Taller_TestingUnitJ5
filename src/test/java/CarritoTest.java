import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    @DisplayName("El total debe ser la suma de los precios de los productos")
    void testCalcularTotal() {
        Carrito carrito = new Carrito();
        carrito.agregar(new Producto("Producto 1", 100.0, 5));
        carrito.agregar(new Producto("Producto 2", 200.0, 5));

        assertEquals(300.0, carrito.calcularTotal());
    }

    @Test
    @DisplayName("Un carrito con productos no debe estar vacío")
    void testNoEstaVacio() {
        Carrito carrito = new Carrito();
        carrito.agregar(new Producto("Galletas", 1500.0, 20));

        assertFalse(carrito.estaVacio());
    }

    @Test
    @DisplayName("El total de un carrito vacío debe ser 0")
    void testTotalCarritoVacio() {
        Carrito carrito = new Carrito();
        assertEquals(0.0, carrito.calcularTotal());
    }
}
