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

public class PanelMedicamento extends JPanel{

	private JButton btnAgregar,btnCancelar, btnEditar, btnGuardarE, btnEliminar;
	private JTextField txtNombre, txtDescripcion, txtENombre, txtEdDescripcion, txtCantidad, txtEdCantidad;
	private JLabel lblNombre, lblDescripcion, lblCantidad, lblFarmacia, lblSeleccionarEd, lblENombre, lblEdDescripcion, lblEdCantidad, lblEdFarmacia, lblAgregar, lblEditar, lblSeleccionarEl, lblEliminar;
	private JComboBox<String> cbFarmacia,cbEdMedicamento,cbEditarFarmacia, cbElMedicamento;
	MySQLConnect data;
	String nombreViejo;
	public PanelMedicamento(){
		this.setLayout(null);
		this.setSize(1200,700);
		data= new MySQLConnect();
		data.MySQLConnect();
		
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
		ResultSet regFarmacia=(ResultSet) data.getQuery("Select * from Farmacia");
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(420,70,100,30);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ResultSet registros=(ResultSet) data.getQuery("Select * from Medicamento");
				ResultSet registrosFarmacia=(ResultSet) data.getQuery("Select * from Farmacia");
				boolean flagRepetido=false;
				int idFarmacia=0;
				int idMedicamento=0;
				//guarda el texto insertado en una variable
				String nombre=txtNombre.getText();
				String desc=txtDescripcion.getText();
				int cantidad=Integer.parseInt(txtCantidad.getText());
				String farmaciaElegido=(String) cbFarmacia.getSelectedItem();
				//inicializo el id del hospital que se agregará a area
				
	
				if(txtNombre.getText().isEmpty()!=true) {
					
				data.setQuery("INSERT INTO Medicamento (idMedicamento, nombre, descripcion) VALUES (NULL, '"+nombre+"','"+desc+"');");
				
				cbEdMedicamento.addItem(nombre);
				cbElMedicamento.addItem(nombre);
				
				ResultSet regIdFarmacia=(ResultSet) data.getQuery("Select * from Farmacia where nombre='"+farmaciaElegido+"';");
				try {
					while(regIdFarmacia.next()) {
						
						idFarmacia=regIdFarmacia.getInt("idFarmacia");
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet regIdMedicamento=(ResultSet) data.getQuery("Select * from Medicamento where nombre='"+nombre+"';");
				try {
					while(regIdMedicamento.next()) {
						
						idMedicamento=regIdMedicamento.getInt("idMedicamento");
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				data.setQuery("INSERT INTO Inventario (idInventario, cantidad, idFarmacia, idMedicamento)"
						+ "VALUES (NULL, '"+cantidad+"','"+idFarmacia+"','"+idMedicamento+"');");
				JOptionPane.showMessageDialog(btnAgregar,"Registro de Medicamento exitoso");
				
				}
			
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
				
				String nombre="";
				String desc="";
				String cantidad="";
				int idFarmacia=0;
				int idMedicamento=0;
				if(cbEdMedicamento.getSelectedIndex()!=0) {
					nombreViejo= (String) cbEdMedicamento.getSelectedItem();
					txtENombre.setText((String) cbEdMedicamento.getSelectedItem());
					ResultSet registrosSeleccionado=(ResultSet)data.getQuery("SELECT * FROM Medicamento where nombre= '"+nombreViejo+"';");
					try {
						while(registrosSeleccionado.next()) {
							
							
							txtEdDescripcion.setText(registrosSeleccionado.getString("descripcion"));
						
							
							
						
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ResultSet regIdMed=(ResultSet)data.getQuery("SELECT * FROM Medicamento where nombre= '"+nombreViejo+"';");
					try {
						while(regIdMed.next()) {
							idMedicamento=regIdMed.getInt("idMedicamento");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ResultSet cansel=(ResultSet)data.getQuery("SELECT * FROM Inventario where idMedicamento= '"+idMedicamento+"';");
					try {
						while(cansel.next()) {
							txtEdCantidad.setText(cansel.getString("cantidad"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ResultSet regFarmacia=(ResultSet)data.getQuery("SELECT * FROM Farmacia where idFarmacia= '"+idFarmacia+"';");
					try {
						while(regFarmacia.next()) {
							cbEditarFarmacia.setSelectedItem(regFarmacia.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
					
				
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
		try {
			while(regFarmacia.next()) {
				cbFarmacia.addItem(regFarmacia.getString("nombre"));
				cbEditarFarmacia.addItem(regFarmacia.getString("nombre"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		btnGuardarE = new JButton("Guardar Edición");
		btnGuardarE.setBounds(420,260,150,30);
		btnGuardarE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int idFarmacia=0;
				int idMedicamento=0;
			
				String nombreNuevo=txtENombre.getText();
				String descNuevo=txtEdDescripcion.getText();
				String cantidadNuevo=txtEdCantidad.getText();
				int newCantidad=Integer.parseInt(cantidadNuevo);
				String FarmaciaNuevo=(String) cbEditarFarmacia.getSelectedItem();
				
				ResultSet regFarmacia=(ResultSet) data.getQuery("select *from Farmacia where nombre='"+FarmaciaNuevo+"';");
				try {
					while(regFarmacia.next()) {
						idFarmacia=regFarmacia.getInt("idFarmacia");
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					data.setQuery("UPDATE Medicamento SET nombre = '"+nombreNuevo+"',descripcion='"+descNuevo+"' WHERE nombre='"+nombreViejo+"'");
					
					txtEdCantidad.setText("");
					txtEdDescripcion.setText("");
					txtENombre.setText("");
					ResultSet regIdMed=(ResultSet)data.getQuery("SELECT * FROM Medicamento where nombre= '"+nombreViejo+"';");
					try {
						while(regIdMed.next()) {
							idMedicamento=regIdMed.getInt("idMedicamento");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					data.setQuery("UPDATE Inventario SET cantidad = '"+cantidadNuevo+"' WHERE idMedicamento='"+idMedicamento+"'");
					
					cbEditarFarmacia.setSelectedIndex(0);
					JOptionPane.showMessageDialog(btnGuardarE,"Edición exitosa");
					cbElMedicamento.removeAllItems();
					cbEdMedicamento.removeAllItems();
					cbElMedicamento.addItem("Seleccione medicamento...");
					cbEdMedicamento.addItem("Seleccione medicamento...");
					ResultSet registrosArea=(ResultSet)data.getQuery("SELECT * FROM Medicamento;");
					
					try {
						while(registrosArea.next()) {
							
							cbElMedicamento.addItem(registrosArea.getString("nombre"));
							cbEdMedicamento.addItem(registrosArea.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
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
				if(cbElMedicamento.getSelectedIndex()!=0) {
					String eliminar=((String) cbElMedicamento.getSelectedItem());
					System.out.println(eliminar);
					data.setQuery("DELETE FROM Medicamento WHERE nombre='"+eliminar+"'");
					cbEdMedicamento.removeAllItems();
					cbElMedicamento.removeAllItems();
					cbElMedicamento.addItem("Seleccione un medicamento...");
					cbEdMedicamento.addItem("Seleccione un medicamento...");
					JOptionPane.showMessageDialog(btnEliminar,"Eliminación exitosa");
					ResultSet registros=(ResultSet) data.getQuery("Select * from Medicamento ;");
					try {
						while(registros.next()) {
							
							cbElMedicamento.addItem(registros.getString("nombre"));
							cbEdMedicamento.addItem(registros.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else {
						
					}
			}
		});
		ResultSet regMed=(ResultSet) data.getQuery("Select * from Medicamento");
		try {
			while(regMed.next()) {
				cbElMedicamento.addItem(regMed.getString("nombre"));
				cbEdMedicamento.addItem(regMed.getString("nombre"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.add(lblEliminar);
		this.add(lblSeleccionarEl);
		this.add(cbElMedicamento);
		this.add(btnEliminar);
	
	}
}
