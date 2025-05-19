# Del 5 - Lese og skrive filer (15%)

Relevante nøkkelord:
* InputStream og OutputStream (lese og skrive datastraumar)
* Parsing av kommaseparerte verdiar (CSV) til objekt
* Unntakshandtering (feilhandtering)

## Oppgåve 1 - Eksportere skreddarsydd pc-bygg til fil

ByteBadger ønskjer å kunne eksportere ei liste over datakomponentar for eit pc-bygg i systemet til eit tekstfilformat. Eit døme på ei utdatafil er vedlagt i [output_example.txt](../../../../../resources/output_example.txt).

Implementer klassen [WriteBuildToFile](WriteBuildToFile.java) i samsvar med JavaDoc.

## Oppgåve 2 - Importere datakomponentar frå ein CSV-fil

ByteBadger ønskjer å kunne importere ei liste over datakomponentar frå ein CSV-fil frå deira gamle programvareplattform. Dei treng eit program som kan lese innhaldet i denne CSV-fila og automatisk importere produkta til systemet.

Fila som inneheld datakomponentane finst i [computer_parts.csv](../../../../../resources/computer_parts.csv). Fila vil nokre gonger innehalde feil, og koden din må ta omsyn til dette.

Implementer klassen [ReadPartsFromFile](ReadPartsFromFile.java) i samsvar med JavaDoc. Klassen inneheld to metodar: éin for å lese innhaldet i CSV-fila og ein annan for å analysere innhaldet i ei enkelt linje og opprette eit ComputerPart-objekt ut frå dette.