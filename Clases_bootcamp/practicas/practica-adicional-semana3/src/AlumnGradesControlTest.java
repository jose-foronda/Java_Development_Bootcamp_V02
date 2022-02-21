import java.util.ArrayList;  
import java.util.Scanner;

public class AlumnGradesControlTest {

	public static void main(String[] args) 
	{
//		"Crear un branch con el nombre practica-adicional-semana3:
//		 La idea es practicar ciclos, dobles con vectores, máximo, mínimo, promedio.
//		 realizar el siguiente ejercicios:
//		 La escuela primaria xyz solicita el desarrollo de una aplicación para poder llevar el control de notas para cada alumno.
//		 El programa solicitará el ingreso la cantidad de alumnos a procesar.
//		 Para cada alumno se deberá ingresar los siguientes datos:
//		 - nombre (string)
//		 - apellido (string)
//		 - número de examen
//		 - nota que obtubo el alumno (númerico >=0 <=10)
//		 Al finalizar la carga de datos, se procederá a listar la siguiente información:
//		 1- alumno/s con la calificación mas alta
//		 2- alumno/s con la calificación mas baja
//		 3- alumnos que promocionan, aquellos que obtubieron un promerdio >= 7
//		 4- alumnos que deben recursar la materia, aquellos que obtuvieron un promedio < 7"""
		
		
		//user input
		Scanner userInputScanner = new Scanner(System.in);
		
		System.out.println("**** Program to Control test scores of alumns ****");
		System.out.println();
		System.out.println();
		
		
		System.out.println("Please enter the number of alumns to process: ");
		byte alumnNumber = userInputScanner.nextByte();
		
		System.out.println();
		System.out.println();
		System.out.println("Please enter the number of tests per alumn to process: ");
		byte testNumber = userInputScanner.nextByte();
		
		ArrayList<Alumno> alumnList = new ArrayList<Alumno>();
		
		byte alumnCounter = 0;
		while (alumnCounter < alumnNumber) 
		{ 
			alumnCounter++;
			
			System.out.println("Please enter the first name of the alumn #" + alumnCounter + " : ");
			String AlumnfirstName = userInputScanner.next();
			
			System.out.println("Please enter the last name of the alumn #" + alumnCounter + " : ");
			String AlumnLastName = userInputScanner.next();
			
			Test[] alumnTests = new Test[testNumber];
			for (int i = 0; i < testNumber; i++) 
			{
				System.out.println("Please enter the number of the test for the alumn #" + alumnCounter + " : ");		
				byte testId = userInputScanner.nextByte();
				
				System.out.println("Please enter the grade ( 0=< grade <= 10) obtained for the test " + testId + " for the alumn #" + alumnCounter + " : ");		
				float testGrade = userInputScanner.nextFloat();
				
				alumnTests[i] = new Test(testId, testGrade);
			}
			
			alumnList.add(new Alumno(AlumnfirstName, AlumnLastName, alumnTests));

		}
		
		userInputScanner.close();
		
		//Listing information section
		System.out.println("*** the entered alumns and their grades are *** ");
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < alumnList.size(); i++) 
		{
			System.out.print(i + "- name: " + alumnList.get(i).getFirstName() + ". Last name: " + alumnList.get(i).getLastName());
			
			for (int j = 0; j < testNumber; j++) {
				
			}
		}
		
		
		
		
//		System.out.println((1+alumnNumber));

	}

}
