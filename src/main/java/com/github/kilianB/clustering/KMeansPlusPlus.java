package com.github.kilianB.clustering;

import java.util.DoubleSummaryStatistics;
import java.util.Random;

import com.github.kilianB.ArrayUtil;
import com.github.kilianB.clustering.distance.DistanceFunction;
import com.github.kilianB.pcg.fast.PcgRSFast;

/**
 * @author Kilian
 *
 */
public class KMeansPlusPlus extends KMeans {

	/**
	 * Create a KMeans clusterer with k clusters and EuclideanDistance.
	 * 
	 * @param clusters the number of cluster to partition the data into
	 */
	public KMeansPlusPlus(int clusters) {
		super(clusters);
	}
	
	/**
	 * Create a KMeans clusterer
	 * 
	 * @param clusters the number of cluster to partition the data into
	 * @param distanceFunction the distanceFunction used to compute the distance between data points
	 */
	public KMeansPlusPlus(int clusters, DistanceFunction distanceFunction) {
		super(clusters, distanceFunction);
	}

	@Override
	protected DoubleSummaryStatistics[][] computeStartingClusters(double[][] data, int k, int dataDimension) {

		// Fast high quality rng
		Random rng = new PcgRSFast();

		DoubleSummaryStatistics[][] clusterMeans = new DoubleSummaryStatistics[k][dataDimension];

		ArrayUtil.fillArrayMulti(clusterMeans, () -> {
			return new DoubleSummaryStatistics();
		});

		// Randomly choose a starting point. Initial vector
		int clusterStart = rng.nextInt(data.length);

		for (int i = 0; i < dataDimension; i++) {
			clusterMeans[0][i].accept(data[clusterStart][i]);
		}

		for (int cluster = 1; cluster < k; cluster++) {

			// Choose a random cluster center with probability equal to the squared distance
			// of the closest existing center
			double[] distance = new double[data.length];
			ArrayUtil.fillArray(distance, () -> {
				return Double.MAX_VALUE;
			});

			double sum = 0;

			// For each point
			for (int i = 0; i < data.length; i++) {

				// find the minimum distance to all already existing clusters
				for (int j = 0; j < cluster; j++) {
					double distTemp = distanceFunction.distanceSquared(clusterMeans[0], data[i]);
					if (distTemp < distance[i]) {
						distance[i] = distTemp;
					}
				}
				sum += distance[i];
			}

			int index = 0;
			double rand = rng.nextDouble() * sum;
			double runningSum = distance[0];
			for (; index < data.length; index++) {
				if (rand <= runningSum) {
					break;
				}
				runningSum += distance[index];
			}

			for (int i = 0; i < dataDimension; i++) {
				clusterMeans[cluster][i].accept(data[cluster][i]);
			}
		}
		return clusterMeans;
	}

	public static void main(String[] args) {

//		double[][] data = { { 1d, 2d, 3d, 4d }, { 1d, 6d, 8d, 8d }, { 1d, 2d, 3d, 3d }, { 2d, 4d, 5d, 5d },
//				{ 4d, 7d, 8d, 7d }, { 7d, 6d, 8d, 9d }, { 4d, 4d, 3d, 3d }, { 2d, 2d, 5d, 5d }, { 7d, 5d, 5d, 5d },
//				{ 5d, 6d, 8d, 9d } };

		int vars = 5;
		double[][] data = new double[2000][vars];

		Random rng = new PcgRSFast();
		for (int i = 0; i < 2000; i++) {
			for (int j = 0; j < vars; j++) {
				data[i][j] = rng.nextInt(20);
			}
		}

		for(int i = 0; i < 10; i++) {
			new KMeansPlusPlus(4).cluster(data).printInformation();;
			new KMeans(4).cluster(data).printInformation();;
		}
	}

}
