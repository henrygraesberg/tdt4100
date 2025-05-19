# Del 4 - Arv (15%)

JavaDoc-en i klassane nedanfor inneheld detaljar for å forstå krava til denne oppgåva og fullføre implementeringa av begge klassane.

Relevante nøkkelord:
* Superklassar og subklassar
* Hierarki

## Oppgåve - Eit strukturert hierarki med datamaskindelar 

Datamaskindelane er organiserte i kategoriar i eit hierarki (for eksempel er 'Keyboard'-kategorien innanfor 'Input devices'-kategorien, som igjen er innanfor 'All parts'-kategorien). For å illustrere, når ein navigerer i delekatalogen, bør kategoriane vere organiserte i ein struktur som dette, der alle kategoriar er underkategoriar (på ein eller annan måte) av éin enkelt overordna kategori:

```plaintext

- All parts
    - Input devices
        - Keyboard
        - Mouse
        - Scanner
        - Game controller
    - Processing unit
        - CPU
        - Motherboard
    - Storage devices
        - Hard disk drive
        - Solid state drive
        - RAM
    - Output devices
        - Monitor
        - Printer
        - Speakers
    - Power and cooling
        - PSU
        - Cooling fans
    ...

```

For eksempel i dette hierarkiet er "Processing unit" forelder til både "CPU" og "Motherboard". Vidare er både "All parts" og "Input devices" forfedrar til "Keyboard" og "Mouse", sidan dei er forelder til deira forelder, og så vidare.

Implementer denne typen kategori-hierarki gjennom klassen [PartCategory.java](PartCategory.java) i samsvar med JavaDoc.

## Einingstestar

Eit komplett sett med einingstestar er tilgjengeleg for å støtte deg i denne delen.

* [Testar for PartCategory](../../../../../../test/java/com/bytebadger/assembly/part4/PartCategoryTest.java)