package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.Coche;

public class Main {

	// ATRIBUTOS
	private JFrame frmAparcamientoTejonY;
	private JTextField matriculaField;
	private JButton btnRegistrar;
	private JTextField matricula2Field;
	private JTextField horaEntradaField;
	private JTextField horaSalidaField;
	private JLabel lblTotal;
	private JLabel lblTotalPrecio;
	private JTextField importeField;
	private JLabel lblCambio;
	private JLabel lblCambioCliente;
	private JButton btnSalir;
	@SuppressWarnings("unused")
	private ArrayList<Coche> parking = new ArrayList<Coche>();
	private int hora1, minuto1, seg1;
	private int hora2, minuto2, seg2;
	private float minimoPrecio;
	private JButton btnPagar;
	private float total;
	private JButton btnCajaDelDia;
	private JButton btnEntrada;
	private JButton btnPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmAparcamientoTejonY.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		setPropiedades();
		setEventos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmAparcamientoTejonY = new JFrame();
		btnEntrada = new JButton("Entrada \r\nVehiculo");
		btnPago = new JButton("Pago Y Salida");
		btnCajaDelDia = new JButton("Caja del Dia");
		matriculaField = new JTextField();
		btnPagar = new JButton("Pagar");
		btnRegistrar = new JButton("Registrar");
		btnSalir = new JButton("Salir del Parking");
		matricula2Field = new JTextField();
		horaEntradaField = new JTextField();
		horaSalidaField = new JTextField();
		lblTotal = new JLabel("Total a pagar");
		lblTotalPrecio = new JLabel("\r\n");
		importeField = new JTextField();
		lblCambio = new JLabel("Cambio");
		lblCambioCliente = new JLabel("");
	}
	
	/**
	 * SETEO DE LAS PROPIEDADES
	 */
	public void setPropiedades() {

		frmAparcamientoTejonY.setResizable(false);
		frmAparcamientoTejonY.setTitle("Aparcamiento Tejon Y Rodriguez");
		frmAparcamientoTejonY.setBounds(100, 100, 443, 300);
		frmAparcamientoTejonY.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAparcamientoTejonY.getContentPane().setLayout(null);

		btnEntrada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEntrada.setBounds(10, 11, 130, 59);
		frmAparcamientoTejonY.getContentPane().add(btnEntrada);

		btnPago.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPago.setBounds(150, 11, 128, 59);
		frmAparcamientoTejonY.getContentPane().add(btnPago);

		btnCajaDelDia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCajaDelDia.setBounds(294, 11, 130, 59);
		frmAparcamientoTejonY.getContentPane().add(btnCajaDelDia);

		matriculaField.setText("Matricula");
		matriculaField.setBounds(138, 98, 162, 30);
		frmAparcamientoTejonY.getContentPane().add(matriculaField);
		matriculaField.setColumns(10);

		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRegistrar.setBounds(138, 162, 162, 89);
		frmAparcamientoTejonY.getContentPane().add(btnRegistrar);

		matricula2Field.setText("Matricula: ");
		matricula2Field.setEnabled(false);
		matricula2Field.setVisible(false);
		matricula2Field.setBounds(89, 81, 190, 35);
		frmAparcamientoTejonY.getContentPane().add(matricula2Field);
		matricula2Field.setColumns(10);

		horaEntradaField.setText("Hora Entrada:");
		horaEntradaField.setEnabled(false);
		horaEntradaField.setVisible(false);
		horaEntradaField.setBounds(88, 127, 190, 35);
		frmAparcamientoTejonY.getContentPane().add(horaEntradaField);
		horaEntradaField.setColumns(10);

		horaSalidaField.setText("Hora Salida:");
		horaSalidaField.setEnabled(false);
		horaSalidaField.setVisible(false);
		horaSalidaField.setBounds(89, 173, 190, 35);
		frmAparcamientoTejonY.getContentPane().add(horaSalidaField);
		horaSalidaField.setColumns(10);

		lblTotal.setVisible(false);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setEnabled(true);
		lblTotal.setBounds(307, 81, 117, 44);
		frmAparcamientoTejonY.getContentPane().add(lblTotal);

		lblTotalPrecio.setEnabled(false);
		lblTotalPrecio.setVisible(false);
		lblTotalPrecio.setBounds(310, 125, 117, 30);
		frmAparcamientoTejonY.getContentPane().add(lblTotalPrecio);

		importeField.setText("Importe");
		importeField.setEnabled(false);
		importeField.setVisible(false);
		importeField.setBounds(310, 162, 117, 30);
		frmAparcamientoTejonY.getContentPane().add(importeField);
		importeField.setColumns(10);

		lblCambio.setVisible(false);
		lblCambio.setEnabled(false);
		lblCambio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCambio.setBounds(310, 199, 117, 23);
		frmAparcamientoTejonY.getContentPane().add(lblCambio);

		lblCambioCliente.setEnabled(false);
		lblCambioCliente.setVisible(false);
		lblCambioCliente.setBounds(310, 226, 117, 35);
		frmAparcamientoTejonY.getContentPane().add(lblCambioCliente);

		btnSalir.setEnabled(false);
		btnSalir.setVisible(false);
		btnSalir.setBounds(89, 219, 190, 42);
		frmAparcamientoTejonY.getContentPane().add(btnSalir);

		btnPagar.setEnabled(false);
		btnPagar.setVisible(false);
		btnPagar.setBounds(89, 216, 190, 45);
		frmAparcamientoTejonY.getContentPane().add(btnPagar);
	}

	/**
	 * SETEO DE LOS EVENTOS
	 */
	public void setEventos() {
		matriculaField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				matriculaField.setText("");
			}
		});
		btnPago.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				matriculaField.setEnabled(true);
				matriculaField.setVisible(true);
				btnRegistrar.setEnabled(true);
				btnRegistrar.setVisible(true);
				matricula2Field.setVisible(false);
				horaSalidaField.setVisible(false);
				horaEntradaField.setVisible(false);
				lblTotal.setVisible(false);
				lblTotalPrecio.setVisible(false);
				importeField.setEnabled(false);
				importeField.setVisible(false);
				lblCambio.setVisible(false);
				lblCambio.setEnabled(false);
				lblCambioCliente.setEnabled(false);
				lblCambioCliente.setVisible(false);
				btnSalir.setEnabled(false);
				btnSalir.setVisible(false);

			}
		});
		btnPagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				/**
				 * SIEMPRE LE TIENES QUE METER UNA CANTIDAD
				 */
				btnPagar.setEnabled(true);
				btnPagar.setVisible(true);
				float importe = Float.parseFloat(importeField.getText());
				float cambio = (importe - total);
				lblCambioCliente.setText(cambio + " €");
			}
		});
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				/**
				 * ESTE IF NO ME PILLA LOS NULL O YO SOY BOBO
				 */
				if ((importeField.getText() == null || importeField.equals(""))) {
					JOptionPane.showMessageDialog(null, "¡¡ NO ME HAS PAGADO !!", "DE AQUI NO SALES",
							JOptionPane.ERROR_MESSAGE);
				} else {
					hora2 = 3;
					minuto2 = 46;
					seg2 = 02;
					/**
					 * TAMBIEN PONGO LA HORA A PELAZO POR FALTA DE TIEMPO
					 */
					horaSalidaField.setText("Hora Salida: " + hora2 + ":" + minuto2 + ":" + seg2);
					total = minimoPrecio + 5.48F;
					lblTotalPrecio.setText(total + " €");
					btnPagar.setEnabled(true);
					btnPagar.setVisible(true);
					btnSalir.setEnabled(false);
					btnSalir.setVisible(false);
				}
			}
		});
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				minimoPrecio = 3.75F;
				hora1 = 2;
				minuto1 = 23;
				seg1 = 45;
				/**
				 * VALIDACION DE LA MATRICULA
				 */
				String entrada = matriculaField.getText().replaceAll(" ", "").toUpperCase();
				// 4 NUMEROS + 3 LETRAS AL FINAL
				Pattern tresLetrasFinal = Pattern.compile("^\\d{4}[A-Za-z]{3}");
				Matcher matricula3letras = tresLetrasFinal.matcher(entrada);
				if (matricula3letras.matches()) {
					JOptionPane.showMessageDialog(null, "¡¡ Bienvenido Al TrvpKing !!", "Bienvenido Surmano",
							JOptionPane.INFORMATION_MESSAGE);
					// ListaCoches.add(a);
					matriculaField.setEnabled(false);
					matriculaField.setVisible(false);
					matricula2Field.setText(matriculaField.getText());
					btnRegistrar.setEnabled(false);
					btnRegistrar.setVisible(false);
					matricula2Field.setVisible(true);
					matricula2Field.setEnabled(true);
					horaSalidaField.setVisible(true);
					horaEntradaField.setVisible(true);
					/**
					 * PONGO LA HORA POR DEFECTO POR FALTA DE TIEMPO. SE QUE
					 * ESTO ESTA UN POCO GITANO
					 */
					horaEntradaField.setText("Hora Automatica: " + hora1 + ":" + minuto1 + ":" + seg1);
					lblTotal.setVisible(true);
					lblTotalPrecio.setVisible(true);
					lblTotalPrecio.setText(minimoPrecio + " €");
					importeField.setEnabled(true);
					importeField.setVisible(true);
					lblCambio.setVisible(true);
					lblCambio.setEnabled(true);
					lblCambioCliente.setEnabled(true);
					lblCambioCliente.setVisible(true);
					btnPagar.setEnabled(false);
					btnPagar.setVisible(false);
					btnSalir.setEnabled(true);
					btnSalir.setVisible(true);
					importeField.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Formato Matricula Incorrecto. Prueba con 1234ABC",
							"Error de formato", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		/**
		 * SETEO DE LOS VISIBLE Y ENABLED PARA NAVEGAR ENTRE VENTANAS
		 */
		btnEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				matriculaField.setEnabled(true);
				matriculaField.setVisible(true);
				btnRegistrar.setEnabled(true);
				btnRegistrar.setVisible(true);
				matricula2Field.setVisible(false);
				horaSalidaField.setVisible(false);
				horaEntradaField.setVisible(false);
				lblTotal.setVisible(false);
				lblTotalPrecio.setVisible(false);
				importeField.setEnabled(false);
				importeField.setVisible(false);
				lblCambio.setVisible(false);
				lblCambio.setEnabled(false);
				lblCambioCliente.setEnabled(false);
				lblCambioCliente.setVisible(false);
				btnSalir.setEnabled(false);
				btnSalir.setVisible(false);
				btnPagar.setEnabled(false);
				btnPagar.setVisible(false);
			}
		});
		btnCajaDelDia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Hoy ha facturado: " + total, "Volviendo A Entrada",
						JOptionPane.INFORMATION_MESSAGE);
				matriculaField.setEnabled(false);
				matriculaField.setVisible(false);
				btnRegistrar.setEnabled(false);
				btnRegistrar.setVisible(false);
				matricula2Field.setVisible(true);
				horaSalidaField.setVisible(true);
				horaEntradaField.setVisible(true);
				lblTotal.setVisible(true);
				lblTotalPrecio.setVisible(true);
				importeField.setEnabled(true);
				importeField.setVisible(true);
				lblCambio.setVisible(true);
				lblCambio.setEnabled(true);
				lblCambioCliente.setEnabled(true);
				lblCambioCliente.setVisible(true);
				btnSalir.setEnabled(true);
				btnSalir.setVisible(true);
			}
		});
	}
	/**
	 * ATENTAMENTE... BVRGUILLX O LO QUE QUEDA DE MI TRAS ESTE RATITO XXX SIN VASELINA
	 */

	// public void comprobarMatricula(String matricula) {
	// String entrada = matriculaField.getText().replaceAll(" ",
	// "").toUpperCase();
	// boolean esCorrecto = false;
	//
	// // 4 numeros, 3 letras al final
	// Pattern tresLetrasFinal = Pattern.compile("^\\d{4}[A-Za-z]{3}");
	// Matcher matricula3letras = tresLetrasFinal.matcher(entrada);
	// }
}
