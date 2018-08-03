package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import frsf.isi.died.app.controller.GrafoController;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

public class MuestraNodos extends JPanel{
	
	 
    private JComboBox<MaterialCapacitacion> cmbVertice1; 
    private JComboBox<MaterialCapacitacion> cmbVertice2; 
    private JTextField txtLongitudCamino; 
    private JButton btnBuscarCamino; 
    //private GrafoController controller;
    private List<MaterialCapacitacion> listaVertices;
        
    //public void armarPanel(Menu ventana, List<MaterialCapacitacion> listaVertices){
    public  MuestraNodos (Menu ventana, List<MaterialCapacitacion> listaVertices){
    	this.listaVertices = listaVertices;
    	this.cmbVertice1 = new JComboBox(listaVertices.toArray()); 
        this.cmbVertice2 = new JComboBox(listaVertices.toArray()); 
        this.txtLongitudCamino = new JTextField(5); 
        this.btnBuscarCamino = new JButton("Buscar Camino");
       /* this.btnBuscarCamino.addActionListener(
                e -> { 
                    Integer n =Integer.parseInt(txtLongitudCamino.getText());
                    Integer idOrigen = this.listaVertices.get(cmbVertice1.getSelectedIndex()).getId();
                    Integer idDestino= this.listaVertices.get(cmbVertice2.getSelectedIndex()).getId();
                    controller.buscarCamino(idOrigen,idDestino,n); 
                }
        );*/
        this.add(new JLabel("Vertice Origen"));        
    	this.add(cmbVertice1);
    	this.add(new JLabel("Vertice Destino"));
    	this.add(cmbVertice2);
    	this.add(new JLabel("Cantidad de saltos"));        
    	this.add(txtLongitudCamino);        
    	this.add(btnBuscarCamino);        
    }

   /* public GrafoController getController() {
        return controller;
    }

    public void setController(GrafoController controller) {
        this.controller = controller;
    }
*/
	}


