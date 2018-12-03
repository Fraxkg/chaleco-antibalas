import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelMedicamento extends JPanel{

	private JButton btnAgregar,btnCancelar, btnEditar, btnGuardarE, btnEliminar;
	private JTextField txtNombre, txtDescripcion, txtENombre, txtEdDescripcion, txtCantidad, txtEdCantidad;
	private JLabel lblNombre, lblDescripcion, lblCantidad, lblFarmacia, lblSeleccionarEd, lblENombre, lblEdDescripcion, lblEdCantidad, lblEdFarmacia, lblAgregar, lblEditar, lblSeleccionarEl, lblEliminar;
	private JComboBox<String> cbFarmacia,cbEdMedicamento,cbEditarFarmacia, cbElMedicamento;
	
	public PanelMedicamento(){
		this.setLayout(null);
		this.setSize(1200,700);
		
		
		//AGREGAR MEDICAMENTO
		lblAgregar =  new JLabel("Agregar Medicamento");
		lblAgregar.setBounds(10,5,200,30);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10,30,70,30);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(80, 30, 230, 30);
		
		lblDescripcion= new JLabel("Descripcion:");
		lblDescripcion.setBounds(320,30,100,30);
	
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(430,30,600,30);
		
		lblCantidad= new JLabel("Cantidad:");
		lblCantidad.setBounds(1040,30,70,30);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(1120,30,50,30);
		
		lblFarmacia = new JLabel("Seleccioanr farmacia:");
		lblFarmacia.setBounds(10,70,150,30);
		
		cbFarmacia = new JComboBox<>();
		cbFarmacia.setBounds(160,70,250,30);
		cbFarmacia.addItem("Seleccionar farmacia --");
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(420,70,100,30);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(530,70,100,30);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblAgregar);
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(lblDescripcion);
		this.add(txtDescripcion);
		this.add(lblCantidad);
		this.add(txtCantidad);
		this.add(lblFarmacia);
		this.add(cbFarmacia);
		this.add(btnAgregar);
		this.add(btnCancelar);
		
		
		//EDITAR MEDICMENTO
		
		lblEditar = new JLabel("Editar");
		lblEditar.setBounds(10, 140,150,30);
		
		lblSeleccionarEd = new JLabel("Seleccionar Medicamento:");
		lblSeleccionarEd.setBounds(10,180,200,30);
		
		cbEdMedicamento = new JComboBox<>();
		cbEdMedicamento.setBounds(180,180,200,30);
		cbEdMedicamento.addItem("Seleccionar medicamento --");
		
		btnEditar =  new JButton("Editar");
		btnEditar.setBounds(390,180,100,30);
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		lblENombre = new JLabel("Nombre:");
		lblENombre.setBounds(10,220,100,30);
		
		txtENombre = new JTextField();
		txtENombre.setBounds(80,220, 230, 30);
		
		lblEdDescripcion = new JLabel("Descripcion:");
		lblEdDescripcion.setBounds(320,220,100,30);
		
		txtEdDescripcion = new JTextField();
		txtEdDescripcion.setBounds(430,220,600,30);
		
		lblEdCantidad= new JLabel("Cantidad:");
		lblEdCantidad.setBounds(1040,220,70,30);
		
		txtEdCantidad = new JTextField();
		txtEdCantidad.setBounds(1120,220,50,30);
		
		lblEdFarmacia = new JLabel("Seleccioanr farmacia:");
		lblEdFarmacia.setBounds(10,260,150,30);
		
		cbEditarFarmacia = new JComboBox<>();
		cbEditarFarmacia.setBounds(160,260,250,30);
		cbEditarFarmacia.addItem("Seleccionar farmacia --");
		
		btnGuardarE = new JButton("Guardar Edición");
		btnGuardarE.setBounds(420,260,150,30);
		btnGuardarE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblEditar);
		this.add(lblSeleccionarEd);
		this.add(cbEdMedicamento);
		this.add(btnEditar);
		this.add(lblENombre);
		this.add(txtENombre);
		this.add(lblEdDescripcion);
		this.add(txtEdDescripcion);
		this.add(lblEdCantidad);
		this.add(txtEdCantidad);
		this.add(lblEdFarmacia);
		this.add(cbEditarFarmacia);
		this.add(btnGuardarE);
		
		//ELIMINAR PUESTO
		
		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(10,320,100,30);
		
		lblSeleccionarEl= new JLabel("Seleccionar Medicamento:");
		lblSeleccionarEl.setBounds(10,360,200,30);
		
		cbElMedicamento = new JComboBox<>();
		cbElMedicamento.setBounds(170,360,250,30);
		cbElMedicamento.addItem("Seleccionar medicamento --");
		
		btnEliminar= new JButton("Eliminar");
		btnEliminar.setBounds(430,360,150,30);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblEliminar);
		this.add(lblSeleccionarEl);
		this.add(cbElMedicamento);
		this.add(btnEliminar);
	
	}
}
