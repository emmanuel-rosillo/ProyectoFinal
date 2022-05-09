import java.util.Scanner;

public class main {
    public static void main(String[] args) {
//        Nodo root = new Nodo(7);
//        Nodo n1 = new Nodo(9);
//        Nodo n2 = new Nodo(8);
//        Nodo n3 = new Nodo(6);
//        Nodo n4 = new Nodo(10);
//        Nodo n5 = new Nodo(12);
//        Nodo n6 = new Nodo(5);
//
//        ArbolAVL a1 = new ArbolAVL(root);
//
//        a1.buildTree(n1);
//        a1.buildTree(n2);
//        a1.buildTree(n3);
//        a1.buildTree(n4);
//        a1.buildTree(n5);
//        a1.buildTree(n6);
//        a1.breadthFrist();

        while (true) {
            Scanner n1 = new Scanner(System.in);
            System.out.println("Seleccione una opción: \n");
            System.out.println("1.- plantar arbol\n");
            System.out.println("2.- inserta ABONO (nodo)\n");
            System.out.println("3.- Cortar parte del arbol (nodo)\n");
            Integer op = n1.nextInt();
            Boolean frue = false;
            ArbolAVL a1 = null;
            switch (op) {
                case 1:
                    if(frue == true){
                        System.err.println("no es posible insertar nuevamente una raiz");
                        break;
                    }
                    System.out.println("Ingresa la raiz: ");
                    Integer x = n1.nextInt();
                    Nodo root = new Nodo(x);
                    a1 = new ArbolAVL(root);
                    frue = true;
                    break;
                case 2:
                    if(frue = true){
                        System.out.println("Ingresa la raiz: ");
                        Integer y = n1.nextInt();
                        Nodo n = new Nodo(y);
                        a1.buildTree(n);
                    }else {
                        System.err.println("No has ingresado una raiz");
                    }
                case 3:

                case 4:
                case 5:
            }
        }
    }
}
