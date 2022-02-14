import java.util.Scanner;

public class TestDateValidation 
{
	public static void main(String[] args) 
	{
		// Exercise
//		"Crear un brach con el nombre practica-semanal-semana2:
//	     Realizar el ejercicio validación de fechas:
//	     Ingresar una fecha dd/mm/yyyy
//	     validar que dd >=1 && <=31 TENIENDO EN CUENTA EL MES
//	     validar que mes >=1 && <=12
//	     validar que anio >=1900 && <= 2099"
		
		//enero tiene 31 siempre.
		//febrero tiene normalmente 28, y 29 cuando el numero de años es divisible x4
		//marzo tiene 31 siempre.
		//abril tiene 30 siempre.
		//mayo tiene 31 siempre.
		//junio tiene 30 siempre.
		//Julio tiene 31 siempre.
		//agosto tiene 31 siempre.
		//septiembre tiene 30 siempre.
		//octubre tiene 31 siempre.
		//noviembre tiene 30 siempre.
		//diciembre tiene 31 siempre.
		
		Scanner userInput = new Scanner(System.in);
		
		String testDateString = "";
		
		do {
			System.out.println("Introduce a date with the format DD/MM/YYYY  (Valid years are >= 1900 and <=2099) :  ");
//			testDateString = "28/02/2099";
			testDateString = userInput.next();
			
		} while ( !(testDateString.split("/").length == 3) );
		
		userInput.close();
		
		
		DateValidation dateValidator = new DateValidation();
		
		String validation = dateValidator.validateDate(testDateString) ? "VALID" : "INVALID";
		
		System.out.println( "the date " + testDateString +" is " + validation );
	}
}
