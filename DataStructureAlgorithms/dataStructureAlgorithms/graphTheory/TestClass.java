package graphTheory;

//A Java Program to detect cycle in an undirected graph
import java.io.*;
import java.util.*;

//This class represents a directed graph using adjacency list
//representation
class TestClass{
	static int func(String str){
		int sum=0;
		for(int i=0; i<str.length();i++)
			for(int j=i+1; j<=str.length();j++){
				//System.out.println(str.substring(i,j));
				sum+=Integer.parseInt(str.substring(i,j));
				}
		//return sum;
		return (int) (sum%(1000000007));
	}
				    public static void main(String[] args)
				    {
				    	Scanner sc=new Scanner(System.in);
				        String str=sc.nextLine();
				        System.out.println(func(str.trim()));
				        
				    }
				}