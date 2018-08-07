package frsf.isi.died.app.InterfacesGraficasNuevo;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frsf.isi.died.tp.estructuras.Nodo;
import frsf.isi.died.tp.estructuras.TipoNodo;
import frsf.isi.died.tp.modelo.productos.MaterialCapacitacion;

public class BuscarArbolN extends JPanel{
	
	List<Nodo> condiciones = new ArrayList<>();
	
	public BuscarArbolN() {
		
	}
	
	public BuscarArbolN(Menu ventana, MaterialCapacitacion material) {
		
		this.setPreferredSize(new Dimension(800,600));
		this.setVisible(true);
		this.setLayout(null);
		
		
		
		JComboBox tipoN = new JComboBox(TipoNodo.values());
		tipoN.setBounds(20, 30, 180, 22);
		this.add(tipoN);
		JTextField valor = new JTextField();
		valor.setBounds(240, 30, 180, 22);
		this.add(valor);
		JButton agregarMas = new JButton("+");
		agregarMas.setBounds(425, 30, 50, 21);
		this.add(agregarMas);
		JButton borrarTodo = new JButton("Borrar todo");
		borrarTodo.setBounds(480, 30, 130, 22);
		this.add(borrarTodo);
		
		JButton atras = new JButton("Atras");
		
		JButton modificar = new JButton("Ir a agregar nodo");		
		atras.setBounds(620, 510, 150, 40);
		modificar.setBounds(450, 510, 150, 40);

		JButton buscar = new JButton("Buscar");		
		buscar.setBounds(280, 510, 150, 40);
		
		this.add(buscar);
		this.add(modificar);
		this.add(atras);
		
		
		atras.addActionListener(e->volverAtras(ventana));
		modificar.addActionListener(e->modificarMaterial(ventana,material));
		agregarMas.addActionListener(e->agregarALista(valor, tipoN.getSelectedItem(), valor.getText()));
		borrarTodo.addActionListener(e->limpiarLista());
	}
	
	private void limpiarLista() {
		condiciones.removeAll(condiciones);
	}

	private void agregarALista(JTextField valor, Object tipoN, String texto) {
		if(!texto.isEmpty()) {
			condiciones.add(new Nodo((TipoNodo)tipoN,texto));
			valor.setText(null);
		}
		else{
			JOptionPane vacio = new JOptionPane();
			vacio.showMessageDialog(this, "Debe ingresar un valor", "Campo vacio", vacio.ERROR_MESSAGE);
		}
	}
	
	public void volverAtras(Menu ventana) {
		ventana.setContentPane(new BuscarMaterial(ventana));
		ventana.pack();
	}
	
	public void modificarMaterial(Menu ventana, MaterialCapacitacion material) {
		ventana.setContentPane(new AgregarNodoArbol(ventana,material));
		ventana.pack();
	}

}
