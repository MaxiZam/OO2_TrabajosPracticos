package model;

import java.io.File;

public class ReporteSinSobreescribir extends Reporte {

	public ReporteSinSobreescribir() {
		super(null, null);
		// TODO Auto-generated constructor stub
	}

	protected boolean validacion(File file) {
		return file.exists();

	}
}
