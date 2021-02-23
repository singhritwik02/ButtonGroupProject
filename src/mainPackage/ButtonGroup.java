package mainPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonGroup extends Frame {
    Label label = new Label();

    public ButtonGroup(String title, int width, int height) {

        this.setSize(width, height);
        this.setTitle(title);

        this.add(label);

        this.setLayout(null);
    }

    public void addLabel(int x,int y) {
        label.setBounds(50,y,500,50);
        label.setText("We dont know to read and write language : ");
        label.setForeground(Color.BLACK);
    }

    public void addButton(String title, int x, int y) {

        System.out.println("Adding button named " + title);
        Button button = new Button(title);
        button.setForeground(Color.BLACK);
        button.setBounds(x, y, 200, 20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLabel(button.getLabel());
            }
        });
        this.add(button);


    }

    public void setLabel(String languageName) {
        label.setText("We dont know to read and write language : " + languageName);
    }

}

class ButtonClass {
    public static void main(String args[]) {
        ButtonGroup group = new ButtonGroup("Language", 500, 500);
        group.setVisible(true);
        String[] titles = {"Hindi", "English", "french","German"};
        int x = 0;
        int y = 0;
        for (String title :
                titles) {
            group.addButton(title, 50, y + 50);

            y += 50;

        }
        group.addLabel(50,y+50);
        group.addWindowListener(
                new WindowAdapter() {

                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
    }
}
