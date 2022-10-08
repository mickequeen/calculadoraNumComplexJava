package CalculadoraNumComplejo;
import javax.swing.*;

public class Calculadora {
  public static void menuOperacion( Double[] arregloComplejos ) {
    String[] operaciones = {"Sumar +", "Restar -", "Multiplicar *", "Dividir /"};
    int menuOperaciones = JOptionPane.showOptionDialog(null, "Dados los números complejos (" + arregloComplejos[0]+", "
                    + arregloComplejos[1] + ") y (" + arregloComplejos[2] + ", "+ arregloComplejos[3]+ "), Elija qué operación ejecutar" , "Elegir acción",
            JOptionPane.INFORMATION_MESSAGE, 3, null, operaciones, operaciones[3]);
    switch (menuOperaciones) {
      case 0: {
        Complejo suma = new Complejo();
        Complejo.retornoComplejo resultadoSuma = suma.sumar(arregloComplejos);
        String resultado = "(" + arregloComplejos[0]+", " + arregloComplejos[1] + ") + (" + arregloComplejos[2] + ", "+ arregloComplejos[3] + ") = ("+
                resultadoSuma.retornoReal + ", " + resultadoSuma.retornoImag + ")" ;
        JOptionPane.showMessageDialog(null, resultado );
        JOptionPane.showMessageDialog(null, "Proceso terminado, vuelve a ingresar datos" );
        menu();
        break;
      }
      case 1: {
        Complejo resta = new Complejo();
        Complejo.retornoComplejo resultadoResta = resta.restar(arregloComplejos);
        String resultado = "(" + arregloComplejos[0]+", " + arregloComplejos[1] + ") - (" + arregloComplejos[2] + ", "+ arregloComplejos[3] + ") = ("+
                resultadoResta.retornoReal + ", " + resultadoResta.retornoImag + ")" ;
        JOptionPane.showMessageDialog(null, resultado );
        JOptionPane.showMessageDialog(null, "Proceso terminado, vuelve a ingresar datos" );
        menu();
        break;
      }
      case 2: {
        Complejo multiplicacion = new Complejo();
        Complejo.retornoComplejo resultadoMultiplicacion = multiplicacion.multiplicar(arregloComplejos);
        String resultado = "(" + arregloComplejos[0]+", " + arregloComplejos[1] + ") * (" + arregloComplejos[2] + ", "+ arregloComplejos[3] + ") = ("+
                resultadoMultiplicacion.retornoReal + ", " + resultadoMultiplicacion.retornoImag + ")" ;
        JOptionPane.showMessageDialog(null, resultado );
        JOptionPane.showMessageDialog(null, "Proceso terminado, vuelve a ingresar datos" );
        menu();
        break;
      }
      case 3: {
        Complejo division = new Complejo();
        Complejo.retornoComplejo resultadoDivision = division.dividir(arregloComplejos);
        String resultado = "(" + arregloComplejos[0]+", " + arregloComplejos[1] + ") / (" + arregloComplejos[2] + ", "+ arregloComplejos[3] + ") = ("+
                resultadoDivision.retornoReal + ", " + resultadoDivision.retornoImag + ")" ;
        JOptionPane.showMessageDialog(null, resultado );
        JOptionPane.showMessageDialog(null, "Proceso terminado, vuelve a ingresar datos" );
        menu();
        break;
      }
    }

  }
  public static void segundoMenu( Complejo.retornoComplejo primerParametro) {
    Double[] dosComplejos = new Double[4];
    Complejo segundoComplejo = new Complejo();
    String[] segundo = {"Definir segundo complejo nulo (0,0)", "Ingresar parámetros segundo complejo"};
    int segundoInicio = JOptionPane.showOptionDialog(null, "Seleccionar cómo ingresar segundo número", "Elegir acción",
            JOptionPane.INFORMATION_MESSAGE, 3, null, segundo, segundo[1]);
    switch (segundoInicio) {
      case 0: {
        Complejo.retornoComplejo segundoNulo =  segundoComplejo.setComplejoNulo();
        JOptionPane.showMessageDialog(null, "Segundo número complejo definido como: '(" + segundoNulo.retornoReal + ", "
                + segundoNulo.retornoImag + ")'");
        dosComplejos[0]= primerParametro.retornoReal;
        dosComplejos[1]= primerParametro.retornoImag;
        dosComplejos[2]= segundoNulo.retornoReal;
        dosComplejos[3]= segundoNulo.retornoImag;
        menuOperacion(dosComplejos);
        break;
      }
      case 1: {
        // definir número
        Double numReal  = 0.00;
        Double numImag  = 0.00;
        try {
          numReal = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese primer carácter del número complejo"));
          numImag = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese segundo carácter del número complejo"));

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error: debe ingresar un número entero o decimal, ej: 10.10, vuelve a comenzar",
                  "Error",  JOptionPane.ERROR_MESSAGE);
          segundoMenu(primerParametro);
        }
        Complejo.retornoComplejo segundoIngresado =  segundoComplejo.setComplejo(numReal, numImag);
        dosComplejos[0]= primerParametro.retornoReal;
        dosComplejos[1]= primerParametro.retornoImag;
        dosComplejos[2]= segundoIngresado.retornoReal;
        dosComplejos[3]= segundoIngresado.retornoImag;
        menuOperacion(dosComplejos);
        break;
      }
    }
  }

  // primer menú, no recibe nada pero da las opciones del primer ingreso
  public static void menu(){
    Complejo primerComplejo = new Complejo();

    String[] buttons = { "Definir primer complejo nulo (0,0)",
            "Ingresar parámetros primer número complejo" };
    int opcionesInicio = JOptionPane.showOptionDialog(null, "Selecciona cómo ingresar tus números", "Elegir acción",
            JOptionPane.INFORMATION_MESSAGE, 3, null, buttons, buttons[1]);
    switch (opcionesInicio){
      case 0:{
        Complejo.retornoComplejo primeroNulo =  primerComplejo.setComplejoNulo();
        JOptionPane.showMessageDialog(null, "Primer número complejo definido como: '(" + primeroNulo.retornoReal + ", "
                + primeroNulo.retornoImag + ")'");
        segundoMenu(primeroNulo);
        break;

      }
      case 1:{
        // definir número
        Double numReal  = 0.00;
        Double numImag  = 0.00;
        try {
          numReal = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese primer carácter del número complejo"));
          numImag = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese segundo carácter del número complejo"));
          Complejo.retornoComplejo primeroIngresado =  primerComplejo.setComplejo(numReal, numImag );
          JOptionPane.showMessageDialog(null, "Primer número complejo definido como: '(" + primeroIngresado.retornoReal + ", "
                  + primeroIngresado.retornoImag + ")'");
          segundoMenu(primeroIngresado);

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error: debe ingresar un número entero o decimal, ej: 10.10, vuelve a comenzar",
                  "Error",  JOptionPane.ERROR_MESSAGE);
          menu();
        }
        break;
      }
    }
  }

  public static void main(String[] args) {
    // llamado al primer menú y seguir flujo
    menu();

  }
}
