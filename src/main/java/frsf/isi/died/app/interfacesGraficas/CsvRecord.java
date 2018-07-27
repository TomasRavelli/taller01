package frsf.isi.died.app.interfacesGraficas;

import java.util.List;

public interface CsvRecord {

	public List<String> asCsvRow();
	public void loadFromStringRow(List<String> datos);
}
