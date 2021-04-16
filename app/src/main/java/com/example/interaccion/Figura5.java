package com.example.interaccion;


import javax.microedition.khronos.opengles.GL10;

public class Figura5 {
    private float posx;
    private float posy;
    private float tamaño;
    private Circulo cabeza;
    private Circulo sonrrisa;
    private Circulo sonrrisa2;
    private Circulo ojo1;
    private Circulo ojo2;
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


    public Figura5(float posx, float posy,float tamaño){

        this.posx=posx;
        this.posy=posy;
        this.tamaño=tamaño;
        modtamaño();
        cabeza=new Circulo(tamaño*0.8f,tamaño*0.8f,360, true,0, 360,(0f*tamaño+posx),(0f*tamaño+posy), 255, 199, 42);
        sonrrisa=new Circulo(tamaño*0.4f,tamaño*0.2f,180, true,-180, 180,(0f*tamaño+posx),(-0.3f*tamaño+posy), 118, 73, 30);
        sonrrisa2=new Circulo(tamaño*0.4f,tamaño*0.2f,180, true,-180, 180,(0f*tamaño+posx),(-0.2f*tamaño+posy), 255, 199, 42);
        ojo1=new Circulo(tamaño*0.1f,tamaño*0.2f,360, true,0, 360,(-0.3f*tamaño+posx),(0.2f*tamaño+posy),  130, 84, 32);
        ojo2=new Circulo(tamaño*0.1f,tamaño*0.2f,360, true,0, 360,(0.3f*tamaño+posx),(0.2f*tamaño+posy),  130, 84, 32);
        fondo=new Rectangulo(verticescuadrado);
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
            cabeza.dibuja(gl);
            cabeza.dibuja(gl);
            sonrrisa.dibuja(gl);
            sonrrisa2.dibuja(gl);
            ojo1.dibuja(gl);
            ojo2.dibuja(gl);
        }
    }
}