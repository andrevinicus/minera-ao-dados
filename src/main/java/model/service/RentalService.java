/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.service;

import java.net.CacheRequest;
import java.time.Duration;
import model.entites.CarRental;
import model.entites.Invoice;

/**
 *
 * @author GCM_02
 */
public class RentalService {
    
    private Double pricePerDay;
    private Double pricePerHour;
    
    private TaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }
    
    public void processInvoice(CarRental carReantal){
        
        double minutes = Duration.between(carReantal.getStart(),carReantal.getFinish()).toMinutes();
        double hours = minutes / 60;
        
        double basicPayment;
        if(hours <= 12.0){
            basicPayment = pricePerHour * Math.ceil(hours);
        }else{
            basicPayment = pricePerDay * Math.ceil(hours / 24);
        }
        double tax = taxService.tax(basicPayment);
        
        carReantal.setInvoice(new Invoice(basicPayment,tax));
    }
            

}
