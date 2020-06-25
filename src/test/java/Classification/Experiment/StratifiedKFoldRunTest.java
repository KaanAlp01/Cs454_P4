package Classification.Experiment;

import Classification.Classifier.*;
import Classification.DistanceMetric.EuclidianDistance;
import Classification.Parameter.*;
import Classification.Performance.ExperimentPerformance;
import org.junit.Test;

import static org.junit.Assert.*;

public class StratifiedKFoldRunTest extends ClassifierTest {

    @Test
    public void testExecute() throws DiscreteFeaturesNotAllowed {
        StratifiedKFoldRun stratifiedKFoldRun = new StratifiedKFoldRun(10);
        ExperimentPerformance experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new C45(), new C45Parameter(1, true, 0.2), iris));
        assertEquals(6.67, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new C45(), new C45Parameter(1, true, 0.2), tictactoe));
        assertEquals(20.27, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new Knn(), new KnnParameter(1, 3, new EuclidianDistance()), bupa));
        assertEquals(37.11, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new Knn(), new KnnParameter(1, 3, new EuclidianDistance()), dermatology));
        assertEquals(10.42, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new Lda(), new Parameter(1), bupa));
        assertEquals(31.32, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new Lda(), new Parameter(1), dermatology));
        assertEquals(3.01, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new LinearPerceptron(), new LinearPerceptronParameter(1, 0.1, 0.99, 0.2, 100), iris));
        assertEquals(4.67, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new LinearPerceptron(), new LinearPerceptronParameter(1, 0.1, 0.99, 0.2, 100), dermatology));
        assertEquals(2.15, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new NaiveBayes(), new Parameter(1), car));
        assertEquals(14.11, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new NaiveBayes(), new Parameter(1), nursery));
        assertEquals(9.70, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new Bagging(), new BaggingParameter(1, 50), tictactoe));
        assertEquals(3.34, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new Bagging(), new BaggingParameter(1, 50), car));
        assertEquals(5.67, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new Dummy(), new Parameter(1), nursery));
        assertEquals(66.67, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
        experimentPerformance = stratifiedKFoldRun.execute(new Experiment(new Dummy(), new Parameter(1), iris));
        assertEquals(66.67, 100 * experimentPerformance.meanPerformance().getErrorRate(), 0.01);
    }
}