package com.cde.mihir.calculatetopFeatures;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import com.cde.mihir.infogain.Attribute;
import com.cde.mihir.infogain.CalculateGainValue;

/**
 * Specialised for our features
 * @author mihirshekhar
 *
 */
public class TopFeatures {
	
	private String inputFolder;
	private int noOfFeatures;
	private double percentDistribution[]= {.12,.12,.12,.12,.12,.20,.20};
	private TreeMap<Integer,Integer>hash;
	private ArrayList<Attribute>arr1;
	private ArrayList<Attribute>arr2;
	private ArrayList<Attribute>arr3;
	private ArrayList<Attribute>arr4;
	private ArrayList<Attribute>arr5;
	private ArrayList<Attribute>arr01;
	private ArrayList<Attribute>arr_multiclass;
    int maxLineToRead ;
	public TopFeatures(String inputFolder, int noOfFeatures,
			double[] percentDistribution) throws IOException {
		super();
		this.inputFolder = inputFolder;
		this.noOfFeatures = noOfFeatures;
		this.percentDistribution = percentDistribution;
		this.maxLineToRead = Integer.MAX_VALUE;
		
		initialiseArrayList();
		
	}
	public TopFeatures(String inputFolder, int noOfFeatures,
			double[] percentDistribution,int maxLineToRead) throws IOException {
		super();
		this.inputFolder = inputFolder;
		this.noOfFeatures = noOfFeatures;
		this.percentDistribution = percentDistribution;
		this.maxLineToRead = maxLineToRead;
		initialiseArrayList();
	}
	
	public TreeSet<Integer> CreateTopFeaturesSet()
	{
		TreeSet< Integer>set = new TreeSet<Integer>();
	    for(int i=0;i<(int)(percentDistribution[0]*(double)noOfFeatures);i++)
	    {
	    	set.add(arr1.remove(0).getId());
	    }
	    for(int i=0;i<(int)(percentDistribution[1]*(double)noOfFeatures);i++)
	    {
	    	set.add(arr2.remove(0).getId());
	    }
	    for(int i=0;i<(int)(percentDistribution[2]*(double)noOfFeatures);i++)
	    {
	    	set.add(arr3.remove(0).getId());
	    }
	    for(int i=0;i<(int)(percentDistribution[3]*(double)noOfFeatures);i++)
	    {
	    	set.add(arr4.remove(0).getId());
	    }
	    for(int i=0;i<(int)(percentDistribution[4]*(double)noOfFeatures);i++)
	    {
	    	set.add(arr5.remove(0).getId());
	    }
	    for(int i=0;i<(int)(percentDistribution[5]*(double)noOfFeatures);i++)
	    {
	    	set.add(arr01.remove(0).getId());
	    }
	    for(int i=0;i<(int)(percentDistribution[6]*(double)noOfFeatures);i++)
	    {
	    	set.add(arr_multiclass.remove(0).getId());
	    }
	    System.out.println("Number of Features: "+set.size());
	    int t=0;
	    while(set.size()<=noOfFeatures)
	    {
	    	if(++t%7==1)
	    	{
	    		set.add(arr1.remove(0).getId());
	    	}
	    	else if(++t%7==2)
	    	{
	    		set.add(arr2.remove(0).getId());
	    	}
	    	else if(++t%7==3)
	    	{
	    		set.add(arr3.remove(0).getId());
	    	}else if(++t%7==4)
	    	{
	    		set.add(arr4.remove(0).getId());
	    	}else if(++t%7==5)
	    	{
	    		set.add(arr5.remove(0).getId());
	    	}else if(++t%7==6)
	    	{
	    		set.add(arr01.remove(0).getId());
	    	}
	    	else
	    	{
	    		++t;
	    		set.add(arr_multiclass.remove(0).getId());
	    	}
	    }
	    
		return set;
	}
	
	
	private void initialiseArrayList() throws IOException {
		
		String path1 = inputFolder+File.separator+"1.txt";
		String path2 = inputFolder+File.separator+"2.txt";
		String path3 = inputFolder+File.separator+"3.txt";
		String path4 = inputFolder+File.separator+"4.txt";
		String path5 = inputFolder+File.separator+"5.txt";
		String path01 = inputFolder+File.separator+"01.txt";
		String pathMultiClass = inputFolder+File.separator+"multiclass.txt";
        arr1 = getGainRatio(path1);
        System.out.println("Gain Ratio for file "+ path1+" completed");
        arr2 = getGainRatio(path2);
        System.out.println("Gain Ratio for file "+ path2+" completed");

        arr3 =getGainRatio(path3);
        System.out.println("Gain Ratio for file "+ path3+" completed");

        arr4 = getGainRatio(path4);
        System.out.println("Gain Ratio for file "+ path4+" completed");

        arr5 = getGainRatio(path5);
        System.out.println("Gain Ratio for file "+ path5+" completed");

        arr01 = getGainRatio(path01);
        System.out.println("Gain Ratio for file "+ path01+" completed");
        arr_multiclass = getGainRatio(pathMultiClass);
        System.out.println("Gain Ratio for file "+ pathMultiClass+" completed");

		
	}

	private ArrayList<Attribute> getGainRatio(String path) throws IOException {
		CalculateGainValue cgv = new CalculateGainValue(path,maxLineToRead);
		cgv.CalculateGainRatio();
		return   cgv.getAttr_list();
	}

	
	

}
