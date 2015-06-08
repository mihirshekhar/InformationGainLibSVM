package com.cde.mihir.infogain;

import java.io.IOException;

public class Test_Main {

	private static String libSVMFile="/home/mihirshekhar/Desktop/FinalVocab/Null_OutputFeatureFiles/wiki/1.txt";

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//ReadLibSVMFile rlbf = new ReadLibSVMFile("/home/mihirshekhar/Desktop/FinalVocab/Null_OutputFeatureFiles/sem/test.libsvm");
	   // rlbf.extractClassDistribution();
		CalculateGainValue cgv = new CalculateGainValue(libSVMFile);
		cgv.CalculateGainRatio();
		
		
	
	}

}
