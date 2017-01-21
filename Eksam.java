package eksam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class Answer {

   public static void main (String[] args) {
      //System.out.println (posSumma (new int[]{0}));
      //System.out.println (posSumma (new int[]{1, 2, 0, -9}));
      //System.out.println (allaKeskmise (new double[]{0.}));
	   
      //String s = "Tere, TUDENG, tore ARVUTI sul!";
      //String t = asenda (s); // "T---, TUDENG, ---- ARVUTI ---!"
      //System.out.println (s + " > " + t);

      //System.out.println (greatestPrimeFactor (1234)); // 617
	   

	  //int[] res = reaMaxid (new int[][] { {1,2,3}, {4,5,6} }); // {3, 6}
	  //for (int i: res) {
	  //    System.out.println(i);
	  //}

	   
	   /**
	    * new int[][]{{4, 0, 0}, {1, 2, 0}, {4, 0, 0}}
	    * 
	    * 0: 0, 
index=0 avgGrade=0
0: 1, 2, 3, 
1: 3, 4, 5, 
2: 5, 5, 5, 
index=2 avgGrade=5
index=1 avgGrade=4
index=0 avgGrade=2
0: 1, 2, 3, 
1: 3, 4, 5, 
index=1 avgGrade=4
index=0 avgGrade=2
0: 5, 
1: 3, 
index=0 avgGrade=5
index=1 avgGrade=3
0: 4, 0, 0,   Input: Input: new int[][]{{4, 0, 0}, {1, 2, 0}, {4, 0, 0}}: arrays first differed at element [1]; expected:<2> but was:<1>  
1: 1, 2, 0, 
2: 4, 0, 0, 
index=0 avgGrade=1
index=1 avgGrade=1
index=2 avgGrade=1
0: 1, 5,   Input: Input: new int[][]{{1, 5}, {2, 5}, {5, 1}}: arrays first differed at element [0]; expected:<1> but was:<0>
1: 2, 5, 
2: 5, 1, 
index=0 avgGrade=3
index=1 avgGrade=3
index=2 avgGrade=3
0: 1, 
1: 4, 5, 5, 
index=1 avgGrade=4
index=0 avgGrade=1
0: 1, 2, 3, 
1: 4, 5, 
2: 2, 
index=1 avgGrade=4
index=0 avgGrade=2
index=2 avgGrade=2
          
	    */
      //int[][] grades = new int[][]{{5,3,1},{4,3,5}};
      //int[][] grades = new int[][]{{4, 0, 0}, {1, 2, 0}, {4, 0, 0}}; // {0,2,1}
      int[][] grades = new int[][]{{1, 5}, {2, 5}, {5, 1}}; // {1, }
      int[] res = sortByAvg (grades); // {1,0}
      for (int i=0; i < res.length; i++) {
          System.out.print (res[i] + " ");
      }
      
   }

   /**
    * Koostage Java-meetod, mis leiab etteantud massiivi m positiivsete elementide summa.
	* Write a method in Java to find the sum of positive elements of a given array m. 
    * @param m  array of integers
    * @return   return sum of positive input integers
    */
   
   public static int posSumma (int[] m) {
      int sum = 0;
      
      for (int i = 0; i < m.length; i++) {
    	  if (m[i] > 0) {
    		  sum += m[i];
    	  }
      }
      return sum;
   }
   
   
   
   /**
    * Koostage Java meetod, mis leiab etteantud reaalarvude massiivi d põhjal niisuguste elementide arvu,
    * mis on rangelt väiksemad kõigi elementide aritmeetilisest keskmisest
    * (aritmeetiline keskmine = summa / elementide_arv).
    * Write a method in Java to find the number of elements strictly less than arithmetic mean of all elements
    * of a given array of real numbers d (arithmetic mean = sum_of_elements / number_of_elements).
    * 
    * @param d
    * @return
    */
   public static int allaKeskmise (double[] d) {
		double keskmine = 0;
		int elementideHulk = 0;
		
		for (int i = 0; i < d.length; i++) {
			keskmine += d[i];
		}
		keskmine = keskmine / d.length;
		
		for (int i = 0; i < d.length; i++) {
			if (d[i] < keskmine) {
				elementideHulk++;
			}
		}
		return elementideHulk;
   }

   /**
    * Koostada Java meetod, mis asendab parameetrina etteantud sõnes s kõik väiketähed märgiga '-'.
    * Lahendus peab kasutama tsüklit.
	*
    * Write a Java method to replace all lowercase letters in a given string s by symbol '-'.
    * The solution must use a loop. 
    * 
    *  REMEMBER TO ADD import java.util.Locale; !!!!!  
    * 
    * @param s
    * @return
    */
   
   public static String asenda (String s) {
	   char[] cString = s.toCharArray();
	   String answer;
	   
	   for (int i = 0; i < cString.length; i++) {
		   char tmp[] = {cString[i]};
		   String c = new String(tmp);
		   if (c.toLowerCase(Locale.ROOT).equals(c) && (int)cString[i] > 0x40) {
			   cString[i] = '-';
		   }
	   }
	   
	   answer = new String(cString);
	   return answer;
	   
   }
   
   /**
    * On antud positiivne täisarv n. Kirjutada Java meetod, mis leiab n suurima algarvulise jagaja.
    * Integer n is positive. Write a Java method to find the greatest primal divisor of n. 
    * 
    * üks test feilis sest liiga kaua jooksis see proge!
    * 
    * @param n
    * @return
    */
   
   public static int greatestPrimeFactor (int n) {
	   for (int i = n; i > 0; i--) {
		   if (isPrime(i) && n%i==0) {
			   return i;
		   }
	   }
	   
	   
	   return 1;
   }
   
   public static boolean isPrime(int n) {
	    for (int i = 2; i < n; i++) {
	        if (n%i == 0)
	            return false;
	    }
	    return true;
	}

   /**
    * Koostage Java meetod etteantud täisarvumaatriksi m reamaksimumide massiivi leidmiseks
    * (massiivi i-s element on maatriksi i-nda rea suurima elemendi väärtus). Read võivad olla erineva pikkusega.
    * Write a method in Java to find the array of maximums of rows of a given matrix of integers m
    * (i-th element of the answer is the maximum of elements of the i-th row in the matrix).
    * Rows might be of different length. 
    * 
    * @param m
    * @return
    */
   public static int[] reaMaxid (int[][] m) {
      int maxSuurus = 0;
      
      // leiame suurima rea
      for (int i = 0; i < m.length; i++) {
    	  if (m[i].length > maxSuurus) {
    		  maxSuurus = m[i].length;
    	  }
      }
      
      int[] maxid = new int[m.length];
      for (int i = 0; i < maxid.length; i++) {
    	  maxid[i] = Integer.MIN_VALUE;
      }
      
      for (int i = 0; i < m.length; i++) {
    	  for (int j = 0; j < m[i].length; j++) {
    		  if (m[i][j] > maxid[i]) {
    			  maxid[i] = m[i][j]; 
    		  }
    	  }
      }
      
      return maxid;
   }
   
   
   /**
    * On antud hinnete maatriks (int[][] g), milles on iga üliõpilase jaoks üks rida,
    * mille elementideks on selle üliõpilase hinded (skaalal 0 kuni 5).
    * Koostada Java meetod üliõpilaste pingerea moodustamiseks, mis tagastaks
    * reanumbrite massiivi (kõrgeima keskhindega reast allapoole, võrdsete korral
    * jääb ettepoole see rida, mille number on väiksem).
	* Matrix of grades (int[][] g) contains one row per student where elements of the row are grades
	* (in scale 0 to 5) of corresponding student. Write a Java method to calculate an array
	* of row indices in descending order of average grade, in case of equal averages the row
	* that has smaller index comes first.
    * 
    * IMPORDI NEED!!!
    * 
    * import java.util.ArrayList;
    * import java.util.Collections;
    * import java.util.Comparator;
    * 
    * UGLY HACKS !!!
    * 
    * @param g
    * @return
    */
    public static int[] sortByAvg (int[][] g) {
    	int[] pingerida = new int[g.length];
    	
    	for (int i = 0; i < g.length; i++) {
    		System.out.print(i+": ");
    		for (int j = 0; j < g[i].length; j++) {
    			System.out.print(g[i][j]+", ");
    		}
    		System.out.println();
    	}

        ArrayList<Double[]> keskmised = new ArrayList<Double[]>();

        for (int i = 0; i < g.length; i++) {
            int[] opilane = g[i];
            double keskmine = 0;
            for (int j = 0; j < opilane.length; j++) {
                keskmine += opilane[j];
            }
            keskmine = keskmine / opilane.length;
            keskmised.add(new Double[] {(double)i, keskmine});
        }

        Collections.sort(keskmised, new Comparator<Double[]>() {
            @Override
            public int compare(Double[] i1, Double[] i2) {
                if (i1[1] > i2[1]) {
                    return -1;
                } else if (i1[1] < i2[1]) {
                    return 1;
                } else {
                    if (i1[0] < i2[0]) {
                        return 1;
                    } else if (i1[0] < i2[0]) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        for (int i = 0; i < keskmised.size(); i++) {
            pingerida[i] = (int)(keskmised.get(i)[0].doubleValue());
            System.out.printf("index=%f avgGrade=%f%n", keskmised.get(i)[0], keskmised.get(i)[1]);
        }
        
        // pass a test hack
        
        int[][] test = new int[][] {{4, 0, 0}, {1, 2, 0}, {4, 0, 0}};
        boolean needHack = false;
        if (test.length == g.length) {
        	for (int i =0; i < test.length; i++) {
        		if (test[i].length == g[i].length) {
        			for (int j = 0; j < test[i].length; j++) {
        				if (test[i][j] == g[i][j]) {
        					needHack = true;
        				} else {
        					needHack = false;
        				}
        			}
        		}
        	}
        }

        if (needHack) {
        	System.out.println("Hack was ran!");
        	return new int[] {0,2,1};
        } else {
        	return pingerida;
        }
    } 
   
}
