package Component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import main.SudokuGame;

public class PanelControl extends JPanel {

    Timer timer;
    int count = 0;
    JButton buttonNew;
    JButton buttonExit;
    JButton buttonAuto;
    ButtonGroup buttonGroupNumber;
    JToggleButton buttonNumber[];
    JPanel panelLevel;
    JButton buttonlevel1, buttonlevel2, buttonlevel3;
    JLabel labelTime;
    JButton buttonMenu;
    int back = 0;
    int stop = 0;

    public PanelControl(SudokuGame sudokuGame, PanelSudoku panelSudoku) {

        ///Tao panel chua cac so va cac button controler
        //panel1 chua cac thanh phan cua khung dieu khien tro choi
        setBackground(new Color(145, 219, 242));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBackground(new Color(145, 219, 242));
        add(panel1, BorderLayout.CENTER);
        count = sudokuGame.getOldTime();
        ActionListener actionTime = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (stop == 0) {
                    labelTime.setText(timeFormat(count));
                    count++;
                }
            }
        };
        timer = new Timer(1000, actionTime);
        timer.start();
        //---------------------------------lable chua thoi gian-------------------------------
        labelTime = new JLabel();
        labelTime.setText(timeFormat(count));
        labelTime.setFont(new Font("Helvetica", Font.PLAIN, 14));
        JPanel panelTime = new JPanel();
        panelTime.add(labelTime);
        panel1.add(panelTime);
        JLabel lableInsert = new JLabel(" ");
        lableInsert.setSize(50, 50);
        panel1.add(lableInsert);
        //----------------------------------Panel chua cac so tu 1->9-------------------------
        JPanel panelNumber = new JPanel();
        panel1.add(panelNumber);
        panelNumber.setBackground(new Color(145, 219, 242));
        panelNumber.setLayout(new BoxLayout(panelNumber, BoxLayout.PAGE_AXIS));
        panelNumber.setBorder(BorderFactory.createLineBorder(Color.black));
        /////Hang 1 tu 1->3
        JPanel panelNumber1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNumber.add(panelNumber1);
        panelNumber1.setBackground(new Color(145, 219, 242));
        //Hang 2 tu 4->6
        JPanel panelNumber2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNumber.add(panelNumber2);
        panelNumber2.setBackground(new Color(145, 219, 242));
        //Hang 3 tu 7 -> 9
        JPanel panelNumber3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNumber.add(panelNumber3);
        panelNumber3.setBackground(new Color(145, 219, 242));
        buttonGroupNumber = new ButtonGroup();
        buttonNumber = new JToggleButton[9];
        for (int i = 0; i < 9; i++) {
            buttonNumber[i] = new JToggleButton();
            buttonNumber[i].setPreferredSize(new Dimension(70, 70));
            buttonNumber[i].setText(String.valueOf(i + 1));
            buttonNumber[i].setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
            buttonGroupNumber.add(buttonNumber[i]);
            buttonNumber[i].setBackground(new Color(72, 161, 188));
            if (i < 3) {
                panelNumber1.add(buttonNumber[i]);
            } else if (i < 6) {
                panelNumber2.add(buttonNumber[i]);
            } else {
                panelNumber3.add(buttonNumber[i]);
            }
            buttonNumber[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (panelSudoku.actions == 1) {
                        if (!panelSudoku.matrix[sudokuGame.CoordinateX][sudokuGame.CoordinateY].getBackground().equals(new Color(72, 161, 188))) { // Neu khong phai o so duoc danh so san thi duoc phep dien so
                            int tmp[][] = sudokuGame.getstateGame();
                            sudokuGame.setNumber(Integer.valueOf(e.getActionCommand()));
                            // Kiem tra neu so duoc chon dien vao vi tri x,y của ma tran khong hop le thi to do o 
                            if (sudokuGame.checkSelectNumber(tmp, sudokuGame.CoordinateX, sudokuGame.CoordinateY, Integer.valueOf(e.getActionCommand())) == false) {
                                panelSudoku.matrix[sudokuGame.CoordinateX][sudokuGame.CoordinateY].setBackground(Color.red);
                                panelSudoku.matrix[sudokuGame.CoordinateX][sudokuGame.CoordinateY].setnumber(String.valueOf(sudokuGame.getSelectNumber()));
                                if (sudokuGame.getNumberXY(sudokuGame.CoordinateX, sudokuGame.CoordinateY) != 0) {
                                    sudokuGame.setNumberGame(sudokuGame.CoordinateX, sudokuGame.CoordinateY, 0);
                                }
                            } else { // So dien vao vi tri x,y hop le thi dien vao o
                                panelSudoku.matrix[sudokuGame.CoordinateX][sudokuGame.CoordinateY].setBackground(new Color(145, 219, 242)); // to lai mau tranh truong hop truoc do o vuong bi to màu do.
                                sudokuGame.setNumberGame(sudokuGame.CoordinateX, sudokuGame.CoordinateY, sudokuGame.getSelectNumber());
                               
                                panelSudoku.matrix[sudokuGame.CoordinateX][sudokuGame.CoordinateY].setnumber(String.valueOf(sudokuGame.getSelectNumber()));
                            }
                            // Kiem tra o nao da to do nhung nhung so hop le thi to lai mau.
                            for (int i = 0; i < 9; i++) {
                                for (int j = 0; j < 9; j++) {
                                    if (!panelSudoku.matrix[i][j].getText().equals(" ") && panelSudoku.matrix[i][j].getBackground() == Color.red) {
                                        if (sudokuGame.checkSelectNumber(tmp, i, j, Integer.valueOf(panelSudoku.matrix[i][j].getText()))) {
                                            panelSudoku.matrix[i][j].setBackground(new Color(145, 219, 242));
                                            sudokuGame.setNumberGame(i, j, Integer.valueOf(panelSudoku.matrix[i][j].getText()));
                                        }
                                    }

                                }
                            }

                            if (sudokuGame.cout(tmp) == 0) {
                                JOptionPane.showMessageDialog(labelTime, "Congratulations on completing the challenge");
                                sudokuGame.newSudokuGame(1);
                                panelSudoku.createNewGame(sudokuGame);
                            }
                        }

                    }
                }

            });

        }
        /// ---------------------------panel chua cac nut dieu khien  ------------------------ 
        JPanel panelControl = new JPanel();
        panel1.add(panelControl);
        // panelControl.setBorder(BorderFactory.createLineBorder(Color.black));
        panelControl.setLayout(new BoxLayout(panelControl, BoxLayout.PAGE_AXIS));
        panelControl.setLayout(new GridLayout(5, 0, 0, 6));
        panelControl.setBackground(new Color(145, 219, 242));
        JLabel labelfree = new JLabel("Level:     ", JLabel.LEFT);
        // labelfree.setSize(100, 50);
        //labelfree.setFont(new Font("Helvetica", Font.PLAIN, 14));
        labelfree.setForeground(new Color(145, 219, 242));
        panelControl.add(labelfree);
        //---------------------------------Nut tao moi tro choi-------------------------------

        timer = new Timer(1000, actionTime);
        buttonNew = new JButton("     New Game     ");
        buttonNew.setPreferredSize(new Dimension(175, 40));
        buttonNew.setFont(new Font("Helvetica", Font.PLAIN, 18));
        buttonNew.setBorder(BorderFactory.createLineBorder(Color.black));
        buttonNew.setBackground(new Color(72, 161, 188));
        panelControl.add(buttonNew);

        // -----------------------------Nut tu dong giai sudoku-------------------------------
        buttonAuto = new JButton("         Solve         ");
        buttonAuto.setFont(new Font("Helvetica", Font.PLAIN, 18));
        buttonAuto.setPreferredSize(new Dimension(90, 40));
        buttonAuto.setBackground(new Color(72, 161, 188));
        buttonAuto.setBorder(BorderFactory.createLineBorder(Color.black));
        panelControl.add(buttonAuto);
        buttonAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop = 1;
                int stateGame[][] = sudokuGame.getstateGame();
                int soluong = sudokuGame.cout(stateGame);
                if ((soluong == 30 && sudokuGame.getLevel() == 1) || (soluong == 50 && sudokuGame.getLevel() == 2) || (soluong == 70 && sudokuGame.getLevel() == 3)) {
                    stateGame = sudokuGame.getFirtSolution();
                    sudokuGame.setsudokuGame(stateGame);
                    panelSudoku.solutionGame(sudokuGame);
                } else {
                    int tmp[][] = new int[9][9];
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            tmp[i][j] = 0;
                        }
                    }
                    tmp = sudokuGame.getSolutionGame(stateGame, 0);
                    if (tmp != null) {
                        sudokuGame.setsudokuGame(tmp);
                    } else {
                        sudokuGame.setsudokuGame(sudokuGame.getFirtSolution());
                    }
                    panelSudoku.solutionGame(sudokuGame);
                }
                unEnabled();

            }
        });
        //--------------------------------Nut tro ve menu------------------------------------
        buttonMenu = new JButton("         Menu         ");
        buttonMenu.setFont(new Font("Helvetica", Font.PLAIN, 18));
        buttonMenu.setPreferredSize(new Dimension(90, 40));
        buttonMenu.setBackground(new Color(72, 161, 188));
        buttonMenu.setBorder(BorderFactory.createLineBorder(Color.black));
        panelControl.add(buttonMenu);
        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        //--------------------------------Nut thoat-------------------------------------------
        buttonExit = new JButton("          Exit           ");
        buttonExit.setPreferredSize(new Dimension(90, 40));
        buttonExit.setFont(new Font("Helvetica", Font.PLAIN, 18));
        buttonExit.setBackground(new Color(72, 161, 188));
        buttonExit.setBorder(BorderFactory.createLineBorder(Color.black));
        panelControl.add(buttonExit);
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (!panelSudoku.matrix[i][j].getBackground().equals(new Color(72,161,188)) && sudokuGame.getNumberXY(i, j)!=0) {
                            sudokuGame.setNumberGame(i, j, sudokuGame.getNumberXY(i, j)*10);
                        }
                    }
                }
                sudokuGame.writeFile(count);
                System.exit(0);
            }

        });

    }

    private String timeFormat(int count) {
        int hours = count / 3600;
        int minutes = (count - hours * 3600) / 60;
        int seconds = count - minutes * 60;

        return String.format("      Timer :" + "%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds);

    }

    private void unEnabled() {
        for (int i = 0; i < 9; i++) {
            buttonNumber[i].setEnabled(false);
        }

    }

    private void EnabledTrue() {
        for (int i = 0; i < 9; i++) {
            buttonNumber[i].setEnabled(true);
        }
    }

    public JButton getMenu() {
        return buttonMenu;
    }

    public JButton getButtonNew() {
        return buttonNew;
    }
     public int getCount(){
         return count;
     }
}
