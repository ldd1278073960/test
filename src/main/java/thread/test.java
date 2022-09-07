package thread;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @author Ldp
 * @date 2022/3/23
 */
public class test {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        int integer = 20220106;
        if (integer >= 20220101 && integer <= 20220105) {
            for (int i = 20220101; i <= integer; i++) {
                result.add(String.valueOf(i));
            }
        }
        System.out.println(result);
    }






}
