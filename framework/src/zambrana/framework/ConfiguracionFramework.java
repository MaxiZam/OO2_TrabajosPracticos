package zambrana.framework;

import java.util.List;

public interface ConfiguracionFramework {

	public abstract List<Accion> accionesConfig(String arch);

	public void desplegarMenu(List<Accion> acciones);
}
