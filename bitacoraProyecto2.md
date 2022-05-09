# Día 1 (viernes 22 de abril de 2022)

Minutos dedicados al proyecto: 50 minutos.

Investigué un poco RPN (Notación Polaca inversa) y en esencia es lo mismo que un recorrido (se denomina recorrido de un árbol al proceso que permite visitar al menos una vez a todos los nodos del árbol) PostOrden.

> Recordemos que el recorrido PostOrden se realiza de la siguiente manera:  
> 1) Recorrer el subárbol izquierdo en PostOrden.
> 2) Recorrer el subárbol derecho en PostOrden.
> 3) Examinar la raíz.<br>
> Enlace a esta explicación [aquí en el minuto 34:06](https://www.youtube.com/watch?v=KpqAy-uZ-04).

> La notación polaca inversa (en inglés, Reverse Polish Notation, o RPN), es una forma alternativa de escribir expresiones matemáticas. Por ejemplo, la expresión "20 - (4 + 3) * 2" en RPN es "20 4 3 + 2 * -". <br> El enlace a esta información está [aquí](https://www.glc.us.es/~jalonso/exercitium/notacion-polaca-inversa/#:~:text=La%20notaci%C3%B3n%20polaca%20inversa%20(en,3%20+%202%20*%20-%22%20.)).

Después vi que los operadores matemáticos que voy a utilizar para hacer las operaciones son: 

* paréntesis "()" 
* multiplicación "*"
* división "/"
* suma "+"
* resta "-"
  
Evidentemente respetando su jerarquía de operaciones.

<br>

Además, me di cuenta que los números funcionan más como hojas o hijos, y que los operadores fungen más como nodos padre:

<figure>
    <img src="arbolEjemplo.jpg"
         alt="árbol de ejemplo">
    <figcaption>Árbol de expresiones aritméticas "1+2*3-4/5"</figcaption>
</figure>

<br> <br>

# Día 2 (martes 3 de mayo de 2022)

Minutos dedicados al proyecto: 150 minutos.

> Hago unas revisiones del primer día (nada fuerte, solo explico la imagen y corrijo algunas faltas de ortografía).

Ahora, en este día me dedico a imaginar cómo voy a construir el programa, así que tomo lápiz y papel y empiezo a dibujar lo siguiente:

<figure>
    <img src="bocetoUno.jpg"
         alt="Boceto 1">
    <figcaption><i>Boceto 1: Asignación de operadores a los nodos</i></figcaption>
</figure>

<br>

<figure>
    <img src="bocetoDos.jpg"
         alt="Boceto 2">
    <figcaption><i>Boceto 2: Una idea de cómo dividir el String</i></figcaption>
</figure>

<br>

En el boceto 1 empiezo a ver cómo colocar los "nodos operadores". Por ejemplo, si la lista de operadores es la siguiente: [*, /, +, +, -, *]; La cantidad de operadores es 6, esto se divide entre 2 y se le suma 1, el resultado es 4. Entonces, se busca el cuarto operador en la lista, y nos daremos cuenta de que es "+". Ese operador se coloca en la raíz, posteriormente se van a gregando los demás operadores como se muestra en el **_Boceto 1_**. 

Después, en el boceto 2, mi idea era pedirle al usuario que separara cada número y cada operador con un espacio, pero entonces investigué más a fondo el método [*split()*](https://es.stackoverflow.com/questions/45846/c%C3%B3mo-separar-un-string-en-java-c%C3%B3mo-utilizar-split). Cuando descubrí que podía agregar más separadores, hice el siguiente código de prueba y su ejecución me dejó satisfecho:

```java
package proyecto2;
import java.util.Arrays;

public class Proyecto2 {

    public static void main(String[] args) {
        String palabras = "1+2*3-4/5";
        String[] textoSeparado = palabras.split("\\+|\\*|\\-|\\/");
        System.out.println("String original: "+palabras);
        System.out.println("String separado: ");
        System.out.println(Arrays.toString(textoSeparado));
    }
}
```

<figure>
    <img src="ejecucionUno.jpg"
         alt="Ejecucion 1">
</figure>

<br> <br>

# Día 3 (Viernes 6 de mayo de 2022)

Minutos dedicados al proyecto: 200 minutos.

> Hice unas revisiones en el código, agregué un segungo *array* de tipo String para guardar los operadores.

Cuando decidí agregar los operadores en un array, me di cuenta de que me agregaba un dato, por decirlo de alguna forma, nulo, ya que no me arroja ningun dato en sí (además, al no agregar ciertas especificaciones, los separadores se vuelven inservibles o en mi contra):

<figure>
    <img src="primerError.jpg"
         alt="Error 1">
</figure>

En esta ejecución decidí agregar un "11" en lugar del "1" para ver cómo funcionaban mis operadores, pero resulta que dejar como separador a "1" no funciona, porque me deja más espacios de lo querido. Así que pensé en otras soluciones.

El primer paso fue crear dos métodos: *separadorDeOperadores* ( método de tipo *String* que crea un *separador* personalizado para ayudar a identificar los operadores y guardarlos en el array) y *eliminandoEspacios* (método de tipo *String[]* que quita los valores basura del array original para guardar los operadores en un nuevo array).

Con lo anteriormente dicho, logro conseguir la siguiente  ejecución satisfactoria:

<figure>
    <img src="ejecucion2.jpg"
         alt="Ejecución 2">   
</figure>

Después, reutilicé las clases que nos brindó el profesor de árboles binarios, solo que cambiando el tipo de variable (en vez de mandar números enteros, voy a enviar los valores como *Strings* para crear los nodos). Las clases reutilizadas son: "ArbolBin.java" y "Nodo.java".

Hice bastante pseudo-código en una hoja para idear cómo guardar los nodos, me llevó hasta la madrugada, así que solo anotaré los minutos que le dediqué al proyecto "el día de hoy" . Más al rato explico lo que hice en el día 4.

# Día 4 (Viernes 6 de mayo de 2022)

Minutos dedicados al proyecto: 100 minutos.

> Revisé lo que hice en días anteriores para entrar en flujo

El "pseudo-código" que hice estaba bastante desordenado y mal hecho, así que decidí acomodarlo un poco, además de enumerar los pasos de mis pensamientos para un mayor orden. Así luce mi bosquejo para almacenar los nodos de los operadores:

<figure>
    <img src="bocetoTres.jpg"
         alt="Boceto 3">
    <figcaption><i>Boceto 3: Una idea de cómo guardar los nodos "padres" en la lista de nodos.</i></figcaption>
</figure>

<br>

En esta ocasión hago uso de la recursividad y de varias instrucciones if. Como suele pasar, mi pseudo-código muestra errores, pues la recursividad se repite de manera infinita arrojando errores, por lo que hice modificaciones, quedando el siguiente código que funciona perfectamente (también agrego su ejecución):

```java
public void NodosDeOperadores(int index, int resta, String[] limite, int contador){
        Nodo nodoOperador;
        //Este if sirve para romper la recursividad
        if(limite.length != contador){
            if((index-resta)%2 == 0 | index == 1){
                nodoOperador = new Nodo(limite[index]);
                listaDeTodosLosNodos.add(nodoOperador);
                if(index == 1)
                    index+=1;
                index+=1;
                contador+=1;
                NodosDeOperadores(index, resta, limite, contador);
            }else{
                nodoOperador = new Nodo(limite[resta]);
                listaDeTodosLosNodos.add(nodoOperador);
                resta+=1;
                contador+=1;
                NodosDeOperadores(index, resta, limite, contador);
            }   
        }
    }
```

<figure>
    <img src="ejecucion3.jpg"
         alt="Ejecución 3">   
</figure>

Como se muestra en la ejecución, se imprimen los nodos en el orden que deseaba, cumpliendo mi objetivo. Ahora siguen los números para después construir el árbol.

