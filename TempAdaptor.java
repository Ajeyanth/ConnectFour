import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TempAdaptor extends KeyAdapter {
	
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();
		System.out.println("Up pressed in frame");

	}

}
