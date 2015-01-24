package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frame.WindowEnvironment.Location;
import frame.component.MainPanel;

public class ToastFrame extends JFrame implements MouseListener{
    private static final long serialVersionUID = 8836021697094316864L;
    private int borderWidth = 5;
    private Color borderColor = new Color(0,0,0);
    private Color innerColor = new Color(255,255,255);
    private JPanel mainPanel;
    private JLabel icon;
    private JLabel text;
    private MouseListener mouseListener;
    private int x,y;
    private ToastFrame() {
        super();
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
        invisible(this);
        mainPanel = new MainPanel(this.borderColor,this.innerColor,this.borderWidth);
        mainPanel.setLayout(null);
        super.add(mainPanel);
    }

    public ToastFrame(int x, int y) {
        this();
        this.x = x;
        this.y = y;
        updateLocation();
    }

    public ToastFrame(Location.X x, Location.Y y) {
        this(x.get(), y.get());
    }
    
    public ToastFrame(Location.X x, Location.Y y,MouseListener listener) {
        this(x.get(), y.get());
        this.mouseListener = listener;
    }

    private void invisible(Component c) {
        c.setBackground(new Color(0,0,0,0));
    }

    public void setIcon(JLabel label){
        int h = WindowEnvironment.HEIGHT - this.borderWidth*2;
        label.setBounds(this.borderWidth , this.borderWidth, h, h);
        icon = label;
    }

    public void setText(JLabel label){
        int w = WindowEnvironment.WIDTH - this.borderWidth*2;
        int h = WindowEnvironment.HEIGHT - this.borderWidth*2;
        label.setBounds(this.borderWidth + h , this.borderWidth, w - h, h);
        text = label;
    }
    
    public void setText(String text){
        JLabel label = new JLabel("<html>"+text.replaceAll("\n", "<br/>")+"</html>");
        int w = WindowEnvironment.WIDTH - this.borderWidth*2;
        int h = WindowEnvironment.HEIGHT - this.borderWidth*2;
        label.setBounds(this.borderWidth + h , this.borderWidth, w - h, h);
        this.text = label;
    }
    
    public void reshow(){
        mainPanel.removeAll();
        if(icon!=null)
            mainPanel.add(icon);
        if(text!=null)
            mainPanel.add(text);
        repaint();
    }
    
    public void updateLocation(){
        this.setBounds(this.x, this.y, WindowEnvironment.WIDTH, WindowEnvironment.HEIGHT);
    }
    
    public void setX(Location.X x){
        this.x = x.get();
        updateLocation();
    }
    
    public void setY(Location.Y y){
        this.y = y.get();
        updateLocation();
    }
    
    public void setXY(Location.X x,Location.Y y){
        this.x = x.get();
        this.y = y.get();
        updateLocation();
    }
    
    public void setMouseListener(MouseListener listener){
        this.mouseListener = listener;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(mouseListener != null)
            mouseListener.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(mouseListener != null)
            mouseListener.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(mouseListener != null)
            mouseListener.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(mouseListener != null)
            mouseListener.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(mouseListener != null)
            mouseListener.mouseExited(e);
    }
    
}
