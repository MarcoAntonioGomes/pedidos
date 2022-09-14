package cotuba.application;

import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;


public interface GeradorEbook {


    void gera(Ebook ebook);

    boolean accept(FormatoEbook formatoEbook);

    static GeradorEbook cria(FormatoEbook formato){
        return formato.getGerador();
    }

}
