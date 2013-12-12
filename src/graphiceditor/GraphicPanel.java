package graphiceditor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GraphicPanel extends JPanel {
	private int xSize = 500;
	int l = 0, l2 = 0;
	private int ySize = 300;
	int tool = 0, sP = 1, sR = 8, sL = 8;
	String lang;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image = new BufferedImage(xSize, ySize,
			BufferedImage.TYPE_INT_RGB);
	private int xPrev;
	private int yPrev;
	private Color color = Color.black;
	private Color colorR = Color.white;

	public GraphicPanel() {
		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				image.setRGB(i, j, colorR.getRGB());
			}
		}
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getX() < xSize && e.getX() >= 0 && e.getY() < ySize
						&& e.getY() >= 0) {
					if (tool == 0) {
						image.setRGB(e.getX(), e.getY(), getIntColor());
						Graphics2D graphics = (Graphics2D) image.getGraphics();
						graphics.setColor(getColor());
						graphics.setStroke(new BasicStroke(sP));
						graphics.setRenderingHint(
								RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						graphics.drawLine(e.getX(), e.getY(), e.getX(),
								e.getY());
						xPrev = e.getX();
						yPrev = e.getY();
						super.mouseDragged(e);
						repaint();

					} else if (tool == 1) {
						image.setRGB(e.getX(), e.getY(), getIntColorR());
						Graphics2D graphics = (Graphics2D) image.getGraphics();
						graphics.setColor(getColorR());
						graphics.setStroke(new BasicStroke(sR));
						graphics.setRenderingHint(
								RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
						graphics.drawLine(e.getX(), e.getY(), e.getX(),
								e.getY());
						xPrev = e.getX();
						yPrev = e.getY();
						super.mouseDragged(e);
						repaint();
					} else if (tool == 2) {
						if (l == 0) {
							l = 1;
							xPrev = e.getX();
							yPrev = e.getY();
						} else if (l == 1) {
							Graphics2D graphics = (Graphics2D) image
									.getGraphics();
							graphics.setColor(getColor());
							graphics.setStroke(new BasicStroke(sL));
							graphics.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							graphics.drawLine(xPrev, yPrev, e.getX(), e.getY());
							super.mouseDragged(e);
							repaint();

							l = 0;
						}
					} else if (tool == 3) {
						if (l2 == 0) {
							l2 = 1;
							xPrev = e.getX();
							yPrev = e.getY();
						} else if (l2 == 1) {
							Graphics2D graphics = (Graphics2D) image
									.getGraphics();
							graphics.setColor(getColor());
							graphics.setStroke(new BasicStroke(sL));
							graphics.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							graphics.drawLine(xPrev, yPrev, e.getX(), e.getY());
							super.mouseDragged(e);
							repaint();
							xPrev = e.getX();
							yPrev = e.getY();
						}
					} else if (tool == 4) {
					//	Graphics2D g2 = (Graphics2D) image.getGraphics();

					//	g2.setPaint(Color.green);
					//	Rectangle2D r2 = new Rectangle2D.Float(25, 25, 150, 150);

					//	g2.fill(r2);
						fil(e.getX(), e.getY(), image.getRGB(e.getX(), e.getY()));
						repaint();
					}
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				if (e.getX() < xSize && e.getX() >= 0 && e.getY() < ySize
						&& e.getY() >= 0) {
					if (xPrev < xSize && xPrev >= 0 && yPrev < ySize
							&& yPrev >= 0) {
						if (tool == 0) {
							image.setRGB(e.getX(), e.getY(), getIntColor());
							Graphics2D graphics = (Graphics2D) image
									.getGraphics();
							graphics.setColor(getColor());
							graphics.setStroke(new BasicStroke(sP));
							graphics.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							graphics.drawLine(xPrev, yPrev, e.getX(), e.getY());
							xPrev = e.getX();
							yPrev = e.getY();
							super.mouseDragged(e);
							repaint();
						} else if (tool == 1) {
							image.setRGB(e.getX(), e.getY(), getIntColorR());
							Graphics2D graphics1 = (Graphics2D) image
									.getGraphics();
							graphics1.setColor(getColorR());
							graphics1.setStroke(new BasicStroke(sR));
							graphics1.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							graphics1.drawLine(xPrev, yPrev, xPrev, yPrev);
							for (int i = 0; i <= sR / 2; i++) {
								image.setRGB(e.getX(), e.getY(), getIntColorR());
								Graphics2D graphics = (Graphics2D) image
										.getGraphics();
								graphics.setColor(getColorR());
								graphics.setRenderingHint(
										RenderingHints.KEY_ANTIALIASING,
										RenderingHints.VALUE_ANTIALIAS_ON);
								graphics.drawLine(xPrev + i, yPrev + i,
										e.getX() + i, e.getY() + i);
								graphics.drawLine(xPrev + i, yPrev - i,
										e.getX() + i, e.getY() - i);
								graphics.drawLine(xPrev - i, yPrev + i,
										e.getX() - i, e.getY() + i);
								graphics.drawLine(xPrev - i, yPrev - i,
										e.getX() - i, e.getY() - i);
								

								graphics.drawLine(xPrev + i - 1, yPrev + i,
										e.getX() + i - 1, e.getY() + i);
								graphics.drawLine(xPrev + i - 1, yPrev - i,
										e.getX() + i - 1, e.getY() - i);
								graphics.drawLine(xPrev - i + 1, yPrev + i,
										e.getX() - i + 1, e.getY() + i);
								graphics.drawLine(xPrev - i + 1, yPrev - i,
										e.getX() - i + 1, e.getY() - i);
								

								graphics.drawLine(xPrev + i, yPrev + i - 1,
										e.getX() + i, e.getY() + i - 1);
								graphics.drawLine(xPrev + i, yPrev - i + 1,
										e.getX() + i, e.getY() - i + 1);
								graphics.drawLine(xPrev - i, yPrev + i - 1,
										e.getX() - i, e.getY() + i - 1);
								graphics.drawLine(xPrev - i, yPrev - i + 1,
										e.getX() - i, e.getY() - i + 1);
							}
							for (int i = 0; i <= sR / 2; i++) {
								image.setRGB(e.getX(), e.getY(), getIntColorR());
								Graphics2D graphics = (Graphics2D) image
										.getGraphics();
								graphics.setColor(getColorR());
								graphics.setRenderingHint(
										RenderingHints.KEY_ANTIALIASING,
										RenderingHints.VALUE_ANTIALIAS_ON);
								graphics.drawLine(xPrev + i, yPrev + i,
										e.getX() + i, e.getY() + i);
								graphics.drawLine(xPrev + i, yPrev - i,
										e.getX() + i, e.getY() - i);
								graphics.drawLine(xPrev - i, yPrev + i,
										e.getX() - i, e.getY() + i);
								graphics.drawLine(xPrev - i, yPrev - i,
										e.getX() - i, e.getY() - i);
								

								graphics.drawLine(xPrev + i - 1, yPrev + i,
										e.getX() + i - 1, e.getY() + i);
								graphics.drawLine(xPrev + i - 1, yPrev - i,
										e.getX() + i - 1, e.getY() - i);
								graphics.drawLine(xPrev - i + 1, yPrev + i,
										e.getX() - i + 1, e.getY() + i);
								graphics.drawLine(xPrev - i + 1, yPrev - i,
										e.getX() - i + 1, e.getY() - i);
								

								graphics.drawLine(xPrev + i, yPrev + i - 1,
										e.getX() + i, e.getY() + i - 1);
								graphics.drawLine(xPrev + i, yPrev - i + 1,
										e.getX() + i, e.getY() - i + 1);
								graphics.drawLine(xPrev - i, yPrev + i - 1,
										e.getX() - i, e.getY() + i - 1);
								graphics.drawLine(xPrev - i, yPrev - i + 1,
										e.getX() - i, e.getY() - i + 1);
							}
							for (int i = 0; i <= sR / 2; i++) {
								image.setRGB(e.getX(), e.getY(), getIntColorR());
								Graphics2D graphics = (Graphics2D) image
										.getGraphics();
								graphics.setColor(getColorR());
								graphics.setRenderingHint(
										RenderingHints.KEY_ANTIALIASING,
										RenderingHints.VALUE_ANTIALIAS_ON);
								graphics.drawLine(xPrev + i, yPrev + i,
										e.getX() + i, e.getY() + i);
								graphics.drawLine(xPrev + i, yPrev - i,
										e.getX() + i, e.getY() - i);
								graphics.drawLine(xPrev - i, yPrev + i,
										e.getX() - i, e.getY() + i);
								graphics.drawLine(xPrev - i, yPrev - i,
										e.getX() - i, e.getY() - i);
								

								graphics.drawLine(xPrev + i - 1, yPrev + i,
										e.getX() + i - 1, e.getY() + i);
								graphics.drawLine(xPrev + i - 1, yPrev - i,
										e.getX() + i - 1, e.getY() - i);
								graphics.drawLine(xPrev - i + 1, yPrev + i,
										e.getX() - i + 1, e.getY() + i);
								graphics.drawLine(xPrev - i + 1, yPrev - i,
										e.getX() - i + 1, e.getY() - i);
								

								graphics.drawLine(xPrev + i, yPrev + i - 1,
										e.getX() + i, e.getY() + i - 1);
								graphics.drawLine(xPrev + i, yPrev - i + 1,
										e.getX() + i, e.getY() - i + 1);
								graphics.drawLine(xPrev - i, yPrev + i - 1,
										e.getX() - i, e.getY() + i - 1);
								graphics.drawLine(xPrev - i, yPrev - i + 1,
										e.getX() - i, e.getY() - i + 1);
							}
							image.setRGB(e.getX(), e.getY(), getIntColorR());
							Graphics2D graphics2 = (Graphics2D) image
									.getGraphics();
							graphics2.setColor(getColorR());
							graphics2.setStroke(new BasicStroke(sR));
							graphics2.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							graphics2.drawLine(e.getX(), e.getY(), e.getX(),
									e.getY());
							xPrev = e.getX();
							yPrev = e.getY();
							super.mouseDragged(e);
							repaint();
						}
					} else {
						if (tool == 0) {
							image.setRGB(e.getX(), e.getY(), getIntColor());
							Graphics2D graphics = (Graphics2D) image
									.getGraphics();
							graphics.setColor(getColor());
							graphics.setStroke(new BasicStroke(sP));
							graphics.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							graphics.drawLine(e.getX(), e.getY(), e.getX(),
									e.getY());
							xPrev = e.getX();
							yPrev = e.getY();
							super.mouseDragged(e);
							repaint();

						} else if (tool == 1) {
							image.setRGB(e.getX(), e.getY(), getIntColorR());
							Graphics2D graphics = (Graphics2D) image
									.getGraphics();
							graphics.setColor(getColorR());
							graphics.setStroke(new BasicStroke(sR));
							graphics.setRenderingHint(
									RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
							graphics.drawLine(e.getX(), e.getY(), e.getX(),
									e.getY());
							xPrev = e.getX();
							yPrev = e.getY();
							super.mouseDragged(e);
							repaint();
						}
					}
				} else {
					xPrev = e.getX();
					yPrev = e.getY();
				}
			}
		});

	}

	public BufferedImage getImage() {
		return image;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	public void reFresh() {
		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				image.setRGB(i, j, colorR.getRGB());
			}
		}
	}

	void fil(int x, int y, int color1) {
		if (color1 == color.getRGB())
			return;
		class StackElem {
			int x, y;
		}
		ArrayList<StackElem> stack = new ArrayList<StackElem>();
		StackElem NowIs = new StackElem();
		NowIs.x = x;
		NowIs.y = y;
		stack.add(NowIs);
		while (stack.size() > 0) {
			int a = 0;
			StackElem NowIsNew = stack.remove(stack.size() - 1);
			if ((NowIsNew.x<0 || NowIsNew.y<0 || NowIsNew.x>=xSize || NowIsNew.y>=ySize))
				continue;
			if(image.getRGB(NowIsNew.x, NowIsNew.y) != color1) continue;
		//	System.out.println("debug " + NowIsNew.x + " " + NowIsNew.y);
			image.setRGB(NowIsNew.x, NowIsNew.y, color.getRGB());
			StackElem NowIsNew1 = new StackElem();
			NowIsNew1.x = NowIsNew.x + 1;
			NowIsNew1.y = NowIsNew.y;
			stack.add(NowIsNew1);
			StackElem NowIsNew2 = new StackElem();
			NowIsNew2.x = NowIsNew.x;
			NowIsNew2.y = NowIsNew.y + 1;
			stack.add(NowIsNew2);
			StackElem NowIsNew3 = new StackElem();
			NowIsNew3.x = NowIsNew.x - 1;
			NowIsNew3.y = NowIsNew.y;
			stack.add(NowIsNew3);
			StackElem NowIsNew4 = new StackElem();
			NowIsNew4.x = NowIsNew.x;
			NowIsNew4.y = NowIsNew.y - 1;
			stack.add(NowIsNew4);
			// TODO
			this.repaint();
			NowIsNew = null;
		}
	}

	public void open() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Windows BMP file", "bmp");
		FileNameExtensionFilter filter2 = new FileNameExtensionFilter(
				"JPEG file", "jpg", "jpeg");
		FileNameExtensionFilter filter3 = new FileNameExtensionFilter("PNG",
				"png");
		// TODO all img
		FileNameExtensionFilter filter4 = new FileNameExtensionFilter(
				"All images", "png", "jpg", "jpeg", "bmp");
		JFileChooser chooserOpen = new JFileChooser();
		chooserOpen.addChoosableFileFilter(filter4);
		chooserOpen.addChoosableFileFilter(filter);
		chooserOpen.addChoosableFileFilter(filter2);
		chooserOpen.addChoosableFileFilter(filter3);
		if (chooserOpen.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = chooserOpen.getSelectedFile();
			GUI.setTitle(file.getName()
					+ " - GrapficEditor " + Constants.ver + " \"" + Constants.verName + "\" " + lang);

			try {
				image = ImageIO.read(file);
				GUI.open(image.getWidth(), image.getHeight());
				image = ImageIO.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * public void save() { try { ImageIO.write(image, "BMP", new
	 * File("images/GraphicEditor_"+System.currentTimeMillis()+".bmp")); } catch
	 * (IOException e) { e.printStackTrace(); } }
	 */

	public void saveAs() {
		try {
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Windows BMP file", "bmp");
			FileNameExtensionFilter filter2 = new FileNameExtensionFilter(
					"JPEG file", "jpg", "jpeg");
			FileNameExtensionFilter filter3 = new FileNameExtensionFilter(
					"PNG", "png");

			JFileChooser chooser = new JFileChooser();
			chooser.addChoosableFileFilter(filter);
			chooser.addChoosableFileFilter(filter2);
			chooser.addChoosableFileFilter(filter3);
			if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				if (!file.getName().contains(".")) {
					if (chooser.getFileFilter() == filter3) {
						file = new File(file.getParent(), file.getName()
								+ ".png");
						ImageIO.write(image, "PNG", file);
					} else if (chooser.getFileFilter() == filter2) {
						file = new File(file.getParent(), file.getName()
								+ ".jpg");
						ImageIO.write(image, "JPEG", file);
					} else if (chooser.getFileFilter() == filter) {
						file = new File(file.getParent(), file.getName()
								+ ".bmp");
						ImageIO.write(image, "BMP", file);
					} else {
						file = new File(file.getParent(), file.getName()
								+ ".png");
						ImageIO.write(image, "PNG", file);
					}
				}
				GUI.setTitle(file.getName()
						+ "-GrapficEditor " + Constants.ver + "  \"" + Constants.verName + "\" " + lang);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setColorR(Color color) {
		this.colorR = color;
	}

	public int getIntColor() {
		return (((color.getRed() << 8) | color.getGreen()) << 8)
				| color.getBlue();
	}

	public int getIntColorR() {
		return (((colorR.getRed() << 8) | colorR.getGreen()) << 8)
				| colorR.getBlue();
	}

	public Color getColor() {
		return color;
	}

	public Color getColorR() {
		return colorR;
	}

	public void setSizeX(int x) {
		xSize = x;
	}

	public void setSizeY(int y) {
		ySize = y;
		image = new BufferedImage(xSize, ySize, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				image.setRGB(i, j, 0xffffff);
			}
		}
	}

	public void setTool(int i) {
		tool = i;
		if (tool == 3)
			l2 = 0;
		if (tool == 2)
			l = 0;
	}

	public void SP(int i) {
		sP = i;
	}

	public void SR(int i) {
		sR = i;
	}

	public void SL(int i) {
		sL = i;
	}

	void SetLang(String get) {
		lang = get;
	}

	void Translations() {

	}
}
