package upc.iluminados.modelo.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="AlquilerCanchas")
public class AlquilerCanchaList {

	private List<AlquilerCancha> data;

	public List<AlquilerCancha> getData() {
		return data;
	}

	public void setData(List<AlquilerCancha> data) {
		this.data = data;
	}
	
	

}
