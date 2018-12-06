import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelPersonal extends JPanel{
	 private int posY=10;
	 private JComboBox<String> cbHospital;
	 private JLabel lblSelectHospital;
	 //bASE DE DATOS
	 MySQLConnect data;
	 ResultSet registros=null;
	 ResultSet registrosSexo=null;
	 ResultSet registrosPuesto=null;
	ResultSet registrosHospital=null;
	String nombreViejo;
	String aPaternoViejo;
	String aMaternoViejo;
	String direccionViejo;
	String telefonoViejo;
	String sexoViejo;
	String PuestoViejo;
	String AreaViejo;
	int idHospital=0;
	//Controles Agergar
	private JLabel lblAgregar,lblNombre, lblAp, lblAm, lblDireccion, lblTel, lblFechaNac, lblSexo, lblPuesto, lblArea;
	private JTextField txtNombre, txtAp, txtAm, txtDireccion, txtTel, txtFechaNac;
	private JComboBox<String> cbSexo, cbPuesto, cbArea;
	private JButton btnAgregar, btnCancelar;
	
	//Conteoles Editar
	private JLabel lblEditar, lblSeleccionarEd,lblEdNombre, lblEdAp, lblEdAm, lblEdDireccion, lblEdTel, lblEdFechaNac, lblEdSexo, lblEdPuesto, lblEdArea;
	private JTextField txtEdNombre, txtEdAp, txtEdAm, txtEdDireccion, txtEdTel, txtEdFechaNac;
	private JComboBox<String> cbEdSexo, cbEditar, cbEdPuesto, cbEdArea;
	private JButton btnEditar, btnGuardarEdicion, btnCancelarEdicion, btnSelHospital;
	
	//Controles Eliminar
	private JLabel lblEliminar, lblSeleccionarEl;
	private JComboBox<String> cbEliminar;
	private JButton btnEliminar;
	
	
	public PanelPersonal(){
		
		this.setLayout(null);
		this.setSize(1200,700);
		
		//AGREGAR PERSONAL
		data= new MySQLConnect();
		data.MySQLConnect();
		registrosHospital=(ResultSet) data.getQuery("Select * from Hospital");
		
		lblSelectHospital = new JLabel("Seleccionar hospital:");
		lblSelectHospital.setBounds(10,posY,150,30);
		
		cbHospital = new JComboBox<>();
		cbHospital.setBounds(150, posY, 300,30);
		cbHospital.addItem("Seleccionar Hospital --");

		try {
			while(registrosHospital.next()) {
				cbHospital.addItem(registrosHospital.getString("nombre"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		btnSelHospital = new JButton("Seleccionar");
		btnSelHospital.setBounds(460,10,120,30);
		btnSelHospital.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String HospitalSel=(String) cbHospital.getSelectedItem();
				ResultSet registrosIdHospital=(ResultSet)data.getQuery("SELECT * FROM hospital where nombre= '"+HospitalSel+"';");
				try {
					while(registrosIdHospital.next()) {
					
						idHospital=registrosIdHospital.getInt("idHospital");
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cbEditar.removeAllItems();
				cbEliminar.removeAllItems();
				cbEditar.addItem("Seleccione un Personal...");
				cbEliminar.addItem("Seleccione un Personal...");
				cbEdArea.removeAllItems();
				cbArea.removeAllItems();
				cbEdArea.addItem("Seleccione un área...");
				cbArea.addItem("Seleccione un área...");
				System.out.println(idHospital);
				ResultSet Concuerda=(ResultSet)data.getQuery("SELECT * FROM Personal where idHospital= '"+idHospital+"';");
				
				try {
					while(Concuerda.next()) {
						System.out.println("sin entro");
						cbEditar.addItem(Concuerda.getString("nombre"));
						cbEliminar.addItem(Concuerda.getString("nombre"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet ConcuerdaArea=(ResultSet)data.getQuery("SELECT * FROM _Area where idHospital= '"+idHospital+"';");
				
				try {
					while(ConcuerdaArea.next()) {
						System.out.println("sin entro");
						cbArea.addItem(ConcuerdaArea.getString("nombre"));
						cbEdArea.addItem(ConcuerdaArea.getString("nombre"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		posY+=40;		
		
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
		
		txtFechaNac = new JTextField("YYYY-MM-DD");
		txtFechaNac.setBounds(150,posY,100,30);
		
		posY+=40;
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10,posY,100,30);
		
		cbSexo = new JComboBox<>();
		cbSexo.setBounds(70,posY,150,30);
		cbSexo.addItem("Seleccioanr sexo --");
		
		posY+=40;
		
		lblPuesto = new JLabel("Seleccionar puesto:");
		lblPuesto.setBounds(10,posY,200,30);
		
		cbPuesto = new JComboBox<>();
		cbPuesto.setBounds(170,posY,200,30);
		cbPuesto.addItem("Seleccionar puesto --");
		
		posY+=40;
		
		lblArea = new JLabel("Área:");
		lblArea.setBounds(10,posY,70,30);
		
		cbArea = new JComboBox<>();
		cbArea.setBounds(80,posY,290,30);
		cbArea.addItem("Seleccionar área --");
		
		posY+=40;
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10,posY,100,30);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				registros=(ResultSet) data.getQuery("Select * from _Area");
				registrosHospital=(ResultSet) data.getQuery("Select * from Hospital");
				boolean flagRepetido=false;
				//guarda el texto insertado en una variable
				String nombre=txtNombre.getText();
				String ap=txtAp.getText();
				String am=txtAm.getText();
				String direccion=txtDireccion.getText();
				String telefono=txtTel.getText();
				String fechaNac=txtFechaNac.getText();
				String sexo=(String) cbSexo.getSelectedItem();
				String area=(String)cbArea.getSelectedItem();
				String puesto=(String)cbPuesto.getSelectedItem();
				int idSexo=0;
				int idPuesto=0;
				int idArea=0;
				//int =(int) cbSexo.getSelectedItem();
				//guardo la opcion del hospital elegido en una varibale
				String hospitalElegido=(String) cbHospital.getSelectedItem();
				//inicializo el id del hospital que se agregará a area
				
				
			
				System.out.println(idHospital);
				
				/// este ciclo de los registros de area sirve para comprobar que no se repita la misma area en el mismo hospital
				try {
					while(registros.next()) {
						String prueba=registros.getString("nombre");
						int prueba2=registros.getInt("idHospital");
						
						if(nombre.equals(prueba)&&idHospital==prueba2) {
							
							flagRepetido=true;
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet obtenerSexo=(ResultSet)data.getQuery("SELECT * FROM Sexo where nombre= '"+sexo+"';");
				
				try {
					while(obtenerSexo.next()) {
						idSexo=obtenerSexo.getInt("idSexo");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet obtenerPuesto=(ResultSet)data.getQuery("SELECT * FROM TipoPuesto where puesto= '"+puesto+"';");
				
				try {
					while(obtenerPuesto.next()) {
						idPuesto=obtenerPuesto.getInt("idTipoPuesto");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet obtenerArea=(ResultSet)data.getQuery("SELECT * FROM _Area where nombre= '"+area+"';");
				
				try {
					while(obtenerArea.next()) {
						idArea=obtenerArea.getInt("idArea");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//aqui se valida que si el campo no esta vacio y no esta repetido insertara la informacion moxxita
				if(txtNombre.getText().isEmpty()!=true && flagRepetido==false) {
					
				data.setQuery("INSERT INTO Personal (idPersonal, nombre,apellidoPaterno,apellidoMaterno,direccion,telefono, fechaNacimiento,idSexo,idTipoPuesto,idArea, idHospital)"
						+ " VALUES (NULL, '"+nombre+"','"+ap+"','"+am+"','"+direccion+"','"+telefono+"','"+fechaNac+"','"+idSexo+"','"+idPuesto+"','"+idArea+"','"+idHospital+"');");
				JOptionPane.showMessageDialog(btnAgregar,"Registro de Personal exitoso");
				cbEditar.addItem(nombre);
				cbEliminar.addItem(nombre);
				
			}else {
				JOptionPane.showMessageDialog(btnAgregar,"Inserte los datos correspondientes");
		}
				if(flagRepetido==true) {
				JOptionPane.showMessageDialog(btnAgregar,"Este personal ya está registrado");}
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
		
		posY+=60;
		
		this.add(lblSelectHospital);
		this.add(cbHospital);
		this.add(lblAgregar);
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
		this.add(lblPuesto);
		this.add(cbPuesto);
		this.add(lblArea);
		this.add(cbArea);
		this.add(btnAgregar);
		this.add(btnCancelar);
		
		
		//EDITAR PERSONAL
		
		posY=10;
		
		lblEditar = new JLabel("Editar");
		lblEditar.setBounds(610,posY,100,30);
		
		posY+=40;
		
		lblSeleccionarEd = new JLabel("Seleccionar personal:");
		lblSeleccionarEd.setBounds(610,posY,150,30);
		
		cbEditar = new JComboBox<>();
		cbEditar.setBounds(760,posY,200,30);
		cbEditar.addItem("Seleccionar personal --");
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(970,posY,100,30);
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sexo="";
				String area="";
				String puesto="";
				int idSexo=0;
				int idPuesto=0;
				int idArea=0;
				if(cbEditar.getSelectedIndex()!=0) {
					
					nombreViejo=(String) cbEditar.getSelectedItem();
					
					txtEdNombre.setText((String) cbEditar.getSelectedItem());
					ResultSet registrosSeleccionado=(ResultSet)data.getQuery("SELECT * FROM Personal where nombre= '"+nombreViejo+"';");
					try {
						while(registrosSeleccionado.next()) {
							
							txtEdAp.setText(registrosSeleccionado.getString("apellidoPaterno"));
							txtEdAm.setText(registrosSeleccionado.getString("apellidoMaterno"));
							txtEdDireccion.setText(registrosSeleccionado.getString("direccion"));
							txtEdTel.setText(registrosSeleccionado.getString("telefono"));
							txtEdFechaNac.setText(registrosSeleccionado.getString("FechaNacimiento"));
							idSexo=registrosSeleccionado.getInt("idSexo");
							idPuesto=registrosSeleccionado.getInt("idTipoPuesto");
							idArea=registrosSeleccionado.getInt("idArea");
						
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ResultSet regSexo=(ResultSet)data.getQuery("SELECT * FROM Sexo where idSexo= '"+idSexo+"';");
					try {
						while(regSexo.next()) {
							cbEdSexo.setSelectedItem(regSexo.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ResultSet regPuesto=(ResultSet)data.getQuery("SELECT * FROM TipoPuesto where idTipoPuesto= '"+idPuesto+"';");
					try {
						while(regPuesto.next()) {
							cbEdPuesto.setSelectedItem(regPuesto.getString("puesto"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ResultSet regArea=(ResultSet)data.getQuery("SELECT * FROM _Area where idArea= '"+idArea+"';");
					try {
						while(regArea.next()) {
							cbEdArea.setSelectedItem(regArea.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else {
						
					}
				
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
		
		txtEdFechaNac = new JTextField("YYYY-MM-DD");
		txtEdFechaNac.setBounds(750,posY,100,30);
		
		posY+=40;
		
		lblEdSexo = new JLabel("Sexo:");
		lblEdSexo.setBounds(610,posY,100,30);
		
		cbEdSexo = new JComboBox<>();
		cbEdSexo.setBounds(670,posY,150,30);
		cbEdSexo.addItem("Seleccionar sexo --");
		
		posY+=40;
		
		lblEdPuesto = new JLabel("Seleccionar puesto:");
		lblEdPuesto.setBounds(610,posY,200,30);
		
		cbEdPuesto = new JComboBox<>();
		cbEdPuesto.setBounds(770,posY,200,30);
		cbEdPuesto.addItem("Seleccionar puesto --");
		
		posY+=40;
		
		lblEdArea = new JLabel("Área:");
		lblEdArea.setBounds(610,posY,70,30);
		
		cbEdArea = new JComboBox<>();
		cbEdArea.setBounds(680,posY,290,30);
		cbEdArea.addItem("Seleccionar área --");
		
		posY+=40;
		
		btnGuardarEdicion = new JButton("Guardar");
		btnGuardarEdicion.setBounds(610,posY,100,30);
		btnGuardarEdicion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int idSexo=0;
				int idPuesto=0;
				int idArea=0;
				String nombreNuevo=txtEdNombre.getText();
				String apNuevo=txtEdAp.getText();
				String amNuevo=txtEdAm.getText();
				String direccionNuevo=txtEdDireccion.getText();
				String telefonoNuevo=txtEdTel.getText();
				String fechaNacNuevo=txtEdFechaNac.getText();
				String areaNuevo=(String) cbEdArea.getSelectedItem();
				String PuestoNuevo=(String) cbEdPuesto.getSelectedItem();
				String SexoNuevo=(String) cbEdSexo.getSelectedItem();
				System.out.println(nombreNuevo);
				
				ResultSet regSexo=(ResultSet) data.getQuery("select *from Sexo where nombre='"+SexoNuevo+"';");
				try {
					while(regSexo.next()) {
						idSexo=regSexo.getInt("idSexo");
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				ResultSet regPuesto=(ResultSet) data.getQuery("select *from TipoPuesto where puesto='"+PuestoNuevo+"';");
				try {
					while(regPuesto.next()) {
						idPuesto=regPuesto.getInt("idTipoPuesto");
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				ResultSet regArea=(ResultSet) data.getQuery("select *from _Area where nombre='"+areaNuevo+"';");
				try {
					while(regArea.next()) {
						idArea=regArea.getInt("idArea");
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(cbEditar.getSelectedIndex()!=0) {
					data.setQuery("UPDATE Personal SET nombre = '"+nombreNuevo+"',apellidoPaterno ='"+apNuevo+"',apellidoMaterno='"+amNuevo+"', direccion='"+direccionNuevo+"',telefono='"+telefonoNuevo+"', fechaNacimiento='"+fechaNacNuevo+"',idSexo='"+idSexo+"',idTipoPuesto='"+idPuesto+"',idArea='"+idArea+"' WHERE nombre='"+nombreViejo+"'");
					
					txtEdNombre.setText("");
					txtEdAp.setText("");
					txtEdAm.setText("");
					txtEdDireccion.setText("");
					txtEdTel.setText("");
					txtEdFechaNac.setText("");
					cbEdArea.setSelectedIndex(0);
					cbEdPuesto.setSelectedIndex(0);
					cbEdSexo.setSelectedIndex(0);
					
					JOptionPane.showMessageDialog(btnGuardarEdicion,"Edición exitosa");
					cbEliminar.removeAllItems();
					cbEditar.removeAllItems();
					cbEliminar.addItem("Seleccione Personal...");
					cbEditar.addItem("Seleccione Personal...");
					ResultSet registrosArea=(ResultSet)data.getQuery("SELECT * FROM Personal where idHospital= '"+idHospital+"';");
					
					try {
						while(registrosArea.next()) {
							
							cbEliminar.addItem(registrosArea.getString("nombre"));
							cbEditar.addItem(registrosArea.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else {
						
					}
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
		
		
		posY+=40;
		
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
		this.add(lblEdPuesto);
		this.add(cbEdPuesto);
		this.add(btnEditar);
		this.add(lblEdArea);
		this.add(cbEdArea);
		this.add(btnGuardarEdicion);
		this.add(btnCancelarEdicion);
		
		posY=510;
		//ELIMINAR
		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(10,posY,100,30);
		
		posY+=40;
		
		lblSeleccionarEl = new JLabel("Seleccionar personal:");
		lblSeleccionarEl.setBounds(10,posY,200,30);
		
		cbEliminar = new JComboBox<>();
		cbEliminar.setBounds(220,posY,200,30);
		cbEliminar.addItem("Seleccionar personal --");
		
		posY+=40;
		
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(10,posY,100,30);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbEliminar.getSelectedIndex()!=0) {
					String eliminar=((String) cbEliminar.getSelectedItem());
					System.out.println(eliminar);
					data.setQuery("DELETE FROM Personal WHERE nombre='"+eliminar+"'");
					cbEliminar.removeAllItems();
					cbEditar.removeAllItems();
					cbEliminar.addItem("Seleccione personal...");
					cbEditar.addItem("Seleccione personal...");
					JOptionPane.showMessageDialog(btnEliminar,"Eliminación exitosa");
					registros=(ResultSet) data.getQuery("Select * from Personal where idHospital='"+idHospital+"';");
					try {
						while(registros.next()) {
							
							cbEliminar.addItem(registros.getString("nombre"));
							cbEditar.addItem(registros.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else {
						
					}
			}
		});
		registrosSexo=(ResultSet)data.getQuery("SELECT * FROM Sexo;");
		
		try {
			while(registrosSexo.next()) {
				System.out.println("sin entro");
				cbSexo.addItem(registrosSexo.getString("nombre"));
				cbEdSexo.addItem(registrosSexo.getString("nombre"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	registrosPuesto=(ResultSet)data.getQuery("SELECT * FROM TipoPuesto;");
		
		try {
			while(registrosPuesto.next()) {
				System.out.println("sin entro");
				cbPuesto.addItem(registrosPuesto.getString("puesto"));
				cbEdPuesto.addItem(registrosPuesto.getString("puesto"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.add(lblEliminar);
		this.add(lblSeleccionarEl);
		this.add(cbEliminar);
		this.add(btnEliminar);
		this.add(btnSelHospital);
	}
}
