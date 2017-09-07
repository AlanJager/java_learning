import java.util.*;
public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int pick(int[] peaches) {
        int[] Len = new int[peaches.length];
        int max =0;
        Len[0] =1;
        for(int i=1;i<peaches.length;i++){
            Len[i] =1;
            for(int j=0;j<i;j++){
                //System.out.println(Seq[i]+" "+Seq[j]);
                if((peaches[i]>peaches[j])&&(Len[j]+1)>Len[i]){
                    Len[i] = Len[j]+1;
                }
            }
            if(max<Len[i]){
                max =Len[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = Integer.parseInt(in.nextLine().trim());
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(pick(peaches));
    }

}

