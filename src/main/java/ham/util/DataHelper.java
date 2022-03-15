package ham.util;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataHelper {

    public int getRandomNumber(int low, int high){
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }

    public String getBookTitle() {
        Faker myfaker = new Faker();
        return myfaker.book().title();
    }
}
