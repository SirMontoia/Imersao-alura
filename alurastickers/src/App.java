
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
       
        // Fazer conexão HTTP e pegar todas as informações disponíveis dos top 250 filmes da URL
        
        String url = "https://api.mocki.io/v2/";

        //DESAFIO 1: URL Filmes Populares: https://imdb-api.com/en/API/MostPopularMovies/k_hn14k54j
        //DESAFIO 1: URL Melhores Séries: https://imdb-api.com/en/API/Top250TVs/k_hn14k54j
        //DESAFIO 1: URL Filmes Populares: https://imdb-api.com/en/API/MostPopularTVs/k_hn14k54j

        //DESAFIO 2: Estilizando saídas do console

        String Ansi_Green = "\u001B[32m";
        String Ansi_Yellow = "\u001B[33m";
        String Ansi_Blue = "\u001B[34m";
        String Ansi_Reset = "\u001B[0m";


        //DESAFIO 2: Estilizando saídas do console
        
        URI endereco = URI.create(url + ChaveApi.chaveApi);
        
        var client = HttpClient.newHttpClient(); // A partir do Java 11, já identifica a variavel como sendo da classe que recebe, não precisa declarar new
        
        var request = HttpRequest.newBuilder(endereco).GET().build();
        
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        
        String body = response.body();
        
       


        // Extrair as informações pertinentes à nossa proposta (titulo, poster, classificação)

         var parser = new JsonParser();

        List<Map<String, String>> listaFilmes = parser.parse(body);
        


        // Exibir os dados

        // para cada filme na lista, imprimir as infos desejadas
        for (Map<String,String> filme: listaFilmes){           

            System.out.println("TÍTULO: " + Ansi_Green + filme.get("title") + Ansi_Reset);
            System.out.println("LINK POSTER: " + Ansi_Yellow +  filme.get("image") + Ansi_Reset);

            //Desafio 2

            var numb = Float.parseFloat(filme.get("imDbRating"));
            
            var numb2 = Math.round(numb);
            // Passa a string do rating para Float e arredonda o valor
           
            
            
            System.out.print("NOTA IMDB: " + Ansi_Blue +  Ansi_Reset);
            
            for (int x =0 ; x< numb2 ; x++){
                
                System.out.print("*");
            }
            //Usa o for para rodar o numero de vezes igual ao valor convertido e imprimir as estrelas  
            
            
            //Desafio 2

            System.out.println();
            System.out.println();
            
           }
        

    }

  
           
            
}
