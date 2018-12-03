import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class Ventana extends JFrame{
	
	private PanelHospital panelHospital;
	private PanelPersonal panelPersonal;
	private PanelArea panelArea;
	private PanelPuesto panelPuesto;
	private PanelPaciente panelPaciente;
	private PanelCama panelCama;
	private PanelFarmacia panelFarmacia;
	private PanelMedicamento panelMedicamento;
	private PanelInternado panelInternado;
	private PanelCita panelCita;
	private PanelReceta panelReceta;
	private JTabbedPane panelTabbe;
	
	
	public Ventana(){
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 700);
		this.setTitle("Administrador BD Hospital");
		
		panelTabbe = new JTabbedPane();
		panelTabbe.setBounds(0, 0, 1200, 700);
		
		this.add(panelTabbe);
		
		panelHospital = new PanelHospital();
		panelPersonal = new PanelPersonal();
		panelArea = new PanelArea();
		panelPuesto = new PanelPuesto();
		panelPaciente = new PanelPaciente();
		panelCama = new PanelCama();
		panelFarmacia = new PanelFarmacia();
		panelMedicamento = new PanelMedicamento();
		panelInternado = new PanelInternado();
		panelCita = new PanelCita();
		panelReceta = new PanelReceta();
		
		panelTabbe.addTab("Admin Hospital", panelHospital);
		panelTabbe.addTab("Personal", panelPersonal);
		panelTabbe.add("Área", panelArea);
		panelTabbe.add("Puesto", panelPuesto);
		panelTabbe.add("Paciente", panelPaciente);
		panelTabbe.add("Camas",panelCama);
		panelTabbe.add("Farmacia",panelFarmacia);
		panelTabbe.add("Medicamento",panelMedicamento);
		panelTabbe.add("Interno", panelInternado);
		panelTabbe.add("Cita", panelCita);
		panelTabbe.add("Receta",panelReceta);
		
	}
}
