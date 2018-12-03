import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCita extends JPanel{

	private int posY=10;
	private JComboBox<String> cbHospital;
	private JLabel lblSelectHospital;
	
	//Controles Agergar
			private JLabel lblAgregar,lblFecha, lblFolio, lblPaciente, lblPersonal;
			private JTextField txtFecha, txtFolio;
			private JComboBox<String> cbPaciente, cbPersonal;
			private JButton btnAgregar, btnCancelar;
			
			//Conteoles Editar
			private JLabel lblEditar, lblSeleccionarEd,lblEdFecha, lblEdFolio, lblEdPaciente, lblEdPersonal;
			private JTextField txtEdFecha, txtEdFolio;
			private JComboBox<String> cbEditar,cbEdPaciente, cbEdPersonal;
			private JButton btnEditar, btnGuardarEdicion, btnCancelarEdicion;
			
			//Controles Eliminar
			private JLabel lblEliminar, lblSeleccionarEl;
			private JComboBox<String> cbEliminar;
			private JButton btnEliminar;
			
			
			public PanelCita(){
				
				this.setLayout(null);
				this.setSize(1200,700);
				
				lblSelectHospital = new JLabel("Seleccionar hospital:");
				lblSelectHospital.setBounds(10,posY,150,30);
				
				cbHospital = new JComboBox<>();
				cbHospital.setBounds(150, posY, 300,30);
				cbHospital.addItem("Seleccionar hospital --");
				
				posY+=40;
				
				//AGREGAR CITA
				
				lblAgregar = new JLabel("Agregar");
				lblAgregar.setBounds(10,posY,100,30);
				
				posY+=40;
				
				lblFecha = new JLabel("Fecha:");
				lblFecha.setBounds(10,posY,100,30);
				
				txtFecha = new JTextField();
				txtFecha.setBounds(70,posY,300,30);
				
				posY+=40;
				
				lblFolio = new JLabel("Folio:");
				lblFolio.setBounds(10,posY,200,30);
				
				txtFolio = new JTextField();
				txtFolio.setBounds(70,posY,300,30);
				
				posY+=40;
				
				lblPaciente = new JLabel("Paciente:");
				lblPaciente.setBounds(10,posY,100,30);
				
				cbPaciente = new JComboBox<>();
				cbPaciente.setBounds(70,posY,300,30);
				cbPaciente.addItem("Seleciconar paciente --");
				
				posY+=40;
				
				lblPersonal = new JLabel("Doctor:");
				lblPersonal.setBounds(10, posY, 100,30);
				
				cbPersonal = new JComboBox<>();
				cbPersonal.setBounds(70,posY,300,30);
				cbPersonal.addItem("Seleccionar doctor --");
				
				posY+=40;
				
				btnAgregar = new JButton("Agregar");
				btnAgregar.setBounds(10,posY,120,30);
				btnAgregar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(140,posY,120,30);
				btnCancelar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
			
				this.add(lblSelectHospital);
				this.add(cbHospital);
				this.add(lblAgregar);
				this.add(lblFecha);
				this.add(txtFecha);
				this.add(lblFolio);
				this.add(txtFolio);
				this.add(lblPaciente);
				this.add(cbPaciente);
				this.add(lblPersonal);
				this.add(cbPersonal);			
				this.add(btnAgregar);
				this.add(btnCancelar);
				
				
				//EDITAR CITA
				posY=10;
				
				lblEditar = new JLabel("Editar");
				lblEditar.setBounds(610,posY,100,30);
				
				posY+=40;
				
				lblSeleccionarEd = new JLabel("Seleccionar Cita:");
				lblSeleccionarEd.setBounds(610,posY,150,30);
				
				cbEditar = new JComboBox<>();
				cbEditar.setBounds(760,posY,200,30);
				cbEditar.addItem("Seleccionar cita --");
				
				btnEditar = new JButton("Editar");
				btnEditar.setBounds(970,posY,100,30);
				btnEditar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				posY+=40;
				
				lblEdFecha = new JLabel("Fecha:");
				lblEdFecha.setBounds(610,posY,100,30);
				
				txtEdFecha = new JTextField();
				txtEdFecha.setBounds(690,posY,300,30);
				
				posY+=40;
				
				lblEdFolio = new JLabel("Folio:");
				lblEdFolio.setBounds(610,posY,300,30);
				
				txtEdFolio = new JTextField();
				txtEdFolio.setBounds(690,posY,300,30);
				
				posY+=40;
				
				lblEdPaciente = new JLabel("Paciente:");
				lblEdPaciente.setBounds(610,posY,200,30);
				
				cbEdPaciente = new JComboBox<>();
				cbEdPaciente.setBounds(690,posY,300,30);
				cbEdPaciente.addItem("Seleccionar paciente --");
				
				posY+=40;
				
				lblEdPersonal = new JLabel("Doctor:");
				lblEdPersonal.setBounds(610,posY,120,30);
				
				cbEdPersonal = new JComboBox<>();
				cbEdPersonal.setBounds(690,posY,300,30);
				cbEdPersonal.addItem("Seleccionar doctor --");
				
				posY+=40;
				
				btnGuardarEdicion = new JButton("Guardar:");
				btnGuardarEdicion.setBounds(610,posY,100,30);
				
				btnCancelarEdicion = new JButton("Cancelar");
				btnCancelarEdicion.setBounds(720,posY,100,30);
				
				
				this.add(lblEditar);
				this.add(lblSeleccionarEd);
				this.add(cbEditar);
				this.add(lblEdFecha);
				this.add(txtEdFecha);
				this.add(lblEdFolio);
				this.add(txtEdFolio);
				this.add(lblEdPaciente);
				this.add(cbEdPaciente);
				this.add(lblEdPersonal);
				this.add(cbEdPersonal);
				this.add(btnEditar);
				this.add(btnGuardarEdicion);
				this.add(btnCancelarEdicion);
				
				
				//ELIMINAR
				
				posY=500;
				
				lblEliminar = new JLabel("Eliminar");
				lblEliminar.setBounds(10,posY,100,30);
				
				posY+=40;
				
				lblSeleccionarEl = new JLabel("Seleccionar Cita:");
				lblSeleccionarEl.setBounds(10,posY,200,30);
				
				cbEliminar = new JComboBox<>();
				cbEliminar.setBounds(120,posY,300,30);
				cbEliminar.addItem("Seleccionar cita --");
				
				posY+=40;
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setBounds(10,posY,100,30);
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
