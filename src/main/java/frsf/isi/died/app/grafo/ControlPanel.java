/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frsf.isi.died.app.grafo;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import frsf.isi.died.app.InterfacesGraficasNuevo.Menu;
import frsf.isi.died.app.InterfacesGraficasNuevo.MuestraResultados;
import frsf.isi.died.app.controller.GrafoController;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;
/**
 *
 * @author mdominguez
 */
public class ControlPanel extends JPanel {
    
    private JComboBox<MaterialCapacitacion> cmbVertice1; 
    private JComboBox<MaterialCapacitacion> cmbVertice2; 
    private JTextField txtLongitudCamino; 
    private JButton btnBuscarCamino;
    private JButton volver;
    private GrafoController controller;
    private List<MaterialCapacitacion> listaVertices;
        
    public void armarPanel( List<MaterialCapacitacion> listaVertices,Menu ventana, List<MaterialCapacitacion> encontrados){
    	this.listaVertices = listaVertices;
    	this.cmbVertice1 = new JComboBox(listaVertices.toArray()); 
        this.cmbVertice2 = new JComboBox(listaVertices.toArray()); 
        this.txtLongitudCamino = new JTextField(5); 
        this.btnBuscarCamino = new JButton("Buscar Camino");
        this.btnBuscarCamino.addActionListener(
                e -> { 
                	if(! txtLongitudCamino.getText().isEmpty()) {
                    Integer n =Integer.parseInt(txtLongitudCamino.getText());
                    Integer idOrigen = this.listaVertices.get(cmbVertice1.getSelectedIndex()).getId();
                    Integer idDestino= this.listaVertices.get(cmbVertice2.getSelectedIndex()).getId();
                    controller.buscarCamino(idOrigen,idDestino,n); }
                	else {
                		Integer idOrigen = this.listaVertices.get(cmbVertice1.getSelectedIndex()).getId();
                        Integer idDestino= this.listaVertices.get(cmbVertice2.getSelectedIndex()).getId();
                        controller.buscarCamino(idOrigen,idDestino);
                	}
                }
        );
        this.volver = new JButton("Volver");
        this.volver.addActionListener( e -> { 
                    ventana.setContentPane(new MuestraResultados(ventana, encontrados));
                    ventana.pack();
                });
       
        
        this.add(new JLabel("Vertice Origen"));        
    	this.add(cmbVertice1);
    	this.add(new JLabel("Vertice Destino"));
    	this.add(cmbVertice2);
    	this.add(new JLabel("Cantidad de saltos"));        
    	this.add(txtLongitudCamino);        
    	this.add(btnBuscarCamino);    
        this.add(volver);    
    }

    public GrafoController getController() {
        return controller;
    }

    public void setController(GrafoController controller) {
        this.controller = controller;
    }
}