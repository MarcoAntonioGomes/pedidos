package cotuba.application;


import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.epub.GeradorEPUBComEpublib;
import cotuba.pdf.GeradorPDFComIText;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {


    private GeradorEbook gerador;
    private final RenderizadorMDParaHTML renderizador;

    public Cotuba(RenderizadorMDParaHTML renderizadorMDParaHTML) {
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
            gerador = new GeradorPDFComIText();

        } else if ("epub".equals(formato)) {
            gerador = new GeradorEPUBComEpublib();

        } else {
            throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
        }

        gerador.gera(ebook);

    }

}
