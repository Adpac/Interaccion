package com.example.interaccion;

import javax.microedition.khronos.opengles.GL10;
public class Figura7 {
    private float posx;
    private float posy;
    private float tamaño;
    private Circulo centro;
    private Circulo petalo1;
    private Circulo petalo2;
    private Circulo petalo3;
    private Circulo petalo4;
    private Circulo petalo5;
    private Rectangulo fondo;
    private boolean mostrarimg=false;
    private float verticescuadrado[]=new float[]{
            -0.8f,-0.8f,
            -0.8f,0.8f,
            0.8f,-0.8f,
            0.8f,0.8f,
    };

    public void modtamaño(){
        for (int i=0; i<verticescuadrado.length; i++){
            if(i%2==0){
                verticescuadrado[i]=(verticescuadrado[i]+posx);
            }else {
                verticescuadrado[i]=(verticescuadrado[i]+posy);
            }
        }
    }

    public Figura7(float posx, float posy,float tamaño){

        this.posx=posx;
        this.posy=posy;
        this.tamaño=tamaño;
        modtamaño();
        fondo=new Rectangulo(verticescuadrado);
        centro=new Circulo(tamaño*0.3f,tamaño*0.3f,360, true,0, 360,(0f*tamaño+posx),(0f*tamaño+posy), 255, 231, 43);
        petalo1=new Circulo(tamaño*0.3f,tamaño*0.3f,360, true,0, 360,(-0.4f*tamaño+posx),(0.1f*tamaño+posy), 253, 176, 64);
        petalo2=new Circulo(tamaño*0.3f,tamaño*0.3f,360, true,0, 360,(0.4f*tamaño+posx),(0.1f*tamaño+posy), 253, 176, 64);
        petalo3=new Circulo(tamaño*0.3f,tamaño*0.3f,360, true,0, 360,(0f*tamaño+posx),(0.4f*tamaño+posy), 253, 176, 64);
        petalo4=new Circulo(tamaño*0.3f,tamaño*0.3f,360, true,0, 360,(-0.2f*tamaño+posx),(-0.3f*tamaño+posy), 253, 176, 64);
        petalo5=new Circulo(tamaño*0.3f,tamaño*0.3f,360, true,0, 360,(0.2f*tamaño+posx),(-0.3f*tamaño+posy), 253, 176, 64);
    }

    public boolean tocofigura(float posacx, float posacy ){
        boolean retorno=false;
        if(puntoEstaDentroDelRectangulo(posacx,posacy,-0.8f+posx,-0.8f+posy,1.6f,1.6f)){
            if(mostrarimg==false){
                mostrarimg=true;
                retorno=true;
            }else {
                retorno=false;
            }
            return retorno;
        }else {
            return false;
        }
    }
    public boolean isMostrarimg() {
        return mostrarimg;
    }
    public void setMostrarimg(boolean mostrarimg) {
        this.mostrarimg = mostrarimg;
    }
    private boolean puntoEstaDentroDelRectangulo(float posx, float posy, float x,
                                                 float y, float ancho, float alto) {
        return ((x < posx) && (posx < (x + ancho)) && (y < posy) && posy < y + alto);
    }
    public void dibuja(GL10 gl) {
        fondo.dibuja(gl);
        if(mostrarimg){
            petalo1.dibuja(gl);
            petalo2.dibuja(gl);
            petalo3.dibuja(gl);
            petalo4.dibuja(gl);
            petalo5.dibuja(gl);
            centro.dibuja(gl);
        }
    }
}