# PasswortGenerator
Passwort Generator in Java mit einem Gui (Java Swing)

SDK: Oracle OpenJDK version 19.0.1

Ausführung (ohne Code compilieren zu müssen):
Den "out/production/PasswortGenerator" Ordner in ein beliebiges Verzeichnis kopieren/ziehen. 
Dann mit der Windows Powershell zu diesem Verzeichnis navigieren und dann mit "java Main" ausführen.

----

Ausführung (Code muss compiliert werden, da es sich hier um .java Dateien handelt. -> Änderungen können vorgenommen werden):
Das Projekt downloaden und die "Main.java" ausführen. Dabei müssen die beiden anderen Dateien "CreatePassword.java" und "MainFrame.java" im gleichen Ordner liegen.

----

Anmerkung: 
Das Projekt ist noch nicht fertig und wird in den nächsten Wochen immer wieder verbessert. Dabei verändert sich allerdings erstmal nur das Optische, sodass die Grundfunktionen jetzt bereits fertig vorhanden sind. 
Wenn man den individuellen Modus auswählt, kann man die Anzahl an Kleinbuchstaben, Großbuchstaben, Zahlen und Sonderzeichen einstellen. Allerdings handelt es sich hier um eine "mindestens" Angabe. Also wenn man bei "Anzahl Kleinbuchstaben" die Zahl "2" einträgt, so erhält das zu generierende Passwort mindestens 2 Kleinbuchstaben. 
Falls man nicht die gesamte Länge des Passworts mit der Eingabe abdeckt, so werden die freien Stellen zufällig aus allen möglichen Bereichen (Kleinbuchstaben, Großbuchstaben, Zahlen und Sonderzeichen) zusammen gewählt.
Falls nichts eingegeben wird in die Textfelder, wird automatisch der Wert 0 angenommen.
Falls keine gewünschten Eingaben getätigt werden, wird eine Fehlermeldung auf dem Gui gezeigt, welche eine bessere Ausführung aufzeigt.

