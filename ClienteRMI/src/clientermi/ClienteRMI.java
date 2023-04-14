/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientermi;

/**
 *
 * @author sistemas
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Interface.RMIDAO;
import java.util.Scanner;

public class ClienteRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner consola = new Scanner(System.in);
        try{
            Registry registro=LocateRegistry.getRegistry("127.0.0.1",7777);
            RMIDAO interfaz = (RMIDAO) registro.lookup("RemotoRMI");
            int num1, num2, suma, resta, multiplicacion;
            float division;
            System.out.println("Ingresa numero 1:");
            num1 = consola.nextInt();
            System.out.println("Ingresa numero 2:");
            num2 = consola.nextInt();
            
            suma = interfaz.sumar( num1, num2);
            System.out.println("Resultado de la suma: " + suma);
            
            resta = interfaz.restar(num1, num2);
            System.out.println("Resultado de la resta: " + resta);
            
            multiplicacion = interfaz.multiplicar(num1, num2);
            System.out.println("Resultado de la multiplicacion: " + multiplicacion);
            
            try{
            division = interfaz.dividir(num1, num2);
                System.out.println("Resultado de la division: " + division);
            }
            catch(ArithmeticException e){
                System.out.println("No se puede dividir entre 0");
            }
        }catch(Exception e){
            System.out.println(""+e);
        }
    }
    
}
