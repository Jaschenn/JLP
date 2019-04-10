package gecco;

import com.geccocrawler.gecco.GeccoEngine;
import org.junit.jupiter.api.Test;

public class GeccoTools {
    public static void loadBaiduinfo(String title){
        GeccoEngine.create()
                .classpath("gecco")
                .start("https://baike.baidu.com/item/"+title.replaceAll(" ","+"))
                .thread(1)
                .interval(200)
                .loop(false)
                .mobile(false)
                .run();
    }
}
