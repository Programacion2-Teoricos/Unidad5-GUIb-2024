package grafica;
//ver aquí como usar JTatoo https://www.youtube.com/watch?v=npatkpiF18I
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import logica.Alumno;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;

public class FrmAlumno extends JFrame {

	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtGrupo;
	private JTextField txtCuotaBase;
	private JTextField txtCuotaNeta;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private JButton btnSalir;

	public FrmAlumno() {
		setTitle("Alumnos");
		iniciarComponentes();
		iniciarManejadoresEventos();
	}

	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del alumno",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(10, 11, 236, 110);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 30, 96, 14);
		panel1.add(lblApellido);

		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(10, 55, 96, 14);
		panel1.add(lblGrupo);

		JLabel lblCuotaBase = new JLabel("Cuota Base:");
		lblCuotaBase.setBounds(10, 80, 96, 14);
		panel1.add(lblCuotaBase);

		txtApellido = new JTextField();
		txtApellido.setBounds(116, 27, 110, 20);
		panel1.add(txtApellido);
		txtApellido.setColumns(10);

		txtGrupo = new JTextField();
		txtGrupo.setBounds(116, 52, 110, 20);
		panel1.add(txtGrupo);
		txtGrupo.setColumns(10);

		txtCuotaBase = new JTextField();
		txtCuotaBase.setBounds(116, 77, 110, 20);
		panel1.add(txtCuotaBase);
		txtCuotaBase.setColumns(10);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setBorder(new TitledBorder(null, "Calculo de la cuota neta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel2.setBounds(256, 11, 213, 58);
		contentPane.add(panel2);
		panel2.setLayout(null);

		txtCuotaNeta = new JTextField();
		txtCuotaNeta.setEditable(false);
		txtCuotaNeta.setBounds(117, 25, 86, 20);
		panel2.add(txtCuotaNeta);
		txtCuotaNeta.setColumns(10);

		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(10, 24, 89, 23);
		panel2.add(btnCalcular);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(256, 98, 89, 23);
		contentPane.add(btnLimpiar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(380, 98, 89, 23);
		contentPane.add(btnSalir);
	}

	private void iniciarManejadoresEventos() {

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alumno a;
				try {
					String apellido = txtApellido.getText();
					int grupo = Integer.valueOf(txtGrupo.getText());
					double cuotaBase = Double.valueOf(txtCuotaBase.getText());
					a = new Alumno(apellido, grupo, cuotaBase);
					txtCuotaNeta.setText(String.valueOf(a.cuotaNeta()));
				} catch (Exception ex) {
					txtCuotaNeta.setText("Error");
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtApellido.setText(null);
				txtGrupo.setText(null);
				txtCuotaBase.setText(null);
				txtCuotaNeta.setText(null);
			}
		});
	}

	public static void main(String[] args) {
		FrmAlumno frm = new FrmAlumno();
		frm.setVisible(true);
	}
}
