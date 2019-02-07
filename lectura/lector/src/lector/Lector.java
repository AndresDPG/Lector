package lector;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lector {
    
    public static void main(String[] args) throws IOException {
        filtraTexto();
    }
    
    public static void filtraTexto() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("../lectura.txt");
        Scanner src = new Scanner(fr);
        String texto = null;
        int opcion = menu();
        switch(opcion){
            case 1:
                System.out.println();
                while(src.hasNextLine()){
                    System.out.println(texto = src.next());
                }
                break;
            case 2: 
                String let = pedirLetra();
                while(src.hasNextLine()){
                    texto = src.next();
                    if(Character.toString(texto.charAt(0)).equals(let)){
                        System.out.println(texto);
                    }
                }
                break;
            case 3:
                while(src.hasNextLine()){
                    texto = src.next();
                    if(texto.length()==5){
                        System.out.println(texto);
                    }
                }
                break;
            case 4:
                while(src.hasNextLine()){
                    texto = src.next();
                    int principio = 0;
                    int fin = texto.length()-1;
                    boolean sera = false;
                    while((principio<fin) && (!sera)){
                        if(texto.charAt(principio) == texto.charAt(fin)){
                            principio++;
                            fin--;
                        }else {
                            sera = true;
                        }
                    }
                    if(!sera){
                        System.out.println(texto + " es un Palindromo");
                    }else{
                        //System.out.println(texto + " no es un Palindromo");
                    }
                }
                break;
            default:
                
                break;
        }
        src.close();
    } 
    
    public static int menu(){
        Scanner entrada=new Scanner(System.in);
        System.out.println("Menú de operaciones:\n1. Sin filtrar\n2. Filtrar palabras iniciadas por una letra dada\n"
                + "3. Solo palabras que tengan 5 caracteres\n4. Palabras que sean palindromos\n***************************************\n");
        int opcion = entrada.nextInt();
        return opcion;
    }
    
    public static String pedirLetra(){
        System.out.println("Introduzca una letra: ");
        Scanner nuevo = new Scanner(System.in);
        String letra = nuevo.nextLine();
        nuevo.close();
        return letra;
    }
}