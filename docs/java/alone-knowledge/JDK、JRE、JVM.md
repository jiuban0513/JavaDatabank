## 什么是JDK?什么是JRE？什么是JVM？三者之间的联系与区别

这几个是Java中很基本很基本的东西，但是我相信一定还有很多人搞不清楚！为什么呢？因为我们大多数时候在使用现成的编译工具以及环境的时候，并没有去考虑这些东西。

**JDK:**  顾名思义它是给开发者提供的开发工具箱,是给程序开发者用的。它除了包括完整的JRE（Java Runtime Environment），Java运行环境，还包含了其他供开发者使用的工具包。

**JRE:** 普通用户而只需要安装JRE（Java Runtime Environment）来运行Java程序。而程序开发者必须安装JDK来编译、调试程序。

**JVM：** 当我们运行一个程序时，JVM负责将字节码转换为特定机器代码，JVM提供了内存管理/垃圾回收和安全机制等。这种独立于硬件和操作系统，正是java程序可以一次编写多处执行的原因。

**区别与联系：**

 1. JDK用于开发，JRE用于运行java程序 ；
 2. JDK和JRE中都包含JVM ；
 3. JVM是java编程语言的核心并且具有平台独立性。