import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelReceta extends JPanel{
	
	private int posY=10;
	private JComboBox<String> cbHospital;
	private JLabel lblSelectHospital;

	private JLabel lblAgregar, lblSelecCita, lblFolio, lblMedicamentos, lblEditar, lblEdSelecCita, lblEdMedicamentos, lblSeleccionarReceta, lblEdFolio,lblEliminar, lblSelecElCita, lblSelecElReceta, lblElReceta, lblM1, lblM2, lblM3, lblEdM1, lblEdM2, lblEdM3;
	private JButton btnAgregar, btnCancelar, btnEditar, btnGuardar, btnEdCancelar, btnEliminar, btnMasMedi;
	private JComboBox<String> cbCitas, cbM1,cbM2, cbM3, cbEdCitas, cbEdM1, cbEdM2, cbEdM3, cbEliminar, cbSelecElCita;
	
	public PanelReceta(){
		
		this.setLayout(null);
		this.setSize(1200,700);
		
		lblSelectHospital = new JLabel("Seleccionar hospital:");
		lblSelectHospital.setBounds(10,posY,150,30);
		
		cbHospital = new JComboBox<>();
		cbHospital.setBounds(150, posY, 300,30);
		cbHospital.addItem("Seleccionar hospital --");
		
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
		
		this.add(lblEliminar);
		this.add(lblSelecElCita);
		this.add(cbSelecElCita);
		this.add(lblSelecElReceta);
		this.add(cbEliminar);
		this.add(btnEliminar);
		
		
	}
}
