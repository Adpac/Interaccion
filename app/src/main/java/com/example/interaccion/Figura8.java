package com.example.interaccion;
import javax.microedition.khronos.opengles.GL10;

public class Figura8 {
    private float posx;
    private float posy;
    private float tamaño;
    private Circulo orejaizq;
    private Circulo orejader;
    private Circulo cabeza;
    private Circulo cabezaborde;
    private Circulo ojoborde1;
    private Circulo ojoborde2;
    private Circulo ojo1;
    private Circulo ojo2;
    private Circulo ojobrillo1;
    private Circulo ojobrillo2;
    private Circulo hocico;
    private Circulo boca;
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

    public Figura8(float posx, float posy,float tamaño){

        this.posx=posx;
        this.posy=posy;
        this.tamaño=tamaño;
        modtamaño();
        fondo=new Rectangulo(verticescuadrado);
        orejaizq=new Circulo(tamaño*0.4f,tamaño*0.4f,360, true,0, 360,(-0.7f*tamaño+posx),(0.7f*tamaño+posy),  0, 0, 0);
        orejader=new Circulo(tamaño*0.4f,tamaño*0.4f,360, true,0, 360,(+0.7f*tamaño+posx),(0.7f*tamaño+posy),  0, 0, 0);
        cabeza=new Circulo(tamaño*1.0f,tamaño*0.8f,360, true,0, 360,(0f*tamaño+posx),(0f*tamaño+posy),  255, 255, 255);
        cabezaborde=new Circulo(tamaño*1.0f,tamaño*0.8f,360, false,0, 360,(0f*tamaño+posx),(0f*tamaño+posy),  0, 0, 0);
        ojoborde1=new Circulo(tamaño*0.3f,tamaño*0.3f,360, true,0, 360,(-0.5f*tamaño+posx),(0.0f*tamaño+posy),  0, 0, 0);
        ojoborde2=new Circulo(tamaño*0.3f,tamaño*0.3f,360, true,0, 360,(0.5f*tamaño+posx),(0.0f*tamaño+posy),  0, 0, 0);
        ojo1=new Circulo(tamaño*0.15f,tamaño*0.15f,360, true,0, 360,(-0.4f*tamaño+posx),(0.1f*tamaño+posy),  255, 255, 255);
        ojo2=new Circulo(tamaño*0.15f,tamaño*0.15f,360, true,0, 360,(0.4f*tamaño+posx),(0.1f*tamaño+posy),  255, 255, 255);
        ojobrillo1=new Circulo(tamaño*0.1f,tamaño*0.1f,360, true,0, 360,(-0.6f*tamaño+posx),(-0.1f*tamaño+posy),  255, 255, 255);
        ojobrillo2=new Circulo(tamaño*0.1f,tamaño*0.1f,360, true,0, 360,(0.6f*tamaño+posx),(-0.1f*tamaño+posy),  255, 255, 255);
        hocico=new Circulo(tamaño*0.1f,tamaño*0.07f,360, true,0, 360,(0f*tamaño+posx),(-0.1f*tamaño+posy),  0, 0, 0);
        boca=new Circulo(tamaño*0.1f,tamaño*0.07f,180, false,-180, 180,(0f*tamaño+posx),(-0.2f*tamaño+posy),  0, 0, 0);

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
            System.out.println("Toco panda");
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
            orejaizq.dibuja(gl);
            orejader.dibuja(gl);
            cabeza.dibuja(gl);
            cabezaborde.dibuja(gl);
            ojoborde1.dibuja(gl);
            ojoborde2.dibuja(gl);
            ojo1.dibuja(gl);
            ojo2.dibuja(gl);
            ojobrillo1.dibuja(gl);
            ojobrillo2.dibuja(gl);
            hocico.dibuja(gl);
            boca.dibuja(gl);
        }
    }
}