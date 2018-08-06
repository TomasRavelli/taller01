/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.app.grafo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import frsf.isi.died.app.controller.GrafoController;
import frsf.isi.died.tp.estructuras.Arista;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

/**
 *
 * @author martdominguez
 */
public class GrafoPanel extends JPanel {

    private JFrame framePadre;
    private GrafoController controller;
    private Color[] coloresVertices = {Color.RED,Color.GREEN} ; 
    private List<VerticeView> vertices;
    private List<AristaView> aristas;
    Boolean flag;
    private AristaView auxiliar;

    public GrafoPanel() {
        this.framePadre = (JFrame) this.getParent();
        this.vertices = new ArrayList<>();
        this.aristas = new ArrayList<>();
        flag = true;

        
      addMouseListener(new MouseAdapter() {
    	  public void mouseClicked(MouseEvent event) {
               if (event.getClickCount() == 2 && !event.isConsumed() && flag) {
              	event.consume();
                   Random x = new Random();
                                         
                    Object[] mats = controller.listaVertices().toArray();
                    //String text = JOptionPane.showInputDialog(, "ID del nodo");
                    for(int i = 0; i<mats.length; i++) {
                        Integer posX = new Integer((int) (x.nextDouble()*300+100));
                        Integer posY = new Integer((int) (x.nextDouble()*300+20));
                    /*Object verticeMatSeleccionado= (MaterialCapacitacion) JOptionPane.showInputDialog(framePadre, 
                            "Que material corresponde con el vertice?",
                            "Agregar Vertice",
                            JOptionPane.QUESTION_MESSAGE, 
                            null, 
                            mats, 
                            mats[0]);
                    */

                   // if (verticeMatSeleccionado != null) {
                    	if(((MaterialCapacitacion)mats[i]).esLibro()) {
                    		 Color aux = coloresVertices[0];  
                             controller.crearVertice(posX, posY, aux,(MaterialCapacitacion) mats[i]);
                    	}
                    	else {
                    		 Color aux = coloresVertices[1];
                             controller.crearVertice(posX, posY, aux,(MaterialCapacitacion) mats[i]);
                    	}
                    
                 }
                    for(int i = 0; i<mats.length; i++) {
                    
                    }
                    flag = false;
               //     }
             } 
        }
            public void mouseReleased(MouseEvent event) {
                VerticeView vDestino = clicEnUnNodo(event.getPoint());
                if (auxiliar!=null && vDestino != null) {
                    auxiliar.setDestino(vDestino);
                    controller.crearArista(auxiliar);
                    auxiliar = null;
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent event) {
                VerticeView vOrigen = clicEnUnNodo(event.getPoint());
                if (auxiliar==null && vOrigen != null) {
                    auxiliar = new AristaView();                    
                    auxiliar.setOrigen(vOrigen);
                }
            }
        });
    }

    
    public void agregar(AristaView arista){
    	if(!this.aristas.contains(arista)) {
        this.aristas.add(arista);
    	}
    }    
    
    public void agregar(VerticeView vert){
        this.vertices.add(vert);
    }

    public void caminoPintar(List<MaterialCapacitacion> camino){
        //this.vertices.add(vert);
    	if(camino.size()>1 || camino.size()>0) {
    	Integer idOrigen =-1;
    	Integer idDestino =-1;
    	for(MaterialCapacitacion mat : camino) {
    		if(idOrigen<0) {
    			idOrigen=mat.getId();
    		}else {
    			idDestino = mat.getId();
    			for(AristaView av : this.aristas) {
    				if(av.getOrigen().getId().equals(idOrigen) && av.getDestino().getId().equals(idDestino) ) {
    	    			av.setColor(Color.BLACK);
    	    			av.getOrigen().setColor(Color.BLACK);
    	    			av.getDestino().setColor(Color.BLACK);
    				}
    			}
    			idOrigen = idDestino;
    		}
    	}
    }
    }
    
    private void dibujarVertices(Graphics2D g2d) {
        for (VerticeView v : this.vertices) {
            g2d.setPaint(Color.BLUE);
            g2d.drawString(v.etiqueta(),v.getCoordenadaX()-5,v.getCoordenadaY()-5);
            g2d.setPaint(v.getColor());
            g2d.fill(v.getNodo());
        }
    }

    private void dibujarAristas(Graphics2D g2d) {
        //System.out.println(this.aristas);
        for (AristaView a : this.aristas) {
            g2d.setPaint(a.getColor());
            g2d.setStroke ( a.getFormatoLinea());
            g2d.draw(a.getLinea());
            //dibujo una flecha al final
            // con el color del origen para que se note
            g2d.setPaint(Color.BLACK);
            Polygon flecha = new Polygon();  
            flecha.addPoint(a.getDestino().getCoordenadaX(), a.getDestino().getCoordenadaY()+7);
            flecha.addPoint(a.getDestino().getCoordenadaX()+20, a.getDestino().getCoordenadaY()+10);
            flecha.addPoint(a.getDestino().getCoordenadaX(), a.getDestino().getCoordenadaY()+18);
            g2d.fillPolygon(flecha);
        }
    }

    private VerticeView clicEnUnNodo(Point p) {
        for (VerticeView v : this.vertices) {
            if (v.getNodo().contains(p)) {
                return v;
            }
        }
        return null;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        dibujarVertices(g2d);
        dibujarAristas(g2d);
    }

    public Dimension getPreferredSize() {
        return new Dimension(450, 400);
    }

    public GrafoController getController() {
        return controller;
    }

    public void setController(GrafoController controller) {
        this.controller = controller;
    }
}