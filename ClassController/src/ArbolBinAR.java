import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArbolBinAR {
    NodoAR root;
    //NodoAR vacio=null;
    List<NodoAR> listaDeTodosLosNodos = new LinkedList();
    
    public ArbolBinAR(){
        root=null;
    }
    
    public ArbolBinAR(String val){
        root=new NodoAR(val);
    }
    
    public ArbolBinAR(NodoAR root){
        this.root=root;
    }
    
    public void add(NodoAR padre, NodoAR hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);            
	else
            padre.setDer(hijo);
    }
    protected void visit(NodoAR n){
        System.out.println(n.valor+" ");
        //listaDeNodos.add(n.valor);
    }
    
    public void nodosDeOperadores(int index, int resta, String[] limite, int contador){
        NodoAR nodoOperador;
        //Este if sirve para romper la recursividad
        if(limite.length != contador){
            if((index-resta)%2 == 0 | index == 1){
                nodoOperador = new NodoAR(limite[index]);
                listaDeTodosLosNodos.add(nodoOperador);
                if(index == 1)
                    index+=1;
                index+=1;
                contador+=1;
                nodosDeOperadores(index, resta, limite, contador);
            }else{
                nodoOperador = new NodoAR(limite[resta]);
                listaDeTodosLosNodos.add(nodoOperador);
                resta+=1;
                contador+=1;
                nodosDeOperadores(index, resta, limite, contador);
            }   
        }
    }
    
    public void nodosDeNumeros(String[] arrayNumeros){
        NodoAR nodoNumero;
        for(String valores: arrayNumeros){
            nodoNumero = new NodoAR(valores);
            listaDeTodosLosNodos.add(nodoNumero);
        }     
    }
    
    public void imprimirLista(){
        for(NodoAR nodos: listaDeTodosLosNodos)
            visit(nodos);  
    }
    
    //Este método contruyes la raíz y las ramas del árbol
    public void contruyendoArbol(){
        NodoAR padre = listaDeTodosLosNodos.get(0);
        NodoAR hijoIzq = listaDeTodosLosNodos.get(1);
        NodoAR hijoDer = listaDeTodosLosNodos.get(2);
        //En cualquier caso, se agrega la raíz y el hijo izquierdo
        root = padre;
        add(root,hijoIzq,0);
        //Este if nos ayudara solo para el caso de que haya dos operadores en la ecuacion del usuario
        if(listaDeTodosLosNodos.size()/2 != 2){
            //agregamos el hijo derecho
            add(root,hijoDer,1);
            //Este for solo agrega nodos derechos
            int operadores = listaDeTodosLosNodos.size()/2;
            //Se resta 2 porque ya se agregaron dos operadores anteriormente
            for(int i=1; i<operadores-2;i++){
                padre = listaDeTodosLosNodos.get(i);
                hijoDer = listaDeTodosLosNodos.get(i+2);
                add(padre,hijoDer,1);
            }
        }
        contruyendoNodosHoja(listaDeTodosLosNodos.size());
        //System.out.println("Se ha construido satisfactoriamente el árbol, FUCK YEAH!");
        System.out.println("\nEl Reverse Polish Notation de su árbol es:");
        reversePolishNotation(root);

    }
    
    public void contruyendoNodosHoja(int numeroDeNodos){
        int operadores = numeroDeNodos/2;
        int numeros =numeroDeNodos - operadores;
        NodoAR padre;
        NodoAR hijoIzq;
        NodoAR hijoDer;

        if(numeros != 2){
            /*
            if(root.der==null){
                add(root,listaDeTodosLosNodos.get(4),1);
                cantidadDeHojas-=1;
            }
            */
            //for para la parte izquierda del árbol
            int numerosEnLaIzquierda = numeros - numeros/2;
            for(int i=0; i<numerosEnLaIzquierda-1;i++){
                padre = listaDeTodosLosNodos.get(1+2*i);
                if(padre.izq==null){
                    hijoIzq = listaDeTodosLosNodos.get(operadores+i);
                    add(padre,hijoIzq,0);
                }
                if(padre.der==null){
                   hijoDer = listaDeTodosLosNodos.get(operadores+i+1);
                    add(padre,hijoDer,1); 
                }
            }
            //for para la parte derecha del árbol
            int numerosEnLaDerecha = numeros/2;
            
            for(int i=0; i<numerosEnLaDerecha;i++){
                padre = listaDeTodosLosNodos.get(2*i);
                int indiceParaNodosIzquierdos = operadores+ operadores/2 + 1*i;
                
                if(padre.izq==null){
                    hijoIzq = listaDeTodosLosNodos.get(indiceParaNodosIzquierdos);
                    add(padre,hijoIzq,0);
                }
                if(padre.der==null){
                   /*Solo hay una hoja derecha en el lado derecho del árbol 
                    entonces, solo se debe poner el indice en un solo caso*/
                    hijoDer = listaDeTodosLosNodos.get(operadores*2);
                    add(padre,hijoDer,1); 
                }
            }
        }
    }

    public void breadthFrist(){
        NodoAR r = root;
	Queue<NodoAR> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                
                r = (NodoAR)queue.poll();
		visit(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
    }
    
    //Recorrido PostOrden
    public void  reversePolishNotation(NodoAR padre){
        //imprimir(padre);
        NodoAR SegundoPadre;
	if(padre.izq!=null){
            SegundoPadre = padre.izq;
            reversePolishNotation(SegundoPadre);
            //imprimir(padre);
	}
        
        if(padre.der!=null){
            SegundoPadre = padre.der;
            reversePolishNotation(SegundoPadre);
            imprimir(padre);
	}else
            imprimir(padre);
    }
    
    protected void imprimir(NodoAR n){
        System.out.printf("%s ", n.valor);
        //listaDeNodos.add(n.valor);
    }
}