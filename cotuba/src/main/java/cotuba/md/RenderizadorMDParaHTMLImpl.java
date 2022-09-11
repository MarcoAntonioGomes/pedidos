package cotuba.md;

import cotuba.domain.Capitulo;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RenderizadorMDParaHTMLImpl implements RenderizadorMDParaHTML {

    @Override
    public List<Capitulo> renderiza(Path diretorioDosMD) {
       return obtemArquivosMD(diretorioDosMD)
                .stream()
                .map(arquivoMD ->{
                    Capitulo capitulo = new Capitulo();
                    Node document = parseDoMD(arquivoMD, capitulo);
                    renderizaParaHTML(arquivoMD, capitulo, document);
                    return capitulo;
                }).toList();
    }

    private List<Path> obtemArquivosMD(Path diretorioDosMD) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.md");
        Stream<Path> arquivosMD = null;
        try {
            arquivosMD = Files.list(diretorioDosMD);
        } catch (IOException e) {
            System.out.println("Erro ao localizar os arquivos MD");
        }
        return  arquivosMD
            .filter(matcher::matches)
            .sorted().collect(Collectors.toList());
    }


    private Node parseDoMD(Path arquivoMD, Capitulo capitulo){
        Parser parser = Parser.builder().build();
        Node document = null;
        try {
            document = parser.parseReader(Files.newBufferedReader(arquivoMD));
            document.accept(new DescobrirHeading(capitulo));
        } catch (Exception ex) {
            throw new IllegalStateException("Erro ao fazer parse do arquivo " + arquivoMD, ex);
        }

        return  document;
    }

    private void renderizaParaHTML(Path arquivoMD, Capitulo capitulo, Node document){

        try {
            HtmlRenderer renderer = HtmlRenderer.builder().build();
            String html = renderer.render(document);
            capitulo.setConteudoHTML(html);
        } catch (Exception ex) {
            throw new IllegalStateException("Erro ao renderizar para HTML o arquivo " + arquivoMD, ex);
        }

    }

}
