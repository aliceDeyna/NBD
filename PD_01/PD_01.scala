import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}
import java.io._ 
import scala.util.Random

/*
 * Stwórz 7 elementową listę zawierającą nazwy dni tygodnia.
 * Napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami korzystając z:
 */

object Excercise_1_Scala {
  def main(args: Array[String]) = {
    val days_ofTheWeek = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
    
    /*
     * a) Pętli for
     */
    
    def task_1a(days_ofTheWeek: List[String]) = {
      var str = "";
      for (i <- 0 until days_ofTheWeek.length) {
        if (str != "")
          str += ", " + days_ofTheWeek.get(i)
          else
            str = days_ofTheWeek.get(i)
            }
      str
      }
    
    /*
     * b) Pętli for wypisując tylko dni z nazwami zaczynającymi się na „P”
     * */
    
    def task_1b(days_ofTheWeek: List[String]) = {
      var main_1b = "";
      for (i <- 0 until days_ofTheWeek.length) {
        breakable {
          if (!days_ofTheWeek.get(i).startsWith("P")) break
          if (main_1b != "")
            main_1b += ", " + days_ofTheWeek.get(i)
            else
              main_1b += days_ofTheWeek.get(i)
              }
        }
      main_1b;
      }
    
    /*
     * c) Pętli while
     */
    
    def task_1c(days_ofTheWeek: List[String]) = {
      var main_1c = ""
      var i = 0;
      while (i < days_ofTheWeek.length) {
        if (main_1c != "")
          main_1c += ", " + days_ofTheWeek.get(i)
          else
            main_1c += days_ofTheWeek.get(i)
            i = i + 1;
        }
      main_1c
      }
    
    /*
     * 2. Dla listy z ćwiczenia 1 napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami 
     * korzystając z:
     */
    
    /*
     * a)	Funkcji rekurencyjnej 
     */
    
    def task_2a(days_ofTheWeek: List[String]) = {
      def main_2a(i: Int): String = {
        if (i == days_ofTheWeek.length) return ""
        val day = if (i == days_ofTheWeek.length - 1) days_ofTheWeek.get(i) else days_ofTheWeek.get(i) + ", "
        day + main_2a(i + 1)
    }
      main_2a(0);
      }
    
    /*
     * b) 	Funkcji rekurencyjnej wypisując elementy listy od końca
     */
    
    def task_2b(days_ofTheWeek: List[String]): String = {
      def main_2b(i: Int): String = {
        if (i == -1) return ""
        val day = if (i == 0) days_ofTheWeek.get(i) else days_ofTheWeek.get(i) + ", "
        day + main_2b(i - 1)
        }
      main_2b(days_ofTheWeek.length - 1)
      }
    
    /*
     * 3.	Stwórz funkcję korzystającą z rekurencji ogonowej do zwrócenia oddzielonego przecinkami stringa zawierającego 
     * elementy listy z ćwiczenia 1  
     */
      
    def task_3(days_ofTheWeek: List[String]) = { @tailrec
      def main_3(i: Int, str: String) : String = {
      if (i == days_ofTheWeek.length) 
        return str
        val day = if (i == days_ofTheWeek.length - 1) days_ofTheWeek.get(i) 
        else days_ofTheWeek.get(i) + ", "
        main_3(i + 1, str + day)
        }
    main_3(0, "")
    }
    
    /*
     * 4.	Dla listy z ćwiczenia 1 napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi 
     * przecinkami korzystając z: 
     */
    
    /*
     * a)	Metody foldl 
     */
     
    def task_4a(days_ofTheWeek: List[String]) : String = {
      days_ofTheWeek.foldLeft("") 
        { (z, f) => {
          z + f + ", " }}.dropRight(2) /* kasuję przecinek na końcu */
          }
      
      /*
       * b) 	Metody foldr
       */
      
        def task_4b(days_ofTheWeek: List[String]) : String = {
          days_ofTheWeek.foldRight("")
          { (z, f) => {
            z + ", " + f }}.dropRight(2)
            }
        
        /*
         * c) 	Metody foldl wypisując tylko dni z nazwami zaczynającymi się na „P”
         */

        def task_4c(days_ofTheWeek: List[String]) : String = {
          days_ofTheWeek.foldLeft("") 
          {(z, f) => {
            if (f.startsWith("P"))
              z + f + ", "
            else z}}.dropRight(2)
            }
        
        /*
         * 5.	Stwórz mapę z nazwami produktów i cenami. Na jej podstawie wygeneruj drugą, z 10% obniżką cen. 
         * Wykorzystaj mechanizm mapowania kolekcji. 
         */
        
        val products_name = Map("Banana" -> 5, "Pineaplle" -> 10, "Orange" -> 15)
        val products_price = products_name map { case (key, value) => (key, value * 1.1) }
        
        /*
         * 6.	Zdefiniuj funkcję przyjmującą krotkę z 3 wartościami różnych typów i wypisującą je
         */
        
        val tuple = Tuple3(33, "abcdef", 55.55)
        
        /*
         * 7.	Zaprezentuj działanie Option na dowolnym przykładzie (np. mapy, w której wyszukujemy wartości 
         * po kluczu)
         */
        
        val Banan_price = products_name.get("Banana")
        val Pineaplle_price = products_name.get("Pineaplle")
        val Orange_price = products_name.get("Orange")
        
        /*
         * 8.	Napisz funkcję usuwającą zera z listy wartości całkowitych (tzn. zwracającą listę elementów mających 
         * wartości różne od 0). 
         * Wykorzystaj rekurencję. 
         */
        
        def task_8(main_list: List[Int]): List[Int] = {
          def main_8(i: Int, our_list: List[Int]): List[Int] = {
            if (i >= our_list.length) 
              return our_list;
            
            val (list_1, list_2) = our_list.splitAt(i)
            if (our_list.get(i) == 0)
              main_8(i + 1, list_1 ++ list_2.tail)
              else
                main_8(i + 1, our_list)
                }
          main_8(0, main_list)
          }
        
        val test_list = -5 to 5 toList
        
        /*
         * 9.	Zdefiniuj funkcję, przyjmującą listę liczb całkowitych i zwracającą wygenerowaną na jej podstawie 
         * listę, w której wszystkie liczby zostały zwiększone o 1. 
         * Wykorzystaj mechanizm mapowania kolekcji.
         */
        
        def task_9(test_list: List[Int]): List[Int] = {
          test_list map (i => i + 1)
          }
        
        /*
         * 10.	Stwórz funkcję przyjmującą listę liczb rzeczywistych i zwracającą stworzoną na jej podstawie listę 
         * zawierającą wartości bezwzględne elementów z oryginalnej listy należących do przedziału <-5,12>. 
         * Wykorzystaj filtrowanie.
         */
        
        def task_10(main_list: List[Int]): List[Int] = {
          val filteredList = main_list filter(x => x >= -5 && x <= 12)
          filteredList map (x => x.abs)
          }
        
    val test_list_10 = List(-30, -13, -8, -6, -5, -3, 2, 0, 1, 2, 3, 4, 5, 6, 8, 13, 30)
    
    println( "1. a) " + task_1a(days_ofTheWeek))
    println( "1. b) " + task_1b(days_ofTheWeek))
    println( "1. c) " + task_1c(days_ofTheWeek))
    println( "2. a) " + task_2a(days_ofTheWeek))
    println( "2. b) " + task_2b(days_ofTheWeek))
    println( "3. " + task_3(days_ofTheWeek))
    println( "4. a) " + task_4a(days_ofTheWeek))
    println( "4. b) " + task_4b(days_ofTheWeek))
    println( "4. c) " + task_4c(days_ofTheWeek))
    println( "5. " + products_price)
    println( "6. " + tuple._1 + ", " + tuple._2 + ", " + tuple._3)
    println( "7. " + Banan_price + ", " + Pineaplle_price + ", " + Orange_price)
    println( "8. " + task_8(test_list))
    println( "9. " + task_9(test_list))
    println( "10. " + task_10(test_list_10))
    }
  }

