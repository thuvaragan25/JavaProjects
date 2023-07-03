public class recursivesequence {
    public static void main(String[] args) {
        for (int i = 1 ; i < 10 ; i++) System.out.print (s1 (i) + (i == 9 ? "\n" : " "));
        for (int i = 1 ; i < 10 ; i++) System.out.print (s2 (i) + (i == 9 ? "\n" : " "));
        for (int i = 1 ; i < 10 ; i++) System.out.print (s3 (i) + (i == 9 ? "\n" : " "));
        for (int i = 1 ; i < 10 ; i++) System.out.print (s4 (i) + (i == 9 ? "\n" : " "));
        for (int i = 1 ; i < 10 ; i++) System.out.print (s5 (i) + (i == 9 ? "\n" : " "));
        for (int i = 1 ; i < 10 ; i++) System.out.print (s6 (i) + (i == 9 ? "\n" : " "));
        for (int i = 1 ; i < 10 ; i++) System.out.print (s7 (i) + (i == 9 ? "\n" : " "));
        for (int i = 1 ; i < 10 ; i++) System.out.print (s8 (i) + (i == 9 ? "\n" : " "));
        for (int i = 1 ; i < 10 ; i++) System.out.print (s9 (i) + (i == 9 ? "\n" : " "));

    }
    public static int s1(int n){
        if(n<=1)
            return 1;
        else
            return s1(n-1)+1; 
    }
    public static int s2(int n){
        if(n<=1)
            return 25;
        else
            return s2(n-1)-1; 
    }
    public static int s3(int n){
        if(n<=1)
            return 25;
        else
            return s3(n-1)-2; 
    }
    public static int s4(int n){
        if(n<=1)
            return 2;
        else
            return s4(n-1)+2; 
    }
    public static int s5(int n){
        if(n<=1)
            return 2;
        else
            return s5(n-1)+1; 
    }
    public static int s6(int n){
        if(n<=1)
            return 1;
        else
            return s6(n-1)+s6(n-1); 
    }
    public static int s7(int n){
        if(n <= 2)
            return 2;
        else
            return s7(n-1)+s7(n-2); 
    }
    public static int s8(int n){
        if(n <= 2)
            return 3;
        else
            return s8(n-1)+s8(n-2); 
    }
    public static int s9(int n){
        if(n<=1)
            return 1;
        else
            return s9(n-1)*n; 
    }
}