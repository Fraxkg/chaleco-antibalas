import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCama extends JPanel{
	
	private int posY=10;
	private JComboBox<String> cbHospital;
	private JLabel lblSelectHospital;
	
	private JButton btnAgregar,btnCancelar, btnEditar, btnGuardarE, btnEliminar;
	private JTextField txtNumero, txtENumero;
	private JLabel lblNumero, lblSeleccionarEd, lblENumero, lblArea, lblAgregar, lblEditar, lblSeleccionarEl, lblEliminar;
	private JComboBox<String> cbArea, cbEdArea, cbElArea;
	
	public PanelCama(){
		this.setLayout(null);
		this.setSize(1200,700);
		
		
		lblSelectHospital = new JLabel("Seleccionar hospital:");
		lblSelectHospital.setBounds(10,posY,150,30);
		
		cbHospital = new JComboBox<>();
		cbHospital.setBounds(150, posY, 300,30);
		cbHospital.addItem("Seleccionar hospital --");
		
		posY+=40;
		
		//AGREGAR CAMAS
		lblAgregar =  new JLabel("Agregar camas");
		lblAgregar.setBounds(10,posY,200,30);
		
		posY+=40;
		
		lblNumero = new JLabel("Numero de camas:");
		lblNumero.setBounds(10,posY,150,30);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(160, posY, 150, 30);
		
		lblArea = new JLabel("Área:");
		lblArea.setBounds(320,posY,50,30);
		
		cbArea = new JComboBox<>();
		cbArea.setBounds(380,posY,300,30);
		cbArea.addItem("Seleccionar área --");
		
		posY+=40;
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10,posY,100,30);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(120,posY,100,30);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblSelectHospital);
		this.add(cbHospital);
		this.add(lblAgregar);
		this.add(lblNumero);
		this.add(txtNumero);
		this.add(lblArea);
		this.add(cbArea);
		this.add(btnAgregar);
		this.add(btnCancelar);
		
		//EDITAR CAMAS
		
		posY+=60;
		
		lblEditar = new JLabel("Editar numero de camas");
		lblEditar.setBounds(10, posY,150,30);
		
		posY+=40;
		
		lblSeleccionarEd = new JLabel("Seleccionar Área:");
		lblSeleccionarEd.setBounds(10,posY,200,30);
		
		cbEdArea = new JComboBox<>();
		cbEdArea.setBounds(140,posY,240,30);
		cbEdArea.addItem("Seleccionar área --");
		
		btnEditar =  new JButton("Editar");
		btnEditar.setBounds(390,posY,100,30);
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		posY+=40;
		
		lblENumero = new JLabel("Numero:");
		lblENumero.setBounds(10,posY,100,30);
		
		txtENumero = new JTextField();
		txtENumero.setBounds(140,posY,50,30);
		
		btnGuardarE = new JButton("Guardar Edición");
		btnGuardarE.setBounds(200,posY,150,30);
		btnGuardarE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblEditar);
		this.add(lblSeleccionarEd);
		this.add(cbEdArea);
		this.add(btnEditar);
		this.add(lblENumero);
		this.add(txtENumero);
		this.add(btnGuardarE);
		
		//ELIMINAR CAMAS
		
		posY+=60;
		
		lblEliminar = new JLabel("Eliminar camas");
		lblEliminar.setBounds(10,posY,100,30);
		
		posY+=40;
		
		lblSeleccionarEl= new JLabel("Seleccionar Área:");
		lblSeleccionarEl.setBounds(10,posY,200,30);
		
		cbElArea = new JComboBox<>();
		cbElArea.setBounds(150,posY,200,30);
		cbElArea.addItem("Seleccionar área --");
		
		posY+=40;
		
		btnEliminar= new JButton("Eliminar");
		btnEliminar.setBounds(150,posY,150,30);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblEliminar);
		this.add(lblSeleccionarEl);
		this.add(cbElArea);
		this.add(btnEliminar);
	}
}
