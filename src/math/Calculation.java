package math;

import java.sql.Timestamp;
import java.util.Random;

/**
 * Created by AlanJager on 2017/6/26.
 */
public class Calculation {
    public static void main(String[] args) {
        new Timestamp(1498735769 * 1000L + (long) msg.getRepeatCount() * (long) 12 * 1000L);


        long megaByte128 = 128;

        Random random = new Random(128);

        for (int i = 0 ; i < 1000 ; i++) {
            long increase = random.nextLong();
            increase = increase >= 0 ? increase : -increase;
            long increaseBytes = UnitSize.megaByteToBytes(increase);

            long remainBytes = increaseBytes % UnitSize.megaByteToBytes(128);
            if (increaseBytes != 0 && remainBytes != 0) {
                System.out.println("run " + i + " times");
                if (remainBytes < UnitSize.megaByteToBytes(128) / 2 ) {
                    increaseBytes = increaseBytes / UnitSize.megaByteToBytes(128) * UnitSize.megaByteToBytes(128);
                } else {
                    increaseBytes = (increaseBytes / UnitSize.megaByteToBytes(128) + 1) * UnitSize.megaByteToBytes(128);
                }

                System.out.println("alignment to " + increaseBytes);
                if (increaseBytes % UnitSize.megaByteToBytes(128) != 0) {
                    System.out.println("error");
                    System.exit(0);
                }
            }
        }


    }

    static class UnitSize {
        public static long megaByteToBytes(long megaByte) {
            return megaByte * 1024 * 1024;
        }
    }
}
