package cotuba.html;

import cotuba.plugin.GeradorEbook;
import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;


public class GeradorHTML implements GeradorEbook {


    @Override
    public FormatoEbook formato() {
        return FormatoEbook.HTML;
    }

    @Override
    public void gera(Ebook ebook) {
        Path arquivoDeSaida = ebook.getArquivoDeSaida();

        try {
            Path diretorioDoHTML = Files.createDirectory(arquivoDeSaida);
            int i = 1;
            for(Capitulo capitulo : ebook.getCapitulos()){
                String nomeDoArquivoHTMLDoCapitulo = obtemNomeDoArquivoHTMLDoCapitulo(i, capitulo);
                Path arquivoHTMLDoCapitulo = diretorioDoHTML.resolve(nomeDoArquivoHTMLDoCapitulo);
                String html = """
                        <!DOCTYPE html>
                        <html lang="pt-BR">
                        <title>%s</title>
                        </head>
                        <body>
                          %s
                        </body>
                        </html>
                        """.formatted(capitulo.getTitulo(), capitulo.getConteudoHTML());
                Files.writeString(arquivoHTMLDoCapitulo, html, StandardCharsets.UTF_8);
                i++;


            }
        } catch (IOException ex) {
           throw new IllegalStateException("Erro ao criar HTML: " + arquivoDeSaida.toAbsolutePath(), ex );
        }

    }

    private String obtemNomeDoArquivoHTMLDoCapitulo(int i, Capitulo capitulo) {

        String nomeArquivoHTMLCapitulo = i + " - " + removeAcentos(capitulo.getTitulo().toLowerCase()).replaceAll("[^\\w]","") + ".html";
        return nomeArquivoHTMLCapitulo;

    }

    private String removeAcentos(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD ).replaceAll("[^\\p{ASCII}]", "");
    }

    @Override
    public boolean accept(FormatoEbook formato) {
        return FormatoEbook.HTML.equals(formato);
    }


}
