package test;


public class Test {

    public static void main(String[] args) {
        System.out.println("-------");
        Test t = new Test();
        System.out.println(t.doSth());
        System.out.println("--------");
    }
    
    public int doSth() {
        try {
            int a = 1;
            System.out.println(1);
            return doSth(a);
        } finally {
            System.out.println(-1);
        }
    }
    
    public int doSth(int a) {
        try {
            a = a + 100;
            System.out.println(2);
            return a;
        } finally {
            System.out.println(-2);
        }
    }

}
