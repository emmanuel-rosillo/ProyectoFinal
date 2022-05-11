
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MainAR {
    
    public void menu() throws IOException{
        InputStreamReader capturarTeclado = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(capturarTeclado);
        IngresarDatos ingreandoDatos = new IngresarDatos();
        
        int opcion = 0, verificador =0;
        while(opcion != 4){
            System.out.format("""
                              
                              \t\t***Menú para árboles aritméticos***
                              \tElige una de las siguientes opciones:
                              \t1) Ingresar expresión
                              \t2) Mostrar árbol
                              \t3) Resolver
                              \t4) Salir de la sección
                              """);
            String strOpcion = buffer.readLine();
            opcion = Integer.parseInt(strOpcion);
            switch (opcion){
            case 1 -> {
                System.out.println("\nIngrese su expresión aritmética");
                System.out.println("Ejemplo: 1+2-3*4/5");
                String strExpresion = buffer.readLine();
                ingreandoDatos.creandoArrays(strExpresion);
                System.out.println("\nSe ha guardado correctamente su expresión aritmética");
                verificador=1;
                }
            case 2 -> {
                if(verificador!=0){
                    ingreandoDatos.crearArbol();
                    
                }else
                    System.out.println("\nPrimero ingrese su expresión aritmética");
                }
            case 3 -> {
                System.out.println("\nOpción no disponible :C");
                }
            case 4 -> {
                System.out.println("¡Qué le vaya bien!");
                }
            default -> {
                System.out.println("Opción inválida");
                }
            }
        }
    }
}
