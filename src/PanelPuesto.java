import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPuesto extends JPanel{
	MySQLConnect data;
	ResultSet registros=null;
	ResultSet registrosHospital=null;
	private JButton btnAgregar,btnCancelar, btnEditar, btnGuardarE, btnEliminar;
	private JTextField txtNombre, txtSueldo, txtENombre, txtEdSueldo;
	private JLabel lblNombre, lblSeleccionarEd, lblENombre, lblSueldo, lblEdSueldo, lblAgregar, lblEditar, lblSeleccionarEl, lblEliminar;
	private JComboBox<String> cbEdPuesto, cbElPuesto;
	String puestoViejo;
	String sueldoViejo;
	public PanelPuesto(){
		this.setLayout(null);
		this.setSize(1200,700);
		
		data= new MySQLConnect();
		data.MySQLConnect();
		
		registros=(ResultSet) data.getQuery("Select * from TipoPuesto");
		//AGREGAR PUESTO
		lblAgregar =  new JLabel("Agregar Puesto");
		lblAgregar.setBounds(10,5,200,30);
		
		lblNombre = new JLabel("Nombre del Puesto:");
		lblNombre.setBounds(10,30,150,30);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(160, 30, 200, 30);
		
		lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setBounds(370,30,100,30);
		
		txtSueldo = new JTextField();
		txtSueldo.setBounds(430,30,100,30);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10,70,100,30);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				registros=(ResultSet) data.getQuery("Select * from TipoPuesto");
				boolean flagRepetido=false;
				String puesto=txtNombre.getText();
				String sueldoP=txtSueldo.getText();
				double sueldo=Double.parseDouble(sueldoP);
				if(!sueldoP.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(btnAgregar,"La cantidad de sueldo es incorrecta");
				}else {
					try {
						while(registros.next()) {
							String prueba=registros.getString("puesto");
							
							if(puesto.equals(prueba)) {
								
								flagRepetido=true;
							}
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(txtNombre.getText().isEmpty()!=true && txtSueldo.getText().isEmpty()!=true) {
						if(flagRepetido==false ) {
							
							data.setQuery("INSERT INTO TipoPuesto (idTipoPuesto, puesto, sueldo) VALUES (NULL,'"+puesto+"','"+sueldo+"');");
							JOptionPane.showMessageDialog(btnAgregar,"Registro de Puesto exitoso");
							cbEdPuesto.addItem(puesto);
							cbElPuesto.addItem(puesto);
							
						}else {
							JOptionPane.showMessageDialog(btnAgregar,"Llene los campos correctamente");
					}
							if(flagRepetido==true) {
							JOptionPane.showMessageDialog(btnAgregar,"Este puesto ya está registrado");}
							
						}else {
							JOptionPane.showMessageDialog(btnAgregar,"Llene los campos correctamente");
						}
					}
					
				
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(120,70,100,30);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtNombre.setText("");
				txtSueldo.setText("");
			}
		});
		
		this.add(lblAgregar);
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(lblSueldo);
		this.add(txtSueldo);
		this.add(btnAgregar);
		this.add(btnCancelar);
		
		//EDITAR PUESTO
		
		lblEditar = new JLabel("Editar");
		lblEditar.setBounds(10, 140,150,30);
		
		lblSeleccionarEd = new JLabel("Seleccionar Puesto:");
		lblSeleccionarEd.setBounds(10,180,200,30);
		
		cbEdPuesto = new JComboBox<>();
		cbEdPuesto.setBounds(160,180,200,30);
		cbEdPuesto.addItem("Seleccionar puesto --");
		
		btnEditar =  new JButton("Editar");
		btnEditar.setBounds(390,180,100,30);
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbEdPuesto.getSelectedIndex()!=0) {
					double sueldoP;
					String sueldo="";
					txtENombre.setText((String) cbEdPuesto.getSelectedItem());
					puestoViejo=(String) cbEdPuesto.getSelectedItem();
					txtENombre.repaint();
					
					registros=(ResultSet) data.getQuery("Select * from TipoPuesto");
					try {
						while(registros.next()) {
							if(registros.getString("puesto").equals(puestoViejo)) {
							sueldoP=registros.getDouble("sueldo");
							sueldo=String.valueOf(sueldoP);
							}
							
							txtEdSueldo.setText(sueldo);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//sueldoViejo=(String) cbEdPuesto.getSelectedItem();
					
					}else {
						
					}
			}
		});
		
		lblENombre = new JLabel("Nombre:");
		lblENombre.setBounds(10,220,100,30);
		
		txtENombre = new JTextField();
		txtENombre.setBounds(160,220,200,30);
		
		lblEdSueldo = new JLabel("Sueldo:");
		lblEdSueldo.setBounds(380,220,150,30);
		
		txtEdSueldo = new JTextField();
		txtEdSueldo.setBounds(430,220,100,30);
		
		btnGuardarE = new JButton("Guardar Edición");
		btnGuardarE.setBounds(540,220,150,30);
		btnGuardarE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String puestoNuevo=txtENombre.getText();
				String sueldoNuevo=txtEdSueldo.getText();
				if(!sueldoNuevo.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(btnGuardarE,"La cantidad de sueldo es incorrecta");
				}else {
				double sueldoNuevoNew = Double.parseDouble(sueldoNuevo);
				data.setQuery("UPDATE TipoPuesto SET puesto = '"+puestoNuevo+"', sueldo='"+sueldoNuevoNew+"' WHERE puesto='"+puestoViejo+"'");
				
				txtENombre.setText("");
				txtEdSueldo.setText("");
				if(cbEdPuesto.getSelectedIndex()!=0) {
					JOptionPane.showMessageDialog(btnGuardarE,"Edición exitosa");
					cbElPuesto.removeAllItems();
					cbEdPuesto.removeAllItems();
					cbElPuesto.addItem("Seleccione un hospital...");
					cbEdPuesto.addItem("Seleccione un hospital...");
					registros=(ResultSet) data.getQuery("Select * from TipoPuesto");
					try {
						while(registros.next()) {
							
							cbElPuesto.addItem(registros.getString("puesto"));
							cbEdPuesto.addItem(registros.getString("puesto"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else {
						
					}
				}
			}
		});
		
		this.add(lblEditar);
		this.add(lblSeleccionarEd);
		this.add(cbEdPuesto);
		this.add(btnEditar);
		this.add(lblENombre);
		this.add(txtENombre);
		this.add(lblEdSueldo);
		this.add(txtEdSueldo);
		this.add(btnGuardarE);
		
		//ELIMINAR PUESTO
		
		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(10,280,100,30);
		
		lblSeleccionarEl= new JLabel("Seleccionar Puesto:");
		lblSeleccionarEl.setBounds(10,320,200,30);
		
		cbElPuesto = new JComboBox<>();
		cbElPuesto.setBounds(160,320,200,30);
		cbElPuesto.addItem("Seleccionar puesto --");
		try {
			while(registros.next()) {
				cbElPuesto.addItem(registros.getString("puesto"));
				cbEdPuesto.addItem(registros.getString("puesto"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnEliminar= new JButton("Eliminar");
		btnEliminar.setBounds(390,320,150,30);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbElPuesto.getSelectedIndex()!=0) {
					String eliminar=((String) cbElPuesto.getSelectedItem());
					System.out.println(eliminar);
					data.setQuery("DELETE FROM TipoPuesto WHERE puesto='"+eliminar+"'");
					cbElPuesto.removeAllItems();
					cbEdPuesto.removeAllItems();
					cbElPuesto.addItem("Seleccione un hospital...");
					cbEdPuesto.addItem("Seleccione un hospital...");
					JOptionPane.showMessageDialog(btnEliminar,"Eliminación exitosa");
					registros=(ResultSet) data.getQuery("Select * from TipoPuesto");
					try {
						while(registros.next()) {
							
							cbElPuesto.addItem(registros.getString("puesto"));
							cbEdPuesto.addItem(registros.getString("puesto"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else {
						
					}
			}
		});
		
		this.add(lblEliminar);
		this.add(lblSeleccionarEl);
		this.add(cbElPuesto);
		this.add(btnEliminar);
	}
}
