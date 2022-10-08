package CalculadoraNumComplejo;

public class Complejo {
  Double complejoReal;
  Double complejoImag;

  // seter de complejo en 0
  public retornoComplejo setComplejoNulo(){
    this.complejoReal = 0.0;
    this.complejoImag = 0.0;
    retornoComplejo retorno = retornoCompuesto(complejoReal, complejoImag);
    return retorno;
  }

  // setter de complejo ingresado por teclado
  public retornoComplejo setComplejo(Double primerReal, Double primerI){
    this.complejoReal = primerReal;
    this.complejoImag = primerI;
    retornoComplejo retorno = retornoCompuesto(complejoReal, complejoImag);
    return retorno;
  }

  // retorno tipo de dato double, con dos datos
  class retornoComplejo {
    Double retornoReal;
    Double retornoImag;
    retornoComplejo(Double real, Double img) {
      retornoReal = real;
      retornoImag = img;
    }
  }

  // function para retornar tipo complejo.
  retornoComplejo retornoCompuesto( Double retornoReal, Double retornoImag) {
    return new retornoComplejo(retornoReal, retornoImag);
  }

  // funcion sumar, desde array con los 4 datos necesarios
  public retornoComplejo sumar(Double[] complejos){
    Double primerReal = complejos[0];
    Double primerImag = complejos[1];
    Double segundoReal = complejos[2];
    Double segundoImag = complejos[3];
    Double sumaReal = primerReal + segundoReal;
    Double sumaImag = primerImag + segundoImag;
    retornoComplejo retorno = retornoCompuesto(sumaReal, sumaImag);
    return retorno;
  }

  // funcion restar, desde array con los 4 datos necesarios
  public retornoComplejo restar(Double[] complejos){
    Double primerReal = complejos[0];
    Double primerImag = complejos[1];
    Double segundoReal = complejos[2];
    Double segundoImag = complejos[3];
    Double restaReal = primerReal - segundoReal;
    Double restaImag = primerImag - segundoImag;
    retornoComplejo retorno = retornoCompuesto(restaReal, restaImag);
    return retorno;
  }

  public retornoComplejo multiplicar(Double[] complejos){
    Double primerReal = complejos[0];
    Double primerImag = complejos[1];
    Double segundoReal = complejos[2];
    Double segundoImag = complejos[3];
    Double multReal = primerReal * segundoReal;
    Double multImag = primerImag * segundoImag;
    Double restaRealImg = multReal - multImag;

    Double multRealIm = primerReal * segundoImag;
    Double mulImgReal = primerImag * segundoReal;
    Double sumaRealImg = multRealIm + mulImgReal;
    retornoComplejo retorno = retornoCompuesto(restaRealImg, sumaRealImg);
    return retorno;
  }

  public retornoComplejo dividir(Double[] complejos){
    Double primerReal = complejos[0];
    Double primerImag = complejos[1];
    Double segundoReal = complejos[2];
    Double segundoImag = complejos[3];

    Double multReal = primerReal * segundoReal;
    Double multImag = primerImag * segundoImag;
    Double sumaRealImg = multReal + multImag;
    Double sumaSegundoComplejo = Math.pow(segundoReal, 2) +  Math.pow(segundoImag, 2);
    Double primerComplejo = sumaRealImg/sumaSegundoComplejo;

    Double mulImgReal = primerImag * segundoReal;
    Double multRealIm = primerReal * segundoImag;
    Double RestaSegundoComp = mulImgReal - multRealIm;
    Double segundoComplejo = RestaSegundoComp/sumaSegundoComplejo;
    retornoComplejo retorno = retornoCompuesto(primerComplejo, segundoComplejo);
    return retorno;
  }

}
