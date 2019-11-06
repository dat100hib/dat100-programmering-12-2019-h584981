package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {
		Blogg blogg = new Blogg();
		int id;
		String bruker;
		String dato;
		int likes;
		String tekst;
		String url;

		Innlegg innlegg;

		try {
			BufferedReader br = new BufferedReader(new FileReader(MAPPE + filnavn));
			String line = br.readLine();

			blogg = new Blogg(Integer.parseInt(line));

			while ((line = br.readLine()) != null) {
				if (line.equals(TEKST)) {
					id = Integer.parseInt(br.readLine());
					bruker = br.readLine();
					dato = br.readLine();
					likes = Integer.parseInt(br.readLine());
					tekst = br.readLine();

					innlegg = new Tekst(id, bruker, dato, likes, tekst);
				} else {
					id = Integer.parseInt(br.readLine());
					bruker = br.readLine();
					dato = br.readLine();
					likes = Integer.parseInt(br.readLine());
					tekst = br.readLine();
					url = br.readLine();

					innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
				}

				blogg.leggTil(innlegg);
			}

			br.close();
		} catch (IOException e) {
			System.err.println(e);
		}

		return blogg;

	}
}
