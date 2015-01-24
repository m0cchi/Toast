package test;

import javax.swing.JLabel;

import frame.WindowEnvironment;
import frame.lib.DefaultMouseListener;

public class ToastFrame {

    public static void main(String[] args) {
        int i = 0;
        String[] face = {"J(>_<)l","J(^-^)l", "J(^o^)l", "J(^o^)/"}; 
        String[] mes = {"WakeUp!","WakeUp!!","WakeUp!!!"};
        frame.ToastFrame frame = new frame.ToastFrame(WindowEnvironment.RIGHT,WindowEnvironment.TOP);
        frame.setMouseListener(new DefaultMouseListener());
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
            textJLabel.setText(mes[Math.abs(i%mes.length)]);
            iconJLabel.setText(face[Math.abs(i++%face.length)]);
        }
    }

}
