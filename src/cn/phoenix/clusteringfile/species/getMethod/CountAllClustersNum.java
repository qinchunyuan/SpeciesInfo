package cn.phoenix.clusteringfile.species.getMethod;

import cn.phoenix.clusteringfile.species.objects.ICluster;

import java.util.List;

/**
 * Created by ubuntu on 18-9-19.
 */
public class CountAllClustersNum {

    public int countClustersNum(List<ICluster> allClusters) {
        /**
         * Statistics on the number of clusters
         */
        int clustersNum = allClusters.size();
        return clustersNum;
    }
}
