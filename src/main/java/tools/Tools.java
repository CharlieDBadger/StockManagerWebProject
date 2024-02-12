package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Tools {

	public static String pideDatoTexto (String texto) {
		String reply=null;
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		reply = scan.nextLine();
		
		return reply;
	}
	
	public static int pideDatoNumerico (String texto) {
		int reply=0;
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		reply = scan.nextInt();
		
		return reply;
	}
	
	public static int pintarMenu(String menu) {
		
		return pintarMenu(menu, "Introduce una opción", "\n");
	}
	
	
	public static int pintarMenu(String menu, String pregunta, String caracterSeparacion) {
		
		
		return pintarMenu(menu.split(caracterSeparacion),pregunta);
	}
	
	
	public static int pintarMenu(String[] menu, String pregunta) {
		for (String opcion : menu) {
			System.out.println(opcion);
		}
		//Pido la opción del menú
		int opcion = pideDatoNumerico(pregunta);
		
		return opcion;
	}
	
    public static Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            return sdf.parse(dateString);
        }
    
}
