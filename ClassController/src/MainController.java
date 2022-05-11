import java.io.IOException;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona tu tipo de arbol: \n");
        System.out.println("1.- Heap\n");
        System.out.println("2.- ArbolAVL\n");
        System.out.println("3.- ArbolAritmetico");
        System.out.println("4.- salir");
        Integer op = sc.nextInt();
        while (true){
            switch (op){
                case 1:
                    MainH h = new MainH();
                    MainH.init();
                    break;
                case 2:
                    MainAVL avl = new MainAVL();
                    avl.init();
                    break;
                case 3:
                    MainAR invocarArbolAritmetico = new MainAR();
                    invocarArbolAritmetico.menu();
                    break;
                case 4:
                    try{
                        System.out.println("Saliendo...");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
            if (op == 4){
                break;
            }
        }
    }
}
