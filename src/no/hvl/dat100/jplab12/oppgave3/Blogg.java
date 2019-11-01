package no.hvl.dat100.jplab12.oppgave3;

import java.util.Arrays;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	protected int nesteLedige;
	protected Innlegg[] innleggTabell;

	public Blogg() {
		this.innleggTabell = new Innlegg[20];
		this.nesteLedige = 0;
	}

	public Blogg(int lengde) {
		this.innleggTabell = new Innlegg[lengde];
		this.nesteLedige = 0;
	}

	public int getAntall() {
		return nesteLedige;
	}

	public Innlegg[] getSamling() {
		return innleggTabell;
	}

	public int finnInnlegg(Innlegg innlegg) {
		int index = -1;

		for (int i = 0; i < nesteLedige; i++) {
			if (innleggTabell[i].erLik(innlegg)) {
				index = i;
			}
		}

		return index;
	}

	public boolean finnes(Innlegg innlegg) {
		boolean f = false;

		if (finnInnlegg(innlegg) > -1) {
			f = true;
		}

		return f;
	}

	public boolean ledigPlass() {
		boolean b = false;

		for (Innlegg i : innleggTabell) {
			if (i == null) {
				b = true;
			}
		}

		return b;
	}

	public boolean leggTil(Innlegg innlegg) {
		boolean b = false;

		if (ledigPlass() == true) {
			innleggTabell[nesteLedige] = innlegg;
			nesteLedige++;
			b = true;
		}

		return b;
	}

	public String toString() {
		String output = Integer.toString(nesteLedige) + "\n";
		for (int i = 0; i < nesteLedige; i++) {
			output += innleggTabell[i].toString();
		}

		return output;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		innleggTabell = Arrays.copyOf(innleggTabell, innleggTabell.length * 2);
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		if (leggTil(innlegg) == false) {
			utvid();
			return leggTil(innlegg);
		} else {
			return false;
		}

	}

	public boolean slett(Innlegg innlegg) {
		boolean slettet = false;

		if (finnes(innlegg)) {
			int index = finnInnlegg(innlegg);

			Innlegg[] dummy = Arrays.copyOf(innleggTabell, innleggTabell.length);

			innleggTabell = new Innlegg[dummy.length - 1];

			int inIndex = 0;

			for (int i = 0; i < dummy.length; i++) {
				if (i != index) {
					innleggTabell[inIndex] = dummy[i];
					inIndex++;

				} else {
					slettet = true;
				}
			}

			nesteLedige--;
		}

		return slettet;
	}

	public int[] addOne(int[] arr, int id) {
		int nextPlace = arr.length;
		
		arr = Arrays.copyOf(arr, arr.length+1);
		
		arr[nextPlace] = id;
		
		return arr;
	}
	
	public int[] search(String keyword) {
		int[] results = new int[0];
		
		for(int i = 0; i < nesteLedige; i++) {
			if(innleggTabell[i].toString().contains(keyword)) {
				addOne(results, innleggTabell[i].getId());
			}
		}
		
		return results;
	}
}