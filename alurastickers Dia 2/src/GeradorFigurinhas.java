import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorFigurinhas {
    

    public void gerar(InputStream input, String nomeArquivo) throws Exception{

        // Ler a imagem
        
       //BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg")); --> Método nativo do java para leitura de imagens que recebe um endereço do computador para o arquivo

       // Nesse caso, poderia tambem fazer:  InputStream input = new FileInputStream(new File("entrada/filme-maior.jpg"));

      // InputStream input = new URL ("https://m.media-amazon.com/images/M/MV5BY2Q2NDI1MjUtM2Q5ZS00MTFlLWJiYWEtNTZmNjQ3OGJkZDgxXkEyXkFqcGdeQXVyNTI4MjkwNjA@.jpg").openStream();   -->  // forma de pegar a imagem através de URL, openStrem le o stream de bytes da url e os traz

      // Agora, passa-se um InputStream como parametro para permitir que esse método receba um objeto desse tipo que leia as imagens de n formas
        
       
       BufferedImage imagemOriginal = ImageIO.read(input);


        // Cria nova imagem em memória com transparência e com tamanho novo 

        int larguraImg = imagemOriginal.getWidth();
        int alturaImg= imagemOriginal.getHeight();
        int novaAltura = alturaImg + 200; // aumentar o tamanho da imagem para fazer a inserção da frase embaixo (img orignal vai ser sobreposta pela nova)

        var novaImagem = new BufferedImage(larguraImg, novaAltura, BufferedImage.TRANSLUCENT); // cria nova imagem vazia com fundo transparente

        
        
        
        // Copiar imagem original para nova imagem em memória

        Graphics2D  graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null); // cria graphics da nova imagem e passa como parametro a imagem original para ser sobrescrita


        // Configurar as características do texto a ser escrito
        
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever frase na nova imagem

        // Desafio inserir imagem

        BufferedImage imagemEu = ImageIO.read(new File("entrada/eu.jpeg"));
        var imagemEu2 = graphics.drawImage(imagemEu, novaImagem.getWidth()/5, novaImagem.getHeight()/5, null);

        // Desafio inserir imagem

        //Desafio centralizar texto

        
        

        //Desafio centralizar texto



        //Desafio Outline  


        graphics.setFont(graphics.getFont().deriveFont(45F));
        graphics.setColor(Color.BLUE);
        int x = 100;
        int y = 100;
        String text = "TEXTO";
        graphics.drawString(text, x + 1, y - 1);
        graphics.drawString(text, x + 1, y + 1);
        graphics.drawString(text, x - 1, y - 1);
        graphics.drawString(text, x - 1, y + 1);       


        //Desafio Outline

        graphics.setColor(Color.WHITE);
        graphics.drawString(text, x, novaAltura -100); // escrever a mensagem na imagem, passa oq será escrito e em qual posição


        // escrever nova imagem em arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo)); // escreve a nova imagem, recebe como parametros a imagem a ser escrita, o tipo do arquivo em string e o nome do arquivo gerado



    }

    





}
