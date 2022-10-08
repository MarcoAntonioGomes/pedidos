package cotuba.application;



import cotuba.domain.FormatoEbook;

import java.nio.file.Path;

public interface ParametrosCotuba {
    RepositorioDeMDs getDiretorioDosMD();

    FormatoEbook getFormato();

    Path getArquivoDeSaida();
}
