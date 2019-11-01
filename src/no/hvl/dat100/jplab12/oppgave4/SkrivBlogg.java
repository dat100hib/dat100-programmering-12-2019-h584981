package no.hvl.dat100.jplab12.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab12.oppgave3.*;
import no.hvl.dat100.jplab12.common.TODO;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) {
		Boolean success = false;
		
		try{
			PrintWriter pr = new PrintWriter(MAPPE + filnavn);
			
			String output = samling.toString();
			
			pr.print(output);
			
			pr.close();
			
			success = true;
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
		
		return success;
	}
}
