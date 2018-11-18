package RythemGame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RythemGame extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage= new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage= new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage= new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage= new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage= new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage= new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage= new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage= new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));


	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();

	private JLabel menuBar =new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton= new JButton(exitButtonBasicImage);
	private JButton startButton= new JButton(startButtonBasicImage);
	private JButton quitButton= new JButton(quitButtonBasicImage);
	private JButton leftButton= new JButton(leftButtonBasicImage);
	private JButton rightButton= new JButton(rightButtonBasicImage);

	private int mouseX , mouseY;

	private boolean isMainScreen =false;

	ArrayList<Track> trackList= new ArrayList<Track>();

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private int nowselected = 0;


	public RythemGame() {
		setUndecorated(true);
		setTitle("Rhythem_Game");
		setSize(Main.SCREEN_WIDTH,Main.SCREEn_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		setVisible(true);
		setBackground(new Color(0,0,0,0));
		setLayout(null);

		Music introMusic =new Music("intromusic.mp3",true);
		introMusic.start();

		trackList.add(new Track("폴킴 Title Image.png", "폴킴 Start Image.png",
				"폴킴 Game Image.png", "폴킴 Selected.mp3", "폴킴-모든날 모든순간.mp3"));
		trackList.add(new Track("아이콘 Title Image.png", "아이콘 Start Image.png",
				"아이콘 Game Image.png", "사랑을 했다 Selected.mp3", "아이콘-사랑을 했다.mp3"));


		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);	
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnterdMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnterdMusic = new Music("buttonPressedMusic.mp3",false);
				try {
					Thread.sleep(1000);

				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);

		//시작버튼
		startButton.setBounds(40, 430, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);	
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnterdMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnterdMusic = new Music("buttonPressedMusic.mp3",false);
				buttonEnterdMusic.start();
				introMusic.close();

				selectTrack(0);

				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background=new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				isMainScreen=true;
			}
		});
		add(startButton);
		
		//종료버튼
		quitButton.setBounds(40, 550, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);	
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnterdMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnterdMusic = new Music("buttonPressedMusic.mp3",false);
				try {
					Thread.sleep(1000);

				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		//왼쪽이동버튼
		leftButton.setVisible(false);
		leftButton.setBounds(140, 330, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);	
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnterdMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnterdMusic = new Music("buttonPressedMusic.mp3",false);
				selectLeft();
			}
		});
		add(leftButton);
		
		//오른쪽이동버튼
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 330, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);	
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnterdMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnterdMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnterdMusic = new Music("buttonPressedMusic.mp3",false);
				selectRight();
			}
		});
		add(rightButton);

		menuBar.setBounds(0,0,1280,30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX= e.getX();
				mouseY= e.getY();
			}
		});

		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x= e.getXOnScreen();
				int y= e.getYOnScreen();
				setLocation(x-mouseX,y-mouseY);
			}
		});
		add(menuBar); 


	}
	public void paint (Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEn_HEIGHT);
		screenGraphic =screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);


	}
	
	public void screenDraw(Graphics g) {
		
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(selectedImage,340,100,null);
			g.drawImage(titleImage,340,570 , null);
		}
		paintComponents(g);
		this.repaint();
	}
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
	
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	

	public void selectLeft() {
		if(nowselected==0)
			nowselected = trackList.size()-1;	
		else 
			nowselected--;
		selectTrack(nowselected);
	}
	public void selectRight() {
		if(nowselected==trackList.size()-1)
			nowselected = 0;	
		else 
			nowselected++;
		selectTrack(nowselected);
	}
}

