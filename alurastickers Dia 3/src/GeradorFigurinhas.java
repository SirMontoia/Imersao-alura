import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorFigurinhas {
    

    public void gerar(InputStream input, String nomeArquivo) throws Exception{

       
        
       
       BufferedImage imagemOriginal = ImageIO.read(input);


        

        int larguraImg = imagemOriginal.getWidth();
        int alturaImg= imagemOriginal.getHeight();
        int novaAltura = alturaImg + 200; 

        var novaImagem = new BufferedImage(larguraImg, novaAltura, BufferedImage.TRANSLUCENT); 

        
        
        
        // Copiar imagem original para nova imagem em memória

        Graphics2D  graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null); // cria graphics da nova imagem e passa como parametro a imagem original para ser sobrescrita


        // Configurar as características do texto a ser escrito
        
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever frase na nova imagem

    
        graphics.drawString("Texto", 100, novaAltura -100); // escrever a mensagem na imagem, passa oq será escrito e em qual posição


        // escrever nova imagem em arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo)); // escreve a nova imagem, recebe como parametros a imagem a ser escrita, o tipo do arquivo em string e o nome do arquivo gerado



    }

    





}
