# Del 5 - Lese og skrive filer (15%)

Relevante nøkkelord:
* InputStream og OutputStream (lese og skrive datastrømmer)
* Parsing av kommaseparerte verdier (CSV) til objekter
* Unntakshåndtering (feilhåndtering)

## Oppgave 1 - Eksportere skreddersydd pc-bygg til fil

ByteBadger ønsker å kunne eksportere en liste over datakomponenter for et pc-bygg i systemet til et tekstfilformat. Et eksempel på utdatafil er vedlagt i [output_example.txt](../../../../../resources/output_example.txt)

Implementer klassen [WriteBuildToFile](WriteBuildToFile.java) i henhold til JavaDoc.

## Task 2 - Importere datakomponenter fra en CSV-fil

ByteBadger ønsker å kunne importere en liste over datakomponenter fra en CSV-fil fra deres gamle programvareplattform. De trenger et program som kan lese innholdet i denne CSV-filen og automatisk importere produktene til systemet.

Filen som inneholder datakomponentene finnes i [computer_parts.csv](../../../../../resources/computer_parts.csv). Filen vil noen ganger inneholde feil, og koden din må ta hensyn til dette.

Implementer klassen [ReadPartsFromFile](ReadPartsFromFile.java) i henhold til JavaDoc. Klassen inneholder to metoder: én for å lese innholdet i CSV-filen og en annen for å analysere innholdet i en enkelt linje og opprette et ComputerPart-objekt ut fra dette.