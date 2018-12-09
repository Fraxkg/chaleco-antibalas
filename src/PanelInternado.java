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

public class PanelInternado extends JPanel{

	private int posY=10;
	private JButton btnAgregar,btnCancelar, btnEditar, btnGuardarE, btnEliminar, btnSelHospital;
	private JLabel lblHospital, lblArea, lblCama, lblPaciente, lblSeleccionarEd, lblEdHospital, lblEdArea, lblEdCama, lblEdPaciente, lblAgregar, lblEditar, lblSeleccionarEl, lblEliminar;
	private JComboBox<String> cbHospital, cbArea, cbCama, cbPaciente, cbEditar, cbEdHospital,cbEdArea,cbEdCama,cbEdPaciente, cbEliminar;
	MySQLConnect data;
	ResultSet registros=null;
	 ResultSet registrosSexo=null;
	 ResultSet registrosPuesto=null;
	ResultSet registrosHospital=null;
	int idHospital=0;
	public PanelInternado(){
		this.setLayout(null);
		this.setSize(1200,700);
		
		data= new MySQLConnect();
		data.MySQLConnect();
		registrosHospital=(ResultSet) data.getQuery("Select * from Hospital;");
		lblHospital = new JLabel("Hospital:");
		lblHospital.setBounds(10,posY,70,30);
		
		cbHospital = new JComboBox<>();
		cbHospital.setBounds(80, posY, 230, 30);
		cbHospital.addItem("Seleccionar hospital --");
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
				ResultSet registrosIdHospital=(ResultSet)data.getQuery("SELECT * FROM Hospital where nombre= '"+HospitalSel+"';");
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
				cbEditar.addItem("Seleccione un interno...");
				cbEliminar.addItem("Seleccione un interno...");
				cbPaciente.removeAllItems();
				cbPaciente.addItem("Seleccione un paciente...");
				
				ResultSet Concuerda=(ResultSet)data.getQuery("SELECT * FROM Interno where idHospital= '"+idHospital+"';");
				
				try {
					while(Concuerda.next()) {
						System.out.println("sin entro");
						cbEditar.addItem(Concuerda.getString("idInterno"));
						cbEliminar.addItem(Concuerda.getString("idInterno"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet ConcuerdaPaciente=(ResultSet)data.getQuery("SELECT * FROM Paciente where idHospital= '"+idHospital+"';");
				
				try {
					while(ConcuerdaPaciente.next()) {
						System.out.println("sin entro");
						cbPaciente.addItem(ConcuerdaPaciente.getString("nombre"));
						cbEdPaciente.addItem(ConcuerdaPaciente.getString("nombre"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				ResultSet ConcuerdaArena=(ResultSet)data.getQuery("SELECT * FROM _Area where idHospital= '"+idHospital+"';");
				
				try {
					while(ConcuerdaArena.next()) {
						System.out.println("sin entro");
						cbArea.addItem(ConcuerdaArena.getString("nombre"));
						cbEdArea.addItem(ConcuerdaArena.getString("nombre"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet registrosInterno=(ResultSet) data.getQuery("Select * from Interno where idHospital='"+idHospital+"';");
				try {
					while(registrosInterno.next()) {
						int id=registrosInterno.getInt("idInterno");
						String idPa=Integer.toString(id);
						cbEditar.addItem(idPa);
						cbEliminar.addItem(idPa);
						System.out.println(idPa);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		this.add(btnSelHospital);
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
				registros=(ResultSet) data.getQuery("Select * from Interno");
				registrosHospital=(ResultSet) data.getQuery("Select * from Hospital");
				boolean flagRepetido=false;
				//guarda el texto insertado en una variable
			
				//guardo la opcion del hospital elegido en una varibale
				String hospitalElegido=(String) cbHospital.getSelectedItem();
				String area=(String) cbArea.getSelectedItem();
				String paciente=(String) cbPaciente.getSelectedItem();
				int idArea=0;
			
				int idPaciente=0;
				
				/// este ciclo de los registros de area sirve para comprobar que no se repita la misma area en el mismo hospital
				try {
					while(registros.next()) {
						String prueba=registros.getString("nombre");
						int prueba2=registros.getInt("idHospital");
						
						if(paciente.equals(prueba)&&idHospital==prueba2) {
							
							flagRepetido=true;
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ResultSet obtenerArea=(ResultSet)data.getQuery("SELECT * FROM _Area where idHospital= '"+idHospital+"';");
				
				try {
					while(obtenerArea.next()) {
						idArea=obtenerArea.getInt("idArea");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ResultSet obtenerPaciente=(ResultSet)data.getQuery("SELECT * FROM Paciente where idHospital= '"+idHospital+"';");
				
				try {
					while(obtenerPaciente.next()) {
						idPaciente=obtenerPaciente.getInt("idPaciente");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					System.out.println(idHospital);
				data.setQuery("INSERT INTO Interno (idInterno, idArea, idHospital, idPaciente) VALUES (NULL, '"+idArea+"','"+idHospital+"','"+idPaciente+"');");
				JOptionPane.showMessageDialog(btnAgregar,"Registro de interno exitoso");
				
				ResultSet registrosInterno=(ResultSet)data.getQuery("SELECT * FROM Interno ;");
				try {
					while(registrosInterno.next()) {
						cbEliminar.addItem(registrosInterno.getString("idInterno"));
						cbEditar.addItem(registrosInterno.getString("idInterno"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//cbEliminar.addItem(paciente);
				//cbEditar.addItem(paciente);
			
				
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
				String paciente="";
				String area="";
				int internoViejo=0;
				
				int idArea=0;
				int idPaciente=0;
				if(cbEditar.getSelectedIndex()!=0) {
					
					internoViejo=Integer.parseInt( (String) cbEditar.getSelectedItem());
					
					
					
					ResultSet registrosSeleccionado=(ResultSet)data.getQuery("SELECT * FROM Interno where idInterno= '"+internoViejo+"';");
					try {
						while(registrosSeleccionado.next()) {
						
							idArea=registrosSeleccionado.getInt("idArea");
							idPaciente=registrosSeleccionado.getInt("idPaciente");
						
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
					ResultSet regArea=(ResultSet)data.getQuery("SELECT * FROM _Area where idArea= '"+idArea+"';");
					try {
						while(regArea.next()) {
							cbEdArea.setSelectedItem(regArea.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		posY+=40;
		
		lblEdArea = new JLabel("Área:");
		lblEdArea.setBounds(10,posY,100,30);
		
		cbEdArea = new JComboBox<>();
		cbEdArea.setBounds(70,posY,200,30);
		cbEdArea.addItem("Seleccionar área --");
		
		
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
				int idArea=0;
				int idPaciente=0;
				String edit=((String) cbEditar.getSelectedItem());
				int edito=Integer.parseInt(edit);
				ResultSet registrosSeleccionado=(ResultSet)data.getQuery("SELECT * FROM Interno where idInterno= '"+edito+"';");
				try {
					while(registrosSeleccionado.next()) {
					
						idArea=registrosSeleccionado.getInt("idArea");
						idPaciente=registrosSeleccionado.getInt("idPaciente");
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(cbEditar.getSelectedIndex()!=0) {  
					data.setQuery("UPDATE Interno SET idArea = '"+idArea+"',idPaciente='"+idPaciente+"' WHERE idInterno='"+edito+"'");
					
				
					cbEliminar.setSelectedIndex(0);
					
					JOptionPane.showMessageDialog(btnGuardarE,"Edición exitosa");
					cbEliminar.removeAllItems();
					cbEditar.removeAllItems();
					cbEliminar.addItem("Seleccione interno...");
					cbEditar.addItem("Seleccione interno...");
					ResultSet registrosArea=(ResultSet)data.getQuery("SELECT * FROM Interno where idHospital= '"+idHospital+"';");
					
					try {
						while(registrosArea.next()) {
							
							cbEliminar.addItem(registrosArea.getString("idInterno"));
							cbEditar.addItem(registrosArea.getString("idinterno"));
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
		this.add(cbEditar);
		this.add(btnEditar);
		this.add(lblEdArea);
		this.add(cbEdArea);
	
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
				if(cbEliminar.getSelectedIndex()!=0) {
					String eliminar=((String) cbEliminar.getSelectedItem());
					int eli=Integer.parseInt(eliminar);
					System.out.println(eliminar);
					data.setQuery("DELETE FROM Interno WHERE idInterno='"+eli+"'");
					cbEliminar.removeAllItems();
					cbEditar.removeAllItems();
					cbEliminar.addItem("Seleccione un interno...");
					cbEditar.addItem("Seleccione un interno...");
					JOptionPane.showMessageDialog(btnEliminar,"Eliminación exitosa");
					registros=(ResultSet) data.getQuery("Select * from Interno where idHospital='"+idHospital+"';");
					try {
						while(registros.next()) {
							
							cbEliminar.addItem(registros.getString("idInterno"));
							cbEditar.addItem(registros.getString("idInterno"));
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
