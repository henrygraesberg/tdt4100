# Innkapsling - Card-oppgave

Denne oppgaven handler om to klasser for kortspill: `Card` (kort) og `CardDeck` (kortstokk), der den siste inneholder ett eller flere `Card`-objekter.

I mange sammenhenger vil objekter av en klasse inneholde eller "eie" objekter av andre klasser. Når en klasse er assosiert med én instans av en (annen) klasse er dette en [1-1-assosiasjon](https://www.ntnu.no/wiki/display/tdt4100/Koding+av+1-1-assosiasjoner) og når en klasse er assosiert med flere instanser av en annen klasse er dette en [1-n-assosiasjon](https://www.ntnu.no/wiki/display/tdt4100/Koding+av+1-n-assosiasjoner). I denne oppgaven skal du implementere logikk for en kortstokk som inneholder kort. Nedenfor beskrives begge klassene og metodene disse skal inneholde.

## Card

Oppgavebeskrivelsen for denne deloppgaven er annerledes enn oppgavene dere har møtt tidligere. Istedenfor å få gitt oppgavene her i `README`-en, skal dere lese og forstå den såkalte Javadoc-dokumentasjonen som er skrevet i koden. Javadoc er en måte å skrive dokumentasjon på i Java, og er en standard måte å skrive dokumentasjon på i Java-verdenen. Dette er ofte slik oppgavene blir gitt på eksamen, så det er viktig å kunne lese og forstå Javadoc-dokumentasjonen. Her gjelder det å lese beskrivelsen nøye, og det er ofte fordelaktig å lese testkoden for å forstå hva som forventes av klassen.

> Tips: Hold musen over metoden/klassen for å lese Javadoc-dokumentasjonen på et fint format.

Den påbegynte koden for `Card`-klassen finner du i [oving3/Card.java](../../src/main/java/oving3/Card.java).

## CardDeck

Denne klassen må dere lage selv slik som på tidligere øvinger. `CardDeck`-objekter inneholder initielt et visst antall kort av de fire kortfargene `'S'`, `'H'`, `'D'` og `'C'`. Klassen inneholder standardmetoder for å lese hvor mange og hvilke kort, og en metode for å endre tilstand.

Konstruktør:

- `CardDeck(int n)` - fyller kortstokken med de `n` første kortene av hver kortfarge, totalt `n*4` kort, med spar $1$ som første kort, spar $2$ som andre, spar $3$ som tredje, spar $4$ som fjerde, ..., hjerter $1$ som fjortende, hjerter $2$ som femtende, osv. Med andre ord, først alle spar, så hjerter, så ruter og så kløver, alle i stigende rekkefølge.

Lesemetoder:

- `int getCardCount()` - returnerer hvor mange Card-objekter som `CardDeck`-objektet inneholder.
- `Card getCard(int n)` - returnerer kort nr. `n` eller utløser et `IllegalArgumentException` hvis `n` ikke er gyldig. Kort nr. $0$ er det første kortet i kortstokken.

Endringsmetode:

- `void shufflePerfectly()` - stokker kortstokken ved å dele den i to like store deler og flette de to delene perfekt, slik at kortet på toppen forblir på toppen og kortet på bunnen forblir på bunnen (se [http://en.wikipedia.org/wiki/Out_shuffle](http://en.wikipedia.org/wiki/Out_shuffle)).

## Oppgave: Java-kode

Skriv `Card`- og `CardDeck`-klassene, slik at de har ønsket oppførsel og er skikkelig innkapslet. Det kan være lurt å skrive og teste `Card`-klassen først.

Testkode for denne oppgaven finner du i [oving3/CardDeckTest.java](../../src/test/java/oving3/CardDeckTest.java) og [oving3/CardTest.java](../../src/test/java/oving3/CardTest.java).
