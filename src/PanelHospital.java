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
import javax.swing.text.AbstractDocument.BranchElement;

public class PanelHospital extends JPanel{
	
	MySQLConnect data;
	ResultSet registros=null;
	private JButton btnAgregar,btnCancelar, btnEditar, btnGuardarE, btnEliminar;
	private JTextField txtNombre, txtENombre;
	private JLabel lblNombre, lblSeleccionarEd, lblENombre, lblAgregar, lblEditar, lblSeleccionarEl, lblEliminar;
	private JComboBox<String> cbEdHospital, cbElHospital;
	String nombreViejo;
	public PanelHospital(){
		this.setLayout(null);
		this.setSize(1200,700);
	
		data= new MySQLConnect();
		data.MySQLConnect();
		registros=(ResultSet) data.getQuery("Select * from Hospital");
		//AGREGAR HOSPITAL
		lblAgregar =  new JLabel("Agregar Hospital");
		lblAgregar.setBounds(10,5,200,30);
		
		lblNombre = new JLabel("Nombre del Hospital:");
		lblNombre.setBounds(10,30,150,30);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(160, 30, 150, 30);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10,70,100,30);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				registros=(ResultSet) data.getQuery("Select * from Hospital");
				boolean flagRepetido=false;
				String hospital=txtNombre.getText();
				System.out.println(hospital);
				System.out.println(" ");
				try {
					while(registros.next()) {
						String prueba=registros.getString("nombre");
						System.out.println(hospital +" "+prueba);
						if(hospital.equals(prueba)) {
							
							flagRepetido=true;
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(txtNombre.getText().isEmpty()!=true && flagRepetido==false) {
					System.out.println(" ");
					System.out.println("no se repetio");
				data.setQuery("INSERT INTO Hospital (idHospital, nombre) VALUES (NULL, '"+hospital+"');");
				JOptionPane.showMessageDialog(btnAgregar,"Registro de hospital exitoso");
				cbElHospital.addItem(hospital);
				cbEdHospital.addItem(hospital);
			}else {
				JOptionPane.showMessageDialog(btnAgregar,"Inserte los datos correspondientes");
		}
				if(flagRepetido==true) {
				JOptionPane.showMessageDialog(btnAgregar,"Este hospital ya está registrado");}
				
				}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(120,70,100,30);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtNombre.setText("");
			}
		});
		
		this.add(lblAgregar);
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(btnAgregar);
		this.add(btnCancelar);
		
		//EDITAR HOSPITAL
		
		lblEditar = new JLabel("Editar");
		lblEditar.setBounds(10, 140,150,30);
		
		lblSeleccionarEd = new JLabel("Seleccionar Hospital:");
		lblSeleccionarEd.setBounds(10,180,200,30);
		
		cbEdHospital = new JComboBox<>();
		cbEdHospital.setBounds(180,180,200,30);
		cbEdHospital.addItem("Seleccionar Hospital --");
		
		txtENombre = new JTextField();
		txtENombre.setBounds(180,220,200,30);
		
		btnEditar =  new JButton("Editar");
		btnEditar.setBounds(390,180,150,30);
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(cbEdHospital.getSelectedIndex()!=0) {
				txtENombre.setText((String) cbEdHospital.getSelectedItem());
				nombreViejo=(String) cbEdHospital.getSelectedItem();
				System.out.println(cbEdHospital.getSelectedItem());
				txtENombre.repaint();
				}else {
					
				}
			}
		});
		
		lblENombre = new JLabel("Nombre:");
		lblENombre.setBounds(10,220,100,30);
		
		
		btnGuardarE = new JButton("Guardar Edición");
		btnGuardarE.setBounds(390,220,150,30);
		btnGuardarE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String nombreNuevo=txtENombre.getText();
				System.out.println(nombreNuevo);
				
				if(cbEdHospital.getSelectedIndex()!=0) {
					data.setQuery("UPDATE Hospital SET nombre = '"+nombreNuevo+"' WHERE nombre='"+nombreViejo+"'");
					
					txtENombre.setText("");
					JOptionPane.showMessageDialog(btnGuardarE,"Edición exitosa");
					cbElHospital.removeAllItems();
					cbEdHospital.removeAllItems();
					cbElHospital.addItem("Seleccione un hospital...");
					cbEdHospital.addItem("Seleccione un hospital...");
					registros=(ResultSet) data.getQuery("Select * from Hospital");
					try {
						while(registros.next()) {
							
							cbElHospital.addItem(registros.getString("nombre"));
							cbEdHospital.addItem(registros.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else {
						
					}
			}
		});
		
		this.add(lblEditar);
		this.add(lblSeleccionarEd);
		this.add(cbEdHospital);
		this.add(btnEditar);
		this.add(lblENombre);
		this.add(txtENombre);
		this.add(btnGuardarE);
		
		//ELIMINAR HOSPITAL
		
		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(10,280,100,30);
		
		lblSeleccionarEl= new JLabel("Seleccionar Hospital:");
		lblSeleccionarEl.setBounds(10,320,200,30);
		
		cbElHospital = new JComboBox<>();
		cbElHospital.setBounds(180,320,200,30);
		cbElHospital.addItem("Seleccionar Hospital --");
		
		try {
			while(registros.next()) {
				cbElHospital.addItem(registros.getString("nombre"));
				cbEdHospital.addItem(registros.getString("nombre"));
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
				
				if(cbElHospital.getSelectedIndex()!=0) {
					String eliminar=((String) cbElHospital.getSelectedItem());
					System.out.println(eliminar);
					data.setQuery("DELETE FROM Hospital WHERE nombre='"+eliminar+"'");
					cbElHospital.removeAllItems();
					cbEdHospital.removeAllItems();
					cbElHospital.addItem("Seleccione un hospital...");
					cbEdHospital.addItem("Seleccione un hospital...");
					JOptionPane.showMessageDialog(btnEliminar,"Eliminación exitosa");
					registros=(ResultSet) data.getQuery("Select * from Hospital");
					try {
						while(registros.next()) {
							
							cbElHospital.addItem(registros.getString("nombre"));
							cbEdHospital.addItem(registros.getString("nombre"));
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
		this.add(cbElHospital);
		this.add(btnEliminar);
	}
}
