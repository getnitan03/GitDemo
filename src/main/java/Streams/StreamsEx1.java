package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class StreamsEx1 {
	
	public ArrayList<String> AL;
	@BeforeTest
	public void CreateArrayList() {
		AL = new ArrayList<String>();
		AL.add("One");
		AL.add("Two");
		AL.add("AP3");
		AL.add("Three");
		AL.add("AP1");
		AL.add("Four");
		AL.add("AP2");
	
	}
	/*
	@Test
	public void StreamFilter() {
	Long val = AL.stream().filter(s->s.startsWith("A")).count();
	AL.stream().filter(s->s.startsWith("A")).forEach(s->System.out.println(s));
	System.out.println(val);
	
	AL.stream().filter(s->s.startsWith("T")).map(s->s.toLowerCase()).forEach(s->System.out.println(s));

	}*/
	/*
	@Test
	public void StreamFilterSorted() {
		AL.stream()
		.filter(s->s.startsWith("A") || s.startsWith("T"))
		.sorted()
		.forEach(s->System.out.println(s));
		
	}*/
	/*
	@Test
	public void StreamMatch() {
		System.out.println(AL.stream().anyMatch(s->s.equalsIgnoreCase("onee")));
	}*/
	/*
	@Test
	public void CollectMethod() {
		List<String> RL = AL.stream().filter(s->s.startsWith("A")).collect(Collectors.toList());
		System.out.println(RL);
	}*/
	
	@Test
	public void ArrayProblem() {
		List<Integer> numArray = Arrays.asList(5,23,67,90,1,5,20,4,1,23,80,1,78);
		//Print Unique numbers in sorted order
		List<Integer> RS =  numArray.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(RS);
		
		//numArray.stream().sorted().forEach(s->System.out.println(s));
	}
}
