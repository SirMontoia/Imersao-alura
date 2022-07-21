public record Conteudo (String titulo, String urlImagem) {

    // Classe que carrega informações. vai receber a imagem e o titulo da imagem pra ser gerada a figurinha posteriormente

// Forma class de fazer abaixo

   //private final String titulo; // usa-se final para determinar que ninguem altera o valor do atributo depois de criado
   //private final String urlImagem;



   public Conteudo(String titulo, String urlImagem) {
    this.titulo = titulo;
    this.urlImagem = urlImagem;
}

public String getTitulo() {
    return titulo;
}
public String getUrlImagem() {
    return urlImagem;
}



    
}
