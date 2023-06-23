package zambrana.framework;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class RunnableAdapter implements Callable<RunnableAdapter> {

	private Accion accion;

	public RunnableAdapter(Accion accion) {
		this.accion = accion;
	}

	@Override
	public RunnableAdapter call() throws Exception {
		// TODO Auto-generated method stub
		this.accion.ejecutar();
		TimeUnit.MILLISECONDS.sleep(1000);
		return null;
	}

}
