package cotuba.application;


import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {


    private final GeradorEPUB geradorEPUB;
    private final GeradorPDF geradorPDF;
    private final RenderizadorMDParaHTML renderizador;

    public Cotuba(GeradorEPUB geradorEPUB, GeradorPDF geradorPDF, RenderizadorMDParaHTML renderizadorMDParaHTML) {
        this.geradorEPUB = geradorEPUB;
        this.geradorPDF = geradorPDF;
        this.renderizador = renderizadorMDParaHTML;
    }

    public void executa(ParametrosCotuba parametros){

        String formato = parametros.getFormato();
        Path diretorioDosMD = parametros.getDiretorioDosMD();
        Path arquivoDeSaida = parametros.getArquivoDeSaida();

        List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);


        Ebook ebook = new Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);


        if ("pdf".equals(formato)) {
            geradorPDF.gera(ebook);

        } else if ("epub".equals(formato)) {
            geradorEPUB.gera(ebook);
        } else {
            throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
        }


    }

}
