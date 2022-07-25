package com.protalento.DataBaseConnector;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class Main_CSV {
	public static void main(String[] args) {
		 try (CSVPrinter printer = new CSVPrinter(new FileWriter("text.csv"), CSVFormat.EXCEL)) {
		     printer.printRecord("id", "userName", "firstName", "lastName", "birthday");
		     printer.printRecord(1, "john73", "John", "Doe", LocalDate.of(1973, 9, 15));
		     printer.println();
		     printer.printRecord(2, "mary", "Mary", "Meyer", LocalDate.of(1985, 3, 29));
		 } catch (IOException ex) {
		     ex.printStackTrace();
		 }
	}
}
