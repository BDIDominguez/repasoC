/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoc;

import java.util.Scanner;

/**
 *
 * @author Dario
 */
public class GuiaC {
    
    /* 12. Escriba un método que valide si una nota ingresada por teclado está entre 0 y 10, sino está
entre 0 y 10 la nota se pedirá de nuevo hasta que la nota sea correcta. */
    
    public static void validaNota(){
        Scanner teclado = new Scanner(System.in);
        int vNota;
        do{
            System.out.println("Ingrese la nota del alumno ");
            vNota = teclado.nextInt();
        } while (vNota < 0 || vNota > 10);
    }
    
    /* 13. Escriba un método en el cual se ingrese un valor límite positivo, y a continuación solicite
números al usuario hasta que la suma de los números introducidos supere el límite inicial. */
    
    public static void sumaNumeros(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el limite!");
        int vLimite = teclado.nextInt();
        int vAcumulador = 0;
        do{
            System.out.println("Ingrese un numero aleatoreo");
            int vNumero = teclado.nextInt();
            vAcumulador = vAcumulador + vNumero;
        }while (vLimite > vAcumulador);
    }
    
    /* 14. Realizar un método que pida dos números enteros positivos por teclado y muestre por pantalla
el siguiente menú:
MENU
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
5. Salir
Elija opción:

El usuario deberá elegir una opción y el programa deberá mostrar el resultado por pantalla y luego
volver al menú. El método deberá ejecutarse hasta que se elija la opción 5. Tener en cuenta que,
si el usuario selecciona la opción 5, en vez de salir del programa directamente, se debe mostrar el
siguiente mensaje de confirmación: ¿Está seguro que desea salir (S/N)? Si el usuario selecciona
el carácter ‘S’ termina, caso contrario se vuelve a mostrar el menú. */
    public static void primerMenu() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el primer Numero");
        int vNum1 = teclado.nextInt();
        System.out.println(" ");
        System.out.print("Ingrese el primer Segundo");
        int vNum2 = teclado.nextInt();
        int vOps;
        do {
            System.out.println(" ******* MENU ******");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.print("Elija opcion: ");
            vOps = teclado.nextInt();
            switch (vOps) {
                case 1:
                    System.out.println("La Suma es de " + (vNum1 + vNum2));
                    break;
                case 2:
                    System.out.println("La resta es de " + (vNum1 - vNum2));
                    break;
                case 3:
                    System.out.println("La multiplicacion es de " + (vNum1 * vNum2));
                    break;
                case 4:
                    if (vNum2 != 0) {
                        System.out.println("La divicion es de " + (vNum1 / vNum2));
                    } else {
                        System.out.println("No se puede divider por 0");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Esa opcion no esta Implementada");
                    break;
            }
        } while (vOps != 5);
    }

    /* 15. Escriba un método que lea 20 números. Si el número leído es igual a cero se debe salir del
bucle y mostrar el mensaje "Se capturó el número cero". El método deberá calcular y mostrar el
resultado de la suma de los números leídos, pero si el número es negativo no debe sumarse. Nota:
recordar el uso de la sentencia break. */
    
    public static void ingresaCero(){
        Scanner teclado = new Scanner(System.in);
        int vNumero,vContador=0;
        for (int i = 1; i <= 20; i++){
            System.out.print(i + "- Ingresa numero: ");
            vNumero = teclado.nextInt();
            if (vNumero== 0){
                System.out.println("Se capturo el numero cero");
                break;
            }else if (vNumero > 0){
                vContador = vContador + vNumero;
            }
        } 
        System.out.println("la suma acumulada es de " + vContador);
    }

    /* 16. Escribir un método que simule el funcionamiento de un dispositivo RS232, este tipo de
dispositivo lee cadenas enviadas por el usuario. Las cadenas deben llegar con un formato fijo:
tienen que ser de un máximo de 5 caracteres de largo, el primer carácter tiene que ser X y el último
tiene que ser una O.
Las secuencias leídas que respeten el formato se consideran correctas, la secuencia especial
“&&&&&” marca el final de los envíos (llamémosla FDE), y toda secuencia distinta de FDE, que
no respete el formato se considera incorrecta. Al finalizar el proceso, se imprime un informe
indicando la cantidad de lecturas correctas e incorrectas recibidas. Para resolver el ejercicio deberá
investigar cómo se utilizan los siguientes métodos de la clase String: Substring(), Length(),
equals(). */
    
    public static void rs323() {
        Scanner teclado = new Scanner(System.in);
        boolean vSalir = true;
        int i = 1, vCorrectas = 0, vIncorrectas = 0;
        while (vSalir) {
            System.out.print("Ingrese la " + i + " cadena del mensaje: ");
            String vDato = teclado.nextLine();
            
            if (vDato.length() == 5) {
                if (vDato.equals("&&&&&")) {
                    vSalir = false;
                    System.out.println("Gracias por Ingresar los Datos!");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                } else if (vDato.startsWith("X") && vDato.endsWith("0")) {
                    vCorrectas++;
                } else {
                    vIncorrectas++;
                }
            } else {
                System.out.println("El Tamaño del Dato es incorrecto" + vDato.length());
            }
        }
        System.out.println("La cantidad de entradas Correctas " + vCorrectas);
        System.out.println("La cantidad de entradas Incorrectas " + vIncorrectas);
    }
    
    
    
    
    
    /* 17. Crear un método que dibuje un cuadrado de N elementos por lado utilizando el carácter “*”.
Por ejemplo, si el cuadrado tiene 4 elementos por lado se deberá dibujar lo siguiente:
* * * *
*     *
*     *
* * * *
El valor de N se ingresará por teclado y en este caso utilice la estructura while para dibujarlo. */
    public static void dibujaCuadrado(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("De que dimension quieres tu cuadrado, mi rey: ");
        int vLado = teclado.nextInt();
        int i=1,b=1;
        while (i <= vLado){
            while (b<= vLado){
               if (i > 1 && i < vLado && b>1 && b<vLado){
                   System.out.print(" ");
               }else{
                   System.out.print("*");
               }
                b++;
            }
            b = 1;
            System.out.println(" ");
            i++;
        }
    }
    
    
    
    
    /* 18. Realizar un método que lea 4 números (comprendidos entre 1 y 20) e imprima el número
ingresado seguido de tantos asteriscos como indique su valor. Por ejemplo:
5 *****
3 ***
11 ***********
2 **
    */
    
    public static void rellena(){
        Scanner teclado = new Scanner(System.in);
        for (int i = 1; i < 21;i++){
            System.out.print("El valor nro " + i + " es " );
            int vNumero = teclado.nextInt();
            System.out.println("Incorporando a " + vNumero + convertirAsterisco(vNumero) );
        }
            
    }
    public static String convertirAsterisco(int i){
        String vCadena = "";
        for (int a = 0;a<i;a++){
            vCadena = vCadena + "*";
        }
        return vCadena;
    }
    
    
} // Fin de Clase
