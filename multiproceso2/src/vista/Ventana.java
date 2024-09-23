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
import javax.swing.JScrollPane;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	static JTextArea textAreaPID1;
	static JTextArea textAreaPID2;
	static JTextArea textAreaPID3;
	
	static JTextArea textAreaPIDpadre1;
	static JTextArea textAreaPIDpadre2;
	static JTextArea textAreaPIDpadre3;

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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 234, 173, 395);
		contentPane.add(scrollPane);

		JTextArea textAreaResultado1 = new JTextArea();
		scrollPane.setViewportView(textAreaResultado1);
		textAreaResultado1.setEditable(false);


		JButton btn2 = new JButton("Start");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comando a ejecutar introducido
				String comando = textField2.getText();

				//seteamos en el textarea la respuesta
				textAreaResultado1.setText(metodo.ejecutarComando(comando));
			}
		});



		btn2.setBounds(200, 95, 89, 23);
		contentPane.add(btn2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(308, 234, 173, 395);
		contentPane.add(scrollPane_1);

		JTextArea textArea2 = new JTextArea();
		scrollPane_1.setViewportView(textArea2);
		textArea2.setEditable(false);



		JButton btn3 = new JButton("Start");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//recogemos el texto introducido por el usuario
				String dato = textField3.getText();

				//seteamos el return en el textarea
				textArea2.setText(metodo.llamarPrograma(dato));
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

		//pid proceso 1
		textAreaPID1 = new JTextArea();
		textAreaPID1.setEditable(false);
		textAreaPID1.setBounds(70, 160, 86, 19);
		contentPane.add(textAreaPID1);

		//pid proceso 2
		textAreaPID2 = new JTextArea();
		textAreaPID2.setEditable(false);
		textAreaPID2.setBounds(200, 160, 86, 19);
		contentPane.add(textAreaPID2);

		//pid proceso 3
		textAreaPID3 = new JTextArea();
		textAreaPID3.setEditable(false);
		textAreaPID3.setBounds(330, 160, 194, 19);
		contentPane.add(textAreaPID3);

		//pid padre 1
		textAreaPIDpadre1 = new JTextArea();
		textAreaPIDpadre1.setEditable(false);
		textAreaPIDpadre1.setBounds(70, 207, 86, 19);
		contentPane.add(textAreaPIDpadre1);

		//pid padre 2
		textAreaPIDpadre2 = new JTextArea();
		textAreaPIDpadre2.setEditable(false);
		textAreaPIDpadre2.setBounds(200, 207, 86, 19);
		contentPane.add(textAreaPIDpadre2);

		//pid padre 3
		textAreaPIDpadre3 = new JTextArea();
		textAreaPIDpadre3.setEditable(false);
		textAreaPIDpadre3.setBounds(330, 207, 86, 19);
		contentPane.add(textAreaPIDpadre3);
	}

	//metodo para insertar el pid1 al textarea
	public static void appendTextPID1(String text) {
		textAreaPID1.append(text + "\n");
	}

	//metodo para insertar el pid2 al textarea
	public static void appendTextPID2(String text) {
		textAreaPID2.append(text + "\n");
	}

	//metodo para insertar el pid3 al textarea
	public static void appendTextPID3(String text) {
		textAreaPID3.append(text + "\n");
	}
	
	//metodo para insertar el pidPadre1 al textarea
		public static void appendTextPIDPadre1(String text) {
			textAreaPIDpadre1.append(text + "\n");
		}

		//metodo para insertar el pidPadre2 al textarea
		public static void appendTextPIDPadre2(String text) {
			textAreaPIDpadre2.append(text + "\n");
		}

		//metodo para insertar el pidPadre3 al textarea
		public static void appendTextPIDPadre3(String text) {
			textAreaPIDpadre3.append(text + "\n");
		}
	
	
}
