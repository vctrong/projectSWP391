/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab7 {

    //Change the name of input and output file based on practical paper
    String inputFile = "input.txt";
    String outputFile = "output.txt";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
    String result = "";
    ArrayList<String> inputLines = new ArrayList<>();
    ArrayList<Order> order = new ArrayList<>();

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
        try ( Scanner sc = new Scanner(new File(fi))) {
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
                case "Order":
                    String type = token[2];
                    String id = token[1];
                    String name = token[3];
                    double price = Double.parseDouble(token[5]);
                    int qty = Integer.parseInt(token[6]);
                    if (type.equals("F")) {
                        boolean rare = Boolean.parseBoolean(token[4]);
                        Flower f = new Flower(rare, name, price);
                        Order o = new Order(id, f, qty);
                        order.add(o);
                    } else {
                        int length = Integer.parseInt(token[4]);
                        Tree t = new Tree(length, name, price);
                        Order o = new Order(id, t, qty);
                        order.add(o);
                    }
                    result += "Added new order " + id + "!\n";
                    break;
                case "List":
                    for (Order o : order) {
                        result += o.printInfo() + "\n";
                    }
                    break;
                case "Total":
                    double total = 0;
                    for (Order o : order) {
                        total = total + o.getTotal();
                    }
                    result += "Total = $" + total + "\n";
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
        Lab7 q = new Lab7();
        q.setFile(args);
        q.read();
        q.solve();
        q.printResult();
    }
    //--END FIXED PART----------------------------    
}
