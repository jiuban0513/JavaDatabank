<!-- TOC -->
- [Collection](#一：Collection)
    - [List](#1.-List)
        - [ArrayList](#（1）Arraylist：)
        - [Vectors](#（2）Vector：)
        - [LinkedList](#（3）LinkedList：)
    - [Set](#2.-Set)
        - [HashSet](#（1）HashSet（无序，唯一）)
        - [LinkedHashSet](#（2）LinkedHashSet： )
        - [TreeSet](#（3）TreeSet（有序，唯一）： )
- [Map](#二：Map)
     - map
        - [HashMap](#（1）HashMap： )
        - [LinkedHashMap](#（2）LinkedHashMap: )
        - [HashTable](#（3）HashTable: )
        - [TreeMap](#（4）TreeMap:)
<!-- /TOC -->

JAVA集合框架底层数据结构总结

 ![Image.text](https://raw.githubusercontent.com/jiuban0513/JavaDatabank/master/image/java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6.jpg)

# 一：Collection

## 1. List

###（1）Arraylist： 

	底层：Object数组

	不同步的，线程不安全

	因为采用数组存储，添加和删除元素受元素位置的影响。时间复杂度近似O（n）。

	支持快速随机访问，就是通过元素的位置序号快速获取到对象（对应于get（int index）方法）

	内存空间浪费主要体现在Arraylist列表的结尾会预留一定的容量空间。

###（2）Vector： 

	底层：Object数组

	类中所有方法都是同步的，两个线程可以同时访问同一个Vector对象；但是一个线程访问的话代码要在同步操作上耗费大量时间。

###（3）LinkedList： 

	底层：双向链表(JDK1.6之前为循环链表，JDK1.7取消了循环) 详细可阅读JDK1.7-LinkedList循环链表优化

	不同步的，线程不安全

	因为采用链表存储，添加和删除元素不受元素位置影响。时间复杂度近似O（1）。

	不支持快速随机访问。

	内存空间浪费主要体现在每个元素都需要消耗比ArrayList更多的空间（因为要存放直接后继、直接前驱、数据）

	

	下面再总结一下 list 的遍历方式选择：

		ArrayList实现了RandomAccess接口的list，优先选择普通for循环 ，其次foreach,

		LinkedList未实现RandomAccess接口的list， 优先选择iterator遍历（foreach遍历底层也是通过iterator实现的），大size的数据，千万不要使用普通for循环

	

## 2. Set

###（1）HashSet（无序，唯一）

	底层：基于 HashMap 实现的，底层采用 HashMap 来保存元素

###（2）LinkedHashSet： 
    
    LinkedHashSet 继承与 HashSet，并且其内部是通过 LinkedHashMap 来实现的。
    有点类似于我们之前说的LinkedHashMap 其内部是基于 Hashmap 实现一样，不过还是有一点点区别的。

###（3）TreeSet（有序，唯一）： 
    
    红黑树(自平衡的排序二叉树。)

## 二：Map

###（1）HashMap： 

	底层：JDK1.8之前HashMap由数组+链表组成的，数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在的（“拉链法”解决冲突）.

		  JDK1.8以后在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为8）时，将链表转化为红黑树，以减少搜索时间

	非线程安全

	因为非线程安全，效率会比HashTable效率高一点。

	HashMap支持key有一个null，所对应的value值可以有一个或多个为null。

	创建不指定初始值时，HashMap的默认大小为16，之后每次扩充为原来的2倍。（2的幂次方值大小）

	若创建时指定初始值大小，HashMap会将其扩充为2的幂次方大小。

	

###（2）LinkedHashMap: 
    
    LinkedHashMap 继承自 HashMap，所以它的底层仍然是基于拉链式散列结构即由数组和链表或红黑树组成。
    另外，LinkedHashMap 在上面结构的基础上，增加了一条双向链表，使得上面的结构可以保持键值对的插入顺序。
    同时通过对链表进行相应的操作，实现了访问顺序相关逻辑。
   详细可以查看：[《LinkedHashMap 源码详细分析（JDK1.8）》](https://www.imooc.com/article/22931)

###（3）HashTable: 

	底层：数组+链表组成的，数组是 HashMap 的主体，链表则是主要为了解决哈希冲突而存在的

	线程安全。HashTable 内部的方法基本都经过 synchronized 修饰。（如果你要保证线程安全的话就使用 ConcurrentHashMap 吧！）

	因为线程安全，效率比HashMap低。另外，HashTable基本被淘汰，不要在代码中使用它。

	HashTable中put进的健值中有一个null，就会抛出NullPointException.

	创建不指定初始值时，HashTable默认的大小为11，之后每次扩容为原来的2n+1大小。

	若创建时指定初始值大小，HashTable会直接使用你给定的大小。

	

###（4）TreeMap:
 红黑树（自平衡的排序二叉树）

