package xie.study.java.vm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xieyang on 17/3/2.
 * 堆内存溢出测试
 * vm参数设置:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args){

        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
