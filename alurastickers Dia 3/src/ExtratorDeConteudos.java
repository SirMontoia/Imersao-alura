import java.util.List;


// Interface não dita comportamento. quem realiza isso são suas implementações. Interfaces detém características gerais que serão utilizadas de forma específica dentro de onde forem necessárias.

// Tudo dentro de interfaces é público  

// Contribui na união de objetos

// Para aplicar a interface, usar 'implements' na classe desejada

//  Une os extratores do IMDB e o da NASA

// Permite criar outros extratores de conteúdo diversos, consumindo outras APIs

public interface ExtratorDeConteudos {
    
    public List<Conteudo> extrairConteudos(String json);
}
