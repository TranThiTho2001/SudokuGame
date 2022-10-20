package Component;

import view.*;
import Component.Square;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import main.SudokuGame;

public class PanelSudoku extends JPanel {

    protected Square matrix[][] = new Square[9][9];
    JPanel panel[][];
    int checkcreate = 1;
    int actions = 0;

    public PanelSudoku(SudokuGame game) {

        super(new GridLayout(3, 3));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setSize(1000, 100);
        setBorder(BorderFactory.createLineBorder(Color.black));
        panel = new JPanel[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panel[i][j] = new JPanel(new GridLayout(3, 3)); //Tao panel co 3 hang 3 cot ben trong                
                panel[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                add(panel[i][j]);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = new Square(i, j);
                panel[i / 3][j / 3].add(matrix[i][j]);
                // matrix[i][j].setBackground(new Color(224, 195, 131));
                matrix[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actions = 1;
                        Square square = (Square) e.getSource();
                        game.CoordinateX = square.getCoordinateX(); // Toa do x cua o duoc chon de dien so
                        game.CoordinateY = square.getCoordinateY(); // Toa do y cua o duoc chon de dien so
                    }
                });
            }

        }

    }
    // Tra ve o vuong (Square) co toa do x,y
    public Square getMatrix(int x, int y){
        return matrix[x][y];
    }

    //----------------------------------------Phuong thuc xoa trang thai sudoku -> Tao sudoku moi------------------------------------------------
    public void deleteGame() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (checkcreate == 1) {
                    matrix[i][j].setBackground(new Color(145, 219, 242));
                    matrix[i][j].setForeground(Color.black);
                }
                matrix[i][j].setnumber("");
            }
        }
    }

    //-------------------------------------Phuong thuc tao mot cau do Sudoku-------------------------------------------------------
    public void createNewGame(SudokuGame game) {
        checkcreate = 1;
        deleteGame();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (game.getNumberXY(i, j) != 0) {
                    if (game.getNumberXY(i, j) > 9) {
                        game.setNumberGame(i, j, game.getNumberXY(i, j) / 10);
                        matrix[i][j].setnumber(String.valueOf(game.getNumberXY(i, j)));
                        matrix[i][j].setEnabled(true);
                    } else {
                        matrix[i][j].setForeground(new Color(60, 79, 85));
                        matrix[i][j].setnumber(String.valueOf(game.getNumberXY(i, j)));
                        matrix[i][j].setBackground(new Color(72, 161, 188));
                    }

                } else {
                    matrix[i][j].setEnabled(true);
                }
            }
        }
    }

    //--------------------------------------- Phuong thuc hien thi loi giai Sudoku---------------------------------------------------
    public void solutionGame(SudokuGame game) {
        checkcreate = 0;
        deleteGame();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j].getForeground() == new Color(60, 79, 85)) {
                    matrix[i][j].setBackground(new Color(72, 161, 188));
                }
                matrix[i][j].setnumber(String.valueOf(game.getNumberXY(i, j)));
            }
        }

    }

}
