/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entites;

/**
 *
 * @author GCM_02
 */
public class Invoice {
    private Double BasicPayment;
    private Double Tax;
    
    public Invoice(){
        
    }

    public Invoice(Double BasicPayment, Double Tax) {
        this.BasicPayment = BasicPayment;
        this.Tax = Tax;
    }

    public Double getBasicPayment() {
        return BasicPayment;
    }

    public void setBasicPayment(Double BasicPayment) {
        this.BasicPayment = BasicPayment;
    }

    public Double getTax() {
        return Tax;
    }

    public void setTax(Double Tax) {
        this.Tax = Tax;
    }

   
    public Double getTotalPayment(){
        return getTotalPayment() + getTax();
    }
    
}
