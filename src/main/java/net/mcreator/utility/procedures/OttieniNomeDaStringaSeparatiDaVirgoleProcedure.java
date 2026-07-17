package net.mcreator.utility.procedures;

public class OttieniNomeDaStringaSeparatiDaVirgoleProcedure {
	public static String execute(double indice, String Lista) {
		if (Lista == null)
			return "";
		String temp_lista = "";
		String GiocatoreEstratto = "";
		double posizioneVirgola = 0;
		double Indice_locale = 0;
		temp_lista = Lista + ",";
		Indice_locale = indice;
		for (int index4 = 0; index4 < (int) (Indice_locale + 1); index4++) {
			posizioneVirgola = temp_lista.indexOf(",", 0);
			if (posizioneVirgola > 0) {
				GiocatoreEstratto = temp_lista.substring(0, (int) posizioneVirgola);
				temp_lista = temp_lista.substring((int) (posizioneVirgola + 1));
			} else {
				GiocatoreEstratto = "ListaVuota";
			}
		}
		return GiocatoreEstratto;
	}
}