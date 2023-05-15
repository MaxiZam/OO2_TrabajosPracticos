package model;

public class Adaptador implements Motor {

	private Adaptado adap;

	public Adaptador(Adaptado adap) {
		this.adap = adap;
	}

	@Override
	public String arrancar() {
		// TODO Auto-generated method stub
		return adap.conectarYactivar();
	}

	@Override
	public String acelerar() {
		// TODO Auto-generated method stub
		return adap.moverMasRapido();
	}

	@Override
	public String apagar() {
		// TODO Auto-generated method stub
		return adap.detenerYdesconectar();
	}

}
