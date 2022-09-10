import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MazeFrame extends JFrame {

	MazeFrame() {
		
		this.add(new MazePanel());
		this.setBackground(Color.gray);
		this.setResizable(false);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
