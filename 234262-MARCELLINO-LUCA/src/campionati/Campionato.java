package campionati;

import java.util.HashMap;
import java.util.LinkedList;

public class Campionato {

	public String lega;
	public String campionato;
	public String stagione;
	public Integer numero;
	public Integer retrocessione;
	public Integer progressivo=1;
	

	
	HashMap <Integer,Squadre> iscrizioni =new HashMap <Integer,Squadre>();
	HashMap <Incontro, String> incontri= new HashMap <Incontro, String>();
	HashMap <String,Incontro> incontriinv= new HashMap <String, Incontro>();
	
	

	public Campionato(String lega, String campionato, String stagione, Integer numero) {
		super();
		this.lega = lega;
		this.campionato = campionato;
		this.stagione = stagione;
		this.numero = numero;
	}

	public String getLega() {
		return lega;
	}

	public String getDenominazione() {
		return campionato;
	}

	public String getStagione() {
		return stagione;
	}
	
	public int getNumeroSquadre() {
		return numero;
	}
	
	public void setNumeroRetrocessioni(int numeroRetrocessioni){
		retrocessione= numeroRetrocessioni;
	}
	
	public String regolamento() {
		String s= numero+" ("+retrocessione+")";
		return s;
	}
	
	public int iscriviSquadra(String nome, String stadio, String presidente ) {
		
		Squadre s= new Squadre (nome,stadio,presidente);
		
		
			if( numero < progressivo)
			{
				return -1;
			}
		
			for(Integer x : iscrizioni.keySet()) {
		
			if(iscrizioni.get(x).getNome().equals(s.getNome()) && iscrizioni.get(x).getPresidente().equals(s.getPresidente()) && iscrizioni.get(x).getStadio().equals(s.getStadio()))
			{ 
				return x;
			}
		
			}
		
		iscrizioni.put(progressivo, s);
		
		return progressivo++;
	}
	
	public String squadra(int identificativoSquadra) {
		
			String s= iscrizioni.get(identificativoSquadra).getNome()+"; "+iscrizioni.get(identificativoSquadra).getStadio()+"; "+iscrizioni.get(identificativoSquadra).getPresidente();
		
		return s;
	}

	public String[] squadreIscritte() {
		
		String[] siscritte= new String[iscrizioni.size()];
		
		
		for (Integer i : iscrizioni.keySet()) 
		{
			siscritte[i-1]=i+" "+ iscrizioni.get(i).getNome()+" "+iscrizioni.get(i).getStadio()+" "+iscrizioni.get(i).getPresidente();
		
		}
		
		return siscritte;
		
		
	}

	public String aggiungiIncontro(int identificativoSquadraCasa, int identificativoSquadraOspite) {
		
			String s= identificativoSquadraCasa+"-"+identificativoSquadraOspite;
			
			Squadre s1= iscrizioni.get(identificativoSquadraCasa);
			Squadre s2= iscrizioni.get(identificativoSquadraOspite);
			
			Incontro i= new Incontro( s2, s1, s);
			int y=0;
			
			for (Incontro x: incontri.keySet())
			{
				if ((x.getSquadraCasa().equals(s1) && x.getSquadraOspite().equals(s2)))
						y++;
				
				if ((x.getSquadraCasa().equals(s2) && x.getSquadraOspite().equals(s1)))
					y++;
				
				if (y==2)
					return null;
				
			}
			
			incontri.put(i, s);
			incontriinv.put(s,i);
		
		return s;
	}

	public void impostaEsito(String identificativoIncontro, String esito) {
		
		if (incontriinv.containsKey(identificativoIncontro))
		{
		Incontro i= incontriinv.get(identificativoIncontro);
		i.setEsito(esito);}
		
	}
	
	
	public String incontro(String identificativoIncontro) {
		
		if(incontriinv.containsKey(identificativoIncontro))
		{
			Incontro i= incontriinv.get(identificativoIncontro);
			
			String s= i.getSquadraCasa().getNome() + " vs "+ i.getSquadraOspite().getNome() + " "+ i.getEsito();
			
			return s;
			
		}
		
		
		
		return null;
	}

	public String incontri() {
		
		String s= "";
		int i= incontriinv.size();
		
		for (String x: incontriinv.keySet())
		{
			s += incontro(x);
			i--;
			if( i!=0)
			{
				s+= "\n";
			}
		}
		return s;
	}
	
	public String incontriTerminati() {
		
		String s= "";
		int i= incontriinv.size();
		
		for(String x: incontriinv.keySet())
		{
			Incontro y= incontriinv.get(x);
			if (!(y.getEsito().equals("N/D")))
			{
				s += incontro(x);
				i--;
				if( i!=0)
				{
					s+= "\n";
				}
			}
			
			i--;
		}
		
		return s;
	}
	
	public String incontriSquadra(int identificativoSquadra) {
		
		if (iscrizioni.containsKey(identificativoSquadra))
		{
			Squadre s= iscrizioni.get(identificativoSquadra);
			LinkedList<Incontro> incontrisquadra= new LinkedList<Incontro>();
			
			for ( Incontro i: incontri.keySet())
			{
				if(i.getSquadraCasa().equals(s) || i.getSquadraOspite().equals(s))
				{
					incontrisquadra.add(i);
				}
				
			}
			
			String stringa= "";
			int i= incontrisquadra.size();
			
			for(Incontro inc: incontrisquadra)
			{
					stringa += incontro(inc.getIdentificativo());
					i--;
					if( i!=0)
					{
						stringa += "\n";
					}

			}
			
			return stringa;
			
			
		}
		
		
		return null;
	}
	
}

