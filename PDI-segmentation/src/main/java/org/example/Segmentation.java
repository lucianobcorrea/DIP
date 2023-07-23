package org.example;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Segmentation {
	BufferedImage defaultImg;
	JPanel myPanelImg;
	JButton missaoUm, missaoTres, missaoDois, missaoCinco, missaoQuatroGrayScale, 
			missaoSeis, missaoQuatroColorido;
	JLabel imgOriginalLabel, imgAlteradaLabel;
	JFrame frame = new JFrame();

	public void configurarFrame() {
		frame.setSize(700, 550);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Manipulacao de Imagens");
		frame.setResizable(false);
	}

	public void adicionarElemento() {
		frame.setLocationRelativeTo(null);
		myPanelImg = new JPanel(new BorderLayout());
		frame.add(myPanelImg);
		
		imgOriginalLabel = new JLabel();
		imgAlteradaLabel = new JLabel();
		
		myPanelImg.add(imgOriginalLabel, BorderLayout.WEST);
		myPanelImg.add(imgAlteradaLabel, BorderLayout.EAST);
		
		setarImagemRetangularNaTela();

		JPanel myPanelBotoes = new JPanel();
		myPanelBotoes.setLayout(new BoxLayout(myPanelBotoes, BoxLayout.Y_AXIS));
		myPanelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		myPanelBotoes.setBackground(Color.LIGHT_GRAY);

		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));

		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 100)));

		missaoUm = new JButton("Missao Um");
		missaoUm.setAlignmentX(Component.CENTER_ALIGNMENT);
		missaoUm.setBackground(Color.WHITE);
		myPanelBotoes.add(missaoUm);

		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));

		missaoDois = new JButton("Missao Dois");
		missaoDois.setAlignmentX(Component.CENTER_ALIGNMENT);
		missaoDois.setBackground(Color.WHITE);
		myPanelBotoes.add(missaoDois);

		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));

		missaoTres = new JButton("Missao Tres");
		missaoTres.setAlignmentX(Component.CENTER_ALIGNMENT);
		missaoTres.setBackground(Color.WHITE);
		myPanelBotoes.add(missaoTres);

		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));

		missaoQuatroGrayScale = new JButton("<html><center>Missao Quatro<br/> Gray Scale");
		missaoQuatroGrayScale.setAlignmentX(Component.CENTER_ALIGNMENT);
		missaoQuatroGrayScale.setBackground(Color.WHITE);
		myPanelBotoes.add(missaoQuatroGrayScale);
		
		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
		
		missaoQuatroColorido = new JButton("<html><center>Missao Quatro<br/> Colorido");
		missaoQuatroColorido.setAlignmentX(Component.CENTER_ALIGNMENT);
		missaoQuatroColorido.setBackground(Color.WHITE);
		myPanelBotoes.add(missaoQuatroColorido);

		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));

		missaoCinco = new JButton("Missao Cinco");
		missaoCinco.setAlignmentX(Component.CENTER_ALIGNMENT);
		missaoCinco.setBackground(Color.WHITE);
		myPanelBotoes.add(missaoCinco);
		
		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));

		missaoSeis = new JButton("Missao Seis");
		missaoSeis.setAlignmentX(Component.CENTER_ALIGNMENT);
		missaoSeis.setBackground(Color.WHITE);
		myPanelBotoes.add(missaoSeis);

		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 55)));

		missaoCinco.addActionListener(listenerMissaoCinco);
		missaoSeis.addActionListener(listenerMissaoSeis);
		missaoDois.addActionListener(listenerMissaoDois);
		missaoQuatroGrayScale.addActionListener(listenerMissaoQuatroGrayScale);
		missaoQuatroColorido.addActionListener(listenerMissaoQuatroColorido);
		missaoTres.addActionListener(listenerMissaoTres);
		missaoUm.addActionListener(listenerMissaoUm);

		frame.getContentPane().add(myPanelBotoes, BorderLayout.EAST);
	}

	ActionListener listenerMissaoUm = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			setarImagemRetangularNaTela();
			
			File file = new File("Imagens/ImagemMissao1.jpg");
				try {
					defaultImg = ImageIO.read(file);
				} catch (IOException e1) {
					System.out.println("Nao foi possivel abrir a imagem");
				}
				BufferedImage imagem = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
						BufferedImage.TYPE_INT_RGB);
				imagem = defaultImg;
				imagem = aumentarBrilho(imagem, 50, 1.25);
				
				ImageIcon imagemOriginal = new ImageIcon(defaultImg.getScaledInstance(250, 150, Image.SCALE_SMOOTH));
				ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(250, 150, Image.SCALE_SMOOTH));
				imgAlteradaLabel.setIcon(imagemAlterada);
				imgOriginalLabel.setIcon(imagemOriginal);
		}
	};

	ActionListener listenerMissaoDois = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			setarImagemRetangularNaTela();
			
			File file = new File("Imagens/ImagemMissao2.jpg");
			try {
				
				defaultImg = ImageIO.read(file);
				
			}catch(IOException e2) {
				System.out.println("Nao foi possivel abrir a imagem");
			}
			BufferedImage imagem = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			imagem = filtroGaussiano();
			
			ImageIcon imagemOriginal = new ImageIcon(defaultImg.getScaledInstance(250, 170, Image.SCALE_SMOOTH));
			ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(250, 170, Image.SCALE_SMOOTH));
			imgAlteradaLabel.setIcon(imagemAlterada);
			imgOriginalLabel.setIcon(imagemOriginal);
		}
	};

	ActionListener listenerMissaoTres = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			setarImagemRetangularNaTela();
			
			File file = new File("Imagens/ImagemMissao3.jpg");
			try {
				defaultImg = ImageIO.read(file);
			}catch(IOException e3) {
				System.out.println("Nao foi possivel abrir a imagem");
			}
			BufferedImage imagem = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			imagem = defaultImg;
			imagem = filtroMediana(40, 1.4);
			
			ImageIcon imagemOriginal = new ImageIcon(defaultImg.getScaledInstance(250, 180, Image.SCALE_SMOOTH));
			ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(250, 180, Image.SCALE_SMOOTH));
			imgAlteradaLabel.setIcon(imagemAlterada);
			imgOriginalLabel.setIcon(imagemOriginal);
		}
	};

	ActionListener listenerMissaoQuatroGrayScale = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			File file = new File("Imagens/ImagemMissao4.jpg");
			try {
				defaultImg = ImageIO.read(file);
			}catch(IOException e4) {
				System.out.println("Nao foi possivel abrir a imagem");
			}
			BufferedImage imagem = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			imagem = defaultImg;
			imagem = detectorDeBordasDeSobelGrayScale(imagem);
			
			ImageIcon imagemOriginal = new ImageIcon(defaultImg.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
			ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
			
			setarImagemQuadradaNaTela();
			
			imgAlteradaLabel.setIcon(imagemAlterada);
			imgOriginalLabel.setIcon(imagemOriginal);
		}
	};
	
	ActionListener listenerMissaoQuatroColorido = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			File file = new File("Imagens/ImagemMissao4.jpg");
			try {
				defaultImg = ImageIO.read(file);
			}catch(IOException e4) {
				System.out.println("Nao foi possivel abrir a imagem");
			}
			BufferedImage imagem = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			imagem = defaultImg;
			imagem = detectorDeBordasDeSobelColorido(imagem);
			
			ImageIcon imagemOriginal = new ImageIcon(defaultImg.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
			ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
			
			setarImagemQuadradaNaTela();
			
			imgAlteradaLabel.setIcon(imagemAlterada);
			imgOriginalLabel.setIcon(imagemOriginal);
		}
	};

	ActionListener listenerMissaoCinco = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			setarImagemRetangularNaTela();
			
			File file = new File("Imagens/ImagemMissao5.jpg");
			try {
				defaultImg = ImageIO.read(file);
			}catch(IOException e4) {
				System.out.println("Nao foi possivel abrir a imagem");
			}
			BufferedImage imagem = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			imagem = defaultImg;
			imagem = algoritmoThreshold(imagem, 150);
			
			ImageIcon imagemOriginal = new ImageIcon(defaultImg.getScaledInstance(240, 200, Image.SCALE_SMOOTH));
			ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(240, 200, Image.SCALE_SMOOTH));
			
			imgAlteradaLabel.setIcon(imagemAlterada);
			imgOriginalLabel.setIcon(imagemOriginal);
		}
	};
	
	ActionListener listenerMissaoSeis = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			setarImagemRetangularNaTela();
			
			File file = new File("Imagens/ImagemMissao6.jpg");
			try {
				defaultImg = ImageIO.read(file);
			}catch(IOException e4) {
				System.out.println("Nao foi possivel abrir a imagem");
			}
			BufferedImage imagem = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			imagem = defaultImg;
			imagem = algoritmoDeSuavizacaoDeMedia();
			
			ImageIcon imagemOriginal = new ImageIcon(defaultImg.getScaledInstance(260, 170, Image.SCALE_SMOOTH));
			ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(260, 170, Image.SCALE_SMOOTH));
			
			imgAlteradaLabel.setIcon(imagemAlterada);
			imgOriginalLabel.setIcon(imagemOriginal);
		}
	};
	
	public void setarImagemQuadradaNaTela() {
		imgOriginalLabel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		imgAlteradaLabel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
	}
	
	public void setarImagemRetangularNaTela() {
		imgOriginalLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		imgAlteradaLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	
	public BufferedImage algoritmoDeSuavizacaoDeMedia() {
		
		BufferedImage mediaAplicada = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		
		final int[][] mascaraMedia = { { 1, 1, 1 }, 
			    					   { 1, 1, 1 }, 
			    					   { 1, 1, 1 }};
		
		for(int y = 1; y < defaultImg.getHeight() - 1; y++) {
			for(int x = 1; x < defaultImg.getWidth() - 1; x++) {
				
				double red = 0;
				double green = 0;
				double blue = 0;
				
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						
						Color color = new Color(defaultImg.getRGB(x + (i - 1), y + (j - 1)));
						red += color.getRed() * mascaraMedia[i][j];
						green += color.getGreen() * mascaraMedia[i][j];
						blue += color.getBlue() * mascaraMedia[i][j];
					}
				}
				red /= 9;
				green /= 9;
				blue /= 9;
				
				mediaAplicada.setRGB(x, y, new Color( (int) red, (int) green, (int) blue).getRGB());
			}
		}
		return algoritmoThreshold(mediaAplicada, 60);
	}
	
	public BufferedImage algoritmoThreshold(BufferedImage img, double threshold) {
		
		BufferedImage thresholdAplicado = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0; y < img.getHeight(); y++) {
			for(int x = 0; x < img.getWidth(); x++) {
				
				Color color = new Color(img.getRGB(x, y));
				int blue = color.getBlue();
				
				if(blue >= threshold) {
					blue = 255;
				}else if(blue < threshold) {
					blue = 0;
				}
				
				thresholdAplicado.setRGB(x, y, new Color(blue, blue, blue).getRGB());
			}
		}
		
		return thresholdAplicado;
	}
	
	public BufferedImage detectorDeBordasDeSobelColorido(BufferedImage img) {

		BufferedImage imgComFiltroSobel = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		int[][] kernelX = { { 1, 0, -1 }, 
						    { 2, 0, -2 }, 
						    { 1, 0, -1 } };

		int[][] kernelY = { { 1, 2, 1 }, 
						    { 0, 0, 0 }, 
						    { -1, -2, -1 } };
		
		for(int y = 1; y < img.getHeight() - 1; y++) {
			for(int x = 1; x < img.getWidth() - 1; x++) {
				
				int redX = 0;
				int greenX = 0;
				int blueX = 0;
				
				int redY = 0;
				int greenY = 0;
				int blueY = 0;
				
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						
						Color color = new Color(img.getRGB(x + (i - 1), y + (j - 1)));
						
						redX += color.getRed() * kernelX[i][j];
						redY += color.getRed() * kernelY[i][j];
						
						greenX += color.getGreen() * kernelX[i][j];
						greenY += color.getGreen() * kernelY[i][j];
						
						blueX += color.getBlue() * kernelX[i][j];
						blueY += color.getBlue() * kernelY[i][j];
					}
				}
				
				double redTotal = Math.sqrt(Math.pow(redX, 2) + Math.pow(redY, 2));
				
				double greenTotal = Math.sqrt(Math.pow(greenX, 2) + Math.pow(greenY, 2));
				
				double blueTotal = Math.sqrt(Math.pow(blueX, 2) + Math.pow(blueY, 2));
				
				if(redTotal > 255) {
					redTotal = 255;
				}else if(redTotal < 0) {
					redTotal = 0;
				}
				
				if(greenTotal > 255) {
					greenTotal = 255;
				}else if(greenTotal < 0) {
					greenTotal = 0;
				}
				
				if(blueTotal > 255) {
					blueTotal = 255;
				}else if(blueTotal < 0) {
					blueTotal = 0;
				}
				imgComFiltroSobel.setRGB(x - 1, y - 1, new Color( (int) redTotal, (int) greenTotal, (int) blueTotal).getRGB());
			}
		}

		return imgComFiltroSobel;
	}
	
	public BufferedImage detectorDeBordasDeSobelGrayScale(BufferedImage img) {

		BufferedImage imgComFiltroSobel = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		imgComFiltroSobel = escalaDeCinza(img);

		int[][] kernelX = { { 1, 0, -1 }, 
						    { 2, 0, -2 }, 
						    { 1, 0, -1 } };

		int[][] kernelY = { { 1, 2, 1 }, 
						    { 0, 0, 0 }, 
						    { -1, -2, -1 } };
		
		for(int y = 1; y < imgComFiltroSobel.getHeight() - 1; y++) {
			for(int x = 1; x < imgComFiltroSobel.getWidth() - 1; x++) {
				
				double gx = 0;
				double gy = 0;
				
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						
						Color color = new Color(imgComFiltroSobel.getRGB(x + (i - 1), y + (j - 1)));
						
						gx += color.getRed() * kernelX[i][j];
						gy += color.getRed() * kernelY[i][j];
					}
				}
				
				double g = Math.sqrt(Math.pow(gx, 2) + Math.pow(gy, 2));
				
				if(g > 255) {
					g = 255;
				}else if(g < 0) {
					g = 0;
				}
				imgComFiltroSobel.setRGB(x - 1, y - 1, new Color( (int) g, (int) g, (int) g).getRGB());
			}
		}

		return imgComFiltroSobel;
	}

	public BufferedImage escalaDeCinza(BufferedImage img) {

		double red = 0;
		double green = 0;
		double blue = 0;
		
		BufferedImage imgEscalaDeCinza = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {

				Color color = new Color(img.getRGB(i, j));
				red = color.getRed() * 0.2126;
				green = color.getGreen() * 0.7152;
				blue = color.getBlue() * 0.0722;

				int escalaCinza = (int) (red + green + blue);

				imgEscalaDeCinza.setRGB(i, j, new Color(escalaCinza, escalaCinza, escalaCinza).getRGB());
			}
		}
		return imgEscalaDeCinza;
	}

	public BufferedImage filtroMediana(int brilho, double contraste) {

		BufferedImage imgComFiltroMediana = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		int kernelWidth = 3;
		int kernelHeight = 3;

		int[] r = new int[kernelWidth * kernelHeight];
		int[] g = new int[kernelWidth * kernelHeight];
		int[] b = new int[kernelWidth * kernelHeight];

		int aux = 0;

		for (int y = 1; y < defaultImg.getHeight() - 1; y++) {
			for (int x = 1; x < defaultImg.getWidth() - 1; x++) {

				for (int ki = 0; ki < 3; ki++) {
					for (int kj = 0; kj < 3; kj++) {

						Color color = new Color(defaultImg.getRGB(x + (ki - 1), y + (kj - 1)));
						r[aux] = color.getRed();
						g[aux] = color.getGreen();
						b[aux] = color.getBlue();

						aux++;
					}
				}

				aux = 0;

				Arrays.sort(r);
				Arrays.sort(g);
				Arrays.sort(b);

				imgComFiltroMediana.setRGB(x, y, new Color(r[4], g[4], b[4]).getRGB());
			}
		}
		return aumentarBrilho(imgComFiltroMediana, 40, 1.4);
	}

	public BufferedImage filtroGaussiano() {

		int[][] mascaraFiltroGaussiano = { { 1, 2, 1 }, { 2, 4, 2 }, { 1, 2, 1 } };

		BufferedImage imgComFiltroGaussiano = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		for (int y = 1; y < defaultImg.getHeight() - 1; y++) {
			for (int x = 1; x < defaultImg.getWidth() - 1; x++) {

				double red = 0;
				double green = 0;
				double blue = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {

						Color color = new Color(defaultImg.getRGB(x + (i - 1), y + (j - 1)));
						red += color.getRed() * mascaraFiltroGaussiano[i][j];
						green += color.getGreen() * mascaraFiltroGaussiano[i][j];
						blue += color.getBlue() * mascaraFiltroGaussiano[i][j];
					}
				}
				red /= 16;
				green /= 16;
				blue /= 16;
				imgComFiltroGaussiano.setRGB(x, y, new Color( (int) red, (int) green, (int) blue).getRGB());
			}
		}
		return imgComFiltroGaussiano;
	}

	public BufferedImage aumentarBrilho(BufferedImage img, int brilho, double contraste) {

		BufferedImage imgBrilhoAumentado = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {

				Color color = new Color(img.getRGB(x, y));
				int red = (int) (contraste * color.getRed() + brilho);
				int green = (int) (contraste * color.getGreen() + brilho);
				int blue = (int) (contraste * color.getBlue() + brilho);

				if (red > 255) {
					red = 255;
				} else if (red < 0) {
					red = 0;
				}

				if (green > 255) {
					green = 255;
				} else if (green < 0) {
					green = 0;
				}

				if (blue > 255) {
					blue = 255;
				} else if (blue < 0) {
					blue = 0;
				}

				imgBrilhoAumentado.setRGB(x, y, new Color(red, green, blue).getRGB());
			}
		}

		return imgBrilhoAumentado;

	}
	
	public static void main(String[] args) {
		Segmentation runFrame = new Segmentation();
		runFrame.configurarFrame();
		runFrame.adicionarElemento();
	}

}
