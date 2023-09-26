import java.util.Scanner;
public class AverageGrades
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int size = 0;
        int[] classArr = new int[0];
        while(choice != 4)
        {
            System.out.println("--------MAIN MENU-------");
            System.out.println("1. Read class size");
            System.out.println("2. Read class grades");
            System.out.println("3. Compute class average");
            System.out.println("4. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            choice = sc.nextInt();
            System.out.println();
            switch(choice)
            {
                case 1:
                    System.out.print("Please enter the class size: ");
                    int classSize = sc.nextInt();
                    System.out.println();
                    if(classSize <= 0)
                    {
                        System.out.println("Please enter a positive integer");
                    }
                    else
                    {
                        size = classSize;
                    }
                    System.out.println();
                    break;

                case 2:
                    if(size == 0)
                    {
                        System.out.println("Please input a class size first");
                    }
                    else
                    {
                        classArr = new int[size];
                        for(int i = 0; i < size; i++)
                        {
                            System.out.print("Please enter grade number " + (i + 1) + ": ");
                            classArr[i] = sc.nextInt();

                        }
                    }
                    System.out.println();
                    break;

                case 3:
                    if(size == 0)
                    {
                        System.out.println("Please input a class size first");
                    }
                    else if(classArr.length == 0)
                    {
                        System.out.println("Please input class grades first");
                    }
                    else
                    {
                        System.out.println("You entered class size:   " + size);
                        System.out.print("You entered grades:       ");
                        for(int i = 0; i < size; i++)
                        {
                            System.out.print(classArr[i] + " ");
                        }
                        System.out.println();
                        System.out.print("Class average:            ");
                        System.out.printf("%.2f", findAverage(classArr, size));
                        System.out.println();
                    }
                    System.out.println();
                    break;
            }
        }
    }

    /* findAverage takes in an array of integers and an integer that is the length of that array.
    it first has a base case that will trigger when the length integer is equal to one and returns the first
    element of the array. After the base case a double "grade" is initialized that is equal to the value of the array at
    index of the length value - 1 added to a recursive call that will loop through the array, adding each value into the
    "grade" double until the length value is one and the base case is called. There is a value of length - 1 multiplied
    the recursive call to counteract the fact that when the program returns the value it divides it by the length, which
    we only want to happen on the final return value of grade.*/
    public static double findAverage(int[] array, int length)
    {
        if(length == 1)
        {
            return array[0];
        }
        double grade = array[length - 1] + (length - 1) * findAverage(array, length - 1);
        return grade / (double) length;
    }
}
