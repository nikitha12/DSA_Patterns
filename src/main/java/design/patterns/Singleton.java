package design.patterns;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Singleton {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SingletonPreventReflection singletonTest = new SingletonPreventReflection();
        SingletonPreventReflection I1 = singletonTest.getInstance();

        SingletonPreventReflection I2 = singletonTest.getInstance();
        System.out.println(I1==I2);

        // Using reflection to create instance using private constructor
        Constructor<?> constructor = SingletonPreventReflection.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object instance = constructor.newInstance();

    }
}

// Lazy impl
class SingletonLazy {
    public static SingletonLazy INSTANCE;

    private SingletonLazy() {
    }

    public static synchronized SingletonLazy getInstance(){
        if(INSTANCE==null){
            INSTANCE = new SingletonLazy();
        }
        return INSTANCE;
    }
}

// Thread Safe but not good performance Impl
class SingletonThreadSafe {
    public static SingletonThreadSafe INSTANCE;

    private SingletonThreadSafe() {
    }

    public static synchronized SingletonThreadSafe getInstance(){
        if(INSTANCE==null){
            INSTANCE = new SingletonThreadSafe();
        }
        return INSTANCE;
    }
}

// Thread safe and better performance impl
class SingletonDoubleCheck {
    public static volatile SingletonDoubleCheck INSTANCE;

    private SingletonDoubleCheck() {
    }

    public static SingletonDoubleCheck getInstance(){
        if(INSTANCE==null){
            synchronized (SingletonDoubleCheck.class){
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDoubleCheck();
                }
            }
        }
        return INSTANCE;
    }
}

class SingletonBigPugh{

    private SingletonBigPugh() {
    }

    private static final class InstanceHolder {
        public static final SingletonBigPugh INSTANCE = new SingletonBigPugh();
    }

    public static SingletonBigPugh getInstance(){
        return InstanceHolder.INSTANCE;
    }
}

class SingletonPreventReflection {
    public static volatile SingletonPreventReflection INSTANCE;

    SingletonPreventReflection() {
        if(INSTANCE!=null){
            throw new RuntimeException("Use getInstance() method to create");
        }
        System.out.println("Instance initialised");
    }

    public static SingletonPreventReflection getInstance(){
        if(INSTANCE==null){
            synchronized (SingletonPreventReflection.class){
                if (INSTANCE == null) {
                    INSTANCE = new SingletonPreventReflection();
                }
            }
        }
        return INSTANCE;
    }
}