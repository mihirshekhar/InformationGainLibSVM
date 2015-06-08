package prune.feature.csv;

import java.io.File;
import java.io.IOException;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.featureselection.ranking.RecursiveFeatureEliminationSVM;
import net.sf.javaml.featureselection.scoring.GainRatio;
import net.sf.javaml.tools.data.FileHandler;

public class RankFeature {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
        /* Load the iris data set */
        Dataset data = FileHandler.loadDataset(new File("/home/mihirshekhar/Desktop/Kaggle/Preprocessed_avg_pr.csv"), 18, ",");

        GainRatio ga = new GainRatio();
        /* Apply the algorithm to the data set */
        ga.build(data);
        /* Print out the score of each attribute */
        for (int i = 0; i < ga.noAttributes(); i++)
            System.out.println(i+"   "+ga.score(i));

	}

}
