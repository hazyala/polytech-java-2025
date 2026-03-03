package chapter06;

public class ForTest7 {

    public static void main(String[] args) {
//        단수별로 세로로 출력하는 구구단
        for( int i = 2 ; i < 10 ; i++ ) {
            for( int j = 1 ; j < 10 ; j++ ) {
                System.out.printf(" %d × %d = %d\n", i , j, i*j);
            }
        }
    }
}