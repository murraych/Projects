package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CigarPartyTests {

    /*
     cigarParty(30, false) → false
     cigarParty(50, false) → true
     cigarParty(70, true) → true
     */
    @Test
    public void RangeOfValuesForWeekendTests() {

        //Arrange
        CigarParty party = new CigarParty();

        //Assert
        //Good Parties
        assertEquals(true, party.haveParty(40, true));
        assertEquals(true, party.haveParty(60, true));
        assertEquals(true, party.haveParty(80, true));

        //Bad Parties
        assertEquals(false, party.haveParty(39, true));
    }

    @Test
    public void RangeOfValuesForWeekdayTests() {

        //Arrange
        CigarParty party = new CigarParty();

        //Assert
        //Good Parties
        assertEquals(true, party.haveParty(40, false));
        assertEquals(true, party.haveParty(60, false));

        //Bad Parties
        assertEquals(false, party.haveParty(39, false));
        assertEquals(false, party.haveParty(61, false));

    }

}