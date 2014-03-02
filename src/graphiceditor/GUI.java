package graphiceditor;

import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
//import java.io.File;
//import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import ru.blogofcoder.utils.Util;

public class GUI {
	String lang;

	String file;
	String help;
	String image;

	String new1;
	String open;
	String save;
	String exit;
	String about;

	String clear;
	String colourChooser;

	String color;
	String fone;
	String oK;
	String canCel;
	String width;
	String height;

	String ch1;
	String ch2;

	String aboutText;

	String ps;
	String es;
	String ls;

	String ips;
	String ies;
	String ils;

	String l1;
	String l2;
	String site;
	String supm;
	String supf;
	// TODO

	private final static JFrame jFrame = new JFrame();
	final static GraphicPanel gpanel = new GraphicPanel();

	JButton pencil = new JButton();
	JButton rubber = new JButton();
	JButton line = new JButton();
	JButton line2 = new JButton();

	public GUI() {
		Util.out("Creating splash");
		JDialog dialog = new JDialog();
		dialog.setLayout(new BoxLayout(dialog.getContentPane(),
				BoxLayout.Y_AXIS));
		dialog.setTitle("Loading GraphicEditor " + Constants.ver + " \"" + Constants.verName + "\"");
		// TODO
		dialog.setUndecorated(true);
		JLabel jlabel = new JLabel();
		ImageIcon imageIcon12 = new ImageIcon(getClass().getResource(
				"icons/logo4.png"));
		jlabel.setIcon(imageIcon12);
		JLabel label = new JLabel("Please wait...");
		dialog.add(jlabel);
		dialog.add(label);
		label.setOpaque(!label.isOpaque());
		dialog.setBackground(Color.white);
		label.setBackground(Color.white);
		dialog.pack();
		Util.out("Running splash");
		dialog.setVisible(true);
		dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		dialog.setLocationRelativeTo(null);

		final JDialog dialogLang = new JDialog();
		dialogLang.setLayout(new BoxLayout(dialogLang.getContentPane(),
				BoxLayout.Y_AXIS));
		dialogLang.setTitle("Choosing language");

		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JLabel lab = new JLabel("Choose language");
		panel1.add(lab);
		JButton Eng = new JButton("English");
		panel.add(Eng);
		JButton Rus = new JButton("Русский");
		panel.add(Rus);
		dialogLang.add(panel1);
		dialogLang.add(panel);
		dialogLang.pack();
		dialogLang.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		dialogLang.setLocationRelativeTo(null);
		Eng.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lang = "Eng";
				l1 = "Importing languges...";
				l2 = "Building interface...";
				dialogLang.setVisible(false);
			}
		});
		Rus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lang = "Rus";
				l1 = "Импорт языков...";
				l2 = "Сборка интерфейса...";
				dialogLang.setVisible(false);
			}
		});
		if (lang == null) {
			lang = "Eng";
			l1 = "Importing languges...";
			l2 = "Building interface...";
		}
		label.setText("Choose language...");
		Util.out("Running lang dialog");
		dialogLang.setVisible(true);
		Util.out("Choosed lang: " + lang);
		label.setText(l1);
		Translations();
		gpanel.SetLang(lang);
		gpanel.Translations();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Util.out("Building interface");

		label.setText(l2);
		jFrame.setLayout(new BoxLayout(jFrame.getContentPane(),
				BoxLayout.Y_AXIS));
		jFrame.setTitle("GraphicEditor " + Constants.ver + " \"" + Constants.verName + "\" " + lang);
		// TODO
		jFrame.setPreferredSize(new Dimension(1280, 700));
		jFrame.setMinimumSize(new Dimension(800, 450));
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ������� ��������

		gpanel.setPreferredSize(new Dimension(500, 300));
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu(file);
		JMenu menu2 = new JMenu(help);
		JMenu menu3 = new JMenu(image);
		JScrollPane scrollPane = new JScrollPane(gpanel);
		// ����������� ������
		ImageIcon imageIcon1 = new ImageIcon(getClass().getResource(
				"icons/New document.gif"));
		ImageIcon imageIcon2 = new ImageIcon(getClass().getResource(
				"icons/Folder.gif"));
		ImageIcon imageIcon3 = new ImageIcon(getClass().getResource(
				"icons/Save.gif"));
		ImageIcon imageIcon4 = new ImageIcon(getClass().getResource(
				"icons/Turn off.gif"));
		ImageIcon imageIcon5 = new ImageIcon(getClass().getResource(
				"icons/Help book 3d.gif"));
		ImageIcon imageIcon51 = new ImageIcon(getClass().getResource(
				"icons/Exit.gif"));
		final ImageIcon imageIcon6 = new ImageIcon(getClass().getResource(
				"icons/OK.gif"));
		final ImageIcon imageIcon7 = new ImageIcon(getClass().getResource(
				"icons/Cancel.gif"));
		ImageIcon imageIcon72 = new ImageIcon(getClass().getResource(
				"icons/Brush.gif"));
		ImageIcon imageIcon11 = new ImageIcon(getClass().getResource(
				"icons/eraser.png"));

		JMenuItem menuItem6 = new JMenuItem(new1);
		menuItem6.setIcon(imageIcon1);
		JMenuItem menuItem2 = new JMenuItem(open);
		menuItem2.setIcon(imageIcon2);
		JMenuItem menuItem3 = new JMenuItem(save);
		menuItem3.setIcon(imageIcon3);
		JMenuItem menuItem4 = new JMenuItem(exit);
		menuItem4.setIcon(imageIcon4);

		JMenuItem menuItem5 = new JMenuItem(about);
		menuItem5.setIcon(imageIcon5);

		JMenuItem menuItem1 = new JMenuItem(clear);
		menuItem1.setIcon(imageIcon11);
		JMenuItem menuItem7 = new JMenuItem(colourChooser);
		menuItem7.setIcon(imageIcon72);

		JButton jButtonOpen = new JButton();
		jButtonOpen.setIcon(imageIcon2);
		// JButton jButtonSave = new JButton("Save in ./images");
		JButton jButtonSaveAS = new JButton();
		jButtonSaveAS.setIcon(imageIcon3);
		JButton jButtonSize = new JButton();
		jButtonSize.setIcon(imageIcon1);
		JButton jButtonClose = new JButton();
		jButtonClose.setIcon(imageIcon51);
		// JButton jButtonColor = new JButton();
		// jButtonColor.setIcon(imageIcon6);
		// final JLabel jLabel1 = new JLabel("Выберите цвет карандаша:");
		// final JLabel jLabel2 = new JLabel("or enter RGB code");
		final JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(100, (int) textField
				.getPreferredSize().getHeight()));
		JPanel standartbar = new JPanel();
		standartbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		standartbar.setMaximumSize(new Dimension(2000, 30));
		menuBar.setMaximumSize(new Dimension(2000, 10));
		// ��������� ����1
		menu1.add(menuItem6);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		menu1.add(menuItem4);
		// ��������� ����2
		menu2.add(menuItem5);
		// ��������� ����3
		menu3.add(menuItem7);
		menu3.add(menuItem1);
		// ��������� ��������
		menuBar.add(menu1);
		menuBar.add(menu3);
		menuBar.add(menu2);
		standartbar.add(jButtonSize);
		standartbar.add(jButtonOpen);
		// standartbar.add(jButtonSave);
		standartbar.add(jButtonSaveAS);
		// standartbar.add(jLabel2);
		// standartbar.add(textField);
		// standartbar.add(jButtonColor);
		// standartbar.add(jButtonClose);
		// scrollPane.add(gpanel);
		jFrame.add(menuBar);
		jFrame.add(standartbar);

		// Creating toolbar
		JPanel toolbar = new JPanel();
		toolbar.setPreferredSize(new Dimension(125, 100));
		JPanel mainArea = new JPanel(new BorderLayout());
		mainArea.add(scrollPane);
		mainArea.add(toolbar, BorderLayout.WEST);
		final JLabel jLabel121 = new JLabel("");
		jLabel121.setPreferredSize(new Dimension(100, 1));
		final JLabel jLabel = new JLabel(color);
		jlabel.setForeground(Color.white);
		jLabel.setPreferredSize(new Dimension(50, 30));
		jLabel.setBackground(Color.black);
		jLabel.setOpaque(!jLabel.isOpaque());
		final JLabel jLabel4 = new JLabel(fone);
		jLabel4.setPreferredSize(new Dimension(50, 30));
		jLabel4.setBackground(Color.white);
		jLabel4.setOpaque(!jLabel4.isOpaque());
		ImageIcon imageIcon10 = new ImageIcon(getClass().getResource(
				"icons/pencil.png"));
		ImageIcon lineI = new ImageIcon(getClass()
				.getResource("icons/line.png"));
		ImageIcon lineI2 = new ImageIcon(getClass().getResource(
				"icons/line2.png"));
		rubber.setIcon(imageIcon11);
		pencil.setIcon(imageIcon10);
		line.setIcon(lineI);
		line2.setIcon(lineI2);
		pencil.setEnabled(false);
		final JButton fil = new JButton("fil");
		toolbar.add(pencil);
		toolbar.add(rubber);
		toolbar.add(line);
		toolbar.add(line2);
		toolbar.add(fil);
		JButton jButton = new JButton();
		jButton.setPreferredSize(new Dimension(100, 8));

		// toolbar.add(jLabel1);
		toolbar.add(jLabel121);
		toolbar.add(jLabel);
		toolbar.add(jLabel4);
		toolbar.add(jButton);

		jFrame.add(mainArea);
		jFrame.setBackground(Color.black);
		// standartbar.setBackground(Color.LIGHT_GRAY);
		// toolbar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,
		// 5));
		// scrollPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,
		// 5));
		gpanel.setBackground(Color.GRAY);
		jButtonOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gpanel.open();
				gpanel.repaint();
			}
		});
		// jButtonSave.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// gpanel.save();
		// }
		// });
		jButtonSaveAS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gpanel.saveAs();
			}
		});
		jButtonClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				close(jFrame);
			}
		});
		jLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				final JColorChooser colorChooser = new JColorChooser(gpanel
						.getColor());
				final JDialog dialog = new JDialog();
				dialog.setLayout(new BoxLayout(dialog.getContentPane(),
						BoxLayout.Y_AXIS));

				dialog.setTitle(colourChooser);
				JPanel panel = new JPanel();
				dialog.add(colorChooser);
				JButton ok = new JButton(oK);
				JButton cancel = new JButton(canCel);
				ok.setIcon(imageIcon6);
				cancel.setIcon(imageIcon7);
				panel.add(ok);
				panel.add(cancel);
				dialog.add(panel);
				dialog.pack();
				dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
				dialog.setLocationRelativeTo(null);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						gpanel.setColor(colorChooser.getColor());
						jLabel.setBackground(colorChooser.getColor());
						dialog.setVisible(false);
					}
				});
				cancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dialog.setVisible(false);
					}
				});

				dialog.setVisible(true);
				super.mousePressed(arg0);
			}
		});
		jLabel4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				final JColorChooser colorChooser = new JColorChooser(gpanel
						.getColorR());
				final JDialog dialog = new JDialog();
				dialog.setLayout(new BoxLayout(dialog.getContentPane(),
						BoxLayout.Y_AXIS));

				dialog.setTitle(colourChooser);
				JPanel panel = new JPanel();
				dialog.add(colorChooser);
				JButton ok = new JButton(oK);
				JButton cancel = new JButton(canCel);
				ok.setIcon(imageIcon6);
				cancel.setIcon(imageIcon7);
				panel.add(ok);
				panel.add(cancel);
				dialog.add(panel);
				dialog.pack();
				dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
				dialog.setLocationRelativeTo(null);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						gpanel.setColorR(colorChooser.getColor());
						jLabel4.setBackground(colorChooser.getColor());
						dialog.setVisible(false);
					}
				});
				cancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dialog.setVisible(false);
					}
				});

				dialog.setVisible(true);
				super.mousePressed(arg0);
			}
		});

		jButtonSize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JDialog dialog = new JDialog();
				dialog.setLayout(new BoxLayout(dialog.getContentPane(),
						BoxLayout.Y_AXIS));
				dialog.setTitle(ch1);

				JPanel panel = new JPanel();
				JPanel panel1 = new JPanel();
				final JTextField x = new JTextField();
				x.setPreferredSize(new Dimension(50, (int) textField
						.getPreferredSize().getHeight()));
				final JTextField y = new JTextField();
				y.setPreferredSize(new Dimension(50, (int) textField
						.getPreferredSize().getHeight()));
				JButton ok = new JButton(oK);
				JButton cancel = new JButton(canCel);
				JLabel jl = new JLabel(width);
				JLabel jl1 = new JLabel(height);
				// Height
				// Width
				ok.setIcon(imageIcon6);
				cancel.setIcon(imageIcon7);
				panel1.add(jl);
				panel1.add(x);
				panel1.add(jl1);
				panel1.add(y);
				panel.add(ok);
				panel.add(cancel);
				dialog.add(panel1);
				dialog.add(panel);
				dialog.pack();
				dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
				dialog.setLocationRelativeTo(null);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						gpanel.setSizeX(Integer.parseInt(x.getText(), 10));
						gpanel.setSizeY(Integer.parseInt(y.getText(), 10));
						gpanel.repaint();
						gpanel.setPreferredSize(new Dimension(Integer.parseInt(
								x.getText(), 10), Integer.parseInt(y.getText(),
								10)));
						gpanel.revalidate();
						dialog.setVisible(false);
					}
				});
				cancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dialog.setVisible(false);
					}
				});
				dialog.setVisible(true);
			}
		});
		menuItem6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				final JDialog dialog = new JDialog();
				dialog.setLayout(new BoxLayout(dialog.getContentPane(),
						BoxLayout.Y_AXIS));
				dialog.setTitle(ch1);

				JPanel panel = new JPanel();
				JPanel panel1 = new JPanel();
				final JTextField x = new JTextField();
				x.setPreferredSize(new Dimension(50, (int) textField
						.getPreferredSize().getHeight()));
				final JTextField y = new JTextField();
				y.setPreferredSize(new Dimension(50, (int) textField
						.getPreferredSize().getHeight()));
				JButton ok = new JButton(oK);
				JButton cancel = new JButton(canCel);
				JLabel jl = new JLabel(width);
				JLabel jl1 = new JLabel(height);
				// Height
				// Width
				ok.setIcon(imageIcon6);
				cancel.setIcon(imageIcon7);
				panel1.add(jl);
				panel1.add(x);
				panel1.add(jl1);
				panel1.add(y);
				panel.add(ok);
				panel.add(cancel);
				dialog.add(panel1);
				dialog.add(panel);
				dialog.pack();
				dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
				dialog.setLocationRelativeTo(null);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						gpanel.setSizeX(Integer.parseInt(x.getText(), 10));
						gpanel.setSizeY(Integer.parseInt(y.getText(), 10));
						gpanel.repaint();
						gpanel.setPreferredSize(new Dimension(Integer.parseInt(
								x.getText(), 10), Integer.parseInt(y.getText(),
								10)));
						gpanel.revalidate();
						dialog.setVisible(false);
					}
				});
				cancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dialog.setVisible(false);
					}
				});
				dialog.setVisible(true);
			}
		});
		menuItem7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				final JColorChooser colorChooser = new JColorChooser(gpanel
						.getColor());
				final JDialog dialog = new JDialog();
				dialog.setLayout(new BoxLayout(dialog.getContentPane(),
						BoxLayout.Y_AXIS));

				dialog.setTitle(colourChooser);
				JPanel panel = new JPanel();
				dialog.add(colorChooser);
				JButton ok = new JButton(oK);
				JButton cancel = new JButton(canCel);
				ok.setIcon(imageIcon6);
				cancel.setIcon(imageIcon7);
				panel.add(ok);
				panel.add(cancel);
				dialog.add(panel);
				dialog.pack();
				dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
				dialog.setLocationRelativeTo(null);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						gpanel.setColor(colorChooser.getColor());
						jLabel.setBackground(colorChooser.getColor());
						dialog.setVisible(false);
					}
				});
				cancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dialog.setVisible(false);
					}
				});

				dialog.setVisible(true);
			}
		});
		// jButtonColor.addActionListener(new ActionListener() {

		// @Override
		// public void actionPerformed(ActionEvent arg0) {
		// gpanel.setColor(new Color(Integer.parseInt(textField.getText(),
		// 16)));
		// jLabel.setBackground(new Color(Integer.parseInt(textField.getText(),
		// 16)));
		// }
		// });
		menuItem1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gpanel.reFresh();
				gpanel.repaint();
			}
		});
		menuItem2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gpanel.open();
				gpanel.repaint();
			}
		});
		menuItem3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gpanel.saveAs();
			}
		});
		menuItem4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				close(jFrame);
			}
		});
		menuItem5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				final JDialog dialog = new JDialog();
				dialog.setLayout(new BoxLayout(dialog.getContentPane(),
						BoxLayout.Y_AXIS));
				dialog.setTitle(about);

				JPanel panel = new JPanel(new BorderLayout());
				JPanel panel2 = new JPanel();
				JPanel panel1 = new JPanel();
				JLabel lab = new JLabel(aboutText);
				JLabel lab1 = new JLabel();
				ImageIcon imageIcon12 = new ImageIcon(getClass().getResource(
						"icons/logo4.png"));
				lab1.setIcon(imageIcon12);
				panel1.add(lab);
				panel1.add(lab1);
				JButton cancel = new JButton(canCel);
				cancel.setIcon(imageIcon7);
				JButton openSite = new JButton(site);
				openSite.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// setCursor(Cursor.getPredefinedCursor(12));
						try {
							Util.openLink(new URL("http://FreeSimpleSoft.RU/")
									.toURI());
						} catch (MalformedURLException e1) {
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							e1.printStackTrace();
						}
					}
				});
				JButton supportm = new JButton(supm);
				supportm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Util.openLink(new URL(
									"mailto:support@freesimplesoft.ru").toURI());
						} catch (MalformedURLException e1) {
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							e1.printStackTrace();
						}
					}
				});
				JButton supportf = new JButton(supf);
				supportf.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Util.openLink(new URL(
									"http://FreeSimpleSoft.RU/forum/").toURI());
						} catch (MalformedURLException e1) {
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							e1.printStackTrace();
						}
					}
				});

				panel.add(panel2, BorderLayout.WEST);
				panel2.add(openSite);
				panel2.add(supportf);
				panel2.add(supportm);
				panel.add(cancel, BorderLayout.EAST);
				dialog.add(panel1);
				dialog.add(panel);
				dialog.pack();
				dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
				dialog.setLocationRelativeTo(null);

				cancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dialog.setVisible(false);
					}
				});
				dialog.setVisible(true);
				/*
				 * try { Desktop.getDesktop().edit(new File("info/info.txt")); }
				 * catch (IOException e) { e.printStackTrace(); }
				 */
			}
		});
		pencil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pencil.setEnabled(false);
				rubber.setEnabled(true);
				line.setEnabled(true);
				line2.setEnabled(true);
				fil.setEnabled(true);
				gpanel.setTool(0);
			}
		});
		rubber.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				rubber.setEnabled(false);
				pencil.setEnabled(true);
				line.setEnabled(true);
				line2.setEnabled(true);
				fil.setEnabled(true);
				gpanel.setTool(1);
			}
		});
		line.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				line.setEnabled(false);
				line2.setEnabled(true);
				pencil.setEnabled(true);
				rubber.setEnabled(true);
				fil.setEnabled(true);
				gpanel.setTool(2);
			}
		});
		line2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				line2.setEnabled(false);
				line.setEnabled(true);
				pencil.setEnabled(true);
				rubber.setEnabled(true);
				fil.setEnabled(true);
				gpanel.setTool(3);
			}
		});
		fil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				line2.setEnabled(true);
				line.setEnabled(true);
				pencil.setEnabled(true);
				rubber.setEnabled(true);
				fil.setEnabled(false);
				gpanel.setTool(4);
			}
		});
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				final JDialog dialog = new JDialog();
				dialog.setLayout(new BoxLayout(dialog.getContentPane(),
						BoxLayout.Y_AXIS));
				dialog.setTitle(ch2);
				JPanel panel = new JPanel(new BorderLayout());
				JPanel panel1 = new JPanel();
				JButton pencil = new JButton(ps);
				// panel1.add(pencil);
				JButton rubber = new JButton(es);
				JButton line = new JButton(ls);
				panel1.add(rubber);
				panel1.add(line);
				JButton close = new JButton(canCel);
				close.setIcon(imageIcon7);
				panel.add(close, BorderLayout.EAST);
				dialog.add(panel1);
				dialog.add(panel);
				dialog.pack();
				dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
				dialog.setLocationRelativeTo(null);
				pencil.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {

						final JDialog dialog = new JDialog();
						dialog.setLayout(new BoxLayout(dialog.getContentPane(),
								BoxLayout.Y_AXIS));
						dialog.setTitle(ps);

						JPanel panel = new JPanel(new BorderLayout());
						JPanel panel1 = new JPanel();
						JLabel lab = new JLabel(ips);
						panel1.add(lab);
						final JTextField size = new JTextField();
						size.setPreferredSize(new Dimension(50, (int) textField
								.getPreferredSize().getHeight()));
						panel1.add(size);
						JButton pencil = new JButton(oK);
						panel1.add(pencil);
						JButton cancel = new JButton(canCel);
						cancel.setIcon(imageIcon7);
						panel.add(cancel, BorderLayout.EAST);
						dialog.add(panel1);
						dialog.add(panel);
						dialog.pack();
						dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
						dialog.setLocationRelativeTo(null);
						pencil.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								gpanel.SP(Integer.parseInt(size.getText(), 10));
								dialog.setVisible(false);
							}
						});
						cancel.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								dialog.setVisible(false);
							}
						});
						dialog.setVisible(true);
					}
				});
				line.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {

						final JDialog dialog = new JDialog();
						dialog.setLayout(new BoxLayout(dialog.getContentPane(),
								BoxLayout.Y_AXIS));
						dialog.setTitle(ls);

						JPanel panel = new JPanel(new BorderLayout());
						JPanel panel1 = new JPanel();
						JLabel lab = new JLabel(ils);
						panel1.add(lab);
						final JTextField size = new JTextField();
						size.setPreferredSize(new Dimension(50, (int) textField
								.getPreferredSize().getHeight()));
						panel1.add(size);
						JButton pencil = new JButton(oK);
						panel1.add(pencil);
						JButton cancel = new JButton(canCel);
						cancel.setIcon(imageIcon7);
						panel.add(cancel, BorderLayout.EAST);
						dialog.add(panel1);
						dialog.add(panel);
						dialog.pack();
						dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
						dialog.setLocationRelativeTo(null);
						pencil.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								gpanel.SL(Integer.parseInt(size.getText(), 10));
								dialog.setVisible(false);
							}
						});
						cancel.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								dialog.setVisible(false);
							}
						});
						dialog.setVisible(true);
					}
				});
				rubber.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {

						final JDialog dialog = new JDialog();
						dialog.setLayout(new BoxLayout(dialog.getContentPane(),
								BoxLayout.Y_AXIS));
						dialog.setTitle(es);

						JPanel panel = new JPanel(new BorderLayout());
						JPanel panel1 = new JPanel();
						JLabel lab = new JLabel(ies);
						panel1.add(lab);
						final JTextField size = new JTextField();
						size.setPreferredSize(new Dimension(50, (int) textField
								.getPreferredSize().getHeight()));
						panel1.add(size);
						JButton pencil = new JButton(oK);
						panel1.add(pencil);
						JButton cancel = new JButton(canCel);
						cancel.setIcon(imageIcon7);
						panel.add(cancel, BorderLayout.EAST);
						dialog.add(panel1);
						dialog.add(panel);
						dialog.pack();
						dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
						dialog.setLocationRelativeTo(null);
						pencil.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								gpanel.SR(Integer.parseInt(size.getText(), 10));
								dialog.setVisible(false);
							}
						});
						cancel.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								dialog.setVisible(false);
							}
						});
						dialog.setVisible(true);
					}
				});
				close.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dialog.setVisible(false);
					}
				});
				dialog.setVisible(true);
			}
		});
		// jFrame.setResizable(false);
		Util.out("Interface loaded: closing splash and showing main window");
		jFrame.setVisible(true);
		dialog.setVisible(false);
	}

	public static void close(JFrame frame) {
		Util.out("Closing from menu");
		if (Constants.debug)System.out.println("======================================");
		frame.dispose();
		System.exit(0);
	}

	static void setTitle(String title) {
		jFrame.setTitle(title);
	}

	static void open(int x, int y) {

		gpanel.setSizeX(x);
		gpanel.setSizeY(y);
		gpanel.repaint();
		gpanel.setPreferredSize(new Dimension(x, y));
		gpanel.revalidate();

	}

	void Translations() {
		if (lang == "Eng") {
			file = "File";
			help = "Help";
			image = "Image";

			new1 = "New";
			open = "Open";
			save = "Save";
			exit = "Exit";

			about = "About GraphicEditor " + Constants.ver + "";

			clear = "Clear";
			colourChooser = "ColorChooser";

			color = "Color";
			fone = "Fone";

			oK = "OK";
			canCel = "Cancel";

			width = "Width:";
			height = "Height:";

			ch1 = "Coosing size of new image";
			ch2 = "Choosing tools size";

			aboutText = "<html>About GrpaphicEditor " + Constants.ver + " Program<br>Availible only for russian language.<br><p align=\"right\">&copy;FreeSimpleSoft Team, 2010-2013</p><html>";
			// TODO

			ps = "Pencil size";
			es = "Eraser size";
			ls = "Line size";

			ips = "Input pencil size (in pixels):";
			ies = "Input eraser size (in pixels):";
			ils = "Input line size (in pixels):";
			site = "Our site";
			supm = "Support e-mail";
			supf = "Support forum";
		} else if (lang == "Rus") {
			file = "Файл";
			help = "Помощь";
			image = "Изображение";

			new1 = "Создать";
			open = "Открыть";
			save = "Сохранить";
			exit = "Выход";

			about = "О программе";

			clear = "Очистить";
			colourChooser = "Палитра";

			color = "Осн. цвет";
			fone = "Фон";

			oK = "OK";
			canCel = "Отмена";

			width = "Ширина:";
			height = "Высота:";

			ch1 = "Выбор размера нового изображения";
			ch2 = "Выбор размера инструментов";

			aboutText = "<html><h1>О программе GrpaphicEditor " + Constants.ver + "</h1><br>"
					+ "<br>&nbsp;Сборка программы GrpaphicEditor " + Constants.ver + " была собрана 22 ноября 2013 года."
					+ "<br>&nbsp;Отличительной чертой этой версии программы является впервые <br>"
					+ " добавленная мультиязычность и добавленная заливка (кнопка \"fil\") которая,<br> активирует инструмент заливки. В финальной версии будет дорабоан алгоритм заливки<br><br> <p align=\"right\">&copy;FreeSimpleSoft Team, 2010-2013</p><html>";
			

			ps = "Размер карандаша";
			es = "Размер резинки";
			ls = "Толщина линии";

			ips = "Введите размер карандаша (в пикселях):";
			ies = "Введите размер ластика (в пикселях):";
			ils = "Введите толщину линии (в пикселях):";
			site = "Наш сайт";
			supm = "E-mail поддержки";
			supf = "Форум поддержки";
		}
	}
}
