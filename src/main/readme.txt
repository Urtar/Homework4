
Stwórz projekt Homework_04. Rozwiązania zadań powinny znajdować się w tym projekcie.

Zadanie 1

W projekcie stwórz stronę jsp index1.jsp. Następnie:

Pobierz wartość parametru GET o nazwie author.
Sprawdź czy parametr istnieje oraz czy nie jest pusty.
Wyświetl informacje w postaci:
<p>Wybrany autor <Pobrana wartość></p>

Zadanie 2

W projekcie stwórz stronę jsp index2.jsp. Za pomocą pętli forEach wyświetl na stronie liczby w taki sposób by uzyskać poniższy wynik. Wykorzystaj dodatkowe atrybuty pętli begin oraz step.

2
4
6
8
10
Zadanie 3

W projekcie stwórz stronę jsp index3.jsp. Następnie:

Za pomocą odpowiedniej funkcji jstl sprawdź czy ustawiony za pomocą poniższego tagu ciąg znaków zawiera napis coderslab:
<c:set var="someName" value="Witaj w coderslab."/>
Jeżeli napis zawiera coderslab w instrukcji sterującej wypisz na stronie <p>OK</p>.
Zadanie 4

W projekcie stwórz servlet Servlet_01_1 oraz Servlet_01_2. Następnie:

Na pierwszej stronie (Servlet_01_1) stwórz formularz z elementem select oraz opcjami wyboru zgodnymi z kluczami poniższej mapy:
Map<String, String> lang = new  HashMap<>();
lang.put("en", "Hello");
lang.put("pl", "Cześć");
lang.put("de", "Ehre");
lang.put("es", "Hola");
lang.put("fr", "Bienvenue");
Strona ma przesyłać dane za pomocą POST do drugiej strony (Servlet_01_2), która ma ustawić ciasteczko language na wartość wybraną przez użytkownika.
Po ponownym wejściu na pierwszą powinna być wyświetlana informacja powitalna w wybranym przez użytkownika języku.
Gdy ciasteczko nie istnieje, wiadomość powitalna powinna być wyświetlana w języku polskim.
Hint: Odpowiednie dane przekaż i przetwórz w pliku widoku.

Zadanie 5

Zapoznaj się z wzorcem DAO - [Wikipedia] dao-wiki.

Jest to wzorzec podobny do znanego już nam ActiveRecords z tą różnicą, że wszystkie metody związane z operacjami na obiekcie są wydzielone do oddzielnej klasy np. ProductDao.

Klasy DAO powinny implementować przynajmniej zestaw operacji CRUD.

Skrót ten oznacza:

Create
Read
Update
Delete
W projekcie stwórz servlet, a w nim servlet Servlet_02 z obsługą metod doGet i doPost. Celem zadania jest stworzenie formularza do zamawiania biletu lotniczego. W tym celu:

Stwórz klasę Airport z następującymi polami:
Nazwa name.
Kod code.
Strefa czasową timezone.
Stwórz klasę AirportDao - a w niej metodę o sygnaturze List <Airport> getList()- metoda wczyta z pliku airports.txt dane w postaci CSV, utworzy na ich podstawie obiekty klasy Airport, które następnie doda do ArrayListy.
Stwórz, w pliku jsp, formularz, który przesyła dane metodą POST. Formularz powinien zawierać:
Lotnisko wylotu - pole select (dane pobrane przez dao).
Lotnisko przylotu - pole select(dane pobrane przez dao).
Czas startu - pole datetime-local (będzie to czas wylotu w czasie lokalnym lotniska).
Długość lotu w godzinach - pole number min="0", step="1".
Cenę lotu - pole number min="0", step="0.01".
Dodaj obsługę tego formularza w metodzie doPost. Obsługa powinna polegać tylko na wyświetleniu przesłanych danych.
Hint: Pamiętaj żeby dane z DAO pobierać tylko raz!. Każdy odczyt z pliku (a potem z bazy danych) może długo trwać.

Zadanie 6

Celem zadania jest obsługa i przetworzenie danych pobranych z formularza, który zrobiliśmy w poprzednim zadaniu. W tym celu zmodyfikuj metodę doPost servletu z poprzedniego pytania w następujący sposób:

Sprawdź czy użytkownik nie wybrał takiego samego lotniska wylotu i przylotu.

Sprawdź czy data i czas lotu zostały podane.

Sprawdź czy cena lotu jest większa od 0.

Pobierz strefę czasową lotniska wylotu i zapisz ją do zmiennej.

Pobierz strefę czasową lotniska przylotu i zapisz ją do zmiennej.

Stwórz obiekt z datą lotniska wylotu w jego strefie czasowej i zapisz czas do zmiennej

Dodaj do daty czas lotu i zmień strefę czasową na lotnisko przylotu i zapisz czas do zmiennej.

Stwórz klasę Flight z następującymi polami:

Lotnisko wylotu departure.
Lotnisko przylotu arrival.
Czas przylotu arrivalTime
Cena lotu price
Utwórz obiekt klasy z odpowiednimi danymi.

Hint: Żeby poprawnie pracować z strefami czasowymi skorzystaj z ZonedDateTime lub joda-time. Tutaj znajdziesz przykłady: przykład1 , przykład2

Zadanie 7

Celem zadania jest wyświetlenie danych przetworzonych w poprzednim zadaniu. W tym celu:

Przekaż do widoku utworzony uprzednio obiekt klasy Flight.
Stwórz w html tabelę zawierającą dane (wygląd tabeli nie ma znaczenia):
lotnisko wylotu z czasem wylotu i kodem lotniska
lotnisko przylotu z czasem przylotu i kodem lotniska
czas lotu
cenę lotu

Zadanie 8

Umieść na stronie dostępnej pod adresem /newsletter dowolny tekst, możesz skorzystać z generatora: lorem-ipsum.
Umieść na stronie formularz z możliwością zapisu użytkownika na newsletter. Formularz musi mieć następujące pola:
email (Adres email),
name (Imię i nazwisko).
Formularz powinien wyświetlać się dla użytkownika raz na 24 godziny - wykorzystaj w tym celu ciasteczka.
Napisz obsługę formularza - dane zapisz do bazy.
Zapytania tworzące tabele w bazie danych umieść w pliku query.sql.
Zadanie 9

Celem zadania jest udostępnienie funkcjonalności księgi gości.

Utwórz servlet wyświetlający listę wpisów z księgi gości. Ma być dostępny pod adresem /guest-book
Wyświetlane mają być wpisy w kolejności od najnowszego do najstarszego.
Informacje o wpisach mają być pobierane z bazy danych.
Zapytania tworzące tabele w bazie danych umieść w pliku query.sql.
Dane dostępowe do bazy danych umieść w parametrach inicjalizacji dla całej aplikacji - sprawdź snippety aby dowiedzieć się jak zapisać i odczytać parametry.
Na stronie nad wpisami umieść formularz umożliwiający dodawanie nowego wpisu (nazwa oraz opis).
Zadanie 10

Utwórz 5 stron, każda ze stron ma posiadać linki nawigacyjne do pozostałych.
Np.:
strona 1 będzie posiadać linki do stron 2,3,4.
strona 2 będzie posiadać linki do stron 1,3,4. itd.
Mają również wyświetlać informacje o aktualnie odwiedzanej stronie w postaci:

Witaj na stronie 1
Strona 4 powinna być dostępna pod adresem /history, ma wyświetlać historię odwiedzanych stron oraz link z możliwością wyczyszczenia historii.
Dane o odwiedzonych stronach przechowuj w sesji.
Przykład wyświetlanej historii:

Odwiedzałeś:
Strona 1
Strona 2
Strona 3
Strona 2
Strona 4