package src.version2;

import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.stream.Collectors;
 

 
 public class InfixInToSuffix {
     /**
     * ���ŵ����ȼ�����
      */
     private static final Map<Character, Integer> basic = new HashMap<Character, Integer>();
     static {
         basic.put('-', 1);
        basic.put('+', 1);
         basic.put('*', 2);
         basic.put('/', 2);
         basic.put('(', 0);//��������  ���������ȼ���ߣ����Ǵ˴����������Ҫ ������Ϊ0
     }
    
     
    /**
      * ��  ��׺���ʽ  ת��Ϊ  ��׺���ʽ
     */
     public String toSuffix(String infix){
         List<String> queue = new ArrayList<String>();                                    //�������  ���ڴ洢 ����  �Լ�����  ��׺���ʽ
         List<Character> stack = new ArrayList<Character>();                             //����ջ    ���ڴ洢  �����  ���stack�лᱻ ����
        
        char[] charArr = infix.trim().toCharArray();                                    //�ַ�����  ���ڲ�����ֻ����
         String standard = "*/+-()";                                                        //�ж���׼ �����ʽ�л���ֵ������д����
         char ch = '&';                                                                    //��ѭ������������ �ַ�����ĵ�ǰѭ��������  ��������ǳ�ʼ��һ��ֵ  û������
        int len = 0;                                                                    //���ڼ�¼�ַ����� ������100*2,���¼��lenΪ3 ��ʱ���ȡ�ַ�����ǰ��λ�������֡�
         for (int i = 0; i < charArr.length; i++) {                                        //��ʼ����
            
             ch = charArr[i];                                                            //���浱ǰ��������
            if(Character.isDigit(ch)) {                                                    //�����ǰ����Ϊ ����  
                len++;    
             }else if(Character.isLetter(ch)) {                                            //�����ǰ����Ϊ  ��ĸ
                len++;
             }else if(ch == '.'){                                                        //�����ǰ����Ϊ  .  �������С������
                len++;
             }else if(Character.isSpaceChar(ch)) {                                        //�����ǰ����Ϊ �ո�  ֧�ֱ��ʽ���пո����
                 if(len > 0) {                                                            //��Ϊ�ո� ���� һ�ν��� ���Ϳ�����������  ������  ������100 * 2  100�����пո� �Ϳ��Խ��ո�֮ǰ�Ĵ�������ˡ�
                     queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len, i)));    //�� ���д��� ��ȡ�� �ַ��� 
                    len = 0;                                                            //�����ÿ�
                }
                continue;                                                                //����ո���֣���һ�ν���  ��������ѭ��
             }else if(standard.indexOf(ch) != -1) {                                        //����������׼�е� ����һ������
                if(len > 0) {                                                            //����Ҳ��
                     queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len, i)));    //˵������֮ǰ�Ŀ��Խ�ȡ����������
                     len = 0;                                                            //�����ÿ�
                }
                 if(ch == '(') {                                                            //�����������
                    stack.add(ch);                                                        //�������� ����ջ��
                     continue;                                                            //��������ѭ��  ��������һ��λ��
                }
                 if (!stack.isEmpty()) {                                                    //���ջ��Ϊempty
                    int size = stack.size() - 1;                                        //��ȡջ�Ĵ�С-1  ������ջ���һ��Ԫ�ص��±�
                     boolean flag = false;                                                //���ñ�־λ
                     while (size >= 0 && ch == ')' && stack.get(size) != '(') {            //����ǰchΪ�����ţ��� ջ��Ԫ�ش�ջ��һֱ������ֱ�������� ������
                        queue.add(String.valueOf(stack.remove(size)));                    //��ʱch��δ��ջ�����Բ�δ��������У�ͬ��ֱ���ҵ������ŵ�ʱ��ѭ�������ˣ�����������Ҳ�����������С�Ҳ���ǣ���׺���ʽ�в���������š�
                        size--;                                                            //size-- ��֤�±���Զ��ջ���һ��Ԫ�ء�ջ�и��ָ����Զָ��ջ��Ԫ�ء�
                         flag = true;                                                    //���ñ�־λΪtrue  ����һֱ��ȡ�����е�Ԫ��
                    }
                    while (size >= 0 && !flag && basic.get(stack.get(size)) >= basic.get(ch)) {    //��ȡ�ò��ǣ����ڵ�Ԫ�أ����ҵ�ǰջ��Ԫ�ص����ȼ�>=�Ա�Ԫ�� �Ǿͳ�ջ�������
                        queue.add(String.valueOf(stack.remove(size)));                    //ͬ��  �˴�Ҳ��remove()���������ܵõ�Ҫ��ȡ��Ԫ�أ�Ҳ�ܽ�ջ��Ԫ���Ƴ���
                       size--;
                    }
                 }
                if(ch != ')') {                                                            //����ǰԪ�ز���������  
                     stack.add(ch);                                                        //��Ҫ��֤������� ��ջ
                } else {                                                                //�����Ҫ��ջ ջ�ڷ���
                    stack.remove(stack.size() - 1);
                }
             }
            if(i == charArr.length - 1) {                                                //����Ѿ��ߵ���  ��׺���ʽ�����һλ
                 if(len > 0) {                                                            //���len>0  �ͽ�ȡ����
                     queue.add(String.valueOf(Arrays.copyOfRange(charArr, i - len+1, i+1)));
                }    
                 int size = stack.size() - 1;                                            //size��ʾջ�����һ��Ԫ���±�
                 while (size >= 0) {                                                        //һֱ��ջ��  ����ȫ����ջ ���Ҽ��������  �����յĺ�׺���ʽ�Ǵ���ڶ����еģ���ջ�����ᱻ���ա�
                    queue.add(String.valueOf(stack.remove(size)));
                    size--;
                 }
             }
             
         }
         return queue.stream().collect(Collectors.joining(","));                            //��������Ԫ����,�ָ� �����ַ���
     }
     
 
     /**
105      * �� ��׺���ʽ ����  ���� ��������
106      * 
108      */
    public String dealEquation(String equation){
         String [] arr = equation.split(",");                                    //����, ����ַ���
        List<String> list = new ArrayList<String>();                            //���ڼ���ʱ  �洢������̵ļ��ϡ�����list�е�ǰ����  100   20  5  /  ��ȡ��20/5 ���ս����4����list   ��ʱlist�н��Ϊ  100  4 ��
         
        
         for (int i = 0; i < arr.length; i++) {                                    //�˴���������˵��������̣� ��Ϊlist.remove��Ե�ʣ�����ȡ�����һ���������������  ����size-2
             int size = list.size();
             switch (arr[i]) {
             case "+": double a = Double.parseDouble(list.remove(size-2))+ Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(a));     break;
             case "-": double b = Double.parseDouble(list.remove(size-2))- Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(b));     break;
             case "*": double c = Double.parseDouble(list.remove(size-2))* Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(c));     break;
             case "/": double d = Double.parseDouble(list.remove(size-2))/ Double.parseDouble(list.remove(size-2)); list.add(String.valueOf(d));       break;
            default: list.add(arr[i]);     break;                                    //���������  ֱ�ӷŽ�list��
             }
         }
         
         return list.size() == 1 ? list.get(0) : "����ʧ��" ;                    //����list�н���һ�������������������
     }
     
    
 
 }