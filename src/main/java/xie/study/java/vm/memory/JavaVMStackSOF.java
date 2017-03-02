package xie.study.java.vm.memory;

/**
 * Created by xieyang on 17/3/2.
 *  虚拟机栈和本地方法栈溢出
 *  对于hotspot 来说，虽然-Xoss(设置本地方法栈大小)参数存在，，但实际是无效的，因为hotspot不分虚拟机栈和本地方法栈
 *  1.如果线程请求的栈深度大于虚拟机的所允许的最大深度，将抛出StackOverflowError Exception
 *  2.如果虚拟机在扩展栈时无法申请到足够的内存空间，帽抛出OutOfMemoryError Exception
 *  使用-Xss 参数减少栈内存大小
 *  如：-Xss128k
 */
public class JavaVMStackSOF {

    private int stackLength =1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:"+ oom.stackLength);
            throw  e;
        }


    }
}
