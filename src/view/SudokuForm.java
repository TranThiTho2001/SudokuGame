package view;

import Component.PanelControl;
import Component.PanelSudoku;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import main.SudokuGame;

public class SudokuForm extends JFrame {

    public SudokuForm(int level, boolean newgame) {
        this.setTitle("SudokuGame");
        BufferedImage myPicture;
        JLabel picLabel = new JLabel();
        try {
            myPicture = ImageIO.read( getClass().getResource("/image/MainBackground1.png"));
            picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setLayout(new FlowLayout(FlowLayout.LEFT));
            add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(SudokuForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        SudokuGame game;
        if (newgame == true) {
            game = new SudokuGame(level);
        } else {
            game = new SudokuGame();
        }

        // Tao panelsudoku
        PanelSudoku panelsudoku = new PanelSudoku(game);
        panelsudoku.createNewGame(game);// Hien thi trang thai ban dau cua game
        picLabel.add(panelsudoku, BorderLayout.CENTER);
        // Tao buttonControl de dieu khien game cac button new, exit va cac so tu 1->9
        PanelControl buttonControl = new PanelControl(game, panelsudoku);
        picLabel.add(buttonControl, BorderLayout.EAST);   //Them buttoncontrol vao trong frame

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        // su kien khi click chon Menu tren panelControl
        buttonControl.getMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (!panelsudoku.getMatrix(i,j).getBackground().equals(new Color(72, 161, 188)) && game.getNumberXY(i, j) != 0) {
                            game.setNumberGame(i, j, game.getNumberXY(i, j) * 10);
                        }
                    }
                }
                game.writeFile(buttonControl.getCount());
                MenuFrom menuFrom = new MenuFrom();
                menuFrom.setVisible(true);
                setVisible(false);
            }
        });
        // Su kien khi click chon New Game tren panelControl
        buttonControl.getButtonNew().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseLevelForm levelForm = new ChooseLevelForm();
                levelForm.setVisible(true);
                setVisible(false);
            }
        });
    }

//    public static void main(String[] args) {
//        new SudokuForm(1, true);
//    }
}
