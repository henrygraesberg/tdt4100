# Øving 2 teorispørsmål

## Hva er en **synlighetsmodifikator**
En synlighetsmodifikator er et nøkkelord som beskriver om funksjoner, variabler, osv. skal være synlige til andre klasser.  
I java er synlighetsmodifikatorene [default], private, public og protected

## Forkjellen mellom **private** og **public**
- **private** gjør at variablen/funksjonen bare er synlig og modifiserbar i klassen. Dette brukes vanligvis med variabler, slik at andre klasser ikke kan endre verdien i variablen uten å gå gjennom verifikasjon i settere, som kan føre til unntak i andre funksjoner, som f.eks. å sette en int til et negativt tall, når det i setteren verifiseres at det ikke kan være negativt. Private brukes også for funksjoner som bare brukes innad i klassen, som f.eks. validateSSN-metoden i Person klassen jeg har skrevet.
- **public** gjør at variablen/funksjonen er synlig for alle klasser som bruker klassen. Public brukes vanligis med funksjoner som kan brukes av andre klasser, slik som f.eks. gettere og settere.