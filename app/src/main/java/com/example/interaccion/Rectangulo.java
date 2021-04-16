package com.example.interaccion;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Rectangulo {
    private float vertices[] = new float[] {
            -3.5f,3.1999998f,
            -3.5f,4.7999997f,
            -1.9f,3.1999998f,
            -1.9f,4.7999997f
    };

    private float colores[] = new float[] {
            1, 0, 0, 0, // 0
            1, 0, 0, 0, // 1
            1, 0, 0, 0, // 2
            1, 0, 0, 0, // 3

    };

    private short indices[] = new short [] {
            0, 1, 2, 1, 2, 3,
    };
    FloatBuffer bufVertices;
    FloatBuffer bufColores;
    ShortBuffer bufIndices;

    public Rectangulo(){

        ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
        bufVertices.put(vertices);
        bufVertices.rewind(); // puntero al principio del buffer
       bufByte = ByteBuffer.allocateDirect(indices.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices.put(indices);
        bufIndices.rewind(); // puntero al principio del buffer
    }
    public Rectangulo(float[] verticesrec){

        /* Lee los vértices */
        ByteBuffer bufByte = ByteBuffer.allocateDirect(verticesrec.length * 4);
        bufByte.order(ByteOrder.nativeOrder());
        bufVertices = bufByte.asFloatBuffer();
        bufVertices.put(verticesrec);
        bufVertices.rewind();
        bufByte = ByteBuffer.allocateDirect(indices.length * 2);
        bufByte.order(ByteOrder.nativeOrder());
        bufIndices = bufByte.asShortBuffer();
        bufIndices.put(indices);
        bufIndices.rewind();
    }

    public void dibuja(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
        gl.glColor4f(50/255f, 57/255f, 83/255f, 0);
      gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
