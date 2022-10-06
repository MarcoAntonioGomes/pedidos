package application;



import domain.Capitulo;
import domain.Ebook;
import domain.FormatoEbook;
import md.RenderizadorMDParaHTML;
import plugin.AoFinalizarGeracao;
import plugin.GeradorEbook;


import java.nio.file.Path;
import java.util.List;


public class Cotuba {


    public void executa(ParametrosCotuba parametros){

        FormatoEbook formato = parametros.getFormato();
        Path diretorioDosMD = parametros.getDiretorioDosMD();
        Path arquivoDeSaida = parametros.getArquivoDeSaida();

        var renderizador = new RenderizadorMDParaHTML();
        List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);


        Ebook ebook = new Ebook(formato, arquivoDeSaida, capitulos );

        GeradorEbook geradorEbook = GeradorEbook.cria(formato);
        geradorEbook.gera(ebook);

        AoFinalizarGeracao.gerou(ebook);

    }

}
