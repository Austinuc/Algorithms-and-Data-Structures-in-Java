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

public class Test4
{
	public static void main(String[] args)
	{
		long t1 = System.currentTimeMillis();

		Distance map1 = new Distance(new File("arabian.txt"));
		System.out.println(map1.getNumOfLines() + " lines  ");
		System.out.println(map1.getNumOfWords() + " words  ");
		System.out.println(map1.getNumOfDistinctWords() + " distinct words");
		System.out.println(map1.norm() + " Euclidean norm\n");

		Distance map2 = new Distance(new File("shakespeare.txt"));
		System.out.println(map2.getNumOfLines() + " lines  ");
		System.out.println(map2.getNumOfWords() + " words  ");
		System.out.println(map2.getNumOfDistinctWords() + " distinct words");
		System.out.println(map2.norm() + " Euclidean norm\n");

		System.out.println(map1.innerProduct(map2.getMap()) + " inner product");
		System.out.println(map1.angle(map2.getMap()) + " angle\n");

		long t2 = System.currentTimeMillis();
		System.out.println("Computing time: " + (t2-t1) + " millisec");


/*                   EXPECTED OUTPUT
54724 lines
550709 words
12425 distinct words
56468.94986627607 Euclidean norm

124456 lines
929396 words
23902 distinct words
71714.66116492498 Euclidean norm

3.623014608E9 inner product
0.46315257198139875 angle

Computing time: 8172 millisec
*/
	}
}
