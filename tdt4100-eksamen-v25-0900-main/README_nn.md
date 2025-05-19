# TDT4100 Javaeksamen vår 2025 - eksamen 1 (0900)

* Les NØYE gjennom dette dokumentet, README for kvar oppgåve og JavaDoc i den medfølgjande koden.

Eksamen består av 6 delar:
* Del 1 består av eit sett med fleirvalsspørsmål. Dette utgjer 20 % av total poengsum.
* Del 2 består av eit sett med kodeoppgåver. Dette utgjer 20 % av total poengsum.
* Del 3-6 har ein felles kontekstbeskriving der oppgåva di er å bidra til ein gitt kodebase. Dette utgjer 60 % av total poengsum.

## DEL 1-2 (40%)

* [Del 1](src/main/java/com/bytebadger/assembly/part1/README_nn.md) (20%)
* [Del 2](src/main/java/com/bytebadger/assembly/part2/README_nn.md) (20%)

## DEL 3-6 (60%)

ByteBadger er eit selskap som spesialiserer seg på skreddarsydde PC-bygg for privatkundar.

Ein skreddarsydd datamaskin blir sett saman av individuelt valde komponentar i staden for å kjøpe eit ferdigbygd system frå produsenten. Dette gir kundane moglegheit til å tilpasse maskinvara etter sine spesifikke behov. Ein kan velje delar basert på ytelse, estetikk, budsjett og moglegheit for oppgraderingar.

ByteBadger utviklar ny programvare som blir brukt i monteringsprosessen for skreddarsydde PC-bygg. Programvaren er skriven i Java. Oppgåva di er å bidra til å utvikle delar av koden.

Oppgåvene dine er organiserte som følgjer:

* [Del 3](src/main/java/com/bytebadger/assembly/part3/README_nn.md) (15%) - I denne oppgåva skal du implementere klassar basert på grensesnitt.
* [Del 4](src/main/java/com/bytebadger/assembly/part4/README_nn.md) (15%) - I denne oppgåva skal du implementere metodar for å jobbe med ein hierarkisk struktur.
* [Del 5](src/main/java/com/bytebadger/assembly/part5/README_nn.md) (15%) - I denne delen skal du implementere metodar for å lese og skrive filer.
* [Del 6](src/main/java/com/bytebadger/assembly/part2/README_nn.md) (15%) - I denne delen skal du implementere metodar som bruker observatør/observert-mønsteret.

## Viktige merknader

1. Koden for alle delane ligg i [src/main/java/com/bytebadger/assembly](src/main/java/com/bytebadger/assembly/)

2. IKKJE MODIFISER KODEN i [src/main/java/no/ntnu/tdt4100/](src/main/java/no/ntnu/tdt4100/).

3. Det er _nokre_ testar tilgjengelege. Dersom desse testane er grønne, indikerer det at implementeringa di er korrekt. Testane er tilgjengelege i mappa [test/java/com/bytebadger/assembly](./src/test/java/com/bytebadger/assembly/).

4. Hugs at du har tilgang til [Javadokumentasjonen](https://eksamensvedlegg.it.ntnu.no/Felles/jdk-21.0.2_doc-all/api/index.html).

Du kan køyre testane på følgjande måtar:

* Du kan opne ein testklasse og køyre testen med den grøne avspelingsknappen på venstre side av testen. Pilen (eller det raude symbolet for at testen 'feilar') ved linja for klassedefinisjonen køyrer _alle_ testane i klassen. Du kan også køyre ein spesifikk testmetode ved å klikke på denne.

* Du kan også legge til eit ‘breakpoint’ i testklassen eller andre klassar som blir brukt, og debugge testen. Dette gjer det mogleg å trinnvis gå gjennom koden. Du vel debug ved å høgreklikke på symbolet til venstre for linja ved metodestart.

* Når du køyrer testane _før_ du har implementert noko for ein del, vil du oppdage at nokre av testane er grønne. Dette er riktig oppførsel. Sørg for at alle testane også er grønne etter at du har implementert kode.

Kvar oppgåve i eksamen er merka med ein // TODO-kommentar. Du kan få ein oversikt over alle TODOs i Problems-fanen som ligg i nedre del av redigeringsvindauget i VS Code. Du finn den også i toppmenyen under View -> Problems.

Når JavaDoc eksplisitt spesifiserer eit klasse- eller metodenamn (med JavaDoc her meiner vi kommentarane som ligg før ein klasse eller metodes definisjon), må du bruke namnet nøyaktig som definert i JavaDoc, dvs. når JavaDoc spesifiserer at klassen skal heite `ComputerPart`, skal den ikkje heite `computerPart`, `computerpart` eller `COMPUTERPART`.

I oppgåver der unntak skal utløysast, treng du ikkje bruke tid på å spesifisere ei melding.

Dersom du ikkje klarer å implementere ein metode i éin klasse, kan du sjølvsagt bruke denne vidare som om den virka. Merk at metoden bør framleis kompilere, alle metodar kompilerer ved hjelp av _dummy_ returverdiar, som er verdiar av riktig type, men ikkje korrekte. Metodar med feil vil ikkje vere synlege som mogleg metodar å bruke i VS Code, og dermed gi raud strek.

Ein metode som ikkje kompilerer vil kunne gi null poeng.

Feil i koden din, som NullPointerException, er ikkje kompileringsproblem (men vil sjølvsagt ikkje gi full poengsum). Du bør teste koden din slik at du veit at den køyrer. Vi anbefaler at du bruker testane som er lagt ved. Du kan også kopiere ein test over til eit nytt testnamn og legge til eventuelle ytterlegare metodekall du ønskjer å teste.

# Kompilering

**Det skal ikkje vere nokre kompileringsfeil når du sender inn arbeidet ditt. Metodar som ikkje kompilerer, vil kunne telle 0 poeng.**

Sørg for at koden kompilerer før du sender den inn. I ein terminal, på stien som inneheld `pom.xml`, kan du utføre følgjande kommando:

```bash
mvn clean compile
```

## Etter at zip-fila er pakka ut

Etter at du har lasta ned zip-fil, så unzip denne. Dette gir ei mappe som heiter **ord2025-0900**.

### For Visual Studio Code

Gå så inn i VSCode, og gå til File -> Open Folder. Eit filnavigeringsvindauge opnast. Finn fram til mappa du unzippa (**ord2025-0900**), og vel denne. VSCode vil då, pga. POM-fila som ligg i mappa, automatisk finne ut at dette er eit Maven Java-prosjekt. (Under føresetnad at Java-utvidinga er installert i VSCode.)

## Spesialteikn i Windows: teikn som alfakrøll, [], {}, |

I Windows legg ein inn desse på ein litt annan måte enn i OS X! Alle kan sjåast på tastaturet, dersom teiknet står nederst til høgre på tasten får ein det gjennom å halde inne alt-gr (tasten til høgre for mellomrom) samtidig med tasten med teiknet.

* | er øvst til venstre
* @ er alt-gr og 2
* [,] er alt-gr  og 8,9
* {,} er alt-gr og 7, 0

## Snarvegar i VS Code

* Sjå tastatursnarvegar: ctrl-shift-p - skriv inn keyboard - Open Keyboard Shortcuts
* Gå til førre stad du var i koden: alt-venstrepil - alt-høgrepil for framover. Som nettlesar!
* Klikk på eit metodenamn, trykk på F12 og då hoppar du inn i koden for denne metoden.

## Levering

**Sørg for å lagre alle filene i VS Code før du zippar mappa.** Du kan gjere det via menyvalet File -> Save All

Når eksamen skal leverast kan du gjere dette på denne måten: Kortform: Den same mappa som du pakka ut, den skal du pakke inn i .zip-format.

* Dersom du ikkje har ei utforskarmeny til venstre: høgreklikk på ikonet for 'Explorer' øvst til venstre (to papirark oppå kvarandre)
* Klikk i eit tomt område i VSCode sin 'Explorer' (der alle filene til prosjektet ligg) eller høgreklikk på README.md-fila.
* Vel 'Reveal in File Explorer' (Windows)
* Du skal no få opp eit utforskingsvindauge (i Windows) som skal innehalde den mappa du pakka ut. Denne mappa inneheld prosjektmappa vi skal komprimere.
* Høgreklikk på denne mappa -> 7-zip -> Add to "ord2025.zip"
* Denne zipfila er fila de skal laste opp til Inspera til slutt.
* De finn eit par bilete av prosessen til slutt i denne fila (med feil årstal)

**Visual Studio Code Explorer**

<img src="VSCode_Explorer.png" alt="drawing" width="600">

**Compress**

<img src="Compress.png" alt="drawing" width="600"/>