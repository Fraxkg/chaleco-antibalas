import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelReceta extends JPanel{
	
	private int posY=10;
	private JComboBox<String> cbHospital;
	private JLabel lblSelectHospital;
	int idMed1=0;
	int idMed2=0;
	int idMed3=0;
	private JLabel lblAgregar, lblSelecCita, lblFolio, lblMedicamentos, lblEditar, lblEdSelecCita, lblEdMedicamentos, lblSeleccionarReceta, lblEdFolio,lblEliminar, lblSelecElCita, lblSelecElReceta, lblElReceta, lblM1, lblM2, lblM3, lblEdM1, lblEdM2, lblEdM3;
	private JButton btnAgregar, btnCancelar, btnEditar, btnGuardar, btnEdCancelar, btnEliminar, btnMasMedi,btnSelHospital;
	private JComboBox<String> cbCitas, cbM1,cbM2, cbM3, cbEdCitas, cbEdM1, cbEdM2, cbEdM3, cbEliminar, cbSelecElCita;
	 MySQLConnect data;
	 int idHospital=0;
	 int recetaF=0;
	 ResultSet registros=null;
	 ResultSet registrosSexo=null;
	 ResultSet registrosPuesto=null;
	ResultSet registrosHospital=null;
	String folioViejo;
	int idRecetaVieja=0;
	public PanelReceta(){
		
		this.setLayout(null);
		this.setSize(1200,700);
		
		lblSelectHospital = new JLabel("Seleccionar hospital:");
		lblSelectHospital.setBounds(10,posY,150,30);
		data= new MySQLConnect();
		data.MySQLConnect();
		
		
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
				cbCitas.removeAllItems();
				cbEdCitas.removeAllItems();
				cbSelecElCita.removeAllItems();
				cbEliminar.removeAllItems();
				
				cbEdM1.removeAllItems();
				cbEdM2.removeAllItems();
				cbEdM3.removeAllItems();
				cbEdM1.addItem("Seleccione una medicina...");
				cbEdM2.addItem("Seleccione una medicina...");
				cbEdM3.addItem("Seleccione una medicina...");
				
				cbM1.removeAllItems();
				cbM2.removeAllItems();
				cbM3.removeAllItems();
				cbM1.addItem("Seleccione una medicina...");
				cbM2.addItem("Seleccione una medicina...");
				cbM3.addItem("Seleccione una medicina...");
				
				cbCitas.addItem("Seleccione la cita...");
				cbEdCitas.addItem("Seleccione la cita...");
				cbSelecElCita.addItem("Seleccione la cita...");
				cbEliminar.addItem("Seleccione la receta...");
				
				ResultSet Concuerda=(ResultSet)data.getQuery("SELECT * FROM Cita where idHospital= '"+idHospital+"';");
				
				try {
					while(Concuerda.next()) {
						System.out.println("sin entro");
						cbCitas.addItem(Concuerda.getString("folio"));
						cbSelecElCita.addItem(Concuerda.getString("folio"));
						cbEdCitas.addItem(Concuerda.getString("folio"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet ConcuerdaArea=(ResultSet)data.getQuery("SELECT * FROM Medicamento;");
				
				try {
					while(ConcuerdaArea.next()) {
						cbEdM1.addItem(ConcuerdaArea.getString("nombre"));
						cbEdM2.addItem(ConcuerdaArea.getString("nombre"));
						cbEdM3.addItem(ConcuerdaArea.getString("nombre"));
						cbM1.addItem(ConcuerdaArea.getString("nombre"));
						cbM2.addItem(ConcuerdaArea.getString("nombre"));
						cbM3.addItem(ConcuerdaArea.getString("nombre"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet regElimi=(ResultSet) data.getQuery("Select * from Receta");
				try {
					while(regElimi.next()) {
						cbEliminar.addItem(regElimi.getString("folio"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		this.add(btnSelHospital);
		cbHospital = new JComboBox<>();
		cbHospital.setBounds(150, posY, 300,30);
		cbHospital.addItem("Seleccionar hospital --");
		registrosHospital=(ResultSet) data.getQuery("Select * from Hospital");
		try {
			while(registrosHospital.next()) {
				cbHospital.addItem(registrosHospital.getString("nombre"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		posY+=40;
		
		lblAgregar = new JLabel("Agregar");
		lblAgregar.setBounds(10,posY,70,30);
		
		posY+=40;
		
		lblSelecCita = new JLabel("Seleccionar cita:");
		lblSelecCita.setBounds(10,posY,100,30);
		
		cbCitas = new JComboBox<>();
		cbCitas.setBounds(120,posY,300,30);
		cbCitas.addItem("Seleccioanr cita --");
		
		lblFolio = new JLabel("Folio de la receta:");
		lblFolio.setBounds(430,posY,200,30);
		
		posY+=40;
		
		lblMedicamentos = new JLabel("Seleccionar Medicamentos:");
		lblMedicamentos.setBounds(10,posY,180,30);
		
		posY+=40;
		
		lblM1= new JLabel("Medicamento 1:");
		lblM1.setBounds(10,posY,100,30);
		
		cbM1 = new JComboBox<>();
		cbM1.setBounds(120,posY,300,30);
		cbM1.addItem("Seleccionar mediciamento --");
		
		posY+=40;
		
		lblM2= new JLabel("Medicamento 2:");
		lblM2.setBounds(10,posY,100,30);
		
		cbM2 = new JComboBox<>();
		cbM2.setBounds(120,posY,300,30);
		cbM2.addItem("Seleccionar mediciamento --");
		
		posY+=40;
		
		lblM3= new JLabel("Medicamento 3:");
		lblM3.setBounds(10,posY,100,30);
		
		cbM3 = new JComboBox<>();
		cbM3.setBounds(120,posY,300,30);
		cbM3.addItem("Seleccionar mediciamento --");
		
		
		this.add(lblSelectHospital);
		this.add(cbHospital);
		this.add(lblAgregar);
		this.add(lblSelecCita);
		this.add(cbCitas);
		this.add(lblFolio);
		this.add(lblMedicamentos);
		this.add(lblM1);
		this.add(cbM1);
		this.add(lblM2);
		this.add(cbM2);
		this.add(lblM3);
		this.add(cbM3);
		
		
		//EDITAR RECETA
		
		posY+=60;
		
		lblEditar = new JLabel("Editar");
		lblEditar.setBounds(10,posY,100,30);
		
		posY+=40;
		
		lblEdSelecCita = new JLabel("Seleccionar cita:");
		lblEdSelecCita.setBounds(10,posY,100,30);
		
		cbEdCitas = new JComboBox<>();
		cbEdCitas.setBounds(120,posY,300,30);
		cbEdCitas.addItem("Seleccioanr cita --");
		
		lblEdFolio = new JLabel("Folio de la receta:");
		lblEdFolio.setBounds(430,posY,200,30);
		
		posY+=40;
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(10,posY,100,30);
btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int idReceta=0;
				int idCita=0;
			
				if(cbEdCitas.getSelectedIndex()!=0) {
					folioViejo= (String) cbEdCitas.getSelectedItem();
					
					ResultSet regIdReceta=(ResultSet)data.getQuery("SELECT * FROM Cita where folio= '"+folioViejo+"';");
					try {
						while(regIdReceta.next()) {
							
							idCita=regIdReceta.getInt("idCita");
						
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					ResultSet regIdReceta2=(ResultSet)data.getQuery("SELECT * FROM Receta where idCita= '"+idCita+"';");
					try {
						while(regIdReceta2.next()) {
							
							idRecetaVieja=regIdReceta2.getInt("idReceta");
						
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					ResultSet regIdMed=(ResultSet)data.getQuery("SELECT * FROM RecetaMedicamento where idReceta= '"+idReceta+"';");
					try {
						while(regIdMed.next()) {
							
							idMed1=regIdMed.getInt("idRecetaMedicamento");
							System.out.println(idMed1);
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}/*
					ResultSet regMed1=(ResultSet)data.getQuery("SELECT * FROM Medicamento where idMedicamento= '"+idMed1+"';");
					try {
						while(regMed1.next()) {
							cbEdM1.setSelectedItem(regMed1.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ResultSet regMed2=(ResultSet)data.getQuery("SELECT * FROM Medicamento where idMedicamento= '"+idMed2+"';");
					try {
						while(regMed2.next()) {
							cbEdM2.setSelectedItem(regMed2.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ResultSet regMed3=(ResultSet)data.getQuery("SELECT * FROM Medicamento where idMedicamento= '"+idMed3+"';");
					try {
						while(regMed3.next()) {
							cbEdM3.setSelectedItem(regMed3.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
					
				}
					
				}
			});
				this.add(btnEditar);
		posY+=40;
		
		lblEdMedicamentos = new JLabel("Seleccionar Medicamentos:");
		lblEdMedicamentos.setBounds(10,posY,180,30);
		
		posY+=40;
		
		lblEdM1= new JLabel("Medicamento 1:");
		lblEdM1.setBounds(10,posY,100,30);
		
		cbEdM1 = new JComboBox<>();
		cbEdM1.setBounds(120,posY,300,30);
		cbEdM1.addItem("Seleccionar mediciamento --");
		
		posY+=40;
		
		lblEdM2= new JLabel("Medicamento 2:");
		lblEdM2.setBounds(10,posY,100,30);
		
		cbEdM2 = new JComboBox<>();
		cbEdM2.setBounds(120,posY,300,30);
		cbEdM2.addItem("Seleccionar mediciamento --");
		
		posY+=40;
		
		lblEdM3= new JLabel("Medicamento 3:");
		lblEdM3.setBounds(10,posY,100,30);
		
		cbEdM3 = new JComboBox<>();
		cbEdM3.setBounds(120,posY,300,30);
		cbEdM3.addItem("Seleccionar mediciamento --");
		
		posY+=40;
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10,posY,100,30);
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				
				
				
				String med1new=(String) cbEdM1.getSelectedItem();
				String med2new=(String) cbEdM3.getSelectedItem();
				String med3new=(String) cbEdM2.getSelectedItem();
				
				int idMed1=0;
				int idMed2=2;
				int idMed3=3;
				ResultSet regMed1=(ResultSet) data.getQuery("select *from Medicamento where nombre='"+med1new+"';");
				try {
					while(regMed1.next()) {
						idMed1=regMed1.getInt("idMedicamento");
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				ResultSet regMed2=(ResultSet) data.getQuery("select *from Medicamento where nombre='"+med2new+"';");
				try {
					while(regMed2.next()) {
						idMed2=regMed2.getInt("idMedicamento");
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				ResultSet regMed3=(ResultSet) data.getQuery("select *from Medicamento where nombre='"+med3new+"';");
				try {
					while(regMed1.next()) {
						idMed3=regMed3.getInt("idMedicamento");
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				if(cbEdCitas.getSelectedIndex()!=0) {  
					data.setQuery("UPDATE RecetaMedicamento SET idMedicamento= '"+idMed1+"' WHERE idReceta='"+idRecetaVieja+"'");
					
				
					
					JOptionPane.showMessageDialog(btnGuardar,"Edición exitosa");
				}	
			}
		});
		
		btnEdCancelar = new JButton("Cancelar");
		btnEdCancelar.setBounds(120,posY,100,30);
		
		this.add(lblEditar);
		this.add(lblEdSelecCita);
		this.add(cbEdCitas);
		this.add(lblEdFolio);
		this.add(btnEditar);
		this.add(lblEdMedicamentos);
		this.add(lblEdM1);
		this.add(cbEdM1);
		this.add(lblEdM2);
		this.add(cbEdM2);
		this.add(lblEdM3);
		this.add(cbEdM3);
		this.add(btnGuardar);
		this.add(btnEdCancelar);
		
		//ELIMINAR RECETA
		
		posY=50;
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(420,posY,100,30);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				registros=(ResultSet) data.getQuery("Select * from Receta");
				registrosHospital=(ResultSet) data.getQuery("Select * from Hospital");
				boolean flagRepetido=false;
				//guarda el texto insertado en una variable
			
				//guardo la opcion del hospital elegido en una varibale
				String citaElegido=(String) cbCitas.getSelectedItem();
				String medElegido1=(String) cbM1.getSelectedItem();
				String medElegido2=(String) cbM2.getSelectedItem();
				String medElegido3=(String) cbM3.getSelectedItem();
				int idCita=0;
				int idMed1=0;
				int idMed2=0;
				int idMed3=0;
				int idReceta=0;
				/// este ciclo de los registros de area sirve para comprobar que no se repita la misma area en el mismo hospital
				
				
				ResultSet obtenerCita=(ResultSet)data.getQuery("SELECT * FROM Cita where folio= '"+citaElegido+"';");
				
				try {
					while(obtenerCita.next()) {
						idCita=obtenerCita.getInt("idCita");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ResultSet obtenerMed1=(ResultSet)data.getQuery("SELECT * FROM Medicamento where nombre= '"+medElegido1+"';");
				
				try {
					while(obtenerMed1.next()) {
						idMed1=obtenerMed1.getInt("idMedicamento");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
ResultSet obtenerMed2=(ResultSet)data.getQuery("SELECT * FROM Medicamento where nombre= '"+medElegido2+"';");
				
				try {
					while(obtenerMed2.next()) {
						idMed2=obtenerMed2.getInt("idMedicamento");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
ResultSet obtenerMed3=(ResultSet)data.getQuery("SELECT * FROM Medicamento where nombre= '"+medElegido3+"';");
				
				try {
					while(obtenerMed3.next()) {
						idMed3=obtenerMed3.getInt("idMedicamento");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				int i=0;
				ResultSet recetaFr=data.getQuery(" select * from receta;");
				try {
					while(recetaFr.next()) {
						i++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				recetaF=i+1;
				String recetaFolio=Integer.toString(recetaF);
				data.setQuery("INSERT INTO Receta (IdReceta, idCita, folio) VALUES (NULL, '"+idCita+"','"+recetaFolio+"');");
				JOptionPane.showMessageDialog(btnAgregar,"Registro de Receta exitoso");
				
				ResultSet regReceta=(ResultSet)data.getQuery("SELECT * FROM Receta where idCita='"+idCita+"' ;");
				try {
					while(regReceta.next()) {
						idReceta=regReceta.getInt("idReceta");
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				data.setQuery("INSERT INTO RecetaMedicamento (IdRecetaMedicamento, idReceta, idMedicamento) VALUES (NULL, '"+idReceta+"','"+idMed1+"');");
				data.setQuery("INSERT INTO RecetaMedicamento (IdRecetaMedicamento, idReceta, idMedicamento) VALUES (NULL, '"+idReceta+"','"+idMed2+"');");
				data.setQuery("INSERT INTO RecetaMedicamento (IdRecetaMedicamento, idReceta, idMedicamento) VALUES (NULL, '"+idReceta+"','"+idMed3+"');");
				
				ResultSet registrosInterno=(ResultSet)data.getQuery("SELECT * FROM Receta ;");
				try {
					while(registrosInterno.next()) {
						cbEliminar.addItem(registrosInterno.getString("folio"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//cbEliminar.addItem(paciente);
				//cbEditar.addItem(paciente);
			
				
			}
		});
		this.add(btnAgregar);
		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(700,posY,70,30);
		
		posY+=40;
		
		lblSelecElCita = new JLabel("Seleccioanr cita:");
		lblSelecElCita.setBounds(700,posY,100,30);
		
		cbSelecElCita = new JComboBox<>();
		cbSelecElCita.setBounds(830,posY,200,30);
		cbSelecElCita.addItem("Seleccioanr cita --");
		
		posY+=40;
		
		lblSelecElReceta = new JLabel("Seleccionar receta:");
		lblSelecElReceta.setBounds(700,posY,120,30);
		
		cbEliminar = new JComboBox<>();
		cbEliminar.setBounds(830,posY,200,30);
		cbEliminar.addItem("Seleccionar folio receta --");
		
		posY+=40;
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(700,posY,100,30);
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbEliminar.getSelectedIndex()!=0) {
					String eliminar=((String) cbEliminar.getSelectedItem());
					System.out.println(eliminar);
					data.setQuery("DELETE FROM Receta WHERE folio='"+eliminar+"'");
					cbEliminar.removeAllItems();
					
					cbEliminar.addItem("Seleccione receta...");
					
					JOptionPane.showMessageDialog(btnEliminar,"Eliminación exitosa");
					registros=(ResultSet) data.getQuery("Select * from receta;");
					try {
						while(registros.next()) {
							
							cbEliminar.addItem(registros.getString("folio"));
							
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
		this.add(lblSelecElCita);
		this.add(cbSelecElCita);
		this.add(lblSelecElReceta);
		this.add(cbEliminar);
		this.add(btnEliminar);
		
		
	}
}
