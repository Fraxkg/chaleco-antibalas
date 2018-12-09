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

public class PanelCama extends JPanel{
	
	private int posY=10;
	private JComboBox<String> cbHospital;
	private JLabel lblSelectHospital;
	ResultSet registros=null;
	ResultSet registrosSexo=null;
	ResultSet registrosPuesto=null;
	ResultSet registrosHospital=null;
	int idHospital=0;
	int idArea=0;
	MySQLConnect data;
	
	private JButton btnAgregar,btnCancelar, btnEditar, btnGuardarE, btnEliminar, btnSelHospital;
	private JTextField txtNumero, txtENumero;
	private JLabel lblNumero, lblSeleccionarEd, lblENumero, lblArea, lblAgregar, lblEditar, lblSeleccionarEl, lblEliminar;
	private JComboBox<String> cbArea, cbEdArea, cbElArea;
	
	public PanelCama(){
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
		try {
			while(registrosHospital.next()) {
				cbHospital.addItem(registrosHospital.getString("nombre"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		posY+=40;
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
				cbArea.removeAllItems();
				cbElArea.removeAllItems();
				cbEdArea.removeAllItems();
				cbArea.addItem("Seleccione un Area...");
				cbElArea.addItem("Seleccione un Area...");
				cbEdArea.addItem("Seleccione un Area...");
				
				System.out.println(idHospital);
				ResultSet Concuerda=(ResultSet)data.getQuery("SELECT * FROM _Area where idHospital= '"+idHospital+"';");
				
				try {
					while(Concuerda.next()) {
						System.out.println("sin entro");
						cbArea.addItem(Concuerda.getString("nombre"));
						cbEdArea.addItem(Concuerda.getString("nombre"));
						cbElArea.addItem(Concuerda.getString("nombre"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			

				
			}
		});
		this.add(btnSelHospital);
		//AGREGAR CAMAS
		lblAgregar =  new JLabel("Agregar camas");
		lblAgregar.setBounds(10,posY,200,30);
		
		posY+=40;
		
		lblNumero = new JLabel("Numero de camas:");
		lblNumero.setBounds(10,posY,150,30);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(160, posY, 150, 30);
		
		lblArea = new JLabel("Área:");
		lblArea.setBounds(320,posY,50,30);
		
		cbArea = new JComboBox<>();
		cbArea.setBounds(380,posY,300,30);
		cbArea.addItem("Seleccionar área --");
		
		posY+=40;
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10,posY,100,30);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				registros=(ResultSet) data.getQuery("Select * from HospitalArea");
				int idArea=0;
				boolean flagRepetido=false;
				String camas=txtNumero.getText();
				String AreaSel=(String) cbArea.getSelectedItem();
				if(!camas.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(btnAgregar,"La cantidad de camas es incorrecta");
				}else {
					
					if(txtNumero.getText().isEmpty()!=true ) {
						
						ResultSet obteneridArea=(ResultSet)data.getQuery("SELECT * FROM _Area where nombre= '"+AreaSel+"';");
						
						try {
							while(obteneridArea.next()) {
								idArea=obteneridArea.getInt("idArea");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							data.setQuery("INSERT INTO HospitalArea (idHospitalArea, noCamas, idArea,idHospital) VALUES (NULL,'"+camas+"','"+idArea+"','"+idHospital+"');");
							JOptionPane.showMessageDialog(btnAgregar,"Registro de camas exitoso");
							
							
						
							if(flagRepetido==true) {
							JOptionPane.showMessageDialog(btnAgregar,"Esta Area ya tiene camas asignadas");}
							
						}else {
							JOptionPane.showMessageDialog(btnAgregar,"Llene los campos correctamente");
						}
					}
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
		
		this.add(lblSelectHospital);
		this.add(cbHospital);
		this.add(lblAgregar);
		this.add(lblNumero);
		this.add(txtNumero);
		this.add(lblArea);
		this.add(cbArea);
		this.add(btnAgregar);
		this.add(btnCancelar);
		
		//EDITAR CAMAS
		
		posY+=60;
		
		lblEditar = new JLabel("Editar numero de camas");
		lblEditar.setBounds(10, posY,150,30);
		
		posY+=40;
		
		lblSeleccionarEd = new JLabel("Seleccionar Área:");
		lblSeleccionarEd.setBounds(10,posY,200,30);
		
		cbEdArea = new JComboBox<>();
		cbEdArea.setBounds(140,posY,240,30);
		cbEdArea.addItem("Seleccionar área --");
		
		btnEditar =  new JButton("Editar");
		btnEditar.setBounds(390,posY,100,30);
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbEdArea.getSelectedIndex()!=0) {
					
					double camasP;
					String camas="";
					String nombreArea=(String)cbEdArea.getSelectedItem();
					ResultSet registrosCamas=(ResultSet) data.getQuery("Select * from _Area where nombre='"+nombreArea+"';");
					try {
						while(registrosCamas.next()) {
							idArea=registrosCamas.getInt("idArea");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ResultSet registroshospitalArea=(ResultSet) data.getQuery("Select * from HospitalArea where idArea='"+idArea+"';");
					try {
						while(registroshospitalArea.next()) {
							txtENumero.setText(registroshospitalArea.getString("noCamas"));
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
		
		lblENumero = new JLabel("Numero:");
		lblENumero.setBounds(10,posY,100,30);
		
		txtENumero = new JTextField();
		txtENumero.setBounds(140,posY,50,30);
		
		btnGuardarE = new JButton("Guardar Edición");
		btnGuardarE.setBounds(200,posY,150,30);
		btnGuardarE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				String camaNuevo=txtENumero.getText();
				if(!camaNuevo.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(btnGuardarE,"La cantidad de camas es incorrecta");
				}else {
				double camasNuevoNew = Double.parseDouble(camaNuevo);
				data.setQuery("UPDATE HospitalArea SET noCamas='"+camasNuevoNew+"' WHERE idArea='"+idArea+"'");
				
				
					
				}
			}
		});
		
		this.add(lblEditar);
		this.add(lblSeleccionarEd);
		this.add(cbEdArea);
		this.add(btnEditar);
		this.add(lblENumero);
		this.add(txtENumero);
		this.add(btnGuardarE);
		
		//ELIMINAR CAMAS
		
		posY+=60;
		
		lblEliminar = new JLabel("Eliminar camas");
		lblEliminar.setBounds(10,posY,100,30);
		
		posY+=40;
		
		lblSeleccionarEl= new JLabel("Seleccionar Área:");
		lblSeleccionarEl.setBounds(10,posY,200,30);
		
		cbElArea = new JComboBox<>();
		cbElArea.setBounds(150,posY,200,30);
		cbElArea.addItem("Seleccionar área --");
		
		posY+=40;
		
		btnEliminar= new JButton("Eliminar");
		btnEliminar.setBounds(150,posY,150,30);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbElArea.getSelectedIndex()!=0) {
					int idArea=0;
					String eliminar=((String) cbElArea.getSelectedItem());
					
					ResultSet registrosIdARea=(ResultSet)data.getQuery("SELECT * FROM _Area where nombre= '"+eliminar+"';");
					try {
						while(registrosIdARea.next()) {
							
							idArea=registrosIdARea.getInt("idArea");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					data.setQuery("DELETE FROM HospitalArea WHERE idArea='"+idArea+"'");
					cbElArea.removeAllItems();
					cbArea.removeAllItems();
					cbEdArea.removeAllItems();
					cbElArea.addItem("Seleccione paciente...");
					cbArea.addItem("Seleccione paciente...");
					cbEdArea.addItem("Seleccione paciente...");
					JOptionPane.showMessageDialog(btnEliminar,"Eliminación exitosa");
					registros=(ResultSet) data.getQuery("Select * from _Area where idHospital='"+idHospital+"';");
					try {
						while(registros.next()) {
							
							cbElArea.addItem(registros.getString("nombre"));
							cbEdArea.addItem(registros.getString("nombre"));
							cbArea.addItem(registros.getString("nombre"));
							
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
		this.add(cbElArea);
		this.add(btnEliminar);
	}
}
