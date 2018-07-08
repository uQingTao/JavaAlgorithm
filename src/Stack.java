import java.util.Scanner;

class DATA3 {
    String name;
    int age;
}

class StackType {
    static final int MAXLEN = 50;
    DATA3[] data = new DATA3[MAXLEN + 1];
    int top;

    StackType STInit() {
        StackType p;
        if ((p = new StackType()) != null) {
            p.top = 0;
            return p;
        }
        return null;
    }

    boolean STIsEmpty(StackType s) {     //判断栈是否为空
        boolean t;
        t = (s.top == 0);
        return t;
    }

    boolean STIsFull(StackType s) {     //判断栈是否为满
        boolean t;
        t = (s.top == MAXLEN);
        return t;
    }

    void STClear(StackType s) {      //清空栈
        s.top = 0;
    }

    void STFree(StackType s) {       //释放栈所占用空间
        if (s != null) {
            s = null;
        }
    }

    int PushST(StackType s, DATA3 data) {        //入栈操作
        if ((s.top + 1) > MAXLEN) {
            System.out.println("栈溢出！");
            return 0;
        }
        s.data[++s.top] = data;
        return 1;
    }

    DATA3 PopST(StackType s) {       //出栈操作
        if (s.top == 0) {
            System.out.println("栈为空！");
            System.exit(0);
        }
        return (s.data[s.top--]);
    }

    DATA3 PeekST(StackType s) {      //读取栈顶数据
        if (s.top == 0) {
            System.out.println("栈为空");
            System.exit(0);
        }
        return (s.data[s.top]);
    }
}

public class Stack {
    public static void main(String[] args) {
        StackType st = new StackType();
        DATA3 data1 = new DATA3();

        StackType stack = st.STInit();      //初始化
        Scanner sc = new Scanner(System.in);
        System.out.println("入栈操作");
        System.out.println("输入姓名 年龄进行入栈操作");
        do {
            DATA3 data = new DATA3();
            data.name = sc.next();
            if (data.name.equals("0")) {
                break;
            } else {
                data.age = sc.nextInt();
                st.PushST(stack, data);
            }
        } while (true);

        String temp ="1";
        System.out.println("出栈操作：按任意非0键进行出栈操作：");
        temp = sc.next();
        while (!temp.equals("0")){
            data1 = st.PopST(stack);
            System.out.println("出栈的数据是(" + data1.name + ", " + data1.age + ")");
            temp = sc.next();
        }
        System.out.println("测试结束");
        st.STFree(st);
    }
}









