package cn.phoenix.clusteringfile.species.io;


import cn.phoenix.clusteringfile.species.objects.ICluster;

/**
 * Created by jg on 10.07.14.
 */
public interface IClusterSourceListener {
    public void onNewClusterRead(ICluster newCluster);
}
