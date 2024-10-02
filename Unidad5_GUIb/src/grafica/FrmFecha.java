package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmFecha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnio;
	private JTextField txtFecha;
	private JButton btnLimpiar;
	private JButton btnMostrarFecha;

	
	public FrmFecha() {
		setTitle("Manejar Fechas");
		iniciarComponentes();
		iniciarManejadoresEventos();
	}


	private void iniciarManejadoresEventos() {
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDia.setText(null);
				txtMes.setText(null);
				txtAnio.setText(null);
				
				
			}
		});
		
		btnMostrarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fecha a;
				try {
					int dia=Integer.valueOf(txtDia.getText());
					int mes=Integer.valueOf(txtMes.getText());
					int anio=Integer.valueOf(txtAnio.getText());
					a=new Fecha(dia, mes, anio);
					
					txtFecha.setText(a.toString());
				}catch(Exception ex){
					System.out.println("Error");
					JOptionPane.showMessageDialog(null,"Error");
				}
			}
		});
		
	}


	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 229, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDia = new JLabel("Día:");
		lblDia.setBounds(10, 28, 77, 14);
		contentPane.add(lblDia);
		
		txtDia = new JTextField();
		txtDia.setBounds(109, 28, 86, 20);
		contentPane.add(txtDia);
		txtDia.setColumns(10);
		
		JLabel lblMes = new JLabel("Mes:");
		lblMes.setBounds(10, 68, 89, 14);
		contentPane.add(lblMes);
		
		txtMes = new JTextField();
		txtMes.setBounds(109, 68, 86, 20);
		contentPane.add(txtMes);
		txtMes.setColumns(10);
		
		JLabel lblAnio = new JLabel("Anio:");
		lblAnio.setBounds(10, 115, 77, 14);
		contentPane.add(lblAnio);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(109, 115, 86, 20);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblMostrarFecha = new JLabel("Mostrar Fecha:");
		lblMostrarFecha.setBounds(10, 194, 77, 17);
		contentPane.add(lblMostrarFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(112, 191, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		btnLimpiar = new JButton("Limpiar");
		
		btnLimpiar.setBounds(10, 227, 89, 23);
		contentPane.add(btnLimpiar);
		
		btnMostrarFecha = new JButton("Mostrar Fecha");
		
		btnMostrarFecha.setBounds(109, 227, 89, 23);
		contentPane.add(btnMostrarFecha);
		
	}
	
	public static void main(String args[]) {
		FrmFecha ventana=new FrmFecha();
		ventana.setVisible(true);
		
		
	}
	
}//fin de la clase
