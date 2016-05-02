

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author THaskioglu
 */
public abstract class Price {
    abstract int getPriceCode();    

public abstract double getCharge(int daysRented);

public int getFrequentRenterPoints(int daysRented){
   
        return 1; 
}
}