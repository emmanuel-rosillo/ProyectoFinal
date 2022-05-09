
package proyecto2;

import java.util.Arrays;

/**
 *
 * @author 3ns3r
 */
public class Main {
    
    public static void main(String[] args) {
        String expresion = "11+2*3-4/5";
        //String expresion = "11+2";
        String separador = "";
        
        
        String[] strNumerosSeparados = expresion.split("\\+|\\*|\\-|\\/");
        System.out.println("String original: "+expresion);
        System.out.println("String separado (números): ");
        System.out.println(Arrays.toString(strNumerosSeparados));
        
        //Aqui sacamos el separador para los operadores
        separador = separadorDeOperadores(strNumerosSeparados, separador);
        //System.out.println("El separador después del método "+separador);
        String[] strOperadores = expresion.split(separador);
        
        //Aqui eliminamos el valor ¨nulo¨ del array de los operadores
        String[] strOperadoresSeparados = eliminandoEspacios(strOperadores);
        System.out.println("String separado (operadores): ");
        System.out.println(Arrays.toString(strOperadoresSeparados));
        int index = (strOperadoresSeparados.length)/2;
        
        //Aqui transformamos y guardamos los operadores y los numeros en la lista de nodos
        ArbolBin arbol = new ArbolBin(strOperadoresSeparados[index]);
        arbol.nodosDeOperadores(index, 0, strOperadoresSeparados, 0);
        arbol.nodosDeNumeros(strNumerosSeparados);
        arbol.imprimirLista();
    }
    
    //Metodos para tener los nodos de los operadores y los numeros
    /*public static void NodosDeOperadores(String[] strOperadoresSeparados){
        
        ArbolBin arbol;
        Nodo padre, hijoIzq, hijoDer;
        
        if(strOperadoresSeparados.length % 2 == 0){
            
            arbol = new ArbolBin(strOperadoresSeparados[0]);
            for(int i=0; i<strOperadoresSeparados.length-1; i++){
                
            }
            
        }else{
            //Agrego este if por si hay un solo operador
            if(strOperadoresSeparados.length == 1)
                arbol = new ArbolBin(strOperadoresSeparados[0]);
        }
            
    }
    
    */
    
    
    //Metodos para tener los arrays de los numeros y operadores
    public static String separadorDeOperadores(String[] numeros, String separador){
        //String separadorModificado="";
        for(int i=0; i<numeros.length; i++){
            if(i==numeros.length-1)
                separador = separador+numeros[i];
            else
                separador = separador+numeros[i]+"|";
        }
        //System.out.println("El separador en el método "+separador);
        return separador;
    }
    public static String[] eliminandoEspacios(String[] operadores){
        String[] strSinNulos = new String[operadores.length-1];
        for(int i=0; i<operadores.length; i++){
            if(i>0)
                strSinNulos[i-1] = operadores[i];
        }
        //System.out.println("El nuevo Array en el método: "+Arrays.toString(strSinNulos));
        return strSinNulos;
    }
}
