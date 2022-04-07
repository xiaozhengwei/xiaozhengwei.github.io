# AbstractQueuedSynchronizer



## 核心属性

- volatile Node head

  ```
  等待队列的头部，延迟初始化。除初始化外，只能通过 setHead 方法进行修改。
  注意：如果head存在，它的waitStatus保证不会被CANCELLED。
  ```

- volatile Node tail

  ```
  等待队列的尾部，延迟初始化。仅通过方法 enq 修改以添加新的等待节点。
  ```

- volatile int state

  ```
  同步状态,根据该字段的值进行状态的同步。
  ```

- transient Thread exclusiveOwnerThread

  ```
  独占模式同步的当前所有者。
  ```



## 对外开放接口

### boolean tryAcquire(int arg)

  ```
  尝试以独占模式获取。此方法应查询对象的状态是否允许以独占模式获取它，如果允许则获取它
  此方法始终由执行获取的线程调用
  如果此方法报告失败，如果线程尚未排队，则获取方法可以将线程排队，直到其他线程发出释放信号
  这可用于实现方法Lock.tryLock() 
  ```

### boolean tryRelease(int arg)

  ```
  尝试设置状态以反映独占模式下的发布
  该方法总是由执行释放的线程调用
  ```

### int tryAcquireShared(int arg)

  ```
  尝试以共享模式获取。此方法应查询对象的状态是否允许以共享模式获取它，如果允许则获取它
  此方法始终由执行获取的线程调用
  如果此方法报告失败，如果该线程尚未排队，则获取方法可以将该线程排队，直到由某个其他线程的释放发出信号
  ```

### boolean tryReleaseShared(int arg)

  ```
  尝试设置状态以反映共享模式下的发布
  该方法总是由执行释放的线程调用
  ```

### boolean isHeldExclusively()

  ```
  如果同步仅针对当前（调用）线程进行，则返回true
  每次调用非等待AbstractQueuedSynchronizer.ConditionObject方法时都会调用此方法
  等待方法改为调用release
  ```



## 父类

### AbstractOwnableSynchronizer

```java
abstract class AbstractOwnableSynchronizer{
	//表示当前占用该锁的线程 
	private transient Thread exclusiveOwnerThread;
}
```



## 辅助类

### Node

  ```java
  static final class Node {
      
      // 指示节点在共享模式下等待的标记
      static final Node SHARED = new Node();
      // 指示节点正在以独占模式等待的标记
      static final Node EXCLUSIVE = null;
  	
      // 指示线程已取消
      static final int CANCELLED =  1;
      // 表示后继线程需要取消停放
      static final int SIGNAL    = -1;
      // 表示线程正在等待条件
      static final int CONDITION = -2;
      // 指示下一个 acquireShared 应该无条件传播
      static final int PROPAGATE = -3;
      
      // 当前节点的状态
      volatile int waitStatus;
      
      volatile Node prev;
      volatile Node next;
      volatile Thread thread;
     
      Node nextWaiter;
           
  }
  ```

  

### ConditionObject

  ```java
  class ConditionObject implements Condition{
      
      // 条件队列的第一个节点。
  	private transient Node firstWaiter;
      // 条件队列的最后一个节点。
  	private transient Node lastWaiter;
      
  }
  ```

 

