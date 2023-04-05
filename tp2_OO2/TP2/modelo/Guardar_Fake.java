package modelo;

public class Guardar_Fake implements GuardarTexto {

	private String textoGuardado;

	@Override
	public void guardarTexto(String texto) {
		// TODO Auto-generated method stub
		this.textoGuardado = texto;
	}

	public String verTextoGuardado() {
		return textoGuardado;
	}
}
