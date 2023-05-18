package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import model.Reporte;
import model.ReporteSinVerificarExistencia;

public class TestReporte {
	@Test
	public void testReporteFile() throws IOException {
		Reporte reporte = new Reporte("reporte", new ReporteSinVerificarExistencia());
		File archivotxt = new File("archivo_reporte_exportado");
		boolean result = true;
		assertEquals(result, reporte.export(archivotxt));
	}
}
