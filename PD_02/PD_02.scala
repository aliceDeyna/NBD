

    /* 
     * 1.	Wykorzystaj Pattern Matching w funkcji przyjmującej parametr typu String. 
 		 * Dla stringów odpowiadających nazwom dni tygodnia funkcja ma zwrócić „Praca” i „Weekend” 
 		 * (odpowiednio dla dni roboczych i wolnych), dla pozostałych napisów „Nie ma takiego dnia”. 
 		 */ 

object Excercise_2_Scala {
  
  def task_1(str: String): String = {
    val dni_robocze = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek")
    val dni_wolne = List("Sobota", "Niedziela")

    str match {
      case robocze if (dni_robocze.contains(robocze)) => "Praca"
      case wolne if (dni_wolne.contains(wolne)) => "Weekend"
      case _ => "Nie ma takiego dnia"
    }
  }

  def main(args: Array[String]): Unit = {
    
  }

    /*
     * 2. Zdefiniuj klasę KontoBankowe z metodami wplata i wyplata oraz własnością stanKonta - 
     * własność ma być tylko do odczytu.
     * Klasa powinna udostępniać konstruktor przyjmujący początkowy stan konta oraz drugi, 
     * ustawiający początkowy stan konta na 0.
     */

class KontoBankowe(poczatkowy_stan_konta: Double) {
  private var stan_konta: Double = poczatkowy_stan_konta

  def stanKonta: Double = stan_konta

  def this() {
    this(0)
  }

  def wplata(kwota_wplaty: Double): Double = {
    stan_konta = stan_konta + kwota_wplaty
    stan_konta
  }

  def wyplata(kwota_wyplaty: Double): Double = {
    if (stan_konta - kwota_wyplaty < 0) 
      return stan_konta

    stan_konta = stan_konta - kwota_wyplaty
    stan_konta
  }
}

val task_2 = new KontoBankowe()

    /* 
     * 3. Zdefiniuj klasę Osoba z własnościami imie i nazwisko. Stwórz kilka instancji tej klasy. 
 		 *  Zdefiniuj funkcję, która przyjmuje obiekt klasy osoba i przy pomocy Pattern Matching wybiera i zwraca napis 
 		 *  zawierający przywitanie danej osoby. Zdefiniuj 2-3 różne przywitania dla konkretnych osób 
 		 *  (z określonym imionami lub nazwiskami) oraz jedno domyślne. 
 		 */

case class Osoba(val imie: String, val nazwisko: String) {
  val task_3 = 0
}

 def siemka(osoba: Osoba) = {
    val przywitania = osoba match {
      case Osoba("Tomasz", "Polski") => "Cześć, jestem Tomasz!"
      case Osoba("John", "American") => "Hello, I am John!"
      case Osoba("André", "Français") => "Bonjour, je m'appelle André."
      case _ => "Dzień dobry/Hello/Bonjour."
    }

    println(przywitania)
    przywitania
  }
 
    val osoba = Osoba("Tomasz", "Polski")
    val person = Osoba("John", "American")
    val personne = Osoba("André", "Français")
    val domyslne = Osoba("Co", "Innego")
    
    /* 
     * 4.	Zdefiniuj funkcję przyjmującą dwa parametry - wartość całkowitą i funkcję operującą na wartości całkowitej. 
     * Zastosuj przekazaną jako parametr funkcję trzykrotnie do wartości całkowitej i zwróć wynik.
     */
    
    def task_4(number: Int, wartosci: (Int) => Int): Int = {
    wartosci(wartosci(wartosci(number)))
    }
    
    def task_4_(number: Int): 
    Int = number - 10
    
    val number = 555
    
    /*
     * 5.	Zdefiniuj klasę Osoba i trzy traity: Student, Nauczyciel, Pracownik. Osoba powinna mieć własności read only: 
     * imie, nazwisko, podatek. Pracownik powinien mieć własność pensja (z getterem i seterem). 
     * Student i Pracownik powinni przesłaniać własność podatek – dla Studenta zwracamy 0, dla Pracownika 20% pensji. 
     * Nauczyciel powinien dziedziczyć z Pracownika, dla niego podatek zwraca 10% pensji. 
     * Stwórz obiekty z każdym z traitów, pokaż jak podatek działa dla każdego z nich. 
     * Stwórz obiekty z traitami Student i Pracownik, pokaż jak podatek zadziała w zależności od kolejności 
     * w jakiej te traity zostały dodane przy tworzeniu obiektu. 
     */
    
    case class Osoba_(val imie: String, val nazwisko: String) {
      val podatek = 0
      }
    
    trait Student extends Osoba_ {
      override val podatek: Int = 0
      }
    
    trait Nauczyciel extends Pracownik {
      override val podatek: Int = 10
      }
    
    trait Pracownik extends Osoba_ {
      override val podatek: Int = 20
      var pensja: Double = 0
      }

    println( "1. ")
    println(( " dni robocze: ") + (task_1("Poniedziałek")))
    println(( " dni wolne: ") + (task_1("Sobota")))
    println(( " pozostałe: ") + (task_1("Co innego")))
    
    println("2. ")
    println(( " stan konta: ") + (task_2.stanKonta))
    println(( " wpłacona kwota: ") + (task_2.wplata(1200)))
    println(( " stan konta po wyplacie: ") + (task_2.wyplata(1000)))
    
    println("3. ")
    siemka(osoba)
    siemka(person)
    siemka(personne)
    siemka(domyslne)
    
    println("4. ")
    println(( " Wynik: ") + (task_4(number, task_4_)))
    
    println("5. ")

    val osoba_student = new Osoba_("Student", "PJATK") with Student
    println(s" Podatek studenta: ${osoba_student.podatek}%")

    val osoba_pracownik = new Osoba_("Pracownik", "Banku") with Pracownik
    println(s" Podatek pracownika ${osoba_pracownik.podatek}%")

    val osoba_nauczyciel = new Osoba_("Nauczyciel", "Liceum") with Nauczyciel
    println(s" Podatek nauczyciela ${osoba_nauczyciel.podatek}%")

    val pracujacy_student = new Osoba_("Student", "Pracujący") with Student with Pracownik
    println(s" Podatek pracujuncęgo studenta ${pracujacy_student.podatek}%")

    val studiujacy_pracownik = new Osoba_("Pracownik", "Studiujący") with Pracownik with Student
    println(s" Podatek studiującego pracownika ${studiujacy_pracownik.podatek}%")

}