package com.example.interaccion;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.Collections;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Renderiza extends GLSurfaceView implements Renderer {
    private int alto;
    private int ancho;
    private Circulo reiniciar;
    private boolean intento1=true;
    private int contadorcorrectos=0;
    Context contexto;
    Figura1 muñeconieve1;
    Figura2 racimouvas1;
    Figura3 helado1;
    Figura4 chocolate1;
    Figura5 emoji1;
    Figura6 oso1;
    Figura7 flor1;
    Figura8 panda1;
    Figura9 pacman1;
    Figura10 android1;
    Figura1 muñeconieve2;
    Figura2 racimouvas2;
    Figura3 helado2;
    Figura4 chocolate2;
    Figura5 emoji2;
    Figura6 oso2;
    Figura7 flor2;
    Figura8 panda2;
    Figura9 pacman2;
    Figura10 android2;
    int jugada1=0;
    int jugada2=0;
    int jugadaactual=0;
    int posfigura1=0;
    int posfigura2=0;
    int posfiguraactual=0;

    private LinkedList<Coordenadas>orden;
    public Renderiza(Context contexto) {
        super(contexto);
        this.contexto = contexto;
        this.setRenderer(this);
        this.requestFocus();
        this.setFocusableInTouchMode(true);
        this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    public Renderiza(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
        iniciar();
        gl.glClearColor(139/255f, 137/255f, 142/255f, 0);
    }
    public void iniciar(){
        orden=new LinkedList<Coordenadas>();
        orden.add(new Coordenadas(-3,5));
        orden.add(new Coordenadas(-1,5));
        orden.add(new Coordenadas(1,5));
        orden.add(new Coordenadas(3,5));
        orden.add(new Coordenadas(-1,3));
        orden.add(new Coordenadas(-3,3));
        orden.add(new Coordenadas(1,3));
        orden.add(new Coordenadas(3,3));
        orden.add(new Coordenadas(-3,1));
        orden.add(new Coordenadas(-1,1));
        orden.add(new Coordenadas(1,1));
        orden.add(new Coordenadas(3,1));
        orden.add(new Coordenadas(-3,-1));
        orden.add(new Coordenadas(-1,-1));
        orden.add(new Coordenadas(1,-1));
        orden.add(new Coordenadas(3,-1));
        orden.add(new Coordenadas(-1,-3));
        orden.add(new Coordenadas(-3,-3));
        orden.add(new Coordenadas(1,-3));
        orden.add(new Coordenadas(3,-3));

        Collections.shuffle(orden);
        reiniciar=new Circulo(0.5f,0.5f,360,true,0,360,0,-5f,253,49,25);
        muñeconieve1=new Figura1(orden.get(0).getCoorx(),orden.get(0).getCoory(),0.7f);
        racimouvas1=new Figura2(orden.get(1).getCoorx(),orden.get(1).getCoory(),0.8f);
        helado1=new Figura3(orden.get(2).getCoorx(),orden.get(2).getCoory(),0.7f);
        chocolate1=new Figura4(orden.get(3).getCoorx(),orden.get(3).getCoory(),1);
        emoji1=new Figura5(orden.get(4).getCoorx(),orden.get(4).getCoory(),0.7f);
        oso1=new Figura6(orden.get(5).getCoorx(),orden.get(5).getCoory(),0.7f);
        flor1=new Figura7(orden.get(6).getCoorx(),orden.get(6).getCoory(),0.8f);
        panda1=new Figura8(orden.get(7).getCoorx(),orden.get(7).getCoory(),0.6f);
        pacman1=new Figura9(orden.get(8).getCoorx(),orden.get(8).getCoory(),0.5f);
        android1=new Figura10(orden.get(9).getCoorx(),orden.get(9).getCoory(),0.7f);
        muñeconieve2=new Figura1(orden.get(10).getCoorx(),orden.get(10).getCoory(),0.7f);
        racimouvas2=new Figura2(orden.get(11).getCoorx(),orden.get(11).getCoory(),0.8f);
        helado2=new Figura3(orden.get(12).getCoorx(),orden.get(12).getCoory(),0.7f);
        chocolate2=new Figura4(orden.get(13).getCoorx(),orden.get(13).getCoory(),1);
        emoji2=new Figura5(orden.get(14).getCoorx(),orden.get(14).getCoory(),0.7f);
        oso2=new Figura6(orden.get(15).getCoorx(),orden.get(15).getCoory(),0.7f);
        flor2=new Figura7(orden.get(16).getCoorx(),orden.get(16).getCoory(),0.8f);
        panda2=new Figura8(orden.get(17).getCoorx(),orden.get(17).getCoory(),0.6f);
        pacman2=new Figura9(orden.get(18).getCoorx(),orden.get(18).getCoory(),0.5f);
        android2=new Figura10(orden.get(19).getCoorx(),orden.get(19).getCoory(),0.7f);
    }
    @Override

    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();
        if(contadorcorrectos>=10){
            reiniciar.dibuja(gl);
        }
        muñeconieve1.dibuja(gl);
        racimouvas1.dibuja(gl);
        helado1.dibuja(gl);
        chocolate1.dibuja(gl);
        emoji1.dibuja(gl);
        oso1.dibuja(gl);
        flor1.dibuja(gl);
        panda1.dibuja(gl);
        pacman1.dibuja(gl);
        android1.dibuja(gl);
        muñeconieve2.dibuja(gl);
        racimouvas2.dibuja(gl);
        helado2.dibuja(gl);
        chocolate2.dibuja(gl);
        emoji2.dibuja(gl);
        oso2.dibuja(gl);
        flor2.dibuja(gl);
        panda2.dibuja(gl);
        pacman2.dibuja(gl);
        android2.dibuja(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0,-4,0);
        gl.glPopMatrix();
    }
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        ancho = width;
        alto = height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluOrtho2D(gl, -4, 4, -6, 6);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float posx = e.getX();
        float posy = e.getY();
        /* Se considera cuando el dedo toca la pantalla. */
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            posx = (posx * 8/ ancho ) - 4;
            posy = (12 - posy *12/ alto) - 6;
            /* Adiciona un nuevo punto */
            String res =String.valueOf(ancho)+","+String.valueOf(alto);
            String s= String.valueOf(posx)+","+String.valueOf(posy);
            //Control de intentos
            jugadaactual=-1;
            //Toast.makeText(contexto.getApplicationContext(),res+"-"+s,Toast.LENGTH_SHORT).show();
            if(muñeconieve1.tocofigura(posx,posy)){
                jugadaactual=1;
                posfiguraactual=1;
            }
            if(racimouvas1.tocofigura(posx,posy)){
                jugadaactual=2;
                posfiguraactual=2;
            }
            if(helado1.tocofigura(posx,posy)){
                jugadaactual=3;
                posfiguraactual=3;
            }
            if(chocolate1.tocofigura(posx,posy)){
                jugadaactual=4;
                posfiguraactual=4;
            }
            if(emoji1.tocofigura(posx,posy)){
                jugadaactual=5;
                posfiguraactual=5;
            }
            if(oso1.tocofigura(posx,posy)){
                jugadaactual=6;
                posfiguraactual=6;
            }
            if(flor1.tocofigura(posx,posy)){
                jugadaactual=7;
                posfiguraactual=7;
            }
            if(panda1.tocofigura(posx,posy)){
                jugadaactual=8;
                posfiguraactual=8;
            }
            if(pacman1.tocofigura(posx,posy)){
                jugadaactual=9;
                posfiguraactual=9;
            }
            if(android1.tocofigura(posx,posy)){
                jugadaactual=10;
                posfiguraactual=10;
            }
            if(muñeconieve2.tocofigura(posx,posy)){
                jugadaactual=1;
                posfiguraactual=11;
            }
            if(racimouvas2.tocofigura(posx,posy)){
                jugadaactual=2;
                posfiguraactual=12;
            }
            if(helado2.tocofigura(posx,posy)){
                jugadaactual=3;
                posfiguraactual=13;
            }
            if(chocolate2.tocofigura(posx,posy)){
                jugadaactual=4;
                posfiguraactual=14;
            }
            if(emoji2.tocofigura(posx,posy)){
                jugadaactual=5;
                posfiguraactual=15;
            }
            if(oso2.tocofigura(posx,posy)){
                jugadaactual=6;
                posfiguraactual=16;
            }
            if(flor2.tocofigura(posx,posy)){
                jugadaactual=7;
                posfiguraactual=17;
            }
            if(panda2.tocofigura(posx,posy)){
                jugadaactual=8;
                posfiguraactual=18;
            }
            if(pacman2.tocofigura(posx,posy)){
                jugadaactual=9;
                posfiguraactual=19;
            }
            if(android2.tocofigura(posx,posy)){
                jugadaactual=10;
                posfiguraactual=20;
            }
            requestRender(); // Llama por defecto
            if(jugadaactual!=-1  ){
                System.out.println("llegue aqui1 jugada1="+jugada1+" jugada actual="+jugadaactual);
                System.out.println("intento1="+intento1);
                if(intento1){
                    intento1=false;
                    jugada1=jugadaactual;
                    posfigura1=posfiguraactual;
                    System.out.println("intento1");
                }else {
                    intento1=true;
                    System.out.println("llegue aqui2.1");
                    jugada2=jugadaactual;
                    posfigura2=posfiguraactual;
                    System.out.println("intento2");
                    if(jugada1==jugada2){
                        System.out.println("Figuras iguales");
                        contadorcorrectos++;
                    }else{
                        SystemClock.sleep(1000);
                        System.out.println("Figuras distintas");
                        //para posjugada1
                        switch(posfigura1) {
                            case 1:
                                muñeconieve1.setMostrarimg(false);
                                break;
                            case 2:
                                racimouvas1.setMostrarimg(false);
                                break;
                            case 3:
                                helado1.setMostrarimg(false);
                                break;
                            case 4:
                                chocolate1.setMostrarimg(false);
                                break;
                            case 5:
                                emoji1.setMostrarimg(false);
                                break;
                            case 6:
                                oso1.setMostrarimg(false);
                                break;
                            case 7:
                                flor1.setMostrarimg(false);
                                break;
                            case 8:
                                panda1.setMostrarimg(false);
                                break;
                            case 9:
                                pacman1.setMostrarimg(false);
                                break;
                            case 10:
                                android1.setMostrarimg(false);
                                break;
                            case 11:
                                muñeconieve2.setMostrarimg(false);
                                break;
                            case 12:
                                racimouvas2.setMostrarimg(false);
                                break;
                            case 13:
                                helado2.setMostrarimg(false);
                                break;
                            case 14:
                                chocolate2.setMostrarimg(false);
                                break;
                            case 15:
                                emoji2.setMostrarimg(false);
                                break;
                            case 16:
                                oso2.setMostrarimg(false);
                                break;
                            case 17:
                                flor2.setMostrarimg(false);
                                break;
                            case 18:
                                panda2.setMostrarimg(false);
                                break;
                            case 19:
                                pacman2.setMostrarimg(false);
                                break;
                            case 20:
                                android2.setMostrarimg(false);
                                break;
                        }
                        switch(posfigura2) {
                            case 1:
                                muñeconieve1.setMostrarimg(false);
                                break;
                            case 2:
                                racimouvas1.setMostrarimg(false);
                                break;
                            case 3:
                                helado1.setMostrarimg(false);
                                break;
                            case 4:
                                chocolate1.setMostrarimg(false);
                                break;
                            case 5:
                                emoji1.setMostrarimg(false);
                                break;
                            case 6:
                                oso1.setMostrarimg(false);
                                break;
                            case 7:
                                flor1.setMostrarimg(false);
                                break;
                            case 8:
                                panda1.setMostrarimg(false);
                                break;
                            case 9:
                                pacman1.setMostrarimg(false);
                                break;
                            case 10:
                                android1.setMostrarimg(false);
                                break;
                            case 11:
                                muñeconieve2.setMostrarimg(false);
                                break;
                            case 12:
                                racimouvas2.setMostrarimg(false);
                                break;
                            case 13:
                                helado2.setMostrarimg(false);
                                break;
                            case 14:
                                chocolate2.setMostrarimg(false);
                                break;
                            case 15:
                                emoji2.setMostrarimg(false);
                                break;
                            case 16:
                                oso2.setMostrarimg(false);
                                break;
                            case 17:
                                flor2.setMostrarimg(false);
                                break;
                            case 18:
                                panda2.setMostrarimg(false);
                                break;
                            case 19:
                                pacman2.setMostrarimg(false);
                                break;
                            case 20:
                                android2.setMostrarimg(false);
                                break;
                        }
                        requestRender(); // Llama por defecto
                    }
                }
            }
            if(puntoEstaDentroDelCirculo(posx,posy,0,-5,0.5f)&& contadorcorrectos>=10){
                iniciar();
                contadorcorrectos=0;
                requestRender(); // Llama por defecto
            }
        }
        return true;
    }

    private boolean puntoEstaDentroDelRectangulo(float posx, float posy, int x, int y, int ancho, int alto) {
        return (x < posx && posx < x + ancho && y < posy && posy < y + alto);
    }
    private boolean puntoEstaDentroDelCirculo(float posx, float posy, float x, float y, float radio) {
        return (distancia2(posx, posy, x, y) < radio * radio);
    }
    public float distancia2(float x1, float y1, float x2, float y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}