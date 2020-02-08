package org.homeTask;
import java.util.*;
public class GiftBox {
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        int  qty, set, wt;
        String candy;
        GiftBox gb=new GiftBox();
        System.out.print("What quantity box would you prefer: 12 or 6 set:");
        set=obj.nextInt();
    System.out.print("****************** GIFT BOX MENU ******************\n"+
            "1.Pop Tart\n"+
            "2.Eclairs\n"+
            "3.Reese's Cup\n"+
            "4.Jell-O\n"+
            "5.MnM's\n"+
            "6.Skittles\n"+
            "7.Kit Kat\n"+
            "Select the contents of the Gift Box\n"

    );
    int candyarr[]=new int[set];
    int no=set;
    while(set!=0)
    {
        int i=0;
        System.out.println("Candy name:");
        candy=obj.next();
        candyarr[i].setCandyName(candy);
        System.out.println("Quantity:");
        qty=obj.nextInt();
        candyarr[i].setCandyQty(qty);
        System.out.println("Weight:");
        wt=obj.nextInt();
        candyarr[i].setCandyWt(wt);
        set-=qty;
    }
        System.out.println("press 1 to get total weight of the gift box\n" +
                "press 2 to sort the contents of gift\n" +
                "press 3 to find candy/chocolate in the gift corresponding to selected option\n" +
                "press 4 to exit");
        boolean exit=false;
    do {
        System.out.println("Enter your choice:");
        int choice = obj.nextInt();
        switch(choice){
            case 1: {
                int totalwt = gb.getCandyGiftBoxWt(candyarr, no);
                if (totalwt >= 1000) {
                    int tw = totalwt / 1000;
                    int twg = totalwt % 1000;
                    System.out.println("Total weight of the candy gift box is: " + tw + "kg " + twg + "g");
                } else {
                    System.out.println("Total weight of the candy gift box is: " + totalwt + "g");
                }
            }
            break;
            case 2: {

                System.out.println("Enter criteria upon which you want to sort candies(name/quan/wt): ");
                String sortCriteria = obj.next();
                gb.sortCandies(sortCriteria, no, candyarr);
            }
                break;
            case 3:
            {
                System.out.println("Enter the criteria on which you want to find the candy:name/wt/quan");
                String criteria2=obj.next();
                gb.findCandy(candyarr,criteria2,no);
            }
            break;
            case 4:
                exit=true;
                break;

        }

    }while (exit!=true);
    }
    private int getCandyGiftBoxWt(Candy[] candyarr, int no) {
        int totalwt=0,i;
        int wt,q;
        for(i=0;i<no;i++)
        {
            wt=candyarr[i].getWeight();
            q=candyarr[i].getCandyquan();
            totalwt=totalwt+(wt*q);
        }
        return totalwt;
    }
    private void findCandy(Candy[] candyarr, String criteria2, int no) {
        int i;
        Scanner sc=new Scanner(System.in);
        if(criteria2.equals("name"))
        {
            System.out.println("Enter candy name:");
            String candyname=sc.next();
            for(i=0;i<no;i++)
            {
                if(candyarr[i].candyName.equals(candyname)){
                    System.out.println("Candy "+candyname+" found and it's weight is : "+candyarr[i].candyweight+" and it's quantity in gift box is: "+candyarr[i].candyquan);
                }
            }
        }
        else if(criteria2.equals("wt")){
            System.out.println("Enter chocolate weight:");
            int candywt=sc.nextInt();
            for(i=0;i<no;i++)
            {
                if(candyarr[i].candyweight==candywt){
                    System.out.println("Candy name: "+candyarr[i].candyName+" found and it's weight is : "+candyarr[i].candyweight+" and it's quantity is: "+candyarr[i].candyquan);
                }
            }
        }
        else if(criteria2.equals("quan")){
            System.out.println("Enter chocolate quan:");
            int candyqn=sc.nextInt();
            for(i=0;i<no;i++)
            {
                if(candyarr[i].candyquan==candyqn){
                    System.out.println("Candy name: "+candyarr[i].candyName+" found and it's weight is : "+candyarr[i].candyweight+" and it's quantity is: "+candyarr[i].candyquan);
                }
            }
        }
    }

    private void sortCandies(String sortCriteria, int no, Candy[] candyarr) {
        int i,j;
        if(sortCriteria.equals("quan"))
        {
            for(i=0;i<no;i++)
            {
                for(j=i+1;j<no;j++)
                {
                    if(candyarr[i].candyquan>candyarr[j].candyquan)
                    {
                        int temp=candyarr[i].candyquan;
                        candyarr[i].candyquan=candyarr[j].candyquan;
                        candyarr[j].candyquan=temp;
                        String temp1=candyarr[i].candyName;
                        candyarr[i].candyName=candyarr[j].candyName;
                        candyarr[j].candyName=temp1;
                        int temp2=candyarr[i].candyweight;
                        candyarr[i].candyweight=candyarr[j].candyweight;
                        candyarr[j].candyweight=temp2;
                    }
                }
            }
            System.out.println("!!SORTED ON THE BASIS OF QUANTITY!!");
            for(i=0;i<no;i++)
            {
                System.out.println("NAME: "+candyarr[i].candyName+" , QUANTITY: "+candyarr[i].candyquan+" WEIGHT: "+candyarr[i].candyweight);
            }
        }
        else if(sortCriteria.equals("wt")){
            for(i=0;i<no;i++)
            {
                for(j=i+1;j<no;j++)
                {
                    if(candyarr[i].candyweight>candyarr[j].candyweight)
                    {
                        int temp=candyarr[i].candyquan;
                        candyarr[i].candyquan=candyarr[j].candyquan;
                        candyarr[j].candyquan=temp;
                        String temp1=candyarr[i].candyName;
                        candyarr[i].candyName=candyarr[j].candyName;
                        candyarr[j].candyName=temp1;
                        int temp2=candyarr[i].candyweight;
                        candyarr[i].candyweight=candyarr[j].candyweight;
                        candyarr[j].candyweight=temp2;
                    }
                }
            }
            System.out.println("!!SORTED ON THE BASIS OF WEIGHT!!");
            for(i=0;i<no;i++)
            {
                System.out.println("NAME: "+candyarr[i].candyName+" , QUANTITY: "+candyarr[i].candyquan+" WEIGHT: "+candyarr[i].candyweight);
            }
        }
        else if(sortCriteria.equals("name")){
            for(i=0;i<no;i++)
            {
                for(j=i+1;j<no;j++)
                {
                    String s1=candyarr[i].candyName;
                    String s2=candyarr[j].candyName;
                    if(s1.compareTo(s2)>0)
                    {
                        int temp=candyarr[i].candyquan;
                        candyarr[i].candyquan=candyarr[j].candyquan;
                        candyarr[j].candyquan=temp;
                        String temp1=candyarr[i].candyName;
                        candyarr[i].candyName=candyarr[j].candyName;
                        candyarr[j].candyName=temp1;
                        int temp2=candyarr[i].candyweight;
                        candyarr[i].candyweight=candyarr[j].candyweight;
                        candyarr[j].candyweight=temp2;
                    }
                }
            }
            System.out.println("!!SORTED ON THE BASIS OF NAMES!!");
            for(i=0;i<no;i++)
            {
                System.out.println("NAME: "+candyarr[i].candyName+" , QUANTITY: "+candyarr[i].candyquan+" WEIGHT: "+candyarr[i].candyweight);
            }
        }
    }

}

}
