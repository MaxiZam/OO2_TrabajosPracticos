package zambrana.framework;

import java.util.concurrent.Callable;

public class RunnableAdapter implements Callable<Object> {

	private Accion accion;

	public RunnableAdapter(Accion accion) {
		this.accion = accion;
	}

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		this.accion.ejecutar();
		return null;
	}

}
