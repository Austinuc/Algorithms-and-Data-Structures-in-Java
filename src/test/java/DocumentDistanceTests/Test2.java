package DocumentDistanceTests; /**
 ******************************************************************************
 *                    HOMEWORK, 15-121
 ******************************************************************************
 *                  THE DOCUMENT DISTANCE
 ******************************************************************************
 *
 *   Test case
 *
 *****************************************************************************/

import java.io.File;

public class Test2
{
	public static void main(String[] args)
	{
		Distance map1 = new Distance(new File("verne.txt"));
		System.out.println(map1.getNumOfLines() + " lines  ");
		System.out.println(map1.getNumOfWords() + " words  ");
		System.out.println(map1.getNumOfDistinctWords() + " distinct words");
		System.out.println(map1.norm() + " Euclidean norm\n");

		Distance map2 = new Distance(new File("lewis.txt"));
		System.out.println(map2.getNumOfLines() + " lines  ");
		System.out.println(map2.getNumOfWords() + " words  ");
		System.out.println(map2.getNumOfDistinctWords() + " distinct words");
		System.out.println(map2.norm() + " Euclidean norm\n");

		System.out.println(map2.innerProduct(map1.getMap()) + " inner product");
		System.out.println(map1.angle(map2.getMap()) + " angle");


/*                   EXPECTED OUTPUT
1057 lines
8943 words
2154 distinct words
886.5624625484659 Euclidean norm

15996 lines
182357 words
8539 distinct words
22206.41589721313 Euclidean norm

1.7962605E7 inner product
0.4217057138495239 angle
*/

	}
}
