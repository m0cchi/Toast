package test;

import java.awt.Color;

import javax.swing.JLabel;

import frame.WindowEnvironment;
import frame.lib.DefaultMouseListener;

public class MainPanel {

    public static void main(String[] args) {
        int i = 0;
        String[] face = { "J(^o^)/" };
        String[] mes = { "WakeUp!!!" };
        Color[] borderColors = {Color.BLACK,Color.RED,Color.BLUE,Color.GREEN};
        frame.ToastFrame frame = new frame.ToastFrame(WindowEnvironment.RIGHT,
                WindowEnvironment.BOTTOM);
        frame.setMouseListener(new DefaultMouseListener());
        frame.component.MainPanel panel = frame.getMainPanel();
        JLabel iconJLabel = new JLabel(face[face.length - 1]);
        JLabel textJLabel = new JLabel(mes[mes.length - 1]);
        frame.setText(textJLabel);
        frame.setIcon(iconJLabel);
        frame.reshow();
        frame.setVisible(true);
        while (frame.isVisible()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            panel.setBorderColor(borderColors[i++%borderColors.length]);
            panel.repaint();
           
        }
    }

}
