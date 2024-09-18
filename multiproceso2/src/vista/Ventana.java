package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Metodos;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		Metodos metodo = new Metodos();


		setTitle("Ventana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField1 = new JTextField();
		textField1.setBounds(70, 50, 86, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setBounds(200, 50, 86, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setBounds(330, 50, 86, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);



		JButton btn1 = new JButton("Start");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//programa a ejecutar introducido
				String programa = textField1.getText();
				
				metodo.ejecutarPrograma(programa);
			}
		});
		btn1.setBounds(70, 95, 89, 23);
		contentPane.add(btn1);



		JButton btn2 = new JButton("Start");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comando a ejecutar introducido
				String comando = textField2.getText();
				
				metodo.ejecutarComando(comando);
			}
		});
		
		btn2.setBounds(200, 95, 89, 23);
		contentPane.add(btn2);

		JButton btn3 = new JButton("Start");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//**
			}
		});
		btn3.setBounds(330, 95, 89, 23);
		contentPane.add(btn3);

		JLabel lblPID = new JLabel("PID");
		lblPID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPID.setBounds(10, 165, 46, 14);
		contentPane.add(lblPID);

		JLabel lblPIDPadre = new JLabel("PID Padre");
		lblPIDPadre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPIDPadre.setBounds(10, 212, 65, 14);
		contentPane.add(lblPIDPadre);

		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultado.setBounds(10, 276, 65, 14);
		contentPane.add(lblResultado);

		JTextArea textArea2 = new JTextArea();
		textArea2.setEditable(false);
		textArea2.setBounds(308, 234, 173, 395);
		contentPane.add(textArea2);

		JTextArea textArea1 = new JTextArea();
		textArea1.setEditable(false);
		textArea1.setBounds(100, 234, 173, 395);
		contentPane.add(textArea1);
	}
}
