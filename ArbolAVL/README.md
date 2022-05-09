# ProyectoFinal
## arbol avl
### inserción
cuando estamos insertando un nuevo nodo dentro de un arbol binario de búsqueda, el nodo padre va a ser a donde su grado del nodo hijo lo lleve:
es decir cuando ingresa un nodo, se revisa la raíz como primer valor, sea numeros enteros, o caracteres, si el valor del nodo hijo es menor al del nodo en donde estamos parados, entonces se nos situarmes en el siguiente nodo consecutivo izquierdo; y se es mayor, se ra a la derecha
#### ahora...
Cada insertamos un nodo, verificamos en que lado va, si izquierda o derecha, y si ya está está lleno los dos caminos, lo insertamos en un nuevo camino...
cada nuevo camino, se podría decir que "es un nuevo nivel en el arbol", un arbol ***AVL*** es un arbol balanceado, ya que la resta de la altura del subarbol derecho menos el subarbol izquierdo, su total tendrá que ser en los rangos de -1, 0 o 1, si no se realiza un balanceo
Las alturas las imprime de la siguiente forma
```java
if(vIzq == true){
            this.hL = -i;
        }else {
            this.hR = i;
        }
        System.out.println("altura izquierda: " + hL + ", altura derecha: " + hR + " y la altura general: " + h);
```
en la clase se puede encontrar el contador de "i" y "h" para mayor especificación

### balanceo
