import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInternado extends JPanel{

	private int posY=10;
	private JButton btnAgregar,btnCancelar, btnEditar, btnGuardarE, btnEliminar;
	private JLabel lblHospital, lblArea, lblCama, lblPaciente, lblSeleccionarEd, lblEdHospital, lblEdArea, lblEdCama, lblEdPaciente, lblAgregar, lblEditar, lblSeleccionarEl, lblEliminar;
	private JComboBox<String> cbHospital, cbArea, cbCama, cbPaciente, cbEditar, cbEdHospital,cbEdArea,cbEdCama,cbEdPaciente, cbEliminar;
	
	public PanelInternado(){
		this.setLayout(null);
		this.setSize(1200,700);
		
		
		lblHospital = new JLabel("Hospital:");
		lblHospital.setBounds(10,posY,70,30);
		
		cbHospital = new JComboBox<>();
		cbHospital.setBounds(80, posY, 230, 30);
		cbHospital.addItem("Seleccionar hospital --");
		
		posY+=40;
		
		//AGREGAR INTERNO
		lblAgregar =  new JLabel("Agregar Interno");
		lblAgregar.setBounds(10,posY,200,30);
		
		posY+=40;
			
		lblArea= new JLabel("Área:");
		lblArea.setBounds(10,posY,100,30);
	
		cbArea = new JComboBox<>();
		cbArea.setBounds(80,posY,200,30);
		cbArea.addItem("Seleccionar área --");
		
		lblCama= new JLabel("Cama:");
		lblCama.setBounds(290,posY,70,30);
		
		cbCama = new JComboBox<>();
		cbCama.setBounds(370,posY,150,30);
		cbCama.addItem("Seleccionar cama --");
		
		posY+=40;
		
		lblPaciente = new JLabel("Seleccioanr Paciente:");
		lblPaciente.setBounds(10,posY,150,30);
		
		cbPaciente = new JComboBox<>();
		cbPaciente.setBounds(160,posY,250,30);
		cbPaciente.addItem("Seleccionar paciente --");
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(420,posY,100,30);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(530,posY,100,30);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblAgregar);
		this.add(lblHospital);
		this.add(cbHospital);
		this.add(lblArea);
		this.add(cbArea);
		this.add(lblCama);
		this.add(cbCama);
		this.add(lblPaciente);
		this.add(cbPaciente);
		this.add(btnAgregar);
		this.add(btnCancelar);
		
		
		posY+=60;
		
		//EDITAR PACIENTE
		
		lblEditar = new JLabel("Editar");
		lblEditar.setBounds(10, posY,150,30);
		
		posY+=40;
		
		lblSeleccionarEd = new JLabel("Seleccionar Paciente:");
		lblSeleccionarEd.setBounds(10,posY,200,30);
		
		cbEditar = new JComboBox<>();
		cbEditar.setBounds(180,posY,200,30);
		cbEditar.addItem("Seleccionar paciente --");
		
		btnEditar =  new JButton("Editar");
		btnEditar.setBounds(390,posY,100,30);
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		posY+=40;
		
		lblEdArea = new JLabel("Área:");
		lblEdArea.setBounds(10,posY,100,30);
		
		cbEdArea = new JComboBox<>();
		cbEdArea.setBounds(70,posY,200,30);
		cbEdArea.addItem("Seleccionar área --");
		
		lblEdCama= new JLabel("Cama:");
		lblEdCama.setBounds(290,posY,70,30);
		
		cbEdCama = new JComboBox<>();
		cbEdCama.setBounds(370,posY,150,30);
		cbEdCama.addItem("Seleccionar cama --");
		
		posY+=40;
		
		lblEdPaciente = new JLabel("Seleccioanr Paciente:");
		lblEdPaciente.setBounds(10,posY,150,30);
		
		cbEdPaciente = new JComboBox<>();
		cbEdPaciente.setBounds(160,posY,250,30);
		cbEdPaciente.addItem("Seleccionar paciente --");
		
		btnGuardarE = new JButton("Guardar Edición");
		btnGuardarE.setBounds(420,posY,150,30);
		btnGuardarE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblEditar);
		this.add(lblSeleccionarEd);
		this.add(cbEditar);
		this.add(btnEditar);
		this.add(lblEdArea);
		this.add(cbEdArea);
		this.add(lblEdCama);
		this.add(cbEdCama);
		this.add(lblEdPaciente);
		this.add(cbEdPaciente);
		this.add(btnGuardarE);
		
		
		posY+=60;
		//ELIMINAR PACIENTE
		
		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(10,posY,100,30);
		
		posY+=40;
		
		lblSeleccionarEl= new JLabel("Seleccionar Paciente:");
		lblSeleccionarEl.setBounds(10,posY,200,30);
		
		cbEliminar = new JComboBox<>();
		cbEliminar.setBounds(160,posY,200,30);
		cbEliminar.addItem("Seleccionar paciente --");
		
		btnEliminar= new JButton("Eliminar");
		btnEliminar.setBounds(390,posY,150,30);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblEliminar);
		this.add(lblSeleccionarEl);
		this.add(cbEliminar);
		this.add(btnEliminar);
	
	}
}
