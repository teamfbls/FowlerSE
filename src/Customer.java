

import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector _rentals = new Vector();
    public int ffffff;
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();	    
        String result = "Rental Record for " + getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentals.hasMoreElements()) {
            
            Rental each = (Rental) rentals.nextElement();
            
            // add frequent renter points
            frequentRenterPoints += each.getFrequentRenterPoints();
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }
    private double getTotalCharge() {
        double result = 0; 
        Enumeration rentals = _rentals.elements(); 
        while (rentals.hasMoreElements()){
            Rental each =(Rental) rentals.nextElement(); 
            result += each.getCharge();
        }
        return result; 
    }
    private int getTotalFrequentRenterPoints(){
        int result=0; 
        Enumeration rentals = _rentals.elements(); 
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement(); 
            result += each.getFrequentRenterPoints(); 
        }
        return result; 
            
    }
    public String htmlStatement() {
        Enumeration rentals = _rentals.elements(); 
        String result ="<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement(); 
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge())+ "<BR>\n";
            
        }
        result += "<P> You owe <EM>" + String.valueOf(getTotalCharge())+ "</EM><P>\n"; 
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints())+ "</EM> frequent renter points<P>"; 
        return result; 
    }

}