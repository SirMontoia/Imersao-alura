import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;

public class GeradorFigurinhas {
    

    public void gerar() throws Exception{

        // Ler a imagem
        
       BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg")); // Método nativo do java para leitura de imagens que recebe um endereço do computador para o arquivo



        // Cria nova imagem em memória com transparência e com tamanho novo 

        int larguraImg = imagemOriginal.getWidth();
        int alturaImg= imagemOriginal.getHeight();
        int novaAltura = alturaImg + 200; // aumentar o tamanho da imagem para fazer a inserção da frase embaixo (img orignal vai ser sobreposta pela nova)

        var novaImagem = new BufferedImage(larguraImg, novaAltura, BufferedImage.TRANSLUCENT); // cria nova imagem vazia com fundo transparente

        
        
        
        // Copiar imagem original para nova imagem em memória

        Graphics2D  graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null); // cria graphics da nova imagem e passa como parametro a imagem original para ser sobrescrita


        // escrever frase na nova imagem


        // escrever nova imagem em arquivo
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png")); // escreve a nova imagem, recebe como parametros a imagem a ser escrita, o tipo do arquivo em string e o nome do arquivo gerado



    }

    public static void main(String[] args) throws Exception {
    
        var geradora = new GeradorFigurinhas();
        geradora.gerar();



}

}
