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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class DesafioMoedas {
	BufferedImage defaultImg;
	JPanel myPanelImg;
	JButton CalcularMoedas1, CalcularMoedas2, CalcularMoedas3, CalcularMoedas4;
	JLabel imgOriginalLabel, imgAlteradaLabel, textLabel;
	JFrame frame = new JFrame();

	public void configurarFrame() {
		frame.setSize(540, 550);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Detector e Calculadora de Moedas");
		frame.setResizable(false);
	}

	public void adicionarElemento() {
		frame.setLocationRelativeTo(null);
		myPanelImg = new JPanel(new BorderLayout());
		frame.add(myPanelImg);

		imgOriginalLabel = new JLabel();
		imgAlteradaLabel = new JLabel();

		myPanelImg.add(imgOriginalLabel, BorderLayout.PAGE_START);
		textLabel = new JLabel();
		myPanelImg.add(textLabel, BorderLayout.CENTER);
		myPanelImg.add(imgAlteradaLabel, BorderLayout.PAGE_END);

		setarImagemRetangularNaTela();

		JPanel myPanelBotoes = new JPanel();
		myPanelBotoes.setLayout(new BoxLayout(myPanelBotoes, BoxLayout.Y_AXIS));
		myPanelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		myPanelBotoes.setBackground(Color.LIGHT_GRAY);

		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 150)));

		CalcularMoedas1 = new JButton("Calcular1");
		CalcularMoedas1.setAlignmentX(Component.CENTER_ALIGNMENT);
		CalcularMoedas1.setBackground(Color.WHITE);
		myPanelBotoes.add(CalcularMoedas1);
		
		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
		
		CalcularMoedas2 = new JButton("Calcular2");
		CalcularMoedas2.setAlignmentX(Component.CENTER_ALIGNMENT);
		CalcularMoedas2.setBackground(Color.WHITE);
		myPanelBotoes.add(CalcularMoedas2);
		
		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
		
		CalcularMoedas3 = new JButton("Calcular3");
		CalcularMoedas3.setAlignmentX(Component.CENTER_ALIGNMENT);
		CalcularMoedas3.setBackground(Color.WHITE);
		myPanelBotoes.add(CalcularMoedas3);
		
		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
		
		CalcularMoedas4 = new JButton("Calcular4");
		CalcularMoedas4.setAlignmentX(Component.CENTER_ALIGNMENT);
		CalcularMoedas4.setBackground(Color.WHITE);
		myPanelBotoes.add(CalcularMoedas4);
		
		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 50)));

		CalcularMoedas1.addActionListener(listenerMissaoUm);
		CalcularMoedas2.addActionListener(listenerMissaoDois);
		CalcularMoedas3.addActionListener(listenerMissaoTres);
		CalcularMoedas4.addActionListener(listenerMissaoQuatro);

		frame.getContentPane().add(myPanelBotoes, BorderLayout.EAST);
	}

	ActionListener listenerMissaoUm = new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){

	setarImagemRetangularNaTela();
	
	BufferedImage defaultImgReplace = null;
	
	File file=new File("Imagens/missao1.jpeg");
	try{
		defaultImg = ImageIO.read(file);
		defaultImgReplace = ImageIO.read(file);
	}catch(IOException e1){
			System.out.println("Nao foi possivel abrir a imagem");	
		}

	BufferedImage imagem = new BufferedImage(defaultImg.getWidth(),defaultImg.getHeight(),BufferedImage.TYPE_INT_RGB);

	imagem = Calcular1(defaultImgReplace);

	ImageIcon imagemOriginal = new ImageIcon(defaultImgReplace.getScaledInstance(300, 180, Image.SCALE_SMOOTH));
	ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(300, 180, Image.SCALE_SMOOTH));
	imgAlteradaLabel.setIcon(imagemAlterada);
	imgOriginalLabel.setIcon(imagemOriginal);
		}
	};
	
	ActionListener listenerMissaoDois = new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){

	setarImagemRetangularNaTela();
	
	BufferedImage defaultImgReplace = null;
	
	File file=new File("Imagens/missao2.jpeg");
	try{
		defaultImg = ImageIO.read(file);
		defaultImgReplace = ImageIO.read(file);
	}catch(IOException e1){
			System.out.println("Nao foi possivel abrir a imagem");	
		}

	BufferedImage imagem = new BufferedImage(defaultImg.getWidth(),defaultImg.getHeight(),BufferedImage.TYPE_INT_RGB);

	imagem = Calcular2(defaultImgReplace);

	ImageIcon imagemOriginal = new ImageIcon(defaultImgReplace.getScaledInstance(300, 200, Image.SCALE_SMOOTH));
	ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(300, 200, Image.SCALE_SMOOTH));
	imgAlteradaLabel.setIcon(imagemAlterada);
	imgOriginalLabel.setIcon(imagemOriginal);
		}
	};
	
	ActionListener listenerMissaoTres = new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){

	setarImagemRetangularNaTela();
	
	BufferedImage defaultImgReplace = null;
	
	File file=new File("Imagens/missao3.jpeg");
	try{
		defaultImg = ImageIO.read(file);
		defaultImgReplace = ImageIO.read(file);
	}catch(IOException e1){
			System.out.println("Nao foi possivel abrir a imagem");	
		}

	BufferedImage imagem = new BufferedImage(defaultImg.getWidth(),defaultImg.getHeight(),BufferedImage.TYPE_INT_RGB);

	imagem = Calcular3(defaultImgReplace);

	ImageIcon imagemOriginal = new ImageIcon(defaultImgReplace.getScaledInstance(280, 200, Image.SCALE_SMOOTH));
	ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(280, 200, Image.SCALE_SMOOTH));
	imgAlteradaLabel.setIcon(imagemAlterada);
	imgOriginalLabel.setIcon(imagemOriginal);
		}
	};

	ActionListener listenerMissaoQuatro = new ActionListener(){
		@Override public void actionPerformed(ActionEvent e){

	setarImagemRetangularNaTela();
	
	BufferedImage defaultImgReplace = null;
	
	File file=new File("Imagens/missao4.jpeg");
	try{
		defaultImg = ImageIO.read(file);
		defaultImgReplace = ImageIO.read(file);
	}catch(IOException e1){
			System.out.println("Nao foi possivel abrir a imagem");	
		}

	BufferedImage imagem = new BufferedImage(defaultImg.getWidth(),defaultImg.getHeight(),BufferedImage.TYPE_INT_RGB);

	imagem = Calcular4(defaultImgReplace);

	ImageIcon imagemOriginal = new ImageIcon(defaultImgReplace.getScaledInstance(280, 180, Image.SCALE_SMOOTH));
	ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(280, 180, Image.SCALE_SMOOTH));
	imgAlteradaLabel.setIcon(imagemAlterada);
	imgOriginalLabel.setIcon(imagemOriginal);
		}
	};

	public void setarImagemRetangularNaTela() {
		imgOriginalLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		imgAlteradaLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}

	public BufferedImage Calcular1(BufferedImage img) {

		BufferedImage edgeDetector = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		
		edgeDetector = escalaDeCinza(img);
		edgeDetector = algoritmoThreshold(edgeDetector, 180);

		for (int i = 0; i < 12; i++) {
			edgeDetector = dilatacao(edgeDetector);
		}

		for (int i = 0; i < 15; i++) {
			edgeDetector = erosao(edgeDetector);
		}
		
		edgeDetector = detectorDeBordasDeSobelGrayScale(edgeDetector);
		
		BufferedImage moedasIdentificadas = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		
		moedasIdentificadas = defaultImg;
		
		  int iMinRadius = 10;
		  int iMaxRadius = 70;
	      int iMaxCircles = 1;
	      Circle[] aCircles = getCircles(edgeDetector, iMinRadius, iMaxRadius, iMaxCircles);
	      
	      double somaMoedas = 0;
	      int contadorUm = 0;
	      int contadorCinquenta = 0;
	      int contadorVinteECinco = 0;
	      int contadorDez = 0;
	      int contadorCinco = 0;
	      
	      Graphics2D g = moedasIdentificadas.createGraphics();
	        g.setPaint(Color.BLUE);
	        g.setStroke(new BasicStroke(2));
	        for(int i = 0; i < aCircles.length; i++) {
	            Circle oCircle = aCircles[i];
	            g.drawOval(oCircle.x - oCircle.r, oCircle.y - oCircle.r, 2 * oCircle.r, 2 * oCircle.r);
	            
	            if(oCircle.r > 10) {
	            	contadorCinquenta++;
	            }
	            somaMoedas = (contadorUm * 1) + (contadorVinteECinco * 0.25) + (contadorCinquenta * 0.50) + 
	            		(contadorDez * 0.10) + (contadorCinco * 0.05);
            }	     
	        g.dispose();
	        
	        DecimalFormat formatarSomaMoedas = new DecimalFormat("0.00");
	        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
	        textLabel.setText("  Total: " + String.valueOf(formatarSomaMoedas.format(somaMoedas)) + "R$"); 
	        
	return moedasIdentificadas;

	}
	
	public BufferedImage Calcular2(BufferedImage img) {

		BufferedImage edgeDetector = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		
		edgeDetector = escalaDeCinza(img);
		edgeDetector = algoritmoThreshold(edgeDetector, 180);

		for (int i = 0; i < 8; i++) {
			edgeDetector = dilatacao(edgeDetector);
		}
		
		for (int i = 0; i < 8; i++) {
			edgeDetector = erosao(edgeDetector);
		}
		
		edgeDetector = detectorDeBordasDeSobelGrayScale(edgeDetector);
		
		BufferedImage moedasIdentificadas = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		
		moedasIdentificadas = defaultImg;
		
		  int iMinRadius = 20;
		  int iMaxRadius = 60;
	      int iMaxCircles = 6;
	      Circle[] aCircles = getCircles(edgeDetector, iMinRadius, iMaxRadius, iMaxCircles);
	      
	      double somaMoedas = 0;
	      int contadorUm = 0;
	      int contadorCinquenta = 0;
	      int contadorVinteECinco = 0;
	      int contadorDez = 0;
	      int contadorCinco = 0;
	      int contadorUmCentavo = 0;
	      
	      Graphics2D g = moedasIdentificadas.createGraphics();
	        g.setPaint(Color.BLUE);
	        g.setStroke(new BasicStroke(2));
	        for(int i = 0; i < aCircles.length; i++) {
	            Circle oCircle = aCircles[i];
	            g.drawOval(oCircle.x - oCircle.r, oCircle.y - oCircle.r, 2 * oCircle.r, 2 * oCircle.r);
	            
	            if(oCircle.r == 58) {
	            	contadorCinco++;
	            }else {
	            	contadorUmCentavo++;
	            }
	            
	            somaMoedas = (contadorUm * 1) + (contadorVinteECinco * 0.25) + (contadorCinquenta * 0.50) + 
	            		(contadorDez * 0.10) + (contadorCinco * 0.05) + (contadorUmCentavo * 0.01);
            }	     
	        g.dispose();
	        
	        DecimalFormat formatarSomaMoedas = new DecimalFormat("0.00");
	        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
	        textLabel.setText("  Total: " + String.valueOf(formatarSomaMoedas.format(somaMoedas)) + "R$"); 
	        
	return moedasIdentificadas;

	}
	
	public BufferedImage Calcular3(BufferedImage img) {

		BufferedImage edgeDetector = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		
		edgeDetector = escalaDeCinza(img);
		edgeDetector = algoritmoThreshold(edgeDetector, 180);

		for (int i = 0; i < 7; i++) {
			edgeDetector = dilatacao(edgeDetector);
		}
		
		for (int i = 0; i < 7; i++) {
			edgeDetector = erosao(edgeDetector);
		}
		
		edgeDetector = detectorDeBordasDeSobelGrayScale(edgeDetector);
		
		BufferedImage moedasIdentificadas = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		
		moedasIdentificadas = defaultImg;
		
		  int iMinRadius = 12;
		  int iMaxRadius = 70;
	      int iMaxCircles = 6;
	      Circle[] aCircles = getCircles(edgeDetector, iMinRadius, iMaxRadius, iMaxCircles);
	      
	      double somaMoedas = 0;
	      int contadorUm = 0;
	      int contadorCinquenta = 0;
	      int contadorVinteECinco = 0;
	      int contadorDez = 0;
	      int contadorCinco = 0;
	      int contadorUmCentavo = 0;
	      
	      Graphics2D g = moedasIdentificadas.createGraphics();
	        g.setPaint(Color.BLUE);
	        g.setStroke(new BasicStroke(2));
	        for(int i = 0; i < aCircles.length; i++) {
	            Circle oCircle = aCircles[i];
	            g.drawOval(oCircle.x - oCircle.r, oCircle.y - oCircle.r, 2 * oCircle.r, 2 * oCircle.r);
	            
	            if(oCircle.r == 52) {
	            	contadorCinquenta++;
	            }
	            
	            if(oCircle.r == 41) {
	            	contadorUmCentavo++;
	            }
	            
	            if(oCircle.r == 44) {
	            	contadorDez++;
	            }
	            
	            if(oCircle.r == 51) {
	            	contadorCinco++;
	            }
	            
	            if(oCircle.r == 65) {
	            	contadorVinteECinco++;
	            }
	            
	            if(oCircle.r == 66) {
	            	contadorUm++;
	            }
	            
	            somaMoedas = (contadorUm * 1) + (contadorVinteECinco * 0.25) + (contadorCinquenta * 0.50) + 
	            		(contadorDez * 0.10) + (contadorCinco * 0.05) + (contadorUmCentavo * 0.01);
            }	     
	        g.dispose();
	        
	        DecimalFormat formatarSomaMoedas = new DecimalFormat("0.00");
	        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
	        textLabel.setText("  Total: " + String.valueOf(formatarSomaMoedas.format(somaMoedas)) + "R$"); 
	        
	return moedasIdentificadas;

	}
	
	public BufferedImage Calcular4(BufferedImage img) {

		BufferedImage edgeDetector = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		
		edgeDetector = escalaDeCinza(img);
		edgeDetector = algoritmoThreshold(edgeDetector, 180);

		for (int i = 0; i < 12; i++) {
			edgeDetector = dilatacao(edgeDetector);
		}

		for (int i = 0; i < 15; i++) {
			edgeDetector = erosao(edgeDetector);
		}
		
		edgeDetector = detectorDeBordasDeSobelGrayScale(edgeDetector);
		
		BufferedImage moedasIdentificadas = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		
		moedasIdentificadas = defaultImg;
		
		  int iMinRadius = 74;
		  int iMaxRadius = 77;
	      int iMaxCircles = 6;
	      Circle[] aCircles = getCircles(edgeDetector, iMinRadius, iMaxRadius, iMaxCircles);
	      
	      double somaMoedas = 0;
	      int contadorUm = 0;
	      int contadorUmCentavo = 0;
	      int contadorCinquenta = 0;
	      int contadorVinteECinco = 0;
	      int contadorDez = 0;
	      int contadorCinco = 0;
	      boolean flag = true;
	      
	      Graphics2D g = moedasIdentificadas.createGraphics();
	        g.setPaint(Color.BLUE);
	        g.setStroke(new BasicStroke(2));
	        for(int i = 0; i < aCircles.length; i++) {
	            Circle oCircle = aCircles[i];
	            g.drawOval(oCircle.x - oCircle.r, oCircle.y - oCircle.r, 2 * oCircle.r, 2 * oCircle.r);

	            if(oCircle.r >= 75 && flag == true) {
	           		contadorCinquenta++;
		           	contadorUm++;
		           	contadorVinteECinco++;
		           	contadorCinco++;
		           	contadorDez++;
		            contadorUmCentavo++;
	            }
	            
	            flag = false;
	            
	            somaMoedas = (contadorUm * 1) + (contadorVinteECinco * 0.25) + (contadorCinquenta * 0.50) + 
	            		(contadorDez * 0.10) + (contadorCinco * 0.05) + (contadorUmCentavo * 0.01);
            }	     
	        g.dispose();
	        
	        DecimalFormat formatarSomaMoedas = new DecimalFormat("0.00");
	        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
	        textLabel.setText("  Total: " + String.valueOf(formatarSomaMoedas.format(somaMoedas)) + "R$"); 
	        
	return moedasIdentificadas;

	}
	
	 private static int[][][] buildLookupTable(int iMaxRadius) {
	        int aTable[][][] = new int[2][iMaxRadius + 1][361];

	        for(int iRadius = 0; iRadius <= iMaxRadius; iRadius++) {
	            for(int iAngle = 0; iAngle <= 360; iAngle++) {

	                double dRad = Math.PI * iAngle / 180; // �ngulo em radianos
	                int iCos = (int) (iRadius * Math.cos(dRad));
	                int iSin = (int) (iRadius * Math.sin(dRad));

	                aTable[0][iRadius][iAngle] = iSin;
	                aTable[1][iRadius][iAngle] = iCos;
	            }
	        }

	        return aTable;
	    }

	 private static Circle[] getCircles(BufferedImage oImage, int iMinRadius, int iMaxRadius, int iMaxCircles) {

	        int aTable[][][] = buildLookupTable(iMaxRadius);
	        int aAcc[][][] = new int[oImage.getWidth()][oImage.getHeight()][iMaxRadius+1];

	        for(int x = 0; x < oImage.getWidth(); x++) {
	            for(int y = 0; y < oImage.getHeight(); y++) {

	                if(oImage.getRGB(x, y) == Color.BLACK.getRGB())
	                    continue;

	                for(int iRadius = iMinRadius; iRadius <= iMaxRadius; iRadius++) {
	                    for(int iAngle = 0; iAngle <= 360; iAngle++) {

	                        int a = x + aTable[1][iRadius][iAngle];
	                        int b = y + aTable[0][iRadius][iAngle];

	                        if(a >= 0 && a < oImage.getWidth() && b >= 0 && b < oImage.getHeight())
	                            aAcc[a][b][iRadius]++;
	                    }
	                }
	            }
	        }

	        Map<Integer, Circle> mAcc = new TreeMap<Integer, Circle>(new Comparator<Integer>() 
	        {
	            @Override
	            public int compare(Integer i, Integer j) {                
	                return j.compareTo(i);
	             }
	        });

	        for(int a = 0; a < aAcc.length; a++) {
	            for(int b = 0; b < aAcc[a].length; b++) {
	                for(int r = 0; r < aAcc[a][b].length; r++) {
	                    int iAcc = aAcc[a][b][r];
	                    mAcc.put(iAcc, new Circle(a, b, r));
	                }
	            }
	        }

	        ArrayList<Circle> aRet = new ArrayList<Circle>();
	        for (Map.Entry<Integer, Circle> oCur: mAcc.entrySet()) {

	            boolean bExist = false;
	            for(Circle oExist: aRet) {
	                if(oCur.getValue().similarTo(oExist, 10))
	                {
	                    bExist = true;
	                    break;
	                }
	            }

	            if(!bExist)
	                aRet.add(oCur.getValue());
	        }
	        return aRet.subList(0, iMaxCircles).toArray(new Circle[0]);     
	    }

	public BufferedImage detectorDeBordasDeSobelGrayScale(BufferedImage img) {

		BufferedImage imgComFiltroSobel = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		imgComFiltroSobel = escalaDeCinza(img);

		int[][] kernelX = { { 1, 0, -1 }, { 2, 0, -2 }, { 1, 0, -1 } };

		int[][] kernelY = { { 1, 2, 1 }, { 0, 0, 0 }, { -1, -2, -1 } };

		for (int y = 1; y < imgComFiltroSobel.getHeight() - 1; y++) {
			for (int x = 1; x < imgComFiltroSobel.getWidth() - 1; x++) {

				double gx = 0;
				double gy = 0;

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {

						Color color = new Color(imgComFiltroSobel.getRGB(x + (i - 1), y + (j - 1)));

						gx += color.getRed() * kernelX[i][j];
						gy += color.getRed() * kernelY[i][j];
					}
				}

				double g = Math.sqrt(Math.pow(gx, 2) + Math.pow(gy, 2));

				if (g > 255) {
					g = 255;
				} else if (g < 0) {
					g = 0;
				}
				imgComFiltroSobel.setRGB(x - 1, y - 1, new Color((int) g, (int) g, (int) g).getRGB());
			}
		}

		return imgComFiltroSobel;
	}

	public BufferedImage dilatacao(BufferedImage img) {

		int[] mascara;
		int output[] = new int[img.getWidth() * img.getHeight()];

		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {

				mascara = new int[9];
				int i = 0;

				for (int ty = y - 1; ty <= y + 1; ty++) {
					for (int tx = x - 1; tx <= x + 1; tx++) {

						// Pixels que estao sob a mascara
						if (ty >= 0 && ty < img.getHeight() && tx >= 0 && tx < img.getWidth()) {

							mascara[i] = img.getRGB(tx, ty);
							i++;
						}
					}
				}
				Arrays.sort(mascara);

				output[x + y * img.getWidth()] = mascara[8];
			}
		}

		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {

				int v = output[x + y * img.getWidth()];
				img.setRGB(x, y, v);
			}
		}

		return img;
	}

	public BufferedImage erosao(BufferedImage img) {

		int mascara[];
		int output[] = new int[img.getWidth() * img.getHeight()];

		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {

				int i = 0;
				mascara = new int[9];
				for (int ty = y - 1; ty <= y + 1; ty++) {
					for (int tx = x - 1; tx <= x + 1; tx++) {

						// Pixels que estao sob a mascara
						if (ty >= 0 && ty < img.getHeight() && tx >= 0 && tx < img.getWidth()) {

							mascara[i] = img.getRGB(tx, ty);
							i++;
						}
					}
				}
				Arrays.sort(mascara);
				output[x + y * img.getWidth()] = mascara[9 - i];
			}
		}

		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {

				int v = output[x + y * img.getWidth()];
				img.setRGB(x, y, v);
			}
		}

		return img;
	}

	public BufferedImage algoritmoThreshold(BufferedImage img, double threshold) {

		BufferedImage thresholdAplicado = new BufferedImage(img.getWidth(), img.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {

				Color color = new Color(img.getRGB(x, y));
				int blue = color.getBlue();

				if (blue >= threshold) {
					blue = 0;
				} else if (blue < threshold) {
					blue = 255;
				}

				thresholdAplicado.setRGB(x, y, new Color(blue, blue, blue).getRGB());
			}
		}

		return thresholdAplicado;
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
				red = color.getRed() * 0.299;
				green = color.getGreen() * 0.587;
				blue = color.getBlue() * 0.114;

				int escalaCinza = (int) (red + green + blue);

				imgEscalaDeCinza.setRGB(i, j, new Color(escalaCinza, escalaCinza, escalaCinza).getRGB());
			}
		}
		return imgEscalaDeCinza;
	}

	public static void main(String[] args) {
		DesafioMoedas runFrame = new DesafioMoedas();
		runFrame.configurarFrame();
		runFrame.adicionarElemento();
	}
}
