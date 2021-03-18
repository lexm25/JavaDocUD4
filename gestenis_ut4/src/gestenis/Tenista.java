package gestenis;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Alejandro Martin Alvarez
 *
 */
public class Tenista {
	private String nombre;
	private int edad;
	private ArrayList<Torneo> palmares;

	/**
	 * Constructor sobrecargado de la clase
	 * 
	 * @param nombre recibe el nombre y lo sobreescribe
	 * @param edad   recibe la edad y la sobreescribe
	 */
	Tenista(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		palmares = new ArrayList<Torneo>();
	}

	/**
	 * @return nombre Obtenemos el nombre del tenista
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Asignamos el nombre del tenista
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return edad Nos devuelve la edad del tenista
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad Asigna la edad del tenista
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return Devuelve el palmares con los nombres de los torneos ganados
	 */
	public String[] getPalmares() {
		String[] p = new String[palmares.size()];
		for (int i = 0; i < p.length; i++) {
			p[i] = palmares.get(i).getnombreTorneo();
		}
		return p;
	}

	/**
	 * @param torneo Anade el torneo ganado al palmares
	 */
	public void aniadirPalmares(Torneo torneo) {
		palmares.add(torneo);
	}

	/**
	 * @return Recorre un bucle acumulando la puntuacion obtenida
	 */
	public int getPuntuacionATP() {
		int p = 1;
		p = 0;
		for (Torneo t : palmares) {
			p += t.getPuntuacion();
		}
		return p;
	}

	/**

	 * @param fichero Carga en fichero el archivo seleccionado e introduce sus datos
	 *                en el ArrayList Tenista
	 * @return Devuelve la lista de Tenistas
	 */
	public static ArrayList<Tenista> cargar(File fichero) {
		ArrayList<Tenista> l = null;
		ObjectInputStream ficheroEntrada = null;
		try {
			ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
			l = (ArrayList<Tenista>) ficheroEntrada.readObject();
			ficheroEntrada.close();
			return l;
		} catch (ClassNotFoundException onfe) {
			return null;
		} catch (FileNotFoundException fnfe) {
			return null;
		} catch (IOException ioe) {
			return null;
		}
	}

	/**
	 * @param lista Se le pasa un ArrayList lista con los datos
	 * @param fichero Graba en fichero los datos del ArrayList lista
	 * @return Devuelve true si ha sido todo correcto o false en caso contrario
	 */
	public static boolean guardar(ArrayList<Tenista> lista, File fichero) {
		try {
			ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
			ficheroSalida.writeObject(lista);
			ficheroSalida.flush();
			ficheroSalida.close();
			return true;
		} catch (FileNotFoundException fnfe) {
			return false;
		} catch (IOException ioe) {
			return false;
		}
	}

}
