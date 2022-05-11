import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Main{
    public static void main(String[] args) {
//        Heap maxHeap = new Heap(10);
//        maxHeap.insert(1);
//        maxHeap.insert(2);
//        maxHeap.insert(3);
//        maxHeap.insert(4);
//        maxHeap.insert(5);
//        maxHeap.insert(6);
//        maxHeap.insert(7);
//        maxHeap.printHeap();
//        // borra nodo
//        maxHeap.delete(7);
//        maxHeap.printHeap();
        Scanner n1 = new Scanner(System.in);
        System.out.println("----- Es necesario elegir la capacidad  -----");
        Integer cap = n1.nextInt();
        Heap h = new Heap(cap);
        while (true) {
            System.out.println("Eliga una opcion: ");
            System.out.println("1.- insertar nodo: ");
            System.out.println("2.- eliminar nodo:");
            System.out.println("3.- imprimir heap:");
            System.out.println("4.- Salir:");
            Integer op = n1.nextInt();
            switch (op) {
                case 1:
                    System.out.println("inserta el heap, papá: ");
                    Integer n = n1.nextInt();
                    h.insert(n);
                    System.out.println("se inserto un nodo\n");
                    System.out.println("¿Desea insertar otro? x-exit");
                    Key codes = null;
                    addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            int code = e.getKeyCode();
                            codes.setCode(code);
                        }

                        @Override
                        public void keyPressed(KeyEvent e) {
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                        }
                    });
                    if (codes.code == 88){
                        break;
                    }
                case 2:
                    System.out.println("¿que nodo desea eliminar: ");
                    Integer e = n1.nextInt();
                    try {
                        System.out.println("Eliminando...");
                        h.delete(e);
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    finally {
                        System.out.println("Eliminado");
                    }
                    break;
                case 3:
                    System.out.println("Imprimiendo...");
                    try{
                        h.printHeap();
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    finally {
                        System.out.println("¡listo!");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    try{
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    finally {
                        System.out.println("¡adios!");
                    }
                    break;
            }
            if (op == 4){
                break;
            }
        }
    }
}
