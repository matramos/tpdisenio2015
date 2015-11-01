package capanegocios;

public class TipoDocumento {
	
	public long tipo;
	public boolean dni;
	public boolean ci;
	public boolean lc;
	public boolean le;
	
	public long getTipo(){
		return tipo;
	}
	
	public void setTipo(long tipo){
		this.tipo=tipo;
	}
	
	public boolean getDni(){
		return dni;
	}
	
	public void setDni(boolean dni){
		this.dni=dni;
	}
	
	public boolean getCi(){
		return ci;
	}
	
	public void setCi(boolean ci){
		this.ci=ci;
	}
	
	public boolean getLc(){
		return lc;
	}
	
	public void setLc(boolean lc){
		this.lc=lc;
	}
	
	public boolean getLe(){
		return le;
	}
	
	public void setLe(boolean le){
		this.le=le;
	}
}
