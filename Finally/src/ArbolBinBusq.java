import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinBusq extends ArbolBin {
    Nodo root;
    Nodo temp;

    Integer h = 0;

    Integer hR = 0;

    Integer hL = 0;



    public ArbolBinBusq() {
    }

    public ArbolBinBusq(Nodo root, Nodo temp) {
        this.root = root;
        this.temp = temp;
    }


    public ArbolBinBusq(Nodo root) {
        super(root);
        this.root = root;
    }
    public void addIn(Nodo padre, Nodo hijo, int lado) {
        Nodo temp = null;
        if (root.izq != null) {
            root.setIzq(root.izq);
        }
        if (temp != null) {
            root.setDer(temp);
        }
        if (root.der != null) {
            this.temp = root.der;
        }
    }

    //construye el arbol
    public synchronized void buildTree(Nodo hijo) {
        Integer i = 1;
        Nodo temp = root;
        Boolean vIzq = false;
        Boolean vDer = false;
        if(hijo.valor < root.valor)
            vIzq = true;
        else
            vDer = true;
        while (true) {
            if (temp.valor >= hijo.valor) {
                if (temp.izq == null) {
                    if(i > h){
                       h = i;
                    }
                    temp.setIzq(hijo);
                    break;
                } else {
                    temp = temp.izq;
                    i++;
                }
            } else {
                if (temp.der == null) {
                    if(i > h){
                        h = i;
                    }
                    temp.setDer(hijo);
                    break;
                } else {
                    temp = temp.der;
                    i++;
                }
            }
        }
        if(vIzq == true){
            this.hL = -i;
        }else {
            this.hR = i;

        }
        System.out.println("altura izquierda: " + hL + ", altura derecha: " + hR + " y la altura general: " + h);
    }
    @Override
    public synchronized void deleteKey(Nodo delete) {
        System.out.println("Se borro Nodo: " + delete.valor + "\n");
        super.deleteKey(delete);
        System.out.println("El arbol ahora tendrá que vivir así:");
        breadthFrist();
    }
    @Override
    public void breadthFrist() {
        super.breadthFrist();
    }
    @Override
    public synchronized boolean inTree(Nodo search) {
        return super.inTree(search);
    }
    public Nodo searchNode(int b){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = queue.poll();
                visit(r);
                if (r.valor == b) {
                    return r;
                }
                if (r.izq != null) {
                    queue.add(r.izq);
                }
                if (r.der != null) {
                    queue.add(r.der);
                }
            }
        }
        return null;
    }
}
