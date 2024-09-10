package grafica;

import logica.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class FrmAlumno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtGrupo;
	private JTextField txtCuotaBase;
	private JTextField txtCuotaNeta;
	private JButton btnSalir;
	private JButton btnLimpiar;
	private JButton btnCalcular;

	public FrmAlumno() {
		iniciarComponentes();
		iniciarManejadoresEventos();
	}
	
	
		private void iniciarManejadoresEventos() {
			//evento del botón  salir
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			//evento del botón limpiar
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtApellido.setText(null);
					txtGrupo.setText(null);
					txtCuotaBase.setText(null);
					txtCuotaNeta.setText(null);
									
				}
			});
			//evento del botón calcular
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Alumno a;
					try {
						String apellido=txtApellido.getText();
						int grupo=Integer.valueOf(txtGrupo.getText());
						double cuotaBase=Double.valueOf(txtCuotaBase.getText());
						a=new Alumno(apellido, grupo, cuotaBase);
						double cuotaNeta=a.cuotaNeta();
						txtCuotaNeta.setText(String.valueOf(cuotaNeta));
					}catch(Exception ex) {
						txtCuotaNeta.setText("error");
						JOptionPane.showMessageDialog(null, ex);
					}
				}
			});
			
			
		
	}

		
		
		
		private void iniciarComponentes() {
			setBackground(new Color(217, 232, 234));
			setTitle("Agregar Alumno");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 511, 190);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);

			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos de Alumno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBackground(new Color(160, 209, 220));
			panel.setBounds(10, 11, 231, 121);
			contentPane.add(panel);
			panel.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Calculo de la cuota Neta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBackground(new Color(160, 209, 220));
			panel_1.setBounds(292, 11, 194, 88);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			btnCalcular = new JButton("Calcular");
			
			btnCalcular.setBounds(10, 32, 86, 23);
			panel_1.add(btnCalcular);
			
			txtCuotaNeta = new JTextField();
			txtCuotaNeta.setEditable(false);
			txtCuotaNeta.setBounds(112, 33, 72, 20);
			panel_1.add(txtCuotaNeta);
			txtCuotaNeta.setColumns(10);

			JLabel lblApellido = new JLabel("Apellido");
			lblApellido.setBounds(20, 23, 46, 14);
			panel.add(lblApellido);

			JLabel lblGrupo = new JLabel("Grupo");
			lblGrupo.setBounds(20, 54, 46, 14);
			panel.add(lblGrupo);

			JLabel lblCuotaBase = new JLabel("Cuota Base");
			lblCuotaBase.setBounds(20, 82, 87, 14);
			panel.add(lblCuotaBase);

			txtApellido = new JTextField();
			txtApellido.setBounds(92, 20, 112, 20);
			panel.add(txtApellido);
			txtApellido.setColumns(10);

			txtGrupo = new JTextField();
			txtGrupo.setBounds(92, 51, 112, 20);
			panel.add(txtGrupo);
			txtGrupo.setColumns(10);

			txtCuotaBase = new JTextField();
			txtCuotaBase.setBounds(92, 79, 112, 20);
			panel.add(txtCuotaBase);
			txtCuotaBase.setColumns(10);

			btnSalir = new JButton("Salir");
			
			btnSalir.setBounds(421, 110, 64, 23);
			contentPane.add(btnSalir);
			
			btnLimpiar = new JButton("Limpiar");
			
			btnLimpiar.setBounds(292, 110, 89, 23);
			contentPane.add(btnLimpiar);
		
	}
		
	public static void main(String[] args) {
		FrmAlumno ventanita= new FrmAlumno();
		ventanita.setVisible(true);
	}
}