#String和StringBuffer、StringBuilder的区别是什么？String为什么是不可变的？

String和StringBuffer、StringBuilder的区别

##可变性 　

简单的来说：String 类中使用 final 关键字字符数组保存字符串，private　final　char　value[]，所以 String 对象是不可变的。而StringBuilder 与 StringBuffer 都继承自 AbstractStringBuilder 类，在 AbstractStringBuilder 中也是使用字符数组保存字符串char[]value 但是没有用 final 关键字修饰，所以这两种对象都是可变的。

StringBuilder 与 StringBuffer 的构造方法都是调用父类构造方法也就是 AbstractStringBuilder 实现的，大家可以自行查阅源码。


```java
AbstractStringBuilder.java

abstract class AbstractStringBuilder implements Appendable, CharSequence {
    char[] value;
    int count;
    AbstractStringBuilder() {
    }
    AbstractStringBuilder(int capacity) {
        value = new char[capacity];
    }
```

##线程安全性

String 中的对象是不可变的，也就可以理解为常量，线程安全。AbstractStringBuilder 是 StringBuilder 与 StringBuffer 的公共父类，定义了一些字符串的基本操作，如 expandCapacity、append、insert、indexOf 等公共方法。StringBuffer 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。StringBuilder 并没有对方法进行加同步锁，所以是非线程安全的。 　　

##性能

每次对 String 类型进行改变的时候，都会生成一个新的 String 对象，然后将指针指向新的 String 对象。StringBuffer 每次都会对 StringBuffer 对象本身进行操作，而不是生成新的对象并改变对象引用。相同情况下使用 StirngBuilder 相比使用 StringBuffer 仅能获得 10%~15% 左右的性能提升，但却要冒多线程不安全的风险。

##对于三者使用的总结：

操作少量的数据 = String
单线程操作字符串缓冲区下操作大量数据 = StringBuilder
多线程操作字符串缓冲区下操作大量数据 = StringBuffer

##String为什么是不可变的吗？

简单来说就是String类利用了final修饰的char类型数组存储字符，源码如下图所以：

    /** The value is used for character storage. */
    private final char value[];
##String真的是不可变的吗？

我觉得如果别人问这个问题的话，回答不可变就可以了。 下面只是给大家看两个有代表性的例子：

1) String不可变但不代表引用不可以变

		String str = "Hello";
		str = str + " World";
		System.out.println("str=" + str);
结果：

str=Hello World
解析：

实际上，原来String的内容是不变的，只是str由原来指向"Hello"的内存地址转为指向"Hello World"的内存地址而已，也就是说多开辟了一块内存区域给"Hello World"字符串。

2) 通过反射是可以修改所谓的“不可变”对象

		// 创建字符串"Hello World"， 并赋给引用s
		String s = "Hello World";

		System.out.println("s = " + s); // Hello World

		// 获取String类中的value字段
		Field valueFieldOfString = String.class.getDeclaredField("value");

		// 改变value属性的访问权限
		valueFieldOfString.setAccessible(true);

		// 获取s对象上的value属性的值
		char[] value = (char[]) valueFieldOfString.get(s);

		// 改变value所引用的数组中的第5个字符
		value[5] = '_';

		System.out.println("s = " + s); // Hello_World
结果：

s = Hello World
s = Hello_World

解析：

用反射可以访问私有成员， 然后反射出String对象中的value属性， 进而改变通过获得的value引用改变数组的结构。但是一般我们不会这么做，这里只是简单提一下有这个东西。
