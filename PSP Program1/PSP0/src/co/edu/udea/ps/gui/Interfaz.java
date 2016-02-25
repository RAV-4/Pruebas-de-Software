package co.edu.udea.ps.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import co.edu.udea.ps.rs.ListaDobleLigada;

public class Interfaz extends JFrame implements ActionListener {

	private JPanel opciones;
	private JPanel ingresoDatos;
	private JPanel resultados;
	private JPanel panelInferior;
	private JButton archivo;
	private JButton teclado;
	private JButton procesarTeclado;
	private JButton cancelarTeclado;
	private JButton regresar;
	private JButton bSalir;
	private JTextArea instruccion;
	private JTextArea nota;
	private JTextArea datosEscritos;
	private JTable tabla;
	private JScrollPane scroll;
	private JFileChooser selecionar;
	private FileNameExtensionFilter filtroExtension;
	private File archivoSelecionado;
	private String datos;
	private int origen; // 1 si es de archivo, 2 si es de teclado
	private ListaDobleLigada lista;

	public Interfaz() {
		super("Prueba");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		setOpacity(0.70f);
		elementos();
	}

	private void elementos() {
		opciones = new JPanel();
		opciones.setSize(this.getWidth(), 120);
		opciones.setLocation(0, 0);
		opciones.setLayout(null);
		this.add(opciones);
		
		ingresoDatos = new JPanel();
		ingresoDatos.setSize(600, 350);
		ingresoDatos.setLocation(50, 140);
		ingresoDatos.setLayout(null);
		ingresoDatos.setVisible(false);
		this.add(ingresoDatos);
		
		resultados = new JPanel();
		resultados.setSize(600, 350);
		resultados.setLocation(50, 140);
		resultados.setLayout(null);
		resultados.setVisible(false);
		this.add(resultados);

		instruccion = new JTextArea(
				"Escoja una de las siguientes opciones\n" + "· Archivo para importar los datos desde un .TXT\n"
						+ "· Teclado para ingresar los datos manualmente\n");
		instruccion.setEditable(false);
		instruccion.setBackground(null);
		instruccion.setSize(320, 65);
		instruccion.setLocation(40, 10);
		opciones.add(instruccion);

		nota = new JTextArea(
				"Tenga en cuenta que:\n· Los datos deben estar separados por una coma.\n· El punto se considera separación decimal\n"
						+ "· Cualquier otro caracter sera omitido");
		nota.setEditable(false);
		nota.setBackground(null);
		nota.setSize(320, 65);
		nota.setLocation(440, 10);
		opciones.add(nota);

		archivo = new JButton("Archivo");
		archivo.setSize(100, 30);
		archivo.setLocation(250, 80);
		archivo.addActionListener(this);
		archivo.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		opciones.add(archivo);

		teclado = new JButton("Teclado");
		teclado.setSize(100, 30);
		teclado.setLocation(450, 80);
		teclado.addActionListener(this);
		teclado.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		opciones.add(teclado);

		panelInferior = new JPanel();
		panelInferior.setSize(this.getWidth(), 80);
		panelInferior.setLocation(0, this.getHeight() - 80);
		panelInferior.setLayout(null);
		this.add(panelInferior);

		bSalir = new JButton("Salir");
		bSalir.setSize(100, 30);
		bSalir.setLocation(this.getWidth() - 140, 25);
		bSalir.addActionListener(this);
		bSalir.setBorder(BorderFactory.createLineBorder(Color.RED));
		panelInferior.add(bSalir);

		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == archivo) {
			if(resultados.isVisible()){
				resultados.setVisible(false);
			}
			if(ingresoDatos.isVisible()){
				ingresoDatos.setVisible(false);
			}
			selecionarArchivo();
		}
		if (e.getSource() == teclado) {
			ingresarDatos();
		}
		if (e.getSource() == bSalir) {
			System.exit(0);
		}
		if (e.getSource() == procesarTeclado) {
			datos = datosEscritos.getText();
			origen = 2;
			ingresoDatos.setVisible(false);
			validarDatos(datos);
		}
		if (e.getSource() == cancelarTeclado) {
			datosEscritos.setText(null);
		}
		if (e.getSource() == regresar){
			
		}
	}

	private void ingresarDatos() {
		if(resultados.isVisible()){
			resultados.setVisible(false);
		}
		ingresoDatos.setVisible(true);

		datosEscritos = new JTextArea();
		datosEscritos.setLineWrap(false);
		scroll = new JScrollPane(datosEscritos);
		scroll.setSize(500, 200);
		scroll.setLocation(100, 25);
		scroll.setBackground(Color.LIGHT_GRAY);
		ingresoDatos.add(scroll);
		datosEscritos.setText("Ok");
		datosEscritos.setText(null);

		procesarTeclado = new JButton("Procesar");
		procesarTeclado.setSize(100, 30);
		procesarTeclado.setLocation(400, 240);
		procesarTeclado.addActionListener(this);
		procesarTeclado.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		ingresoDatos.add(procesarTeclado);

		cancelarTeclado = new JButton("Cancelar");
		cancelarTeclado.setSize(100, 30);
		cancelarTeclado.setLocation(200, 240);
		cancelarTeclado.addActionListener(this);
		cancelarTeclado.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		ingresoDatos.add(cancelarTeclado);

		this.repaint();
	}

	private void selecionarArchivo() {
		selecionar = new JFileChooser();
		selecionar.setFileSelectionMode(JFileChooser.FILES_ONLY);
		filtroExtension = new FileNameExtensionFilter("*.TXT", "txt");
		selecionar.setFileFilter(filtroExtension);
		int seleccion = selecionar.showOpenDialog(getRootPane());
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			archivoSelecionado = selecionar.getSelectedFile();
			try (FileReader lectorArchivo = new FileReader(archivoSelecionado)) {
				datos = "";
				int valor = lectorArchivo.read();
				while (valor != -1) {
					datos = datos + (char) valor;
					valor = lectorArchivo.read();
				}
				origen = 1;
				validarDatos(datos);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void validarDatos(String datos) {
		lista = new ListaDobleLigada();
		try (StringReader lector = new StringReader(datos)) {
			int recorrer = lector.read();
			String aux = "";
			double numero;
			while (recorrer != -1) {
				if (',' == (char) recorrer) {
					numero = Double.parseDouble(aux);
					lista.insertar(numero);
					aux = "";
				} else {
					if (Character.isDigit(recorrer) || '.' == (char) recorrer) {
						aux = aux + (char) recorrer;
					}
				}
				recorrer = lector.read();
			}
			if (aux != "") {
				numero = Double.parseDouble(aux);
				lista.insertar(numero);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!lista.esVacia()) {
			procesarDatos();
		} else {
			if(origen ==1){
				JOptionPane.showMessageDialog(null, "Sin datos validos para procesar\nIntente de nuevo");
			}
			if(origen == 2){
				JOptionPane.showMessageDialog(null, "Sin datos validos para procesar\nIntente de nuevo");
				ingresarDatos();
			}
		}
	}

	private void procesarDatos() {
		resultados.setVisible(true);

		tabla = new JTable(2, 3);
		tabla.setLocation(100, 60);
		tabla.setSize(500, 30);
		tabla.setValueAt("Numero de datos", 0, 0);
		tabla.setValueAt("Media", 0, 1);
		tabla.setValueAt("Desviacíon Estandar", 0, 2);
		tabla.setValueAt(lista.tamaño(), 1, 0);
		tabla.setValueAt(lista.media(), 1, 1);
		tabla.setValueAt(lista.desviacion(), 1, 2);
		tabla.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		tabla.setGridColor(Color.BLUE);
		resultados.add(tabla);

		this.repaint();
	}
}