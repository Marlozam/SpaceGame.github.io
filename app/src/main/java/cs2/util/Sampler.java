package cs2.util;
import java.io.File;
import java.util.*;

public class Sampler {
    private HashMap<String, Integer> counts;

    // constructors 
  public Sampler() {
    counts = new HashMap<String, Integer>();
  }
  public Sampler(String filename) {
    counts = new HashMap<String, Integer>();
    try{
    File f = new File(filename);
    Scanner scan = new Scanner(f);
    while(scan.hasNextLine()){
        String line = scan.nextLine();
        // 
        String[] parts = line.split("\t");
        counts.put(parts[0], Integer.parseInt(parts[1]) );
    }}
    // using catch and exception to catch user errors 
    catch (Exception e){
        e.printStackTrace();
        //System.out.println("error message" + e.printStackTrace());
    }

    // methods 
  }

  public void increment(String word) {
    if (counts.containsKey(word) == false){
        counts.put(word, 1);
    }
    else{
        int val = counts.get(word);
        int add = val + 1;
        // have to put it back into HashMap in order to value ot update 
        counts.put(word, add);
    }
  }

  public int totalCount() {
    int total = 0;
    for(String word : counts.keySet()){
        int val = counts.get(word);
      total =+ val;
        
    }
    return total;
    //return 0;// why did he put a return 0 here 
  }

  public int getCount(String word) {
    if (counts.containsKey(word)){
        return counts.get(word);
        
    }
    else{ return 0;}
    

  }

  public double getProbability(String word) {
    if(counts.containsKey(word)){
       int prob = getCount(word) / totalCount();
       //changing a int into a double 
       return (double) prob;

    }else{
        return 0;}
  }

  public Set<String> getWords() {
    return counts.keySet();
  }

  public String sample() {
    double prob = 0;
    double num = Math.random();

    for(String word : counts.keySet()){
      double wProb = getProbability(word);
      prob += wProb;

      if (num <= prob){
        return word;
      }

    }
    // should I put iterator here?
    // I did;nt really use an iterator 
    // should I add one?
    return counts.keySet().iterator().next();
  }
  // write here I can wrtie my tester code for more cases and be like staic main args

}


