import java.util.Scanner;

class DATA2 {        //节点的关键字
    String key;
    String name;
    int age;
}

class CLType {           //定义链表结构
    DATA2 nodeDate = new DATA2();
    CLType nextNode;

    CLType CLAddEnd(CLType head, DATA2 nodeData) {
        CLType node, htemp;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败！");
            return null;
        } else {
            node.nodeDate = nodeDate;      //保存数据
            node.nextNode = null;
            if (head == null) {
                head = node;
                return head;
            }
            htemp = head;
            while (htemp.nextNode != null) {      //查找链表的末尾
                htemp = htemp.nextNode;
            }
            htemp.nextNode = node;
            return head;
        }
    }

    CLType CLAddFirst(CLType head, DATA2 nodeDate) {
        CLType node;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败！");
            return null;
        } else {
            node.nodeDate = nodeDate;   //保存数据
            node.nextNode = head;
            head = node;
            return head;
        }
    }

    CLType CLFindNode(CLType head, String key) {        //查找节点
        CLType htemp;
        htemp = head;
        while (htemp != null) {
            if (htemp.nodeDate.key.compareTo(key) == 0) {
                return htemp;
            }
            htemp = htemp.nextNode;       //处理下一节点
        }
        return null;
    }

    CLType CLInsertNode(CLType head, String findkey, DATA2 nodeDate) {     //插入节点
        CLType node, nodetemp;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败！");
            return null;
        }
        node.nodeDate = nodeDate;       //保存节点数据
        nodetemp = CLFindNode(head, findkey);
        if (nodetemp != null) {       //若找到要插入的节点
            node.nextNode = nodetemp.nextNode;      //新插入的节点指向关键节点的下一节点
            nodetemp.nextNode = node;       //关键节点指向新插入的节点
        } else {
            System.out.println("未找到正确的插入位置！");
        }
        return head;
    }

    int CLDeleteNode(CLType head, String key) {
        CLType node, htemp;      //node 保存删除节点的前一节点
        htemp = head;
        node = head;
        while (htemp != null) {
            if (htemp.nodeDate.key.compareTo(key) == 0) {
                node.nextNode = htemp.nextNode;     //使前一节点指向当前节点的下一节点
                htemp = null;
                return 1;
            } else {
                node = htemp;     //指向当前节点
                htemp = htemp.nextNode;       //指向下一节点
            }
        }
        return 0;
    }

    int CLLength(CLType head) {
        CLType htemp;
        int Len = 0;
        htemp = head;
        while (htemp != null) {
            Len++;
            htemp = htemp.nextNode;       //指向下一节点
        }
        return Len;
    }

    void CLAllNode(CLType head) {
        CLType htemp;
        DATA2 nodeData;
        htemp = head;
        System.out.println("当前链表共有" + CLLength(head) + "个节点。链表所有数据如下：");
        while (htemp != null) {
            nodeData = htemp.nodeDate;
            System.out.println("节点（" + nodeData.key + "," + nodeData.name + "," + nodeData.age + ")");
            htemp = htemp.nextNode;       //指向下一节点
        }
    }
}

public class LinkedList {
    public static void main(String[] args) {
        CLType node, head = null;
        CLType CL = new CLType();
        String key, findkey;
        Scanner scanner = new Scanner(System.in);

        System.out.println("链表测试，请先输入链表中的数据，格式为：关键字 姓名 年龄");
        do {
            DATA2 nodeData = new DATA2();
            nodeData.key = scanner.next();
            if (nodeData.key.equals("0")) {
                break;
            } else {
                nodeData.name = scanner.next();
                nodeData.age = scanner.nextInt();
                head = CL.CLAddFirst(head, nodeData);        //在链表尾部添加节点
            }
        } while (true);
        CL.CLAllNode(head);

        System.out.println("演示插入节点，输入插入位置的关键字");
        findkey = scanner.next();
        System.out.println("输入插入节点的数据，格式为：关键字 姓名 年龄");
        DATA2 nodeData = new DATA2();
        nodeData.key = scanner.next();
        nodeData.name = scanner.next();
        nodeData.age = scanner.nextInt();
        head = CL.CLInsertNode(head, findkey, nodeData);
        CL.CLAllNode(head);

        System.out.println("演示删除节点，输入要删除的关键字：");
        key = scanner.next();
        CL.CLDeleteNode(head, key);
        CL.CLAllNode(head);

        System.out.println("演示在链表中查找，输入查找关键字：");
        key = scanner.next();
        node = CL.CLFindNode(head, key);
        if (node != null) {
            nodeData = node.nodeDate;
            System.out.println("关键字" + key + "对应的节点是（" + nodeData.key + "," + nodeData.name + "," + nodeData.age + ")");
        } else {
            System.out.println("未在链表中找到关键字" + key + "的节点");
        }
    }
}
