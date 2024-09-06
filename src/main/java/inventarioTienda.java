import java.util.InputMismatchException;
import java.util.Scanner;


public class inventarioTienda {
    public static void main(String[] args) {
        Object[][] productos = new Object[10][3];
        ejecutarMenu(productos);
    }




    public static void ejecutarMenu(Object[][] productos) {
        boolean condicion = true;
        while (condicion) {
            int opcion = 0;
            mostrarMenu();
            opcion = leerOpcionMenu();
            if (opcion == 5) {
                condicion = false;
            }
            ejecutarOpcion(opcion, productos);


        }
    }


    public static void ejecutarOpcion(int opcion, Object[][] productos) {
        switch (opcion) {
            case 1:
                ejecutarAgregarProductos(productos);
                break;
            case 2:
                ejecutarEliminarProducto(productos);
                break;
            case 3:
                ejecutarConsultarDisponibilidad(productos);
                break;
            case 4:
                listarProductos(productos);
                break;
            case 5:
                System.out.println("Cerrando programa...");
                break;
        }
    }


    public static void mostrarMenu() {
        System.out.println("Inventario de tienda: ");
        System.out.println("1. Agregar producto.");
        System.out.println("2. Eliminar producto.");
        System.out.println("3. Disponibilidad de producto.");
        System.out.println("4. Listar productos.");
        System.out.println("5. Salir.");
        System.out.print("Seleccione una opción: ");
    }


    public static Scanner crearScanner() {
        return new Scanner(System.in);
    }


    public static int leerOpcionMenu() {
        int opcion = 0;
        while (true) {
            Scanner scanner = crearScanner();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    break;
                } else {
                    System.out.print("Opcion invalida. Seleccione una opcion: ");
                    scanner.nextLine();
                }
            } else {
                System.out.print("Entrada invalida. Seleccione una opcion: ");
                scanner.nextLine();
            }
        }
        return opcion;


    }


    public static boolean agregarProductos(Object[][] productos, int idProducto, int cantidadAgregar) {
        for (int i = 0; i < productos.length; i++)
            if ( productos[i][0] != null && productos[i][0].equals(idProducto)) {
                productos[i][2] = (int) productos[i][2] + cantidadAgregar;
                return true;
            }


        return false;
    }


    public static void ejecutarAgregarProductos(Object[][] productos) {
        int idProducto = ingresarIdProducto();
        boolean existenciaId = verificarExistenciaId(productos,idProducto);
        if(existenciaId) {
            int cantidadAgregar = ingresarCantidad();
            boolean productoAgregado = agregarProductos(productos, idProducto, cantidadAgregar);
            if (productoAgregado) {
                System.out.println("Producto agregado correctamente.");
            }


        }else {
            System.out.println("El producto no se encuentra guardado");
            System.out.print("¿Deseas agregarlo? (1.Si/2.No): ");
            productoNoGuardado(productos,idProducto);

        }
    }

    public static void productoNoGuardado(Object[][] productos,int idProducto) {
        int opcion = leerOpcionAgregar();
        boolean espacioDisponible = espacioDisponible(productos);

        if (opcion == 1) {
            if (espacioDisponible){
                String nombre = ingresarNombreProducto();
                int cantidad = ingresarCantidad();
                annadirProducto(productos, idProducto,nombre,cantidad);
                System.out.println("Producto agregado correctamente.");
            }else{
                System.out.println("No se puede guardar el producto ya que el inventario se encuentra lleno");
            }
        }else{
            System.out.println("El producto no se guardará.");
        }

    }


    public static int leerOpcionAgregar(){
        int opcion = 0;
        while (true) {
            Scanner scanner = crearScanner();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 2) {
                    break;
                } else {
                    System.out.print("Opcion invalida. Seleccione una opcion: ");
                    scanner.nextLine();
                }
            } else {
                System.out.print("Entrada invalida. Seleccione una opcion: ");
                scanner.nextLine();
            }
        }
        return opcion;
    }


    public static boolean eliminarProducto(Object[][] productos, int idProducto, int cantidadEliminar) {
        for (int i = 0; i < productos.length; i++){
            if (productos[i][0] != null && productos[i][0].equals(idProducto)) {
                int cantidadInicial = (int) productos[i][2];
                int resta = cantidadInicial - cantidadEliminar;
                if (resta > 0){
                    productos[i][2] = resta;
                    return true;
                }else if (resta == 0){
                    productos [i][0] = null;
                    productos [i][1] = null;
                    productos [i][2] = null;
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }


    public static void ejecutarEliminarProducto(Object[][] productos) {
        int idProducto = ingresarIdProducto();
        boolean existenciaId = verificarExistenciaId(productos, idProducto);
        if (existenciaId){
            int cantidadEliminar = ingresarCantidad();
            boolean productoEliminar = eliminarProducto(productos, idProducto, cantidadEliminar);
            if (productoEliminar){
                System.out.println("Producto eliminado correctamente.");
            }else{
                System.out.println("Se esta excediendo de la cantidad que puede eliminar");
            }
        }else{
            System.out.println("El producto no se encuentra guardado");
        }




    }


    public static String ingresarNombreProducto(){
        Scanner scanner = crearScanner();
        String nombre = "";
        while (true){
            System.out.print("Ingrese el nombre del producto: ");
            nombre = scanner.nextLine();
            if (nombre.isEmpty()){
                System.out.print("Por favor ingrese el nombre del producto. ");
            }else{
                break;
            }
        }
        return nombre;
    }



    public static int ingresarIdProducto() {
        Scanner scanner = crearScanner();
        int idProducto = 0;
        while (true) {
            try {
                System.out.print("Ingrese el id del producto: ");
                idProducto = scanner.nextInt();
                if (idProducto > 0) {
                    break;
                } else {
                    System.out.print("El numero ingresado no es valido. Intente de nuevo.");
                }


            } catch (InputMismatchException e) {
                System.out.print("Ingrese una entrada valida. ");
                scanner.nextLine();
            }


        }
        return idProducto;
    }




    public static int ingresarCantidad() {
        Scanner scanner = crearScanner();
        int cantidad = 0;
        while (true) {
            try {
                System.out.print("Ingresa la cantidad: ");
                cantidad = scanner.nextInt();


                if (cantidad > 0) {
                    break;
                } else {
                    System.out.print("La cantidad debe ser mayor que cero. Intenta de nuevo. ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Ingresa una entrada valida. ");
                scanner.nextLine();
            }
        }
        return cantidad;
    }


    public static int consultarDisponibilidad(Object[][] productos, int idProducto){
        int cantidadProducto = 0;
        for (int i = 0; i < productos.length ; i++){
            if (productos[i][0].equals(idProducto)){
                cantidadProducto = (int)productos[i][2];
                return cantidadProducto;
            }
        }return cantidadProducto;
    }


    public static void ejecutarConsultarDisponibilidad(Object[][] productos){
        int idProducto = ingresarIdProducto();
        boolean existenciaId = verificarExistenciaId(productos, idProducto);
        if (existenciaId){
            int cantidadProducto = consultarDisponibilidad(productos, idProducto);
            System.out.println("El producto con la id: "+ idProducto + " , su cantidad disponible es: " + cantidadProducto);
        }else{
            System.out.println("El producto no se encuentra guardado");
        }
    }


    public static void listarProductos(Object[][] productos) {
        for (int i = 0; i < productos.length; i++){
            if (productos[i][0] != null) {
                System.out.println(productos[i][0] + "| Nombre: " +  productos[i][1] + " | Cantidad: " + productos[i][2] );
            }else{
                continue;
            }
        }
    }




    public static boolean verificarExistenciaId(Object[][] productos, int idProducto){
        try {
            for(int i = 0; i < productos.length; i++){
                if (productos[i][0].equals(idProducto)) {
                    return true;
                }
            }
        }
        catch (NullPointerException e){
            return false;


        }
        return false;

    }

    public static boolean espacioDisponible(Object [][] productos){
        for (int i = 0; i < productos.length; i++){
            if (productos[i][0] == null){
                return true;
            }
        }
        return false;

    }

    public static void annadirProducto(Object[][] productos, int idProducto, String nombreProducto, int cantidad) {
            for (int i = 0; i < productos.length;i++){

                if (productos[i][0] == null){
                    productos[i][0] = idProducto;
                    productos[i][1] = nombreProducto;
                    productos[i][2] = cantidad;
                    break;
                }
            }
    }


}











