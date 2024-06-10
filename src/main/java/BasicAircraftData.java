// TODO: include Class docstring.

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class BasicAircraftData {

    protected HashMap<Integer, List<Float>> armsData = new HashMap<>();
    protected HashMap<Integer, List<Float>> momentLimits = new HashMap<>();
    protected HashMap<Integer, List<Float>> cgLimits = new HashMap<>();
    protected List<Integer> weights = Arrays.asList(1500, 1600, 1700, 1800, 1950, 2000, 2100, 2200, 2300);
    private final int size = weights.size();

    private HashMap<Integer, List<Float>> setArmsData() {
        armsData.put(1, Arrays.asList(37.0f, 37.0f, 73.0f, 73.0f, 95.0f, 123.0f));
        armsData.put(2, Arrays.asList(37.0f, 37.0f, 73.0f, 73.0f, 96.0f, 123.0f));
        return armsData;
    }

    private HashMap<Integer, List<Float>> setMomentLimits() {
        List<Float> minMoments = Arrays.asList(52.5f, 55.9f, 59.3f, 62.8f, 67.9f, 71.0f, 77.0f, 82.7f, 88.5f);
        List<Float> maxMoments = Arrays.asList(70.0f, 75.0f, 80.0f, 84.8f, 92.0f, 94.5f, 99.4f, 104.0f, 109.0f);
        for (int i = 0; i < size; i++) {
            Float[] limits = {minMoments.get(i), maxMoments.get(i)};
            momentLimits.put(weights.get(i), Arrays.asList(limits));
        }
        return momentLimits;
    }

    private HashMap<Integer, List<Float>> setCGLimits() {
        List<Float> minCG = Arrays.asList(35.0f, 35.0f, 35.0f, 35.0f, 35.0f, 35.5f, 36.5f, 37.5f, 38.5f);
        List<Float> maxCG = Arrays.asList(47.2f, 47.2f, 47.2f, 47.2f, 47.2f, 47.2f, 47.2f, 47.2f, 47.2f);
        for (int i = 0; i < size; i++) {
            Float[] momentLimits = {minCG.get(i), maxCG.get(i)};
            cgLimits.put(weights.get(i), Arrays.asList(momentLimits));
        }
        return cgLimits;
    }

    public HashMap<String, HashMap<Integer, List<Float>>> loadBasicAircraftData() {
        HashMap<String, HashMap<Integer, List<Float>>> basicAircraftData = new HashMap<>();
        basicAircraftData.put("armsData", setArmsData());
        basicAircraftData.put("momentLimits", setMomentLimits());
        basicAircraftData.put("cgLimits", setCGLimits());
        return basicAircraftData;
    }
}
