import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPaciente extends JPanel{

		private int posY=10;
		private JComboBox<String> cbHospital;
		private JLabel lblSelectHospital;
	//Controles Agergar
		private JLabel lblAgregar,lblNombre, lblAp, lblAm, lblDireccion, lblTel, lblFechaNac, lblSexo;
		private JTextField txtNombre, txtAp, txtAm, txtDireccion, txtTel, txtFechaNac;
		private JComboBox<String> cbSexo;
		private JButton btnAgregar, btnCancelar;
		
		//Conteoles Editar
		private JLabel lblEditar, lblSeleccionarEd,lblEdNombre, lblEdAp, lblEdAm, lblEdDireccion, lblEdTel, lblEdFechaNac, lblEdSexo;
		private JTextField txtEdNombre, txtEdAp, txtEdAm, txtEdDireccion, txtEdTel, txtEdFechaNac;
		private JComboBox<String> cbEdSexo, cbEditar;
		private JButton btnEditar, btnGuardarEdicion, btnCancelarEdicion;
		
		//Controles Eliminar
		private JLabel lblEliminar, lblSeleccionarEl;
		private JComboBox<String> cbEliminar;
		private JButton btnEliminar;
		
		
		public PanelPaciente(){
			
			this.setLayout(null);
			this.setSize(1200,700);
			
			lblSelectHospital = new JLabel("Seleccionar hospital:");
			lblSelectHospital.setBounds(10,posY,150,30);
			
			cbHospital = new JComboBox<>();
			cbHospital.setBounds(150, posY, 300,30);
			cbHospital.addItem("Seleccionar hospital --");
			
			posY+=40;
			
			//AGREGAR PACIENTE
			
			lblAgregar = new JLabel("Agregar");
			lblAgregar.setBounds(10,posY,100,30);
			
			posY+=40;
			
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10,posY,100,30);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(70,posY,200,30);
			
			posY+=40;
			
			lblAp = new JLabel("Apellido paterno:");
			lblAp.setBounds(10,posY,200,30);
			
			txtAp = new JTextField();
			txtAp.setBounds(130,posY,200,30);
			
			posY+=40;
			
			lblAm = new JLabel("Apellido materno:");
			lblAm.setBounds(10,posY,200,30);
			
			txtAm = new JTextField();
			txtAm.setBounds(130,posY,200,30);
			
			posY+=40;
			
			lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(10,posY,120,30);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(90,posY,300,30);
			
			posY+=40;
			
			lblTel = new JLabel("Telefono:");
			lblTel.setBounds(10,posY,100,30);
			
			txtTel = new JTextField();
			txtTel.setBounds(90,posY,150,30);
			
			posY+=40;
			
			lblFechaNac = new JLabel("Fecha de nacimiento:");
			lblFechaNac.setBounds(10,posY,230,30);
			
			txtFechaNac = new JTextField();
			txtFechaNac.setBounds(150,posY,100,30);
			
			posY+=40;
			
			lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(10,posY,100,30);
			
			cbSexo = new JComboBox<>();
			cbSexo.setBounds(70,posY,150,30);
			cbSexo.addItem("Seleccionar sexo --");
			
			posY+=40;
			
			btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(10,posY,100,30);
			btnAgregar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
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
			this.add(lblSelectHospital);
			this.add(cbHospital);
			this.add(lblNombre);
			this.add(txtNombre);
			this.add(lblAp);
			this.add(txtAp);
			this.add(lblAm);
			this.add(txtAm);
			this.add(lblDireccion);
			this.add(txtDireccion);
			this.add(lblTel);
			this.add(txtTel);
			this.add(lblFechaNac);
			this.add(txtFechaNac);
			this.add(lblSexo);
			this.add(cbSexo);			
			this.add(btnAgregar);
			this.add(btnCancelar);
			
			
			//EDITAR PACIENTE
			
			posY=10;
			
			lblEditar = new JLabel("Editar");
			lblEditar.setBounds(610,posY,100,30);
			
			posY+=40;
			
			lblSeleccionarEd = new JLabel("Seleccionar Paciente:");
			lblSeleccionarEd.setBounds(610,posY,150,30);
			
			cbEditar = new JComboBox<>();
			cbEditar.setBounds(760,posY,200,30);
			cbEditar.addItem("Seleccionar paciente --");
			
			btnEditar = new JButton("Editar");
			btnEditar.setBounds(970,posY,100,30);
			btnEditar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			posY+=40;
			
			lblEdNombre = new JLabel("Nombre:");
			lblEdNombre.setBounds(610,posY,100,30);
			
			txtEdNombre = new JTextField();
			txtEdNombre.setBounds(670,posY,200,30);
			
			posY+=40;
			
			lblEdAp = new JLabel("Apellido paterno:");
			lblEdAp.setBounds(610,posY,200,30);
			
			txtEdAp = new JTextField();
			txtEdAp.setBounds(730,posY,200,30);
			
			posY+=40;
			
			lblEdAm = new JLabel("Apellido materno:");
			lblEdAm.setBounds(610,posY,200,30);
			
			txtEdAm = new JTextField();
			txtEdAm.setBounds(730,posY,200,30);
			
			posY+=40;
			
			lblEdDireccion = new JLabel("Direccion:");
			lblEdDireccion.setBounds(610,posY,120,30);
			
			txtEdDireccion = new JTextField();
			txtEdDireccion.setBounds(690,posY,300,30);
			
			posY+=40;
			
			lblEdTel = new JLabel("Telefono:");
			lblEdTel.setBounds(610,posY,100,30);
			
			txtEdTel = new JTextField();
			txtEdTel.setBounds(690,posY,150,30);
			
			posY+=40;
			
			lblEdFechaNac = new JLabel("Fecha de nacimiento:");
			lblEdFechaNac.setBounds(610,posY,230,30);
			
			txtEdFechaNac = new JTextField();
			txtEdFechaNac.setBounds(750,posY,100,30);
			
			posY+=40;
			
			lblEdSexo = new JLabel("Sexo:");
			lblEdSexo.setBounds(610,posY,100,30);
			
			cbEdSexo = new JComboBox<>();
			cbEdSexo.setBounds(670,posY,150,30);
			cbEdSexo.addItem("Seleccionar sexo --");
			
			posY+=40;
			
			btnGuardarEdicion = new JButton("Guardar");
			btnGuardarEdicion.setBounds(610,posY,100,30);
			btnGuardarEdicion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			btnCancelarEdicion = new JButton("Cancelar");
			btnCancelarEdicion.setBounds(720,posY,100,30);
			btnCancelarEdicion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			this.add(lblEditar);
			this.add(lblSeleccionarEd);
			this.add(cbEditar);
			this.add(lblEdNombre);
			this.add(txtEdNombre);
			this.add(lblEdAp);
			this.add(txtEdAp);
			this.add(lblEdAm);
			this.add(txtEdAm);
			this.add(lblEdDireccion);
			this.add(txtEdDireccion);
			this.add(lblEdTel);
			this.add(txtEdTel);
			this.add(lblEdFechaNac);
			this.add(txtEdFechaNac);
			this.add(lblEdSexo);
			this.add(cbEdSexo);
			this.add(btnEditar);
			this.add(btnGuardarEdicion);
			this.add(btnCancelarEdicion);
			
			
			
			posY=500;
			//ELIMINAR
			lblEliminar = new JLabel("Eliminar");
			lblEliminar.setBounds(10,posY,100,30);
			
			posY+=40;
			
			lblSeleccionarEl = new JLabel("Seleccionar Paciente:");
			lblSeleccionarEl.setBounds(10,posY,200,30);
			
			cbEliminar = new JComboBox<>();
			cbEliminar.setBounds(220,posY,200,30);
			cbEliminar.addItem("Seleccionar paciente --");
			
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
