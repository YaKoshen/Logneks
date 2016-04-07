package cyclic;

import java.util.ArrayList;
import java.util.List;

public class Dependents {
	private List<Integer> col1 = new ArrayList<Integer>();
	private List<Integer> col2 = new ArrayList<Integer>();
	
	public Dependents(ArrayList<String> depsList) {
		for(int i=0; i<depsList.size(); i++) {
			col1.add(Integer.parseInt(depsList.get(i).split(" ")[0]));
			col2.add(Integer.parseInt(depsList.get(i).split(" ")[1]));
		}
	}

	public ArrayList<String> getCyclic() {
		ArrayList<String> depsCyclic = new ArrayList<String>();
		for(int i=0; i<(col1.size()-1); i++) {
			for(int j=(i+1); j<col1.size(); j++) {
				if(col1.get(i).equals(col2.get(j)) && col2.get(i).equals(col1.get(j))) {
					depsCyclic.add(col1.get(i)+" "+col2.get(i)+" "+col1.get(i));
				}
			}
		}

		return depsCyclic;
	}
}
