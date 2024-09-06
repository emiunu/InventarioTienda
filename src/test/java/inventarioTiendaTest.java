import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class inventarioTiendaTest {

    Object [][] productos = new Object[5][3];
    @BeforeEach
    void setUp() {
        inventarioTienda.annadirProducto(productos,1,"1+1",3);
        inventarioTienda.annadirProducto(productos,2,"triton",12);
        inventarioTienda.annadirProducto(productos,3,"pepsi",12);
        inventarioTienda.annadirProducto(productos,4,"coca-cola",5);
        inventarioTienda.annadirProducto(productos,6,"sprite",7);

    }

    @Test
    void agregarProductos() {
        assertTrue(inventarioTienda.agregarProductos(productos,4,6));
        assertFalse(inventarioTienda.agregarProductos(productos,5,6));
        assertTrue(inventarioTienda.agregarProductos(productos,6,7));

    }

    @Test
    void eliminarProducto() {
        assertTrue(inventarioTienda.eliminarProducto(productos,4,3));
        assertFalse(inventarioTienda.eliminarProducto(productos,5,6));
        assertFalse(inventarioTienda.eliminarProducto(productos,6,8));
        assertTrue(inventarioTienda.eliminarProducto(productos,1,3));
    }

    @Test
    void consultarDisponibilidad() {
        assertEquals(3,inventarioTienda.consultarDisponibilidad(productos,1));
        assertNotEquals(3,inventarioTienda.consultarDisponibilidad(productos,2));
    }
}

