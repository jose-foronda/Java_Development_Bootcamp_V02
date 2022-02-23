import java.util.ArrayList;  
import java.util.Scanner; 

public class AlumnGradesControlTest {

	public static void main(String[] args) 
	{
		/*			*** Exercise week three ***
		 * // "Crear un branch con el nombre practica-adicional-semana3: // La idea es
		 * practicar ciclos, dobles con vectores, máximo, mínimo, promedio. // realizar
		 * el siguiente ejercicios: // La escuela primaria xyz solicita el desarrollo de
		 * una aplicación para poder llevar el control de notas para cada alumno. // El
		 * programa solicitará el ingreso la cantidad de alumnos a procesar. // Para
		 * cada alumno se deberá ingresar los siguientes datos: // - nombre (string) //
		 * - apellido (string) // - número de examen // - nota que obtubo el alumno
		 * (númerico >=0 <=10) // Al finalizar la carga de datos, se procederá a listar
		 * la siguiente información: // 1- alumno/s con la calificación mas alta // 2-
		 * alumno/s con la calificación mas baja // 3- alumnos que promocionan, aquellos
		 * que obtubieron un promerdio >= 7 // 4- alumnos que deben recursar la materia,
		 * aquellos que obtuvieron un promedio < 7"""
		 */		
		
		//user input
		Scanner userInputScanner = new Scanner(System.in);

		System.out.println("**** Program to Control test scores of alumns ****");
		System.out.println();
		System.out.println();
		
		
		System.out.print("Please enter the NUMBER OF ALUMNS to process: ");
		byte alumnNumber = userInputScanner.nextByte();
		userInputScanner.nextLine();
 
		System.out.print("Please enter the NUMBER OF TESTS per-alumn to process: ");
		byte testNumber = userInputScanner.nextByte();
		userInputScanner.nextLine();
		
		ArrayList<Alumno> alumnList = new ArrayList<Alumno>();
		
		byte alumnCounter = 0;
		while (alumnCounter < alumnNumber) 
		{ 
			alumnCounter++;
			
			System.out.println();
			System.out.println();
			System.out.print("Please enter the FIRST-NAME of the ALUMN #" + alumnCounter + " : ");
			String AlumnfirstName = userInputScanner.nextLine();
 			
			System.out.print("Please enter the LAST-NAME of the ALUMN #" + alumnCounter + " : ");
			String AlumnLastName = userInputScanner.nextLine();
 						
			Test[] alumnTests = new Test[testNumber];
			for (int i = 0; i < testNumber; i++) 
			{
				System.out.print("Please enter the TEST-NUMBER for the ALUMN #" + alumnCounter + " : ");		
				byte testId = userInputScanner.nextByte();
				userInputScanner.nextLine();
				
				float testGrade = 0;
				do 
				{
					System.out.print("Please enter the GRADE ( 0=< grade <= 10) obtained for the TEST " + testId + " for the ALUMN #" + alumnCounter + " : ");		
					testGrade = Float.parseFloat(userInputScanner.next());
					userInputScanner.nextLine();
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
		
		//Compute the mean-score for each Alumn instance.
		for (int i = 0; i < alumnList.size(); i++) 
		{
			alumnList.get(i).computeMeanScore();
		}
		
		//Prints each Alumn instance and the associated information
		for (int i = 0; i < alumnList.size(); i++) 
		{
			System.out.print((i + 1) + "- name: " + alumnList.get(i).getFirstName() + ". Last-name: " + alumnList.get(i).getLastName() + ".   ");
			System.out.println();
			for (int j = 0; j < testNumber; j++) {
				System.out.print("| test" + (j + 1) + " = " + alumnList.get(i).getTestArray()[j].getTestScore() + "  |");
			}
			
			System.out.print(" *mean-score: " + alumnList.get(i).getMeanScore());
	
			System.out.println();
			System.out.println();
		}
		
		Alumno auxAlumn;
		// Sorts the mean-score values.
		for (int i = 0; i < alumnList.size(); i++) 
		{
			for (int j = 0; j < alumnList.size() - 1; j++) 
			{
				if( alumnList.get(j).getMeanScore() > alumnList.get(j + 1).getMeanScore() )
				{
					auxAlumn = alumnList.get(j + 1);
					alumnList.set( j + 1, alumnList.get(j) );
					alumnList.set(j, auxAlumn);
				}
			}
		}
		
		//Listing information section
		System.out.println();
		System.out.println();
		System.out.println("*** Ordered scores *** ");
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < alumnList.size(); i++) 
		{
			System.out.print((i + 1) + "- name: " + alumnList.get(i).getFirstName() + ". Last-name: " + alumnList.get(i).getLastName() + ".   ");
			System.out.println();
			for (int j = 0; j < testNumber; j++) {
				System.out.print("| test" + (j + 1) + " = " + alumnList.get(i).getTestArray()[j].getTestScore() + "  |");
			}
			
			System.out.print( " -mean score: " + alumnList.get(i).getMeanScore());
			
			System.out.println();
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("*** Alumns with the lowest mean-score *** ");
		System.out.println();
		System.out.println();
		
		float minScore = alumnList.get(0).getMeanScore();
		byte countLowestScore = 1;
		for (int i = 0; i < alumnList.size() - 1; i++) 
		{
			if ( minScore == alumnList.get(i + 1).getMeanScore() ) 
			{
				countLowestScore++;
			}
		}
		
		for (int i = 0; i < countLowestScore ; i++) 
		{
			System.out.print((i + 1) + "- name: " + alumnList.get(i).getFirstName() + ". Last-name: " + alumnList.get(i).getLastName() + ".   ");
			System.out.println();
			for (int j = 0; j < testNumber; j++) {
				System.out.print("| test" + (j + 1) + " = " + alumnList.get(i).getTestArray()[j].getTestScore() + "  |");
			}
			
			System.out.print(" *mean-score: " + alumnList.get(i).getMeanScore());
	
			System.out.println();
			System.out.println();			
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("*** Alumns with the highest mean-score *** ");
		System.out.println();
		System.out.println();
		
		float maxScore = alumnList.get(alumnList.size() - 1).getMeanScore();
		byte countHighestScore = 1;
		for (int i = alumnList.size() - 1; i > 0; i--) 
		{
			if ( maxScore == alumnList.get(i - 1).getMeanScore() ) 
			{
				countHighestScore++;
			}
		}
		
		for (int i = alumnList.size() - 1; i >= alumnList.size() - countHighestScore ; i--) 
		{
			System.out.print( "- name: " + alumnList.get(i).getFirstName() + ". Last-name: " + alumnList.get(i).getLastName() + ".   ");
			System.out.println();
			for (int j = 0; j < testNumber; j++) {
				System.out.print("| test" + (j + 1) + " = " + alumnList.get(i).getTestArray()[j].getTestScore() + "  |");
			}
			
			System.out.print(" *mean-score: " + alumnList.get(i).getMeanScore());
	
			System.out.println();
			System.out.println();			
		}
				
		
		
		System.out.println();
		System.out.println();
		System.out.println("*** Alumns that PASS the course (mean-score >=7) *** ");
		System.out.println();
		System.out.println();
		
		for (int i = alumnList.size() - 1; i >= 0; i--) 
		{
			if (alumnList.get(i).getMeanScore() >= 7) 
			{
				System.out.print( "- name: " + alumnList.get(i).getFirstName() + ". Last-name: " + alumnList.get(i).getLastName() + ".   ");
				System.out.println();
				for (int j = 0; j < testNumber; j++) {
					System.out.print("| test" + (j + 1) + " = " + alumnList.get(i).getTestArray()[j].getTestScore() + "  |");
				}
				
				System.out.print(" *mean-score: " + alumnList.get(i).getMeanScore());
		
				System.out.println();
				System.out.println();					
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("*** Alumns that FAIL the course (mean-score < 7) *** ");
		System.out.println();
		System.out.println();
		
		for (int i = alumnList.size() - 1; i >= 0; i--) 
		{
			if (alumnList.get(i).getMeanScore() < 7) 
			{
				System.out.print( "- name: " + alumnList.get(i).getFirstName() + ". Last-name: " + alumnList.get(i).getLastName() + ".   ");
				System.out.println();
				for (int j = 0; j < testNumber; j++) {
					System.out.print("| test" + (j + 1) + " = " + alumnList.get(i).getTestArray()[j].getTestScore() + "  |");
				}
				
				System.out.print(" *mean-score: " + alumnList.get(i).getMeanScore());
		
				System.out.println();
				System.out.println();					
			}
		}
		

	}

}
