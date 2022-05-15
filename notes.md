一、Java基础

1、基本数据类型
Boolean 
byte 1字节
short 2
int 4
long 8
char 2

float 4
double 8


基本数据类型转换：容量小的类型自动转换到容量大的类型。

自动转换中可能丢失精度：int->float,int->double,long->double.

byte short int这三种类型在计算时会转换成int类型。

Boolean不能转换成任何其他类型。

强制类型转换：容量大的类型转换到容量小的类型。可能有精度损失或溢出。

2、运算符
&和&&的区别：
&：在逻辑运算时分别计算表达式两边的结果，再作&运算。在做位运算时表示按位与。
&&：短路与运算，如果左边表达式是false，那么不用计算右边。效率高。

不通过第三个变量交换两个数：
//a = 1,b = 2
//a = a+b-(b=a)

//最快方法:异或
//a = a^b;
//b = a^b;
//a = a^b;

三目运算符
X?Y:Z
表达式X为true时X?Y:Z的值为Y，X为flase时X?Y:Z的值为Z。

3、方法
重载overload：方法名一样，参数不同。

foreach
for(int x:nums)

4、数组
栈内存：每一块内存大小固定，存放局部变量（基本数据类型）和引用变量。
堆内存：大小不固定，存放对象。

Arrays类
binarySearch()
toString()
sort()
copyOf()
System.arraycopy()
equals()
数组复制效率排序：System.arraycopy()>Arrays.copyOf()

5、面向对象
成员变量和局部变量：成员变量在堆内存，局部变量在栈内存。

构造方法：方法名和类名必须相同，且无返回类型。
每个类都有默认的无参构造方法，如果有重载构造方法，还想保留默认构造方法，那么需要显式地写出默认构造方法。
构造方法中可以调用另一个构造方法，该句代码必须在第一句。
class ListNode{
int val;
public ListNode(){
System.out.println("构造方法执行了");
}
public ListNode(int val){
this();//调用默认构造方法
this.val = val;
}
}
public class Main {

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
    }
}

构造方法私有化：保证该类只有一个对象。例如工具类（没有属性，只有行为）。
class ListNode{
int val;
static ListNode ln = new ListNode(1);
public ListNode(){
System.out.println("构造方法执行了");
}
private ListNode(int val){
this.val = val;
System.out.println("私有");
}
}
public class Main {

    public static void main(String[] args) {
        System.out.println(ListNode.ln.val);
    }
}

this关键字：
调用类的属性和方法，表示当前对象。

值传递：参数是基本数据类型，传递的是栈内存中的值。
public class Main {

    public static void main(String[] args) {
        int x = 10;
        method(x);
        System.out.println(x);
    }
    public static void method(int mx){
        mx = 20;
    }
}

引用传递：传递的参数是该对象的栈内存地址。也是值传递（传的是对象的值，对象的值就是一个栈内存地址）。
public class Main {
    public static void main(String[] args) {
        Duck duck = new Duck();
        method(duck);//把duck的值
        System.out.println(duck.val);
    }
    public static void method(Duck duck){
        duck.val = 1;
    }
}
class Duck{
int val  = 0;
}

String传递: 传递的也是String对象的栈内存地址，本质都是值传递。String对象不能修改，只能重新引用。
public class Main {
public static void main(String[] args) {
String name = "小小";
method(name);
System.out.println(name);
}
public static void method(String sname){
sname = "小贝";//String对象不能修改，只能重新引用。
}
}

对象关联：在一个类里增加属性，该属性是另一个类。

static关键字
静态变量或方法不属于对象，依赖类。
静态变量是全局变量，生命周期从类加载到程序结束。

代码块：
普通代码块：方法中的代码块。
构造块：在类中定义的代码块，创建对象时被调用，优先于构造方法执行。
静态代码块：在第一次使用的时候（创建对象）被调用一次，优先构造块执行。

单例设计模式：
1、构造方法私有化 2、声明本类对象 3、给外部提供一个静态方法获取实例。
饿汉式
懒汉式
public class Main {
public static void main(String[] args) {
Singleton s = Singleton.getInstance();
}
}
//饿汉式
class Singleton{
private Singleton(){}
private static Singleton s = new Singleton();
public static Singleton getInstance(){
return s;
}
}

//懒汉式:占用内存时间少，效率低（懒加载）
//在多线程访问时有安全问题 
class Singleton2{
private Singleton2(){}
private static Singleton2 s;
public static Singleton2 getInstance(){
if(s == null){
s = new Singleton2();
}
return s;
}
}

单例的优势：节省重复创建对象带来的内存消耗。
1、在设计工具类时（只有功能方法） 2、工具类被频繁调用 

能否用私有构造方法+静态方法（例如Math类）替代单例：
单例更省内存。对象被销毁时内存就释放。

实现动态数组：
if(count>=cs.length){
int newLen = cs.length*2;
cs = Arrays.copyOf(cs,newLen);
}

继承：
protected和public修饰的属性和方法可以被继承。
创建子类对象时，父类的默认构造方法也会被调用（不管调用哪个子类构造方法，父类都是调用默认构造方法）：因为子类要使用父类的数据。
当父类中没有默认构造方法时，子类必须显式调用父类的带参构造方法。super(),必须在第一句。
class Dog{
protected String name;
public Dog(){
System.out.println("我是Dog的默认构造方法");
}
public Dog(String name){
System.out.println("我是Dog的带参数构造方法");
}
}
class HomeDog extends Dog{
public HomeDog(){
super();
System.out.println("我是HomeDog的默认构造方法");
}
public HomeDog(String name){
super(name);
System.out.println("我是HomeDog的带参数构造方法");
}
}

方法重写规则：
参数列表与父类方法的参数列表必须完全相同。方法名和参数一样就是重写方法，否则就是子类的新方法。
返回类型必须是父类方法返回值的派生类。
访问权限必须>=父类方法的访问权限。
static,final方法不能被重写。
public class Main {
public static void main(String[] args) {
//HomeDog hd = new HomeDog();
Dog hd = new HomeDog();
hd.static_test();
hd.test();
}
}
class Dog{
protected String name;
public Dog(){
System.out.println("我是Dog的默认构造方法");
}
public static void static_test(){
System.out.println("我是Dog的static方法");
}
public void test(){ }
}
class HomeDog extends Dog{
public HomeDog(){
System.out.println("我是HomeDog的默认构造方法");
}
public static void static_test(){
System.out.println("我是HomeDog的static方法");
};
public void test(){
System.out.println("子类");
}
} 

重载：在同一个类中，方法名相同、参数不同、返回值无关。
重写：在子父类中，方法名和参数相同、返回值是父类方法的派生类型、
访问权限>=父类访问权限、异常声明<=父类异常、static,final方法不能被重写。

final声明常量：该常量不能修改。
final声明方法：该方法只能被子类继承，不能被重写。
final声明类：无法被继承。

抽象类：
抽象类可以有普通的属性。
继承抽象类的具体类必须实现所有抽象方法。
抽象类可以没有抽象方法，有抽象方法一定是抽象类。
抽象类可以继承抽象类，不用实现抽象方法。
抽象类不能实例化。
抽象类不能用final修饰。
抽象类可以有构造方法。（具体类调用父类的构造方法用来初始化属性）

接口：
只有全局常量和抽象方法。
接口方法没有声明修饰符，默认为public abstract
接口之间可以多继承。实现类必须实现所有抽象方法。

接口与类的区别：

    接口不能用于实例化对象。
    接口没有构造方法。
    接口中所有的方法必须是抽象方法，Java 8 之后 接口中可以使用 default 关键字修饰的非抽象方法。
    接口不能包含成员变量，除了 static 和 final 变量。
    接口支持多继承。

父类引用指向子类对象：类型转换
对象的强制类型转换：父类对象转换为子类对象。

instanceof
将父类实例强制转换为子类引用时，判断是否是子类的实例。

父类设计法则：
设计为抽象类或接口，优先考虑接口。

String
字符串，内部使用字符数组实现，不能被继承（final类），不可变（字符数组是final）
两种赋值方式，推荐使用直接赋值。
使用new关键字创建字符串对象时，若字符串常量池没有该字符串，则会创建两个对象。

编译期值可以确定，就使用已有的对象。

相关方法：
charAt()
toCharArray()


StringBuffer:
解决字符串相加的性能问题。内部采用字符数组，默认数组长度16。
线程安全，影响性能。

StringBuilder:
线程不安全，速度快。单线程时使用此类。

对象比较器：
自定义对象实现比较排序，使用Comparable接口。
Comparator接口

对象克隆
Cloneable接口

Lambda表达式 ：














