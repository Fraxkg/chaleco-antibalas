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

public class PanelFarmacia extends JPanel{

	private int posY=10;
	private JButton btnAgregar,btnCancelar, btnEditar, btnGuardarE, btnEliminar;
	private JTextField txtNombre, txtENombre;
	private JLabel lblNombre, lblSeleccionarEd, lblENombre, lblHospital, lblEdHospital, lblAgregar, lblEditar, lblSeleccionarEl, lblEliminar;
	JButton btnSelHospital;
	private JComboBox<String> cbHospital, cbEdFarmacia, cbElFarmacia,cbEdHospital;
	ResultSet registros=null;
	ResultSet registrosSexo=null;
	ResultSet registrosPuesto=null;
	ResultSet registrosHospital=null;
	String nombreViejo;
	MySQLConnect data;
	int idHospital=0;
	public PanelFarmacia(){
		this.setLayout(null);
		this.setSize(1200,700);
		
		data= new MySQLConnect();
		data.MySQLConnect();
		lblHospital = new JLabel("Hospital:");
		lblHospital.setBounds(10,posY,50,30);
	
		cbHospital = new JComboBox<>();
		cbHospital.setBounds(70,posY,300,30);
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
		btnSelHospital = new JButton("Seleccionar");
		btnSelHospital.setBounds(450,10,150,30);
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
				
				cbEdFarmacia.removeAllItems();
				cbElFarmacia.removeAllItems();
				cbElFarmacia.addItem("Seleccione una farmacia...");
				cbEdFarmacia.addItem("Seleccione una farmacia...");
				System.out.println(idHospital);
				ResultSet Concuerda=(ResultSet)data.getQuery("SELECT * FROM Farmacia where idHospital= '"+idHospital+"';");
				
				try {
					while(Concuerda.next()) {
						System.out.println("sin entro");
						cbElFarmacia.addItem(Concuerda.getString("nombre"));
						cbEdFarmacia.addItem(Concuerda.getString("nombre"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		posY+=40;
		
		//AGREGAR FARMACIA
		lblAgregar =  new JLabel("Agregar");
		lblAgregar.setBounds(10,posY,200,30);
		
		posY+=40;
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10,posY,150,30);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(80, posY, 230, 30);
		
		posY+=40;
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10,posY,100,30);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				registros=(ResultSet) data.getQuery("Select * from Farmacia");
				registrosHospital=(ResultSet) data.getQuery("Select * from Hospital");
				boolean flagRepetido=false;
				//guarda el texto insertado en una variable
				String farmacia=txtNombre.getText();
				//guardo la opcion del hospital elegido en una varibale
				String hospitalElegido=(String) cbHospital.getSelectedItem();
				//inicializo el id del hospital que se agregará a area
				
				
			
				System.out.println(idHospital);
				
				/// este ciclo de los registros de area sirve para comprobar que no se repita la misma area en el mismo hospital
				try {
					while(registros.next()) {
						String prueba=registros.getString("nombre");
						int prueba2=registros.getInt("idHospital");
						
						if(farmacia.equals(prueba)&&idHospital==prueba2) {
							
							flagRepetido=true;
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//aqui se valida que si el campo no esta vacio y no esta repetido insertara la informacion moxxita
				if(txtNombre.getText().isEmpty()!=true && flagRepetido==false) {
					System.out.println(idHospital);
				data.setQuery("INSERT INTO Farmacia (idFarmacia, nombre, idHospital) VALUES (NULL, '"+farmacia+"','"+idHospital+"');");
				JOptionPane.showMessageDialog(btnAgregar,"Registro de farmacia exitoso");
				cbElFarmacia.addItem(farmacia);
				cbEdFarmacia.addItem(farmacia);
			}else {
				JOptionPane.showMessageDialog(btnAgregar,"Inserte los datos correspondientes");
		}
				if(flagRepetido==true) {
				JOptionPane.showMessageDialog(btnAgregar,"Esta farmacia ya está registrado");
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
		
		this.add(lblAgregar);
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(lblHospital);
		this.add(cbHospital);
		this.add(btnAgregar);
		this.add(btnCancelar);
		
		//EDITAR FARMACIA
		
		posY+=60;
		
		lblEditar = new JLabel("Editar");
		lblEditar.setBounds(10, posY,150,30);
		
		posY+=40;
		
		lblSeleccionarEd = new JLabel("Seleccionar Farmacia:");
		lblSeleccionarEd.setBounds(10,posY,200,30);
		
		cbEdFarmacia = new JComboBox<>();
		cbEdFarmacia.setBounds(140,posY,240,30);
		cbEdFarmacia.addItem("Seleccionar farmacia --");
		
		btnEditar =  new JButton("Editar");
		btnEditar.setBounds(390,posY,100,30);
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbEdFarmacia.getSelectedIndex()!=0) {
					txtENombre.setText((String) cbEdFarmacia.getSelectedItem());
					nombreViejo=(String) cbEdFarmacia.getSelectedItem();
					System.out.println(cbEdFarmacia.getSelectedItem());
					txtENombre.repaint();
					}else {
						
					}
			}
		});
		
		posY+=40;
		
		lblENombre = new JLabel("Nombre:");
		lblENombre.setBounds(10,posY,100,30);
		
		txtENombre = new JTextField();
		txtENombre.setBounds(140,posY,240,30);
		
		
		
		btnGuardarE = new JButton("Guardar Edición");
		btnGuardarE.setBounds(400,posY,150,30);
		btnGuardarE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombreNuevo=txtENombre.getText();
				System.out.println(nombreNuevo);
				
				if(cbEdFarmacia.getSelectedIndex()!=0) {
					data.setQuery("UPDATE Farmacia SET nombre = '"+nombreNuevo+"' WHERE nombre='"+nombreViejo+"'");
					
					txtENombre.setText("");
					JOptionPane.showMessageDialog(btnGuardarE,"Edición exitosa");
					cbElFarmacia.removeAllItems();
					cbEdFarmacia.removeAllItems();
					cbElFarmacia.addItem("Seleccione un Farmacia...");
					cbEdFarmacia.addItem("Seleccione un Farmacia...");
					ResultSet registrosArea=(ResultSet)data.getQuery("SELECT * FROM Farmacia where idHospital= '"+idHospital+"';");
					
					try {
						while(registrosArea.next()) {
							
							cbElFarmacia.addItem(registrosArea.getString("nombre"));
							cbEdFarmacia.addItem(registrosArea.getString("nombre"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}else {
						
					}
			}
		});
		this.add(btnSelHospital);
		this.add(lblEditar);
		this.add(lblSeleccionarEd);
		this.add(cbEdFarmacia);
		this.add(btnEditar);
		this.add(lblENombre);
		this.add(txtENombre);
		this.add(btnGuardarE);
		
		//ELIMINAR FARMACIA
		
		posY+=60;
		
		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(10,posY,100,30);
		
		posY+=40;
		
		lblSeleccionarEl= new JLabel("Seleccionar Farmacia:");
		lblSeleccionarEl.setBounds(10,posY,200,30);
		
		cbElFarmacia = new JComboBox<>();
		cbElFarmacia.setBounds(160,posY,200,30);
		cbElFarmacia.addItem("Seleccionar farmacia --");
		
		btnEliminar= new JButton("Eliminar");
		btnEliminar.setBounds(370,posY,150,30);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbElFarmacia.getSelectedIndex()!=0) {
					String eliminar=((String) cbElFarmacia.getSelectedItem());
					System.out.println(eliminar);
					data.setQuery("DELETE FROM Farmacia WHERE nombre='"+eliminar+"'");
					cbElFarmacia.removeAllItems();
					cbEdFarmacia.removeAllItems();
					cbElFarmacia.addItem("Seleccione una farmacia...");
					cbEdFarmacia.addItem("Seleccione una farmacia...");
					JOptionPane.showMessageDialog(btnEliminar,"Eliminación exitosa");
					registros=(ResultSet) data.getQuery("Select * from Farmacia where idHospital='"+idHospital+"';");
					try {
						while(registros.next()) {
							
							cbElFarmacia.addItem(registros.getString("nombre"));
							cbEdFarmacia.addItem(registros.getString("nombre"));
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
		this.add(cbElFarmacia);
		this.add(btnEliminar);
	}

}
