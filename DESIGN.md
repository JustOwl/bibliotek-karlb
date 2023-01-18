## Krav för Godkänt

Det finns minst 3 typer av verk (ex bok, cd-skiva, film, spel) som kan sparas i biblioteket, och de har vissa gemensamma attribut (ex id, titel, inköpspris) och vissa olika attribut (ex sidantal, speltid).

- Varje typ är en klass med vissa unika värden, t.ex:

- Bok: sidantal
- Musik: minuter (längd)
- Spel: Hur lång tid att spela ut

- De ärver från en "huvudklass" med delade värden, t.ex:

- id (kanske bör vara unikt och läggs till i koden)
- titel
- utgivningsår

- De hör alla till en interface för att kunna lättare hanteras i katalogen.

Man kan registrera nya verk som läggs in i bibliotekets katalog. Den frågar efter olika attribut beroende på vilken typ av verk.

- Input validering behövs för detta, behöver vara större än 0 (även strings) och inte Null

Man kan lista alla verk som finns i katalogen för varje verk visas summerad information om det

- Kanske sparar verk i separata listor som sedan kan kallas på som en helhet senare istället för en gigantisk lista.

Man kan spara ner och ladda in bibliotekets katalog från en fil eller databas

- Likt punkten ovan. Utforksa hur CSV funkar i Java, känns som det lättaste formatet för detta