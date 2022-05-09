import java.util.Deque;
import java.util.LinkedList;

public class ArbolAVL extends ArbolBin {
    Nodo root;
    Nodo temp;

    Integer h = 0;

    Integer hR = 0;

    Integer hL = 0;
    Integer izq = 0;
    Integer der = 0;
    LinkedList<Integer> rec = new LinkedList();
    LinkedList<Nodo> rec2 = new LinkedList();

    public ArbolAVL() {
    }

    public ArbolAVL(Nodo root, Nodo temp) {
        this.root = root;
        this.temp = temp;
    }


    public ArbolAVL(Nodo root) {
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
        Deque<Nodo> deque = new LinkedList<>();
        deque.add(root);
        Integer i = 1;
        Nodo temp = root;
        Nodo x;
        Nodo y;
        Nodo z;
        //enter to assignment for the node
        while (true) {
            Integer recorridos = 0;
            //check value node
            if (temp.valor >= hijo.valor) {
                //add node left
                if (temp.izq == null) {
                    temp.setIzq(hijo);
                    hijo.setPadre(temp);
                    checkBalance(hijo);
                    rec.add(0);
                    break;
                    //scroll left
                } else {
                    temp = temp.izq;
                    deque.add(temp);
                    rec.add(0);
                }
                //add node Right
            } else {
                if (temp.der == null) {
                    temp.setDer(hijo);
                    hijo.setPadre(temp);
                    checkBalance(hijo);
                    rec.add(1);
                    break;
                    //scroll right
                } else {
                    temp = temp.der;
                    deque.add(temp);
                    rec.add(1);
                }
            }
        }
    }
    public void checkBalance(Nodo hijo) {
        Deque <Nodo> unbalance = new LinkedList<>();
        while (true) {
            unbalance.add(hijo);
            LinkedList<Integer> ch;
            if (hijo == null)
                break;
            if (hijo.izq == null)
                ch = chekRight(hijo);
            else
                ch = checkHeight(hijo);
            Integer izq = ch.get(0);
            Integer der = ch.get(1);
            Integer total = izq - der;
            if ((total < -1)||(total > 1)){
                Nodo z = unbalance.pollLast();
                Nodo y = unbalance.pollLast();
                Nodo x = unbalance.pollLast();
                System.out.println("\n");
                System.out.println("Raiz: " + z.valor + " hijo: " + y.valor + " daño: " + x.valor);
                System.out.println("\n");
                balance(x, y, z);
            }
            System.out.println("valor nodo: " + hijo.valor + " Izq: " + izq + " der: " + der);
            hijo = hijo.padre;

        }
    }

    public void balance(Nodo x, Nodo y, Nodo z) {
        int rec1 = rec.pollLast();
        int rec2 = rec.pollLast();
        Nodo temp = null;
        Integer temp2;
        switch (rec2) {
            case 0: {
                if (rec1 == 1) {
                    if (x.izq != null)
                        temp = x.izq;
                    z.setIzq(x);
                    x.setIzq(y);
                    if (x == x.izq)
                        x.setNullIzq();
                    if (x == x.der)
                        x.setNullDer();
                    if (temp != null)
                        y.setDer(temp);
                }
                if (y.der != null)
                    temp = x.der;
                temp2 = x.valor;
                x.valor = z.valor;
                z.valor = temp2;
                x.setIzq(z);
                x.setDer(y);
                if (temp != null)
                    z.setIzq(temp);
                checkNode(x, y, z);
            }
            case 1: {
                if (rec1 == 0) {
                    if (x.der != null)
                        temp = x.der;
                    z.setDer(x);
                    x.setDer(y);
                    if (x == x.izq)
                        x.setNullIzq();
                    if (x == x.der)
                        x.setNullDer();
                    if (temp != null)
                        y.setIzq(temp);
                }
                if (y.der != null)
                    temp = x.der;
                temp2 = x.valor;
                x.valor = z.valor;
                z.valor = temp2;
                z.setIzq(x);
                z.setDer(y);
                if (temp != null)
                    z.setIzq(temp);
                checkNode(x, y, z);
            }
        }
    }

    public void checkNode(Nodo x, Nodo y, Nodo z) {
        LinkedList<Nodo> deque = new LinkedList<>();
        deque.add(y);
        deque.add(x);
        Nodo n = null;
        Nodo m = null;
        for (int i = 0; i < deque.size(); i++) {
            n = deque.get(i);
            for (int j = 0; j < deque.size(); j++) {
                m = deque.get(j);
                if (n.izq != null)
                    if ((n.izq.valor == m.valor) || (n.izq.valor == n.valor)) {
                        n.izq = null;
                    }
                if (n.der != null)
                    if ((n.der.valor == m.valor) || (n.der.valor == n.valor)) {
                        n.der = null;
                    }
            }
        }
    }
    public LinkedList<Integer> checkHeight(Nodo check) {
        LinkedList<Integer> heights = new LinkedList<>();
        LinkedList<Nodo> op = new LinkedList<>();
        Integer heightLeft = 0;
        Integer heightRight = 0;
        Nodo temp;
        temp = check;
        Integer i = 0;
        while (check.pasos != 2) {
            switch (temp.pasos) {
                case 0:
                    temp.setOne();
                    if (temp.izq != null) {
                        temp = temp.izq;
                        i++;
                        if (i > heightLeft) {
                            heightLeft = i;
                        }
                        break;
                    }
                case 1:
                    temp.setTwo();
                    if (temp.der != null) {
                        temp = temp.der;
                        i++;
                        if (i > heightLeft) {
                            heightLeft = i;
                        }
                        break;
                    }
                case 2:
                    temp.setThree();
                    op.add(temp);
                    if (i > heightLeft) {
                        heightLeft = i;
                    }
                    if (temp == check)
                        break;
                    temp = temp.padre;
                    i -= 1;
            }
            if (temp == check) {
                i = 0;
                break;
            }
        }
        op.add(temp);
        if (temp.der != null) {
            while (true) {
                switch (temp.pasos) {
                    case 0:
                        temp.setOne();
                        if (temp.izq != null) {
                            temp = temp.izq;
                            i++;
                            if (i > heightRight) {
                                heightRight = i;
                            }
                            break;
                        }
                    case 1:
                        temp.setTwo();
                        if (temp.der != null) {
                            temp = temp.der;
                            i++;
                            if (i > heightRight) {
                                heightRight = i;
                            }
                            break;
                        }
                    case 2:
                        temp.setThree();
                        op.add(temp);
                        if (i > heightRight) {
                            heightRight = i;
                        }
                        if (temp == check)
                            break;
                        temp = temp.padre;
                        i -= 1;
                        break;
                }
                if (temp == check) {
                    break;
                }
            }
        }
        for (Nodo n : op) {
            n.setPasos(0);
        }
        heights.add(heightLeft);
        heights.add(heightRight);
        return heights;
    }

    public LinkedList<Integer> chekRight(Nodo check) {
        LinkedList<Integer> heights = new LinkedList<>();
        LinkedList<Nodo> op = new LinkedList<>();
        Integer heightRight = 0;
        Nodo temp;
        temp = check;
        Integer i = 0;
        op.add(temp);
        while (true) {
            switch (temp.pasos) {
                case 0:
                    temp.setOne();
                    if (temp.izq != null) {
                        temp = temp.izq;
                        i++;
                        if (i > heightRight) {
                            heightRight = i;
                        }
                        break;
                    }
                case 1:
                    temp.setTwo();
                    if (temp.der != null) {
                        temp = temp.der;
                        i++;
                        if (i > heightRight) {
                            heightRight = i;
                        }
                        break;
                    }
                case 2:
                    temp.setThree();
                    op.add(temp);
                    if (i > heightRight) {
                        heightRight = i;
                    }
                    if (temp == check)
                        break;
                    temp = temp.padre;
                    i -= 1;
                    break;
            }
            if (temp == check) {
                break;
            }
        }
        for (Nodo n : op) {
            n.setPasos(0);
        }
        heights.add(0);
        heights.add(heightRight);
        return heights;
    }

    @Override
    public void breadthFrist() {
        super.breadthFrist();
    }

}