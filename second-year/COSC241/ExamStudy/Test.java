import java.util.*;

public class Test{

    private static int[] array = {1,2,3,4,5,6,7,8,9};
    private static int[][] array2 = {{1,2},{3,4,5},{-2,0,1,3}};

    public static void main(String[]args){
        Test test = new Test();
        //test.reverse(array, 3, 6);
        //test.join(array2);
        //test.shuffle(array);
        //for(int i: array) System.out.print(i + ", ");
        Stack<Integer> s = new Stack<>();
        s.push(7);
        while(!s.isEmpty()){
            int n = s.pop();
            System.out.print(n + "_");
            if (n >= 3){
                s.push(n-2);
            }
            if (n >= 4){
                s.push(n-3);
            }
        }
        System.out.println();
        Queue<Integer> q = new Queue<>();
        q.add(7);
        while (!q.isEmpty()){
            int n = q.remove();
            System.out.print(n + "_");
            if (n >= 3){
                q.add(n-2);
            }
            if (n >= 4){
                q.add(n-3);
            }
        }
        System.out.println();
    }

    public void reverse(int[] a, int x, int j){
        for(int i = x; i < j; i++){
            int temp = a[i];
            a[i] = a[j-1];
            a[j-1] = temp;
            j--;
        }
        for(int i: array) System.out.print(i + ", ");
    }

    public int[] join(int[][] a){
        int count = 0;
        for(int[] rows: a){
            for(int vals: rows){
                count++;
            }
        }
        int[] joined = new int[count];
        int index = 0;
        for(int[] rowz: a){
            for(int valz: rowz){
                joined[index] = valz;
                index++;
            }
        }
        //for(int i: joined) System.out.print(i + ", ");
        return joined;
    }

    public int[] shuffle(int[] a){
        Random rand = new Random();
        for(int i = 0; i < a.length; i++){
            int temp = a[i];
            int randomValue = rand.nextInt(a.length);
            a[i] = a[randomValue];
            a[randomValue] = temp;
        }
        return a;
    }

    
}