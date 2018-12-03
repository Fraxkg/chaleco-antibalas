import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFarmacia extends JPanel{

	private int posY=10;
	private JButton btnAgregar,btnCancelar, btnEditar, btnGuardarE, btnEliminar;
	private JTextField txtNombre, txtENombre;
	private JLabel lblNombre, lblSeleccionarEd, lblENombre, lblHospital, lblEdHospital, lblAgregar, lblEditar, lblSeleccionarEl, lblEliminar;
	private JComboBox<String> cbHospital, cbEdFarmacia, cbElFarmacia,cbEdHospital;
	
	public PanelFarmacia(){
		this.setLayout(null);
		this.setSize(1200,700);
		
		
		lblHospital = new JLabel("Hospital:");
		lblHospital.setBounds(10,posY,50,30);
		
		cbHospital = new JComboBox<>();
		cbHospital.setBounds(70,posY,300,30);
		cbHospital.addItem("Seleccionar hospital --");
		
		posY+=40;
		
		//AGREGAR FARMACIA
		lblAgregar =  new JLabel("Agregar");
		lblAgregar.setBounds(10,posY,200,30);
		
		posY+=40;
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10,posY,150,30);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(80, posY, 230, 30);
		
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
		
		this.add(lblAgregar);
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(lblHospital);
		this.add(cbHospital);
		this.add(btnAgregar);
		this.add(btnCancelar);
		
		//EDITAR FARMACIA
		
		posY+=60;
		
		lblEditar = new JLabel("Editar");
		lblEditar.setBounds(10, posY,150,30);
		
		posY+=40;
		
		lblSeleccionarEd = new JLabel("Seleccionar Farmacia:");
		lblSeleccionarEd.setBounds(10,posY,200,30);
		
		cbEdFarmacia = new JComboBox<>();
		cbEdFarmacia.setBounds(140,posY,240,30);
		cbEdFarmacia.addItem("Seleccionar farmacia --");
		
		btnEditar =  new JButton("Editar");
		btnEditar.setBounds(390,posY,100,30);
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		posY+=40;
		
		lblENombre = new JLabel("Nombre:");
		lblENombre.setBounds(10,posY,100,30);
		
		txtENombre = new JTextField();
		txtENombre.setBounds(140,posY,240,30);
		
		lblEdHospital = new JLabel("Hospital:");
		lblEdHospital.setBounds(390,posY,150,30);
		
		cbEdHospital = new JComboBox<>();
		cbEdHospital.setBounds(445,posY,250,30);		
		cbEdHospital.addItem("Seleccionar hospital --");
		
		btnGuardarE = new JButton("Guardar Edición");
		btnGuardarE.setBounds(700,posY,150,30);
		btnGuardarE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblEditar);
		this.add(lblSeleccionarEd);
		this.add(cbEdFarmacia);
		this.add(btnEditar);
		this.add(lblENombre);
		this.add(txtENombre);
		this.add(lblEdHospital);
		this.add(cbEdHospital);
		this.add(btnGuardarE);
		
		//ELIMINAR FARMACIA
		
		posY+=60;
		
		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(10,posY,100,30);
		
		posY+=40;
		
		lblSeleccionarEl= new JLabel("Seleccionar Farmacia:");
		lblSeleccionarEl.setBounds(10,posY,200,30);
		
		cbElFarmacia = new JComboBox<>();
		cbElFarmacia.setBounds(160,posY,200,30);
		cbElFarmacia.addItem("Seleccionar farmacia --");
		
		btnEliminar= new JButton("Eliminar");
		btnEliminar.setBounds(370,posY,150,30);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblEliminar);
		this.add(lblSeleccionarEl);
		this.add(cbElFarmacia);
		this.add(btnEliminar);
	}

}
