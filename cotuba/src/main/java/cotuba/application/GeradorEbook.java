package cotuba.application;

import cotuba.domain.Ebook;
import cotuba.epub.GeradorEPUB;
import cotuba.pdf.GeradorPDF;

import java.util.HashMap;
import java.util.Map;

public interface GeradorEbook {

    Map<String, GeradorEbook> GERADORES = new HashMap<String, GeradorEbook>(){{
       put("pdf", new GeradorPDF());
       put("epub", new GeradorEPUB());
    }};

    void gera(Ebook ebook);

    static GeradorEbook cria(String formato){

        GeradorEbook gerador = GERADORES.get(formato);


         if(gerador == null) {
            throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
        }

        return gerador;
    }

}
