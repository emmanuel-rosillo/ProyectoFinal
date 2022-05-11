import java.util.Scanner;

public class mainAVL {
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

        // se ejecuta el menu, hasta que se ingrese la opcion 5
        while (true) {
            //menu de las opciones para el usuario
            Scanner n1 = new Scanner(System.in); // objeto de lectura por teclado
            System.out.println("es necesario plantar un arbol primero\n");
            Integer root = n1.nextInt();
            Nodo rt = new Nodo(root);
            ArbolAVL a1 = new ArbolAVL(rt);
            Boolean frue = true;           // validar si la raiz fue insertada op "1"
            System.out.println("Seleccione una opción: \n");
            System.out.println("2.- inserta ABONO (añadir nodo)\n");
            System.out.println("3.- Cortar parte del arbol (borrar nodo)\n");
            System.out.println("4.- buscar valor en el arbol");
            Integer op = n1.nextInt(); // opcion elegida
            switch (op) {
                case 1:
                    //añadir nodos al arbol
                    System.out.println("Ingresa el nodo: ");
                    Integer y = n1.nextInt();
                    Nodo n = new Nodo(y);
                    a1.buildTree(n);
                    break;
                case 2:
                    // borrar nodo
                    System.out.println("ingresa a quien matamos:");
                    Integer z = n1.nextInt();
                    Nodo d = new Nodo(z);
                    a1.deleteKey(d);
                    break;
                case 3:
                    // buscar nodo
                    System.out.println("diganme ¿a quien localizamos?: ");
                    Integer h = n1.nextInt();
                    Nodo l = new Nodo(h);
                    Boolean tr = a1.inTree(l);
                    if (tr == true){
                        System.out.println("Ya lo encontramos vivo");
                    }
                    else {
                        System.err.println("No encontramos rastros de vida");
                    }
                    break;
            }
            // finalizar programa
            if (op == 4){
                System.out.println("Saliendo del programa...");
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    break;
                }
            }
        }
    }
}
