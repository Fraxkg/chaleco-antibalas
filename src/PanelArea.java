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

public class PanelArea extends JPanel{
	//Base de datos
	MySQLConnect data;
	ResultSet registros=null;
	ResultSet registrosHospital=null;
	String nombreViejo;

	//
	private int posY=10;
	 private JComboBox<String> cbHospital;
	 private JLabel lblSelectHospital;

	private JButton btnAgregar,btnCancelar, btnEditar, btnGuardarE, btnEliminar;
	private JTextField txtNombre, txtENombre;
	private JLabel lblNombre, lblSeleccionarEd, lblENombre, lblAgregar, lblEditar, lblSeleccionarEl, lblEliminar;
	private JComboBox<String> cbEdArea, cbElArea;
	
	public PanelArea(){
		this.setLayout(null);
		this.setSize(1200,700);
		
		data= new MySQLConnect();
		data.MySQLConnect();
		registrosHospital=(ResultSet) data.getQuery("Select * from Hospital");
		registros=(ResultSet) data.getQuery("Select * from _Area");
		
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
		
		//AGREGAR area
		lblAgregar =  new JLabel("Agregar Área");
		lblAgregar.setBounds(10,posY,200,30);
		
		posY+=40;
		
		lblNombre = new JLabel("Nombre del Área:");
		lblNombre.setBounds(10,posY,150,30);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(150, posY, 150, 30);
		
		posY+=40;
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10,posY,100,30);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				registros=(ResultSet) data.getQuery("Select * from _Area");
				registrosHospital=(ResultSet) data.getQuery("Select * from Hospital");
				boolean flagRepetido=false;
				//guarda el texto insertado en una variable
				String area=txtNombre.getText();
				//guardo la opcion del hospital elegido en una varibale
				String hospitalElegido=(String) cbHospital.getSelectedItem();
				//inicializo el id del hospital que se agregará a area
				int idHospital=0;
				
				int comp2;
				String comp1;
				//este while de registros obtiene el id del del hospital que seleccione
				System.out.println(hospitalElegido);
				try {
					while(registrosHospital.next()) {
						comp2=registros.getInt("idHospital");
						comp1=registros.getString("nombre");
						System.out.println(comp2 + comp1);
						if(hospitalElegido.equals(comp1)) {
							
							
							idHospital=comp2;
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(idHospital);
				
				/// este ciclo de los registros de area sirve para comprobar que no se repita la misma area en el mismo hospital
				try {
					while(registros.next()) {
						String prueba=registros.getString("nombre");
						int prueba2=registros.getInt("idHospital");
						
						if(area.equals(prueba)&&idHospital==prueba2) {
							
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
				data.setQuery("INSERT INTO _Area (idArea, nombre, idHospital) VALUES (NULL, '"+area+"',16);");
				JOptionPane.showMessageDialog(btnAgregar,"Registro de Area exitoso");
				
			}else {
				JOptionPane.showMessageDialog(btnAgregar,"Inserte los datos correspondientes");
		}
				if(flagRepetido==true) {
				JOptionPane.showMessageDialog(btnAgregar,"Esta area ya está registrado");}
			}

			private int getValueOf(String idHospital) {
				// TODO Auto-generated method stub
				return 0;
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
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(btnAgregar);
		this.add(btnCancelar);
		
		//EDITAR HOSPITAL
		posY+=60;
		
		lblEditar = new JLabel("Editar");
		lblEditar.setBounds(10, posY,150,30);
		
		posY+=40;
		
		lblSeleccionarEd = new JLabel("Seleccionar Área:");
		lblSeleccionarEd.setBounds(10,posY,200,30);
		
		cbEdArea = new JComboBox<>();
		cbEdArea.setBounds(150,posY,200,30);
		cbEdArea.addItem("Seleccionar área --");
		
		btnEditar =  new JButton("Editar");
		btnEditar.setBounds(390,posY,150,30);
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		posY+=40;
		
		lblENombre = new JLabel("Nombre:");
		lblENombre.setBounds(10,posY,100,30);
		
		txtENombre = new JTextField();
		txtENombre.setBounds(150,posY,200,30);
		
		btnGuardarE = new JButton("Guardar Edición");
		btnGuardarE.setBounds(390,posY,150,30);
		btnGuardarE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblEditar);
		this.add(lblSeleccionarEd);
		this.add(cbEdArea);
		this.add(btnEditar);
		this.add(lblENombre);
		this.add(txtENombre);
		this.add(btnGuardarE);
		
		//ELIMINAR HOSPITAL
		
		posY+=60;
		
		lblEliminar = new JLabel("Eliminar");
		lblEliminar.setBounds(10,posY,100,30);
		
		posY+=40;
		
		lblSeleccionarEl= new JLabel("Seleccionar Área:");
		lblSeleccionarEl.setBounds(10,posY,200,30);
		
		cbElArea = new JComboBox<>();
		cbElArea.setBounds(150,posY,200,30);
		cbElArea.addItem("Seleccionar área --");
		
		btnEliminar= new JButton("Eliminar");
		btnEliminar.setBounds(390,posY,150,30);
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.add(lblEliminar);
		this.add(lblSeleccionarEl);
		this.add(cbElArea);
		this.add(btnEliminar);
	}
}
