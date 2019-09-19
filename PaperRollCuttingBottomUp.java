//author Sean Adam Holland R00162740
public class PaperRollCuttingBottomUp {

	
		
	public void pCutting(int pSize) {
		if(pSize < 1)
			System.out.println("Sorry number must be greater than 0");
		else {
			double price[] = new double[6];
			price[1] = 1.2;
			price[2] = 3;
			price[3] = 5.8;
			price[4] = 0;
			price[5] = 1000;
			int firstcut[] = new int[pSize+1]; // holds first cut position
			double revenue[] = new double[pSize+1]; // holds max revenue per paper length
			revenue[0] = 0; // assigns paper cut size 0 to 0
		
			for(int size = 1; size < firstcut.length; size++) {
			
				double bestPrice = -99999;
				for(int cut = 1; cut < price.length; cut++ ) {
					if(cut == 4) // there is no cut 4 so it is skipped
						continue;
					if(size-cut >= 0) { // checks if the cut isnt bigger than the paper size
						if(bestPrice < price[cut] + revenue[size-cut]) { // loops through the price array to find the best firstcut for max revenue
							bestPrice = price[cut] + revenue[size-cut]; // if its bigger than bestPrice, it becomes bestPrice
							firstcut[size] = cut; // the firstcut is saved for the length size
						}
				
					}
					revenue[size] = bestPrice; // best revenue for length 'size' is saved into the revenue array
				}
			}
			for(int i = 1; i < revenue.length; i++) // prints out max revenue for the paper size, bottom-up
				System.out.println("revenue for position "+i+" "+revenue[i] );
		
		
			System.out.println("\n\n");
		
			int position = pSize;
			for(int i = 1; position > 0; i++) { // while loop to print out all cuts for given 'position'
				System.out.println("Cut "+i+": "+ firstcut[position]);
				position -= firstcut[position]; // position minus its first cut
			}
		}
	}

	



		public static void main(String[] args) {
			// TODO Auto-generated method stub
			PaperRollCuttingBottomUp test = new PaperRollCuttingBottomUp();
			test.pCutting(15);
		}
}
