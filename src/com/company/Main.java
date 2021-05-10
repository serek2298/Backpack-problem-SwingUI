package com.company;
import javax.swing.*;
import java.util.*;
import java.io.*;
/*public class Item
{
    int weight;
    int value;
    float ratio;




    public Item(int weight, int value)
    {
        this.weight = weight;
        this.value = value;
        if (weight != 0) this.ratio = (float)value / (float)weight;
        else ratio = 0;
    }
    public Item()
    {
        this.weight = 0;
        this.value = 0;
        this.ratio = 0;
    }
    public String GetStringFromItem()
    {
        return ("Waga: " + weight + " Wartosc: " + value+"||");
    }
    public static boolean ==(Item compare, Item toCompare)
    {
        if (compare.value == toCompare.value && compare.weight == compare.weight) return true;
        else return false;
    }

    public static bool operator !=(Item compare, Item toCompare)
    {
        if (compare.value == toCompare.value && compare.weight == compare.weight) return false;
        else return true;
    }


}

public class ListOfItem
{
    List<Item> list = new List<Item>();
    public List<Item> List
    {
        get => this.list;
        set => this.list = value;
    }


    public ListOfItem(int seedToweight, int seedTovalue, int amountOfItems)
    {
        RandomNumberGenerator rngToweights = new RandomNumberGenerator(seedToweight);
        RandomNumberGenerator rngTovalues = new RandomNumberGenerator(seedTovalue);


        for (int x = 0; x < amountOfItems; x++)
        {
            list.Add(new Item(rngToweights.nextInt(1, 29), rngTovalues.nextInt(1, 29)));
        }
        SortListByratio();

    }
    public String getStringFromList()
    {
        String returnvalue = "";
        foreach (Item x in list)
        {
            returnvalue += "\n" + x.GetStringFromItem() + " ";
        }
        return returnvalue;
    }
    public void AddItemToListManual(Item item)
    {
        list.Add(item);
        SortListByratio();
    }

    public void  SortListByratio()
    {
        list.Sort((x, y) => x.ratio.CompareTo(y.ratio));
        list.Reverse();
    }

    public ListOfItem()
    {

    }

    public void DisplayList()
    {
        foreach (Item x in list)
        {
            System.Console.WriteLine(x.GetStringFromItem());
        }
    }

    public static bool operator ==(ListOfItem compare, ListOfItem toCompare)
    {
        for(int i = 0;i<compare.List.Count();i++)
        {
            if (compare.List[i] != toCompare.List[i]) return false;
        }
        return true;
    }
    public static bool operator != (ListOfItem compare, ListOfItem toCompare)
    {
        for (int i = 0; i < compare.List.Count(); i++)
        {
            if (compare.List[i] != toCompare.List[i]) return true;
        }
        return false;
    }

}

public class BackPack
{
    int maxCapacity;
    int currentCapacity;
    List<Item> itemsOnBackPack =new List<Item>();

    public int MaxCapacity
    {
        get => maxCapacity;
        set => maxCapacity = value;
    }
    public int CurrentCapacity
    {
        get => currentCapacity;
        set => currentCapacity = value;
    }

    public List<Item> ItemsOnBackPack
    {
        get => itemsOnBackPack;
        set => itemsOnBackPack = value;
    }




    public BackPack(int capacity)
    {
        this.maxCapacity = capacity;
    }
    public bool Add(Item newItem)
    {
        if(this.currentCapacity + newItem.weight <= maxCapacity)
        {
            this.ItemsOnBackPack.Add(newItem);
            this.currentCapacity += newItem.weight;
            return true;
        }
        else
        {
            return false;
        }
    }

    public bool robTheHouse(ListOfItem availableItems)
    {
        int amountBeforeRob = itemsOnBackPack.Count();
        foreach(Item item in availableItems.List)
        {
            Add(item);
        }
        int amountAfterRob = itemsOnBackPack.Count();
        if (amountAfterRob == amountBeforeRob) return false;
        else return true;

    }

    public void showWhatYouVeStolen()
    {
        foreach(Item item in ItemsOnBackPack)
        {
            Console.WriteLine(item.GetStringFromItem());
        }
    }
    public String getStringFromBackPack()
    {
        String returnvalue = "";
        foreach (Item x in itemsOnBackPack)
        {
            returnvalue += "\n" + x.GetStringFromItem() + " ";
        }
        return returnvalue;
    }

}

 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Java&.NET LAB 2021 Grupa 5");

        int seed = 1;
       int numOfItems=30;

///////////////////PROGRAM//////////////////////
        int[][] Items = new int[numOfItems][3];
        RandomNumberGenerator rng = new RandomNumberGenerator(seed);

       //Generating Items
        for(int i=0;i<numOfItems;i++){
            Items[i][0] = rng.nextInt(0,10);    //Weight
            Items[i][1] = rng.nextInt(0,1000);  //Value
            Items[i][2] = Items[i][1]/Items[i][0];        //Ratio
        }
        //Generating BackPack.capacity
        int capacity = numOfItems;//approx. 20% of all goods weight

        //Sorting items by ratio

        for(int i=0;i<numOfItems;i++){
            for(int j=0;j<numOfItems;j++){
                if (j+1<numOfItems)if(Items[j][3]<Items[j+1][3]) {
                    int[] item = Items[j];
                    Items[j]= Items[j+1];
                    Items[j+1] = item;
                }
            }
        }

        Vector<int[]> Backpack = new Vector<>();
        int sum=0;
        for(int i=0;i<numOfItems;i++){

            if(sum+ Items[i][1]<=capacity) {
                sum +=Items[i][1];
                Backpack.add(Items[i]);
            }
        }



    }
}
