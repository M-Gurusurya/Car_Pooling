import java.util.Scanner;

public class CarPooling {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size=scanner.nextInt();
        int array[][]=new int[size][3];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<3;j++)
            {
                array[i][j]=scanner.nextInt();
            }
        }
        int capacity=scanner.nextInt();

        System.out.println(checkPossible(array,size,capacity));
    }
    public static boolean checkPossible(int array[][],int size,int capacity)
    {
        int totalTripLength[]=new int[100];
        for(int i=0;i<size;i++)
        {
            totalTripLength[array[i][1]]+=array[i][0];
            totalTripLength[array[i][2]]-=array[i][0];
        }
        int carload=0;
        for(int i=0;i<100;i++)
        {
            carload+=totalTripLength[i];
            if(carload>capacity)
            {
                return false;
            }
        }
        return true;
    }
}
