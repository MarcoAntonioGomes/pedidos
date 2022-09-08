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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RenderizadorMDParaHTML {

    public List<Capitulo> renderiza(Path diretorioDosMD) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.md");
        List<Capitulo> capitulos = new ArrayList<>();
        try (Stream<Path> arquivosMD = Files.list(diretorioDosMD)) {
            arquivosMD
                    .filter(matcher::matches)
                    .sorted()
                    .forEach(arquivoMD -> {
                        Parser parser = Parser.builder().build();
                        Node document = null;
                        Capitulo capitulo = new Capitulo();
                        try {
                            document = parser.parseReader(Files.newBufferedReader(arquivoMD));
                            document.accept(new DescobrirHeading(capitulo));
                        } catch (Exception ex) {
                            throw new IllegalStateException("Erro ao fazer parse do arquivo " + arquivoMD, ex);
                        }

                        try {
                            HtmlRenderer renderer = HtmlRenderer.builder().build();
                            String html = renderer.render(document);
                            capitulo.setConteudoHTML(html);
                            capitulos.add(capitulo);

                        } catch (Exception ex) {
                            throw new IllegalStateException("Erro ao renderizar para HTML o arquivo " + arquivoMD, ex);
                        }
                    });
        } catch (IOException ex) {
            throw new IllegalStateException("Erro tentando encontrar arquivos .md em " + diretorioDosMD.toAbsolutePath(), ex);
        }

        return capitulos;
    }


}
