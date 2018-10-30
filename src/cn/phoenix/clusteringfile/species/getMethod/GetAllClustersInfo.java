package cn.phoenix.clusteringfile.species.getMethod;

import cn.phoenix.clusteringfile.species.io.ClusteringFileReader;
import cn.phoenix.clusteringfile.species.io.IClusterSourceReader;
import cn.phoenix.clusteringfile.species.objects.ICluster;

import java.io.File;
import java.util.List;

/**
 * Created by qincy on 18-9-19.
 */
public class GetAllClustersInfo {

    public List<ICluster> getAllClusters(String filename) {

        File clustersFile = new File(filename);
        IClusterSourceReader reader = new ClusteringFileReader(clustersFile);
        List<ICluster> allClusters = null;
        try {
            allClusters = reader.readAllClusters();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allClusters;
    }
}
