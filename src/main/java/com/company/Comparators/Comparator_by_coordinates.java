package com.company.Comparators;

import com.company.Models.Ticket;

import java.util.Comparator;

public class Comparator_by_coordinates implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getCoordinates().compareTo(o2.getCoordinates());
    }
}
