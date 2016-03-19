package org.interview.puzzles.test;

import java.math.BigInteger;
import java.util.Optional;

import org.interview.puzzles.main.SumOfProductOfPrecedingElements;
import org.junit.Assert;
import org.junit.Test;
public class SumOfProductOfPrecedingElementsTest {

	@Test(expected=NullPointerException.class)
	public void testWithNullArgument(){
		Long start = System.currentTimeMillis();
		SumOfProductOfPrecedingElements.sumOfProductsOfConsecutivePrecedingElements(null, null);
		Long end = System.currentTimeMillis();
		System.out.println("null - null :"+(end-start));
	}

	@Test
	public void testWithRequest5And2(){
		Long start = System.currentTimeMillis();
		Optional<BigInteger> result = SumOfProductOfPrecedingElements.sumOfProductsOfConsecutivePrecedingElements(5, 2);
		Long end = System.currentTimeMillis();
		Assert.assertNotNull(result);
		Assert.assertEquals(new BigInteger("21"), result.get());
		System.out.println("5   -   2  :"+(end-start));
	}

	@Test
	public void testWithInitialRequest6And2(){
		Long start = System.currentTimeMillis();
		Optional<BigInteger> result = SumOfProductOfPrecedingElements.sumOfProductsOfConsecutivePrecedingElements(6, 2);
		Long end = System.currentTimeMillis();
		Assert.assertNotNull(result);
		Assert.assertEquals(new BigInteger("41"), result.get());
		System.out.println("6   -   2  :"+(end-start));
	}

	@Test
	public void testWithInitialRequest7And2(){
		Long start = System.currentTimeMillis();
		Optional<BigInteger> result = SumOfProductOfPrecedingElements.sumOfProductsOfConsecutivePrecedingElements(7, 2);
		Long end = System.currentTimeMillis();
		Assert.assertNotNull(result);
		Assert.assertEquals(new BigInteger("71"), result.get());
		System.out.println("7   -   2  :"+(end-start));
	}

	@Test
	public void testWithInitialRequest7And3(){
		Long start = System.currentTimeMillis();
		Optional<BigInteger> result = SumOfProductOfPrecedingElements.sumOfProductsOfConsecutivePrecedingElements(7, 3);
		Long end = System.currentTimeMillis();
		Assert.assertNotNull(result);
		Assert.assertEquals(new BigInteger("213"), result.get());
		System.out.println("7   -   3  :"+(end-start));
	}

	@Test
	public void testWithInitialRequest100And10(){
		Long start = System.currentTimeMillis();
		Optional<BigInteger> result = SumOfProductOfPrecedingElements.sumOfProductsOfConsecutivePrecedingElements(100, 10);
		Long end = System.currentTimeMillis();
		Assert.assertNotNull(result);
		Assert.assertEquals("5139462350", result.get().toString().substring(0, 10));
		System.out.println("100   -   10  :"+(end-start));
	}

	@Test
	public void testWithInitialRequest1000000And200(){
		Long start = System.currentTimeMillis();
		Optional<BigInteger> result = SumOfProductOfPrecedingElements.sumOfProductsOfConsecutivePrecedingElements(1000000, 200);
		Long end = System.currentTimeMillis();
		Assert.assertNotNull(result);
		Assert.assertEquals("4876116127", result.get().toString().substring(0, 10));
		System.out.println("1000000 -   200:"+(end-start));
	}
	
	@Test
	public void testWithInitialRequest10000000And200(){
		Long start = System.currentTimeMillis();
		Optional<BigInteger> result = SumOfProductOfPrecedingElements.sumOfProductsOfConsecutivePrecedingElements(10000000, 200);
		Long end = System.currentTimeMillis();
		Assert.assertNotNull(result);
		Assert.assertEquals("4965134354", result.get().toString().substring(0, 10));
		System.out.println("10000000 - 200:"+(end-start));
	}
}
