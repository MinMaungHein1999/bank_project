package view.card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardUpdateWindow extends JFrame {
    private JButton updateBtn;
    private JButton cancelBtn;

    public CardUpdateWindow(){
        initializeComponents();
        addComponentsToUI();
    }
    private void initializeComponents() {
        this.setLayout(new FlowLayout());
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.updateBtn = new JButton("Update");
        this.cancelBtn = new JButton("Cancel");
        addUpdateButtonAction();
        addCancelButtonAction();
    }

    private void addComponentsToUI() {
        this.add(updateBtn);
        this.add(cancelBtn);

        this.setVisible(true);
    }

    private void addUpdateButtonAction() {
        this.updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void addCancelButtonAction() {
        this.cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
    }
    private void closeWindow() {
        this.dispose();
    }
}
