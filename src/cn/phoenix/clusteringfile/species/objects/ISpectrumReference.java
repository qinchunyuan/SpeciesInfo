package cn.phoenix.clusteringfile.species.objects;

import java.util.List;

/**
 * Created by jg on 01.08.14.
 */
public interface ISpectrumReference {
    public String getSpectrumId();

    public float getPrecursorMz();

    //public int getCharge();
    public float getCharge();

    public float getSimilarityScore();

    public String getSpecies();

    public boolean isIdentifiedAsMultiplePeptides();

    public boolean isIdentified();

    public String getSequence();

    public IPeptideSpectrumMatch getMostCommonPSM();

    public List<IPeptideSpectrumMatch> getPSMs();

    public boolean hasPeaks();

    public List<ClusteringFileSpectrumReference.Peak> getPeaks();

    public void addPeaksFromString(String mzString, String intensityString) throws Exception;
}
