package PracticaUT9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;


import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;


public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField CodGrup;
	private JTextArea textArea;
	static Principal frame2;

	private ArrayList<Grupos>grupos;
	private ArrayList<Canciones>canciones;
	
	//Getters y setters del input del código del grupo
	public JTextField getCodGrup() {
		return CodGrup;
	}
	public void setCodGrup(JTextField codGrup) {
		CodGrup = codGrup;
	}
	//Getters y setters del textArea
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame2 = new Principal();
					frame2.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 516);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Reservo espacio para los AL
			this.grupos = new ArrayList<>();
			this.canciones = new ArrayList<>();
		//Ponemos un título a la ventana
			setTitle(" Spotify Ribera | Programa");
		//Impedimos que el usuario pueda cambiar el tamaño de la ventana
			setResizable(false);
		//Hacemos que la ventana aparezca centrada
			setLocationRelativeTo(null);
		//COMPONENTES DE LA VENTANA
			//Botón de grupos
				JButton GruposButton = new JButton("Mostrar Grupos");
				GruposButton.setBackground(new Color(50, 205, 50));
				GruposButton.setFont(new Font("Constantia", Font.BOLD, 17));
				GruposButton.addActionListener(new ActionListener() {//Evento de pulsar el Botón Grupos
					public void actionPerformed(ActionEvent e) { 
						textArea.setText(null);	//Limpiamos el textArea
						leerGrupos("grupos.csv");//Leemos el csv
						escribirGrupos();
						grupos.clear();//Limpiamos el AL
						}
				});
				GruposButton.setBounds(92, 217, 168, 58);
				contentPane.add(GruposButton);
			//Botón de Canciones
				JButton CancionesButton = new JButton("Ver Canciones");
				CancionesButton.setBackground(new Color(50, 205, 50));
				CancionesButton.setFont(new Font("Constantia", Font.BOLD, 17));
				CancionesButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {//Evento de pulsar el Botón Canciones
						textArea.setText(null);	//Limpiamos el textArea
						leerCanciones("canciones.csv");//Leemos el csv
						escribirCanciones();
						canciones.clear();//Limpiamos el AL
					}
				});
				CancionesButton.setBounds(92, 305, 168, 58);
				contentPane.add(CancionesButton);
			//Label del código de grupo
				JLabel lblNewLabel = new JLabel("C\u00F3digo de Grupo");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel.setBounds(113, 123, 128, 19);
				contentPane.add(lblNewLabel);
				lblNewLabel.setForeground(Color.white);
			//TextField del código de grupo
				CodGrup = new JTextField();
				CodGrup.setToolTipText("");
				CodGrup.setFont(CodGrup.getFont().deriveFont(CodGrup.getFont().getStyle() | Font.ITALIC));
				CodGrup.setForeground(Color.white);
				CodGrup.setHorizontalAlignment(SwingConstants.CENTER);
				CodGrup.setBackground(new Color(102, 102, 102));
				CodGrup.setBounds(92, 152, 168, 24);
				contentPane.add(CodGrup);
				CodGrup.setColumns(10);
				
			//TextArea
				textArea = new JTextArea();
				textArea.setBackground(new Color(102, 102, 102));
				textArea.setForeground(Color.white);
				textArea.setEditable(false);
				textArea.setWrapStyleWord(true);
				textArea.setSize(480, 350);
				textArea.setLocation(10, -7);	
				//Padding al textArea:
				textArea.setBorder(BorderFactory.createCompoundBorder(textArea.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

				contentPane.add(textArea);
			//Label del Título del Text Area
				JLabel lblNewLabel_1 = new JLabel("Grupos y Canciones");
				lblNewLabel_1.setFont(new Font("Ink Free", Font.BOLD, 30));
				lblNewLabel_1.setBounds(436, 33, 268, 37);
				contentPane.add(lblNewLabel_1);
				lblNewLabel_1.setForeground(Color.GREEN);
			//Scroll
				JScrollPane scroll = new JScrollPane(textArea);
				scroll.setSize(480, 350);
				scroll.setLocation(315, 80);
					//Añado el Scroll al panel
					getContentPane().add(scroll, BorderLayout.CENTER);

	}
		//MÉTODOS
			//Método de lectura de los grupos
				public void leerGrupos(String filename) {
					File fichero = new File(filename);
					try { 
						Scanner entrada = new Scanner(fichero);
						entrada.nextLine();
						String cadena = "";
						String[] linea;
						while (entrada.hasNext()) { //Lee si quedan datos en el fichero
							cadena = entrada.nextLine();
							linea = cadena.split(";"); //Aquí se guardarán los datos
							//Añado los datos al AL
							if(CodGrup.getText().length()==0) {
								grupos.add(new Grupos(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]), linea[3]));
							} else if(CodGrup.getText().equals(linea[0])) {
								grupos.add(new Grupos(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]), linea[3]));
							}
						}
						entrada.close();
					} catch (Exception  e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			//Método para escribir los grupos
				public void escribirGrupos() {
				if(grupos.isEmpty()) {
					textArea.append("\n");
					textArea.append("\n");
					textArea.append("\t**El código introducido no corresponde a ningún grupo**");

				}else {
				textArea.append("                   GRUPO\t\t||          AÑO          ||      GÉNERO \n");
				textArea.append("---------------------------------------------------------------------------------------------------------------\n");
				for (Grupos x : grupos) {//Imprimimos los datos del AL en el textArea
					textArea.append("          "+x.getNombre()+" (cod:"+x.getCodigo()+")\t\t||          "+x.getYear()+"          ||           "+x.getGenero()+ "\n");
					textArea.append("---------------------------------------------------------------------------------------------------------------\n");
					}
				}
				}
			//Método de lectura de las canciones
				public void leerCanciones(String filename) {
					File fichero = new File(filename);
					try { 
						Scanner entrada = new Scanner(fichero);
						entrada.nextLine();
						String cadena = "";
						String[] linea;
						while (entrada.hasNext()) { //Lee si quedan datos en el fichero
							cadena = entrada.nextLine();
							linea = cadena.split(";"); //Aquí se guardarán los datos
							//Añado los datos al AL
							if(CodGrup.getText().length()==0) {
								canciones.add(new Canciones(Integer.parseInt(linea[0]), linea[1], linea[2], Integer.parseInt(linea[3]), Integer.parseInt(linea[4])));
							} else if(CodGrup.getText().equals(linea[0])) {
								canciones.add(new Canciones(Integer.parseInt(linea[0]), linea[1], linea[2], Integer.parseInt(linea[3]), Integer.parseInt(linea[4])));
							}
						}
						entrada.close();
					} catch (Exception  e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Método para escribir las canciones
				public void escribirCanciones() {
					String discoAnteior="";
					int cont=0;
					
				if(canciones.isEmpty()) {
					textArea.append("\n");
					textArea.append("\n");
					textArea.append("\t**El código introducido no corresponde a ningún grupo**");
				}else {
					for (Canciones x : canciones) {
						if (!discoAnteior.equals(x.getDisco())) {
							if(cont!=0) {
								textArea.append("---------------------------------------------------------------------------------------------------------------\n");
								cont=0;
							}
						textArea.append("     Disco: "+x.getDisco()+"\n");
						cont++;
						textArea.append("\t0"+cont+". "+x.getNombre()+" ("+x.getMin()+":"+x.getSeg()+")\n");
						discoAnteior=x.getDisco();
						} else {
							if(cont<9) {
								cont++;
								textArea.append("\t0"+cont+". "+x.getNombre()+" ("+x.getMin()+":"+x.getSeg()+")\n");
							}else {
								cont++;
								textArea.append("\t"+cont+". "+x.getNombre()+" ("+x.getMin()+":"+x.getSeg()+")\n");
							}
						}
					}
				}
				}
}