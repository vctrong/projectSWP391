/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab4 {

    //Change the name of input and output file based on practical paper
    String inputFile = "input.txt";
    String outputFile = "output.txt";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
    String result = "";
    ArrayList<String> inputLines = new ArrayList<>();
    ArrayList<Media> media = new ArrayList<>();

    //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
    //--START FIXED PART--------------------------    
    String fi, fo;

    /**
     * Set input and output file for automatic rating
     *
     * @param args path of input file and path of output file
     */
    public void setFile(String[] args) {
        fi = args.length >= 2 ? args[0] : inputFile;
        fo = args.length >= 2 ? args[1] : outputFile;
    }

    /**
     * Reads data from input file
     */
    public void read() {
        try (Scanner sc = new Scanner(new File(fi))) {
            //--END FIXED PART----------------------------

            //INPUT - @STUDENT: ADD YOUR CODE FOR INPUT HERE:
            int T = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < T; i++) {
                String Line = sc.nextLine();
                inputLines.add(Line);
            }

            //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
            //--START FIXED PART--------------------------    
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Input Exception # " + ex);
        }
    }
    //--END FIXED PART----------------------------

    //ALGORITHM - @STUDENT: ADD YOUROWN METHODS HERE (IF NEED):
    //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
    //--START FIXED PART--------------------------    
    /**
     * Main algorithm
     */
    public void solve() {
        //--END FIXED PART----------------------------

        for (String inputLine : inputLines) {
            String[] token = inputLine.trim().split(" ");
            switch (token[0]) {
                case "M":
                    //Lấy thông tin cần để tạo đối tượng
                    String id = token[1];
                    String title = token[2];
                    String director = token[3];
                    int releaseYear = Integer.parseInt(token[4]);
                    int size = Integer.parseInt(token[5]);
                    //Sau khi lấy thông tin xong thì khởi tạo đối tượng
                    Movie m = new Movie(title, director, releaseYear, id, size);
                    //Khởi tạo xong thì thêm đối tượng vào danh sách để quản lý
                    media.add(m);
                    //Rồi in thông báo ra file out put, nếu có hàm sẳn thì gọi hàm ra, không thì viét tay thêm vào result
                    result += m.entryData();

                    break;
                case "T":
                    //tương tự như trên movie
                    String idT = token[1];
                    String titleT = token[2];
                    String artist = token[3];
                    String category = token[4];
                    int sizeT = Integer.parseInt(token[5]);
                    Track t = new Track(titleT, artist, category, idT, sizeT);
                    media.add(t);
                    result += t.entryData();
                    break;
                case "Clear":
                    //Dùng hàm clear() để clear toàn bộ arraylist 
                    media.clear();
                    //rồi viết thông báo ra
                    result += "* Remove all media\n";
                    break;
                case "List":
                    //viết thông báo list như sample
                    result += "---List---\n";
                    
                    //kiểm tra xem cái arraylist đang quản lý có rỗng hay không, nếu rỗng thì in empty ra
                    if (media.isEmpty()) {
                        result += "Empty\n";
                    } else {
                        //duyệt qua tất cả phần tử trong arraylist bằng for rồi dùng hàm in có sẳn, nếu không thì viết tay
                        for (int i = 0; i < media.size(); i++) {
                            result += media.get(i).printData();
                        }
                    }
                    result += "------\n";
                    break;
                case "Size":
                    //Khai báo 1 biến để lưu tổng size của các media
                    int totalSize = 0;
                    //duyệt qua toàn bộ các phần tử trong arraylist bằng for để lấy kích thước
                    //media.size() để lấy kích thước của arraylist hiện, ví dụ: arraylist có 4 phần tử thì media.size() sẽ trả về 4
                    for (int i = 0; i < media.size(); i++) {
                        totalSize = totalSize + media.get(i).getSize(); //dùng media.get(i) để lấy các phần tử trong media ra,
                        //ví dụ phần tử thứ 2 của mảng a là "abc" thì a.get(1) sẽ trả về abc
                    }
                    result += "Total size: " + totalSize + "MB\n";
                    break;
            }
        }

        //ALGORITHM - @STUDENT: ADD YOUR CODE HERE:
        //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
        //--START FIXED PART-------------------------- 
    }

    /**
     * Write result into output file
     */
    public void printResult() {
        try {
            FileWriter fw = new FileWriter(fo);
            //--END FIXED PART----------------------------

            //OUTPUT - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
            fw.write(result);

            //--FIXED PART - DO NOT EDIT ANY THINGS HERE--
            //--START FIXED PART-------------------------- 
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Output Exception # " + ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lab4 q = new Lab4();
        q.setFile(args);
        q.read();
        q.solve();
        q.printResult();
    }
    //--END FIXED PART----------------------------    
}
