import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoNasa {

    public List<Conteudo> extrairConteudos (String json){
        
        
        var parser = new JsonParser();

        List<Map<String, String>> listaDeAtributos = parser.parse(json);


        List <Conteudo> conteudos = new ArrayList<>();
        
        // popular a lista de conteudos

        // -- Para cada item da lista (chave JSON + Valor JSON), gera um novo conteúdo
        
        for (Map<String, String> atributos : listaDeAtributos){  

            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");

            var conteudo = new Conteudo(titulo, urlImagem);


            conteudos.add(conteudo);



        } 


    return conteudos;

    }
    
}
