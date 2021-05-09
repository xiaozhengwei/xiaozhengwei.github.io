# 单例模式

## **饿汉式**

**( 1 . 静态变量 )**

```java
//饿汉式(静态变量)
public class Singleton{

    //构造器私有化
    private Singleton(){
    }

    //本类内部创建对象实例
    private final static Singleton instance=new Singleton();

    //提供一个共有的静态方法,返回实例对象
    public static Singleton getInstance(){
        return instance;
    }

}
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

**( 2 . 静态代码块 )**

```java
//饿汉式(静态代码块)
public class Singleton{

    //构造器私有化
    private Singleton(){
    }

    //本类内部创建对象实例
    private final static Singleton instance;


    static {
        //在静态代码块中,创建单例模式
        instance=new Singleton();
    }

    //提供一个共有的静态方法,返回实例对象
    public static Singleton getInstance(){
        return instance;
    }

}
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

## **懒汉式**

**( 3. 最简单模式,线程不安全 )**

```java
//懒汉式(线程不安全)
public class Singleton{

    //构造器私有化
    private Singleton(){
    }

    //本类内部创建对象实例
    private static Singleton instance;

    //提供一个共有的静态方法,当使用到该方法时,采取创建实例
    public static Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }
}
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

**( 4 . 同步代码块,线程安全 )**

```
//懒汉式(线程安全,同步代码块)
public class Singleton {

    //构造器私有化
    private Singleton(){
    }

    //本类内部创建对象实例
    private static Singleton instance;

    //加入了同步代码块,解决线程不安全问题
    //提供一个共有的静态方法,当使用到该方法时,采取创建实例
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)



**( 5 . 同步方法,线程安全 )**

```java
//懒汉式(线程安全,同步方法)
public class Singleton {

    //构造器私有化
    private Singleton(){
    }

    //本类内部创建对象实例
    private static Singleton instance;

    //加入了同步代码,解决线程不安全问题
    //提供一个共有的静态方法,当使用到该方法时,采取创建实例
    public static synchronized Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }
}
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

## **枚举**

**( 6 . 枚举,线程安全 )**

```java
enum Singleton {
    INSTANCE;
}
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)



## **静态内部类**

**( 7. 静态内部类,线程安全 )**

```java
//静态内部类
public class Singleton {

    //构造器私有化
    private Singleton() {
    }

    //静态内部类
    private static class SingletonInstance{
        private static final Singleton INSTANCE=new Singleton();
    }


    //提供一个共有的静态方法,当使用到该方法时,返回实例
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

}
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

## **双重校验锁**

**( 8. 双重校验锁,线程安全 )**

```java
//双重校验锁(双重检查,线程安全)
public class Singleton {
    //构造器私有化
    private Singleton() {
    }

    //本类内部创建对象实例
    private static volatile Singleton instance;

    //加入了,解决线程不安全问题
    //提供一个共有的静态方法,当使用到该方法时,采取创建实例
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
```

![点击并拖拽以移动](data:image/gif;base64,R0lGODlhAQABAPABAP///wAAACH5BAEKAAAALAAAAAABAAEAAAICRAEAOw==)

 