package com.example.interaccion;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Figura2 {
    //figura de un racimo de uvas
    private float posx;
    private float posy;
    private float tamaño;
    private Circulo uva1;
    private Circulo uva2;
    private Circulo uva3;
    private Circulo uva4;
    private Circulo uva5;
    private Circulo uva6;
    private Circulo uva7;
    private Circulo uva8;
    private Circulo uva9;
    private Circulo uva10;
    private Circulo luva1;
    private Circulo luva2;
    private Circulo luva3;
    private Circulo luva4;
    private Circulo luva5;
    private Circulo luva6;
    private Circulo luva7;
    private Circulo luva8;
    private Circulo luva9;
    private Circulo luva10;
    private Rectangulo fondo;
    private boolean mostrarimg=false;
    private float verticescuadrado[]=new float[]{
            -0.8f,-0.8f,
            -0.8f,0.8f,
            0.8f,-0.8f,
            0.8f,0.8f,
    };

    private float vertices[] = new float[] {
            (0.5f), (0.0f), // 0
            (0.3f), (0.0f), // 1
            (0.5f), (0.6f), // 2
            (0.3f), (0.6f), // 1
    };
    public void modtamaño(){
        for (int i=0; i<vertices.length; i++){
            if(i%2==0){
                vertices[i]=(vertices[i]*tamaño+posx-0.3f);
            }else {
                vertices[i]=(vertices[i]*tamaño+posy+0.2f);
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
    public boolean isMostrarimg() {
        return mostrarimg;
    }
    public void setMostrarimg(boolean mostrarimg) {
        this.mostrarimg = mostrarimg;
    }
    private float colores[] = new float[] {
            124/255f, 76/255f, 60/255f, 1, // 0
            124/255f, 76/255f, 60/255f, 1, // 0
            124/255f, 76/255f, 60/255f, 1, // 0
            124/255f, 76/255f, 60/255f, 1, // 0
    };

    private short indices[] = new short [] {
            0,1,2,1,2,3
    };
    FloatBuffer bufVertices;
    FloatBuffer bufColores;
    ShortBuffer bufIndices;
    public Figura2(float posx, float posy,float tamaño){
        this.posx=posx;
        this.posy=posy;
        this.tamaño=tamaño;
        modtamaño();
        ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
        bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
        bufVertices.put(vertices);
        bufVertices.rewind();
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
        uva1=new Circulo(tamaño*0.25f,tamaño*0.25f,360, true,0, 360,(0f*tamaño+posx-0.3f),(0f*tamaño+posy+0.2f), 162,25,116);
        uva2=new Circulo(tamaño*0.25f,tamaño*0.25f,360, true,0, 360,(0.25f*tamaño+posx-0.3f),(0f*tamaño+posy+0.2f), 162,25,116);
        uva3=new Circulo(tamaño*0.25f,tamaño*0.25f,360, true,0, 360,(0.5f*tamaño+posx-0.3f),(0f*tamaño+posy+0.2f), 162,25,116);
        uva4=new Circulo(tamaño*0.25f,tamaño*0.25f,360, true,0, 360,(0.75f*tamaño+posx-0.3f),(0f*tamaño+posy+0.2f), 162,25,116);
        uva5=new Circulo(tamaño*0.25f,tamaño*0.25f,360, true,0, 360,(0.125f*tamaño+posx-0.3f),(-0.25f*tamaño+posy+0.2f), 162,25,116);
        uva6=new Circulo(tamaño*0.25f,tamaño*0.25f,360, true,0, 360,(0.375f*tamaño+posx-0.3f),(-0.25f*tamaño+posy+0.2f), 162,25,116);
        uva7=new Circulo(tamaño*0.25f,tamaño*0.25f,360, true,0, 360,(0.625f*tamaño+posx-0.3f),(-0.25f*tamaño+posy+0.2f), 162,25,116);
        uva8=new Circulo(tamaño*0.25f,tamaño*0.25f,360, true,0, 360,(0.25f*tamaño+posx-0.3f),(-0.5f*tamaño+posy+0.2f), 162,25,116);
        uva9=new Circulo(tamaño*0.25f,tamaño*0.25f,360, true,0, 360,(0.5f*tamaño+posx-0.3f),(-0.5f*tamaño+posy+0.2f), 162,25,116);
        uva10=new Circulo(tamaño*0.25f,tamaño*0.25f,360, true,0, 360,(0.375f*tamaño+posx-0.3f),(-0.75f*tamaño+posy+0.2f), 162,25,116);
        luva1=new Circulo(tamaño*0.25f,tamaño*0.25f,360, false,0, 360,(0f*tamaño+posx-0.3f),(0f*tamaño+posy+0.2f), 0,0,0);
        luva2=new Circulo(tamaño*0.25f,tamaño*0.25f,360, false,0, 360,(0.25f*tamaño+posx-0.3f),(0f*tamaño+posy+0.2f), 0,0,0);
        luva3=new Circulo(tamaño*0.25f,tamaño*0.25f,360, false,0, 360,(0.5f*tamaño+posx-0.3f),(0f*tamaño+posy+0.2f), 0,0,0);
        luva4=new Circulo(tamaño*0.25f,tamaño*0.25f,360, false,0, 360,(0.75f*tamaño+posx-0.3f),(0f*tamaño+posy+0.2f), 0,0,0);
        luva5=new Circulo(tamaño*0.25f,tamaño*0.25f,360, false,0, 360,(0.125f*tamaño+posx-0.3f),(-0.25f*tamaño+posy+0.2f), 0,0,0);
        luva6=new Circulo(tamaño*0.25f,tamaño*0.25f,360, false,0, 360,(0.375f*tamaño+posx-0.3f),(-0.25f*tamaño+posy+0.2f), 0,0,0);
        luva7=new Circulo(tamaño*0.25f,tamaño*0.25f,360, false,0, 360,(0.625f*tamaño+posx-0.3f),(-0.25f*tamaño+posy+0.2f), 0,0,0);
        luva8=new Circulo(tamaño*0.25f,tamaño*0.25f,360, false,0, 360,(0.25f*tamaño+posx-0.3f),(-0.5f*tamaño+posy+0.2f), 0,0,0);
        luva9=new Circulo(tamaño*0.25f,tamaño*0.25f,360, false,0, 360,(0.5f*tamaño+posx-0.3f),(-0.5f*tamaño+posy+0.2f), 0,0,0);
        luva10=new Circulo(tamaño*0.25f,tamaño*0.25f,360, false,0, 360,(0.375f*tamaño+posx-0.3f),(-0.75f*tamaño+posy+0.2f), 0,0,0);
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
    public void dibuja(GL10 gl) {
        fondo.dibuja(gl);
        if(mostrarimg){
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
            gl.glColorPointer(4, GL10.GL_FLOAT, 0, bufColores);
            gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
                    GL10.GL_UNSIGNED_SHORT, bufIndices);
            gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
            uva10.dibuja(gl);
            luva10.dibuja(gl);
            uva8.dibuja(gl);
            luva8.dibuja(gl);
            uva9.dibuja(gl);
            luva9.dibuja(gl);
            uva5.dibuja(gl);
            luva5.dibuja(gl);
            uva7.dibuja(gl);
            luva7.dibuja(gl);
            uva6.dibuja(gl);
            luva6.dibuja(gl);
            uva1.dibuja(gl);
            luva1.dibuja(gl);
            uva4.dibuja(gl);
            luva4.dibuja(gl);
            uva2.dibuja(gl);
            luva2.dibuja(gl);
            uva3.dibuja(gl);
            luva3.dibuja(gl);
        }
    }
}
