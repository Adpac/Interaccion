package com.example.interaccion;
import javax.microedition.khronos.opengles.GL10;
public class Figura9 {

    private float posx;
    private float posy;
    private float tamaño;
    private Circulo cuerpo1;
    private Circulo cuerpo2;
    private Circulo borde1;
    private Circulo borde2;
    private Circulo ojo;
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

    public Figura9(float posx, float posy,float tamaño){
        this.posx=posx;
        this.posy=posy;
        this.tamaño=tamaño;
        modtamaño();
        fondo=new Rectangulo(verticescuadrado);
        cuerpo1=new Circulo(tamaño*1.0f,tamaño*1f,100, true,-310, 165,(0f*tamaño+posx),(0f*tamaño+posy),  254, 254, 0);
        cuerpo2=new Circulo(tamaño*1.0f,tamaño*1f,140, true,-190, 155,(0f*tamaño+posx),(0f*tamaño+posy),  254, 254, 0);
        borde1=new Circulo(tamaño*1.0f,tamaño*1f,100, false,-310, 165,(0f*tamaño+posx),(0f*tamaño+posy),  8, 6, 13);
        borde2=new Circulo(tamaño*1.0f,tamaño*1f,130, false,-180, 150,(0f*tamaño+posx),(0f*tamaño+posy),  8, 6, 13);
        ojo=new Circulo(tamaño*0.1f,tamaño*0.1f,250, true,0, 360,(-0.1f*tamaño+posx),(0.5f*tamaño+posy),  8, 6, 13);
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
            cuerpo2.dibuja(gl);
            borde2.dibuja(gl);
            cuerpo1.dibuja(gl);
            borde1.dibuja(gl);
            ojo.dibuja(gl);
        }
    }
}