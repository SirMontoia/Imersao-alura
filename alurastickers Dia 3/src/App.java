
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
       
      
        
        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD"; 
        
        /*URI endereco = URI.create(url);
        
        var client = HttpClient.newHttpClient(); 
        var request = HttpRequest.newBuilder(endereco).GET().build();
        
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        
        String body = response.body();*/

        // Código acima foi refatorado e sua atuação deixada para outra classe. Agora, é chamado como método abaixo

        var http = new ClienteHTTP();
        String json = http.buscaDados(url);
        


       ExtratorDeConteudoNasa extrator = new ExtratorDeConteudoNasa();

       List<Conteudo> conteudos = extrator.extrairConteudos(json);

        var gerarFigurinha = new GeradorFigurinhas();

        
        for (int i = 0 ; i<3 ; i++){    
            
            Conteudo conteudo = conteudos.get(i);
            

            InputStream input = new URL (conteudo.urlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.titulo() + ".png";

            gerarFigurinha.gerar(input, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
            
            
           }
        

    }


     // Código reutilizável, para usar com o IMDB, chamar a classe ExtratorDeConteudoIMDB e a url do imbd, para a nasa, chamar  ExtratorDeConteudoNasa e url da API da NASA
  
           
            
}
