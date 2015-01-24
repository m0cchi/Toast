package frame.lib;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import frame.ToastFrame;

public class DefaultMouseListener implements MouseListener{
    
    @Override
    public void mouseClicked(MouseEvent e) {
        ToastFrame frame = (ToastFrame) e.getComponent();
        frame.dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
