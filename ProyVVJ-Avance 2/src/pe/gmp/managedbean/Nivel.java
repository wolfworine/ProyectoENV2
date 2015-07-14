package pe.gmp.managedbean;

import java.util.ArrayList;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.swing.ListModel;

import pe.gmp.jpa.NivelJPA;
import pe.gmp.service.NivelImpl;

public class Nivel {
	
	private NivelImpl niveli=new NivelImpl();
	private DataModel<NivelJPA> nivelesmodel;
	private ArrayList<SelectItem> nivellista;
	
	
	
	
	public ArrayList<SelectItem> getNivellista() throws Exception {
		nivellista=new ArrayList<SelectItem>();
		for(NivelJPA obj:niveli.listadonivel()){
			nivellista.add(new SelectItem(obj.getNivelid(), obj.getNiveldes()));
		}
		
		return nivellista;
	}
	public void setNivellista(ArrayList<SelectItem> nivellista) {
		this.nivellista = nivellista;
	}
	public DataModel<NivelJPA> getNivelesmodel() throws Exception {
		nivelesmodel=new ListDataModel<NivelJPA>(niveli.listadonivel());
		return nivelesmodel;
	}
	public void setNivelesmodel(DataModel<NivelJPA> nivelesmodel) {
		this.nivelesmodel = nivelesmodel;
	}
	
	
	
	
	

}
