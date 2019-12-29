/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkValid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class CheckValid {
    public static boolean checkDate(String dateBooking, String datePay){
        boolean check = false;
        String DATE_FORMAT = "dd-MM-yyyy";
        try {
            Date d1 = new SimpleDateFormat(DATE_FORMAT).parse(dateBooking);
            Date d2 = new SimpleDateFormat(DATE_FORMAT).parse(datePay);
            if(d1.after(d2)){
                check = false;
            }if(d1.before(d2)){
                check = true;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
    public static boolean checkBlankCustomer(String id, String name, String addr, String tel){
        boolean check = false;
        String ID_Format = "\\d{9}";
        if(id.matches(ID_Format) == true && !name.trim().equals("") && !addr.trim().equals("") && !tel.trim().equals("")){
            check = true;
        }
        return check;
    }
    
    public static boolean checkCar(String lice, String brand, String color, String seat , String price , String state){
        boolean check = false;
        String lice_Format ="^[0-9]{2}[A-Z]-[0-9]{5}$";
     
        if(lice.matches(lice_Format) == true && !brand.trim().equals("") && !color.trim().equals("")
                && !state.trim().equals("") && !price.trim().equals("") && !seat.trim().equals("")){
            check = true;
        }
        return check;
    }
}
