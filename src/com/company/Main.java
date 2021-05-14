package com.company;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;


public class Main {
    static class Result{
        int stolenItems; // % of stolen items
        int stolenValue;    // % of stolen value
        Vector<int[]> Backpack;

    };
    public static Result STEAL(int seed){
        ///////////////////PROGRAM//////////////////////
        int numOfItems = 30;
        int[][] Items = new int[numOfItems][3];
        RandomNumberGenerator rng = new RandomNumberGenerator(seed);

        //Generating Items
        for(int i=0;i<numOfItems;i++){
            Items[i][0] = rng.nextInt(1,10);    //Weight
            Items[i][1] = rng.nextInt(1,1000);  //Value
            Items[i][2] = Items[i][1]/Items[i][0];        //Ratio
        }
        //Generating BackPack.capacity
        int capacity = numOfItems;//approx. 20% of all goods weight

        //Sorting items by ratio

        for(int i=0;i<numOfItems;i++){
            for(int j=0;j<numOfItems;j++){
                if (j+1<numOfItems)if(Items[j][2]<Items[j+1][2]) {
                    int[] item = Items[j];
                    Items[j]= Items[j+1];
                    Items[j+1] = item;
                }
            }
        }

        Vector<int[]> Backpack = new Vector<>();
        int sum=0;
        int allWeight=0;
        int allValue=0;
        int sumValue=0;
        for(int i=0;i<numOfItems;i++){
            allWeight += Items[i][0];
            allValue += Items[i][1];
            if(sum+ Items[i][0]<=capacity) {
                sum +=Items[i][0];
                sumValue +=Items[i][1];
                Backpack.add(Items[i]);
            }
        }

        Result result = new Result();
        result.Backpack = Backpack;
        result.stolenItems = 100*sum/allWeight;
        result.stolenValue = 100*sumValue/allValue;

        return result;
    };
    public static void main(String[] args) {
        System.out.println("Java&.NET LAB 2021 Grupa 5");

        int seed = 1;
       int numOfItems=30;
        JFrame frame = new JFrame("Backpack Problem SwingUI");
        JPanel panel = new JPanel();
        JLabel txt1 = new JLabel("Enter Seed: ");
        JTextField txtField = new JTextField(5);
        JButton buttonSteal = new JButton("Steal");
        JLabel info1 = new JLabel("");
        JLabel info2 = new JLabel("%");
        JLabel info3 = new JLabel("%");
        JLabel result1 = new JLabel("None");
        JLabel result2 = new JLabel("None");
        JLabel result3 = new JLabel("None");
        panel.add(txt1);
        panel.add(txtField);
        panel.add(buttonSteal);
        panel.add(result1);
        panel.add(result2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(400,300);
        Result result = STEAL(154);
        System.out.println(result.Backpack.capacity()+" | "+result.stolenItems+" | "+result.stolenValue);
frame.setVisible(true);
    }
}
