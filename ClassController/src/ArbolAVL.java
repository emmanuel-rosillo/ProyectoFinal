import java.util.Deque;
import java.util.LinkedList;

public class ArbolAVL extends ArbolBinAVL {
    NodoAVL root;
    NodoAVL temp;
    LinkedList<Integer> rec = new LinkedList();

    public ArbolAVL() {
    }

    public ArbolAVL(NodoAVL root, NodoAVL temp) {
        this.root = root;
        this.temp = temp;
    }

    public ArbolAVL(NodoAVL root) {
        super(root);
        this.root = root;
    }
    //construye el arbol
    public synchronized void buildTree(NodoAVL hijo) {
        Deque<NodoAVL> deque = new LinkedList<>();
        deque.add(root);
        NodoAVL temp = root;
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
    public void checkBalance(NodoAVL hijo) {
        Deque <NodoAVL> unbalance = new LinkedList<>();
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
                NodoAVL z = unbalance.pollLast();
                NodoAVL y = unbalance.pollLast();
                NodoAVL x = unbalance.pollLast();
                System.out.println("\n");
                System.out.println("entro en el nodo: " + z.valor + " siguio por el nodo: " + y.valor + " la insercion que desvalenceo el arbol: " + x.valor);
                System.out.println("\n");
                balance(x, y, z);
            }
            System.out.println("valor del nodo que se reviso la altura: " + hijo.valor + " su altura izquierda: " + izq + " su altura derecha: " + der);
            hijo = hijo.padre;
        }
    }
    public void balance(NodoAVL x, NodoAVL y, NodoAVL z) {
        int rec1 = rec.pollLast();
        int rec2 = rec.pollLast();
        NodoAVL temp = null;
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
    public void checkNode(NodoAVL x, NodoAVL y, NodoAVL z) {
        LinkedList<NodoAVL> deque = new LinkedList<>();
        deque.add(y);
        deque.add(x);
        NodoAVL n = null;
        NodoAVL m = null;
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
    public LinkedList<Integer> checkHeight(NodoAVL check) {
        LinkedList<Integer> heights = new LinkedList<>();
        LinkedList<NodoAVL> op = new LinkedList<>();
        Integer heightLeft = 0;
        Integer heightRight = 0;
        NodoAVL temp;
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
        for (NodoAVL n : op) {
            n.setPasos(0);
        }
        heights.add(heightLeft);
        heights.add(heightRight);
        return heights;
    }
    public LinkedList<Integer> chekRight(NodoAVL check) {
        LinkedList<Integer> heights = new LinkedList<>();
        LinkedList<NodoAVL> op = new LinkedList<>();
        Integer heightRight = 0;
        NodoAVL temp;
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
        for (NodoAVL n : op) {
            n.setPasos(0);
        }
        heights.add(0);
        heights.add(heightRight);
        return heights;
    }
    public void setRoot(NodoAVL root) {
        this.root = root;
    }
    @Override
    public void breadthFrist() {
        super.breadthFrist();
    }
    @Override
    public boolean inTree(NodoAVL search) {
        return super.inTree(search);
    }
    @Override
    public void deleteKey(NodoAVL delete) {
        super.deleteKey(delete);
    }
}