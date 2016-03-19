package org.interview.puzzles.main;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * calculate a sum of a function across the entire range, where the function
 * returns the product of the *preceding* C elements.
 * @author rithvikgopishelke
 *
 */
public class SumOfProductOfPrecedingElements {

	
	public static void main(String[] args){
		//if(args.length == 2){
			Integer limit = new Integer(100);
			Integer preceedingElement = new Integer(10);
			System.out.println("The range is:" + limit);
			System.out.println("The preceeding element val is:" + preceedingElement);
			Optional<BigInteger> result = 
			sumOfProductsOfConsecutivePrecedingElements(limit, preceedingElement);
			printResults(result);
			System.out.println("------------------------");
			limit = new Integer(1000000);
			preceedingElement = new Integer(200);
			System.out.println("The range is:" + limit);
			System.out.println("The preceeding element val is:" + preceedingElement);
			result = 
			sumOfProductsOfConsecutivePrecedingElements(limit, preceedingElement);
			printResults(result);
			System.out.println("------------------------");
		//}else{
		//	System.out.println("Usage: ProductForPrecedingElements <N-Range> <C-PreceedingElement>");
	//	}
	}

	/**
	 * 
	 * @param result
	 */
	private static void printResults(Optional<BigInteger> result) {
		if(result.get().toString().length() > 10){
			System.out.println("Result:"+ result.get().toString().substring(0, 10));
		}else{
			System.out.println("Result: "+ result.get());
		}
	}

	/**
	 * 
	 * @param limit
	 * @param preceedingElement
	 * @return
	 */
	public static Optional<BigInteger> sumOfProductsOfConsecutivePrecedingElements(Integer limit,
			Integer preceedingElement) {
		return IntStream.rangeClosed(1, limit).parallel().mapToObj(x-> {
			//System.out.println(x);
			if(x == 1){
		        //Keep as is since this is the first element
		       //System.out.println("0\n");
		        return BigInteger.ZERO;
		      }else if(x <=preceedingElement){
		    	  //If there are less than C previous elements, just use the available numbers.
		    	  BigInteger subListResult = IntStream.range(1,x).parallel().mapToObj(BigInteger::valueOf).reduce((a,b)-> a.multiply(b)).get();
		        //System.out.println(subListResult+"\n");
		        return subListResult;
		      }
		      else {
		    	  //calculate the product using only the preceding numbers when the current index is larger than the preceding number.
		    	  BigInteger anotherList = IntStream.range((x-preceedingElement), x).parallel().mapToObj(BigInteger::valueOf).
		    			  reduce((a,b)-> a.multiply(b)).get();
		    	  //System.out.println(anotherList+"\n");
		    	  return anotherList;
		      }
		      }
				).reduce((a,b)-> a.add(b));
	}
}