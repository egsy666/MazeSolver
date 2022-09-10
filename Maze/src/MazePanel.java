import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MazePanel extends JPanel implements ActionListener {

	static final int GAME_WIDTH = 500;
	static final int GAME_HEIGHT = 500;
	static final int gridSize = 50;
	final int DELAY = 100;
	Image image;
	Graphics graphic;
	Timer timer;
	boolean running;
	int x = 1;
	int y = 0;
	
	int [] [] board = { 
			{1,0,1,1,1,1,1,1,1,1},
			{1,0,1,0,1,0,0,0,0,1},
			{1,0,0,0,0,0,1,1,1,1},
			{1,0,1,1,1,1,1,1,1,1},
			{1,0,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,1,4,1},
			{1,1,1,1,1,1,0,0,0,1},
			{1,0,0,0,0,0,0,1,0,1},
			{1,1,1,1,1,1,1,1,1,1}
	};
			
	
	
	MazePanel() {
		this.setPreferredSize(new Dimension(GAME_HEIGHT,GAME_WIDTH));
		this.setFocusable(true);
		running = true;
		this.addKeyListener(new AL());
		timer = new Timer(DELAY,this);
		timer.start();
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for(int y=0; y<board.length; y++) {
			for(int x = 0; x<board[0].length;x++) {
				switch(board[y][x]) {
				case 1: g.setColor(Color.BLACK); break;
				case 4: g.setColor(Color.RED); break;
				case 2: g.setColor(Color.GREEN); break;
				default: g.setColor(Color.WHITE);
				}
				
				g.fillRect(x*gridSize, y*gridSize, gridSize, gridSize);
				
			}
		}
	}
	
	boolean solve() {
				
				
						for(int i = 0; i<4; i++) { // 0 = r, 1 = u, 2 = l, 3 = o
							if(i == 0) {
								x++;
								if(board[y][x] == 4) {
									return  true;
								}
								if(board[y][x] == 0) {
										board[y][x] = 2;
										if(solve()) {
											return true;
										} 
											board[y][x] = 0;	
										
											
										
									} x--;
								}
							
							if(i == 1) {
								y++;
								if(board[y][x] == 4) {
									return  true;
								}
							if(board[y][x] == 0) {
										board[y][x] = 2;
										if(solve()) {
											return true;
										} 
											board[y][x] = 0;	
										
											
										
									} y--;
								}
								
							
							if(i == 2) {
								x--;
								if(board[y][x] == 4) {
									return  true;
								}
							if(board[y][x] == 0) {
										board[y][x] = 2;
										if(solve()) {
											return true;
										}  
											board[y][x] = 0;	
										
										
									} x++;
								}
								
							
							
							if(i == 3) {
								y--;
								if(board[y][x] == 4) {
									return  true;
								}
							if(board[y][x] == 0) {
										board[y][x] = 2;
										if(solve()) {
											return true;
										}  
											board[y][x] = 0;	
										
									} y++;
								}
								
							} return false;
							
					}
						
				
	
	public void move() {
		for(int y = 0; y<board.length; y++) {
			for(int x = 0; x<board[0].length;x++) {
				if(x<board[0].length-1) {
					System.out.print(board[y][x]);
				} else {
					System.out.print(board[y][x]);
					System.out.println();
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_S) {
				solve();
				repaint();
			}
		}
	}
	
}
