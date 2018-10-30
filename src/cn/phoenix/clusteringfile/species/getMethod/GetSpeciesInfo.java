package cn.phoenix.clusteringfile.species.getMethod;

import cn.phoenix.clusteringfile.species.objects.ClusteringFileSpectrumReference;
import cn.phoenix.clusteringfile.species.objects.ICluster;
import cn.phoenix.clusteringfile.species.objects.ISpectrumReference;

import java.io.*;
import java.util.*;

/**
 * Created by qincy on 18-9-19.
 */
public class GetSpeciesInfo {

    public void getSpeciesinfo(List<ICluster> allClusters, String infoStorageFile){

        Iterator<ICluster> itr = allClusters.iterator();
        while (itr.hasNext()) {
            ICluster cluster = itr.next();
            String cluster_id = cluster.getId();
            int cluster_size = cluster.getSpecCount();
            float cluster_ratio = cluster.getRatio();
            String species_Info = null;
            Map species_no = new HashMap();
            int speciesNum = 0;
            List<String> speciesList = new ArrayList();
            Map map = new HashMap();

            /**
             * 取出每个cluster里面的spec的信息
             */
            List<ISpectrumReference> allSpectrum = cluster.getSpectrumReferences();
            Iterator<ISpectrumReference> specItr = allSpectrum.iterator();
            for(int i = 0; i < allSpectrum.size(); i++) {

                String value = null;
                ClusteringFileSpectrumReference ISpec = (ClusteringFileSpectrumReference) specItr.next();
                value = ISpec.getSpecies();
                speciesList.add(value);
            }

            for(String s : speciesList) {
               Integer count = (Integer) map.get(s);
               map.put(s, (count == null) ? 1 : count +1);
            }
            species_no = map;
            speciesNum = map.size();

            if (species_no.size() != 1) {
                Iterator<String> it = species_no.keySet().iterator();
                while(it.hasNext()) {
                    String key = it.next();
                    String value = species_no.get(key).toString();
                    if (species_Info == null ) {
                        species_Info = key + "=" + value;
                    }else {
                        species_Info = species_Info + "|" + key + "=" + value;
                    }

                }

                try {
                    //File csv = new File("/home/ubuntu/getSpeciesInfo_clusteringFile/src/Data/0719_1.csv");//CSV文件
                    File csv = new File(infoStorageFile);
                    BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
                    //新增一行数据
                    bw.newLine();
                    bw.write(cluster_id + ";" + cluster_size + ";" + cluster_ratio + ";" + speciesNum +";"+ species_Info);
                    bw.close();
                } catch (FileNotFoundException e) {
                    //捕获File对象生成时的异常
                    e.printStackTrace();
                } catch (IOException e) {
                    //捕获BufferedWriter对象关闭时的异常
                    e.printStackTrace();
                }
            }
        }


    }
}
