package model;

import java.io.File;

public class ReporteSinVerificarExistencia extends Reporte {

	public ReporteSinVerificarExistencia() {
		super(null, null);
		// TODO Auto-generated constructor stub
	}

	protected boolean validacion(File file) {
		return !file.exists();
	}

}
