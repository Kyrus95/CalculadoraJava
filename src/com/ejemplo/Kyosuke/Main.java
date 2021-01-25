package com.ejemplo.Kyosuke;
import java.util.*;
import java.math.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        String Desicion = "y"; //Condicion inicial para que ejecute el ciclo while
        String RestablecerValor = "y"; //Condicion inicial para que el switch RestablecerValor tome el case Y y permite al usuario ingresar numero
        BigDecimal bigValue1 = null;
        BigDecimal Resultado = null;
        while (Desicion.compareTo("n")!= 0) { //Ciclo while para que al final el usuario pueda elegir si desea seguir usando la calculadora o finalizar
            switch (RestablecerValor) { //Permite elegir al usuario si se desea seguir haciendo calculo con el resultado dado o empesar de nuevo
                case "y": //Funciona como el botón "AC" de la calculadora, restablece los valores a cero cuando ejecuta por primera vez el programa o cuando el usuario haya decidido restablecer valores
                    System.out.print("Ingrese un numero: ");
                    double Numero1 = teclado.nextDouble(); //double para capturar mayor cantidad de decimales posibles
                    String strValue1 = Double.toString(Numero1);
                    bigValue1 = new BigDecimal(strValue1); //conversion a bigdecimal para evitar errores de calculos
                    break;
                case "n":
                    bigValue1 = Resultado; //Usa el resultado de la operacion anterior para seguir realizando calculo
                    break;
            }
            System.out.print("¿Que operacion se desea realizar?: +, -, *, /, %: ");
            String operador = teclado.next();
            System.out.print("Ingrese otro numero: ");
            double Numero2 = teclado.nextDouble();
            String strValue2 = Double.toString(Numero2);
            BigDecimal bigValue2 = new BigDecimal(strValue2);
            switch (operador) {
                case "+":
                    assert bigValue1 != null;
                    Resultado = bigValue1.add(bigValue2);
                    break;
                case "-":
                    assert bigValue1 != null;
                    Resultado = bigValue1.subtract(bigValue2);
                    break;
                case "*":
                    assert bigValue1 != null;
                    Resultado = bigValue1.multiply(bigValue2);
                    break;
                case "/": //En caso de division se solicita al usuario definir la cantidad maxima de decimales para evitar errores generados por decimales infinitas
                    assert bigValue1 != null;
                    System.out.println("Indique la cantidad maxima de decimales que desee obtener para la division: ");
                    int maxDecimales = teclado.nextInt();
                    Resultado = bigValue1.divide(bigValue2,maxDecimales,RoundingMode.HALF_UP); //Se redondea los decimales a la cantidad maxima indicada
                    break;
                case "%":
                    assert bigValue1 != null;
                    Resultado = bigValue1.remainder(bigValue2);
                    break;
            }
            System.out.println(bigValue1 + " " + operador + " " + bigValue2 + " = " + Resultado);
            System.out.println("¿Desea continuar? Digite Y para continuar o N para finalizar: "); //El usuario define si quiere seguir usando la calculadora o finalizarla
            Desicion = teclado.next().toLowerCase();
            if (Desicion.compareTo("y")== 0) { //Si el usuario decidio seguir usando la calculadora, aqui puede escoger si empesar un nuevo calculo o seguir calculando con el valor del resultado de la operacion anterior
                System.out.println("¿Desea restablecer valor? Digite Y para restablecer o N para NO restablecer: ");
                RestablecerValor = teclado.next().toLowerCase();
            }
        }
    }
}