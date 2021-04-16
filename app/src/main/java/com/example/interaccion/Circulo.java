package com.example.interaccion;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
public class Circulo {
    private FloatBuffer bufVertices;
    private int segmentos;
    private boolean llenado;
    private float R;
    private float G;
    private float B;
    private float Gradosmin;
    private Float Gradosmax;
    public Circulo(float radiox, float radioy, int segmentos, boolean llenado, float gradomin, float gradosmax, float posx, float posy, float R, float G, float B) {
        this.R=R/255;
        this.G=G/255;
        this.B=B/255;
        this.segmentos = segmentos;
        this.llenado = llenado;
        this.Gradosmax=gradosmax;
        this.Gradosmin=gradomin;
        ByteBuffer bufByte = ByteBuffer.allocateDirect(360 * 2 * 4);
        bufByte.order(ByteOrder.nativeOrder());
        bufVertices = bufByte.asFloatBuffer();
        int j = 0;
        for (float i = Gradosmin; i < Gradosmax; i = i + Gradosmax/segmentos) {
            bufVertices.put(j++, (float) Math.cos(Math.toRadians(i)) * radiox +posx); //ejex
            bufVertices.put(j++, (float) Math.sin(Math.toRadians(i)) * radioy +posy); //ejey
        }
        bufVertices.rewind();
    }

    public Circulo(float radio, int segmentos, boolean llenado) {
        R=1;
        G=1;
        B=0;
        this.segmentos = segmentos;
        this.llenado = llenado;
        ByteBuffer bufByte = ByteBuffer.allocateDirect(segmentos * 2 * 4);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden del byte nativo
        bufVertices = bufByte.asFloatBuffer();
        int j = 0;
        for (float i = 0; i < 360.0f; i = i + 360.0f/segmentos) {
            bufVertices.put(j++, (float) Math.cos(Math.toRadians(i)) * radio ); //ejex
            bufVertices.put(j++, (float) Math.sin(Math.toRadians(i)) * radio ); //ejey
        }
        bufVertices.rewind();
    }
    public void dibuja(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
        gl.glColor4f(R, G, B, 0);
        gl.glEnable(GL10.GL_LINE_SMOOTH);
        gl.glDrawArrays((llenado) ? GL10.GL_TRIANGLE_FAN : GL10.GL_LINE_STRIP, 0, segmentos);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}