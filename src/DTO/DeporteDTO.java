package DTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import capanegocios.Deporte;
import capanegocios.SeRealizaEn;

public class DeporteDTO {
	private long id;
	private String nombre;
	private List<SeRealizaEnDTO> serealizaen = new ArrayList<SeRealizaEnDTO>();
	
	
	
	public DeporteDTO(Deporte deporte) {
		this.id = deporte.getId();
		this.nombre = deporte.getNombre();
		System.out.println(deporte.getSerealizaen().size());
		for(SeRealizaEn realiza: deporte.getSerealizaen()){
			SeRealizaEnDTO realizaDTO = new SeRealizaEnDTO();
			realizaDTO.id_deporte=realiza.getIddeporte();
			realizaDTO.id_lugar=realiza.getIdlugar();
			serealizaen.add(realizaDTO);
			}		
	}

	public DeporteDTO() {
		// TODO Auto-generated constructor stub
	}

	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre (){
		return nombre;
	}
	
	public void setSerealizaen(List<SeRealizaEnDTO> serealizaen){
		this.serealizaen = serealizaen;
	}
	
	
	public List<SeRealizaEnDTO> getSerealizaen(){
		return serealizaen;
	}
	
	public void addSerealizaen(SeRealizaEnDTO serealizaen){
		this.serealizaen.add(serealizaen);
	}
	
	public static Comparator<DeporteDTO> COMPARAR_POR_NOMBRE = new Comparator<DeporteDTO>(){
		public int compare(DeporteDTO uno, DeporteDTO dos){
			return uno.nombre.compareTo(dos.nombre);
		}
	};
}

