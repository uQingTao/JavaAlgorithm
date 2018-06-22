import java.util.Scanner;

class DATA {
    String key;     //结点关键字
    String name;
    int age;
}

class SLType {       //定义顺序表结构
    static final int MAXLEN = 100;
    DATA[] ListData = new DATA[MAXLEN + 1];
    int ListLen;

    void SLInit(SLType SL) {        //初始换顺序表
        SL.ListLen = 0;
    }

    int SLLength(SLType SL) {     //返回顺序表的元素数量
        return SL.ListLen;
    }

    int SLInsert(SLType SL, int n, DATA data) {     //插入顺序表
        if (SL.ListLen >= MAXLEN) {
            System.out.println("顺序表已满，不能插入节点！");
            return 0;
        }
        if (n < 1 || n > SL.ListLen - 1) {
            System.out.println("插入元素序号错误，不能插入元素！");
            return 0;
        }
        for (int i = SL.ListLen; i >= n; i--) {
            SL.ListData[i + 1] = SL.ListData[i];
        }
        SL.ListData[n] = data;
        SL.ListLen++;
        return 1;
    }

    int SLAdd(SLType SL, DATA data) {       //增加元素到顺序表尾部
        if (SL.ListLen >= MAXLEN) {
            System.out.println("顺序表已满，不能再添加节点了！");
            return 0;
        }
        SL.ListData[++SL.ListLen] = data;
        return 1;
    }

    int SLDelete(SLType SL, int n) {     //删除顺序表中的元素
        if (n < 1 || n > SL.ListLen + 1) {
            System.out.println("删除绩点序号错误！");
            return 0;
        }
        for (int i = n; i < SL.ListLen; i++) {
            SL.ListData[i] = SL.ListData[i + 1];
        }
        SL.ListLen--;
        return 1;
    }

    DATA SLFindByNum(SLType SL, int n) {     //根据序号返回数据元素
        if (n < 1 || n > SL.ListLen + 1) {
            System.out.println("节点序号错误，不能返回节点");
            return null;
        }
        return SL.ListData[n];
    }

    int SLFindByCont(SLType SL, String key) {        //按关键字查询节点
        for (int i = 1; i < SL.ListLen; i++) {
            if (SL.ListData[i].key.compareTo(key) == 0) {
                return i;
            }
        }
        return 0;
    }

    int SLAll(SLType SL) {      //显示顺序表中的所有节点
        for (int i = 1; i <= SL.ListLen; i++) {
            System.out.println("(" + SL.ListData[i].key + "," + SL.ListData[i].name + "," + SL.ListData[i].age + ")");
        }
        return 0;
    }

}

public class SequentialList {
    public static void main(String[] args) {
        int i;
        SLType SL = new SLType();       //定义顺序表变量
        DATA pdata;     //定义节点保存引用变量
        String key;     // 保存关键字
        System.out.println("顺序表演示操作");

        SL.SLInit(SL);      //初始化顺序表
        System.out.println("初始化顺序表完成");

        Scanner scanner = new Scanner(System.in);
        do {     //循环添加节点
            System.out.println("输入添加的节点");
            DATA data = new DATA();
            data.key = scanner.next();
            data.name = scanner.next();
            data.age = scanner.nextInt();

            if (data.age != 0) {
                if (SL.SLAdd(SL, data) == 0) {
                    break;
                }
            } else {
                break;
            }
        } while (true);

        System.out.println("\n顺序表中的节点顺序为：");
        SL.SLAll(SL);       //显示所有节点数据

        System.out.println("\n要取出的节点的序号为：");
        i = scanner.nextInt();
        pdata = SL.SLFindByNum(SL, i);
        if (pdata != null)
            System.out.println("第" + i + "个节点为" + "(" + SL.ListData[i].key + "," + SL.ListData[i].name + "," + SL.ListData[i].age + ")");

        System.out.println("\n要查找的节点的关键字：");
        key = scanner.next();
        i = SL.SLFindByCont(SL, key);
        pdata = SL.SLFindByNum(SL, i);
        if (pdata != null) {
            System.out.println("第" + i + "个节点为" + "(" + SL.ListData[i].key + "," + SL.ListData[i].name + "," + SL.ListData[i].age + ")");
        }
    }

}
