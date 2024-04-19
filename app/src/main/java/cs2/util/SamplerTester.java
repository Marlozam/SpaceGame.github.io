package cs2.util;

import java.util.ArrayList;
import java.util.Collections;

public class SamplerTester {
  public static void main(String[] args) {
    Sampler data = new Sampler(args[0]);
    Sampler test = new Sampler();
    for(int i = 0; i < 1000000; i++) {
      test.increment(data.sample());
    }
    if(test.getWords() == null) {
      System.out.println("getWords() is not implemented");
    } else {
      ArrayList<String> words = new ArrayList<String>(test.getWords());
      Collections.sort(words);
      double epsilon = 0.001;
      for (String word : words) {
        double frequenceDifference = Math.abs(test.getProbability(word) - data.getProbability(word));
        if (frequenceDifference > epsilon) {
          System.out.println(word + " " + test.getProbability(word) + " " + data.getProbability(word));
        } else {
          System.out.println(word + "\tfrequency is within " + epsilon + " of " + String.format("%.04f", data.getProbability(word)));
        }
      }
    }
  }
}
