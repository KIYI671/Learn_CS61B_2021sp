package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    public static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static final double CONCERT = 440.0;
    //public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    public static void main(String[] args) {
        GuitarString string=new GuitarString(CONCERT);

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int k = keyboard.indexOf(key);
                if (k >= 0) {
                    string = new GuitarString(CONCERT * Math.pow(2, (k - 24) / 12.0));
                    string.pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = string.sample() + string.sample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            string.tic();
        }
    }
}

