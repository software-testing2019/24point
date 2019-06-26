import Utils.DrawMenu;
import entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManager{
    private List<Student> stuList = new ArrayList<Student>();
    private DrawMenu drawMenu = new DrawMenu();

    public StudentManager() {
        addStu(new Student("2016012049","张航", 1,"19971011"));
        addStu(new Student("2016012067","茅梓军", 1, "19970814"));
        addStu(new Student("2016012031","师浩然", 1, "19980718"));
        drawMenu.printTitle();
        drawMenu.printMenu();
    }

    public boolean addStu(Student student){
        if(student.getId().length()!= 10 && !(student.getBirDate().contains("199")||student.getBirDate().contains("200"))) {
            System.out.println("违法输入:\n" + student.toString());
            return false;
        }

        if(selStu(student.getName()).size() == 0 &&
           selStuByID(student.getId()).size() ==0){
            stuList.add(student);
            Collections.sort(stuList,Collections.reverseOrder(new Comparator<Student>() {
                public int compare(Student o1, Student o2) {
                    return o2.getId().compareTo(o1.getId());
                }
            }));
            return true;
        }else {
            System.out.println("重复添加");
            return false;
        }
    }

    public boolean delStu(String name){
        List<Student> list = selStu(name);
        if(list.size() != 0){
            stuList.remove(list.get(0));
            return true;
        }
        else
            return false;
    }

    public List<Student> selStu(String name){
        List<Student> list = new ArrayList<Student>();
        for (Student s:
                this.stuList) {
            if(s.getName().contains(name)){
                list.add(s);
            }
        }
        return list;
    }

    public List<Student> selStuByID(String id){
        List<Student> list = new ArrayList<Student>();
        for (Student s:
                this.stuList) {
            if(s.getId().contains(id)){
                list.add(s);
            }
        }
        return list;
    }
    public boolean updateStu(Student student){
        delStu(student.getName());
        addStu(student);
        return true;
    }

    protected void printList(List<Student> list){
        drawMenu.printList(list);
    }

    public List<Student> selALlStu(){
        return stuList;
    }

    public List<Student> getStuList() {
        return stuList;
    }

    public boolean App(String arg){
        String[] args = arg.split(" ");
        int num = Integer.parseInt(args[0]);
        switch (num){
            case 0 :
                drawMenu.printHelp();
                return true;
            case 1 :
                if(addStu(new Student(args[1],args[2],args[3].contains("男")?1:2,args[4])))
                    System.out.println("插入成功");
                return true;
            case 2 :
                List<Student> list = selStu(args[1]);
                if(list.size() == 0)
                    System.out.println("查无此人");
                else
                    printList(list);
                return true;
            case 3 :
                if(delStu(args[1]))
                    System.out.println("删除失败，请确认是否正确操作");
                else
                    System.out.println("删除成功");
                return true;
            case 4 :
                updateStu(new Student(args[1],args[2],args[3].contains("男")?1:2,args[4]));
                return true;
            case 5 :
                printList(this.stuList);
                drawMenu.printMenu();
                return true;
            case 6 :
                return false;
            default:
                System.out.println("错误命令请重试");
                return true;
        }
    }
}
