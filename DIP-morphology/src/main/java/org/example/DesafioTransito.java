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
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class DesafioTransito {
	BufferedImage defaultImg;
	JPanel myPanelImg;
	JButton missaoUm, missaoTres, missaoDois, missaoQuatro;
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

		missaoQuatro = new JButton("Missao Quatro");
		missaoQuatro.setAlignmentX(Component.CENTER_ALIGNMENT);
		missaoQuatro.setBackground(Color.WHITE);
		myPanelBotoes.add(missaoQuatro);

		myPanelBotoes.add(Box.createRigidArea(new Dimension(0, 55)));

		missaoDois.addActionListener(listenerMissaoDois);
		missaoQuatro.addActionListener(listenerMissaoQuatro);
		missaoTres.addActionListener(listenerMissaoTres);
		missaoUm.addActionListener(listenerMissaoUm);

		frame.getContentPane().add(myPanelBotoes, BorderLayout.EAST);
	}

	ActionListener listenerMissaoUm = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			setarImagemQuadradaNaTela();

			File file = new File("Imagens/Imagem1.jpg");
			try {
				defaultImg = ImageIO.read(file);
			} catch (IOException e1) {
				System.out.println("Nao foi possivel abrir a imagem");
			}
			BufferedImage imagem = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			imagem = defaultImg;
			imagem = missaoUm(imagem);

			ImageIcon imagemOriginal = new ImageIcon(defaultImg.getScaledInstance(180, 180, Image.SCALE_SMOOTH));
			ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(180, 180, Image.SCALE_SMOOTH));
			imgAlteradaLabel.setIcon(imagemAlterada);
			imgOriginalLabel.setIcon(imagemOriginal);
		}
	};

	ActionListener listenerMissaoDois = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			setarImagemQuadradaNaTela();

			File file = new File("Imagens/Imagem2.jpg");
			try {

				defaultImg = ImageIO.read(file);

			} catch (IOException e2) {
				System.out.println("Nao foi possivel abrir a imagem");
			}
			BufferedImage imagem = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			imagem = defaultImg;
			imagem = missaoDois(imagem);

			ImageIcon imagemOriginal = new ImageIcon(defaultImg.getScaledInstance(180, 180, Image.SCALE_SMOOTH));
			ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(180, 180, Image.SCALE_SMOOTH));
			imgAlteradaLabel.setIcon(imagemAlterada);
			imgOriginalLabel.setIcon(imagemOriginal);
		}
	};

	ActionListener listenerMissaoTres = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			setarImagemQuadradaNaTela();

			File file = new File("Imagens/Imagem3.jpg");
			try {
				defaultImg = ImageIO.read(file);
			} catch (IOException e3) {
				System.out.println("Nao foi possivel abrir a imagem");
			}
			BufferedImage imagem = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			imagem = defaultImg;
			imagem = missaoTres(imagem);

			ImageIcon imagemOriginal = new ImageIcon(defaultImg.getScaledInstance(180, 180, Image.SCALE_SMOOTH));
			ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(180, 180, Image.SCALE_SMOOTH));
			imgAlteradaLabel.setIcon(imagemAlterada);
			imgOriginalLabel.setIcon(imagemOriginal);
		}
	};

	ActionListener listenerMissaoQuatro = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			File file = new File("Imagens/Imagem4.jpg");
			try {
				defaultImg = ImageIO.read(file);
			} catch (IOException e4) {
				System.out.println("Nao foi possivel abrir a imagem");
			}
			BufferedImage imagem = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			imagem = defaultImg;
			imagem = missaoQuatro(imagem);

			ImageIcon imagemOriginal = new ImageIcon(defaultImg.getScaledInstance(180, 180, Image.SCALE_SMOOTH));
			ImageIcon imagemAlterada = new ImageIcon(imagem.getScaledInstance(180, 180, Image.SCALE_SMOOTH));
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

	public BufferedImage missaoUm(BufferedImage img) {

		BufferedImage holtAplicado = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		holtAplicado = escalaDeCinza(img);
		holtAplicado = algoritmoThreshold(holtAplicado, 150);

		int red = 0;
		int green = 0;
		int blue = 0;

		for (int y = 0; y < holtAplicado.getHeight(); y++) {
			for (int x = 0; x < holtAplicado.getWidth(); x++) {

				Color color = new Color(holtAplicado.getRGB(x, y));
				if (color.getRed() <= 0) {
					red = 255;
				} else {
					red = 0;
				}
				if (color.getGreen() <= 0) {
					green = 255;
				} else {
					green = 0;
				}
				if (color.getBlue() <= 0) {
					blue = 255;
				} else {
					blue = 0;
				}

				holtAplicado.setRGB(x, y, new Color(red, green, blue).getRGB());
			}
		}

		int[][] binaryImage = new int[holtAplicado.getHeight()][holtAplicado.getWidth()];
		
		for (int y = 0; y < binaryImage.length; y++) {
			for (int x = 0; x < binaryImage[y].length; x++) {

				if (holtAplicado.getRGB(x, y) == Color.BLACK.getRGB()) {
					binaryImage[y][x] = 0;
				} else {
					binaryImage[y][x] = 1;
				}
			}
		}

		afinamento(binaryImage, true);

		for (int y = 0; y < binaryImage.length; y++) {
			for (int x = 0; x < binaryImage[y].length; x++) {
				
				if(binaryImage[y][x] == 0) {
					holtAplicado.setRGB(x, y, Color.BLACK.getRGB());
				}else {
					holtAplicado.setRGB(x, y, Color.WHITE.getRGB());
				}
			}
		}

		return holtAplicado;
	}

	public int[][] afinamento(final int[][] givenImage, boolean changeGivenImage) {
		int[][] binaryImage;
		if (changeGivenImage) {
			binaryImage = givenImage;
		} else {
			binaryImage = givenImage.clone();
		}
		int a, b;
		LinkedList<Pontos> pointsAlterar = new LinkedList<>();
		boolean hasChange;
		do {
			hasChange = false;
			for (int y = 1; y + 1 < binaryImage.length; y++) {
				for (int x = 1; x + 1 < binaryImage[y].length; x++) {
					a = getA(binaryImage, y, x);
					b = getB(binaryImage, y, x);
					if (binaryImage[y][x] == 1 && 2 <= b && b <= 6 && a == 1
							&& (binaryImage[y - 1][x] * binaryImage[y][x + 1] * binaryImage[y + 1][x] == 0)
							&& (binaryImage[y][x + 1] * binaryImage[y + 1][x] * binaryImage[y][x - 1] == 0)) {
						pointsAlterar.add(new Pontos(x, y));

						hasChange = true;
					}
				}
			}
			for (Pontos point : pointsAlterar) {
				binaryImage[point.getY()][point.getX()] = 0;
			}
			pointsAlterar.clear();
			for (int y = 1; y + 1 < binaryImage.length; y++) {
				for (int x = 1; x + 1 < binaryImage[y].length; x++) {
					a = getA(binaryImage, y, x);
					b = getB(binaryImage, y, x);
					if (binaryImage[y][x] == 1 && 2 <= b && b <= 6 && a == 1
							&& (binaryImage[y - 1][x] * binaryImage[y][x + 1] * binaryImage[y][x - 1] == 0)
							&& (binaryImage[y - 1][x] * binaryImage[y + 1][x] * binaryImage[y][x - 1] == 0)) {
						pointsAlterar.add(new Pontos(x, y));
						hasChange = true;
					}
				}
			}
			for (Pontos point : pointsAlterar) {
				binaryImage[point.getY()][point.getX()] = 0;
			}
		} while (hasChange);
		return binaryImage;
	}

	private int getA(int[][] binaryImage, int y, int x) {
		int count = 0;
//p2 p3
		if (y - 1 >= 0 && x + 1 < binaryImage[y].length && binaryImage[y - 1][x] == 0
				&& binaryImage[y - 1][x + 1] == 1) {
			count++;
		}
//p3 p4
		if (y - 1 >= 0 && x + 1 < binaryImage[y].length && binaryImage[y - 1][x + 1] == 0
				&& binaryImage[y][x + 1] == 1) {
			count++;
		}
//p4 p5
		if (y + 1 < binaryImage.length && x + 1 < binaryImage[y].length && binaryImage[y][x + 1] == 0
				&& binaryImage[y + 1][x + 1] == 1) {
			count++;
		}
//p5 p6
		if (y + 1 < binaryImage.length && x + 1 < binaryImage[y].length && binaryImage[y + 1][x + 1] == 0
				&& binaryImage[y + 1][x] == 1) {
			count++;
		}
//p6 p7
		if (y + 1 < binaryImage.length && x - 1 >= 0 && binaryImage[y + 1][x] == 0 && binaryImage[y + 1][x - 1] == 1) {
			count++;
		}
//p7 p8
		if (y + 1 < binaryImage.length && x - 1 >= 0 && binaryImage[y + 1][x - 1] == 0 && binaryImage[y][x - 1] == 1) {
			count++;
		}
//p8 p9
		if (y - 1 >= 0 && x - 1 >= 0 && binaryImage[y][x - 1] == 0 && binaryImage[y - 1][x - 1] == 1) {
			count++;
		}
//p9 p2
		if (y - 1 >= 0 && x - 1 >= 0 && binaryImage[y - 1][x - 1] == 0 && binaryImage[y - 1][x] == 1) {
			count++;
		}
		return count;
	}

	private int getB(int[][] binaryImage, int y, int x) {
		return binaryImage[y - 1][x] + binaryImage[y - 1][x + 1] + binaryImage[y][x + 1] + binaryImage[y + 1][x + 1]
				+ binaryImage[y + 1][x] + binaryImage[y + 1][x - 1] + binaryImage[y][x - 1] + binaryImage[y - 1][x - 1];
	}

	public BufferedImage missaoDois(BufferedImage img) {

		BufferedImage dilatacaoAplicado = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		dilatacaoAplicado = escalaDeCinza(img);
		dilatacaoAplicado = algoritmoThreshold(dilatacaoAplicado, 150);

		int red = 0;
		int green = 0;
		int blue = 0;

		for (int y = 0; y < dilatacaoAplicado.getHeight(); y++) {
			for (int x = 0; x < dilatacaoAplicado.getWidth(); x++) {

				Color color = new Color(dilatacaoAplicado.getRGB(x, y));
				if (color.getRed() <= 0) {
					red = 255;
				} else {
					red = 0;
				}
				if (color.getGreen() <= 0) {
					green = 255;
				} else {
					green = 0;
				}
				if (color.getBlue() <= 0) {
					blue = 255;
				} else {
					blue = 0;
				}

				dilatacaoAplicado.setRGB(x, y, new Color(red, green, blue).getRGB());
			}
		}

		int[] mascara;
		int output[] = new int[dilatacaoAplicado.getWidth() * dilatacaoAplicado.getHeight()];

		for (int y = 0; y < dilatacaoAplicado.getHeight(); y++) {
			for (int x = 0; x < dilatacaoAplicado.getWidth(); x++) {

				mascara = new int[9];
				int i = 0;

				for (int ty = y - 1; ty <= y + 1; ty++) {
					for (int tx = x - 1; tx <= x + 1; tx++) {
						if (ty >= 0 && ty < dilatacaoAplicado.getHeight() && tx >= 0
								&& tx < dilatacaoAplicado.getWidth()) {

							mascara[i] = dilatacaoAplicado.getRGB(tx, ty);
							i++;
						}
					}
				}
				Arrays.sort(mascara);

				output[x + y * dilatacaoAplicado.getWidth()] = mascara[8];
			}
		}

		for (int y = 0; y < dilatacaoAplicado.getHeight(); y++) {
			for (int x = 0; x < dilatacaoAplicado.getWidth(); x++) {

				int v = output[x + y * dilatacaoAplicado.getWidth()];
				dilatacaoAplicado.setRGB(x, y, v);
			}
		}

		return dilatacaoAplicado;
	}

	public BufferedImage missaoTres(BufferedImage img) {

		BufferedImage fechamentoAplicado = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		fechamentoAplicado = escalaDeCinza(img);
		fechamentoAplicado = algoritmoThreshold(fechamentoAplicado, 150);

		int red = 0;
		int green = 0;
		int blue = 0;

		for (int y = 0; y < fechamentoAplicado.getHeight(); y++) {
			for (int x = 0; x < fechamentoAplicado.getWidth(); x++) {

				Color color = new Color(fechamentoAplicado.getRGB(x, y));
				if (color.getRed() <= 0) {
					red = 255;
				} else {
					red = 0;
				}
				if (color.getGreen() <= 0) {
					green = 255;
				} else {
					green = 0;
				}
				if (color.getBlue() <= 0) {
					blue = 255;
				} else {
					blue = 0;
				}

				fechamentoAplicado.setRGB(x, y, new Color(red, green, blue).getRGB());
			}
		}

		fechamentoAplicado = dilatacao(fechamentoAplicado);
		fechamentoAplicado = erosao(fechamentoAplicado);

		return fechamentoAplicado;
	}

	public BufferedImage missaoQuatro(BufferedImage img) {

		BufferedImage erosaoAplicado = new BufferedImage(defaultImg.getWidth(), defaultImg.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		erosaoAplicado = escalaDeCinza(img);
		erosaoAplicado = algoritmoThreshold(erosaoAplicado, 230);

		erosaoAplicado = erosao(erosaoAplicado);
		erosaoAplicado = erosao(erosaoAplicado);
		erosaoAplicado = erosao(erosaoAplicado);

		return erosaoAplicado;

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
						
						//Pixels que estao sob a mascara
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
						
						//Pixels que estao sob a mascara
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
					blue = 255;
				} else if (blue < threshold) {
					blue = 0;
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
		DesafioTransito runFrame = new DesafioTransito();
		runFrame.configurarFrame();
		runFrame.adicionarElemento();
	}

}
