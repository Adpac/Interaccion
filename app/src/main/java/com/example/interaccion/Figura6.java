package com.example.interaccion;

import javax.microedition.khronos.opengles.GL10;

public class Figura6 {

    private float posx;
    private float posy;
    private float tamaño;
    private Circulo orejaizq1;
    private Circulo orejaizq2;
    private Circulo orejader1;
    private Circulo orejader2;
    private Circulo cabeza;
    private Circulo ojo1;
    private Circulo ojo2;
    private Circulo seccionboca;
    private Circulo hocico;
    private Circulo boca1;
    private Circulo boca2;
    private boolean mostrarimg=false;
    private Rectangulo fondo;

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


    public Figura6(float posx, float posy,float tamaño){

        this.posx=posx;
        this.posy=posy;
        this.tamaño=tamaño;
        modtamaño();

        fondo=new Rectangulo(verticescuadrado);
        orejaizq1=new Circulo(tamaño*0.4f,tamaño*0.4f,360, true,0, 360,(-0.5f*tamaño+posx),(0.7f*tamaño+posy-0.1f), 153, 73, 35);
        orejaizq2=new Circulo(tamaño*0.2f,tamaño*0.2f,360, true,0, 360,(-0.5f*tamaño+posx),(0.7f*tamaño+posy-0.1f), 248, 250, 245);
        orejader1=new Circulo(tamaño*0.4f,tamaño*0.4f,360, true,0, 360,(+0.5f*tamaño+posx),(0.7f*tamaño+posy-0.1f), 153, 73, 35);
        orejader2=new Circulo(tamaño*0.2f,tamaño*0.2f,360, true,0, 360,(+0.5f*tamaño+posx),(0.7f*tamaño+posy-0.1f), 248, 250, 245);
        cabeza=new Circulo(tamaño*0.7f,tamaño*0.8f,360, true,0, 360,(0f*tamaño+posx),(0f*tamaño+posy-0.1f), 153, 73, 35);
        ojo1=new Circulo(tamaño*0.1f,tamaño*0.1f,360, true,0, 360,(-0.2f*tamaño+posx),(0.2f*tamaño+posy-0.1f),  5, 9, 3);
        ojo2=new Circulo(tamaño*0.1f,tamaño*0.1f,360, true,0, 360,(0.2f*tamaño+posx),(0.2f*tamaño+posy-0.1f),  5, 9, 3);
        seccionboca=new Circulo(tamaño*0.36f,tamaño*0.36f,360, true,0, 360,(0f*tamaño+posx),(-0.3f+posy-0.1f),  243, 249, 247);
        hocico=new Circulo(tamaño*0.2f,tamaño*0.2f,360, true,0, 360,(0f*tamaño+posx),(-0.2f*tamaño+posy-0.1f),  4, 5, 7);
        boca1=new Circulo(tamaño*0.1f,tamaño*0.2f,180, false,-150, 150,(-0.1f*tamaño+posx),(-0.4f*tamaño+posy-0.1f),  4, 5, 7);
        boca2=new Circulo(tamaño*0.1f,tamaño*0.2f,180, false,-150, 150,(0.1f*tamaño+posx),(-0.4f*tamaño+posy-0.1f),  4, 5, 7);
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
            orejaizq1.dibuja(gl);
            orejaizq2.dibuja(gl);
            orejader1.dibuja(gl);
            orejader2.dibuja(gl);
            cabeza.dibuja(gl);
            ojo1.dibuja(gl);
            ojo2.dibuja(gl);
            seccionboca.dibuja(gl);
            hocico.dibuja(gl);
            boca1.dibuja(gl);
            boca2.dibuja(gl);
        }
    }
}