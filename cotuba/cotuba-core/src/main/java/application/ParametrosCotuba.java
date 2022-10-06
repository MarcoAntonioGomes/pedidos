package application;



import domain.FormatoEbook;

import java.nio.file.Path;

public interface ParametrosCotuba {
    Path getDiretorioDosMD();

    FormatoEbook getFormato();

    Path getArquivoDeSaida();
}
