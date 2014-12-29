package frame.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

import frame.WindowEnvironment;

public class MainPanel extends JPanel {
    private static final long serialVersionUID = -8808640154833962463L;
    private Color borderColor;
    private Color innerColor;
    private int borderWidth;
    public MainPanel(){
        super();
        this.borderColor = getBackground();
        this.innerColor = this.borderColor;
    }
    
    public MainPanel(Color borderColor,Color innerColor){
        this();
        this.borderColor = borderColor;
        this.innerColor = innerColor;
    }
    
    public MainPanel(Color boderColor, Color innerColor,int borderWidth){
        this(boderColor, innerColor);
        this.borderWidth = borderWidth;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);

        BasicStroke wideStroke = new BasicStroke(4.0f);
        g2.setStroke(wideStroke);
        g2.setPaint(this.borderColor);

        g2.fill(new RoundRectangle2D.Double(0, 0, WindowEnvironment.WIDTH, WindowEnvironment.HEIGHT, 30.0d, 30.0d));
        g2.setPaint(this.innerColor);
        g2.fill(new RoundRectangle2D.Double(this.borderWidth, this.borderWidth, WindowEnvironment.WIDTH - this.borderWidth * 2, WindowEnvironment.HEIGHT - this.borderWidth * 2, 30.0d, 30.0d));


      }
}
