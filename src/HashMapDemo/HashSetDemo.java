package HashMapDemo;

import java.util.HashSet;

@SuppressWarnings({"all"})
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("hashset=" + hashSet);
        /*
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
            Node<K,V>[] tab; Node<K,V> p; int n, i;//定义了辅助变量
            //if语句表示当前table如果是null，或者大小==0，就是第一次扩容，到16.
            if ((tab = table) == null || (n = tab.length) == 0)//table是什么，是HashMap的一个数组，类型是Node[]
                n = (tab = resize()).length;//resize是什么，就是扩容。
            //根据key，得到的hash去计算该key应该存放到table表的哪个索引位置，并把这个位置的对象，赋给辅助变量p
            //如果p是否为空，为空，表示还没有存放元素，就创建一个Node。key是什么，是你传进来的东西， value是什么，是上面的PRESENT
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);
            else {
                Node<K,V> e; K k;
                if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p;
                else if (p instanceof TreeNode)
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {
                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);
                            break;
                        }
                        if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e);
                    return oldValue;
                }
    }
    ++modCount;
    if (++size > threshold)
        resize();
    //这个方法，让HashMap的子类来实现，进行一系列操作的，返回true，可以先不看
    afterNodeInsertion(evict);
    return null;
}

         */
    }
}

