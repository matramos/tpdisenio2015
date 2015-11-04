package capanegocios;

import java.io.Serializable;

public class SeRealizaEn implements Serializable {
	private long idlugar;
	private long iddeporte;
	
	public void setIdlugar(long idlugar){
		this.idlugar = idlugar;
	}
	
	public void setIddeporte(long iddeporte){
		this.iddeporte = iddeporte;
	}
	
	public long getIddeporte(){
		return iddeporte;
	}
	public long getIdlugar(){
		return idlugar;
	}
}
