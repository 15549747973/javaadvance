import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 蔡心勇
 * @create 2022/3/20 - 17:52
 */
public class Test2 {
    public static void main(String[] args) {

    }

    @MyTest
    public void test1(){

    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyTest{

}
