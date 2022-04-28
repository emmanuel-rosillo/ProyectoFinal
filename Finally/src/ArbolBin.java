import java.util.LinkedList;
import java.util.Queue;
public class ArbolBin {
    Nodo root;

    public ArbolBin() {
        root = null;
    }

    public ArbolBin(int val) {
        root = new Nodo(val);
    }

    public ArbolBin(Nodo root) {
        this.root = root;
    }

    public void add(Nodo padre, Nodo hijo, int lado) {
        if (lado == 0)
            padre.setIzq(hijo);
        else
            padre.setDer(hijo);
    }

    protected void visit(Nodo n) {
        System.out.println(n.valor + " ");
    }

    public void breadthFrist() {
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = queue.poll();
                visit(r);
                if (r.izq != null)
                    queue.add(r.izq);
                if (r.der != null)
                    queue.add(r.der);
            }
        }
    }

    public void printnudes(Nodo nodo) {
        System.out.println("Valor de nodo padre: " + nodo.valor);
        System.out.println("Valor de nodo hijo izq: " + nodo.izq.valor);
        System.out.println("Valor de nodo hijo der: " + nodo.der.valor);

    }

    public boolean inTree(Nodo search) {
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = queue.poll();
                visit(r);
                if (r == search) {
                    System.out.println("ya encontre tu nodo");
                    return true;
                }
                if (r.izq != null) {
                    queue.add(r.izq);
                }
                if (r.der != null) {
                    queue.add(r.der);
                }
            }
        }
        return false;
    }

    public void deleteKey(Nodo delete) {
        Nodo temp = delete;
        if (temp.izq != null) {
            temp = temp.izq;
            while (temp.der != null) {
                temp = temp.der;
            }
            delete.valor = temp.valor;
            if (temp.izq != null) {
                temp = temp.izq;
                temp.izq = null;
            }
            temp.valor = null;
        } else {
            delete.valor = null;
            temp.valor = null;

        }
    }
}

/*
        }
 */