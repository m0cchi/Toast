package test;

import javax.swing.JLabel;

import frame.WindowEnvironment;

public class ToastFrame {

    public static void main(String[] args) {
        int i = 0;
        String[] face = {"J(>_<)l","J(^-^)l"}; 
        frame.ToastFrame frame = new frame.ToastFrame(WindowEnvironment.RIGHT,WindowEnvironment.TOP);
        JLabel iconJLabel = new JLabel("J(^-^)l");
        frame.setText("WakeUp!!!");
        frame.setIcon(iconJLabel);
        frame.reshow();
        frame.setVisible(true);
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            iconJLabel.setText(face[Math.abs(i++%face.length)]);
        }
    }

}
