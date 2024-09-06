# Inventario de Tienda
**Enunciado:** El sistema que se está desarrollando tiene como propósito gestionar el
inventario de una tienda. El inventario se representa mediante una matriz de objetos en
Java, donde cada objeto almacena tanto el identificador único, el nombre del producto,
como la cantidad disponible del mismo.
El sistema debe permitir a los empleados realizar las siguientes operaciones a través de un
menú interactivo en la consola:
1. **Agregar Productos al Inventario:** Permite aumentar la cantidad de un producto
   específico en el inventario.
2. **Restar Productos del Inventario:** Permite disminuir la cantidad de un producto
   específico.
3. **Consultar Disponibilidad de un Producto:** Permite a los empleados verificar la
   cantidad disponible de un producto específico introduciendo su identificador.
4. **Listar Todos los Productos:** Muestra una lista con los identificadores, nombres y
   cantidades disponibles de todos los productos en el inventario.

***Requisitos:***

Matriz de Objetos:

   productos[][]: Almacena el identificador, el nombre y la cantidad disponible
   de cada producto.

   

   **Métodos a Implementar:**
1. **agregarProductos(int idProducto, int cantidad):** Aumenta la cantidad de un
   producto específico.
2. **restarProductos(int idProducto, int cantidad):** Disminuye la cantidad de un
   producto específico.
3. **consultarDisponibilidad(int idProducto):** Devuelve la cantidad disponible de un
   producto.
4. **listarProductos():** Lista todas las cantidades, nombres e identificadores de los
   productos.

Se pueden añadir nuevos métodos de ser pertinente
   Manejo de Errores con try-catch:
   Cada operación debe manejar los errores utilizando try-catch, y se debe capturar la
   excepción específica en cada caso.

**Menú por Consola:**
   El programa debe ofrecer un menú interactivo por consola donde los empleados puedan
   seleccionar las operaciones a realizar. Cada opción del menú debe ejecutar una de las
   funcionalidades descritas anteriormente. El programa debe manejar entradas incorrectas o
   no válidas en el menú.

   **Pruebas Unitarias:**

   ● Validar operaciones exitosas: agregar, restar, consultar, y listar.

   ● Validar que los errores (intentos inválidos de agregar/restar, identificadores
   incorrectos, etc.) sean manejados correctamente con las excepciones
   correspondientes.