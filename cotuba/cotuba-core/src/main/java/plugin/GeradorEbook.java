package plugin;

import domain.Ebook;
import domain.FormatoEbook;

import java.util.ServiceLoader;


public interface GeradorEbook {

    FormatoEbook formato();

    void gera(Ebook ebook);

    boolean accept(FormatoEbook formatoEbook);

    static GeradorEbook cria(FormatoEbook formato){

        for(GeradorEbook gerador : ServiceLoader.load(GeradorEbook.class)){
            if(gerador.formato().equals(formato)){
                return gerador;
            }
        }

        throw new IllegalArgumentException("Formato do Ebook inválido: " + formato);
    }


}
