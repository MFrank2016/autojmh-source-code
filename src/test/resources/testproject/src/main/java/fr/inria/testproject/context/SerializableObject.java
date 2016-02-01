package fr.inria.testproject.context;

/**
 * Created by marcel on 23/02/14.
 *
 * A class to test some coverage. In some method an "explosive" line is introduced
 * which will not be tested.
 *
*/
public class SerializableObject implements SerializableInterface {

    int values;

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }
}