package com.luv2code.springboot.cruddemo;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
		    for(int spaces=1;spaces<=n-i;spaces++) 
		    System.out.print(" ");
		    
		    for(int stars=1;stars<=(2*i-1);stars++)
		    System.out.print("*");
		    
		    System.out.println();
		}
	}
}
