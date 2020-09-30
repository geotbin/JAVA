package exercice_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class timerExe implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(java.util.Calendar.getInstance().getTime());
	}
	
	
	
	public static void main(String[] args) {
		
		ActionListener listener = new timerExe();
		Timer timer = new Timer(1, listener);
		timer.start();
		while(true);
	}

}
