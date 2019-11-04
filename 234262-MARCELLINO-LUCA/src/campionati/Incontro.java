package campionati;

public class Incontro {
	private Squadre squadraOspite;
	private Squadre squadraCasa;
	private String identificativo;
	private String esito= "N/D";
	
	public Incontro(Squadre squadraOspite, Squadre squadraCasa, String identificativo) {
		super();
		this.squadraOspite = squadraOspite;
		this.squadraCasa = squadraCasa;
		this.identificativo = identificativo;
	}
	public Squadre getSquadraOspite() {
		return squadraOspite;
	}
	public Squadre getSquadraCasa() {
		return squadraCasa;
	}
	public String getIdentificativo() {
		return identificativo;
	}
	
	public String getEsito() {
		return esito;
	}
	public void setEsito(String esito) {
		this.esito = esito;
	}
	
	
	
	

}
