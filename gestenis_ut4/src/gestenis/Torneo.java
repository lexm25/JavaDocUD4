package gestenis;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Alejandro Martin Alvarez
 *
 */
public class Torneo {

	
	/**
	* No usados
	* 
	public static String GRAND_SLAM = "Grand Slam";
	public static String MASTER1000 = "ATP World Tour Master 1000";
	public static String MASTER500 = "ATP World Tour 500";
	public static String MASTER250 = "ATP World Tour 250";
	*/
	
	private String nombreTorneo;
	private int puntuacion;

	Torneo(String nombreTorneo, int puntuacion) {
		this.nombreTorneo = nombreTorneo;
		this.puntuacion = puntuacion;
	}

	/**
	 * @return nombreTorneo Devuelve el nombre del torneo
	 */
	public String getnombreTorneo() {
		return nombreTorneo;
	}

	/**
	 * @param nombreTorneo Asignamos un nombre de torneo
	 */
	public void setnombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}

	/**
	 * @return puntuacion Devuelve la puntuacion asignada al torneo
	 */
	public int getPuntuacion() {
		return puntuacion;
	}

	/**
	 * @param puntuacion Introducimos la puntuacion asignada para el torneo
	 */
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	/**
	 * @param fichero Carga los datos del fichero en el ArrayList lista
	 * @return devuelve true si todo ha ido bien o false si ha fallado algo
	 */
	public static ArrayList<Torneo> cargar(File fichero) {
		ArrayList<Torneo> lista = null;
		try {
			lista = new ArrayList<Torneo>();
			ObjectInputStream ficheroEntrada = null;
			ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
			lista = (ArrayList<Torneo>) ficheroEntrada.readObject();
			ficheroEntrada.close();
			return lista;
		} catch (ClassNotFoundException cnfe) {
			return null;
		} catch (FileNotFoundException fnfe) {
			return null;
		} catch (IOException ioe) {
			return null;
		}
	}

	/**
	 * @param lista Se pasa un ArrayList lista con los datos
	 * @param fichero Guarda los datos del ArrayList lista en el fichero
	 * @return Si todo ha ido bien devuelve true y en caso contrario false
	 */
	public static boolean guardar(ArrayList<Torneo> lista, File fichero) {
		try {
			ObjectOutputStream sal = null;
			sal = new ObjectOutputStream(new FileOutputStream(fichero));
			sal.writeObject(lista);
			sal.flush();
			sal.close();
			return true;
		} catch (FileNotFoundException fnfe) {
			return false;
		} catch (IOException ioe) {
			return false;
		}
	}
	
}
