
package proyecto2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author 3ns3r
 */
public class ArbolBin {
    Nodo root;
    Nodo vacio=null;
    List<Integer> listaDeNodos = new LinkedList();
    List<Nodo> listaTransformada = new LinkedList();
    List<Nodo> listaDeTodosLosNodos = new LinkedList();
    
    
    public ArbolBin(){
        root=null;
    }
    
    public ArbolBin(String val){
        root=new Nodo(val);
    }
    
    public ArbolBin(Nodo root){
        this.root=root;
    }
    
    public void add(Nodo padre, Nodo hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);            
	else
            padre.setDer(hijo);
    }
    
    protected void visit(Nodo n){
        System.out.println(n.valor+" ");
        //listaDeNodos.add(n.valor);
    }
    
    
    public void nodosDeOperadores(int index, int resta, String[] limite, int contador){
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
                nodosDeOperadores(index, resta, limite, contador);
            }else{
                nodoOperador = new Nodo(limite[resta]);
                listaDeTodosLosNodos.add(nodoOperador);
                resta+=1;
                contador+=1;
                nodosDeOperadores(index, resta, limite, contador);
            }   
        }
    }
    
    public void nodosDeNumeros(String[] arrayNumeros){
        Nodo nodoNumero;
        for(String valores: arrayNumeros){
            nodoNumero = new Nodo(valores);
            listaDeTodosLosNodos.add(nodoNumero);
        }     
    }
    
    public void imprimirLista(){
        /*for(int nodos : listaDeNodos){
            System.out.println("a ver si salió "+nodos);
        }*/
        for(Nodo nodos: listaDeTodosLosNodos)
            visit(nodos);
            
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Estos son los dos métodos para borrar nodos
    public void reconstruirArbol(int numeroDeNodos){
        int contador = 0;
        Nodo padre, hijoIzq, hijoDer;
        /*Este if me salva el último nodo (en el caso de que solo haya un nodo hijo en el
          último nodo padre)*/
        if(numeroDeNodos%2 ==0)
            listaTransformada.add(vacio);
        numeroDeNodos = numeroDeNodos/2;
        for(int i=0; i<numeroDeNodos; i++){
            padre = listaTransformada.get(i);
            hijoIzq = listaTransformada.get(i+(i+1));
            add(padre, hijoIzq, 0);

            hijoDer = listaTransformada.get(i+(i+2));
            add(padre, hijoDer, 1);
            if(contador==0){
                root=padre;
                contador+=1;
            }
        }
    }
    /*
    
    public void deleteNode(int nodoParaEliminar){
        //Agrego esto para saber en qué índice borrar el nodo
        int indiceDelNodoEliminado=0, contador=0;
        //listaDeNodos.add(root); 
        for(int nodos: listaDeNodos){
            int nodoParaComparar = nodos;
            if(nodoParaComparar != nodoParaEliminar){
                //System.out.println(nodos);
                contador+=1;
                Nodo nodoGenerado = new Nodo(nodoParaComparar);
                listaTransformada.add(nodoGenerado);
            }else
                indiceDelNodoEliminado=contador;
        }
        listaDeNodos.remove(indiceDelNodoEliminado);
        //System.out.println("El tamaño de la lista es (no debe de ser 9): "+listaDeNodos.size());
        //System.out.println("El segundo elemento de la lista es (no debe de ser 7): "+listaDeNodos.get(indiceDelNodoEliminado));
        reconstruirArbol(listaDeNodos.size());
    }
    */
    //Métodos para buscar un nodo en el árbol
    public void findNode(int searchedNode){
        if(listaDeNodos.contains(searchedNode))
            System.out.println("El nodo "+searchedNode+" SI se encuentra en el árbol");
        else
            System.out.println("El nodo "+searchedNode+" NO se encuentra en el árbol");
    }
    
    public void breadthFrist(){
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                
                r = (Nodo)queue.poll();
		visit(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
    }
}
