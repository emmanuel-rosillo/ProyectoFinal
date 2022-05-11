# arbol avl
## inserción
cuando estamos insertando un nuevo nodo dentro de un arbol binario de búsqueda, el nodo padre va a ser a donde su grado del nodo hijo lo lleve:
es decir cuando ingresa un nodo, se revisa la raíz como primer valor, sea numeros enteros, o caracteres, si el valor del nodo hijo es menor al del nodo en donde estamos parados, entonces se nos situarmes en el siguiente nodo consecutivo izquierdo; y se es mayor, se ra a la derecha
#### ahora...
Cada insertamos un nodo, verificamos en que lado va, si izquierda o derecha, y si ya está está lleno los dos caminos, lo insertamos en un nuevo camino...
cada nuevo camino, se podría decir que "es un nuevo nivel en el arbol", un arbol ***AVL*** es un arbol balanceado, ya que la resta de la altura del subarbol derecho menos el subarbol izquierdo, su total tendrá que ser en los rangos de -1, 0 o 1, si no se realiza un balanceo
Las alturas las imprime de la siguiente forma
```java
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
```
en la clase anterior, se puede encontrar la clase controladora de las alturas expicada a detalle en el video.

## balanceo
### explicación del funcionamiento de la clase :point_down:


[![ScreenShot](images/Screenshot%20from%202022-05-09%2001-05-13.png)](https://drive.google.com/file/d/1htEN2Bsm8H8mUxb2plqEXOTX84tzNRaI/view?usp=sharing)

seguimos el esquema explicado en el video sobre los cuatro tipos de rotaciones para su balanceo:

![ScreenShot](images/rot.png)

## Explicación breve del funcionamiento del programa
El programa cuando ingresa a un nodo ala raíz del árbol, lo inserta de una forma similar a un árbol binario de búsqueda, la única diferencia, es qué, cuando el nodo ya fue insertado, hace un método recursivo, para el camino que siguió  el nodo insertado. Una vez que Checa las alturas, válida el rango anterior, para conocer si el árbol está balanceado relativamente, si el valor de las alturas, es mayor que los rangos establecidos, llama a un método de balanceo para hacer el reajuste del árbol y poder qué las alturas sean las mismas qué el rango preestablecido
### A continuación observamos estos métodos :sunglasses:

***método de recursividad para las alturas*** :heart:
```java
//retorna una lista con el valor de la altura derecha y de la izquierda
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
```
***método de balance*** :hotsprings:
```java
//toma los tres ultimos nodos que recorrio el nodo insertado, para balancear
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
```