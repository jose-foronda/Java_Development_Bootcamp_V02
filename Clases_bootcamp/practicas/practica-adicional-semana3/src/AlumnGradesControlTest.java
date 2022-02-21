import java.util.ArrayList;  
import java.util.Scanner;

public class AlumnGradesControlTest {

	public static void main(String[] args) 
	{
//		"Crear un branch con el nombre practica-adicional-semana3:
//		 La idea es practicar ciclos, dobles con vectores, m�ximo, m�nimo, promedio.
//		 realizar el siguiente ejercicios:
//		 La escuela primaria xyz solicita el desarrollo de una aplicaci�n para poder llevar el control de notas para cada alumno.
//		 El programa solicitar� el ingreso la cantidad de alumnos a procesar.
//		 Para cada alumno se deber� ingresar los siguientes datos:
//		 - nombre (string)
//		 - apellido (string)
//		 - n�mero de examen
//		 - nota que obtubo el alumno (n�merico >=0 <=10)
//		 Al finalizar la carga de datos, se proceder� a listar la siguiente informaci�n:
//		 1- alumno/s con la calificaci�n mas alta
//		 2- alumno/s con la calificaci�n mas baja
//		 3- alumnos que promocionan, aquellos que obtubieron un promerdio >= 7
//		 4- alumnos que deben recursar la materia, aquellos que obtuvieron un promedio < 7"""
		
		
		//user input
		Scanner userInputScanner = new Scanner(System.in);

		System.out.println("**** Program to Control test scores of alumns ****");
		System.out.println();
		System.out.println();
		
		
		System.out.print("Please enter the NUMBER OF ALUMNS to process: ");
		byte alumnNumber = userInputScanner.nextByte();
		
//		System.out.println();
//		System.out.println();
		System.out.print("Please enter the NUMBER OF TESTS per-alumn to process: ");
		byte testNumber = userInputScanner.nextByte();
		
		ArrayList<Alumno> alumnList = new ArrayList<Alumno>();
		
		byte alumnCounter = 0;
		while (alumnCounter < alumnNumber) 
		{ 
			alumnCounter++;
			
			System.out.println();
			System.out.println();
			System.out.print("Please enter the FIRST-NAME of the ALUMN #" + alumnCounter + " : ");
			String AlumnfirstName = userInputScanner.next();
			
			System.out.print("Please enter the LAST-NAME of the ALUMN #" + alumnCounter + " : ");
			String AlumnLastName = userInputScanner.next();
			
			Test[] alumnTests = new Test[testNumber];
			for (int i = 0; i < testNumber; i++) 
			{
				System.out.print("Please enter the TEST-NUMBER for the ALUMN #" + alumnCounter + " : ");		
				byte testId = userInputScanner.nextByte();
				
				float testGrade = 0;
				do 
				{
					System.out.print("Please enter the GRADE ( 0=< grade <= 10) obtained for the TEST " + testId + " for the ALUMN #" + alumnCounter + " : ");		
					testGrade = Float.parseFloat(userInputScanner.next());
				} while ( !((testGrade >= 0) && (testGrade <= 10)) );

				
				alumnTests[i] = new Test(testId, testGrade);
			}
			
			alumnList.add(new Alumno(AlumnfirstName, AlumnLastName, alumnTests));

		}
		
		userInputScanner.close();
		
		//Listing information section
		System.out.println();
		System.out.println();
		System.out.println("*** the entered alumns and their grades are *** ");
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < alumnList.size(); i++) 
		{
			System.out.print((i + 1) + "- name: " + alumnList.get(i).getFirstName() + ". Last-name: " + alumnList.get(i).getLastName() + ".   ");
			System.out.println();
			for (int j = 0; j < testNumber; j++) {
				System.out.print("| test" + (j + 1) + " = " + alumnList.get(i).getTestArray()[j].getTestScore() + "  |");
			}
			
			System.out.println();
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("*** Alumns with the best mean-score *** ");
		
		for (int i = 0; i < alumnList.size(); i++) 
		{
			
		}
		
//		System.out.println((1+alumnNumber));

	}

}
