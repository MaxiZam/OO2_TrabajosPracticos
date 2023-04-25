package domain.portsin;

import domain.model.AdministrarParticipantes;

public interface UI {

	public void setupUIComponents(AdministrarParticipantes admin);

	public String[] obtenerDatosParticipante();
}
