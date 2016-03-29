package fr.inria.testproject.context;

import java.util.List;

/**
 * Created by marcel on 23/02/14.
 * <p>
 * A class to test some coverage. In some method an "explosive" line is introduced
 * which will not be tested.
 */
public abstract class DataContextPlayGround {

    int field1;

    //A dummy Add procedure to test some logic branches
    public int arrayOfObjects(Object... values) {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) result++;
        }
        return values.length;
    }

    //A dummy Add procedure to test some logic branches
    public int arrayOfSerializables() {
        int result = 0;
        SerializableObject[] seris = new SerializableObject[10];
        for (int i = 0; i < seris.length; i++) {
            if (seris[i] != null) result++;
        }
        return seris.length;
    }

    //A dummy Add procedure to test some logic branches
    public int arrayOfNonSerializables() {
        Thread[] seris = new Thread[10];
        int result = 0;
        for (int i = 0; i < seris.length; i++) {
            if (seris[i] != null) result++;
        }
        return seris.length;
    }

    //A dummy procedure to test return types
    public int anIntMethod() {
        if (field1 != 0) {
            field1 = 0;
            return field1;
        }
        return field1++;
    }

    //------------------------ PRECONDITIONS TEST --------------------------
    //A dummy method to test if the precoditions sucessfully reject it because of an invalid method call
    private int callTheCallDontPass() {
        Thread seris = Thread.currentThread();
        if (seris.getId() > 0) return 1;
        else return 0;
    }

    //A dummy method to test if the precoditions sucessfully reject it
    private int callTheCallPass() {
        if (call().length > 0) return 1;
        else return 0;
    }

    //A private call allowed by the preconditions
    private Thread[] call() {
        Thread[] seris = new Thread[10];
        return seris;
    }
    //------------------------ PRECONDITIONS TEST --------------------------




    //------------------------ TYPE ATTRIBUTES --------------------------
    //A method that contains only primitive classes to test TypeAttributes
    public String containOnlyPrimitiveClasses(Double b, Integer a) {
        b = b * a;
        String s = b.toString();
        return s;
    }
    //A method to try the TypeAttribute detection of serializables
    public void containOnlySerializables(SerializableInterface b) {
        b.doSomething();
    }
    protected void containOnlyCollections(List<Integer> b) {
        b.clear();
    }
    public int containOnlyArrays(int[] b) {
        return b.length;
    }
    //------------------------ TYPE ATTRIBUTES --------------------------




    //------------------------ METHOD ATTRIBUTES --------------------------
    private int callPrivate(boolean k) {
        return callPrivate(k);
    }
    private int callPrivate() {
        return callPrivate();
    }

    public int callPublic(  boolean k ) {
        return callPublic(k);
    }
    protected int callProtected() {
        return callProtected();
    }
    //------------------------ METHOD ATTRIBUTES --------------------------




    //------------------------ DecoratorTransoformation ATTRIBUTES --------------------------
    private static int privateStaticMethod(int x) {
        if ( x > 100 ) return x;
        return privateStaticMethod(x + x * 90);
    }

    public int callStatic( int bb ) {
        return privateStaticMethod(bb);
    }

    public void callInvocations( boolean bb ) {
        if ( bb ) {
            callPrivate();
            callProtected();
            //callPublic();
        } else callProtected();
    }

    public void callInvocationsSomePublic( boolean bb ) {
        if ( bb ) {
            callPrivate(bb);
            callProtected();
            //callPublic();
        } else callPublic(bb);
    }

    protected abstract void protectedAbsctractMethod();

    public void callProtectedAbstractMethod( boolean bb ) {
        if ( bb ) {
            callPrivate();
            callProtected();
            //callPublic();
        } else protectedAbsctractMethod();
    }

    public int callPublicAbstractMethod(AbstractClass ac) {
        return ac.abstractMethod();
    }
    //------------------------ DecoratorTransoformation ATTRIBUTES --------------------------


    //------------------------ INJECTORS --------------------------
    //A dummy procedure to test the instrumentation of collection of serializabes
    public int collectionOfSerializables(List<SerializableObject> seris) {
        int result = 0;
        for (int i = 0; i < seris.size(); i++) {
            if (seris.get(i) != null) result++;
        }
        return result;
    }

    //A dummy procedure to test the instrumentation of class primitives of serializabes
    public int collectionOfClassPrimitives(List<Double> seris) {
        int result = 0;
        for (int i = 0; i < seris.size(); i++) {
            if (seris.get(i) != null) result++;
        }
        return result;
    }

    //A dummy Add procedure to test injection in a return whose parent is not a block
    public int singleReturn(int i, SerializableObject... values) {
        if (values[i] != null) i++;
        else return values.length;
        return i;
    }
    //------------------------ INJECTORS --------------------------

    //------------------------ INSTRUMENTATION CLEANER --------------------------
    //A dummy Add procedure to test some logic branches
    public int instrumentedStatements(Object... values) {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) result++;
            else { return 0; }
        }
        return values.length;
    }
    //------------------------ INSTRUMENTATION CLEANER --------------------------
}


