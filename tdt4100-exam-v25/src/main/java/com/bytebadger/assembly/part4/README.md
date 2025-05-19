# Del 4 - Arv (15%)

JavaDoc-en i klassene nedenfor inneholder detaljer for å forstå kravene til denne oppgaven og fullføre implementeringen av begge klassene.

Relevante nøkkelord:
* Superklasser og subklasser
* Hierarki

## Oppgave - Et strukturert hierarki med datamaskindeler 

Datamaskindelene er organisert i kategorier i et hierarki (for eksempel er 'Keyboard'-kategorien innenfor 'Input devices'-kategorien, som igjen er innenfor 'All parts'-kategorien). For å illustrere, når man navigerer i delekatalogen, bør kategoriene være organisert i en struktur som dette, der alle kategorier er underkategorier (på en eller annen måte) av én enkelt overordnet kategori:

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

For eksempel i dette hierarkiet er "Processing unit" forelder til både "CPU" og "Motherboard". Videre er både "All parts" og "Input devices" forfedre til "Keyboard" og "Mouse", siden de er forelder til deres forelder, og så videre.

Implementer denne typen kategori-hierarki gjennom klassen [PartCategory.java](PartCategory.java) i henhold til JavaDoc.

## Enhetstester

Et komplett sett med enhetstester er tilgjengelig for å støtte deg i denne delen.

* [Tester for PartCategory](../../../../../../test/java/com/bytebadger/assembly/part4/PartCategoryTest.java)