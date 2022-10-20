package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SudokuGame {

    private int selectnunber;
    private int game[][] = new int[9][9]; // Luu tru trang thai hien tai cua game tai mot thoi diem
    private int level;
    private int firtSolution[][] = new int[9][9]; // Luu tru cau do Sudoku hoan chinh
    private int time = 0;
    public int CoordinateX, CoordinateY; //vi tri o duoc chon dien so trong ma tran 9x9

    //Khoi tao cac o trong game co gia tri la 0
    public SudokuGame() {
        int init[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                init[i][j] = 0;
                firtSolution[i][j] = 0;
                game[i][j] = 0;
            }
        }
        level = 1;
        int temporary[][] = getFirtSolution(init, 0);
        firtSolution = coppySudokuGame(temporary);
        getOldStateGame();

    }

    // Tao mot SudokuGame moi voi muc do kho levelGame
    public void newSudokuGame(int levelGame) {
        //int solution[][] = new int[9][9];
        int init[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                init[i][j] = 0;
                firtSolution[i][j] = 0;
                game[i][j] = 0;
            }
        }
        level = levelGame;
        int temporary[][] = getFirtSolution(init, 0);
        firtSolution = coppySudokuGame(temporary);
        game = createProblemSudoku(temporary);
    }

    public SudokuGame(int levelGame) {
        //int solution[][] = new int[9][9];
        int init[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                init[i][j] = 0;
                firtSolution[i][j] = 0;
                game[i][j] = 0;
            }
        }
        level = levelGame;
        int temporary[][] = getFirtSolution(init, 0);
        firtSolution = coppySudokuGame(temporary);
        game = createProblemSudoku(temporary);
    }

    // ham xay dung sao chep cua thuoc tinh game 
    public void setsudokuGame(int tmp[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                game[i][j] = tmp[i][j];
            }
        }
    }

    // Tra ve trang thai hien tai (Ma tran cac so hien tai) cua game
    public int[][] getstateGame() {
        return game;
    }

    public int[][] getFirtSolution() {
        return firtSolution;
    }

    public void setLevel(int l) {
        level = l;
    }

    public int getLevel() {
        return level;
    }

    public int getOldTime() {
        return time;
    }

    //--------------------------Phuong thuc ghi trang thai game hien tai vao file  SudokuGameFile.txt--------------------------------------
    public void writeFile(int time) {
      try {
           FileWriter file;
           //File f = new File(System.getProperty("user.dir")+"\\src\\Data\\SudokuGameFile.txt");
          File f = new File(getClass().getResource("/Data/SudokuGameFile.txt").toURI());
           //File f = new File("Data/SudokuGameFile.txt");
           try {
               file = new FileWriter(f);
               for (int i = 0; i < 9; i++) {
                   for (int j = 0; j < 9; j++) {
                       int number = game[i][j];
                       file.write(number + " ");
                   }
                   file.write("\n");
               }
               file.write(String.valueOf(time));
               file.close();
           } catch (IOException ex) {
               Logger.getLogger(SudokuGame.class.getName()).log(Level.SEVERE, null, ex);
           }
       } catch (URISyntaxException ex) {
            Logger.getLogger(SudokuGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //---------------------------Phuong thuc hien thi trang thai cua man choi truoc-----------------------------------------------------------
    public void getOldStateGame() {
       try {
            File file = new File(getClass().getResource("/Data/SudokuGameFile.txt").toURI());
          //  File file = new File("Data/SudokuGameFile.txt");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                try {
                    line = reader.readLine();
                    int j = 0;
                    while (line != null) {
                        if (j == 9) {
                            time = Integer.valueOf(String.valueOf(line));
                            break;
                        } else {
                            String row[] = line.split(" ");
                            for (int i = 0; i < row.length; i++) {
                                game[j][i] = Integer.valueOf(String.valueOf(row[i]));
                            }
                            j++;
                            line = reader.readLine();
                        }

                    }
                    if (cout(game) == 0) {
                        newSudokuGame(1);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(SudokuGame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SudokuGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(SudokuGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Gan so duoc chon tai thoi diem hien tai
    public void setNumber(int number) {
        selectnunber = number;
    }

    // Lay so duoc chon tai thoi diem
    public int getSelectNumber() {
        return selectnunber;
    }

    // Tra ve so tai vi tri x,y
    public int getNumberXY(int x, int y) {
        return game[x][y];
    }

    //Gan so duoc chon number cho mang game[x][y]
    public void setNumberGame(int x, int y, int number) {
        game[x][y] = number;
    }

    //Kiem tra so theo hang        
    public boolean checkRow(int sudokuGame[][], int x, int y, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudokuGame[x][i] == number && y != i) {
                return false;
            }
        }
        return true;
    }

    //Kiem tra so theo cot
    public boolean checkColum(int sudokuGame[][], int x, int y, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudokuGame[i][y] == number && x != i) {
                return false;
            }
        }
        return true;
    }

    //Kiem tra so trong ma tran 3x3
    public boolean checkSmallPanel(int sudokuGame[][], int x, int y, int number) {
        int hang = x / 3;
        int cot = y / 3;
        for (int i = hang * 3; i < hang * 3 + 3; i++) {
            for (int j = cot * 3; j < cot * 3 + 3; j++) {
                if (sudokuGame[i][j] == number && x != i && y != j) {
                    return false;
                }
            }
        }
        return true;
    }

    //Kiem tra viec luu ma tran(game sudoku)
    public void in() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println("\n");
        }
        System.out.println("");
    }

    // Kiem tra mot so dien vao ma tran sudokuGame tai vi tri x,y co duoc khong.
    public boolean checkSelectNumber(int sudokuGame[][], int x, int y, int number) {
        return (checkRow(sudokuGame, x, y, number) && checkColum(sudokuGame, x, y, number) && checkSmallPanel(sudokuGame, x, y, number));
    }

    // -------------------------------Dem co bao nhieu vi tri chua duoc dien so trong ma tran(tro choi sudoku)-----------------------------
    public int cout(int sudokuGame[][]) {
        int c = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudokuGame[i][j] == 0) {
                    c++;
                }
            }
        }
        return c;
    }

    //-------------------------------Ham kiem tra dien so number vao vi tri x, y co duoc khong-----------------------------------
    public boolean checkNumber(int sudokuGame[][], int x, int y, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudokuGame[x][i] == number || sudokuGame[i][y] == number) {
                return false;
            }
        }
        int row = x / 3;
        int column = y / 3;
        for (int i = row * 3; i < row * 3 + 3; i++) {
            for (int j = column * 3; j < column * 3 + 3; j++) {
                if (sudokuGame[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    //-------------------------------------Ham tim so dien vao vi tri x, y -----------------------------------------------------------------
    private int getNextPossibleNumber(int[][] sudokuGame, int x, int y, List<Integer> numbers) {
        while (numbers.size() > 0) {
            int number = numbers.remove(0);
            if (checkNumber(sudokuGame, x, y, number)) {
                return number;
            }
        }
        return -1;
    }

    //--------------------------------------Ham khoi tao mot loi giai Sudoku ban dau---------------------------------------------------------
    private int[][] getFirtSolution(int[][] sudokuGame, int position) {
        if (position > 80) { // vi tri danh so tư 0 nen 81 o vuong thi co 80 vi tri
            return sudokuGame;
        }

        int x = position % 9; //chi so hang
        int y = position / 9;  // chi so cot

        List<Integer> numbers = new ArrayList<Integer>(9);
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        while (numbers.size() > 0) {
            int number = getNextPossibleNumber(sudokuGame, x, y, numbers);
            if (number == -1) {
                return null;
            }
            sudokuGame[x][y] = number;
            int[][] tmpGame = getFirtSolution(sudokuGame, position + 1);
            if (tmpGame != null) {
                return tmpGame;
            }
            sudokuGame[x][y] = 0;
        }

        return null;

    }

    // -------------------------------------Sao chep trang thai game ------------------------------------------------------------------
    public int[][] coppySudokuGame(int sudokuGame[][]) {
        int coppyGame[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int value = sudokuGame[i][j];
                coppyGame[i][j] = value;
            }
        }

        return coppyGame;
    }

    public int[][] getSolutionGame(int sudokuGame[][], int position) {

        if (position > 80) {
            return sudokuGame;
        }

        int x = position % 9; //chi so hang
        int y = position / 9;  // chi so cot

        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        if (sudokuGame[x][y] == 0) {
            while (numbers.size() > 0) {

                int number = getNextPossibleNumber(sudokuGame, x, y, numbers);
                if (number == -1) {
                    return null;
                }
                sudokuGame[x][y] = number;
                int[][] tmpGame = getSolutionGame(sudokuGame, position + 1);
                if (tmpGame != null) {
                    return tmpGame;
                }
                sudokuGame[x][y] = 0;
            }
        } else {
            int[][] tmpGame = getSolutionGame(sudokuGame, position + 1);
            if (tmpGame != null) {
                return tmpGame;
            }
        }
        return null;
    }
//--------------------------------------------------------------------------
    // Phuong thuc tao 1 tro choi sudoku moi bang cac coppy loi giai cua tro choi, sao do an di(cho o vuong ==0) ngau nhien n o vuong 

    public int[][] createProblemSudoku(int sudokuGame[][]) {
        ArrayList<Integer> random = new ArrayList<>();
        for (int i = 0; i < 81; i++) {
            random.add(i);
        }
        Collections.shuffle(random);
        // Tron vi tri cua 81 so(o so) de chon ngau nhien cac o can an di
        int k;
        if (level == 1) {
            k = 30;
        } else if (level == 2) {
            k = 50;
        } else {
            k = 70;
        }
        for (int i = 0; i < k; i++) {
            int tmp = random.remove(0);
            int x = tmp % 9; //  So hang
            int y = tmp / 9; // So cot
            sudokuGame[x][y] = 0; // cho o so tai vi tri x, y =0
        }

        return sudokuGame;
    }

    public void getsolutionGame(int[][] stateGame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
