package com;

public class PowerBill {
    public void bill(int units) {
        double rate=1;
        double billAmount = 0;
        if(units<=90) {
            billAmount=units*rate;
            System.out.println(billAmount);
        }
        if(units>91&&units<=150) {
            rate=rate+0.5;
            billAmount= (units-90)*rate+90;
            System.out.println(billAmount);
        }
        if(units>151&&units<=200) {
            rate=rate+1.0;
            billAmount=(units-150)*rate+180;
            System.out.println(billAmount);
        }
        if(units>=201&&units<=240) {
            rate=rate+1.5;
            billAmount=(units-200)*rate+278;
            System.out.println(billAmount);
        }
        if(units>=241) {
            rate=rate+2;
            billAmount=(units-240)*rate+375.5;
            System.out.println(billAmount);
        }

    }
    public static void main(String[] args) {
        PowerBill p=new PowerBill();
        int units=242;
        p.bill(units);
    }

}
