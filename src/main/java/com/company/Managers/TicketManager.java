package com.company.Managers;


import com.company.Models.*;
import com.company.Helper.Printer;
import com.company.Validator;

public class TicketManager implements Validator {
    public static Long ids = (long)-1;
    public static Long ids_venue = (long)-1;

    public static Long getIds() {
        ids++;
        return ids;
    }

    public static Long getIds_venue() {
        ids_venue++;
        return ids_venue;
    }

    public static String getString(String name){
        String str = "";
        while (str.equals("")){
            Printer.getInstance().WriteLine("Введите поле " + name);
            str = Printer.getInstance().ReadLine();
        }
        return str;
    }
    public static int getInt(String name){
        int str;
        while (true){
            try {
                Printer.getInstance().WriteLine("Введите поле " + name);
                str = Integer.parseInt(Printer.getInstance().ReadLine());
                break;
            }
            catch (Exception ignored){

            }
        }
        return str;
    }
    public static long getLong(String name){
        long str;
        while (true){
            try {
                Printer.getInstance().WriteLine("Введите поле " + name);
                str = Long.parseLong(Printer.getInstance().ReadLine());
                break;
            }
            catch (Exception ignored){

            }
        }
        return str;
    }


    public Ticket get_ticket(){

        String name = TicketManager.getString("name");
        while (validationName(name)) {
            Printer.getInstance().InvalidValue();
            name = TicketManager.getString("name");
        }

        int price = TicketManager.getInt("price");
        while (validationPrice(price)) {
            Printer.getInstance().InvalidValue();
            price = TicketManager.getInt("price");
        }

        int discount = TicketManager.getInt("discount");
        while (validationDiscount(discount)) {
            Printer.getInstance().InvalidValue();
            discount = TicketManager.getInt("discount");
        }

        TicketType type = null;
        while (true){
            try{
                Printer.getInstance().WriteLine("Введите TicketType");
                for (TicketType ticketType: TicketType.values()) {
                    Printer.getInstance().Write("\t\t\t\t" + ticketType);
                }
                Printer.getInstance().WriteLine("");
                String next = Printer.getInstance().ReadLine();
                if(next.equals("null") || next.equals("")){
                    break;
                }
                type = TicketType.valueOf(next);
                break;
            }
            catch (Exception ignored){

            }
        }
        Printer.getInstance().WriteLine("Вводится coordinate");

        int x = TicketManager.getInt("X");
        while (validationX(x)) {
            Printer.getInstance().InvalidValue();
            x = TicketManager.getInt("X");
        }

        long y = TicketManager.getLong("Y");
        while (validationY(y)) {
            Printer.getInstance().InvalidValue();
            y = TicketManager.getLong("Y");
        }

        Printer.getInstance().WriteLine("Вводится Venue");

        String name1 = TicketManager.getString("name");
        while (validationName(name1)) {
            Printer.getInstance().InvalidValue();
            name1 = TicketManager.getString("name");
        }

        int capacity = TicketManager.getInt("capacity");
        while (validationCapacity(capacity)) {
            Printer.getInstance().InvalidValue();
            capacity = TicketManager.getInt("capacity");
        }

        VenueType type1 = null;
        while (true){
            try{
                Printer.getInstance().WriteLine("Введите VenueType");
                for (VenueType VenueType: VenueType.values()) {
                    Printer.getInstance().Write("\t\t\t\t" + VenueType);
                }
                Printer.getInstance().WriteLine("");
                String next = Printer.getInstance().ReadLine();
                if(next.equals("null") || next.equals("")){
                    break;
                }
                type1 = VenueType.valueOf(next);
                break;
            }
            catch (Exception ignored){

            }
        }
        return new Ticket(name, new Coordinates(x,y), price, discount, type, new Venue(name1, capacity, type1));
    }
    public Venue GetVenue(){
        Printer.getInstance().WriteLine("Вводится Venue");

        String name1 = TicketManager.getString("name");
        while (validationName(name1)) {
            Printer.getInstance().InvalidValue();
            name1 = TicketManager.getString("name");
        }

        int capacity = TicketManager.getInt("capacity");
        while (validationCapacity(capacity)) {
            Printer.getInstance().InvalidValue();
            capacity = TicketManager.getInt("capacity");
        }

        VenueType type1 = null;
        while (true){
            try{
                Printer.getInstance().WriteLine("Введите VenueType");
                for (VenueType VenueType: VenueType.values()) {
                    Printer.getInstance().Write("\t\t\t\t" + VenueType);
                }
                Printer.getInstance().WriteLine("");
                String next = Printer.getInstance().ReadLine();
                if(next.equals("null") || next.equals("")){
                    break;
                }
                type1 = VenueType.valueOf(next);
                break;
            }
            catch (Exception ignored){

            }
        }
        return new Venue(name1, capacity, type1);
    }
    public boolean validationY(long y) {
        return y > 292;
    }
    public boolean validationX(int x){
        return false;
    }
    public boolean validationName(String s){
        return s == null || s.equals("");
    }
    public boolean validationPrice(int x){
        return x <= 0;
    }
    public boolean validationDiscount(int x){
        return x <= 0 || x > 100;
    }
    public boolean validationCapacity(int x){
        return x <= 0;
    }
}
