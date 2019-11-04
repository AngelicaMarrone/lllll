import campionati.Campionato;

/**
 * Classe con un main di esempio
 */

public class Esempio {

	public static void main(String[] args) {

		System.out.println("Definizione campionato");
		
		Campionato c = new Campionato("Lega Calcio Serie A", "Campionato di Calcio Maschile", "2019-2020", 20);

		System.out.println("Lega: "+c.getLega());
		System.out.println("Denominazione: "+c.getDenominazione());
		System.out.println("Stagione: "+c.getStagione());
		System.out.println("Numero squadre: "+c.getNumeroSquadre());

		System.out.println("\nImpostazione numero retrocessioni");
		
		c.setNumeroRetrocessioni(3);

		System.out.println("\nRegolamento, numero quadre (retrocessioni):");
		
		String regolamento = c.regolamento();
		
		System.out.println(regolamento);

		System.out.println("\nIscrizione squadra");
		
		int primo_id_squadra = c.iscriviSquadra("A.S.D. Genova Calcio", "Stadio L. Ferraris", "Enrico Preziosi");
		
		System.out.println("\nIdentificativo assegnato: ");
		System.out.println(primo_id_squadra);

		System.out.println("\nInformazioni squadra 1: ");
		String informazioni_squadra = c.squadra(1);
		System.out.println(informazioni_squadra);

		System.out.println("\nIscrizione altre squadre");

		int secondo_id_squadra = c.iscriviSquadra("Udinese Calcio", "Stadio Friuli", "Franco Soldati");
		int terzo_id_squadra = c.iscriviSquadra("S.S. Calcio Napoli", "Stadio S. Paolo", "Aurelio De Laurentis");
		
		System.out.println("\nSquadre iscritte: ");
		String[] squadreIscritte = c.squadreIscritte();
		if(squadreIscritte!=null)
			for(int i=0;i<squadreIscritte.length;i++)
				System.out.println(squadreIscritte[i]);
		
		System.out.println("\nAggiunto incontro");
		c.aggiungiIncontro(primo_id_squadra, secondo_id_squadra);

		System.out.println("\nImpostato esito");
		c.impostaEsito("1-2", "4-3");		
		
		System.out.println("\nInformazioni incontro 1-2");
		String informazioni_incontro = c.incontro("1-2");
		System.out.println(informazioni_incontro);		
		
		System.out.println("\nAggiunti altri incontri");
		c.aggiungiIncontro(secondo_id_squadra, primo_id_squadra);
		c.aggiungiIncontro(primo_id_squadra, terzo_id_squadra);
		
		System.out.println("\nIncontri:");

		String incontri = c.incontri();
		System.out.println(incontri);

		System.out.println("\nIncontri squadra 2:");

		String incontriSquadra = c.incontriSquadra(2);
		System.out.println(incontriSquadra);
		
	}
	
}
