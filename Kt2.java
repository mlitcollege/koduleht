package KT2;

public class Answer {

	public static void main(String[] args) {
		System.out.println(keskmisestParemaid(new double[] { 0. }));
		int[][] res = liitmisTabel(9);

		for (int[] row : res) {
			for (int col : row) {
				System.out.printf("%3d ", col);
			}
			System.out.println();
		}

		System.out.println("score on: " + score(new int[] { 4, 1, 2, 3, 0 }) + ", peaks olema 9"); // 9
		System.out.println("score on: " + score(new int[] { -2, -1, -1, 0 }) + ", peaks olema -1"); // -1
		System.out.println("score on: " + score(new int[] { 3, 6, 2, 8, 4 }) + ", peaks olema 18"); // 18
		System.out.println("score on: " + score(new int[] { 9, 1, 1, 3 }) + ", peaks olema 12"); // 12

        veeruMinid(new int[][] {{1,2,3},{1,5},{5,8,4,8,9}});
        
        //new int[][]{{1, 2, 6}, {-4, 5, 3}} // return.length=3, return array peab olema {-4, 2, 3}
        veeruMinid(new int[][]{{1, 2, 6}, {-4, 5, 3}});
        
        //new int[][]{{1, 2, 0}, {4, 0, 0}}  // return.length=3
        veeruMinid(new int[][]{{1, 2, 0}, {4, 0, 0}});
        
        //new int[][]{{1}, {4, 5, 6}}  // return.length=3
        veeruMinid(new int[][]{{1}, {4, 5, 6}});
        
	}

	
	/*
	 * funktsioon ei tohi välja kutsuda teisi siin defineeritud funktsioone (vähemalt sedasi sain ma aru pöidla jutust)
	 * package ei tohi olla moodles seal code aknas
	 * kui impordid midagi siis need peavad ka olema seal moodle code aknas olemas alguses
	 * soovitatav on eclipse panna seda koodi kompileerima java 1.6'ga (ei tea täpselt kuidas see käib, googelda)
	 * */
	
	
	// leiab 2D masiivi iga veeru minimummi ja tagastab need
	public static int[] veeruMinid(int[][] m) {
		int min_size = 0;
		
		for (int[] row : m){
            if (row.length > min_size){
                min_size = row.length;
            }
        }
		
		// loome miinimummide salvestamiseks massiivi mis on sama pikk kui ette antud masiiv
		int[] minimummid = new int[min_size];
		
		
		for (int i = 0; i < minimummid.length; i++) {
			int min = Integer.MAX_VALUE;  // antud rea väikseim arv
			for (int x = 0; x < m.length; x++) {
				if (m[x].length > i && m[x][i] < min) {
					min = m[x][i];
					System.out.printf("%3d", min);  // prindime välja meie sisendi
				}
			}
			// pistame leitud minimummi meie minimumme hoidvasse arraysse 
			minimummid[i] = min;
			// prindime uue rea ja leitud minimummi 
			System.out.printf("%n min on:%3d%n", min);
		}
		/*
		for (int x = 0; x < m.length; x++) {  // käime läbi kõik veerud	
			
			for (int y = 0; y < m[x].length; y++) {  // käime läbi kõik read seal veerus
				int el = m[x][y];
				System.out.printf("%3d", el);  // prindime välja meie sisendi
				if (el < min) {
					min = el;
				}
			}
			// pistame leitud minimummi meie minimumme hoidvasse arraysse 
			minimummid[x] = min;
			// prindime uue rea ja leitud minimummi 
			System.out.printf("%n min on:%3d%n", min);
		}*/
		
		System.out.print("minimummid on: ");
		for (int el : minimummid) {
			System.out.print(el+", ");
		}
		System.out.println();
		
		return minimummid;
	}


/*  väljund moodles jooksutamisel, also fuck java ja see moodle keskond
sisend:  1  2  3
min1 arv on 1 indeksiga 0
min2 arv on 2 indeksiga 1
sisend:  0  1  2  3  4  5  6
min1 arv on 0 indeksiga 0
min2 arv on 1 indeksiga 1
sisend:  1  2  1
min1 arv on 1 indeksiga 0
min2 arv on 1 indeksiga 2
sisend:  9  8  1  7  8  9
min1 arv on 1 indeksiga 2
min2 arv on 7 indeksiga 3
sisend: -2 -1 -1  0
min1 arv on -2 indeksiga 0
min2 arv on -1 indeksiga 1
sisend:  8  2  8  5  1
min1 arv on 1 indeksiga 4
min2 arv on 2 indeksiga 1
sisend:  9  1  1  3
min1 arv on 1 indeksiga 1
min2 arv on 1 indeksiga 2
*/
	public static int score(int[] points) {
		// prindime välja meile ette antud masiivi
		System.out.print("sisend:");
		for (int el : points) {
			System.out.printf("%3d", el);
		}
		System.out.println();
		
		int score = 0;  // palju lõpuks punkte koos on

		int min1 = Integer.MAX_VALUE; // array väikseim arv
		int min1_i = 0; // mis indexi peal ta asub
		
		int min2 = Integer.MAX_VALUE;  // array suuruselt järgmine väikseim arv, juhul kui min1 arve on kaks või rohkem siis min1 == min2
		int min2_i = 0;  // kus kohas see teine arv asub arrays
		
		if (points.length < 3) {  // katseid kokku peab olema rohkem kui 2
			return 0;  // katseid oli vähem kui 3, punktisumma on järelikult 0
		}
		
		// leiame kõige väiksema arvu
		for (int i = 0; i < points.length; i++) {
			int point = points[i];
			if (point < min1) {
				min1 = point;
				min1_i = i;
			}
		}
		System.out.println("min1 arv on "+min1+" indeksiga "+min1_i);
		
		// leiame suuruselt järgmise arvu
		for (int i = 0; i < points.length; i++) {
			int point = points[i];
			if (point < min2 && i != min1_i) {
				min2 = point;
				min2_i = i;
			}
		}
		System.out.println("min2 arv on "+min2+" indeksiga "+min2_i);
		
		// arvutame kokku punkti summa
		for (int i = 0; i < points.length; i++) {
			int point = points[i];
			if (i != min1_i && i != min2_i) {
				score += point;
			}
		}
		
		return score;
	}
	
/*  // Marguse koodi üritasin päästa, ei toiminud 
    // dont use!!!!
	public static int score(int[] points) {
		int score = 0;
		int min1_i = 0;  // hoiab esimese kõige väiksema indeksit
		int min1 = Integer.MAX_VALUE;
		int min2_i = 0;  // hoiab teise kõige väiksema tulemuse indeksit
		int min2 = Integer.MAX_VALUE;
		// kui on vähem kui 3 katset ja kahe halvima tulemused eemaldatakse, on
		// tulemus null
		if (points.length < 3) {
			return 0;
		} else {
			// leian miinimumtulemused
			// siin ei toimi `for (element : points)` sest vaja on salvestada mis indexi peal
			// need kõige väiksemad punkti summad asuvad et neid hiljem ignoreerida
			for (int i = 0; i < points.length; i++) {
				int element = points[i];
				if (element < min1 && min1 > min2) {
					System.out.println("min1:" + element + " " + min1);
					min1_i = i;
					min1 = element;
					
				}
				if (element < min2 && element != min1) {
					System.out.println("Min2. " + element + " " + min2 + " min1: " + min1);
					min2_i = i;
					min2 = element;
				}
			}
			// arvutan punktide tulemuse, vältides kahte miinimumpunkti
			for (int i = 0; i < points.length; i++) {
				int element = points[i];
				if (i != min1_i && i != min2_i) {
					score += element;
				}
			}
			System.out.println(min1 + " " + min2);
			return score;
		}
	}
*/
	public static int keskmisestParemaid(double[] d) {
		double keskmine = 0;
		int elementideHulk = 0;

		for (int i = 0; i < d.length; i++) {
			keskmine += d[i];
		}
		keskmine = keskmine / d.length;

		for (int i = 0; i < d.length; i++) {
			if (d[i] > keskmine) {
				elementideHulk++;
			}
		}
		return elementideHulk;
	}

	public static int[][] liitmisTabel(int n) {
		int[][] m = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = i + j;
			}
		}

		return m;
	}

}
