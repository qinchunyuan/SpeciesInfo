package cn.phoenix.clusteringfile.species.getMethod;

import cn.phoenix.clusteringfile.species.objects.*;

import java.util.List;

/**
 * Created by qincy on 2018-9-18.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Get all clusters information from .clustering file
         */
        GetAllClustersInfo getAllClustersInfo = new GetAllClustersInfo();
        List<ICluster> allClusters = getAllClustersInfo.getAllClusters(args[0]);

        /**
         * Get the specific species information from the all clusters LIST
         */
        GetSpeciesInfo getSpeciesInfo = new GetSpeciesInfo();
        getSpeciesInfo.getSpeciesinfo(allClusters, args[1]);

        /**
         * Statistics on the number of clusters

        CountAllClustersNum countAllClusters = new CountAllClustersNum();
        int clustersNum = countAllClusters.countClustersNum(allClusters);
         */
    }
}