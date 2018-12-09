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

public class PanelCita extends JPanel{

	private int posY=10;
	private JComboBox<String> cbHospital;
	private JLabel lblSelectHospital;
	MySQLConnect data;
	 ResultSet registros=null;
	 ResultSet registrosSexo=null;
	 ResultSet registrosPuesto=null;
	ResultSet registrosHospital=null;
	int idHospital=0;
	//Controles Agergar
			private JLabel lblAgregar,lblFecha, lblFolio, lblPaciente, lblPersonal;
			private JTextField txtFecha, txtFolio;
			private JComboBox<String> cbPaciente, cbPersonal;
			private JButton btnAgregar, btnCancelar,btnSelHospital;
			
			//Conteoles Editar
			private JLabel lblEditar, lblSeleccionarEd,lblEdFecha, lblEdFolio, lblEdPaciente, lblEdPersonal;
			private JTextField txtEdFecha, txtEdFolio;
			private JComboBox<String> cbEditar,cbEdPaciente, cbEdPersonal;
			private JButton btnEditar, btnGuardarEdicion, btnCancelarEdicion;
			
			//Controles Eliminar
			private JLabel lblEliminar, lblSeleccionarEl;
			private JComboBox<String> cbEliminar;
			private JButton btnEliminar;
			String folioViejo;
			
			public PanelCita(){
				
				this.setLayout(null);
				this.setSize(1200,700);
				data= new MySQLConnect();
				data.MySQLConnect();
				registrosHospital=(ResultSet) data.getQuery("Select * from Hospital");
				lblSelectHospital = new JLabel("Seleccionar hospital:");
				lblSelectHospital.setBounds(10,posY,150,30);
				
				cbHospital = new JComboBox<>();
				cbHospital.setBounds(150, posY, 300,30);
				cbHospital.addItem("Seleccionar hospital --");
				
				posY+=40;
				
				//AGREGAR CITA
				
				lblAgregar = new JLabel("Agregar");
				lblAgregar.setBounds(10,posY,100,30);
				try {
					while(registrosHospital.next()) {
						cbHospital.addItem(registrosHospital.getString("nombre"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				posY+=40;
				
				lblFecha = new JLabel("Fecha:");
				lblFecha.setBounds(10,posY,100,30);
				
				txtFecha = new JTextField();
				txtFecha.setBounds(70,posY,300,30);
				btnSelHospital = new JButton("Seleccionar");
				btnSelHospital.setBounds(460,10,120,30);
				
				btnSelHospital.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String HospitalSel=(String) cbHospital.getSelectedItem();
						String doctor="Doctor";
						int idPuesto=0;
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
						cbEdPaciente.removeAllItems();
						cbEdPersonal.removeAllItems();
						cbPersonal.removeAllItems();
						cbPaciente.removeAllItems();
						cbEditar.addItem("Seleccione una cita...");
						cbEliminar.addItem("Seleccione una cita...");
						cbEdPaciente.addItem("Seleccione un paciente...");
						cbEdPersonal.addItem("Seleccione un doctor...");
						cbPaciente.addItem("Seleccione un paciente...");
						cbPersonal.addItem("Seleccione un doctor...");
						
						System.out.println(idHospital);
						ResultSet registros=(ResultSet)data.getQuery("SELECT * FROM TipoPuesto where puesto='"+doctor+"';");
						
						try {
							while(registros.next()) {
								System.out.println("sin entro");
								idPuesto=registros.getInt("idTipoPuesto");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ResultSet obtenerDoctores=(ResultSet)data.getQuery("SELECT * FROM Personal where idHospital= '"+idHospital+"'and idTipoPuesto='"+idPuesto+"';");
						
						try {
							while(obtenerDoctores.next()) {
								System.out.println("sin entro");
								cbPersonal.addItem(obtenerDoctores.getString("nombre"));
								cbEdPersonal.addItem(obtenerDoctores.getString("nombre"));
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						ResultSet ConcuerdaPaciente=(ResultSet)data.getQuery("SELECT * FROM Paciente where idHospital= '"+idHospital+"';");
						
						try {
							while(ConcuerdaPaciente.next()) {
								System.out.println("sin entro");
								cbEdPaciente.addItem(ConcuerdaPaciente.getString("nombre"));
								cbPaciente.addItem(ConcuerdaPaciente.getString("nombre"));
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ResultSet regCitas=(ResultSet)data.getQuery("SELECT * FROM Cita where idHospital= '"+idHospital+"';");
						
						try {
							while(regCitas.next()) {
								System.out.println("sin entro");
								String cita=regCitas.getString("folio");
								
								cbEditar.addItem(cita);
								cbEliminar.addItem(cita);
								
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				this.add(btnSelHospital);
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
						registros=(ResultSet) data.getQuery("Select * from Cita");
						registrosHospital=(ResultSet) data.getQuery("Select * from Hospital");
						boolean flagRepetido=false;
						//guarda el texto insertado en una variable
						String fecha=txtFecha.getText();
						String folio=txtFolio.getText();
						String paciente=(String) cbPaciente.getSelectedItem();
						String doctor=(String) cbPersonal.getSelectedItem();
						
						int idDoctor=0;
						int idPaciente=0;
						
						//int =(int) cbSexo.getSelectedItem();
						//guardo la opcion del hospital elegido en una varibale
						String hospitalElegido=(String) cbHospital.getSelectedItem();
						//inicializo el id del hospital que se agregará a area
						
				
						try {
							while(registros.next()) {
								String prueba=registros.getString("folio");
								int prueba2=registros.getInt("idHospital");
								
								if(folio.equals(prueba)&&idHospital==prueba2) {
									
									flagRepetido=true;
								}
								
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ResultSet obtenerPaciente=(ResultSet)data.getQuery("SELECT * FROM Paciente where nombre= '"+paciente+"';");
						
						try {
							while(obtenerPaciente.next()) {
								idPaciente=obtenerPaciente.getInt("idPaciente");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ResultSet obtenerPersonal=(ResultSet)data.getQuery("SELECT * FROM Personal where nombre= '"+doctor+"';");
						
						try {
							while(obtenerPersonal.next()) {
								idDoctor=obtenerPersonal.getInt("idPersonal");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						//aqui se valida que si el campo no esta vacio y no esta repetido insertara la informacion moxxita
						if(txtFolio.getText().isEmpty()!=true && flagRepetido==false) {
							
						data.setQuery("INSERT INTO Cita (idCita,fecha,folio,idPaciente,idPersonal, idHospital)"
								+ " VALUES (NULL, '"+fecha+"','"+folio+"','"+idPaciente+"','"+idDoctor+"','"+idHospital+"');");
						JOptionPane.showMessageDialog(btnAgregar,"Registro de Cita exitoso");
						cbEditar.addItem(folio);
						cbEliminar.addItem(folio);
						
					}else {
						JOptionPane.showMessageDialog(btnAgregar,"Inserte los datos correspondientes");
				}
						if(flagRepetido==true) {
						JOptionPane.showMessageDialog(btnAgregar,"Esta cita ya está registrado");}
					
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
						
						String doctor="";
						String paciente="";
						int idDoctor=0;
						int idPaciente=0;
						if(cbEditar.getSelectedIndex()!=0) {
							
							folioViejo=(String) cbEditar.getSelectedItem();
							
							txtEdFolio.setText((String) cbEditar.getSelectedItem());
							ResultSet registrosSeleccionado=(ResultSet)data.getQuery("SELECT * FROM Cita where folio= '"+folioViejo+"';");
							try {
								while(registrosSeleccionado.next()) {
									
									txtEdFecha.setText(registrosSeleccionado.getString("fecha"));
									idPaciente=registrosSeleccionado.getInt("idPaciente");
									idDoctor=registrosSeleccionado.getInt("idPersonal");
								
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ResultSet regDoctor=(ResultSet)data.getQuery("SELECT * FROM Personal where idPersonal= '"+idDoctor+"';");
							try {
								while(regDoctor.next()) {
									cbEdPersonal.setSelectedItem(regDoctor.getString("nombre"));
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							ResultSet regPaciente=(ResultSet)data.getQuery("SELECT * FROM Paciente where idPaciente= '"+idPaciente+"';");
							try {
								while(regPaciente.next()) {
									cbEdPaciente.setSelectedItem(regPaciente.getString("nombre"));
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
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
				btnGuardarEdicion.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int idPaciente=0;
						int idDoctor=0;
						
						String fecha=txtEdFecha.getText();
						String folio=txtEdFolio.getText();
				
						String pacienteNuevo=(String) cbEdPaciente.getSelectedItem();
						String doctorNuevo=(String) cbEdPersonal.getSelectedItem();
						
						ResultSet regPaciente=(ResultSet) data.getQuery("select *from Paciente where nombre='"+pacienteNuevo+"';");
						try {
							while(regPaciente.next()) {
								idPaciente=regPaciente.getInt("idPaciente");
							}
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						ResultSet regDoctor=(ResultSet) data.getQuery("select *from Personal where nombre='"+doctorNuevo+"';");
						try {
							while(regDoctor.next()) {
								idDoctor=regDoctor.getInt("idPersonal");
							}
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						
						if(cbEditar.getSelectedIndex()!=0) {  
							data.setQuery("UPDATE Cita SET folio = '"+folio+"',fecha ='"+fecha+"',idPaciente='"+idPaciente+"',idPersonal='"+idDoctor+"' WHERE folio='"+folioViejo+"'");
							
							txtEdFolio.setText("");
							txtEdFecha.setText("");
							
							cbEdPersonal.setSelectedIndex(0);
							cbEdPaciente.setSelectedIndex(0);
							JOptionPane.showMessageDialog(btnGuardarEdicion,"Edición exitosa");
							cbEliminar.removeAllItems();
							cbEditar.removeAllItems();
							cbEliminar.addItem("Seleccione Cita...");
							cbEditar.addItem("Seleccione Cita...");
							ResultSet registrosArea=(ResultSet)data.getQuery("SELECT * FROM Cita where idHospital= '"+idHospital+"';");
							
							try {
								while(registrosArea.next()) {
									
									cbEliminar.addItem(registrosArea.getString("folio"));
									cbEditar.addItem(registrosArea.getString("folio"));
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
						if(cbEliminar.getSelectedIndex()!=0) {
							String eliminar=((String) cbEliminar.getSelectedItem());
							System.out.println(eliminar);
							data.setQuery("DELETE FROM Cita WHERE folio='"+eliminar+"'");
							cbEliminar.removeAllItems();
							cbEditar.removeAllItems();
							cbEliminar.addItem("Seleccione Folio de cita...");
							cbEditar.addItem("Seleccione folio de cita...");
							JOptionPane.showMessageDialog(btnEliminar,"Eliminación exitosa");
							registros=(ResultSet) data.getQuery("Select * from Cita where idHospital='"+idHospital+"';");
							try {
								while(registros.next()) {
									
									cbEliminar.addItem(registros.getString("folio"));
									cbEditar.addItem(registros.getString("folio"));
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
				this.add(cbEliminar);
				this.add(btnEliminar);
				
			}
}
