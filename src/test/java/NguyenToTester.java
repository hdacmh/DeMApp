
import com.hdacmh.services.NguyenToService;
import java.time.Duration;
import java.util.stream.Stream;
//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hoang
 */
public class NguyenToTester {
//   @BeforeAll
//   public static void beforeAll(){
//       System.out.println("Before All");
//   }
//   
//   @AfterAll
//   public static void afterAll(){
//       System.out.println("After All");
//   }
//    @Test
//    public void testOddNumber(){
//        boolean actual = NguyenToService.isNguyenTo(5);
//        boolean expected = true;
//        Assertions.assertEquals(expected, actual);
//    }
//    @Test
//    public void testEvenNumber(){
//        boolean actual = NguyenToService.isNguyenTo(8);
//        Assertions.assertFalse(actual);
//    }
//    @Test
//    public void testExc(){
//       Assertions.assertThrows(ArithmeticException.class, ()->{NguyenToService.isNguyenTo(-4);});
//    }
//     @Test
//    public void testTimeOut(){
//       Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), ()->{
//           NguyenToService.isNguyenTo(9);});
//}
    @ParameterizedTest
    @ValueSource(ints = {4,6,8,12,18,66})
    public void testEvenNumber(int n){
       boolean actual = NguyenToService.isNguyenTo(n);
       boolean expected = false;
       Assertions.assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({"2,true", "4,false", "5,true", "6, false"})
    public void CsvSourceTest(int n, boolean expected){
       boolean actual = NguyenToService.isNguyenTo(n);
       Assertions.assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
    public void CsvFileSource(int n, boolean expected){
       boolean actual = NguyenToService.isNguyenTo(n);
       Assertions.assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource(value = "loadData")
    public void methodSourceTest(int n, boolean expected){
       boolean actual = NguyenToService.isNguyenTo(n);
       Assertions.assertEquals(expected, actual);
    }
    static Stream<Arguments> loadData(){
        return Stream.of(
                arguments(4, false),
                arguments(2, true)
        );
    }
}
