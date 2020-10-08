package SwingPaint;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PaintSWG {
 
    JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn;
    DrawBox drawBox;
    
    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                drawBox.clearCanvas();
            } else if (e.getSource() == blackBtn) {
                drawBox.black();
            } else if (e.getSource() == blueBtn) {
                drawBox.blue();
            } else if (e.getSource() == greenBtn) {
                drawBox.green();
            } else if (e.getSource() == redBtn) {
                drawBox.red();
            } else if (e.getSource() == magentaBtn) {
                drawBox.magenta();
            }
        }
    };
 
 
    public static void main(String[] args) {
        new PaintSWG().show();
    }
 
 
    public void show() {
        // create main frame
        JFrame frame = new JFrame("Swing Paint");
        Container content = frame.getContentPane();
        // set layout on content pane
        content.setLayout(new BorderLayout());
        // create draw area
        drawBox = new DrawBox();

        // add to content pane
        content.add(drawBox, BorderLayout.CENTER);

        // create controls to apply colors and call clear feature
        JPanel controls = new JPanel();

        clearBtn = new JButton("Clear Button");
        clearBtn.addActionListener(actionListener);
        blackBtn = new JButton("Black");
        blackBtn.addActionListener(actionListener);
        blueBtn = new JButton("Blue");
        blueBtn.addActionListener(actionListener);
        greenBtn = new JButton("Green");
        greenBtn.addActionListener(actionListener);
        redBtn = new JButton("Red");
        redBtn.addActionListener(actionListener);
        magentaBtn = new JButton("Magenta");
        magentaBtn.addActionListener(actionListener);

        // add to panel
        controls.add(greenBtn);
        controls.add(blueBtn);
        controls.add(blackBtn);
        controls.add(redBtn);
        controls.add(magentaBtn);
        controls.add(clearBtn);

        // add to content pane
        content.add(controls, BorderLayout.NORTH);

        frame.setSize(600, 600);
        // can close frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // show the swing paint result
        frame.setVisible(true);
    }
    
}
