package frsf.isi.died.app.interfacesGraficas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class BorrarLibro2 {
	
	public BorrarLibro2(){
		JFrame crearL = new JFrame("Actualizar Libro");
		crearL.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		crearL.pack();
		crearL.setSize(800,600);
		crearL.setVisible(true);
		JPanel panel = new JPanel();
		crearL.setContentPane(panel);
		panel.setLayout(new GridBagLayout());
		
		JLabel lblTitulo;
		JTextField txtTitulo;
		JLabel lblCosto;
		JLabel lblPrecioCompra;
		JLabel lblPaginas;
		JTextField txtCosto;
		JTextField txtPrecioCompra;
		JTextField txtPaginas;
		JButton btnEliminar;
		JButton btnCancelar;
		
		GridBagConstraints gridConst= new GridBagConstraints();
		
		lblTitulo = new JLabel("Titulo: ");
		gridConst.gridx=0;
		gridConst.gridy=0;
		panel.add(lblTitulo, gridConst);
		
		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setColumns(20);
		gridConst.gridx=1;
		gridConst.gridwidth=5;
		panel.add(txtTitulo, gridConst);
		
		lblCosto= new JLabel("Costo: ");		
		gridConst.gridx=0;
		gridConst.gridy=1;
		gridConst.weightx=0.0;
		panel.add(lblCosto, gridConst);
		
		txtCosto = new JTextField();
		txtCosto.setEditable(false);
		txtCosto.setColumns(5);
		gridConst.gridx=1;
		panel.add(txtCosto, gridConst);
		
		lblPrecioCompra= new JLabel("Precio Compra: ");
		gridConst.gridx=0;
		gridConst.gridy=2;
		panel.add(lblPrecioCompra, gridConst);
		
		txtPrecioCompra = new JTextField();
		txtPrecioCompra.setEditable(false);
		txtPrecioCompra.setColumns(5);
		gridConst.gridx=3;
		panel.add(txtPrecioCompra, gridConst);
		
		lblPaginas= new JLabel("Paginas: ");		
		gridConst.gridx=0;
		gridConst.gridy=3;
		panel.add(lblPaginas, gridConst);
		
		txtPaginas = new JTextField();
		txtPaginas.setEditable(false);
		txtPaginas.setColumns(5);
		gridConst.gridx=1;
		panel.add(txtPaginas, gridConst);
		
		JLabel relevancia = new JLabel("Relevancia:");
		gridConst.gridx=0;
		gridConst.gridy=5;
		panel.add(relevancia,gridConst);
		
		JTextField relevancia2 = new JTextField();
		gridConst.gridx=1;
		relevancia2.setColumns(5);
		gridConst.gridy=5;
		relevancia2.setEditable(false);
		panel.add(relevancia2,gridConst);
		
		JLabel id = new JLabel("ID:");
		gridConst.gridx=0;
		gridConst.gridy=6;
		panel.add(id,gridConst);
		
		JTextField ID2 = new JTextField();
		ID2.setEditable(false);
		gridConst.gridx=1;
		ID2.setColumns(5);
		gridConst.gridy=6;
		panel.add(ID2,gridConst);
		
		
		btnEliminar = new JButton("Eliminar");
		gridConst.gridx=0;
		gridConst.gridy=7;
		panel.add(btnEliminar, gridConst);
		
		btnCancelar = new JButton("Cancelar");
		gridConst.gridx=1;
		gridConst.gridy=7;
		panel.add(btnCancelar, gridConst);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				BorrarLibro v1 = new BorrarLibro();
				crearL.dispose();
			}
		});
		
	}
	
	
}
