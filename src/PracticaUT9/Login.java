package PracticaUT9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	static Login frame1;
	private JButton salir;
	private JPasswordField pass;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 = new Login();
					frame1.setVisible(true);
					//Reservo espacio para la ventana principal
					Principal.frame2 = new Principal();
					Principal.frame2.setVisible(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Getters y setters de los input de usuario y contraseña
		public JTextField getUser() {
			return user;
		}
		public void setUser(JTextField user) {
			this.user = user;
		}
		public JPasswordField getPass() {
			return pass;
		}
		public void setPass(JPasswordField pass) {
			this.pass = pass;
		}
	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 358);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Titulo de la ventana Login
			setTitle(" Spotify Ribera | Login");
		//Impedimos que el usuario pueda cambiar el tamaño de la ventana
			setResizable(false);
		//Hacemos que la ventana aparezca centrada
			setLocationRelativeTo(null);
		//COMPONENTES DE LA VENTANA
			//Input del usuario
				user = new JTextField();
				user.setBackground(new Color(102, 102, 102));
				user.setBounds(249, 71, 194, 30);
				contentPane.add(user);
				user.setColumns(10);
				user.setForeground(Color.white);
				//Padding al input User
				user.setBorder(BorderFactory.createCompoundBorder(user.getBorder(), BorderFactory.createEmptyBorder(5,5,5,5)));
			//Botón de entrar
				JButton entrar = new JButton("Entrar");
				entrar.setFont(new Font("Constantia", Font.BOLD, 17));
				entrar.setBackground(new Color(50, 205, 50));
				entrar.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) { //Este es el evento que se acciona al pulsar  el botón de entrar
						if(frame1.getUser().getText().equals("admin") && frame1.getPass().getText().equals("admin")) {
							frame1.setVisible(false);
							Principal.frame2.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrectas", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				entrar.setBounds(118, 187, 150, 56);
				contentPane.add(entrar);
			//Botón de salir
				salir = new JButton("Salir");
				salir.setFont(new Font("Constantia", Font.BOLD, 17));
				salir.setBackground(new Color(50, 205, 50));
				salir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) { //Evento del botón salir
						System.exit(0); //Para salir del programa
					}
				});
				salir.setBounds(293, 187, 150, 56);
				contentPane.add(salir);
			//Label de Usuario
				JLabel Usuario = new JLabel("Usuario:");
				Usuario.setFont(new Font("Tahoma", Font.BOLD, 15));
				Usuario.setBounds(118, 68, 102, 30);
				contentPane.add(Usuario);
				Usuario.setForeground(Color.white);
			//Label de contraseña
				JLabel Contraseña = new JLabel("Contrase\u00F1a:");
				Contraseña.setFont(new Font("Tahoma", Font.BOLD, 15));
				Contraseña.setBounds(118, 122, 102, 25);
				contentPane.add(Contraseña);
				Contraseña.setForeground(Color.white);
			//Input de la contraseña
				pass = new JPasswordField();
				pass.setBackground(new Color(102, 102, 102));
				pass.setBounds(249, 122, 194, 30);
				contentPane.add(pass);
				pass.setForeground(Color.white);
				//Padding al input de contraseña
				pass.setBorder(BorderFactory.createCompoundBorder(pass.getBorder(), BorderFactory.createEmptyBorder(5,5,5,5)));
		}
}
