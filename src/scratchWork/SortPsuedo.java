package scratchWork;

public class SortPsuedo {
	package edu.sdsu.cs;

	/**
	 * Created by gageparaiso on 4/4/17.
	 */
	public class pokemon {
	    //Parse in data/csv

	    //make each pokemon in csv a class???
	    //add indicy to end of the parsed data
	    //named "counter"
	    //add another indicy to end called "based stats"

	    based stats indicy = summation of values in the stats indicies
	    //sort max to min (im thinking HEAP sort) of based stats indicy

	    //create function called resistance pt 1 which essentially sets the counter value comparing Input type 1 to csv type 1
	    if (input type 1 indicy = fire)
	        if (CSV type 1 = water)
	            counter = counter +1
	        else if (CSV type 1 = grass)
	            counter = counter - 2 //can make more extreme change
	        else if (CSV type 1 = electric)
	            counter = counter

	    if (input type 1 indicy = water)
	            if (CSV type 1 = fire)
	                counter = counter - 2
	            else if (CSV type 1 = grass)
	                counter = counter + 1
	            else if (CSV type 1 = steel)
	                counter = counter


	    //create function called resistance pt 2 which essentially sets the counter value comparing Input type 1 to csv type 2
	    if (input type 1 indicy = fire)
	            if (CSV type 2 = water)
	                counter = counter +1
	            else if (CSV type 2 = grass)
	                counter = counter - 2 //can make more extreme change
	            else if (CSV type 2 = electric)
	                counter = counter

	    if (input type 1 indicy = water)
	            if (CSV type 2 = fire)
	                counter = counter - 2
	            else if (CSV type 2 = grass)
	                counter = counter + 1
	            else if (CSV type 2 = steel)
	                counter = counter


	    //create function called resistance part 3 which sets the counter value comparing Input type 2 to to csv type 1

	    if (input type 2 indicy = null)
	        counter = counter  //maybe can write return

	    else if (input type 2 indicy = fire)
	            if (CSV type 1 = water)
	                counter = counter +1
	            else if (CSV type 1 = grass)
	                counter = counter - 2 //can make more extreme change
	            else if (CSV type 1 = electric)
	                counter = counter

	    else if (input type 2 indicy = water)
	            if (CSV type 1 = fire)
	                counter = counter - 2
	            else if (CSV type 1 = grass)
	                counter = counter + 1
	            else if (CSV type 1 = steel)
	                 counter = counter


	    //create function called resistance part 4 which sets the counter value comparing input type 2 to csv type 2

	    if (input type 2 indicy = null)
	    counter = counter  //maybe can write return

	    else if (input type 2 indicy = fire)
	            if (CSV type 2 = water)
	    counter = counter +1
	            else if (CSV type 2 = grass)
	    counter = counter - 2 //can make more extreme change
	            else if (CSV type 2 = electric)
	    counter = counter

	    else if (input type 2 indicy = water)
	            if (CSV type 2 = fire)
	    counter = counter - 2
	            else if (CSV type 2 = grass)
	    counter = counter + 1
	            else if (CSV type 2 = steel)
	    counter = counter





	    //cycle through CSV aka Pokemon (which now all have their own class)
	    //calling the resistance functions on each class aka each pokemon
	    //output based on counter value
	    //DONE
	}

}
