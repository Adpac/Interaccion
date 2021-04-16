package com.example.interaccion;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Figura1 {

    private float posx;
    private float posy;
    private float tamaño;
    private Circulo cabeza;
    private Circulo cuerpo;
    private Circulo boton1;
    private Circulo boton2;
    private Rectangulo fondo;

    private boolean mostrarimg=false;

    private float verticescuadrado[]=new float[]{
            -0.8f,-0.8f,
            -0.8f,0.8f,
            0.8f,-0.8f,
            0.8f,0.8f,
    };
    private float vertices[] = new float[] {
            (-0.0f), (0.1f), // 0
            (0.6f), (0.0f), // 1
            (-0.0f), (-0.1f), // 2
    };

    public void modtamaño(){
        for (int i=0; i<vertices.length; i++){
            if(i%2==0){
                vertices[i]=(vertices[i]*tamaño+posx);
            }else {
                vertices[i]=(vertices[i]*tamaño+posy)+0.5f;
            }
        }
        for (int i=0; i<verticescuadrado.length; i++){
            if(i%2==0){
                verticescuadrado[i]=(verticescuadrado[i]+posx);
            }else {
                verticescuadrado[i]=(verticescuadrado[i]+posy);
            }
        }
    }

    private float colores[] = new float[] {
            180/255f, 50/255f, 10/255f, 1, // 0
            180/255f, 50/255f, 10/255f, 1, // 0
            180/255f, 50/255f, 10/255f, 1, // 0
            180/255f, 50/255f, 10/255f, 1, // 0
    };

    private short indices[] = new short [] {
            0,1,2,3
    };
    FloatBuffer bufVertices;
    FloatBuffer bufColores;
    ShortBuffer bufIndices;

    public Figura1(float posx, float posy,float tamaño){
        this.posx=posx;
        this.posy=posy;
        this.tamaño=tamaño;
        modtamaño();
        ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
        bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
        bufVertices.put(vertices);
        bufVertices.rewind(); // puntero al principio del buffer
        bufByte = ByteBuffer.allocateDirect(colores.length * 4);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
        bufColores = bufByte.asFloatBuffer(); // Convierte de byte a float
        bufColores.put(colores);
        bufColores.rewind();
        bufByte = ByteBuffer.allocateDirect(indices.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices.put(indices);
        bufIndices.rewind(); // puntero al principio del buffer
        fondo=new Rectangulo(verticescuadrado);
        cabeza=new Circulo(tamaño*0.35f,tamaño*0.35f,360, true,0, 360,(0f*tamaño+posx),(0f*tamaño+posy)+0.5f, 255,255,255);
        cuerpo=new Circulo(tamaño*0.5f,tamaño*0.7f,360, true,0, 360,(0f*tamaño+posx),(-1.0f*tamaño+posy)+0.5f, 255,255,255);
        boton1=new Circulo(tamaño*0.1f,tamaño*0.1f,360, true,0, 360,(0f*tamaño+posx),(-1.0f*tamaño+posy)+0.5f, 0,0,0);
        boton2=new Circulo(tamaño*0.1f,tamaño*0.1f,360, true,0, 360,(0f*tamaño+posx),(-1.25f*tamaño+posy)+0.5f, 0,0,0);
    }

    public boolean getMostrarimg() {
        return mostrarimg;
    }
    public void setMostrarimg(boolean mostrarimg) {
        this.mostrarimg = mostrarimg;
    }
    public void dibuja(GL10 gl) {
        fondo.dibuja(gl);
        if(mostrarimg){
            cabeza.dibuja(gl);
            cuerpo.dibuja(gl);
            boton1.dibuja(gl);
            boton2.dibuja(gl);
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
            gl.glColorPointer(4, GL10.GL_FLOAT, 0, bufColores);
            gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
                    GL10.GL_UNSIGNED_SHORT, bufIndices);
            gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        }
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
    private boolean puntoEstaDentroDelRectangulo(float posx, float posy, float x,
                                                 float y, float ancho, float alto) {
        return ((x < posx) && (posx < (x + ancho)) && (y < posy) && posy < y + alto);
    }
}
