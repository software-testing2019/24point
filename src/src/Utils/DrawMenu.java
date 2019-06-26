package Utils;

import java.util.List;
import entity.Student;

public class DrawMenu {

    public void printList(List<Student> list){
        System.out.print("----------------------------------\n");
        System.out.print("|   学号\t    |姓 名 \t|性别|  生日\t  | \n");
        for (Student s:
                list) {
            System.out.print("----------------------------------\n");
            System.out.print("| "
                             +s.getId()+ " |"
                             +(s.getName().length()<3?s.getName()+" ":s.getName())+ "\t| "
                             +(s.getGender()==1?"男":"女")+ " |"
                             +s.getBirDate()+ "|\n");
        }
        System.out.print("----------------------------------\n");
    }

    public void printMenu(){
        System.out.print("请选择操作：\n" +
                "***********************************\n" +
                "*              0  帮助             *\n" +
                "*              1  插入             *\n" +
                "*              2  查找             *\n" +
                "*              3  删除             *\n" +
                "*              4  修改             *\n" +
                "*              5  输出             *\n" +
                "*              6  退出             *\n" +
                "***********************************\n");
    }

    public void printTitle(){
        System.out.print(
                "***********************************\n" +
                "*                                 *\n" +
                "*            学生管理系统           *\n" +
                "*                                 *\n" +
                "***********************************\n");
    }

    public void printHelp(){
        System.out.print("请选择操作：\n" +
                "***********************************\n" +
                "*        1 学号 姓名 男/女 学号      *\n" +
                "*              2  姓名             *\n" +
                "*              3  姓名             *\n" +
                "*        4 学号 姓名 男/女 学号      *\n" +
                "*              5  输出             *\n" +
                "*              6  退出             *\n" +
                "***********************************\n");
    }
}
