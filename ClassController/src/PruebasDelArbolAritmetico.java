

import java.io.IOException;
//import java.util.Arrays;
/**
 *
 * @author 3ns3r
 */
public class PruebasDelArbolAritmetico {
    //PruebasDelArbolAritmetico 
    public static void main(String[] args) throws IOException {
        
        MainAR invocarArbolAritmetico = new MainAR();
        invocarArbolAritmetico.menu();
        
        /*
        String expresion = "1+2-3*4/5";
        //String expresion = "11+2";
        String separador = "";
        System.out.println(3-(3/2));
        
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
        ArbolBinAR arbol = new ArbolBinAR(strOperadoresSeparados[index]);
        arbol.nodosDeOperadores(index, 0, strOperadoresSeparados, 0);
        arbol.nodosDeNumeros(strNumerosSeparados);
        arbol.imprimirLista();
        arbol.contruyendoArbol();
        //arbol.imprimirLista();
        System.out.println("\nBFS de su árbol queda así:");
        arbol.breadthFrist();
        */
    }
    
    //Metodos para tener los nodos de los operadores y los numeros
    /*public static void NodosDeOperadores(String[] strOperadoresSeparados){
        
        ArbolBinAR arbol;
        NodoAR padre, hijoIzq, hijoDer;
        
        if(strOperadoresSeparados.length % 2 == 0){
            
            arbol = new ArbolBinAR(strOperadoresSeparados[0]);
            for(int i=0; i<strOperadoresSeparados.length-1; i++){
                
            }
            
        }else{
            //Agrego este if por si hay un solo operador
            if(strOperadoresSeparados.length == 1)
                arbol = new ArbolBinAR(strOperadoresSeparados[0]);
        }
            
    }
    
    */
    
    /*
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
    */
}
