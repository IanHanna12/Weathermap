## Refaktorisierung des WeatherForecastApp-Codes nach S.O.L.I.D- und Clean-Code Prinzipien

Als Anwendungsentwicler liegt unser Fokus darauf, Softwareentwicklung nicht nur effizient, sondern auch nachhaltig und
wartbar zu gestalten. Die Anwendung der S.O.L.I.D- und Clean-Code-Prinzipien spielt dabei eine entscheidende Rolle.
Diese
Prinzipien helfen uns, Code zu schreiben, der leicht zu verstehen, zu erweitern und zu warten ist. Im Folgenden werden
wir uns auf die Refaktorisierung eines bestehenden Java-Codes konzentrieren, um diese Prinzipien praktisch anzuwenden
und die Vorteile einer sauberen und soliden Codebasis zu demonstrieren.

> Nicht immer ist es möglich bzw. sinnvoll alle Prinzipien von S.O.L.I.D und Clean-Code umzusetzen. Setze nie
> irgendwelche Prinzipien oder Patterns nur zum Selbstzweck um.

- **SOLID-Prinzipien**
    - **Single Responsibility Principle (SRP):** Teile `WeatherForecastApp` in kleinere Klassen auf, sodass jede Klasse
      eine einzige Aufgabe erfüllt. Zum Beispiel könnten separate Klassen für die Handhabung von HTTP-Anfragen, die
      Verarbeitung der Wetterdaten und die Benutzeroberfläche (CLI) erstellt werden.

    - **Open/Closed Principle (OCP):** Stelle sicher, dass die neuen Klassen für Erweiterungen offen, aber für
      Modifikationen geschlossen sind. Beispielsweise könnten Methoden zur Abfrage des Wetters oder zur Formatierung der
      Ausgabe so gestaltet werden, dass sie leicht erweitert werden können, ohne bestehenden Code zu ändern.

    - **Liskov Substitution Principle (LSP):** Wenn du abstrakte Klassen oder Interfaces einführst, stelle sicher, dass
      die
      abgeleiteten Klassen alle Eigenschaften und Verhalten ihrer Basisklassen oder Interfaces erfüllen, ohne deren
      Funktionalität zu beeinträchtigen.

    - **Interface Segregation Principle (ISP):** Vermeide "fette" Interfaces. Wenn du Interfaces verwendest, stelle
      sicher,
      dass diese spezifisch und fokussiert auf eine bestimmte Funktionalität sind, sodass die implementierenden Klassen
      nicht unnötige Methoden implementieren müssen.

    - **Dependency Inversion Principle (DIP):** Abhängigkeiten sollten abstrakt sein, nicht konkret. Das bedeutet, dass
      höherstufige Module nicht direkt von niedrigerstufigen Modulen abhängen sollten. Beispielsweise könnte die
      Hauptanwendungsklasse von abstrakten Interfaces für Wetterdaten-Abfragen und Ausgabeformate abhängen, anstatt von
      konkreten Implementierungen.

- **Clean Code:**
    - **Klare Namensgebung:** Überprüfe alle Variablen-, Methoden- und Klassennamen, um sicherzustellen, dass sie
      aussagekräftig und konsistent sind.
    - **Methoden-Refaktorisierung:** Zerlege lange Methoden in kleinere, wiederverwendbare Methoden, um die Lesbarkeit
      und Wartbarkeit zu verbessern.
    - **Fehlerbehandlung:** Überarbeite das Fehlerhandling, um es konsistent und aussagekräftig zu gestalten, anstatt
      generische Meldungen auszugeben.
    - **Code-Duplikation:** Eliminiere jegliche Duplikate im Code, um die Wartbarkeit zu erhöhen.
    - **Kommentare und Dokumentation:** Füge nötige Kommentare hinzu und aktualisiere sie, um den Zweck und die
      Funktionsweise des Codes klarzustellen. Habe immer im Hinterkopf, dass eine klare Namensgebung, besser als jeder
      Kommentar sein kann.

- **Einrichtung von Unit-Tests:** Um JUnit Tests für die WeatherForecastApp Code zu erstellen, müssen wir
  zuerst einige Änderungen am Code vornehmen, um ihn testbar zu machen. Der aktuelle Code ist stark gekoppelt und schwer
  bis gar nicht zu testen, da er direkte Abhängigkeiten zu externen Diensten (wie dem HTTP-Client und dem
  Wetter-Service) und zur Systemkonsole hat. Schreibe Unit-Tests für alle neuen Klassen und Methoden, um die
  Zuverlässigkeit und Stabilität des Codes sicherzustellen.

> Durch diese Aufteilung und Fokussierung wird der Code modularer, wartbarer und erweiterbarer, was im Einklang mit den
> S.O.L.I.D-Prinzipien und den Best Practices des Clean Codes steht.
