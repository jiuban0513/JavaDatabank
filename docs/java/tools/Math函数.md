

## Math常用函数汇总：

```java
Math.E                          //自然常数e=2.7182818284590452354
Math.abs(12.3);                 //12.3 返回该值的绝对值  
Math.abs(-12.3);                //12.3  

Math.copySign(1.23, -12.3);     //-1.23,返回第一个参数的量值和第二个参数的符号  
Math.copySign(-12.3, 1.23);     //12.3  

Math.signum(x);                 //如果x大于0则返回1.0，小于0则返回-1.0，等于0则返回0  
Math.signum(12.3);              //1.0  
Math.signum(-12.3);             //-1.0  
Math.signum(0);                 //0.0  


//指数  
Math.exp(x);                    //e的x次幂  
Math.expm1(x);                  //e的x次幂 - 1  

Math.scalb(x, y);               //x*(2的y次幂）  
Math.scalb(12.3, 3);            //12.3*2³  

//取整  
Math.ceil(12.3);                //返回最近的且大于该值的整数13.0  
Math.ceil(-12.3);               //-12.0  

Math.floor(12.3);               //返回最近的且小于该值的整数12.0  
Math.floor(-12.3);              //-13.0  

//x和y平方和的二次方根  
Math.hypot(x, y);               //√（x²+y²）  

//返回该值的二次方根  
Math.sqrt(x);                   //√(x) x的二次方根  
Math.sqrt(9);                   //3.0  
Math.sqrt(16);                  //4.0  

//返回该值的立方根  
Math.cbrt(27.0);                //3   
Math.cbrt(-125.0);              //-5  

//对数函数  
Math.log(e);                    //1 以e为底的对数  
Math.log10(100);                //10 以10为底的对数  
Math.log1p(x);                  //Ln（x+ 1）  

//返回较大值和较小值  
Math.max(x, y);                 //返回x、y中较大的那个数  
Math.min(x, y);                 //返回x、y中较小的那个数  

//返回x的y次幂  
Math.pow(x, y);                   
Math.pow(2, 3);                 //即2³ 即返回：8  

//随机返回[0,1)之间的无符号double值  
Math.random();                    

//返回最接近该值的整数,如果居中，则取偶数  
Math.rint(12.3);                //12.0   
Math.rint(-12.3);               //-12.0  
Math.rint(78.9);                //79.0  
Math.rint(-78.9);               //-79.0  
Math.rint(34.5);                //34.0  
Math.rint(35.5);                //36.0  

Math.round(12.3);               //与rint相似，返回值为long  

//三角函数  
Math.sin(α);                    //sin（α）的值  
Math.cos(α);                    //cos（α）的值  
Math.tan(α);                    //tan（α）的值  

//求角  
Math.asin(x/z);                 //返回角度值[-π/2，π/2]  arc sin（x/z）  
Math.acos(y/z);                 //返回角度值[0~π]   arc cos（y/z）  
Math.atan(y/x);                 //返回角度值[-π/2，π/2]  
Math.atan2(y-y0, x-x0);         //同上，返回经过点（x，y）与原点的的直线和经过点（x0，y0）与原点的直线之间所成的夹角  

Math.sinh(x);                   //双曲正弦函数sinh(x)=(exp(x) - exp(-x)) / 2.0;  
Math.cosh(x);                   //双曲余弦函数cosh(x)=(exp(x) + exp(-x)) / 2.0;  
Math.tanh(x);                   //tanh(x) = sinh(x) / cosh(x);  

//角度弧度互换  
Math.toDegrees(angrad);         //角度转换成弧度，返回：angrad * 180d / PI  

Math.toRadians(angdeg);         //弧度转换成角度，返回：angdeg / 180d * PI  

``` 

## 参考资料：
[java中Math常用的数学函数](https://blog.csdn.net/shangming150/article/details/78617808)