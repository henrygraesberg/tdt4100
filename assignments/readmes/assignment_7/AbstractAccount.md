# Arv - AbstractAccount-oppgave

Denne oppgaven handler om å lage en felles abstrakt superklasse `AbstractAccount` for `CreditAccount`, `DebitAccount`- og `SavingsAccount2`-klassene.

Denne oppgaven er en annen variant av [SavingsAccount](./SavingsAccount.md)-oppgaven, med fokus på bruk av abstrakte klasser og arv.

Denne oppgaven er på likt format som dere møtte i [Øving 3 - Card-oppgaven](../oving3/Card.md), der det ikke blir oppgitt en detaljert beskrivelse av klassene her i `README`-filen, men heller gjennom Javadoc-dokumentasjonen. Dette er igjen for å gi dere øving i å lese og forstå dokumentasjon, som er et vanlig format å bli gitt oppgaver på eksamen.

> Kjapt tips: Hold musen over metoden/klassen for å lese Javadoc-dokumentasjonen på et fint format.

Filene i denne oppgaven skal legges i [oving7/abstractaccount](../../src/main/java/oving7/abstractaccount).

## Del 1 - Abstrakt klasse AbstractAccount

En bank består av mange ulike type kontoer: sparekontoer, brukskontoer, depositumskontoer, støttekontoer, osv. Siden disse har mye felles, f.eks. har alle en balanse, så er det praktisk å samle så mye som mulig av den felles logikken i en superklasse, som alle kan arve fra. Denne superklassen er imidlertid ikke noen egen type konto, og derfor gjør vi den abstrakt, slik at den ikke kan instansieres. De konkrete konto-klassene som arver fra den, må selvsagt være instansierbare.

Vær oppmerksom på at du fra og med [del 2](#del-2---debitaccount-extends-abstractaccount) skal lage subklasser av `AbstractAccount` og at du ved å bruke rett innkapsling (hint: `protected`-modifikatoren) skal la *subklassene* nyttiggjøre seg *superklassen* i størst mulig grad.

Skjelletet til `AbstractAccount`-klassen finner du i [oving7/abstractaccount/AbstractAccount.java](../../src/main/java/oving7/abstractaccount/AbstractAccount.java).

Det er ingen spesifikke tester for denne klassen, siden abstrakte klasser ikke kan instansieres.

## Del 2 - DebitAccount extends AbstractAccount

Skjelettet til `DebitAccount`-klassen finner du i [oving7/abstractaccount/DebitAccount.java](../../src/main/java/oving7/abstractaccount/DebitAccount.java).

Testkode for oppgavene finner du her: [oving7/abstractaccount/DebitAccountTest.java](../../src/test/java/oving7/abstractaccount/DebitAccountTest.java).

## Del 3 - CreditAccount extends AbstractAccount

Skjelettet til `CreditAccount`-klassen finner du i [oving7/abstractaccount/CreditAccount.java](../../src/main/java/oving7/abstractaccount/CreditAccount.java).

Testkode for oppgavene finner du her: [oving7/abstractaccount/CreditAccountTest.java](../../src/test/java/oving7/abstractaccount/CreditAccountTest.java).

## Del 4 - SavingsAccount extends AbstractAccount

> Merk at denne klassen har samme navn som den fra [SavingsAccount-oppgaven](./SavingsAccount.md), men at dette er uproblematisk siden de befinner seg i forskjellige mapper.

Skjelettet til `SavingsAccount`-klassen finner du i [oving7/abstractaccount/SavingsAccount.java](../../src/main/java/oving7/abstractaccount/SavingsAccount.java).

Testkode for oppgavene finner du her: [oving7/abstractaccount/SavingsAccountTest.java](../../src/test/java/oving7/abstractaccount/SavingsAccountTest.java).
