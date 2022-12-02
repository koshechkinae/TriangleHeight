import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        float sideA = readSideLength("A");
        float sideB = readSideLength("B");
        float sideC = readSideLength("C");

        checkTriangleExists(sideA, sideB, sideC);

        float heightA = calculateTriangleHeight(sideA, sideB, sideC, sideA);
        float heightB = calculateTriangleHeight(sideA, sideB, sideC, sideB);
        float heightC = calculateTriangleHeight(sideA, sideB, sideC, sideC);

        printTriangleHeight("A", heightA);
        printTriangleHeight("B", heightB);
        printTriangleHeight("C", heightC);

    }

    private static float readSideLength(String sideName)
    {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Введите длину стороны %s:\n",sideName);

        float sideLength = scan.nextFloat();

        if (sideLength <= 0) throw new IllegalArgumentException("Длина стороны треугольника должна быть больше 0!");

        return sideLength;
    }

    private static float calculateTriangleHeight(float sideA, float sideB, float sideC, float calculatedHeightSide)
    {
        float semiperimeter = (sideA + sideB + sideC) / 2;

        return 2 / calculatedHeightSide * (float) Math.sqrt(semiperimeter * (semiperimeter - sideA) * (semiperimeter - sideB) * (semiperimeter - sideC));
    }

    private static void printTriangleHeight(String sideName, float sideHeight)
    {
        System.out.printf("Высота стороны %s = %.2f\n", sideName, sideHeight);
    }

    private static void checkTriangleExists(float sideA, float sideB, float sideC)
    {
        if ((sideA + sideB <= sideC) || (sideB + sideC <= sideA) || (sideC + sideA) <= sideB)
        {
            throw new IllegalArgumentException("Из данных сторон нельзя составить треугольник!");
        }
    }

}
