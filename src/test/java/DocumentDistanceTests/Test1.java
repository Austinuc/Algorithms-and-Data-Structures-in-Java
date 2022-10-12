package DocumentDistanceTests;

/**
 ******************************************************************************
 *                    HOMEWORK, 15-121
 ******************************************************************************
 *                  THE DOCUMENT DISTANCE
 ******************************************************************************
 *
 *   Test case
 *
 *****************************************************************************/


public class Test1
{
	public static void main(String[] args)
	{
		Distance map1 = new Distance("To be or not to be");
		System.out.println(map1.getNumOfLines() + " lines  ");
		System.out.println(map1.getNumOfWords() + " words  ");
		System.out.println(map1.getNumOfDistinctWords() + " distinct words");
		System.out.println(map1.norm() + " Euclidean norm\n");

		Distance map2 = new Distance("Doubt truth to be a liar");
		System.out.println(map2.getNumOfLines() + " lines  ");
		System.out.println(map2.getNumOfWords() + " words  ");
		System.out.println(map2.getNumOfDistinctWords() + " distinct words");
		System.out.println(map2.norm() + " Euclidean norm\n");

		System.out.println(map1.innerProduct(map2.getMap()) + " inner product");
		System.out.println(map1.angle(map2.getMap()) + " angle");


/*                   EXPECTED OUTPUT
0 lines
6 words
4 distinct words
3.1622776601683795 Euclidean norm

0 lines
6 words
6 distinct words
2.449489742783178 Euclidean norm

4.0 inner product
1.028157224545244 angle
*/
	}
}
