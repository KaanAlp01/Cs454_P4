package Classification.Regressor;

import Classification.Instance.Instance;
import Classification.InstanceList.InstanceList;
import Classification.Parameter.Parameter;

public abstract class Regressor {


    public abstract void train(InstanceList trainSet, Parameter parameter);
}
