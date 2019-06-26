import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        boolean temp = true;
        while (temp){
            temp = studentManager.App(input.nextLine());
        }
        System.out.print("运行结束~");
    }
}
